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

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.HorarioDeAulas;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.enums.TipoTitulo;
import br.facet.tcc.enums.UserRoles;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.HorarioDeAula;
import br.facet.tcc.pojo.Professor;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Osnir F CUNHA
 * 
 */
public class ProfessorDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#salvar(br.facet.tcc.pojo.Professor)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testSalvar() throws DaoException {
        // Endereço
        Endereco endereco = new Endereco();
        endereco.setBairro("bairroendprof");
        endereco.setCep(12312345);
        endereco.setCidade("cidadeendprof");
        endereco.setComplemento("nt");
        endereco.setEstado(Estado.BA);
        endereco.setNumero(123);
        endereco.setRua("ruaendprfo");

        // Permissoes
        List<br.facet.tcc.pojo.UserRoles> permissoes = new ArrayList<br.facet.tcc.pojo.UserRoles>();
        permissoes.add(new br.facet.tcc.pojo.UserRoles(UserRoles.ROLE_USR));
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername("prof1");
        userLogin.setEnable(true);
        userLogin.setPassword("senha");
        userLogin.setPermissoes(permissoes);

        // Disponibilidade
        Set<Disciplina> disciplinas = new HashSet<Disciplina>(
                this.disciplinaDao.listar(Disciplina.class));
        Set<HorarioDeAula> horarioDeAulas = new LinkedHashSet<HorarioDeAula>();
        horarioDeAulas.add(new HorarioDeAula(
                HorarioDeAulas.SEGUNDA_PRIMEIRO_HORARIO));

        Professor professor = new Professor();

        professor.setCpf(32932112388L);
        professor.setDataNascimento(new GregorianCalendar(2003, 06, 12)
                .getTime());
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
        professor.setUserLogin(userLogin);
        professor.setSexo(Sexo.M);
        professor.setStatus(Status.ATIVO);
        professor.setTitulo(TipoTitulo.GRADUACAO);
        professor.setDescricaoTitulo("Engenharia de Computação");
        professor.setDisciplinasQueLeciona(disciplinas);
        professor.setHorarioDisponivel(horarioDeAulas);

        Integer codigo = (Integer) this.enderecoDao.save(professor);

        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#atualizar(br.facet.tcc.pojo.Professor)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testAtualizar() throws DaoException {
        Professor professor = getProfessorDao().listar(Professor.class).get(0);
        String unexpected = professor.getNome();
        String actual = "novo nome";
        professor.setNome(actual);
        getProfessorDao().atualizar(professor);
        Professor atualizado = getProfessorDao().listar(Professor.class).get(0);
        Assert.assertNotSame("Nome do professor não foi atualizado.",
                unexpected, atualizado.getNome());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#excluir(br.facet.tcc.pojo.Professor)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testExcluir() throws DaoException {
        int unexpected = getProfessorDao().listar(Professor.class).size();

        this.getProfessorDao().excluir(
                getProfessorDao().obterPorID(Professor.class, 4));

        int actual = getProfessorDao().listar(Professor.class).size();

        Assert.assertNotSame("Professor não excluido.", unexpected, actual);
    }

    /**
     * Test method for {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#listar()}.
     * 
     * @throws DaoException
     */
    @Test
    public void testListar() throws DaoException {
        List<Professor> professor = getProfessorDao().listar(Professor.class);
        Assert.assertTrue("Lista esta vazia", professor.size() > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#pesquisar(br.facet.tcc.pojo.Professor)}
     * .
     * 
     * @throws DaoException
     */
    @Test
    public void testPesquisar() throws DaoException {
        Professor professor = new Professor();
        // professor.setNome("carol");

        Disciplina disciplina = this.disciplinaDao.obterPorID(Disciplina.class,
                7);
        Set<Disciplina> disciplinas = new HashSet<Disciplina>();
        disciplinas.add(disciplina);

        professor.setDisciplinasQueLeciona(disciplinas);

        List<Professor> professor1 = getProfessorDao().pesquisar(professor);
        Assert.assertTrue("Lista esta vazia", professor1.size() > 0);
    }

    @Test
    public void testPesquisarPorDisponibilidade() throws DaoException {
        Professor professor = new Professor();
        // professor.setNome("carol");

        Set<HorarioDeAula> horarios = new HashSet<HorarioDeAula>();
        horarios.add(new HorarioDeAula(HorarioDeAulas.SEGUNDA_PRIMEIRO_HORARIO));
        horarios.add(new HorarioDeAula(HorarioDeAulas.SEXTA_SEGUNDO_HORARIO));
        horarios.add(new HorarioDeAula(HorarioDeAulas.QUARTA_PRIMEIRO_HORARIO));

        professor.setHorarioDisponivel(horarios);

        List<Professor> professor1 = getProfessorDao().pesquisar(professor);
        Assert.assertTrue("Lista esta vazia", professor1.size() > 0);
    }
}
