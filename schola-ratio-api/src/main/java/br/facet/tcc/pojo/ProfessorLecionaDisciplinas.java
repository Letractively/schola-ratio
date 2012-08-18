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

import br.facet.tcc.enums.Status;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "tb_professor_leciona_disciplinas")
@SequenceGenerator(sequenceName = "seq_professor_leciona_disciplinas", name = "seq_professor_leciona_disciplinas", allocationSize = 1)
public class ProfessorLecionaDisciplinas {

    private Integer id;

    private Professor professor;

    private List<Disciplina> disciplinas;

    private Status status;

    /**
     * @return the id
     */

    @Id
    @GeneratedValue(generator = "seq_professor_leciona_disciplinas")
    @Column(name = "professor_leciona_disciplinas_id")
    public Integer getId() {
        return id;
    }

    /**
     * @return the professor
     */

    @OneToOne
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

}
