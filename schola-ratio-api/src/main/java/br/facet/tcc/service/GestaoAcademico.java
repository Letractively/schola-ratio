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
package br.facet.tcc.service;

import java.io.File;
import java.util.List;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AvaliacaoDeAluno;
import br.facet.tcc.pojo.Turma;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface GestaoAcademico {

    public void registrarNotasFaltas(List<AvaliacaoDeAluno> avaliacoesDaTurma)
        throws ServiceException;

    public void registrarNotasFaltas(AvaliacaoDeAluno avaliacaoDeAluno)
        throws ServiceException;

    public File buscarRelatorio(Integer tipo) throws ServiceException;

    public List<AvaliacaoDeAluno> listarDiario(Aluno aluno)
        throws ServiceException;

    public List<AvaliacaoDeAluno> listarDiario(Turma turma)
        throws ServiceException;

}
