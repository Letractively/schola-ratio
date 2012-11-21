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

import br.facet.tcc.annotations.Searchable;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_aluno")
@SequenceGenerator(sequenceName = "seq_aluno", name = "seq_aluno", allocationSize = 1)
public class Aluno extends Pessoa implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4557294267620477230L;

    private Integer id;

    private Date dataDeMatricula;

    /**
     * @see br.facet.tcc.pojo.Pessoa#getId()
     * @since since optional
     */
    @Id
    @Column(name = "aluno_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
    @Searchable
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the dataDeMatricula
     */
    @Temporal(TemporalType.DATE)
    @Column
    @Searchable
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

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        Integer id = ((Aluno) obj).getId();
        boolean result = this.getId().equals(id);
        return result;
    }
}
