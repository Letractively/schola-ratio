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

import br.facet.tcc.pojo.HorarioDeAula;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@FacesConverter("horarioDeAulaConverter")
public class HorarioDeAulaConverter implements Converter {

    /**
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.String)
     * @since since optional
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        HorarioDeAula hda = null;
        for (br.facet.tcc.enums.HorarioDeAulas horario : br.facet.tcc.enums.HorarioDeAulas
                .values()) {
            if (horario.getValue().equals(value)) {
                hda = new HorarioDeAula(horario);

            }
        }
        return hda;
    }

    /**
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.Object)
     * @since since optional
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String retorno = ((HorarioDeAula) value).getHorarioDeAulas().getValue();
        return retorno;
    }

}
