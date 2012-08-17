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
     * Persiste um objeto do tipo definido na classe
     * 
     * @since 0.0.1
     */
    public Integer salvar(T t);

    /**
     * Atualiza um objeto do tipo definido na classe
     * 
     * @since 0.0.1
     */
    public void atualizar(T t);

    /**
     * Remove um objeto do tipo definido na classe
     * 
     * @since 0.0.1
     */
    public void excluir(T t);

    /**
     * Lista os objetos do tipo definido na classe
     * 
     * @return lista de objetos T
     * @param Class
     * @since 0.0.1
     */
    public List<T> listar(@SuppressWarnings("rawtypes") Class clazz);

    /**
     * Pesquisa um objeto apartir dos parametros passado.
     * 
     * @return list de objetos encontrados
     * @since 0.0.1
     */
    public List<T> pesquisar(T t);

}
