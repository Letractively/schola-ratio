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

import br.facet.tcc.enums.Status;
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Instituicao;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class CursoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() {
        Curso curso = new Curso();

        curso.setDisciplina(this.getDisciplinaDao().listar(Disciplina.class));
        curso.setDuracao(8);
        curso.setInstituicao(this.getInstituicaoDao().listar(Instituicao.class)
                .get(0));
        curso.setNome("Curso4");
        curso.setStatus(Status.ATIVO);

        Integer codigo = this.getCursoDao().salvar(curso);
        Assert.assertTrue("Curso nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() {
        Curso curso = this.getCursoDao().listar(Curso.class).get(0);
        String expected = curso.getNome();
        curso.setNome("Novo Nome");
        this.getCursoDao().atualizar(curso);
        String actual = this.getCursoDao().listar(Curso.class).get(0).getNome();
        Assert.assertNotSame("Cursos são diferentes", expected, actual);

    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}.
     */
    @Test
    public final void testExcluir() {
        int unexpected = this.getCursoDao().listar(Curso.class).size();

        Curso curso = this.getCursoDao().obterPorID(Curso.class, 4);

        this.getCursoDao().excluir(curso);

        int actual = this.getCursoDao().listar(Curso.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() {
        List<Curso> cursos = this.getCursoDao().listar(Curso.class);

        Assert.assertFalse(cursos.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() {
        Curso curso = new Curso();
        curso.setNome("%Novo Nome%");
        List<Curso> cursos = this.getCursoDao().pesquisar(curso);

        Assert.assertFalse(cursos.isEmpty());
    }
}
