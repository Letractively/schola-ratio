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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.facet.tcc.enums.SituacaoAlunoCurso;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */

@Entity
@Table(name = "tb_aluno_curso")
@SequenceGenerator(name = "seq_aluno_curso", sequenceName = "seq_aluno_curso", allocationSize = 1)
public class AlunoCurso {
    private Curso curso;

    private Aluno aluno;

    private SituacaoAlunoCurso situacao;

    /**
     * @return the curso
     */
    @OneToOne
    public Curso getCurso() {
        return curso;
    }

    /**
     * @return the aluno
     */
    @OneToOne
    public Aluno getAluno() {
        return aluno;
    }

    /**
     * @return the situacao
     */
    @Column
    @Enumerated(EnumType.STRING)
    public SituacaoAlunoCurso getSituacao() {
        return situacao;
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
     * @param situacao
     *            the situacao to set
     */
    public void setSituacao(SituacaoAlunoCurso situacao) {
        this.situacao = situacao;
    }

}
