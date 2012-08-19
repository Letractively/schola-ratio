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

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Permissao;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 * 
 * 
 */
public class PermissaoDaoImplTeste extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public void testSalvar() throws DaoException {
        Permissao permissao = new Permissao();
        permissao.setDescricaoPermissao("descricaoPermissao4");
        permissao.setTipoPermissao("tipoPermissao4");

        Integer codigo = this.getPermissaoDao().salvar(permissao);
        Assert.assertTrue("Permissao nao foi salva. ", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public void testAtualizar() throws DaoException {
        Permissao permissao = this.getPermissaoDao().listar(Permissao.class)
            .get(0);
        String expected = permissao.getTipoPermissao();
        permissao.setTipoPermissao("tipoPermissao5");
        this.getPermissaoDao().atualizar(permissao);
        String actual = this.getPermissaoDao().listar(Permissao.class).get(0)
            .getTipoPermissao();
        Assert.assertNotSame("Tipos de permissao são diferentes", expected,
            actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}
     * .
     */
    @Test
    public void testExcluir() throws DaoException {
        int unexpected = this.getPermissaoDao().listar(Permissao.class).size();

        Permissao permissao = this.getPermissaoDao().listar(Permissao.class)
            .get(0);

        this.getPermissaoDao().excluir(permissao);

        int actual = this.getPermissaoDao().listar(Permissao.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public void testListar() throws DaoException {
        List<Permissao> permissao = this.getPermissaoDao().listar(
            Permissao.class);

        Assert.assertFalse(permissao.isEmpty());

    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public void testPesquisar() throws DaoException {
        Permissao permissao = new Permissao();
        permissao.setTipoPermissao("tipoPermissao5");
        List<Permissao> permissao1 = this.getPermissaoDao()
            .pesquisar(permissao);

        Assert.assertFalse(permissao1.isEmpty());
    }
}
