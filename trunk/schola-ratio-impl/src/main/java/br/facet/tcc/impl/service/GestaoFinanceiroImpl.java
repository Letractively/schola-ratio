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

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.DescontoDaoImpl;
import br.facet.tcc.impl.dao.MensalidadeDaoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Desconto;
import br.facet.tcc.pojo.Mensalidade;
import br.facet.tcc.service.GestaoFinanceiro;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@Service("gestaoFinanceiro")
public class GestaoFinanceiroImpl implements GestaoFinanceiro {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private DescontoDaoImpl descontoDao;

    @Autowired
    private MensalidadeDaoImpl mensalidadeDao;

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#salvarDisciplina(br.facet.tcc.pojo.Disciplina)
     * @since since optional
     */
    public Integer salvarDesconto(Desconto desconto) throws ServiceException {
        try {
            return this.descontoDao.salvar(desconto);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#alterarDesconto(br.facet.tcc.pojo.Desconto)
     * @since since optional
     */
    public void alterarDesconto(Desconto desconto) throws ServiceException {
        try {
            this.descontoDao.atualizar(desconto);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#listarDescontos()
     * @since since optional
     */
    public List<Desconto> listarDescontos() throws ServiceException {
        try {
            return this.descontoDao.listar(Desconto.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#buscarDescontos(br.facet.tcc.pojo.Desconto)
     * @since since optional
     */

    public List<Desconto> buscarDescontos(Desconto desconto)
            throws ServiceException {
        try {
            return this.descontoDao.pesquisar(desconto);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#salvarDisciplina(br.facet.tcc.pojo.Disciplina)
     * @since since optional
     */
    public Integer salvarMensalidade(Mensalidade mensalidade)
            throws ServiceException {
        try {
            return this.mensalidadeDao.salvar(mensalidade);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#alterarDesconto(br.facet.tcc.pojo.Desconto)
     * @since since optional
     */
    public void alterarMensalidade(Mensalidade mensalidade)
            throws ServiceException {
        try {
            this.mensalidadeDao.atualizar(mensalidade);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#listarDescontos()
     * @since since optional
     */
    public List<Mensalidade> listarMensalidades() throws ServiceException {
        try {
            return this.mensalidadeDao.listar(Mensalidade.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#buscarDescontos(br.facet.tcc.pojo.Desconto)
     * @since since optional
     */

    public List<Mensalidade> buscarMensalidades(Mensalidade mensalidade)
            throws ServiceException {
        try {
            return this.mensalidadeDao.pesquisar(mensalidade);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Integer gerarMensalidade(Aluno aluno) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Mensalidade> buscarMensalidade(Aluno aluno)
            throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void quitarMensalidade(Aluno aluno) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizarMensalidade(Aluno aluno) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public void aplicarDesconto(Desconto desconto) throws ServiceException {
        // TODO Auto-generated method stub

    }

    @Override
    public File buscarRelatorio() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

}
