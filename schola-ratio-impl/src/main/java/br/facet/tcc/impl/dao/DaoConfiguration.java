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
package br.facet.tcc.impl.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * <code>DaoConfiguration</code><br>
 * Define os metodos utiilizados para a configuração das DAOs
 * 
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class DaoConfiguration extends HibernateDaoSupport {

    /**
     * Um tipo de mock para sobescrever o metodo setSessionFactory da classe
     * {@link HibernateDaoSupport}
     * 
     * @param sessionFactory
     *            que sera adicionado ao atributo sessionFactory da classe
     *            {@link HibernateDaoSupport}
     * @since 0.0.1
     */
    @Autowired
    public void addSessionFactoryToDao(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
}
