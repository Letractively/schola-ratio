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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.Status;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_curso")
@SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso", allocationSize = 1)
public class Curso {

    private Integer id;

    private Instituicao instituicao;

    private String nome;

    private Integer duracao;

    private Status status;

    private List<Disciplina> disciplina;

    /**
     * @return the id
     */
    @Id
    @Column(name = "curso_id")
    @GeneratedValue(generator = "seq_curso")
    public Integer getId() {
        return id;
    }

    /**
     * @return the instituicao
     */
    @ManyToOne
    @JoinColumn(name = "instituicao_id")
    public Instituicao getInstituicao() {
        return instituicao;
    }

    /**
     * @return the nome
     */
    @Column
    public String getNome() {
        return nome;
    }

    /**
     * @return the duracao
     */
    @Column
    public Integer getDuracao() {
        return duracao;
    }

    /**
     * @return the status
     */
    @Enumerated(EnumType.STRING)
    @Column
    public Status getStatus() {
        return status;
    }

    /**
     * @return the disciplina
     */
    @ManyToMany
    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param instituicao
     *            the instituicao to set
     */
    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param duracao
     *            the duracao to set
     */
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param disciplina
     *            the disciplina to set
     */
    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

}
