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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.HorarioDeAulas;
import br.facet.tcc.enums.Status;

/**
 * @author Osnir F CUNHA
 * 
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_turma")
@SequenceGenerator(name = "seq_turma", sequenceName = "seq_turma", allocationSize = 1)
public class Turma implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -934449391778826834L;

    private Integer id;

    private Professor professor;

    private Disciplina disciplina;

    private Status status;

    private List<Aluno> alunos;

    private HorarioDeAulas horarioDeAulas;

    private String ano;

    @Enumerated(EnumType.STRING)
    @Column
    public HorarioDeAulas getHorarioDeAulas() {
        return horarioDeAulas;
    }

    @Column
    public String getAno() {
        return ano;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "turma_id")
    @GeneratedValue(generator = "seq_turma")
    @Searchable
    public Integer getId() {
        return id;
    }

    /**
     * @return the professor
     */
    @ManyToOne
    @JoinColumn(name = "professor_id")
    @Searchable(innerSearch = true)
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @return the disciplina
     */
    @OneToOne
    @JoinColumn(name = "disciplina_id")
    @Searchable(innerSearch = true)
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @return the status
     */
    @Enumerated(EnumType.STRING)
    @Column
    @Searchable
    public Status getStatus() {
        return status;
    }

    /**
     * @return the alunos
     */
    @ManyToMany
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setHorarioDeAulas(HorarioDeAulas horarioDeAulas) {
        this.horarioDeAulas = horarioDeAulas;
    }

    public void setAno(String ano) {
        this.ano = ano;
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
     * @param disciplina
     *            the disciplina to set
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param alunos
     *            the alunos to set
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object obj) {
        Integer id = ((Turma) obj).getId();
        return this.id.equals(id);
    }

    @Override
    public String toString() {
        String disciplina = "";
        String professor = "";

        if (this.disciplina != null) {
            disciplina = this.disciplina.getNome();
        }
        if (this.professor != null) {
            professor = this.professor.getNome();
        }
        return disciplina + " - " + professor;
    }
}
