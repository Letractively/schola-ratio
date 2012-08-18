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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_avaliacao_aluno")
@SequenceGenerator(name = "seq_avaliacao_aluno", sequenceName = "seq_avaliacao_aluno", allocationSize = 1)
public class AvaliacaoDeAluno {

    private Integer id;

    private Aluno aluno;

    private Avaliacao avaliacao;

    private Turma turma;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_avaliacao_aluno")
    @Column(name = "avaliacao_aluno_id")
    public Integer getId() {
        return id;
    }

    /**
     * @return the aluno
     */
    @OneToOne
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the avaliacao
     */
    @OneToOne
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    /**
     * @return the turma
     */
    @OneToOne
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param aluno
     *            the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @param avaliacao
     *            the avaliacao to set
     */
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    /**
     * @param turma
     *            the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
