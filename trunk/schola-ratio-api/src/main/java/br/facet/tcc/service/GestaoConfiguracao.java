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

import java.io.Serializable;
import java.rmi.ServerException;

import br.facet.tcc.pojo.Instituicao;
import br.facet.tcc.pojo.Permissao;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface GestaoConfiguracao extends Serializable {

    /**
     * @param instituicao
     * @throws ServerException
     * @since 0.0.1
     */
    public void atualizarDestalhesInstituicao(Instituicao instituicao)
        throws ServerException;

    /**
     * @param permissao
     * @return
     * @throws ServerException
     * @since 0.0.1
     */
    public Integer incluirPermissao(Permissao permissao) throws ServerException;

    /**
     * @param permissao
     * @throws ServerException
     * @since 0.0.1
     */
    public void alterarPermissao(Permissao permissao) throws ServerException;

}
