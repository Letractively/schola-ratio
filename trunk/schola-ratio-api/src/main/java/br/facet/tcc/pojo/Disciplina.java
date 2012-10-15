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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.Status;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_disciplina")
@SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina", allocationSize = 1)
public class Disciplina implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1940996532056368591L;

    private Integer id;

    private String nome;

    private Integer cargaHoraria;

    private Status status;

    private Set<Disciplina> requisitos;

    private Integer periodo;

    public Disciplina() {
        this.status = Status.ATIVO;
        this.requisitos = new HashSet<Disciplina>();
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_disciplina")
    @Searchable
    public Integer getId() {
        return id;
    }

    /**
     * @return the nome
     */
    @Column
    @Searchable
    public String getNome() {
        return nome;
    }

    /**
     * @return the cargaHoraria
     */
    @Column
    @Searchable
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @return the status
     */
    @Enumerated(EnumType.STRING)
    @Column
    @Searchable
    public Status getStatus() {
        return status;
    }

    /**
     * @return the requisitos
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @IndexColumn(name = "idx_col")
    @Fetch(FetchMode.SUBSELECT)
    public Set<Disciplina> getRequisitos() {
        return requisitos;
    }

    /**
     * @return the periodo
     */
    @Column
    @Searchable
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param cargaHoraria
     *            the cargaHoraria to set
     */
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param requisitos
     *            the requisitos to set
     */
    public void setRequisitos(Set<Disciplina> requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * @param periodo
     *            the periodo to set
     */
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        Disciplina disciplina = (Disciplina) obj;
        return this.nome.equals(disciplina.getNome());
    }
}
