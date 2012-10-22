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
import br.facet.tcc.impl.service.GestaoProfessorImpl;
import br.facet.tcc.pojo.Professor;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.2
 * @since 0.0.2
 */
@ManagedBean(name = "professorConverter")
@RequestScoped
@FacesConverter("professorConverter")
public class ProfessorConverter implements Converter {

    @ManagedProperty("#{professorService}")
    private GestaoProfessorImpl gestaoProfessor;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        Professor professor = new Professor();
        professor.setNome(value);

        try {
            List<Professor> professores = this.gestaoProfessor
                    .consultarUsuario(professor);
            professor = professores.get(0);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return professor;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        String retorno = ((Professor) value).getNome();
        return retorno;
    }

    /**
     * @param gestaoProfessor
     *            the gestaoProfessor to set
     */
    public void setGestaoProfessor(GestaoProfessorImpl gestaoProfessor) {
        this.gestaoProfessor = gestaoProfessor;
    }

}
