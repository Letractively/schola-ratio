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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.Bimestre;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_avaliacao")
@SequenceGenerator(name = "seq_avaliacao", sequenceName = "seq_avaliacao", allocationSize = 1)
public class Avaliacao {

    private Integer id;

    private Float nota;

    private Integer frequencia;

    private Bimestre bimestre;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_avaliacao")
    public Integer getId() {
        return id;
    }

    /**
     * @return the resultado
     */
    @Column
    public Float getNota() {
        return nota;
    }

    /**
     * @return the peso
     */
    @Column
    public Integer getFrequencia() {
        return frequencia;
    }

    /**
     * @return the bimestre
     */
    @Enumerated(EnumType.STRING)
    @Column
    public Bimestre getBimestre() {
        return bimestre;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param nota
     *            the nota to set
     */
    public void setNota(Float nota) {
        this.nota = nota;
    }

    /**
     * @param peso
     *            the peso to set
     */
    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    /**
     * @param bimestre
     *            the bimestre to set
     */
    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

}
