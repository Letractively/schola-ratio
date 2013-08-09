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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;

/**
 * <code>Instituicao</code><br>
 * Modela uma instituição e seus atributos.
 * 
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_instituicao")
@SequenceGenerator(sequenceName = "seq_instituicao", name = "seq_instituicao", allocationSize = 1)
public class Instituicao implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -135831804467799660L;

    private Integer id;

    private String nome;

    private Long cnpj;

    private Integer inscricaoEstadual;

    private Endereco endereco;

    private String email;

    private Integer telefone;

    public Instituicao() {
        this.endereco = new Endereco();
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "id_instituicao")
    @GeneratedValue(generator = "seq_instituicao", strategy = GenerationType.SEQUENCE)
    @Searchable
    public Integer getId() {
        return id;
    }

    /**
     * @return the nome
     */
    @Column(name = "nome_instituicao")
    @Searchable
    public String getNome() {
        return nome;
    }

    /**
     * @return the cnpj
     */
    @Column(name = "cnpj")
    @Searchable
    public Long getCnpj() {
        return cnpj;
    }

    /**
     * @return the inscricaoEstadual
     */
    @Column(name = "inscricao_estadual")
    @Searchable
    public Integer getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * @return the endereco
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_instituicao")
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @return the email
     */
    @Column(name = "email_instituicao")
    public String getEmail() {
        return email;
    }

    /**
     * @return the telefone
     */
    @Column(name = "telefone_instituicao")
    public Integer getTelefone() {
        return telefone;
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
     * @param cnpj
     *            the cnpj to set
     */
    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @param inscricaoEstadual
     *            the inscricaoEstadual to set
     */
    public void setInscricaoEstadual(Integer inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    /**
     * @param endereco
     *            the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param telefone
     *            the telefone to set
     */
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

}
