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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.facet.tcc.enums.Status;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_mensalidade")
@SequenceGenerator(name = "seq_mensalidade", sequenceName = "seq_mensalidade", allocationSize = 1)
public class Mensalidade {

    private Integer id;

    private Aluno aluno;

    private Date mesReferencia;

    private Float valor;

    private Float valorPago;

    private Status status;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_mensalidade")
    @Column(name = "mensalidade_id")
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
     * @return the mesReferencia
     */
    @Temporal(TemporalType.DATE)
    @Column
    public Date getMesReferencia() {
        return mesReferencia;
    }

    /**
     * @return the valor
     */
    @Column
    public Float getValor() {
        return valor;
    }

    /**
     * @return the valorPago
     */
    @Column
    public Float getValorPago() {
        return valorPago;
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
     * @param mesReferencia
     *            the mesReferencia to set
     */
    public void setMesReferencia(Date mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    /**
     * @param valor
     *            the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @param valorPago
     *            the valorPago to set
     */
    public void setValorPago(Float valorPago) {
        this.valorPago = valorPago;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

}
