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
import br.facet.tcc.impl.service.GestaoFinanceiroImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;
import br.facet.tcc.pojo.Mensalidade;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@SuppressWarnings("serial")
@ManagedBean(name = "mensalidadeMB")
@ViewScoped
public class MensalidadeManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(MensalidadeManagedBean.class);

    @ManagedProperty("#{gestaoFinanceiro}")
    private GestaoFinanceiroImpl gestaoFinanceiro;

    private List<Mensalidade> mensalidades;

    private List<Mensalidade> listaMensalidade;

    public void setAluno(AlunoCurso alunoCurso) {
        this.mensalidadeSalvar.setAluno(alunoCurso.getAluno());
    }

    public AlunoCurso getAluno() {
        return null;
    }

    /**
     * @return the mensalidades
     */
    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    /**
     * @param mensalidades
     *            the mensalidades to set
     */
    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    private Mensalidade mensalidadeSalvar;

    private Mensalidade mensalidadePesquisar;

    private Mensalidade mensalidadeSelecionada;

    public MensalidadeManagedBean() {
        this.mensalidades = new ArrayList<Mensalidade>();

        this.reset();
    }

    public List<Aluno> completeDisciplina(String query) {
        List<Aluno> suggestions = new ArrayList<Aluno>();

        Aluno aluno = new Aluno();
        aluno.setNome(query);

        // suggestions = this.usurioService.consultarUsuario(suggestions);

        return suggestions;
    }

    public String salvarMensalidade() {

        try {
            this.gestaoFinanceiro.salvarMensalidade(mensalidadeSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Mensalidade salva com sucesso.", "Código : "
                            + this.mensalidadeSalvar.getId());
            FacesContext.getCurrentInstance().addMessage("message", message);
            log.debug(message.toString());
            this.reset();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
            log.error(message.toString());
        }
        return null;
    }

    public String atualizarMensalidade() {
        try {
            this.gestaoFinanceiro.alterarMensalidade(mensalidadeSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Mensalidade alterada com sucesso.", "Código : "
                            + this.mensalidadeSelecionada.getId());
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

    public String pesquisarMensalidade() {
        this.mensalidades = new ArrayList<Mensalidade>();
        if ("".equals(mensalidadePesquisar.getAluno())) {
            this.mensalidadePesquisar.setAluno(null);
        }
        if (mensalidadePesquisar.getValor() == 0) {
            this.mensalidadePesquisar.setValor(null);
        }

        try {
            this.listaMensalidade = this.gestaoFinanceiro
                    .buscarMensalidades(mensalidadePesquisar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.",
                    this.listaMensalidade.size() + " mensalidades encontrado.");
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

    public String listarMensalidade() {
        try {
            this.mensalidades = this.gestaoFinanceiro.listarMensalidades();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerMensalidade() {
        try {
            this.mensalidadeSelecionada.setStatus(Status.INATIVO);
            this.gestaoFinanceiro.alterarMensalidade(mensalidadeSelecionada);
            this.listaMensalidade.remove(mensalidadeSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Mensalidade removida com sucesso.", "");
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
        this.mensalidadeSalvar = new Mensalidade();
        this.mensalidadePesquisar = new Mensalidade();
        this.mensalidadeSalvar.setStatus(Status.ATIVO);
    }

    /**
     * @return the mensalidades
     */
    public List<Mensalidade> getMensalidade() {
        listarMensalidade();
        return mensalidades;
    }

    /**
     * @param mensalidades
     *            the mensalidades to set
     */
    public void setMensalidade(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    /**
     * @param gestaoFinanceiro
     *            the gestaoFinanceiro to set
     */
    public void setGestaoFinanceiro(GestaoFinanceiroImpl gestaoFinanceiro) {
        this.gestaoFinanceiro = gestaoFinanceiro;
    }

    /**
     * @return the mensalidadeSalvar
     */
    public Mensalidade getMensalidadeSalvar() {
        return mensalidadeSalvar;
    }

    /**
     * @param mensalidadeSalvar
     *            the mensalidadeSalvar to set
     */
    public void setMensalidadeSalvar(Mensalidade mensalidadeSalvar) {
        this.mensalidadeSalvar = mensalidadeSalvar;
    }

    /**
     * @return the mensalidadePesquisar
     */
    public Mensalidade getMensalidadePesquisar() {
        return mensalidadePesquisar;
    }

    /**
     * @return the mensalidadeSelecionada
     */
    public Mensalidade getMensalidadeSelecionada() {
        return mensalidadeSelecionada;
    }

    /**
     * @param mensalidadePesquisar
     *            the mensalidadePesquisar to set
     */
    public void setMensalidadePesquisar(Mensalidade mensalidadePesquisar) {
        this.mensalidadePesquisar = mensalidadePesquisar;
    }

    /**
     * @param mensalidadeSelecionada
     *            the mensalidadeSelecionada to set
     */
    public void setMensalidadeSelecionada(Mensalidade mensalidadeSelecionada) {
        this.mensalidadeSelecionada = mensalidadeSelecionada;
    }

    /**
     * @return the listaMensalidade
     */
    public List<Mensalidade> getListaMensalidade() {
        return listaMensalidade;
    }

    /**
     * @param listaMensalidade
     *            the listaMensalidade to set
     */
    public void setListaMensalidade(List<Mensalidade> listaMensalidade) {
        this.listaMensalidade = listaMensalidade;
    }
}
