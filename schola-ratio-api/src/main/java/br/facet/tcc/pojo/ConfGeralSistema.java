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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.Status;

/**
 * @author TODO: Djulles IKEDA
 * 
 * @version TODO: 0.0.2
 * @since TODO: 0.0.2
 */

@Entity
@Table(name = "tb_confGeraisSistema")
@SequenceGenerator(name = "seq_confGeraisSistema", sequenceName = "seq_confGeraisSistema", allocationSize = 1)
public class ConfGeralSistema implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer anoReferencia;

    private Float valorMensalidade;

    private Integer notaPassarDireto;

    private Integer notaReprovarDireto;

    private Integer notaRecuperacao;

    private Integer notaPassarRecuperacao;

    private Integer percentualReprovarFalta;

    private Status status;

    /**
     * @return the id
     */
    @Id
    @Column(name = "curso_id")
    @GeneratedValue(generator = "seq_confGeraisSistema")
    @Searchable
    public Integer getId() {
        return id;
    }

    /**
     * @return the valorMensalidade
     */

    @Column
    @Searchable
    public Float getValorMensalidade() {
        return valorMensalidade;
    }

    /**
     * @return the notaPassarDireto
     */
    @Column
    @Searchable
    public Integer getNotaPassarDireto() {
        return notaPassarDireto;
    }

    /**
     * @return the notaReprovarDireto
     */
    @Column
    @Searchable
    public Integer getNotaReprovarDireto() {
        return notaReprovarDireto;
    }

    /**
     * @return the notaRecuperacao
     */
    @Column
    @Searchable
    public Integer getNotaRecuperacao() {
        return notaRecuperacao;
    }

    /**
     * @return the notaPassarRecuperacao
     */
    @Column
    @Searchable
    public Integer getNotaPassarRecuperacao() {
        return notaPassarRecuperacao;
    }

    /**
     * @return the percentualReprovarFalta
     */
    @Column
    @Searchable
    public Integer getPercentualReprovarFalta() {
        return percentualReprovarFalta;
    }

    @Column
    @Searchable
    public Integer getAnoReferencia() {
        return anoReferencia;
    }

    @Enumerated(EnumType.STRING)
    @Column
    @Searchable
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
     * @param valorMensalidade
     *            the valorMensalidade to set
     */
    public void setValorMensalidade(Float valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    /**
     * @param notaPassarDireto
     *            the notaPassarDireto to set
     */
    public void setNotaPassarDireto(Integer notaPassarDireto) {
        this.notaPassarDireto = notaPassarDireto;
    }

    /**
     * @param notaReprovarDireto
     *            the notaReprovarDireto to set
     */
    public void setNotaReprovarDireto(Integer notaReprovarDireto) {
        this.notaReprovarDireto = notaReprovarDireto;
    }

    /**
     * @param notaRecuperacao
     *            the notaRecuperacao to set
     */
    public void setNotaRecuperacao(Integer notaRecuperacao) {
        this.notaRecuperacao = notaRecuperacao;
    }

    /**
     * @param notaPassarRecuperacao
     *            the notaPassarRecuperacao to set
     */
    public void setNotaPassarRecuperacao(Integer notaPassarRecuperacao) {
        this.notaPassarRecuperacao = notaPassarRecuperacao;
    }

    /**
     * @param percentualReprovarFalta
     *            the percentualReprovarFalta to set
     */
    public void setPercentualReprovarFalta(Integer percentualReprovarFalta) {
        this.percentualReprovarFalta = percentualReprovarFalta;
    }

    public void setAnoReferencia(Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
