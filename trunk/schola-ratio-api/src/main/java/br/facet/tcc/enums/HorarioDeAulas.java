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

public enum HorarioDeAulas {
    SEGUNDA_PRIMEIRO_HORARIO(1), SEGUNDA_SEGUNDO_HORARIO(2), TERCA_PRIMEIRO_HORARIO(
            3), TERCA_SEGUNDO_HORARIO(4), QUARTA_PRIMEIRO_HORARIO(5), QUARTA_SEGUNDO_HORARIO(
            6), QUINTA_PRIMEIRO_HORARIO(7), QUINTA_SEGUNDO_HORARIO(8), SEXTA_PRIMEIRO_HORARIO(
            9), SEXTA_SEGUNDO_HORARIO(10);

    private int id;

    private String value;

    private HorarioDeAulas(Integer id) {
        this.id = id;
        this.value = this.name();
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
