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
import javax.persistence.OneToMany;
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
@Table(name = "tb_disciplina")
@SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina", allocationSize = 1)
public class Disciplina {

    private Integer id;

    private String nome;

    private Integer cargaHoraria;

    private Status status;

    private List<Disciplina> requisitos;

    private Integer periodo;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_disciplina")
    public Integer getId() {
        return id;
    }

    /**
     * @return the nome
     */
    @Column
    public String getNome() {
        return nome;
    }

    /**
     * @return the cargaHoraria
     */
    @Column
    public Integer getCargaHoraria() {
        return cargaHoraria;
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
     * @return the requisitos
     */
    @OneToMany
    @JoinColumn(name = "disciplina_requisitos")
    public List<Disciplina> getRequisitos() {
        return requisitos;
    }

    /**
     * @return the periodo
     */
    @Column
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
    public void setRequisitos(List<Disciplina> requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * @param periodo
     *            the periodo to set
     */
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
