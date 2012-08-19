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
package br.facet.tcc.impl.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.facet.tcc.enums.Status;
import br.facet.tcc.pojo.Disciplina;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public class DisciplinaDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)}.
     */
    @Test
    public final void testSalvar() {
        Disciplina disciplina = new Disciplina();

        disciplina.setCargaHoraria(36);
        disciplina.setNome("Matematica");
        disciplina.setPeriodo(8);
        disciplina.setStatus(Status.ATIVO);
        Integer codigo = this.getDisciplinaDao().salvar(disciplina);
        Assert.assertTrue("Endereco nao foi salvo.", codigo > 0);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#atualizar(java.lang.Object)}
     * .
     */
    @Test
    public final void testAtualizar() {
        Disciplina disciplina = this.getDisciplinaDao()
                .listar(Disciplina.class).get(0);
        String expected = disciplina.getNome();
        disciplina.setNome("Outro Nome");
        this.getDisciplinaDao().atualizar(disciplina);
        String actual = this.getDisciplinaDao().listar(Disciplina.class).get(0)
                .getNome();
        Assert.assertNotSame("Disciplina são diferentes", expected, actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#excluir(java.lang.Object)}.
     */
    @Test
    public final void testExcluir() {
        int unexpected = this.getDisciplinaDao().listar(Disciplina.class)
                .size();

        Disciplina disciplina = this.getDisciplinaDao().obterPorID(
                Disciplina.class, 4);

        this.getDisciplinaDao().excluir(disciplina);

        int actual = this.getDisciplinaDao().listar(Disciplina.class).size();

        Assert.assertFalse("Lista esta vazia", unexpected == actual);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#listar(java.lang.Class)}.
     */
    @Test
    public final void testListar() {
        List<Disciplina> disciplina1 = this.getDisciplinaDao().listar(
                Disciplina.class);

        Assert.assertFalse(disciplina1.isEmpty());
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.DaoConfiguration#pesquisar(java.lang.Object)}
     * .
     */
    @Test
    public final void testPesquisar() {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("%Outro Nome%");
        List<Disciplina> disciplina1 = this.getDisciplinaDao().pesquisar(
                disciplina);

        Assert.assertFalse(disciplina1.isEmpty());
    }
}
