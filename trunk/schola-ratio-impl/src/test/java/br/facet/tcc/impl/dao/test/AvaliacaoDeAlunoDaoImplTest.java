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

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Bimestre;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Avaliacao;
import br.facet.tcc.pojo.AvaliacaoDeAluno;
import br.facet.tcc.pojo.Turma;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public class AvaliacaoDeAlunoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() throws DaoException {
        AvaliacaoDeAluno avaliacaoDeAluno = new AvaliacaoDeAluno();
        avaliacaoDeAluno
                .setAluno(this.getAlunoDao().listar(Aluno.class).get(0));
        avaliacaoDeAluno.setAvaliacao(this.getAvaliacaoDao()
                .listar(Avaliacao.class).get(0));
        avaliacaoDeAluno
                .setTurma(this.getTurmaDao().listar(Turma.class).get(0));

        Integer codigo = getAvaLiacaoDeAlunoDao().salvar(avaliacaoDeAluno);

        Assert.assertTrue("Codigo de Avaliação do Aluno invalido.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() throws DaoException {
        AvaliacaoDeAluno avaliacaoDeAluno = this.getAvaLiacaoDeAlunoDao()
                .listar(AvaliacaoDeAluno.class).get(0);
        Float expected = avaliacaoDeAluno.getAvaliacao().getNota();

        avaliacaoDeAluno.getAvaliacao().setNota(8.8f);

        this.getAvaLiacaoDeAlunoDao().atualizar(avaliacaoDeAluno);
        Float actual = avaliacaoDeAluno.getAvaliacao().getNota();
        Assert.assertNotSame("AvaliacaoDeAluno são diferentes", expected,
                actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}.
     */
    @Test
    public final void testExcluir() throws DaoException {
        int unexpected = getAvaLiacaoDeAlunoDao()
                .listar(AvaliacaoDeAluno.class).size();

        AvaliacaoDeAluno avaliacaoDeAluno = this.getAvaLiacaoDeAlunoDao()
                .obterPorID(AvaliacaoDeAluno.class, 1);

        this.getAvaLiacaoDeAlunoDao().excluir(avaliacaoDeAluno);

        int actual = getAvaLiacaoDeAlunoDao().listar(AvaliacaoDeAluno.class)
                .size();

        Assert.assertFalse("Avaliação não foi excluida.", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() throws DaoException {
        int actual = getAvaliacaoDao().listar(Avaliacao.class).size();

        Assert.assertFalse("Lista esta vazia.", actual == 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() throws DaoException {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setBimestre(Bimestre.PRIMEIRO);
        avaliacao.setFrequencia(15);
        avaliacao.setNota(9.5f);

        int actual = getAvaliacaoDao().listar(Avaliacao.class).size();

        Assert.assertTrue(
                "Não foram encontrados obbjetos com os parametros passado.",
                actual > 0);
    }
}
