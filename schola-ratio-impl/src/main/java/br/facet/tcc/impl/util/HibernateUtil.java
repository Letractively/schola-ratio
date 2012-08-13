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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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

        Field[] fields = object.getClass().getDeclaredFields();

        Class[] noparam = {};

        Criteria criteria = session.createCriteria(object.getClass());
        try {
            for (Field field : fields) {
                StringBuffer methodName = new StringBuffer("get");

                methodName
                    .append(field.getName().substring(0, 1).toUpperCase());

                methodName.append(field.getName().substring(1,
                    field.getName().length()));

                Object serializable = object.getClass()
                    .getDeclaredMethod(methodName.toString(), noparam)
                    .invoke(object, noparam);

                if (serializable != null) {
                    if (serializable instanceof String) {
                        criteria.add(Restrictions.ilike(field.getName(), "%"
                            + serializable + "%"));
                    } else {
                        criteria.add(Restrictions.eq(field.getName(),
                            serializable));
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return criteria;
    }
}
