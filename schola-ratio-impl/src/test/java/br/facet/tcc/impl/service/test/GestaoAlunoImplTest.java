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

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Endereco;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

public class GestaoAlunoImplTest extends ServiceTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoAlunoImpl#salvarUsuario(br.facet.tcc.pojo.Aluno)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testSalvarUsuarioAluno() throws DaoException {

        Aluno aluno = new Aluno();
        Endereco endereco = new Endereco();

        endereco.setBairro("bairro");
        endereco.setCep(123);
        endereco.setCidade("cidade");
        endereco.setComplemento("complemento");
        endereco.setEstado(Estado.PR);
        endereco.setNumero(123);
        endereco.setRua("rua");

        aluno.setCpf(32932112388L);
        aluno.setDataNascimento(new Date(103, 06, 12));
        aluno.setEmail("osnircunha@email.com");
        aluno.setEndereco(endereco);
        aluno.setNacionalidade("Brasileiro");
        aluno.setNaturalidade("São Vicente");
        aluno.setNome("Osnir F CUNHA");
        aluno.setNomeMae("");
        aluno.setNomePai("");
        aluno.setOrgaoExpeditor("SSP-SP");
        aluno.setRg(272675670L);
        aluno.setUfOrgaoExpeditor(Estado.SP);
        aluno.setUserLogin(this.userLoginDao.obterPorID("user_name4"));
        aluno.setSexo(Sexo.M);
        aluno.setStatus(Status.ATIVO);
        aluno.setDataDeMatricula(new Date());

        Integer codigo = null;
        try {

            codigo = gestaoAluno.salvarUsuario(aluno);
        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoAlunoImpl#removerUsuario(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testRemoverUsuarioAluno() {

        Aluno aluno = null;

        try {

            aluno = this.gestaoAluno.consultarUsuario(Aluno.class, 4);
            this.gestaoAluno.removerUsuario(aluno);
            aluno = this.gestaoAluno.consultarUsuario(Aluno.class, 4);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(aluno);
        Assert.assertTrue("Aluno não excluido.", aluno == null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoAlunoImpl#consultarUsuario(java.lang.Class, java.lang.Integer)}
     * .
     */
    @Test
    public void testConsultarUsuarioClassInteger() {

        Aluno aluno = null;

        try {

            aluno = this.gestaoAluno.consultarUsuario(Aluno.class, 3);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(aluno);
        Assert.assertFalse("Aluno não excluido.", aluno == null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoAlunoImpl#consultarUsuario(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testConsultarUsuarioAluno() {

        Aluno aluno = new Aluno();
        List<Aluno> alunos = null;
        aluno.setNacionalidade("Bras%");

        try {

            alunos = gestaoAluno.consultarUsuario(aluno);

        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertTrue("Lista esta vazia", alunos.size() > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoAlunoImpl#alterarUsuario(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testAlterarUsuarioAluno() {

        Aluno aluno = null;
        String emailAntigo = null, emailNovo = null;
        try {

            aluno = this.gestaoAluno.consultarUsuario(Aluno.class, 3);
            emailAntigo = aluno.getEmail();
            aluno.setEmail("EmailNovo");
            emailAntigo = aluno.getEmail();

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(aluno);
        Assert.assertFalse("Aluno não excluido.", emailAntigo == emailNovo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoAlunoImpl#listarUsuario(java.lang.Class)}
     * .
     */
    @Test
    public void testListarUsuarioClass() {

        List<Aluno> alunos = null;
        try {
            alunos = gestaoAluno.listarUsuario(Aluno.class);
        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertTrue("Lista esta vazia", alunos.size() > 0);

    }
}
