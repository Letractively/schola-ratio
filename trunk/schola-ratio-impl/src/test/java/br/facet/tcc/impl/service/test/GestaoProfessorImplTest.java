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
import br.facet.tcc.enums.TipoTitulo;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.Professor;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

public class GestaoProfessorImplTest extends ServiceTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoProfessorImpl#salvarUsuario(br.facet.tcc.pojo.Professor)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testSalvarUsuarioProfessor() throws DaoException {
        Professor professor = new Professor();
        Endereco endereco = new Endereco();

        endereco.setBairro("bairro");
        endereco.setCep(123);
        endereco.setCidade("cidade");
        endereco.setComplemento("complemento");
        endereco.setEstado(Estado.PR);
        endereco.setNumero(123);
        endereco.setRua("rua");

        professor.setCpf(32932112388L);
        professor.setDataExpedicao(new Date(103, 06, 12));
        professor.setEmail("osnircunha@email.com");
        professor.setEndereco(endereco);
        professor.setNacionalidade("Brasileiro");
        professor.setNaturalidade("São Vicente");
        professor.setNome("Osnir F CUNHA");
        professor.setNomeMae("");
        professor.setNomePai("");
        professor.setOrgaoExpeditor("SSP-SP");
        professor.setRg(272675670L);
        professor.setUfOrgaoExpeditor(Estado.SP);
        professor.setUserLogin(this.userLoginDao.obterPorID("user_name4"));
        professor.setSexo(Sexo.M);
        professor.setStatus(Status.ATIVO);
        professor.setDescricaoTitulo("descricaoTitulo");
        professor.setTitulo(TipoTitulo.MESTRADO);

        Integer codigo = null;
        try {

            codigo = gestaoProfessor.salvarUsuario(professor);
        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoProfessorImpl#removerUsuario(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testRemoverUsuarioProfessor() {
        Professor professor = null;

        try {

            professor = this.gestaoProfessor.consultarUsuario(Professor.class,
                    4);
            this.gestaoProfessor.removerUsuario(professor);
            professor = this.gestaoProfessor.consultarUsuario(Professor.class,
                    4);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(professor);
        Assert.assertTrue("Professor não excluido.", professor == null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoProfessorImpl#consultarUsuario(java.lang.Class, java.lang.Integer)}
     * .
     */
    @Test
    public void testConsultarUsuarioClassInteger() {

        Professor professor = null;

        try {

            professor = this.gestaoProfessor.consultarUsuario(Professor.class,
                    3);

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(professor);
        Assert.assertFalse("Professor não excluido.", professor == null);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoProfessorImpl#consultarUsuario(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testConsultarUsuarioProfessor() {

        Professor professor = new Professor();
        List<Professor> professores = null;
        professor.setNacionalidade("Bras%");

        try {

            professores = gestaoProfessor.consultarUsuario(professor);

        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertTrue("Lista esta vazia", professores.size() > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoProfessorImpl#alterarUsuario(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testAlterarUsuarioProfessor() {

        Professor professor = null;
        String emailAntigo = null, emailNovo = null;
        try {

            professor = this.gestaoProfessor.consultarUsuario(Professor.class,
                    3);
            emailAntigo = professor.getEmail();
            professor.setEmail("EmailNovo");
            emailAntigo = professor.getEmail();

        } catch (ServiceException e) {
            Assert.fail();
        }
        System.out.println(professor);
        Assert.assertFalse("Professor não excluido.", emailAntigo == emailNovo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.service.GestaoProfessorImpl#listarUsuario(java.lang.Class)}
     * .
     */
    @Test
    public void testListarUsuarioClass() {
        List<Professor> professores = null;
        try {
            professores = gestaoProfessor.listarUsuario(Professor.class);
        } catch (ServiceException e) {
            Assert.fail();
        }
        Assert.assertTrue("Lista esta vazia", professores.size() > 0);
    }

}
