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
import br.facet.tcc.enums.TipoTitulo;
import br.facet.tcc.pojo.Professor;

/**
 * @author Osnir F CUNHA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public class ProfessorDaoImplTest extends DaoTestCaseSetUp {

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#salvar(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testSalvar() {
        Professor professor = new Professor();

        professor.setCpf(32932112388L);
        professor.setDataExpedicao(new Date(2003, 06, 12));
        professor.setEmail("osnircunha@email.com");
        professor.setEndereco(this.getEnderecoDao().listar(Professor.class)
            .get(0));
        professor.setNacionalidade("Brasileiro");
        professor.setNaturalidade("São Vicente");
        professor.setNome("Osnir F CUNHA");
        professor.setNomeMae("");
        professor.setNomePai("");
        professor.setOrgaoExpeditor("SSP-SP");
        professor.setRg(272675670L);
        professor.setUfOrgaoExpeditor(Estado.SP);
        professor.setSenha("123qwe");
        professor.setSexo(Sexo.M);
        professor.setStatus(Status.ATIVO);
        professor.setTitulo(TipoTitulo.GRADUACAO);
        professor.setDescricaoTitulo("Engenharia de Computação");

        Integer codigo = (Integer) this.enderecoDao.getHibernateTemplate()
            .save(professor);

        Assert.assertNotNull("Codigo é nulo.", codigo);
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#atualizar(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testAtualizar() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#excluir(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testExcluir() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#listar()}.
     */
    @Test
    public void testListar() {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link br.facet.tcc.impl.dao.ProfessorDaoImpl#pesquisar(br.facet.tcc.pojo.Professor)}
     * .
     */
    @Test
    public void testPesquisar() {
        fail("Not yet implemented"); // TODO
    }

}
