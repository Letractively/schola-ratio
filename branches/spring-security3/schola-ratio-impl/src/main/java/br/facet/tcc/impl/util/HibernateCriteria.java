/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 * 
 * Copyright (c) 2012 All rights reserved.
 * 
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written
 * 
 * 
 * (Code Template Version: 1.0)
 */
package br.facet.tcc.impl.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.facet.tcc.annotations.Searchable;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class HibernateCriteria {

    private static final Logger LOG = Logger.getLogger(HibernateCriteria.class);

    private final Session session;

    private Criteria criteria;

    /**
     * @since TODO: class_version
     */
    public HibernateCriteria(Session session) {
        LOG.debug("Criando uma instancia de " + this.getClass().getName());
        this.session = session;
    }

    public Criteria createCriteria(Object object) {

        Method[] methods = object.getClass().getMethods();
        Class[] noparam = {};
        this.criteria = session.createCriteria(object.getClass());

        try {
            for (Method method : getSearchbles(methods)) {
                Object serializable = method.invoke(object, noparam);
                if (serializable != null) {
                    String field = method.getName().subSequence(3, 4)
                            .toString().toLowerCase()
                            + method.getName().substring(4);
                    if (method.getAnnotation(Searchable.class).innerSearch()) {
                        this.prepareInnerSearch(serializable, field);
                    } else {
                        if (serializable instanceof String) {
                            criteria.add(Restrictions.ilike(field, "%"
                                    + serializable + "%"));
                        } else {
                            criteria.add(Restrictions.eq(field, serializable));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }

    private void prepareInnerSearch(Object object, String columnName) {
        Method[] methods = object.getClass().getMethods();
        Class[] noparam = {};

        try {
            for (Method method : getSearchbles(methods)) {
                Object serializable = method.invoke(object, noparam);
                if (serializable != null) {
                    String field = method.getName().subSequence(3, 4)
                            .toString().toLowerCase()
                            + method.getName().substring(4);
                    if (method.getAnnotation(Searchable.class).innerSearch()) {
                        this.prepareInnerSearch(serializable, field);
                    } else {
                        if (serializable instanceof String) {
                            this.criteria.createCriteria(columnName).add(
                                    Restrictions.ilike(field, "%"
                                            + serializable + "%"));
                        } else {
                            this.criteria.createCriteria(columnName).add(
                                    Restrictions.eq(field, serializable));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Method> getSearchbles(Method[] methods) {
        List<Method> retorno = new ArrayList<Method>();

        for (Method method : methods) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation instanceof Searchable) {
                    retorno.add(method);
                }
            }
        }
        return retorno;
    }
}
