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

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.ProfessorDaoImpl;
import br.facet.tcc.pojo.Professor;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Service("professorService")
public class GestaoProfessorImpl extends GestaoUsuarioConfig<Professor> {
    @Autowired
    public GestaoProfessorImpl(ProfessorDaoImpl usuarioDao) {
        this.dao = usuarioDao;
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#salvarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvarUsuario(Professor t) throws ServiceException {
        return super.salvarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#removerUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public void removerUsuario(Professor t) throws ServiceException {
        super.removerUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#consultarUsuario(java.lang.Class,
     *      java.lang.Integer)
     * @since since optional
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Professor consultarUsuario(Class clazz, Integer id)
            throws ServiceException {
        return super.consultarUsuario(clazz, id);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#consultarUsuario(java.lang.Object)
     * @since since optional
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List consultarUsuario(Professor t) throws ServiceException {
        return super.consultarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#alterarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public void alterarUsuario(Professor t) throws ServiceException {
        super.alterarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#listarUsuario(java.lang.Class)
     * @since since optional
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List listarUsuario(Class clazz) throws ServiceException {
        return super.listarUsuario(clazz);
    }
}
