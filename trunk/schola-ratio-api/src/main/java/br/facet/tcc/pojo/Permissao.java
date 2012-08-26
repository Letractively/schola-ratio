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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "tb_permissao")
public class Permissao {

    private Integer id;

    private UserLogin usuario;

    private String role;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    /**
     * @return the usuario
     */
    @ManyToOne
    @JoinColumn(name = "username")
    public UserLogin getUsuario() {
        return usuario;
    }

    /**
     * @return the role
     */
    @Column
    public String getRole() {
        return role;
    }

    /**
     * @param usuario
     *            the usuario to set
     */
    public void setUsuario(UserLogin usuario) {
        this.usuario = usuario;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
