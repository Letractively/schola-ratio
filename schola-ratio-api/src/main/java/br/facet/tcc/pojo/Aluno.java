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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_aluno")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "ID")),
    @AttributeOverride(name = "cpf", column = @Column(name = "CPF")),
    @AttributeOverride(name = "dataexpedicao", column = @Column(name = "DATAEXPEDICAO")),
    @AttributeOverride(name = "email", column = @Column(name = "EMAIL")),
    @AttributeOverride(name = "nacionalidade", column = @Column(name = "NACIONALIDADE")),
    @AttributeOverride(name = "naturalidade", column = @Column(name = "NATURALIDADE")),
    @AttributeOverride(name = "nome", column = @Column(name = "NOME")),
    @AttributeOverride(name = "nomemae", column = @Column(name = "NOMEMAE")),
    @AttributeOverride(name = "nomepai", column = @Column(name = "NOMEPAI")),
    @AttributeOverride(name = "orgaoexpeditor", column = @Column(name = "ORGAOEXPEDITOR")),
    @AttributeOverride(name = "rg", column = @Column(name = "RG")),
    @AttributeOverride(name = "senha", column = @Column(name = "SENHA")),
    @AttributeOverride(name = "sexo", column = @Column(name = "SEXO")),
    @AttributeOverride(name = "status", column = @Column(name = "STATUS")),
    @AttributeOverride(name = "uforgaoexpeditor", column = @Column(name = "UFORGAOEXPEDITOR")),
    @AttributeOverride(name = "endereco_usuario", column = @Column(name = "ENDERECO_USUARIO"))})
public class Aluno extends Usuario {

    private Date dataDeMatricula;

    /**
     * @return the dataDeMatricula
     */
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
