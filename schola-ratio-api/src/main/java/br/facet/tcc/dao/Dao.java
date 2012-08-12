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

/**
 * @author Osnir F CUNHA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public interface Dao<T> {
    /**
     * @since 0.0.1
     */
    public Integer salvar(T t);

    /**
     * @since 0.0.1
     */
    public void atualizar(T t);

    /**
     * @since 0.0.1
     */
    public void excluir(T t);

    /**
     * @return
     * @since 0.0.1
     */
    public List<T> listar();

    /**
     * @return
     * @since 0.0.1
     */
    public List<T> pesquisar(T t);

}
