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

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.HorarioDeAulas;
import br.facet.tcc.enums.Status;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "tb_disponibilidade_professor")
@SequenceGenerator(sequenceName = "seq_disponibilidade_professor", name = "seq_disponibilidade_professor", allocationSize = 1)
public class DisponibilidadeDoProfessor implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -711215748016024891L;

    private Integer id;

    private Professor professor;

    private List<Disciplina> disciplinas;

    private List<HorarioDeAulas> horarioDisponivel;

    private Status status;

    /**
     * @return the id
     */

    @Id
    @GeneratedValue(generator = "seq_disponibilidade_professor")
    @Column(name = "disponibilidade_professor_id")
    public Integer getId() {
        return id;
    }

    /**
     * @return the professor
     */

    @OneToOne
    @Searchable
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @return the disciplinas
     */
    @ManyToMany
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
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
     * @return the horarioDisponivel
     */
    @ManyToMany
    public List<HorarioDeAulas> getHorarioDisponivel() {
        return horarioDisponivel;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param professor
     *            the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @param disciplinas
     *            the disciplinas to set
     */
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param horarioDisponivel
     *            the horarioDisponivel to set
     */
    public void setHorarioDisponivel(List<HorarioDeAulas> horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

}
