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
package br.facet.tcc.controle;

import java.util.List;

import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Turma;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface GestaoAdministrativo {

    /**
     * @param curso
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public Integer salvarCurso(Curso curso) throws ServiceException;

    /**
     * @param curso
     * @throws ServiceException
     * @since 0.0.1
     */
    public void alterarCurso(Curso curso) throws ServiceException;

    /**
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public List<Curso> listarCursos() throws ServiceException;

    /**
     * @param curso
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public List<Curso> buscarCurso(Curso curso) throws ServiceException;

    /**
     * @param disciplina
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public Integer salvarDisciplina(Disciplina disciplina)
        throws ServiceException;

    /**
     * @param disciplina
     * @throws ServiceException
     * @since 0.0.1
     */
    public void alterarDisciplina(Disciplina disciplina)
        throws ServiceException;

    /**
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public List<Disciplina> listarDisciplinas() throws ServiceException;

    /**
     * @param disciplina
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public List<Disciplina> buscarDisciplinas(Disciplina disciplina)
        throws ServiceException;

    public Integer salvarTurma(Turma turma) throws ServiceException;

    /**
     * @param turma
     * @throws ServiceException
     * @since 0.0.1
     */
    public void alterarTurma(Turma turma) throws ServiceException;

    /**
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public List<Turma> listarTurma() throws ServiceException;

    /**
     * @param turma
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public List<Turma> buscarTurma(Turma turma) throws ServiceException;

    /**
     * @param aluno
     * @param turmas
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public Integer matricularAluno(Aluno aluno, List<Turma> turmas)
        throws ServiceException;

    /**
     * @param aluno
     * @param curso
     * @param periodo
     * @return
     * @throws ServiceException
     * @since 0.0.1
     */
    public Integer matricularAluno(Aluno aluno, Curso curso, Integer periodo)
        throws ServiceException;

    /**
     * @param aluno
     * @param turma
     * @param status
     * @throws ServiceException
     * @since 0.0.1
     */
    public void alterarMatricula(Aluno aluno, Turma turma, Status status)
        throws ServiceException;

    /**
     * @param aluno
     * @param turma
     * @param status
     * @throws ServiceException
     * @since 0.0.1
     */
    public void pesquisarMatricula(Aluno aluno, Turma turma, Status status)
        throws ServiceException;
}