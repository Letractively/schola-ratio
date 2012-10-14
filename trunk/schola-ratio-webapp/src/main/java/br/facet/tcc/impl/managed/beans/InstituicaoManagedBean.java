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

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoConfiguracaoImpl;
import br.facet.tcc.pojo.Instituicao;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.2
 * @since 01 SEP 2012
 */
@ManagedBean(name = "instituicaoMB")
@ViewScoped
public class InstituicaoManagedBean extends ConstantsMB implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{instituicaoService}")
    private GestaoConfiguracaoImpl instituicaoService;

    public void setInstituicaoService(GestaoConfiguracaoImpl instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    private Instituicao instituicaoPesquisar;

    private Instituicao instituicaoSalvar = new Instituicao();

    /**
     * Add User
     * 
     * @return String - Response Message
     */
    public String atualizarInstituicao() {
        try {
            this.instituicaoService
                    .atualizarDetalhesInstituicao(instituicaoSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    /**
     * List users
     * 
     * @return
     * @since schola-ratio-webapp 0.0.1
     */
    public String pesquisarInstituicaos() {
        try {

            instituicaoPesquisar = instituicaoService
                    .atualizarDetalhesInstituicao(instituicaoSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }
        return null;
    }

    /**
     * @return the instituicaoPesquisar
     * @throws ServiceException
     */
    public Instituicao getInstituicaoPesquisar() throws ServiceException {
        this.instituicaoPesquisar = this.instituicaoService.buscarInstituicao();
        return instituicaoPesquisar;
    }

    public void setInstituicaoPesquisar(Instituicao instituicaoPesquisar) {
        this.instituicaoPesquisar = instituicaoPesquisar;
    }

    public Instituicao getInstituicaoSalvar() {
        return instituicaoSalvar;
    }

    public void setInstituicaoSalvar(Instituicao instituicaoSalvar) {
        this.instituicaoSalvar = instituicaoSalvar;
    }

}
