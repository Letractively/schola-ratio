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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.pojo.Endereco;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class EnderecoDaoImplTest extends DaoTestCaseSetUp {

    private static final Log log = LogFactory.getLog(EnderecoDaoImplTest.class);

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.EnderecoDaoImpl#salvar(br.facet.tcc.pojo.Endereco)}
     * .
     */
    @Test
    public void testSalvar() {

        Endereco endereco = new Endereco();

        endereco.setBairro("Afonso Pena");
        endereco.setCep(83050330);
        endereco.setCidade("São José dos Pinhais");
        endereco.setComplemento("");
        endereco.setEstado(Estado.PR);
        endereco.setNumero(422);
        endereco.setRua("Leonidas Sechi");

        Integer codigo = this.getEnderecoDao().salvar(endereco);
        log.debug("REcuperado endereço com o codigo : " + codigo);
        Assert.assertTrue("Codigo é nulo.", codigo != null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.EnderecoDaoImpl#atualizar(br.facet.tcc.pojo.Endereco)}
     * .
     */
    @Test
    public void testAtualizar() {
        Endereco endereco = this.getEnderecoDao().listar(Endereco.class).get(0);
        String expected = endereco.getBairro();
        endereco.setBairro("Outro bairro");
        this.getEnderecoDao().atualizar(endereco);
        String actual = this.getEnderecoDao().listar(Endereco.class).get(0)
            .getBairro();
        Assert.assertNotSame("Bairro são diferentes", expected, actual);
    }

    @Test
    public void testDeletar() {
        int unexpected = this.getEnderecoDao().listar(Endereco.class).size();

        Endereco endereco = this.getEnderecoDao().listar(Endereco.class).get(0);

        this.getEnderecoDao().excluir(endereco);

        int actual = this.getEnderecoDao().listar(Endereco.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    @Test
    public void testListarEndereco() {
        List<Endereco> enderecos = this.getEnderecoDao().listar(Endereco.class);

        Assert.assertFalse(enderecos.isEmpty());
    }

    @Test
    public void testPesquisarEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua("%rosa%");
        List<Endereco> enderecos = this.getEnderecoDao().pesquisar(endereco);

        Assert.assertFalse(enderecos.isEmpty());
    }
}
