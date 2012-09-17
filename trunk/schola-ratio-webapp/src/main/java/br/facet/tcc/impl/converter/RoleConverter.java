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
package br.facet.tcc.impl.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.facet.tcc.pojo.UserRoles;

/**
 * @author TODO: author_name
 * 
 * @version TODO: class_version
 * @since TODO: package_version
 */
@FacesConverter("roleConverter")
public class RoleConverter implements Converter {

    /**
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.String)
     * @since since optional
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        System.out.println(" ============ getAsObject ===============");
        UserRoles role = new UserRoles();
        for (br.facet.tcc.enums.UserRoles userRoles : br.facet.tcc.enums.UserRoles
                .values()) {
            if (userRoles.getDescricao().equals(value)) {
                role.setId(userRoles.getId());
                role.setUserRole(userRoles);

            }
        }
        return role;
    }

    /**
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.Object)
     * @since since optional
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        System.out.println(" ============ getAsString ===============");
        String retorno = ((UserRoles) value).getUserRole().getDescricao();

        return retorno;
    }

}
