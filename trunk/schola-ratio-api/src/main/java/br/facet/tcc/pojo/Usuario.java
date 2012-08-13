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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {

    private Integer id;

    private Integer nome;

    private Integer nacionalidade;

    private Integer naturalidade;

    private Integer cpf;

    private Integer email;

    private Integer rg;

    private Integer orgaoExpeditor;

    private Integer ufOrgaoExpeditor;

    private Integer dataExpedicao;

    private Integer nomePai;

    private Integer nomeMae;

    private Integer senha;

    private Status status;

    private Endereco endereco;

    private Sexo sexo;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(generator = "seq_usuario")
    public Integer getId() {
        return id;
    }

    /**
     * @return the nome
     */
    @Column
    public Integer getNome() {
        return nome;
    }

    /**
     * @return the nacionalidade
     */
    @Column
    public Integer getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @return the naturalidade
     */
    @Column
    public Integer getNaturalidade() {
        return naturalidade;
    }

    /**
     * @return the cpf
     */
    @Column
    public Integer getCpf() {
        return cpf;
    }

    /**
     * @return the email
     */
    @Column
    public Integer getEmail() {
        return email;
    }

    /**
     * @return the rg
     */
    @Column
    public Integer getRg() {
        return rg;
    }

    /**
     * @return the orgaoExpeditor
     */
    @Column
    public Integer getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    /**
     * @return the ufOrgaoExpeditor
     */
    @Column
    public Integer getUfOrgaoExpeditor() {
        return ufOrgaoExpeditor;
    }

    /**
     * @return the dataExpedicao
     */
    @Column
    public Integer getDataExpedicao() {
        return dataExpedicao;
    }

    /**
     * @return the nomePai
     */
    @Column
    public Integer getNomePai() {
        return nomePai;
    }

    /**
     * @return the nomeMae
     */
    @Column
    public Integer getNomeMae() {
        return nomeMae;
    }

    /**
     * @return the senha
     */
    @Column
    public Integer getSenha() {
        return senha;
    }

    /**
     * @return the status
     */
    @Column
    public Status getStatus() {
        return status;
    }

    /**
     * @return the endereco
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_usuario")
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @return the sexo
     */
    @Enumerated(EnumType.STRING)
    @Column
    public Sexo getSexo() {
        return sexo;
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
    public void setNome(Integer nome) {
        this.nome = nome;
    }

    /**
     * @param nacionalidade
     *            the nacionalidade to set
     */
    public void setNacionalidade(Integer nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @param naturalidade
     *            the naturalidade to set
     */
    public void setNaturalidade(Integer naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * @param cpf
     *            the cpf to set
     */
    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(Integer email) {
        this.email = email;
    }

    /**
     * @param rg
     *            the rg to set
     */
    public void setRg(Integer rg) {
        this.rg = rg;
    }

    /**
     * @param orgaoExpeditor
     *            the orgaoExpeditor to set
     */
    public void setOrgaoExpeditor(Integer orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    /**
     * @param ufOrgaoExpeditor
     *            the ufOrgaoExpeditor to set
     */
    public void setUfOrgaoExpeditor(Integer ufOrgaoExpeditor) {
        this.ufOrgaoExpeditor = ufOrgaoExpeditor;
    }

    /**
     * @param dataExpedicao
     *            the dataExpedicao to set
     */
    public void setDataExpedicao(Integer dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    /**
     * @param nomePai
     *            the nomePai to set
     */
    public void setNomePai(Integer nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @param nomeMae
     *            the nomeMae to set
     */
    public void setNomeMae(Integer nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @param senha
     *            the senha to set
     */
    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param endereco
     *            the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @param sexo
     *            the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

}
