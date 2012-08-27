/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 *
 * Copyright (c) 2012
 * All rights reserved.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written
 * 
 * 
 * (Code Template Version: 1.0)
 */
package br.facet.tcc.impl.service;

import java.util.List;

import br.facet.tcc.dao.Dao;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.EnderecoDaoImpl;
import br.facet.tcc.service.GestaoUsuario;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public abstract class GestaoUsuarioConfig<T> implements GestaoUsuario<T> {

    protected Dao dao;

    protected EnderecoDaoImpl enderecoDao;

    /**
     * @see br.facet.tcc.service.GestaoUsuario#salvarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvarUsuario(T t) throws ServiceException {
        try {
            return this.dao.salvar(t);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoUsuario#removerUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public void removerUsuario(T t) throws ServiceException {
        try {
            this.dao.excluir(t);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoUsuario#consultarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public T consultarUsuario(Class clazz, Integer id) throws ServiceException {
        try {
            return (T) this.dao.obterPorID(clazz, id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoUsuario#consultarUsuario(java.lang.Integer)
     * @since since optional
     */
    @Override
    public List<T> consultarUsuario(T t) throws ServiceException {
        try {
            return this.dao.pesquisar(t);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoUsuario#alterarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public void alterarUsuario(T t) throws ServiceException {
        try {
            this.dao.atualizar(t);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoUsuario#listarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<T> listarUsuario(Class clazz) throws ServiceException {
        try {
            return this.dao.listar(clazz);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
