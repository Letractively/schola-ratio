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
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.Disciplina;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@ManagedBean(name = "disciplinaMB")
@ViewScoped
public class DisciplinaManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(DisciplinaManagedBean.class);

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    private List<Disciplina> disciplinas;

    private List<Disciplina> listaDisciplinas;

    private Disciplina disciplinaSalvar;

    private Disciplina disciplinaPesquisar;

    private Disciplina disciplinaSelecionada;

    public DisciplinaManagedBean() {
        this.disciplinas = new ArrayList<Disciplina>();

        this.reset();
    }

    public String salvarDisciplina() {

        try {
            this.gestaoAdministrativo.salvarDisciplina(disciplinaSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Disciplina salva com sucesso.", "Código : "
                            + this.disciplinaSalvar.getId());
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

    public String atualizarDisciplina() {
        try {
            this.gestaoAdministrativo.alterarDisciplina(disciplinaSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Disciplina alterada com sucesso.", "Código : "
                            + this.disciplinaSelecionada.getId());
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

    public String pesquisarDisciplina() {
        this.disciplinas = new ArrayList<Disciplina>();
        if ("".equals(disciplinaPesquisar.getNome())) {
            this.disciplinaPesquisar.setNome(null);
        }
        if (disciplinaPesquisar.getPeriodo() == 0) {
            this.disciplinaPesquisar.setPeriodo(null);
        }
        if (disciplinaPesquisar.getCargaHoraria() == 0) {
            this.disciplinaPesquisar.setCargaHoraria(null);
        }
        if ("".equals(disciplinaPesquisar.getCurso().getNome())) {
            this.disciplinaPesquisar.setCurso(null);
        }

        try {
            this.listaDisciplinas = this.gestaoAdministrativo
                    .buscarDisciplinas(disciplinaPesquisar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.",
                    this.listaDisciplinas.size() + " disciplinas encontrado.");
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

    public String listarDisciplinas() {
        try {
            this.disciplinas = this.gestaoAdministrativo.listarDisciplinas();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerDisciplina() {
        try {
            this.disciplinaSelecionada.setStatus(Status.INATIVO);
            this.gestaoAdministrativo.alterarDisciplina(disciplinaSelecionada);
            this.listaDisciplinas.remove(disciplinaSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Disciplina removida com sucesso.", "");
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
        this.disciplinaSalvar = new Disciplina();
        this.disciplinaPesquisar = new Disciplina();
        this.disciplinaPesquisar.setCurso(new Curso());
        this.disciplinaSalvar.setStatus(Status.ATIVO);
    }

    public void prepararAtualizar() {
        Set<Disciplina> disciplinas = new HashSet<Disciplina>();

        for (Disciplina disciplina : this.disciplinaSelecionada.getRequisitos()) {
            Set<Disciplina> disciplinasD = new HashSet<Disciplina>();
            for (Disciplina disciplinaD : disciplina.getRequisitos()) {
                disciplinasD.add(disciplinaD);
            }
            disciplina.setRequisitos(disciplinasD);
            disciplinas.add(disciplina);
        }
        this.disciplinaSelecionada.setRequisitos(disciplinas);
    }

    public void postProcessXLS(Object document) {
        this.processarXLS(document, "Disciplinas");
    }

    /**
     * @return the disciplinas
     */
    public List<Disciplina> getDisciplinas() {
        listarDisciplinas();
        return disciplinas;
    }

    /**
     * @param disciplinas
     *            the disciplinas to set
     */
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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
     * @return the disciplinaSalvar
     */
    public Disciplina getDisciplinaSalvar() {
        return disciplinaSalvar;
    }

    /**
     * @param disciplinaSalvar
     *            the disciplinaSalvar to set
     */
    public void setDisciplinaSalvar(Disciplina disciplinaSalvar) {
        this.disciplinaSalvar = disciplinaSalvar;
    }

    /**
     * @return the disciplinaPesquisar
     */
    public Disciplina getDisciplinaPesquisar() {
        return disciplinaPesquisar;
    }

    /**
     * @return the disciplinaSelecionada
     */
    public Disciplina getDisciplinaSelecionada() {
        return disciplinaSelecionada;
    }

    /**
     * @param disciplinaPesquisar
     *            the disciplinaPesquisar to set
     */
    public void setDisciplinaPesquisar(Disciplina disciplinaPesquisar) {
        this.disciplinaPesquisar = disciplinaPesquisar;
    }

    /**
     * @param disciplinaSelecionada
     *            the disciplinaSelecionada to set
     */
    public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
        this.disciplinaSelecionada = disciplinaSelecionada;
    }

    /**
     * @return the listaDisciplinas
     */
    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    /**
     * @param listaDisciplinas
     *            the listaDisciplinas to set
     */
    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
}
