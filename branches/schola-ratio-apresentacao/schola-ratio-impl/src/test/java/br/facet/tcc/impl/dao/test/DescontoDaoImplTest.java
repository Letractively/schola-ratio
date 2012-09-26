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
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Desconto;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class DescontoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() throws DaoException {
        Desconto desconto = new Desconto();

        desconto.setAluno(this.getAlunoDao().obterPorID(Aluno.class, 1));
        desconto.setStatus(Status.ATIVO);
        desconto.setTipoDesconto("Bolsa");
        desconto.setValorDesconto((float) 52.01);

        Integer codigo = this.getDescontoDao().salvar(desconto);
        Assert.assertTrue("Desconto nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() throws DaoException {
        Desconto desconto = this.getDescontoDao().listar(Desconto.class).get(0);
        String expected = desconto.getTipoDesconto();
        desconto.setTipoDesconto("Novo Desconto");
        this.getDescontoDao().atualizar(desconto);
        String actual = this.getDescontoDao().listar(Desconto.class).get(0)
                .getTipoDesconto();
        Assert.assertNotSame("Desconto são diferentes", expected, actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}.
     */
    @Test
    public final void testExcluir() throws DaoException {
        int unexpected = this.getDescontoDao().listar(Desconto.class).size();
        Desconto desconto = this.getDescontoDao().listar(Desconto.class).get(0);
        this.getDescontoDao().excluir(desconto);
        int actual = this.getDescontoDao().listar(Desconto.class).size();
        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() throws DaoException {
        List<Desconto> desconto = this.getDescontoDao().listar(Desconto.class);
        Assert.assertFalse(desconto.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() throws DaoException {
        Desconto desconto = new Desconto();
        desconto.setTipoDesconto("%Novo Desconto%");
        List<Desconto> descontos = this.getDescontoDao().pesquisar(desconto);
        Assert.assertFalse(descontos.isEmpty());
    }

}
