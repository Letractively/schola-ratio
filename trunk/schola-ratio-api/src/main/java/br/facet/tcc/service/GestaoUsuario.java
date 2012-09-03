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
import java.util.List;

import br.facet.tcc.exception.ServiceException;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface GestaoUsuario<T> extends Serializable {

    public Integer salvarUsuario(T t) throws ServiceException;

    public void removerUsuario(T t) throws ServiceException;

    public List<T> consultarUsuario(T t) throws ServiceException;

    public T consultarUsuario(Class clazz, Integer id) throws ServiceException;

    public void alterarUsuario(T t) throws ServiceException;

    public List<T> listarUsuario(Class clazz) throws ServiceException;

}
