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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAdministrativoImpl;
import br.facet.tcc.impl.service.GestaoProfessorImpl;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Professor;
import br.facet.tcc.pojo.Turma;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@ManagedBean(name = "turmaMB")
@ViewScoped
public class TurmaManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger.getLogger(TurmaManagedBean.class);

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    @ManagedProperty("#{professorService}")
    private GestaoProfessorImpl professorService;

    private List<Turma> listaTurmas;

    private Turma turmaSalvar;

    private Turma turmaPesquisar;

    private Turma turmaSelecionada;

    private List<Professor> professores;

    public TurmaManagedBean() {
        this.reset();
    }

    public String salvarTurma() {

        try {
            this.gestaoAdministrativo.salvarTurma(turmaSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Turma salva com sucesso.", "Código : "
                            + this.turmaSalvar.getId());
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return null;
    }

    public String atualizarTurma() {
        try {
            this.gestaoAdministrativo.alterarTurma(turmaSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Turma alterada com sucesso.", "Código : "
                            + this.turmaSelecionada.getId());
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return null;
    }

    public String pesquisarTurma() {
        this.listaTurmas = new ArrayList<Turma>();
        if (turmaPesquisar.getDisciplina() == null
                || turmaPesquisar.getDisciplina().getNome() == null
                || "".equals(turmaPesquisar.getDisciplina().getNome().trim())) {
            this.turmaPesquisar.setDisciplina(null);
        } else {
            Disciplina disciplina = new Disciplina();
            disciplina.setId(turmaPesquisar.getDisciplina().getId());
            disciplina.setStatus(null);
            disciplina.setRequisitos(null);
            this.turmaPesquisar.setDisciplina(disciplina);
        }
        if (turmaPesquisar.getProfessor() == null
                || turmaPesquisar.getProfessor().getNome() == null
                || "".equals(turmaPesquisar.getProfessor().getNome().trim())) {
            this.turmaPesquisar.setProfessor(null);
        } else {
            Professor professor = new Professor();
            professor.setId(this.turmaPesquisar.getProfessor().getId());
            professor.setStatus(null);
            professor.setDisciplinasQueLeciona(null);
            professor.setHorarioDisponivel(null);
            this.turmaPesquisar.setProfessor(professor);
        }
        if ("".equals(turmaPesquisar.getAno().trim())) {
            this.turmaPesquisar.setAno(null);
        }
        try {
            this.listaTurmas = this.gestaoAdministrativo
                    .buscarTurma(turmaPesquisar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", this.listaTurmas.size()
                            + " turmas encontrada.");
            FacesContext.getCurrentInstance().addMessage("message", message);
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return null;
    }

    public String listarTurmas() {
        try {
            this.listaTurmas = this.gestaoAdministrativo.listarTurma();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerTurma() {
        try {
            this.turmaSelecionada.setStatus(Status.INATIVO);
            this.gestaoAdministrativo.alterarTurma(turmaSelecionada);
            this.listaTurmas.remove(turmaSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Turma removida com sucesso.", "");
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    private void reset() {
        this.turmaSalvar = new Turma();
        this.turmaPesquisar = new Turma();
        this.turmaSalvar.setStatus(Status.ATIVO);
        this.professores = new ArrayList<Professor>();
    }

    public void prepararAtualizar() {
        Disciplina disciplina = this.turmaSelecionada.getDisciplina();
        disciplina.setRequisitos(new HashSet<Disciplina>());
        Professor professor = new Professor();
        Set<Disciplina> disciplinas = new HashSet<Disciplina>();
        disciplinas.add(disciplina);
        professor.setDisciplinasQueLeciona(disciplinas);

        try {
            this.professores = this.professorService
                    .consultarUsuario(professor);
        } catch (ServiceException e) {
        }
    }

    public void prepararSalvar() {
        Disciplina disciplina = this.turmaSalvar.getDisciplina();
        Professor professor = new Professor();
        Set<Disciplina> disciplinas = new HashSet<Disciplina>();
        disciplinas.add(disciplina);
        professor.setDisciplinasQueLeciona(disciplinas);

        try {
            this.professores = this.professorService
                    .consultarUsuario(professor);
        } catch (ServiceException e) {
        }

    }

    public void prepararDisciplinasParaSalvar() {
        Disciplina disciplina = this.turmaSalvar.getDisciplina();
        Set<Disciplina> disciplinasD = new HashSet<Disciplina>();
        for (Disciplina disciplinaD : disciplina.getRequisitos()) {
            disciplinasD.add(disciplinaD);
        }
        disciplina.setRequisitos(disciplinasD);
        turmaSalvar.setDisciplina(disciplina);
    }

    public List<Disciplina> completeDisciplina(String query) {
        List<Disciplina> suggestions = new ArrayList<Disciplina>();

        Disciplina disciplinaAutoComplete = new Disciplina();
        disciplinaAutoComplete.setRequisitos(null);
        disciplinaAutoComplete.setNome(query);

        try {
            suggestions = this.gestaoAdministrativo
                    .buscarDisciplinas(disciplinaAutoComplete);
        } catch (ServiceException e) {
        }

        return suggestions;
    }

    public List<Professor> completeProfessor(String query) {
        List<Professor> suggestions = new ArrayList<Professor>();

        Professor professorAutoComplete = new Professor();
        professorAutoComplete.setNome(query);
        professorAutoComplete.setDisciplinasQueLeciona(null);

        try {
            suggestions = this.professorService
                    .consultarUsuario(professorAutoComplete);
        } catch (ServiceException e) {
        }

        return suggestions;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    /**
     * @return the listaTurmas
     */
    public List<Turma> getListaTurmas() {
        return listaTurmas;
    }

    /**
     * @return the turmaSalvar
     */
    public Turma getTurmaSalvar() {
        return turmaSalvar;
    }

    /**
     * @return the turmaPesquisar
     */
    public Turma getTurmaPesquisar() {
        return turmaPesquisar;
    }

    /**
     * @return the turmaSelecionada
     */
    public Turma getTurmaSelecionada() {
        return turmaSelecionada;
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
     * @param listaTurmas
     *            the listaTurmas to set
     */
    public void setListaTurmas(List<Turma> listaTurmas) {
        this.listaTurmas = listaTurmas;
    }

    /**
     * @param turmaSalvar
     *            the turmaSalvar to set
     */
    public void setTurmaSalvar(Turma turmaSalvar) {
        this.turmaSalvar = turmaSalvar;
    }

    /**
     * @param turmaPesquisar
     *            the turmaPesquisar to set
     */
    public void setTurmaPesquisar(Turma turmaPesquisar) {
        this.turmaPesquisar = turmaPesquisar;
    }

    /**
     * @param turmaSelecionada
     *            the turmaSelecionada to set
     */
    public void setTurmaSelecionada(Turma turmaSelecionada) {
        this.turmaSelecionada = turmaSelecionada;
    }

    public void setProfessorService(GestaoProfessorImpl professorService) {
        this.professorService = professorService;
    }
}
