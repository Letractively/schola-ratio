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

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.AlunoDaoImpl;
import br.facet.tcc.pojo.Aluno;

/**
 * @author
 * 
 */
@Service("alunoService")
@SuppressWarnings("serial")
public class GestaoAlunoImpl extends GestaoUsuarioConfig<Aluno> implements
        Serializable {

    @Autowired
    public GestaoAlunoImpl(AlunoDaoImpl alunoDao) {
        this.dao = alunoDao;
    }

    @Override
    public Integer salvarUsuario(Aluno t) throws ServiceException {
        return super.salvarUsuario(t);
    }

    @Override
    public void alterarUsuario(Aluno t) throws ServiceException {
        super.alterarUsuario(t);
    }

    @Override
    public void removerUsuario(Aluno t) throws ServiceException {
        super.removerUsuario(t);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Aluno> listarUsuario(Class clazz) throws ServiceException {
        return super.listarUsuario(clazz);
    }

    @Override
    public List<Aluno> consultarUsuario(Aluno t) throws ServiceException {
        return super.consultarUsuario(t);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Aluno consultarUsuario(Class clazz, Integer id)
            throws ServiceException {
        return super.consultarUsuario(clazz, id);
    }
}
