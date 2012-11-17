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

import br.facet.tcc.enums.SituacaoAlunoCurso;
import br.facet.tcc.enums.Status;
import br.facet.tcc.enums.UserRoles;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAlunoCursoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.2
 * @since 01 SEP 2012
 */
@ManagedBean(name = "alunoMB")
@ViewScoped
public class AlunoCursoManagedBean extends ConstantsMB implements Serializable {

    private static final Logger log = Logger
            .getLogger(AlunoCursoManagedBean.class);

    private static final long serialVersionUID = 1L;

    @ManagedProperty("#{alunoCursoService}")
    private GestaoAlunoCursoImpl alunoService;

    private List<AlunoCurso> listaAlunos;

    private AlunoCurso alunoSalvar;

    private AlunoCurso alunoPesquisar = new AlunoCurso();

    private AlunoCurso alunoSelecionado;

    private List<Curso> cursos;

    public AlunoCursoManagedBean() {
        this.listaAlunos = new ArrayList<AlunoCurso>();

        this.reset();
    }

    /**
     * Add User
     * 
     * @return String - Response Message
     */
    public String salvarAluno() {
        try {

            List<br.facet.tcc.pojo.UserRoles> permissoes = new ArrayList<br.facet.tcc.pojo.UserRoles>();
            br.facet.tcc.pojo.UserRoles roles = new br.facet.tcc.pojo.UserRoles();
            roles.setUserRole(UserRoles.ROLE_ALU);
            permissoes.add(roles);
            this.alunoSalvar.getAluno().getUserLogin()
                    .setPermissoes(permissoes);

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
                            + this.alunoSelecionado.getId());
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

        listaAlunos = new ArrayList<AlunoCurso>();
        if ("".equals(alunoPesquisar.getAluno().getNome())) {
            alunoPesquisar.getAluno().setNome(null);
        }
        if (alunoPesquisar.getAluno().getCpf() == 0) {
            alunoPesquisar.getAluno().setCpf(null);
        }
        if ("".equals(alunoPesquisar.getAluno().getUserLogin().getUsername())) {
            alunoPesquisar.getAluno().setUserLogin(null);
        }

        try {
            listaAlunos = alunoService.consultarUsuario(alunoPesquisar);
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
            this.alunoSelecionado.getAluno().setStatus(Status.INATIVO);
            this.alunoService.alterarUsuario(alunoSelecionado);
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

    public void postProcessXLS(Object document) {
        this.processarXLS(document, "Alunos");
    }

    /**
     * Reset Fields
     * 
     */
    public void reset() {
        alunoSalvar = new AlunoCurso();
        alunoSalvar.setAluno(new Aluno());
        alunoSalvar.getAluno().setUserLogin(new UserLogin());
        alunoSalvar.getAluno().setStatus(Status.ATIVO);
        alunoSalvar.setSituacaoAlunoCurso(SituacaoAlunoCurso.CADASTRADO);

        alunoPesquisar = new AlunoCurso();
        alunoPesquisar.setAluno(new Aluno());
        alunoPesquisar.getAluno().setUserLogin(new UserLogin());

    }

    /**
     * @return the alunoService
     */
    public GestaoAlunoCursoImpl getAlunoService() {
        return alunoService;
    }

    /**
     * @return the listaAlunos
     */
    public List<AlunoCurso> getListaAlunos() {
        return listaAlunos;
    }

    /**
     * @return the alunoSalvar
     */
    public AlunoCurso getAlunoSalvar() {
        return alunoSalvar;
    }

    /**
     * @return the alunoPesquisar
     */
    public AlunoCurso getAlunoPesquisar() {
        return alunoPesquisar;
    }

    /**
     * @return the alunoSelecionado
     */
    public AlunoCurso getAlunoSelecionado() {
        return alunoSelecionado;
    }

    /**
     * @param alunoService
     *            the alunoService to set
     */
    public void setAlunoService(GestaoAlunoCursoImpl alunoService) {
        this.alunoService = alunoService;
    }

    /**
     * @param listaAlunos
     *            the listaAlunos to set
     */
    public void setListaAlunos(List<AlunoCurso> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    /**
     * @param alunoSalvar
     *            the alunoSalvar to set
     */
    public void setAlunoSalvar(AlunoCurso alunoSalvar) {
        this.alunoSalvar = alunoSalvar;
    }

    /**
     * @param alunoSelecionado
     *            the alunoSelecionado to set
     */
    public void setAlunoSelecionado(AlunoCurso alunoSelecionado) {
        this.alunoSelecionado = alunoSelecionado;
    }

    /**
     * @return the cursos
     */
    public List<Curso> getCursos() {
        return cursos;
    }

    /**
     * @param cursos
     *            the cursos to set
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}
