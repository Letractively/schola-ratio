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
package br.facet.tcc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.HorarioDeAulas;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.2
 */
@Entity
@Table(name = "tb_horario_aulas")
@SequenceGenerator(sequenceName = "seq_horario_aulas", name = "seq_horario_aulas", initialValue = 1)
public class HorarioDeAula {

    private Integer id;

    private HorarioDeAulas horarioDeAulas;

    public HorarioDeAula() {
    }

    public HorarioDeAula(HorarioDeAulas horarioDeAulas) {
        this.id = horarioDeAulas.getId();
        this.horarioDeAulas = horarioDeAulas;
    }

    /**
     * @return the id
     */
    @Id
    public Integer getId() {
        return this.horarioDeAulas.getId();
    }

    /**
     * @return the horarioDeAulas
     */
    @Enumerated(EnumType.STRING)
    @Column
    public HorarioDeAulas getHorarioDeAulas() {
        return horarioDeAulas;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param horarioDeAulas
     *            the horarioDeAulas to set
     */
    public void setHorarioDeAulas(HorarioDeAulas horarioDeAulas) {
        this.horarioDeAulas = horarioDeAulas;
    }

    @Override
    public boolean equals(Object obj) {
        HorarioDeAula roles = (HorarioDeAula) obj;
        return this.getHorarioDeAulas().getId() == roles.getId();
    }
}
