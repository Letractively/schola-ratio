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
@Repository("usuarioDao")
public class UsuarioDaoImpl extends DaoConfiguration<Usuario> {

    @Override
    public Integer salvar(Usuario t) throws DaoException {
        String password = DigestUtils.shaHex(t.getUserLogin().getPassword());
        t.getUserLogin().setPassword(password);
        return super.salvar(t);
    }

}