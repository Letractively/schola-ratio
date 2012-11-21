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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.SituacaoAlunoCurso;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "tb_aluno_curso")
@SequenceGenerator(name = "seq_aluno_curso", sequenceName = "seq_aluno_curso", allocationSize = 1)
public class AlunoCurso implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 772832262524181415L;

    private Integer id;

    private Curso curso;

    private Aluno aluno;

    private SituacaoAlunoCurso situacaoAlunoCurso = SituacaoAlunoCurso.CURSANDO;

    public AlunoCurso() {
    }

    /**
     * @param curso
     * @param aluno
     * @param situacaoAlunoCurso
     */
    public AlunoCurso(Curso curso, Aluno aluno,
            SituacaoAlunoCurso situacaoAlunoCurso) {
        this();
        this.curso = curso;
        this.aluno = aluno;
        this.situacaoAlunoCurso = situacaoAlunoCurso;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "aluno_curso")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno_curso")
    public Integer getId() {
        return id;
    }

    /**
     * @return the curso
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Searchable(innerSearch = true)
    public Curso getCurso() {
        return curso;
    }

    /**
     * @return the aluno
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Searchable(innerSearch = true)
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the situacaoAlunoCurso
     */
    @Column
    @Enumerated(EnumType.STRING)
    @Searchable
    public SituacaoAlunoCurso getSituacaoAlunoCurso() {
        return situacaoAlunoCurso;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param curso
     *            the curso to set
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /**
     * @param aluno
     *            the aluno to set
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    /**
     * @param situacaoAlunoCurso
     *            the situacaoAlunoCurso to set
     */
    public void setSituacaoAlunoCurso(SituacaoAlunoCurso situacaoAlunoCurso) {
        this.situacaoAlunoCurso = situacaoAlunoCurso;
    }

    @Override
    public boolean equals(Object obj) {

        AlunoCurso alunoCurso = (AlunoCurso) obj;

        return this.getId().equals(alunoCurso.getId());
    }
}
