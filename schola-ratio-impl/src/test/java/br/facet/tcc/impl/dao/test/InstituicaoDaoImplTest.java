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
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.Instituicao;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        TODO : implementar usando spring annotations
 */
public class InstituicaoDaoImplTest extends DaoTestCaseSetUp {

    @Test
    public void testSalvarInstituicao() throws DaoException {
        Instituicao instituicao = new Instituicao();
        instituicao.setCnpj(33333333333333l);
        instituicao.setEmail("email3");
        instituicao.setInscricaoEstadual(3333333);
        instituicao.setNome("ScholaRatio3");
        instituicao.setTelefone(33333333);
        instituicao.setEndereco(getEnderecoDao().listar(Endereco.class).get(0));

        Integer codigo = this.getInstituicaoDao().salvar(instituicao);
        Assert.assertTrue("Instituicao nao salva", codigo > 0);
    }

    @Test
    public void testAtualizar() throws DaoException {

        Instituicao instituicao = this.getInstituicaoDao()
                .listar(Instituicao.class).get(0);
        String expected = instituicao.getNome();
        instituicao.setNome("Outro nome");
        String actual = this.getInstituicaoDao().listar(Instituicao.class)
                .get(0).getNome();
        Assert.assertNotSame("Nao atualizou o nome.", expected, actual);
    }

    @Test
    public void testDeletar() throws DaoException {
        int unexpected = this.getInstituicaoDao().listar(Instituicao.class)
                .size();

        Instituicao instituicao = this.getInstituicaoDao().obterPorID(
                Instituicao.class, 4);
        this.getInstituicaoDao().excluir(instituicao);

        int actual = this.getInstituicaoDao().listar(Instituicao.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    @Test
    public void testListarInstituicao() throws DaoException {
        List<Instituicao> instituicao = this.getInstituicaoDao().listar(
                Instituicao.class);

        Assert.assertFalse(instituicao.isEmpty());
    }

    @Test
    public void testPesquisarInstituicao() throws DaoException {
        Instituicao instituicao = new Instituicao();
        instituicao.setNome("%Schola%");
        List<Instituicao> instituicaos = this.getInstituicaoDao().pesquisar(
                instituicao);

        Assert.assertFalse(instituicaos.isEmpty());
    }
}
