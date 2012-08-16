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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_aluno")
@SequenceGenerator(sequenceName = "seq_aluno", name = "seq_aluno", allocationSize = 1)
public class Aluno extends Pessoa {

    private Date dataDeMatricula;

    /**
     * @see br.facet.tcc.pojo.Pessoa#getId()
     * @since since optional
     */
    @Override
    @Id
    @Column(name = "aluno_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the dataDeMatricula
     */
    @Temporal(TemporalType.DATE)
    @Column
    public Date getDataDeMatricula() {
        return dataDeMatricula;
    }

    /**
     * @param dataDeMatricula
     *            the dataDeMatricula to set
     */
    public void setDataDeMatricula(Date dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }
}