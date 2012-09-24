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
import br.facet.tcc.enums.UserRoles;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.datamodel.AlunoDataModel;
import br.facet.tcc.impl.service.GestaoAlunoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author TODO: Djulles IKEDA
 * 
 * @version 1.0.2
 * @since 01 SEP 2012
 */
@ManagedBean(name = "alunoMB")
@ViewScoped
public class AlunoManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger.getLogger(AlunoManagedBean.class);

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{alunoService}")
    private GestaoAlunoImpl alunoService;

    @ManagedProperty("#{alunoDataModel}")
    private AlunoDataModel alunoDataModel;

    private List<Aluno> listaAlunos;

    private Aluno alunoSalvar;

    private Aluno alunoPesquisar = new Aluno();

    private Aluno alunoSelecionado;

    public AlunoManagedBean() {
        this.listaAlunos = new ArrayList<Aluno>();

        this.reset();
    }

    /**
     * Add User
     * 
     * @return String - Response Message
     */
    public String salvarAluno() {
        try {

            UserLogin userLogin = new UserLogin();
            List<br.facet.tcc.pojo.UserRoles> permissoes = new ArrayList<br.facet.tcc.pojo.UserRoles>();
            br.facet.tcc.pojo.UserRoles roles = new br.facet.tcc.pojo.UserRoles();
            roles.setUserRole(UserRoles.ROLE_ALU);
            permissoes.add(roles);
            userLogin.setPermissoes(permissoes);
            userLogin.setUsername(alunoSalvar.getUserLogin().getUsername());
            userLogin.setPassword(alunoSalvar.getUserLogin().getPassword());

            this.alunoSalvar.setUserLogin(userLogin);

            this.alunoService.salvarUsuario(this.alunoSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Aluno salvo com sucesso.", "Código : "
                            + this.alunoSalvar.getId());
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

    /**
     * Update User
     * 
     * @return String - Response Message
     */
    public String atualizarAluno() {
        try {
            this.alunoService.alterarUsuario(this.alunoSelecionado);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Aluno atualizado com sucesso.", "Código : "
                            + this.alunoSalvar.getId());
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

    /**
     * Search user
     * 
     * @return
     * @since 0.0.1
     */
    public String pesquisarAlunos() {

        listaAlunos = new ArrayList<Aluno>();
        if ("".equals(alunoPesquisar.getNome())) {
            alunoPesquisar.setNome(null);
        }

        if (alunoPesquisar.getCpf() == 0) {
            alunoPesquisar.setCpf(null);
        }

        if ("".equals(alunoPesquisar.getUserLogin().getUsername())) {
            alunoPesquisar.setUserLogin(null);
        }

        try {
            listaAlunos = alunoService.consultarUsuario(alunoPesquisar);
            this.alunoDataModel.setWrappedData(listaAlunos);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", this.listaAlunos.size()
                            + " usuários encontrado.");
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

    /**
     * List users
     * 
     * @return
     * @since schola-ratio-webapp 0.0.1
     */
    public String listarAlunos() {
        try {
            this.listaAlunos = this.alunoService.listarUsuario(Aluno.class);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerAluno() {

        try {
            this.alunoService.removerUsuario(alunoSelecionado);
            this.listaAlunos.remove(alunoSelecionado);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Aluno removido com sucesso.", "");
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
     * Reset Fields
     * 
     */
    public void reset() {
        alunoSalvar = new Aluno();
        alunoPesquisar = new Aluno();
        alunoSalvar.setUserLogin(new UserLogin());
        alunoPesquisar.setUserLogin(new UserLogin());
        alunoSalvar.setStatus(Status.ATIVO);
    }

    /**
     * Get User List
     * 
     * @return List - User List
     */
    public List<Aluno> getListaAlunos() {

        return listaAlunos;
    }

    /**
     * @return the alunoDataModel
     */
    public AlunoDataModel getAlunoDataModel() {
        return alunoDataModel;
    }

    /**
     * @return the aluno
     */
    public Aluno getAlunoSalvar() {
        return alunoSalvar;
    }

    /**
     * @return the alunoSelecionado
     */
    public Aluno getAlunoSelecionado() {
        return alunoSelecionado;
    }

    /**
     * @return the alunoPesquisar
     */
    public Aluno getAlunoPesquisar() {
        return alunoPesquisar;
    }

    /**
     * @param usurioService
     *            the usurioService to set
     */
    public void setAlunoService(GestaoAlunoImpl alunoService) {
        this.alunoService = alunoService;
    }

    public GestaoAlunoImpl getAlunoService() {
        return alunoService;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    /**
     * @param aluno
     *            the aluno to set
     */
    public void setAlunoSalvar(Aluno aluno) {
        this.alunoSalvar = aluno;
    }

    /**
     * @param alunoDataModel
     *            the alunoDataModel to set
     */
    public void setAlunoDataModel(AlunoDataModel alunoDataModel) {
        this.alunoDataModel = alunoDataModel;
    }

    /**
     * @param alunoSelecionado
     *            the alunoSelecionado to set
     */
    public void setAlunoSelecionado(Aluno alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

    public void setAlunoPesquisar(Aluno alunoPesquisar) {
        this.alunoPesquisar = alunoPesquisar;
    }

}
