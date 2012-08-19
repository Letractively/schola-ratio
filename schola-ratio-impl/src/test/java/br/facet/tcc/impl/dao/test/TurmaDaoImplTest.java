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

import br.facet.tcc.enums.HorarioDeAulas;
import br.facet.tcc.enums.Status;
import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Professor;
import br.facet.tcc.pojo.Turma;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class TurmaDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() throws DaoException {
        Turma turma = new Turma();

        turma.setAlunos(this.getAlunoDao().listar(Aluno.class));
        turma.setAno("2012");
        turma.setDisciplina(this.getDisciplinaDao().listar(Disciplina.class)
            .get(0));
        turma.setHorarioDeAulas(HorarioDeAulas.QUARTA_SEGUNDO_HORARIO);
        turma.setProfessor(this.getProfessorDao().listar(Professor.class)
            .get(0));
        turma.setStatus(Status.ATIVO);

        Integer codigo = this.getTurmaDao().salvar(turma);
        Assert.assertTrue("Turma nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() throws DaoException {
        Turma turma = this.getTurmaDao().listar(Turma.class).get(0);
        String expected = turma.getAno();
        turma.setAno("Outro Ano");
        this.getTurmaDao().atualizar(turma);
        String actual = this.getTurmaDao().listar(Turma.class).get(0).getAno();
        Assert.assertNotSame("Turma são diferentes", expected, actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}
     * .
     */
    @Test
    public final void testExcluir() throws DaoException {
        int unexpected = this.getTurmaDao().listar(Turma.class).size();

        Turma turma = this.getTurmaDao().obterPorID(Turma.class, 4);

        this.getTurmaDao().excluir(turma);

        int actual = this.getTurmaDao().listar(Turma.class).size();

        Assert.assertFalse("Turma esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() throws DaoException {
        List<Turma> turma1 = this.getTurmaDao().listar(Turma.class);

        Assert.assertFalse(turma1.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() throws DaoException {
        Turma turma = new Turma();
        turma.setAno("%Outro Ano%");
        List<Turma> turma1 = this.getTurmaDao().pesquisar(turma);

        Assert.assertFalse(turma1.isEmpty());
    }
}
