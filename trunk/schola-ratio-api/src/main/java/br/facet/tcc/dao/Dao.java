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
package br.facet.tcc.dao;

import java.util.List;

import br.facet.tcc.exception.DaoException;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public interface Dao<T> {
    /**
     * Persiste um objeto do tipo definido na classe
     * 
     * @since 0.0.1
     */
    public Integer salvar(T t) throws DaoException;

    /**
     * Atualiza um objeto do tipo definido na classe
     * 
     * @since 0.0.1
     */
    public void atualizar(T t) throws DaoException;

    /**
     * Remove um objeto do tipo definido na classe
     * 
     * @since 0.0.1
     */
    public void excluir(T t) throws DaoException;

    /**
     * Lista os objetos do tipo definido na classe
     * 
     * @return lista de objetos T
     * @param Class
     * @since 0.0.1
     */
    public List<T> listar(@SuppressWarnings("rawtypes") Class clazz)
        throws DaoException;

    /**
     * Pesquisa um objeto apartir dos parametros passado.
     * 
     * @return list de objetos encontrados
     * @since 0.0.1
     */
    public List<T> pesquisar(T t) throws DaoException;

    /**
     * Obtem objeto apartir do seu id
     * 
     * @param clazz
     *            classe do objeto que sera recuperado
     * @param id
     *            id do objeto
     * @return objeto que sera recuperado
     * @throws DaoException
     * @since 0.0.1
     */
    public T obterPorID(Class clazz, Integer id) throws DaoException;

}
