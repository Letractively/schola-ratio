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
import br.facet.tcc.impl.datamodel.ProfessorDataModel;
import br.facet.tcc.impl.service.GestaoProfessorImpl;
import br.facet.tcc.pojo.Professor;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Djulles IKEDA
 * 
 * @version 1.0.2
 * @since 23 SEP 2012
 */
@ManagedBean(name = "professorMB")
@ViewScoped
public class ProfessorManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(ProfessorManagedBean.class);

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{professorService}")
    private GestaoProfessorImpl professorService;

    @ManagedProperty("#{professorDataModel}")
    private ProfessorDataModel professorDataModel;

    private List<Professor> listaProfessors;

    private Professor professorSalvar;

    private Professor professorPesquisar = new Professor();

    private Professor professorSelecionado;

    public ProfessorManagedBean() {
        this.listaProfessors = new ArrayList<Professor>();

        this.reset();
    }

    /**
     * Add User
     * 
     * @return String - Response Message
     */
    public String salvarProfessor() {
        try {

            List<br.facet.tcc.pojo.UserRoles> permissoes = new ArrayList<br.facet.tcc.pojo.UserRoles>();
            br.facet.tcc.pojo.UserRoles roles = new br.facet.tcc.pojo.UserRoles();
            roles.setUserRole(UserRoles.ROLE_ACA);
            permissoes.add(roles);
            this.professorSalvar.getUserLogin().setPermissoes(permissoes);

            this.professorService.salvarUsuario(this.professorSalvar);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Professor salvo com sucesso.", "Código : "
                            + this.professorSalvar.getId());
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
    public String atualizarProfessor() {
        try {
            this.professorService.alterarUsuario(this.professorSelecionado);

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Professor atualizado com sucesso.", "Código : "
                            + this.professorSelecionado.getId());
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
    public String pesquisarProfessors() {

        listaProfessors = new ArrayList<Professor>();
        if ("".equals(professorPesquisar.getNome())) {
            professorPesquisar.setNome(null);
        }

        if (professorPesquisar.getCpf() == 0) {
            professorPesquisar.setCpf(null);
        }

        if ("".equals(professorPesquisar.getUserLogin().getUsername())) {
            professorPesquisar.setUserLogin(null);
        }

        try {
            listaProfessors = professorService
                    .consultarUsuario(professorPesquisar);
            // this.professorDataModel.setWrappedData(listaProfessors);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Busca realizada com sucesso.", this.listaProfessors.size()
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
    public String listarProfessors() {
        try {
            this.listaProfessors = this.professorService
                    .listarUsuario(Professor.class);
        } catch (ServiceException e) {
            FacesMessage message = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause()
                            .getMessage());
            FacesContext.getCurrentInstance().addMessage("message", message);
        }

        return null;
    }

    public String removerProfessor() {

        try {
            this.professorSelecionado.setStatus(Status.INATIVO);
            this.professorService.alterarUsuario(professorSelecionado);
            this.listaProfessors.remove(professorSelecionado);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Professor removido com sucesso.", "");
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
        professorSalvar = new Professor();
        professorPesquisar = new Professor();
        professorSalvar.setUserLogin(new UserLogin());
        professorPesquisar.setUserLogin(new UserLogin());
        professorSalvar.setStatus(Status.ATIVO);
    }

    /**
     * Get User List
     * 
     * @return List - User List
     */
    public List<Professor> getListaProfessors() {

        return listaProfessors;
    }

    /**
     * @return the professorDataModel
     */
    public ProfessorDataModel getProfessorDataModel() {
        return professorDataModel;
    }

    /**
     * @return the professor
     */
    public Professor getProfessorSalvar() {
        return professorSalvar;
    }

    /**
     * @return the professorSelecionado
     */
    public Professor getProfessorSelecionado() {
        return professorSelecionado;
    }

    /**
     * @return the professorPesquisar
     */
    public Professor getProfessorPesquisar() {
        return professorPesquisar;
    }

    /**
     * @param usurioService
     *            the usurioService to set
     */
    public void setProfessorService(GestaoProfessorImpl professorService) {
        this.professorService = professorService;
    }

    /**
     * @param professor
     *            the professor to set
     */
    public void setProfessorSalvar(Professor professor) {
        this.professorSalvar = professor;
    }

    /**
     * @param professorDataModel
     *            the professorDataModel to set
     */
    public void setProfessorDataModel(ProfessorDataModel professorDataModel) {
        this.professorDataModel = professorDataModel;
    }

    /**
     * @param professorSelecionado
     *            the professorSelecionado to set
     */
    public void setProfessorSelecionado(Professor professorSelecionado) {
        this.professorSelecionado = professorSelecionado;
    }

    public void setProfessorPesquisar(Professor professorPesquisar) {
        this.professorPesquisar = professorPesquisar;
    }
}
