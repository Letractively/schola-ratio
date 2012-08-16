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

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.Usuario;

/**
 * @author Osnir F CUNHA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public class UsuarioDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#salvar(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testSalvar() {
        Endereco endereco = this.enderecoDao.listar().get(0);
        Usuario usuario = new Usuario();
        usuario.setCpf(32932112388L);
        usuario.setDataExpedicao(new Date(2003, 06, 12));
        usuario.setEmail("osnircunha@email.com");
        usuario.setEndereco(endereco);
        usuario.setNacionalidade("Brasileiro");
        usuario.setNaturalidade("São Vicente");
        usuario.setNome("Osnir F CUNHA");
        usuario.setNomeMae("");
        usuario.setNomePai("");
        usuario.setOrgaoExpeditor("SSP-SP");
        usuario.setRg(272675670L);
        usuario.setUfOrgaoExpeditor(Estado.SP);
        usuario.setSenha("123qwe");
        usuario.setSexo(Sexo.M);
        usuario.setStatus(Status.ATIVO);

        Integer codigo = (Integer) this.enderecoDao.getHibernateTemplate()
            .save(usuario);

        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#atualizar(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testAtualizar() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#excluir(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testExcluir() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#listar()}.
     */
    @Test
    public void testListar() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#pesquisar(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testPesquisar() {
        fail("Not yet implemented"); // TODO
    }

}
