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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.UserRoles;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1 Entity Table(name = "tb_permissao")
 *        SequenceGenerator(sequenceName = "seq_permissao", name =
 *        "seq_permissao", initialValue = 1)
 */

public class Permissao implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 5913393066760408864L;

	private Integer id;

	private UserRoles role;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permissao")
	@Searchable
	public Integer getId() {
		return id;
	}

	/**
	 * @return the role
	 */
	@Column
	@Enumerated(EnumType.STRING)
	@Searchable
	public UserRoles getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(UserRoles role) {
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
