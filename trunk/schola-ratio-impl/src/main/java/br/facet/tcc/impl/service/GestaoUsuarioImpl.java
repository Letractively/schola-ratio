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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.EnderecoDaoImpl;
import br.facet.tcc.impl.dao.UsuarioDaoImpl;
import br.facet.tcc.pojo.Usuario;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Service("usurioService")
public class GestaoUsuarioImpl extends GestaoUsuarioConfig<Usuario> {

    @Autowired
    public GestaoUsuarioImpl(UsuarioDaoImpl usuarioDao,
            EnderecoDaoImpl enderecoDao) {
        this.dao = usuarioDao;
        this.enderecoDao = enderecoDao;
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#salvarUsuario(java.lang.Usuario)
     * @since since optional
     */
    @Override
    public Integer salvarUsuario(Usuario t) throws ServiceException {
        try {
            this.enderecoDao.salvar(t.getEndereco());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return super.salvarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#removerUsuario(java.lang.Usuario)
     * @since since optional
     */
    @Override
    public void removerUsuario(Usuario t) throws ServiceException {
        super.removerUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#consultarUsuario(java.lang.Class,
     *      java.lang.Integer)
     * @since since optional
     */
    @Override
    public Usuario consultarUsuario(Class clazz, Integer id)
            throws ServiceException {
        return super.consultarUsuario(clazz, id);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#consultarUsuario(java.lang.Usuario)
     * @since since optional
     */
    @Override
    public List consultarUsuario(Usuario t) throws ServiceException {
        return super.consultarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#alterarUsuario(java.lang.Usuario)
     * @since since optional
     */
    @Override
    public void alterarUsuario(Usuario t) throws ServiceException {
        super.alterarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#listarUsuario(java.lang.Class)
     * @since since optional
     */
    @Override
    public List listarUsuario(Class clazz) throws ServiceException {
        return super.listarUsuario(clazz);
    }

}
