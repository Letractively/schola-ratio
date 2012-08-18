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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_usuario")
@SequenceGenerator(sequenceName = "seq_usuario", name = "seq_usuario", allocationSize = 1)
public class Usuario extends Pessoa {

    private Integer id;

    /**
     * @see br.facet.tcc.pojo.Pessoa#getId()
     * @since since optional
     */
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    public Integer getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
