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

import br.facet.tcc.enums.Estado;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Endereco;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class EnderecoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.EnderecoDaoImpl#salvar(br.facet.tcc.pojo.Endereco)}
     * .
     */
    @Test
    public void testSalvar() throws DaoException {

        Endereco endereco = new Endereco();

        endereco.setBairro("Afonso Pena");
        endereco.setCep(83050330);
        endereco.setCidade("São José dos Pinhais");
        endereco.setComplemento("");
        endereco.setEstado(Estado.PR);
        endereco.setNumero(422);
        endereco.setRua("Leonidas Sechi");

        Integer codigo = this.getEnderecoDao().salvar(endereco);
        Assert.assertTrue("Endereco nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.EnderecoDaoImpl#atualizar(br.facet.tcc.pojo.Endereco)}
     * .
     */
    @Test
    public void testAtualizar() throws DaoException {
        Endereco endereco = this.getEnderecoDao().listar(Endereco.class).get(0);
        String expected = endereco.getBairro();
        endereco.setBairro("Outro bairro");
        this.getEnderecoDao().atualizar(endereco);
        String actual = this.getEnderecoDao().listar(Endereco.class).get(0)
            .getBairro();
        Assert.assertNotSame("Bairro são diferentes", expected, actual);
    }

    @Test
    public void testExcluir() throws DaoException {
        int unexpected = this.getEnderecoDao().listar(Endereco.class).size();

        Endereco endereco = this.getEnderecoDao().obterPorID(Endereco.class, 4);

        this.getEnderecoDao().excluir(endereco);

        int actual = this.getEnderecoDao().listar(Endereco.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    @Test
    public void testListarEndereco() throws DaoException {
        List<Endereco> enderecos = this.getEnderecoDao().listar(Endereco.class);

        Assert.assertFalse(enderecos.isEmpty());
    }

    @Test
    public void testPesquisarEndereco() throws DaoException {
        Endereco endereco = new Endereco();
        endereco.setRua("%rosa%");
        List<Endereco> enderecos = this.getEnderecoDao().pesquisar(endereco);

        Assert.assertFalse(enderecos.isEmpty());
    }
}
