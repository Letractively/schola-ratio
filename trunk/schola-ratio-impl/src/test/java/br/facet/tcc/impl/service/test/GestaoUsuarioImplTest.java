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
package br.facet.tcc.impl.service.test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.enums.UserRoles;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.UserLogin;
import br.facet.tcc.pojo.Usuario;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

public class GestaoUsuarioImplTest extends ServiceTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoUsuarioImpl#salvarUsuario(br.facet.tcc.pojo.Usuario)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testSalvarUsuarioUsuario() throws DaoException {
        Usuario usuario = new Usuario();
        Endereco endereco = new Endereco();
        UserLogin userLogin = new UserLogin();

        List<br.facet.tcc.pojo.UserRoles> permissoes = new ArrayList<br.facet.tcc.pojo.UserRoles>();

        endereco.setBairro("bairro");
        endereco.setCep(123);
        endereco.setCidade("cidade");
        endereco.setComplemento("complemento");
        endereco.setEstado(Estado.PR);
        endereco.setNumero(123);
        endereco.setRua("rua");

        userLogin.setUsername("user_nameX");
        userLogin.setPassword(DigestUtils.shaHex("senha"));

        br.facet.tcc.pojo.UserRoles roleAca = new br.facet.tcc.pojo.UserRoles();
        roleAca.setUserRole(UserRoles.ROLE_ACA);
        permissoes.add(roleAca);

        br.facet.tcc.pojo.UserRoles roleUsr = new br.facet.tcc.pojo.UserRoles();
        roleUsr.setUserRole(UserRoles.ROLE_USR);
        permissoes.add(roleUsr);

        userLogin.setPermissoes(permissoes);

        usuario.setCpf(32932112388L);
        usuario.setDataNascimento(new GregorianCalendar(1983, 06, 12).getTime());
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
        usuario.setUserLogin(userLogin);
        usuario.setSexo(Sexo.M);
        usuario.setStatus(Status.ATIVO);

        Integer codigo = null;
        try {

            codigo = gestaoUsuario.salvarUsuario(usuario);
        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoUsuarioImpl#removerUsuario(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testRemoverUsuarioUsuario() {
        Usuario usuario = null;

        try {

            usuario = this.gestaoUsuario.consultarUsuario(Usuario.class, 1);
            this.gestaoUsuario.removerUsuario(usuario);
            usuario = this.gestaoUsuario.consultarUsuario(Usuario.class, 1);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(usuario);
        Assert.assertTrue("Usuario não excluido.", usuario == null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoUsuarioImpl#consultarUsuario(java.lang.Class, java.lang.Integer)}
     * .
     */
    @Test
    public void testConsultarUsuarioClassInteger() {
        Usuario usuario = null;

        try {

            usuario = this.gestaoUsuario.consultarUsuario(Usuario.class, 1);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(usuario);
        Assert.assertFalse("Usuario não excluido.", usuario == null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoUsuarioImpl#consultarUsuario(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testConsultarUsuarioUsuario() {
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = null;
        usuario.setNome("osnir");

        try {

            usuarios = gestaoUsuario.consultarUsuario(usuario);

        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertTrue("Lista esta vazia", usuarios.size() > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoUsuarioImpl#alterarUsuario(br.facet.tcc.pojo.Usuario)}
     * .
     */
    @Test
    public void testAlterarUsuarioUsuario() {

        Usuario usuario = null;
        String emailAntigo = null;
        try {

            usuario = this.gestaoUsuario.consultarUsuario(Usuario.class, 1);
            emailAntigo = usuario.getEmail();
            usuario.setEmail("EmailNovo");
            this.gestaoUsuario.alterarUsuario(usuario);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(usuario);
        Assert.assertFalse("Usuario não excluido.",
                emailAntigo == usuario.getEmail());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoUsuarioImpl#listarUsuario(java.lang.Class)}
     * .
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testListarUsuarioClass() {
        List<Usuario> usuarios = null;
        try {
            usuarios = gestaoUsuario.listarUsuario(Usuario.class);
        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertTrue("Lista esta vazia", usuarios.size() > 0);
    }

}
