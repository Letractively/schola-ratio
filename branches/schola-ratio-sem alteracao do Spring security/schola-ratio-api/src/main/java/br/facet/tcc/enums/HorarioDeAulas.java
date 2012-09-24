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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_horario_aulas")
public enum HorarioDeAulas {
    SEGUNDA_PRIMEIRO_HORARIO, SEGUNDA_SEGUNDO_HORARIO, TERCA_PRIMEIRO_HORARIO, TERCA_SEGUNDO_HORARIO, QUARTA_PRIMEIRO_HORARIO, QUARTA_SEGUNDO_HORARIO, QUINTA_PRIMEIRO_HORARIO, QUINTA_SEGUNDO_HORARIO, SEXTA_PRIMEIRO_HORARIO, SEXTA_SEGUNDO_HORARIO;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column
    private String value;

    private HorarioDeAulas() {
        this.value = this.toString();
    }
}
