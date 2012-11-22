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

import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.dao.ConfGeralSistemaDaoImpl;
import br.facet.tcc.impl.dao.CursoDaoImpl;
import br.facet.tcc.impl.dao.DescontoDaoImpl;
import br.facet.tcc.impl.dao.DisciplinaDaoImpl;
import br.facet.tcc.impl.dao.TurmaDaoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.ConfGeralSistema;
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.Desconto;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Turma;
import br.facet.tcc.service.GestaoAdministrativo;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@Service("gestaoAdministrativo")
public class GestaoAdministrativoImpl implements GestaoAdministrativo {

    @Autowired
    private CursoDaoImpl cursoDao;

    @Autowired
    private DisciplinaDaoImpl disciplinaDao;

    @Autowired
    private TurmaDaoImpl turmaDao;

    @Autowired
    private ConfGeralSistemaDaoImpl confDao;

    @Autowired
    private DescontoDaoImpl descontoDao;

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#salvarCurso(br.facet.tcc.pojo.Curso)
     * @since since optional
     */
    @Override
    public Integer salvarCurso(Curso curso) throws ServiceException {
        try {
            return cursoDao.salvar(curso);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#alterarCurso(br.facet.tcc.pojo.Curso)
     * @since since optional
     */
    @Override
    public void alterarCurso(Curso curso) throws ServiceException {
        try {
            this.cursoDao.atualizar(curso);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#listarCursos()
     * @since since optional
     */
    @Override
    public List<Curso> listarCursos() throws ServiceException {
        try {
            return this.cursoDao.listar(Curso.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#buscarCurso(br.facet.tcc.pojo.Curso)
     * @since since optional
     */
    @Override
    public List<Curso> buscarCurso(Curso curso) throws ServiceException {
        try {
            return this.cursoDao.pesquisar(curso);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#salvarDisciplina(br.facet.tcc.pojo.Disciplina)
     * @since since optional
     */
    @Override
    public Integer salvarDisciplina(Disciplina disciplina)
            throws ServiceException {
        try {
            return this.disciplinaDao.salvar(disciplina);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#alterarDisciplina(br.facet.tcc.pojo.Disciplina)
     * @since since optional
     */
    @Override
    public void alterarDisciplina(Disciplina disciplina)
            throws ServiceException {
        try {
            this.disciplinaDao.atualizar(disciplina);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#listarDisciplinas()
     * @since since optional
     */
    @Override
    public List<Disciplina> listarDisciplinas() throws ServiceException {
        try {
            return this.disciplinaDao.listar(Disciplina.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#buscarDisciplinas(br.facet.tcc.pojo.Disciplina)
     * @since since optional
     */
    @Override
    public List<Disciplina> buscarDisciplinas(Disciplina disciplina)
            throws ServiceException {
        try {
            return this.disciplinaDao.pesquisar(disciplina);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#salvarTurma(br.facet.tcc.pojo.Turma)
     * @since since optional
     */
    @Override
    public Integer salvarTurma(Turma turma) throws ServiceException {
        try {
            return this.turmaDao.salvar(turma);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#alterarTurma(br.facet.tcc.pojo.Turma)
     * @since since optional
     */
    @Override
    public void alterarTurma(Turma turma) throws ServiceException {
        try {
            this.turmaDao.atualizar(turma);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#listarTurma()
     * @since since optional
     */
    @Override
    public List<Turma> listarTurma() throws ServiceException {
        try {
            return this.turmaDao.listar(Turma.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#buscarTurma(br.facet.tcc.pojo.Turma)
     * @since since optional
     */
    @Override
    public List<Turma> buscarTurma(Turma turma) throws ServiceException {
        try {
            return this.turmaDao.pesquisar(turma);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#matricularAluno(br.facet.tcc.pojo.Aluno,
     *      java.util.List)
     * @since since optional
     */
    @Override
    public Integer matricularAluno(Aluno aluno, List<Turma> turmas)
            throws ServiceException {
        return null;
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#matricularAluno(br.facet.tcc.pojo.Aluno,
     *      br.facet.tcc.pojo.Curso, java.lang.Integer)
     * @since since optional
     */
    @Override
    public Integer matricularAluno(Aluno aluno, Curso curso, Integer periodo)
            throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#alterarMatricula(br.facet.tcc.pojo.Aluno,
     *      br.facet.tcc.pojo.Turma, br.facet.tcc.enums.Status)
     * @since since optional
     */
    @Override
    public void alterarMatricula(Aluno aluno, Turma turma, Status status)
            throws ServiceException {
        // TODO Auto-generated method stub

    }

    /**
     * @see br.facet.tcc.service.GestaoAdministrativo#pesquisarMatricula(br.facet.tcc.pojo.Aluno,
     *      br.facet.tcc.pojo.Turma, br.facet.tcc.enums.Status)
     * @since since optional
     */
    @Override
    public void pesquisarMatricula(Aluno aluno, Turma turma, Status status)
            throws ServiceException {
        // TODO Auto-generated method stub

    }

    public Integer salvarConfGeralSistema(ConfGeralSistema confSalvar)
            throws ServiceException {
        try {
            return confDao.salvar(confSalvar);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    public void alterarConfGeralSistema(ConfGeralSistema confSelecionada)
            throws ServiceException {
        try {
            this.confDao.atualizar(confSelecionada);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }

    }

    public List<ConfGeralSistema> buscarConfGeralSistema(
            ConfGeralSistema confPesquisar) throws ServiceException {
        try {
            return this.confDao.pesquisar(confPesquisar);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<ConfGeralSistema> listarConfGeralSistemas()
            throws ServiceException {
        try {
            return this.confDao.listar(ConfGeralSistema.class);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

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

}
