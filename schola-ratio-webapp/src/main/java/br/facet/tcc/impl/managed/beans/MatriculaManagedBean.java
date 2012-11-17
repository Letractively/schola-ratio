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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.facet.tcc.impl.service.GestaoAdministrativoImpl;
import br.facet.tcc.impl.service.GestaoUsuarioImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Turma;

/**
 * @author Osnir F CUNHA
 * 
 */
@ManagedBean(name = "matriculaMB")
@ViewScoped
public class MatriculaManagedBean extends ConstantsMB implements Serializable {

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    @ManagedProperty("#{usurioService}")
    private GestaoUsuarioImpl usurioService;

    private Aluno aluno;

    private List<Turma> turmas;

    public List<Aluno> completeDisciplina(String query) {
        List<Aluno> suggestions = new ArrayList<Aluno>();

        Aluno aluno = new Aluno();
        aluno.setNome(query);

        // suggestions = this.usurioService.consultarUsuario(suggestions);

        return suggestions;
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
     * @return the aluno
     */
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the turmas
     */
    public List<Turma> getTurmas() {
        return turmas;
    }

    /**
     * @param usurioService
     *            the usurioService to set
     */
    public void setUsurioService(GestaoUsuarioImpl usurioService) {
        this.usurioService = usurioService;
    }

    /**
     * @param aluno
     *            the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @param turmas
     *            the turmas to set
     */
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

}
