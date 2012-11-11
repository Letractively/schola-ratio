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

import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAdministrativoImpl;
import br.facet.tcc.pojo.ConfGeralSistema;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@ManagedBean(name = "configGeralMB")
@ViewScoped
public class ConfGeraisSistemaManagedBean extends ConstantsMB implements
        Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    private List<ConfGeralSistema> confs;

    private List<ConfGeralSistema> listaConfGeralSistemas;

    private ConfGeralSistema confSalvar;

    private ConfGeralSistema confPesquisar;

    private ConfGeralSistema confSelecionada;

    public ConfGeraisSistemaManagedBean() {
        this.confs = new ArrayList<ConfGeralSistema>();

        this.reset();
    }

    public String salvarConfGeralSistema() {

        try {
            this.gestaoAdministrativo.salvarConfGeralSistema(confSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "ConfGeralSistema salva com sucesso.", "Código : "
                            + this.confSalvar.getId());
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

    public String atualizarConfGeralSistema() {
        try {
            this.gestaoAdministrativo.alterarConfGeralSistema(confSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "ConfGeralSistema alterada com sucesso.", "Código : "
                            + this.confSelecionada.getId());
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

    public String pesquisarConfGeralSistema() {
        this.confs = new ArrayList<ConfGeralSistema>();
        if ("".equals(confPesquisar.getAnoReferencia()) 
                || this.confPesquisar.getAnoReferencia().equals(0)) {
            this.confPesquisar.setAnoReferencia(null);
        }
        try {
            this.listaConfGeralSistemas = this.gestaoAdministrativo
                    .buscarConfGeralSistema(confPesquisar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.",
                    this.listaConfGeralSistemas.size() + " confs encontrado.");
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

    public String listarConfGeralSistemas() {
        try {
            this.confs = this.gestaoAdministrativo.listarConfGeralSistemas();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerConfGeralSistema() {
        try {
            this.confSelecionada.setStatus(Status.INATIVO);
            this.gestaoAdministrativo.alterarConfGeralSistema(confSelecionada);
            this.listaConfGeralSistemas.remove(confSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "ConfGeralSistema removida com sucesso.", "");
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
        this.confSalvar = new ConfGeralSistema();
        this.confPesquisar = new ConfGeralSistema();
        this.confSalvar.setStatus(Status.ATIVO);
    }

    /**
     * @return the confs
     */
    public List<ConfGeralSistema> getConfGeralSistemas() {
        listarConfGeralSistemas();
        return confs;
    }

    /**
     * @param confs
     *            the confs to set
     */
    public void setConfGeralSistemas(List<ConfGeralSistema> confs) {
        this.confs = confs;
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
     * @return the confSalvar
     */
    public ConfGeralSistema getConfGeralSistemaSalvar() {
        return confSalvar;
    }

    /**
     * @param confSalvar
     *            the confSalvar to set
     */
    public void setConfGeralSistemaSalvar(ConfGeralSistema confSalvar) {
        this.confSalvar = confSalvar;
    }

    /**
     * @return the confPesquisar
     */
    public ConfGeralSistema getConfGeralSistemaPesquisar() {
        return confPesquisar;
    }

    /**
     * @return the confSelecionada
     */
    public ConfGeralSistema getConfGeralSistemaSelecionada() {
        return confSelecionada;
    }

    /**
     * @param confPesquisar
     *            the confPesquisar to set
     */
    public void setConfGeralSistemaPesquisar(ConfGeralSistema confPesquisar) {
        this.confPesquisar = confPesquisar;
    }

    /**
     * @param confSelecionada
     *            the confSelecionada to set
     */
    public void setConfGeralSistemaSelecionada(ConfGeralSistema confSelecionada) {
        this.confSelecionada = confSelecionada;
    }

    /**
     * @return the listaConfGeralSistemas
     */
    public List<ConfGeralSistema> getListaConfGeralSistemas() {
        return listaConfGeralSistemas;
    }

    /**
     * @param listaConfGeralSistemas
     *            the listaConfGeralSistemas to set
     */
    public void setListaConfGeralSistemas(
            List<ConfGeralSistema> listaConfGeralSistemas) {
        this.listaConfGeralSistemas = listaConfGeralSistemas;
    }
}
