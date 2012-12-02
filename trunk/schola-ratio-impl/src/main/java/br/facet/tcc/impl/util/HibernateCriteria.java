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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
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

    @SuppressWarnings("rawtypes")
    private final Class[] noparam = {};

    private static StringBuilder parentFlag = null;

    /**
     * @since 0.0.1
     */
    public HibernateCriteria(Session session) {
        LOG.debug("Criando uma instancia de " + this.getClass().getName());
        this.session = session;
    }

    @SuppressWarnings("rawtypes")
    public Criteria createCriteria(Object object) {

        Method[] methods = object.getClass().getMethods();

        this.criteria = session.createCriteria(object.getClass(), "F");

        try {
            for (Method method : getSearchables(methods)) {
                Object serializable = method.invoke(object, (Object[]) noparam);
                if (serializable != null) {
                    String field = method.getName().subSequence(3, 4)
                            .toString().toLowerCase()
                            + method.getName().substring(4);
                    if (method.getAnnotation(Searchable.class).innerSearch()) {
                        parentFlag = new StringBuilder(field);
                        this.prepareInnerSearch(serializable, field);
                        if (parentFlag.length() > 0)
                            removeLastField(parentFlag);
                    } else if (serializable instanceof Collection
                            && method.getAnnotation(Searchable.class)
                                    .collectionSearch()) {
                        if (!((Collection) serializable).isEmpty()) {

                            criteria.createCriteria(field)
                                    .add(Restrictions
                                            .in("id",
                                                    prepareCollectionId((Collection) serializable)));
                        }
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
            parentFlag = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        LOG.debug("Criteria criada : " + this.criteria.toString());
        return criteria;
    }

    @SuppressWarnings("rawtypes")
    private List<Integer> prepareCollectionId(Collection serializable)
            throws IllegalArgumentException, SecurityException,
            IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        List<Integer> ids = new ArrayList<Integer>();
        for (Object object : serializable) {
            Integer id = (Integer) object.getClass()
                    .getMethod("getId", noparam)
                    .invoke(object, (Object[]) noparam);
            ids.add(id);
        }

        return ids;
    }

    @SuppressWarnings("rawtypes")
    private void prepareInnerSearch(Object object, String columnName) {
        Method[] methods = object.getClass().getMethods();
        Class[] noparam = {};

        try {
            for (Method method : getInnerSearchables(methods)) {
                Object serializable = method.invoke(object, (Object[]) noparam);
                if (serializable != null) {
                    String field = method.getName().subSequence(3, 4)
                            .toString().toLowerCase()
                            + method.getName().substring(4);
                    if (parentFlag != null) {
                        parentFlag.append(".").append(field);
                    } else {
                        parentFlag = new StringBuilder(field);
                    }
                    this.prepareInnerSearch(serializable, field);
                    if (parentFlag.length() > 0)
                        removeLastField(parentFlag);
                }
            }
            for (Method method : getNonInnerSearchables(methods)) {
                Object serializable = method.invoke(object, (Object[]) noparam);
                if (serializable != null) {
                    String field = method.getName().subSequence(3, 4)
                            .toString().toLowerCase()
                            + method.getName().substring(4);
                    if (serializable instanceof String) {
                        if (parentFlag != null) {
                            parentFlag.append(".").append(field);
                            this.criteria.add(Restrictions.ilike("F."
                                    + parentFlag.toString(), "%" + serializable
                                    + "%"));
                            if (parentFlag.length() > 0)
                                removeLastField(parentFlag);
                        } else {
                            this.criteria.createCriteria(columnName).add(
                                    Restrictions.ilike(field, "%"
                                            + serializable + "%"));
                        }
                    } else {
                        if (parentFlag != null) {
                            parentFlag.append(".").append(field);
                            this.criteria
                                    .add(Restrictions.eq(
                                            "F." + parentFlag.toString(),
                                            serializable));
                            if (parentFlag.length() > 0)
                                removeLastField(parentFlag);
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

    private List<Method> getSearchables(Method[] methods) {
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

    private List<Method> getInnerSearchables(Method[] methods) {
        List<Method> retorno = new ArrayList<Method>();

        for (Method method : methods) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation instanceof Searchable) {
                    if (((Searchable) annotation).innerSearch()) {
                        retorno.add(method);
                    }
                }
            }
        }
        return retorno;
    }

    private List<Method> getNonInnerSearchables(Method[] methods) {
        List<Method> retorno = new ArrayList<Method>();

        for (Method method : methods) {
            for (Annotation annotation : method.getAnnotations()) {
                if (annotation instanceof Searchable) {
                    if (!((Searchable) annotation).innerSearch()) {
                        retorno.add(method);
                    }
                }
            }
        }
        return retorno;
    }

    private StringBuilder removeLastField(StringBuilder builder) {
        int index = builder.lastIndexOf(".");

        if (index != -1) {
            builder.delete(index, builder.length());
        }
        return builder;
    }
}
