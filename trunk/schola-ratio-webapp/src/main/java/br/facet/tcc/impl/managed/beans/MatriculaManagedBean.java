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
package br.facet.tcc.impl.managed.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.facet.tcc.enums.SituacaoAlunoCurso;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAdministrativoImpl;
import br.facet.tcc.impl.service.GestaoAlunoCursoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Turma;

/**
 * @author Osnir F CUNHA
 * 
 */
@SuppressWarnings("serial")
@ManagedBean(name = "matriculaMB")
@ViewScoped
public class MatriculaManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(MatriculaManagedBean.class);

    @ManagedProperty("#{alunoCursoService}")
    private GestaoAlunoCursoImpl alunoCursoService;

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    private AlunoCurso aluno;

    private List<Turma> turmasListadas;

    private List<Turma> turmasSelecionadas;

    private List<Curso> cursos;

    public MatriculaManagedBean() {
        reset();
    }

    private void reset() {
        this.aluno = new AlunoCurso(new Curso(), new Aluno(),
                SituacaoAlunoCurso.CURSANDO);
        this.turmasListadas = new ArrayList<Turma>();
        this.turmasSelecionadas = new ArrayList<Turma>();

    }

    @SuppressWarnings("unchecked")
    public String matricularAluno() {

        try {
            Map<String, String> result = this.gestaoAdministrativo
                    .matricularAluno(this.aluno.getAluno(),
                            this.turmasSelecionadas);

            if (result.get("retornoErr").length() > 0) {
                FacesMessage messageErr = new FacesMessage(
                        FacesMessage.SEVERITY_WARN, this.aluno.getAluno()
                                .getNome() + " já matriculado em: ",
                        result.get("retornoErr"));
                FacesContext.getCurrentInstance().addMessage("message",
                        messageErr);
                log.error(messageErr.toString());
            }
            if (result.get("retornoOk").length() > 0) {
                FacesMessage message = new FacesMessage(
                        FacesMessage.SEVERITY_INFO, this.aluno.getAluno()
                                .getNome() + " matriculado em: ",
                        result.get("retornoOk"));
                FacesContext.getCurrentInstance()
                        .addMessage("message", message);
                log.debug(message.toString());
            }
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao matricular.", e
                            .getCause().getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
            log.error(message.toString());
        }

        return null;
    }

    public List<AlunoCurso> completeAluno(String query) {
        List<AlunoCurso> suggestions = new ArrayList<AlunoCurso>();

        Aluno aluno = new Aluno();
        aluno.setNome(query);

        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setAluno(aluno);
        alunoCurso.setSituacaoAlunoCurso(SituacaoAlunoCurso.CURSANDO);

        try {
            suggestions = this.alunoCursoService.consultarUsuario(alunoCurso);
        } catch (ServiceException e) {

            log.error("Falha ao executar o autocomplete aluno", e);

            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return suggestions;
    }

    public void buscarTurmas() {

        System.out.println("\nEntrou no buscar turmas\n");

        if (this.aluno.getId() != null) {
            Turma turma = new Turma();
            Disciplina disciplina = new Disciplina();
            Curso curso = new Curso();
            curso.setId(this.aluno.getCurso().getId());
            // disciplina.setId(this.aluno.getAluno().getId());
            disciplina.setCurso(curso);
            turma.setDisciplina(disciplina);

            try {
                this.turmasListadas = this.gestaoAdministrativo
                        .buscarTurma(turma);
            } catch (ServiceException e) {

                log.error("Falha ao listar as turmas", e);

                FacesMessage message = new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, e.getMessage(), e
                                .getCause().getMessage());
                FacesContext.getCurrentInstance()
                        .addMessage("message", message);
            }
        }
    }

    public void postProcessXLS(Object document) {
        this.processarXLS(document, "Matriculas");
    }

    /**
     * @return the aluno
     */
    public AlunoCurso getAluno() {
        return aluno;
    }

    /**
     * @return the turmasListadas
     */
    public List<Turma> getTurmasListadas() {
        return turmasListadas;
    }

    /**
     * @return the turmasSelecionadas
     */
    public List<Turma> getTurmasSelecionadas() {
        return turmasSelecionadas;
    }

    /**
     * @return the cursos
     */
    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     * @param alunoCursoService
     *            the alunoCursoService to set
     */
    public void setAlunoCursoService(GestaoAlunoCursoImpl alunoCursoService) {
        this.alunoCursoService = alunoCursoService;
    }

    /**
     * @param gestaoAdministrativo
     *            the gestaoAdministrativo to set
     */
    public void setGestaoAdministrativo(
            GestaoAdministrativoImpl gestaoAdministrativo) {
        this.gestaoAdministrativo = gestaoAdministrativo;
    }

    /**
     * @param aluno
     *            the aluno to set
     */
    public void setAluno(AlunoCurso aluno) {
        this.aluno = aluno;
    }

    /**
     * @param turmasListadas
     *            the turmasListadas to set
     */
    public void setTurmasListadas(List<Turma> turmasListadas) {
        this.turmasListadas = turmasListadas;
    }

    /**
     * @param turmasSelecionadas
     *            the turmasSelecionadas to set
     */
    public void setTurmasSelecionadas(List<Turma> turmasSelecionadas) {
        this.turmasSelecionadas = turmasSelecionadas;
    }

    /**
     * @param cursos
     *            the cursos to set
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
