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

import org.springframework.beans.factory.annotation.Autowired;

import br.facet.tcc.impl.dao.test.DaoTestCaseSetUp;
import br.facet.tcc.impl.service.GestaoAlunoImpl;
import br.facet.tcc.impl.service.GestaoProfessorImpl;
import br.facet.tcc.impl.service.GestaoUsuarioImpl;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

public class ServiceTestCaseSetUp extends DaoTestCaseSetUp {

    @Autowired
    protected GestaoAlunoImpl gestaoAluno;

    @Autowired
    protected GestaoProfessorImpl gestaoProfessor;

    @Autowired
    protected GestaoUsuarioImpl gestaoUsuario;

}