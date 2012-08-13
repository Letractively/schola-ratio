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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import br.facet.tcc.dao.Dao;
import br.facet.tcc.impl.util.HibernateUtil;
import br.facet.tcc.pojo.Endereco;

/**
 * <code>EnderecoDaoImpl</code><br>
 * 
 * Implementação de uma Dao para a classe {@link Endereco}
 * 
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository("enderecoDao")
public class EnderecoDaoImpl extends DaoConfiguration implements Dao<Endereco> {

    Session session;

    Transaction transaction;

    /**
     * @see br.facet.tcc.dao.Dao#salvar(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvar(Endereco t) {

        Integer id = null;
        try {
            this.session = this.getHibernateTemplate().getSessionFactory()
                .openSession();
            transaction = this.session.beginTransaction();

            id = (Integer) this.getHibernateTemplate().save(t);

            transaction.commit();
        } catch (DataAccessException exception) {
            transaction.rollback();
        } finally {
            this.session.close();
        }
        return id;
    }

    /**
     * @see br.facet.tcc.dao.Dao#atualizar(java.lang.Object)
     * @since since optional
     */
    @Override
    public void atualizar(Endereco t) {
        this.getHibernateTemplate().update(t);
    }

    /**
     * @see br.facet.tcc.dao.Dao#excluir(java.lang.Object)
     * @since since optional
     */
    @Override
    public void excluir(Endereco t) {
        this.getHibernateTemplate().delete(t);
    }

    /**
     * @see br.facet.tcc.dao.Dao#listar()
     * @since since optional
     */
    @Override
    public List<Endereco> listar() {
        return this.getHibernateTemplate().find("from Endereco");
    }

    /**
     * @see br.facet.tcc.dao.Dao#pesquisar(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<Endereco> pesquisar(Endereco t) {
        Criteria criteria = HibernateUtil.createCriteria(t, getSession());
        List enderecos = criteria.list();
        return enderecos;
    }
}
