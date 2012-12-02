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
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;
import br.facet.tcc.pojo.Desconto;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@SuppressWarnings("serial")
@ManagedBean(name = "descontoMB")
@ViewScoped
public class DescontoManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(DescontoManagedBean.class);

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    private List<Desconto> descontos;

    private List<Desconto> listaDesconto;

    public void setAluno(AlunoCurso alunoCurso) {
        this.descontoSalvar.setAluno(alunoCurso.getAluno());
    }

    public AlunoCurso getAluno() {
        return null;
    }

    /**
     * @return the descontos
     */
    public List<Desconto> getDescontos() {
        return descontos;
    }

    /**
     * @param descontos
     *            the descontos to set
     */
    public void setDescontos(List<Desconto> descontos) {
        this.descontos = descontos;
    }

    private Desconto descontoSalvar;

    private Desconto descontoPesquisar;

    private Desconto descontoSelecionada;

    public DescontoManagedBean() {
        this.descontos = new ArrayList<Desconto>();

        this.reset();
    }

    public List<Aluno> completeDisciplina(String query) {
        List<Aluno> suggestions = new ArrayList<Aluno>();

        Aluno aluno = new Aluno();
        aluno.setNome(query);

        // suggestions = this.usurioService.consultarUsuario(suggestions);

        return suggestions;
    }

    public String salvarDesconto() {

        try {
            this.gestaoAdministrativo.salvarDesconto(descontoSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Desconto salva com sucesso.", "Código : "
                            + this.descontoSalvar.getId());
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

    public String atualizarDesconto() {
        try {
            this.gestaoAdministrativo.alterarDesconto(descontoSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Desconto alterada com sucesso.", "Código : "
                            + this.descontoSelecionada.getId());
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

    public String pesquisarDesconto() {
        this.descontos = new ArrayList<Desconto>();
        if ("".equals(descontoPesquisar.getAluno())) {
            this.descontoPesquisar.setAluno(null);
        }
        if (descontoPesquisar.getValorDesconto() == 0) {
            this.descontoPesquisar.setValorDesconto(null);
        }

        try {
            this.listaDesconto = this.gestaoAdministrativo
                    .buscarDescontos(descontoPesquisar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", this.listaDesconto.size()
                            + " descontos encontrado.");
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

    public String listarDesconto() {
        try {
            this.descontos = this.gestaoAdministrativo.listarDescontos();
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerDesconto() {
        try {
            this.descontoSelecionada.setStatus(Status.INATIVO);
            this.gestaoAdministrativo.alterarDesconto(descontoSelecionada);
            this.listaDesconto.remove(descontoSelecionada);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Desconto removida com sucesso.", "");
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
        this.descontoSalvar = new Desconto();
        this.descontoPesquisar = new Desconto();
        this.descontoSalvar.setStatus(Status.ATIVO);
    }

    /**
     * @return the descontos
     */
    public List<Desconto> getDesconto() {
        listarDesconto();
        return descontos;
    }

    /**
     * @param descontos
     *            the descontos to set
     */
    public void setDesconto(List<Desconto> descontos) {
        this.descontos = descontos;
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
     * @return the descontoSalvar
     */
    public Desconto getDescontoSalvar() {
        return descontoSalvar;
    }

    /**
     * @param descontoSalvar
     *            the descontoSalvar to set
     */
    public void setDescontoSalvar(Desconto descontoSalvar) {
        this.descontoSalvar = descontoSalvar;
    }

    /**
     * @return the descontoPesquisar
     */
    public Desconto getDescontoPesquisar() {
        return descontoPesquisar;
    }

    /**
     * @return the descontoSelecionada
     */
    public Desconto getDescontoSelecionada() {
        return descontoSelecionada;
    }

    /**
     * @param descontoPesquisar
     *            the descontoPesquisar to set
     */
    public void setDescontoPesquisar(Desconto descontoPesquisar) {
        this.descontoPesquisar = descontoPesquisar;
    }

    /**
     * @param descontoSelecionada
     *            the descontoSelecionada to set
     */
    public void setDescontoSelecionada(Desconto descontoSelecionada) {
        this.descontoSelecionada = descontoSelecionada;
    }

    /**
     * @return the listaDesconto
     */
    public List<Desconto> getListaDesconto() {
        return listaDesconto;
    }

    /**
     * @param listaDesconto
     *            the listaDesconto to set
     */
    public void setListaDesconto(List<Desconto> listaDesconto) {
        this.listaDesconto = listaDesconto;
    }
}
