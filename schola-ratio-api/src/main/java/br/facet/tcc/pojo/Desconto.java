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
package br.facet.tcc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.Status;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
@Entity
@Table(name = "tb_desconto")
@SequenceGenerator(name = "seq_desconto", sequenceName = "seq_desconto", allocationSize = 1)
public class Desconto {

    private Integer id;

    private String tipoDesconto;

    private Status status;

    private Float valorDesconto;

    private Aluno aluno;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_desconto")
    @Column(name = "desconto_id")
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
     * @return the tipoDesconto
     */
    @Column
    public String getTipoDesconto() {
        return tipoDesconto;
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
     * @return the valorDesconto
     */
    @Column
    public Float getValorDesconto() {
        return valorDesconto;
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
     * @param tipoDesconto
     *            the tipoDesconto to set
     */
    public void setTipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param valorDesconto
     *            the valorDesconto to set
     */
    public void setValorDesconto(Float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

}
