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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.Usuario;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class UsuarioDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#salvar(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testSalvar() throws DaoException {
        Endereco endereco = this.enderecoDao.listar(Endereco.class).get(0);
        Usuario usuario = new Usuario();
        usuario.setCpf(19809887654L);
        usuario.setDataExpedicao(new Date(103, 06, 12));
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

        File imagem = new File("src/test/resources/images/loo.jpg");
        byte[] bFile = new byte[(int) imagem.length()];
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(imagem);

            inputStream.read(bFile);
            inputStream.close();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        usuario.setImage(bFile);

        Integer codigo = this.usuarioDao.salvar(usuario);

        Assert.assertTrue("Codigo é nulo.", codigo == usuario.getId());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#atualizar(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testAtualizar() throws DaoException {
        Usuario usuario = getUsuarioDao().obterPorID(Usuario.class, 2);
        usuario.setStatus(Status.INATIVO);
        getUsuarioDao().atualizar(usuario);

        Usuario usuarioToSearch = new Usuario();
        usuarioToSearch.setStatus(Status.INATIVO);
        int count = getUsuarioDao().pesquisar(usuarioToSearch).size();

        Assert.assertEquals(
            "Lista não foi atualizada de acordo com o esperado.", 2, count);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#excluir(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testExcluir() throws DaoException {
        int unexpected = getUsuarioDao().listar(Usuario.class).size();
        getUsuarioDao().excluir(getUsuarioDao().obterPorID(Usuario.class, 3));
        int actual = getUsuarioDao().listar(Usuario.class).size();

        Assert.assertNotSame("Quantidade das listas são as mesmas.",
            unexpected, actual);
    }

    /**
     * Test method for {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#listar()}.
     */
    @Test
    public void testListar() throws DaoException {
        int actual = getUsuarioDao().listar(Usuario.class).size();
        Assert.assertTrue("Lista esta vazia.", actual > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.UsuarioDaoImpl#pesquisar(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testPesquisar() throws DaoException {
        Usuario usuario = new Usuario();
        usuario.setUfOrgaoExpeditor(Estado.AP);

        List<Usuario> usuarios = getUsuarioDao().pesquisar(usuario);

        Assert.assertFalse("Lista esta vazia.", usuarios.isEmpty());
    }

    @Test
    public void testeObterPorId() throws DaoException {

        Usuario usuario = getUsuarioDao().obterPorID(Usuario.class, 4);

        File imagem = new File("src/test/resources/images/loo_out.jpg");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(imagem);
            outputStream.write(usuario.getImage());
            outputStream.close();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

}
