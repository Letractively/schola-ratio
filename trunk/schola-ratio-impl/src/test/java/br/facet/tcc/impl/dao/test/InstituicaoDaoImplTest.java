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

import junit.framework.Assert;
import junit.framework.TestCase;
import br.facet.tcc.impl.dao.InstituicaoDaoImpl;
import br.facet.tcc.pojo.Instituicao;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 * 
 *        TODO : implementar usando spring annotations
 */
public class InstituicaoDaoImplTest extends TestCase {

    private InstituicaoDaoImpl instituicaoDao;

    public void testSalvarInstituicaoNull() throws Exception {
        // Endereco endereco = new Endereco();
        // endereco.set
        Instituicao instituicao = null;

        try {
            this.instituicaoDao.salvar(instituicao);
            Assert.fail("N�o poderia salvar nulo.");
        } catch (IllegalArgumentException exception) {
            Assert.assertTrue("Lan�ou exce��o esperada.",
                exception instanceof IllegalArgumentException);
        }

    }

}
