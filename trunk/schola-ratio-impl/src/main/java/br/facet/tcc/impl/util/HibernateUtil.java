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

import java.lang.reflect.Method;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class HibernateUtil {

    public static Criteria createCriteria(Object object, Session session) {

        Method[] methods = object.getClass().getMethods();

        Class[] noparam = {};

        Criteria criteria = session.createCriteria(object.getClass());
        try {
            for (Method method : methods) {

                if (method.getName().startsWith("get")
                    && method.getName() != "getClass") {
                    Object serializable = method.invoke(object, noparam);
                    if (serializable != null) {

                        String field = method.getName().subSequence(3, 4)
                            .toString().toLowerCase()
                            + method.getName().substring(4);

                        if (serializable instanceof String) {
                            criteria.add(Restrictions
                                .ilike(field, serializable));
                        } else {
                            criteria.add(Restrictions.eq(field, serializable));
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return criteria;
    }
}
