/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 * 
 * Copyright (c) 2012 All rights reserved.
 * 
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written
 * 
 * 
 * (Code Template Version: 1.0)
 */
package br.facet.tcc.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.Situacao;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_situacao_aluno_turma")
@SequenceGenerator(name = "seq_situacao_aluno_turma", sequenceName = "seq_situacao_aluno_turma", allocationSize = 1)
public class SituacaoDoAlunoNaTurma implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2518287049513011103L;

    private Integer id;

    private Turma turma;

    private Aluno aluno;

    private Situacao situacao;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_situacao_aluno_turma")
    @Column(name = "situacao_aluno_turma_id")
    public Integer getId() {
        return id;
    }

    /**
     * @return the turma
     */
    @OneToOne
    public Turma getTurma() {
        return turma;
    }

    /**
     * @return the aluno
     */
    @OneToOne
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the situacao
     */
    @Enumerated(EnumType.STRING)
    @Column
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param turma
     *            the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    /**
     * @param aluno
     *            the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @param situacao
     *            the situacao to set
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

}
