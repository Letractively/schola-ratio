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

import org.springframework.stereotype.Repository;

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.ConfGeralSistema;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Repository("confDao")
public class ConfGeralSistemaDaoImpl extends DaoConfiguration<ConfGeralSistema> {

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvar(ConfGeralSistema t) throws DaoException {
        return super.salvar(t);
    }

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)
     * @since since optional
     */
    @Override
    public void atualizar(ConfGeralSistema t) throws DaoException {
        super.atualizar(t);
    }

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)
     * @since since optional
     */
    @Override
    public void excluir(ConfGeralSistema t) throws DaoException {
        super.excluir(t);
    }

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)
     * @since since optional
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List<ConfGeralSistema> listar(Class clazz) throws DaoException {
        return super.listar(clazz);
    }

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<ConfGeralSistema> pesquisar(ConfGeralSistema t)
            throws DaoException {
        return super.pesquisar(t);
    }

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#obterPorID(java.lang.Class,
     *      java.lang.Integer)
     * @since since optional
     */
    @SuppressWarnings("rawtypes")
    @Override
    public ConfGeralSistema obterPorID(Class clazz, Integer id)
            throws DaoException {
        return super.obterPorID(clazz, id);
    }

}
