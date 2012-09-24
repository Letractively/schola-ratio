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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.Estado;

/**
 * @author Osnir F CUNHA
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_endereco")
@SequenceGenerator(sequenceName = "seq_endereco", name = "seq_endereco", allocationSize = 1)
public class Endereco implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9151813768097067999L;

    private Integer id;

    /**
     * 
     */
    private String rua;

    /**
     * 
     */
    private Integer numero;

    /**
     * 
     */
    private String bairro;

    /**
     * 
     */
    private String complemento;

    /**
     * 
     */
    private Integer cep;

    /**
     * 
     */
    private String cidade;

    /**
     * 
     */
    private Estado estado;

    /**
     * @return the id
     */
    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(generator = "seq_endereco")
    public Integer getId() {
        return id;
    }

    /**
     * @return the rua
     */
    @Column(name = "rua")
    @Searchable
    public String getRua() {
        return rua;
    }

    /**
     * @return the numero
     */
    @Column(name = "numero")
    public Integer getNumero() {
        return numero;
    }

    /**
     * @return the bairro
     */
    @Column(name = "bairro")
    @Searchable
    public String getBairro() {
        return bairro;
    }

    /**
     * @return the complemento
     */
    @Column(name = "complemento")
    public String getComplemento() {
        return complemento;
    }

    /**
     * @return the cep
     */
    @Column(name = "cep")
    @Searchable
    public Integer getCep() {
        return cep;
    }

    /**
     * @return the cidade
     */
    @Column(name = "cidade")
    @Searchable
    public String getCidade() {
        return cidade;
    }

    /**
     * @return the estado
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    @Searchable
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param rua
     *            the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @param numero
     *            the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @param bairro
     *            the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @param complemento
     *            the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @param cep
     *            the cep to set
     */
    public void setCep(Integer cep) {
        this.cep = cep;
    }

    /**
     * @param cidade
     *            the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @param estado
     *            the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}