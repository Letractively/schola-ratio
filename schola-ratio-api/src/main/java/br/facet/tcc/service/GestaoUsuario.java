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
package br.facet.tcc.service;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface GestaoUsuario<T> {

    public void salvarUsuario(T t) throws ServerException;

    public void removerUsuario(T t) throws ServerException;

    public void consultarUsuario(T t) throws ServerException;

    public void consultarUsuario(Integer id) throws ServerException;

    public void alterarUsuario(T t) throws ServerException;

    public List<T> listarUsuario(T t) throws ServerException;

}
