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

import br.facet.tcc.pojo.Instituicao;

/**
 * @author Osnir F CUNHA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
public interface InstituicaoDao {

    public void salvar(Instituicao instituicao);

    public void atualizar(Instituicao instituicao);

    public void excluir(Instituicao instituicao);

    public List<Instituicao> listar();

    public List<Instituicao> pesquisar(Instituicao instituicao);

}
