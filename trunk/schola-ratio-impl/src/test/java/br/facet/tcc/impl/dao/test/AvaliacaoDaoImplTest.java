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

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Bimestre;
import br.facet.tcc.pojo.Avaliacao;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class AvaliacaoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public void testSalvar() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setFrequencia(14);
        avaliacao.setNota(9f);
        avaliacao.setBimestre(Bimestre.SEGUNDO);

        Integer codigo = getAvaliacaoDao().salvar(avaliacao);

        Assert.assertTrue("Codigo de Avaliação invalido.", codigo > 0);

    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public void testAtualizar() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setBimestre(Bimestre.SEGUNDO);

        Avaliacao avaliacaoToEdit = getAvaliacaoDao().pesquisar(avaliacao).get(
            0);

        avaliacaoToEdit.setBimestre(Bimestre.FINAL);

        getAvaliacaoDao().atualizar(avaliacaoToEdit);

        Avaliacao avaliacaoEditada = getAvaliacaoDao().obterPorID(
            Avaliacao.class, avaliacaoToEdit.getId());

        Assert.assertNotSame("Bimestres são iguais.",
            avaliacaoEditada.getBimestre(), Bimestre.SEGUNDO);

    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}
     * .
     */
    @Test
    public void testExcluir() {
        int unexpected = getAvaliacaoDao().listar(Avaliacao.class).size();

        getAvaliacaoDao().excluir(
            getAvaliacaoDao().obterPorID(Avaliacao.class, 2));

        int actual = getAvaliacaoDao().listar(Avaliacao.class).size();

        Assert.assertFalse("Avaliação não foi excluida.", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public void testListar() {
        int actual = getAvaliacaoDao().listar(Avaliacao.class).size();

        Assert.assertFalse("Lista esta vazia.", actual == 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public void testPesquisar() {
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
