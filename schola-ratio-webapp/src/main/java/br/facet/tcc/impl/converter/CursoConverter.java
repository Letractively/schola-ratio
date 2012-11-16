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

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAdministrativoImpl;
import br.facet.tcc.pojo.Curso;

/**
 * @author Osnir F CUNHA
 * 
 */
@ManagedBean(name = "cursoConverter")
@RequestScoped
@FacesConverter("cursoConverter")
public class CursoConverter implements Converter {

    @ManagedProperty("#{gestaoAdministrativo}")
    private GestaoAdministrativoImpl gestaoAdministrativo;

    /**
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.String)
     * @since since optional
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {
        Curso curso = new Curso();
        curso.setNome(value);

        Curso retorno = null;

        try {
            List<Curso> cursos = this.gestaoAdministrativo.buscarCurso(curso);
            retorno = cursos.isEmpty() ? null : cursos.get(0);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return retorno;
    }

    /**
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.Object)
     * @since since optional
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        Curso curso = (Curso) value;
        return curso != null ? curso.getNome() : null;
    }

    public void setGestaoAdministrativo(
            GestaoAdministrativoImpl gestaoAdministrativo) {
        this.gestaoAdministrativo = gestaoAdministrativo;
    }

}
