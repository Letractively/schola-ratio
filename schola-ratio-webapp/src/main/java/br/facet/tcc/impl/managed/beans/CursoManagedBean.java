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

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@ManagedBean(name = "cursoMB")
@ViewScoped
public class CursoManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger.getLogger(CursoManagedBean.class);

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    private List<Curso> cursos;

    private List<Curso> listaCursos;

    private Curso cursoSalvar;

    private Curso cursoPesquisar;

    private Curso cursoSelecionada;

    public CursoManagedBean() {
        this.cursos = new ArrayList<Curso>();

        this.reset();
    }

    public String salvarCurso() {

        try {
            this.gestaoAdministrativo.salvarCurso(cursoSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Curso salva com sucesso.", "Código : "
                            + this.cursoSalvar.getId());
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

    public String atualizarCurso() {
        try {
            this.gestaoAdministrativo.alterarCurso(cursoSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Curso alterada com sucesso.", "Código : "
                            + this.cursoSelecionada.getId());
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

    public String pesquisarCurso() {
        this.cursos = new ArrayList<Curso>();
        if ("".equals(cursoPesquisar.getNome())) {
            this.cursoPesquisar.setNome(null);
        }
        if (cursoPesquisar.getDuracao() == 0) {
            this.cursoPesquisar.setDuracao(null);
        }
        try {
            this.listaCursos = this.gestaoAdministrativo
                    .buscarCurso(cursoPesquisar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", this.listaCursos.size()
                            + " cursos encontrado.");
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

    public String listarCursos() {
        try {
            this.cursos = this.gestaoAdministrativo.listarCursos();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerCurso() {
        try {
            this.cursoSelecionada.setStatus(Status.INATIVO);
            this.gestaoAdministrativo.alterarCurso(cursoSelecionada);
            this.listaCursos.remove(cursoSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Curso removida com sucesso.", "");
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
        this.cursoSalvar = new Curso();
        this.cursoPesquisar = new Curso();
        this.cursoSalvar.setStatus(Status.ATIVO);
    }

    /**
     * @return the cursos
     */
    public List<Curso> getCursos() {
        listarCursos();
        return cursos;
    }

    /**
     * @param cursos
     *            the cursos to set
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
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
     * @return the cursoSalvar
     */
    public Curso getCursoSalvar() {
        return cursoSalvar;
    }

    /**
     * @param cursoSalvar
     *            the cursoSalvar to set
     */
    public void setCursoSalvar(Curso cursoSalvar) {
        this.cursoSalvar = cursoSalvar;
    }

    /**
     * @return the cursoPesquisar
     */
    public Curso getCursoPesquisar() {
        return cursoPesquisar;
    }

    /**
     * @return the cursoSelecionada
     */
    public Curso getCursoSelecionada() {
        return cursoSelecionada;
    }

    /**
     * @param cursoPesquisar
     *            the cursoPesquisar to set
     */
    public void setCursoPesquisar(Curso cursoPesquisar) {
        this.cursoPesquisar = cursoPesquisar;
    }

    /**
     * @param cursoSelecionada
     *            the cursoSelecionada to set
     */
    public void setCursoSelecionada(Curso cursoSelecionada) {
        this.cursoSelecionada = cursoSelecionada;
    }

    /**
     * @return the listaCursos
     */
    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    /**
     * @param listaCursos
     *            the listaCursos to set
     */
    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
}
