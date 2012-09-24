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
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public enum Sexo {

    M("Masculino"), F("Feminino");

    private String genero;

    /**
     * @since 0.0.1
     */
    private Sexo(String genero) {
        this.genero = genero;
    }

    /**
     * @see java.lang.Enum#toString()
     * @since since optional
     */
    @Override
    public String toString() {
        return this.genero;
    }
}
