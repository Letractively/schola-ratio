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
package br.facet.tcc.enums;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public enum Situacao {

    APROVADO(1), REPROVADO(2);

    private int codigo;

    /**
     * Construtor unico e privado que cria uma enum Situação apartir de um
     * codigo.
     * 
     * @param codigo
     *            Valor que sera armazenado para definir o Status
     * @since 0.0.1
     */
    private Situacao(int codigo) {
        this.codigo = codigo;
    }

    public static Situacao fromInt(int codigo) {
        switch (codigo) {
        case 1:
            return APROVADO;
        case 2:
            return REPROVADO;
        default:
            return null;
        }
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

}