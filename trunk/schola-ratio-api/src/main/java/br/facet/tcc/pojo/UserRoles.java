/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of HSBC Holdings plc.
 */
package br.facet.tcc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b>Creation Time:</b> 07/09/2012 00:32:27
 * 
 * @author Osnir F CUNHA
 * @version 0.0.1
 * @since schola-ratio-api
 */
@Entity
@Table(name = "tb_user_roles")
@SequenceGenerator(sequenceName = "seq_user_roles", name = "seq_user_roles", initialValue = 1)
public class UserRoles {

	private Integer id;

	private br.facet.tcc.enums.UserRoles userRole;

	/**
	 * Returns the id
	 * 
	 * @return the id
	 * @since schola-ratio-api package_version
	 */
	@Id
	public Integer getId() {
		return this.userRole.getId();
	}

	/**
	 * Returns the userRole
	 * 
	 * @return the userRole
	 * @since schola-ratio-api package_version
	 */

	@Enumerated(EnumType.STRING)
	@Column
	public br.facet.tcc.enums.UserRoles getUserRole() {
		return userRole;
	}

	/**
	 * Sets the id
	 * 
	 * @param id
	 *            the id to set
	 * @since schola-ratio-api package_version
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the userRole
	 * 
	 * @param userRole
	 *            the userRole to set
	 * @since schola-ratio-api package_version
	 */
	public void setUserRole(br.facet.tcc.enums.UserRoles userRole) {
		this.userRole = userRole;
	}
}
