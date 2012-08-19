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
package br.facet.tcc.impl.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.SituacaoAlunoCurso;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;
import br.facet.tcc.pojo.Curso;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public class AlunoCursoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() {

        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setAluno(this.getAlunoDao().listar(Aluno.class).get(0));
        alunoCurso.setCurso(this.getCursoDao().listar(Curso.class).get(0));
        alunoCurso.setSituacaoAlunoCurso(SituacaoAlunoCurso.CURSANDO);

        Integer codigo = this.getAlunoCursoDao().salvar(alunoCurso);
        Assert.assertTrue("alunoCurso nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() {
        AlunoCurso alunoCurso = this.getAlunoCursoDao()
                .listar(AlunoCurso.class).get(0);
        SituacaoAlunoCurso expected = alunoCurso.getSituacaoAlunoCurso();
        alunoCurso.setSituacaoAlunoCurso(SituacaoAlunoCurso.CONCLUIDO);
        this.getAlunoCursoDao().atualizar(alunoCurso);
        SituacaoAlunoCurso actual = alunoCurso.getSituacaoAlunoCurso();
        Assert.assertNotSame("Cursos são diferentes", expected, actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}.
     */
    @Test
    public final void testExcluir() {
        int unexpected = this.getAlunoCursoDao().listar(AlunoCurso.class)
                .size();
        AlunoCurso curso = this.getAlunoCursoDao().listar(AlunoCurso.class)
                .get(0);
        this.getAlunoCursoDao().excluir(curso);
        int actual = this.getCursoDao().listar(AlunoCurso.class).size();
        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() {
        List<AlunoCurso> alunoCursos = this.getAlunoCursoDao().listar(
                AlunoCurso.class);
        Assert.assertFalse(alunoCursos.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() {
        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setId(1);
        List<AlunoCurso> alunoCursos = this.getAlunoCursoDao().pesquisar(
                alunoCurso);
        Assert.assertFalse(alunoCursos.isEmpty());
    }
}
