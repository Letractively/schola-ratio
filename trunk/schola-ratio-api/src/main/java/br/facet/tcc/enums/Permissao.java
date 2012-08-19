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
package br.facet.tcc.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */

@Entity
@Table(name = "tb_permissao")
@SequenceGenerator(name = "seq_permissao", sequenceName = "seq_permissao", allocationSize = 1)
public enum Permissao {

    ROLE_PROFESSOR, ROLE_SECRETARIA, ROLE_ADMINISTRADOR, ROLE_FINANCEIRO;

    @Id
    @GeneratedValue(generator = "seq_permissao")
    @Column
    private Integer id;

    @Column
    private String value;

    private Permissao() {
        this.value = this.toString();
    }
}
