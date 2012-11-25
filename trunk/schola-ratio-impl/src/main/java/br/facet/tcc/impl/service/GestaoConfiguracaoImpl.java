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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facet.tcc.dao.Dao;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.InstituicaoDaoImpl;
import br.facet.tcc.pojo.Instituicao;
import br.facet.tcc.pojo.Permissao;
import br.facet.tcc.service.GestaoConfiguracao;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Service("instituicaoService")
public class GestaoConfiguracaoImpl implements GestaoConfiguracao {

    @Autowired
    public GestaoConfiguracaoImpl(InstituicaoDaoImpl instituicaoDao) {
        this.instituicaoDao = instituicaoDao;
    }

    private final Dao instituicaoDao;

    /**
     * @return
     * @see br.facet.tcc.impl.service.GestaoUsuarioConfig#alterarUsuario(java.lang.Usuario)
     * @since since optional
     */

    @Override
    public Instituicao atualizarDetalhesInstituicao(Instituicao instituicao)
            throws ServiceException {
        try {
            this.instituicaoDao.atualizar(instituicao);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return instituicao;

    }

    @Override
    public Integer incluirPermissao(Permissao permissao)
            throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void alterarPermissao(Permissao permissao) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public Instituicao buscarInstituicao() throws ServiceException {
        try {
            return (Instituicao) this.instituicaoDao.listar(Instituicao.class)
                    .get(0);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }

}
