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
import br.facet.tcc.impl.dao.AlunoDaoImpl;
import br.facet.tcc.impl.dao.EnderecoDaoImpl;
import br.facet.tcc.pojo.Aluno;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Service("alunoService")
public class GestaoAlunoImpl extends GestaoUsuarioConfig<Aluno> {

    @Autowired
    public GestaoAlunoImpl(AlunoDaoImpl alunoDao, EnderecoDaoImpl enderecoDao) {
        this.dao = alunoDao;
        this.enderecoDao = enderecoDao;
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#salvarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public Integer salvarUsuario(Aluno t) throws ServiceException {
        try {
            this.enderecoDao.salvar(t.getEndereco());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return super.salvarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#removerUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public void removerUsuario(Aluno t) throws ServiceException {
        super.removerUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#consultarUsuario(java.lang.Class,
     *      java.lang.Integer)
     * @since since optional
     */
    @Override
    public Aluno consultarUsuario(Class clazz, Integer id)
            throws ServiceException {
        return super.consultarUsuario(clazz, id);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#consultarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public List<Aluno> consultarUsuario(Aluno t) throws ServiceException {
        return super.consultarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#alterarUsuario(java.lang.Object)
     * @since since optional
     */
    @Override
    public void alterarUsuario(Aluno t) throws ServiceException {
        super.alterarUsuario(t);
    }

    /**
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#listarUsuario(java.lang.Class)
     * @since since optional
     */
    @Override
    public List<Aluno> listarUsuario(Class clazz) throws ServiceException {
        return super.listarUsuario(clazz);
    }
}
