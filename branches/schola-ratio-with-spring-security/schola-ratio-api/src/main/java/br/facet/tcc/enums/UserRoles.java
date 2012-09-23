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
package br.facet.tcc.enums;

/**
 * Define as roles que serão utilizadas para controle de acesso.
 * 
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public enum UserRoles {

    /**
     * Academico
     */
    ROLE_ACA(1, "Academico"),

    /**
     * Administrativo
     */
    ROLE_ADM(2, "Adminsitrativo"),

    /**
     * Configuração
     */
    ROLE_CFG(3, "Configurações"),

    /**
     * Financeiro
     */
    ROLE_FIN(4, " Financeiro"),

    /**
     * Usuarios
     */
    ROLE_USR(5, "Usuario");

    private int id;

    private String descricao;

    private UserRoles(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
