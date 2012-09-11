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

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Endereco;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class AlunoDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.AlunoDaoImpl#salvar(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testSalvar() throws DaoException {

        Aluno aluno = new Aluno();

        aluno.setCpf(32932112388L);
        aluno.setDataNascimento(new Date(103, 06, 12));
        aluno.setEmail("osnircunha@email.com");
        aluno.setEndereco(this.getEnderecoDao().listar(Endereco.class).get(0));
        aluno.setNacionalidade("Brasileiro");
        aluno.setNaturalidade("São Vicente");
        aluno.setNome("Osnir F CUNHA");
        aluno.setNomeMae("");
        aluno.setNomePai("");
        aluno.setOrgaoExpeditor("SSP-SP");
        aluno.setRg(272675670L);
        aluno.setUfOrgaoExpeditor(Estado.SP);
        aluno.setUserLogin(this.userLoginDao.obterPorID("user_name6"));
        aluno.setSexo(Sexo.M);
        aluno.setStatus(Status.ATIVO);
        aluno.setDataDeMatricula(new Date());

        Integer codigo = this.getAlunoDao().salvar(aluno);

        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.AlunoDaoImpl#atualizar(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testAtualizar() throws DaoException {

        List<Aluno> alunos = getAlunoDao().listar(Aluno.class);
        Aluno aluno = alunos.get(0);
        String unexpected = aluno.getNome();
        String actual = "novo nome";

        aluno.setNome(actual);

        getAlunoDao().atualizar(aluno);

        Aluno atualizado = getAlunoDao().listar(Aluno.class).get(0);

        Assert.assertNotSame("Nome não foi atualizado.", unexpected,
                atualizado.getNome());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.AlunoDaoImpl#excluir(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testExcluir() throws DaoException {
        List<Aluno> list = this.getAlunoDao().listar(Aluno.class);
        int unexpected = list.size();
        this.getAlunoDao().excluir(getAlunoDao().obterPorID(Aluno.class, 4));
        list = this.getAlunoDao().listar(Aluno.class);

        Assert.assertFalse("Aluno não excluido.", unexpected == list.size());
    }

    /**
     * Test method for {@link br.facet.tcc.impl.dao.AlunoDaoImpl#listar()}.
     */
    @Test
    public void testListar() throws DaoException {
        List<Aluno> alunos = getAlunoDao().listar(Aluno.class);
        Assert.assertTrue("Lista esta vazia", alunos.size() > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.AlunoDaoImpl#pesquisar(br.facet.tcc.pojo.Aluno)}
     * .
     */
    @Test
    public void testPesquisar() throws DaoException {
        Aluno aluno = new Aluno();
        aluno.setNaturalidade("São%");
        List<Aluno> alunos = getAlunoDao().pesquisar(aluno);
        Assert.assertTrue("Lista esta vazia", alunos.size() > 0);
    }

}
