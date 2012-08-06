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
public enum Status {

    ATIVO(1), INATIVO(2);

    private int codigo;

    /**
     * @param codigo
     *            Valor que sera armazenado para definir o Status
     * @since 0.0.1
     */
    private Status(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Converte um codigo inteiro para um Enum do tipo Status.
     * 
     * @param codigo
     *            valor armazenado que representa um Status.
     * @return Constante enum para o codigo passado.
     * @since 0.0.1
     */
    public static Status fromInt(int codigo) {
        switch (codigo) {
        case 1:
            return ATIVO;
        case 2:
            return INATIVO;

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
