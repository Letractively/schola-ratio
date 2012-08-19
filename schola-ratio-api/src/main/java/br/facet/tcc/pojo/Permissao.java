/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 *
 * Copyright (c) 2012
 * All rights reserved.
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
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Djulles IKEDA
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */

@Entity
@Table(name = "tb_permissao")
@SequenceGenerator(name = "seq_permissao", sequenceName = "seq_permissao", allocationSize = 1)
public class Permissao {
    private Integer id;

    private String tipoPermissao;

    private String descricaoPermissao;

    /**
     * @return the id
     */

    @Id
    @GeneratedValue(generator = "seq_permissao")
    @Column(name = "permissao_id")
    public Integer getId() {
        return id;
    }

    /**
     * @return the tipoPermissao
     */
    @Column
    public String getTipoPermissao() {
        return tipoPermissao;
    }

    /**
     * @return the descricaoPermissao
     */

    @Column
    public String getDescricaoPermissao() {
        return descricaoPermissao;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param tipoPermissao
     *            the tipoPermissao to set
     */
    public void setTipoPermissao(String tipoPermissao) {
        this.tipoPermissao = tipoPermissao;
    }

    /**
     * @param descricaoPermissao
     *            the descricaoPermissao to set
     */
    public void setDescricaoPermissao(String descricaoPermissao) {
        this.descricaoPermissao = descricaoPermissao;
    }

}
