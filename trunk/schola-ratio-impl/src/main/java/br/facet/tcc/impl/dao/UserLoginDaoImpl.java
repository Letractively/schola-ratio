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
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository("userLoginDao")
public class UserLoginDaoImpl extends DaoConfiguration<UserLogin> {

    /**
     * @see br.facet.tcc.impl.dao.DaoConfiguration#salvar(java.lang.Object)
     * @since since optional
     * 
     *        FIXME : Verificar a melhor forma de tratar o retorno do metodo
     *        salvar
     * 
     * 
     */
    @Override
    public Integer salvar(UserLogin t) throws DaoException {
        String pwd = t.getPassword();

        t.setPassword(DigestUtils.shaHex(pwd));
        this.save(t);
        return null;
    }

    public UserLogin obterPorID(String userName) throws DaoException {
        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(userName);

        return this.pesquisar(userLogin).get(0);
    }

}
