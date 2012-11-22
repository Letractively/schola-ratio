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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAdministrativoImpl;
import br.facet.tcc.pojo.Disciplina;
import br.facet.tcc.pojo.Professor;
import br.facet.tcc.pojo.Turma;

/**
 * @author Osnir F CUNHA
 * 
 */
@ManagedBean(name = "turmaConverter")
@RequestScoped
@FacesConverter("turmaConverter")
public class TurmaConverter implements Converter {

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
        String[] values = value.split("-");
        String disciplina = values[0];
        String professor = values[1];

        Turma turma = new Turma();

        Disciplina disci = new Disciplina();
        disci.setNome(disciplina);

        Professor prof = new Professor();
        prof.setNome(professor);
        turma.setDisciplina(disci);

        try {
            turma = this.gestaoAdministrativo.buscarTurma(turma).get(0);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return turma;
    }

    /**
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.Object)
     * @since since optional
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        Turma turma = (Turma) value;
        return turma.toString();
    }

}
