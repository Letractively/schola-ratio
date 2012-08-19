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

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.facet.tcc.dao.Dao;
import br.facet.tcc.impl.util.HibernateUtil;

/**
 * <code>DaoConfiguration</code><br>
 * Define os metodos utiilizados para a configuração das DAOs
 * 
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public abstract class DaoConfiguration<T> extends HibernateDaoSupport implements
    Dao<T> {

    /**
     * 
     */
    private static Logger logger = Logger.getLogger(DaoConfiguration.class);

    /**
     * @see br.facet.tcc.dao.Dao#salvar(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvar(T t) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        Integer integer = null;
        try {
            tx = session.beginTransaction();
            integer = (Integer) session.save(t);
            tx.commit();
            logger.debug("Objeto salvo com sucesso em " + t.getClass());
        } catch (HibernateException e) {
            tx.rollback();
            logger.error(t.getClass(), e);
        } finally {
            session.close();
        }
        return integer;
    }

    /**
     * @see br.facet.tcc.dao.Dao#atualizar(java.lang.Object)
     * @since since optional
     */
    @Override
    public void atualizar(T t) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            logger.debug("Objeto atualizado com sucesso em " + t.getClass());
        } catch (HibernateException e) {
            tx.rollback();
            logger.error(t.getClass(), e);
        } finally {
            session.close();
        }
    }

    /**
     * @see br.facet.tcc.dao.Dao#excluir(java.lang.Object)
     * @since since optional
     */
    @Override
    public void excluir(T t) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
            logger.debug("Objeto removido com sucesso em " + t.getClass());
        } catch (HibernateException e) {
            tx.rollback();
            logger.error(t.getClass(), e);
        } finally {
            session.close();
        }
    }

    /**
     * @see br.facet.tcc.dao.Dao#listar()
     * @since since optional
     */
    @Override
    public List<T> listar(Class clazz) {
        return getHibernateTemplate().find("from " + clazz.getSimpleName());
    }

    /**
     * @see br.facet.tcc.dao.Dao#pesquisar(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<T> pesquisar(T t) {
        Criteria criteria = HibernateUtil.createCriteria(t, getSession());
        return criteria.list();
    }

    /**
     * Obtem um objeto apartir do seu id e de seu tipo
     * 
     * @param clazz
     *            define o tipo do objeto a ser recuperado
     * @param id
     *            id do objeto persistido
     * @return o objeto
     * @since 0.0.1
     */
    public T obterPorID(Class clazz, Integer id) {
        return (T) getSession().load(clazz, id);
    }

    /**
     * Usado paa sobscrever o metodo setSessionFactory da classe
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
