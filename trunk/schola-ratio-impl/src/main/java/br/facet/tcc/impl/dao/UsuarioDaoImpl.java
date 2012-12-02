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
package br.facet.tcc.impl.dao;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Repository;

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Usuario;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Repository("usuarioDao")
public class UsuarioDaoImpl extends DaoConfiguration<Usuario> {

    @Override
    public Integer salvar(Usuario t) throws DaoException {
        String password = DigestUtils.shaHex(t.getUserLogin().getPassword());
        t.getUserLogin().setPassword(password);
        return super.salvar(t);
    }

    @Override
    public void atualizar(Usuario t) throws DaoException {
        String password = t.getUserLogin().getPassword();
        t.getUserLogin().setPassword(
                password.length() == 40 ? password : DigestUtils
                        .shaHex(password));
        super.atualizar(t);
    }

    @Override
    public void excluir(Usuario t) throws DaoException {
        super.excluir(t);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List<Usuario> listar(Class clazz) throws DaoException {
        return super.listar(clazz);
    }

    @Override
    public List<Usuario> pesquisar(Usuario t) throws DaoException {
        return super.pesquisar(t);
    }
}