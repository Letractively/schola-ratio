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
package br.facet.tcc.impl.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.AvaliacaoDeAlunoDaoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AvaliacaoDeAluno;
import br.facet.tcc.pojo.Turma;
import br.facet.tcc.service.GestaoAcademico;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Service("gestaoAcademico")
public class GestaoAcademicoImpl implements GestaoAcademico {

    @Autowired
    private AvaliacaoDeAlunoDaoImpl avaliacaoDeAlunoDao;

    /**
     * @see br.facet.tcc.service.GestaoAcademico#registrarNotasFaltas(br.facet.tcc.pojo.AvaliacaoDeAluno)
     * @since since optional
     */
    @Override
    public void registrarNotasFaltas(AvaliacaoDeAluno avaliacaoDeAluno)
        throws ServiceException {

        try {
            this.avaliacaoDeAlunoDao.salvar(avaliacaoDeAluno);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    /**
     * @see br.facet.tcc.service.GestaoAcademico#registrarNotasFaltas(java.util.List)
     * @since since optional
     */
    @Override
    public void registrarNotasFaltas(List<AvaliacaoDeAluno> avaliacoesDaTurma)
        throws ServiceException {

        for (AvaliacaoDeAluno avaliacaoDeAluno : avaliacoesDaTurma) {
            try {
                this.avaliacaoDeAlunoDao.salvar(avaliacaoDeAluno);
            } catch (DaoException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAcademico#buscarRelatorio(java.lang.Integer)
     * @since since optional
     */
    @Override
    public File buscarRelatorio(Integer tipo) throws ServiceException {
        throw new ServiceException("Ainda não implementado.");
    }

    /**
     * @see br.facet.tcc.service.GestaoAcademico#listarDiario(br.facet.tcc.pojo.Aluno)
     * @since since optional
     */
    @Override
    public List<AvaliacaoDeAluno> listarDiario(Aluno aluno)
        throws ServiceException {

        AvaliacaoDeAluno avaliacaoDeAluno = new AvaliacaoDeAluno();
        avaliacaoDeAluno.setAluno(aluno);

        List<AvaliacaoDeAluno> avaliacaoDeAlunos = null;
        try {
            this.avaliacaoDeAlunoDao.pesquisar(avaliacaoDeAluno);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return avaliacaoDeAlunos;
    }

    /**
     * @see br.facet.tcc.service.GestaoAcademico#listarDiario(br.facet.tcc.pojo.Turma)
     * @since since optional
     */
    @Override
    public List<AvaliacaoDeAluno> listarDiario(Turma turma)
        throws ServiceException {

        return null;
    }

}
