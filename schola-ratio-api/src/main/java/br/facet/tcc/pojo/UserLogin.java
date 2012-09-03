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
package br.facet.tcc.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.facet.tcc.annotations.Searchable;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_user_login")
public class UserLogin implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 722657699635191181L;

    private String username;

    private String password;

    private boolean enable;

    // private List<Permissao> permissoes;

    /**
     * @return the username
     */
    @Id
    @Column(name = "user_name")
    @Searchable
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    @Column
    public String getPassword() {
        return password;
    }

    /**
     * @return the enable
     */
    @Column(columnDefinition = "BOOLEAN")
    public boolean isEnable() {
        return enable;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param enable
     *            the enable to set
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    /**
     * @see java.lang.Object#toString()
     * @since since optional
     */
    @Override
    public String toString() {
        return this.username;
    }

}
