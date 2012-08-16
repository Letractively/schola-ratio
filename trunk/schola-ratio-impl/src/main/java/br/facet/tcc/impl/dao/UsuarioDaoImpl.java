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
import br.facet.tcc.pojo.Usuario;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class UsuarioDaoImpl extends DaoConfiguration implements Dao<Usuario> {

    /**
     * @see br.facet.tcc.dao.Dao#salvar(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvar(Usuario t) {

        Integer id = (Integer) getHibernateTemplate().save(t);

        return id;
    }

    /**
     * @see br.facet.tcc.dao.Dao#atualizar(java.lang.Object)
     * @since since optional
     */
    @Override
    public void atualizar(Usuario t) {
        getHibernateTemplate().update(t);
    }

    /**
     * @see br.facet.tcc.dao.Dao#excluir(java.lang.Object)
     * @since since optional
     */
    @Override
    public void excluir(Usuario t) {
        getHibernateTemplate().delete(t);
    }

    /**
     * @see br.facet.tcc.dao.Dao#listar()
     * @since since optional
     */
    @Override
    public List<Usuario> listar() {
        return getHibernateTemplate().find("from Usuario");
    }

    /**
     * @see br.facet.tcc.dao.Dao#pesquisar(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<Usuario> pesquisar(Usuario t) {
        Criteria criteria = HibernateUtil.createCriteria(t, getSession());

        return criteria.list();
    }

}