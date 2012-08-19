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
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Mensalidade;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public class MensalidadeDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() {
        Mensalidade mensalidade = new Mensalidade();

        mensalidade.setAluno(this.getAlunoDao().listar(Aluno.class).get(0));
        // mensalidade.setMesReferencia();
        mensalidade.setStatus(Status.ATIVO);
        mensalidade.setValor(400.00f);
        mensalidade.setValorPago(400.00f);

        Integer codigo = this.getMensalidadeDao().salvar(mensalidade);
        Assert.assertTrue("Endereco nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() {
        Mensalidade mensalidade = this.getMensalidadeDao()
                .listar(Mensalidade.class).get(0);
        Float expected = mensalidade.getValorPago();
        mensalidade.setValorPago(420.00f);
        this.getMensalidadeDao().atualizar(mensalidade);
        Float actual = this.getMensalidadeDao().listar(Mensalidade.class)
                .get(0).getValorPago();
        Assert.assertNotSame("Mensalidades são diferentes", expected, actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}.
     */
    @Test
    public final void testExcluir() {
        int unexpected = this.getMensalidadeDao().listar(Mensalidade.class)
                .size();

        Mensalidade mensalidade = this.getMensalidadeDao().obterPorID(
                Mensalidade.class, 2);

        this.getMensalidadeDao().excluir(mensalidade);

        int actual = this.getMensalidadeDao().listar(Mensalidade.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() {
        List<Mensalidade> mensalidade1 = this.getMensalidadeDao().listar(
                Mensalidade.class);

        Assert.assertFalse(mensalidade1.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() {
        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setValorPago(420.00f);
        List<Mensalidade> mensalidade1 = this.getMensalidadeDao().pesquisar(
                mensalidade);

        Assert.assertFalse(mensalidade1.isEmpty());
    }
}