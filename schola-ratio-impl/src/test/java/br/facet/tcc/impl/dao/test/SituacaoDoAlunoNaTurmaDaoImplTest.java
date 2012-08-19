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
package br.facet.tcc.impl.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Situacao;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.SituacaoDoAlunoNaTurma;
import br.facet.tcc.pojo.Turma;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class SituacaoDoAlunoNaTurmaDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() throws DaoException {
        SituacaoDoAlunoNaTurma situacaoDoAlunoNaTurma = new SituacaoDoAlunoNaTurma();

        situacaoDoAlunoNaTurma.setAluno(this.alunoDao.listar(Aluno.class)
            .get(0));
        situacaoDoAlunoNaTurma.setSituacao(Situacao.APROVADO);
        situacaoDoAlunoNaTurma.setTurma(this.turmaDao.listar(Turma.class)
            .get(0));
        Integer codigo = this.getSituacaoDoAlunoNaTurmaDao().salvar(
            situacaoDoAlunoNaTurma);
        Assert.assertTrue("SituacaoDoAlunoNaTurma nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() throws DaoException {
        SituacaoDoAlunoNaTurma situacaoDoAlunoNaTurma = this
            .getSituacaoDoAlunoNaTurmaDao()
            .listar(SituacaoDoAlunoNaTurma.class).get(0);
        Situacao expected = situacaoDoAlunoNaTurma.getSituacao();

        situacaoDoAlunoNaTurma.setSituacao(Situacao.REPROVADO);
        this.getSituacaoDoAlunoNaTurmaDao().atualizar(situacaoDoAlunoNaTurma);
        Situacao actual = situacaoDoAlunoNaTurma.getSituacao();

        Assert.assertNotSame("SituacaoDoAlunoNaTurma são diferentes",
            expected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}
     * .
     */
    @Test
    public final void testExcluir() throws DaoException {
        int unexpected = this.getSituacaoDoAlunoNaTurmaDao()
            .listar(SituacaoDoAlunoNaTurma.class).size();

        SituacaoDoAlunoNaTurma situacaoDoAlunoNaTurma = this
            .getSituacaoDoAlunoNaTurmaDao().obterPorID(
                SituacaoDoAlunoNaTurma.class, 4);

        this.getSituacaoDoAlunoNaTurmaDao().excluir(situacaoDoAlunoNaTurma);

        int actual = this.getSituacaoDoAlunoNaTurmaDao()
            .listar(SituacaoDoAlunoNaTurma.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() throws DaoException {
        List<SituacaoDoAlunoNaTurma> situacaoDoAlunoNaTurma1 = this
            .getSituacaoDoAlunoNaTurmaDao()
            .listar(SituacaoDoAlunoNaTurma.class);

        Assert.assertFalse(situacaoDoAlunoNaTurma1.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() throws DaoException {
        SituacaoDoAlunoNaTurma situacaoDoAlunoNaTurma = new SituacaoDoAlunoNaTurma();
        situacaoDoAlunoNaTurma.setSituacao(Situacao.APROVADO);
        List<SituacaoDoAlunoNaTurma> situacaoDoAlunoNaTurma1 = this
            .getSituacaoDoAlunoNaTurmaDao().pesquisar(situacaoDoAlunoNaTurma);

        Assert.assertFalse(situacaoDoAlunoNaTurma1.isEmpty());
    }
}
