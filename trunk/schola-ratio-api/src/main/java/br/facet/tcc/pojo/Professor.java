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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.facet.tcc.enums.TipoTitulo;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_professor")
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
public class Professor extends Usuario {

    private TipoTitulo titulo;

    private String descricaoTitulo;

    /**
     * @return the titulo
     */
    @Enumerated(EnumType.STRING)
    @Column
    public TipoTitulo getTitulo() {
        return titulo;
    }

    /**
     * @return the descricaoTitulo
     */
    @Column
    public String getDescricaoTitulo() {
        return descricaoTitulo;
    }

    /**
     * @param titulo
     *            the titulo to set
     */
    public void setTitulo(TipoTitulo titulo) {
        this.titulo = titulo;
    }

    /**
     * @param descricaoTitulo
     *            the descricaoTitulo to set
     */
    public void setDescricaoTitulo(String descricaoTitulo) {
        this.descricaoTitulo = descricaoTitulo;
    }
}
