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

import br.facet.tcc.dao.Dao;
import br.facet.tcc.impl.util.HibernateUtil;
import br.facet.tcc.pojo.Aluno;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class AlunoDaoImpl extends DaoConfiguration implements Dao<Aluno> {

    /**
     * @see br.facet.tcc.dao.Dao#salvar(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvar(Aluno t) {
        Integer codigo = (Integer) getHibernateTemplate().save(t);

        return codigo;
    }

    /**
     * @see br.facet.tcc.dao.Dao#atualizar(java.lang.Object)
     * @since since optional
     */
    @Override
    public void atualizar(Aluno t) {
        getHibernateTemplate().update(t);
    }

    /**
     * @see br.facet.tcc.dao.Dao#excluir(java.lang.Object)
     * @since since optional
     */
    @Override
    public void excluir(Aluno t) {
        getHibernateTemplate().delete(t);
    }

    /**
     * @see br.facet.tcc.dao.Dao#listar()
     * @since since optional
     */
    @Override
    public List<Aluno> listar() {
        return getHibernateTemplate().find("from Aluno");
    }

    /**
     * @see br.facet.tcc.dao.Dao#pesquisar(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<Aluno> pesquisar(Aluno t) {
        Criteria criteria = HibernateUtil.createCriteria(t, getSession());
        return criteria.list();
    }

}
