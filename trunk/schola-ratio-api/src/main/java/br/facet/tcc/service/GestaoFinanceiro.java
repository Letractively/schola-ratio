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
import java.io.Serializable;
import java.util.List;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Desconto;
import br.facet.tcc.pojo.Mensalidade;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface GestaoFinanceiro extends Serializable {

    public Integer gerarMensalidade(Aluno aluno) throws ServiceException;

    public List<Mensalidade> buscarMensalidade(Aluno aluno)
        throws ServiceException;

    public void quitarMensalidade(Aluno aluno) throws ServiceException;

    public void atualizarMensalidade(Aluno aluno) throws ServiceException;

    public void aplicarDesconto(Desconto desconto) throws ServiceException;

    public File buscarRelatorio() throws ServiceException;
}
