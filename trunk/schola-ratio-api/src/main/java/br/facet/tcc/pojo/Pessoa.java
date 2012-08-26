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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@MappedSuperclass
public abstract class Pessoa {

    private String nome;

    private String nacionalidade;

    private String naturalidade;

    private Long cpf;

    private String email;

    private Long rg;

    private String orgaoExpeditor;

    private Estado ufOrgaoExpeditor;

    private Date dataExpedicao;

    private String nomePai;

    private String nomeMae;

    private UserLogin userLogin;

    private Status status;

    private Endereco endereco;

    private Sexo sexo;

    private byte[] image;

    /**
     * @return the nome
     */
    @Column
    public String getNome() {
        return nome;
    }

    /**
     * @return the nacionalidade
     */
    @Column
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * @return the naturalidade
     */
    @Column
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * @return the cpf
     */
    @Column
    public Long getCpf() {
        return cpf;
    }

    /**
     * @return the email
     */
    @Column
    public String getEmail() {
        return email;
    }

    /**
     * @return the rg
     */
    @Column
    public Long getRg() {
        return rg;
    }

    /**
     * @return the orgaoExpeditor
     */
    @Column
    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    /**
     * @return the ufOrgaoExpeditor
     */
    @Enumerated(EnumType.STRING)
    @Column
    public Estado getUfOrgaoExpeditor() {
        return ufOrgaoExpeditor;
    }

    /**
     * @return the dataExpedicao
     */
    @Temporal(TemporalType.DATE)
    @Column
    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    /**
     * @return the nomePai
     */
    @Column
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @return the nomeMae
     */
    @Column
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @return the status
     */
    @Column
    @Enumerated(EnumType.STRING)
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
     * @return the image
     */
    @Column
    public byte[] getImage() {
        return image;
    }

    /**
     * @return the userLogin
     */
    @OneToOne
    @JoinColumn(name = "user_name")
    public UserLogin getUserLogin() {
        return userLogin;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param nacionalidade
     *            the nacionalidade to set
     */
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    /**
     * @param naturalidade
     *            the naturalidade to set
     */
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    /**
     * @param cpf
     *            the cpf to set
     */
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param rg
     *            the rg to set
     */
    public void setRg(Long rg) {
        this.rg = rg;
    }

    /**
     * @param orgaoExpeditor
     *            the orgaoExpeditor to set
     */
    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    /**
     * @param ufOrgaoExpeditor
     *            the ufOrgaoExpeditor to set
     */
    public void setUfOrgaoExpeditor(Estado ufOrgaoExpeditor) {
        this.ufOrgaoExpeditor = ufOrgaoExpeditor;
    }

    /**
     * @param dataExpedicao
     *            the dataExpedicao to set
     */
    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    /**
     * @param nomePai
     *            the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @param nomeMae
     *            the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
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

    /**
     * @param image
     *            the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @param userLogin
     *            the userLogin to set
     */
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
}
