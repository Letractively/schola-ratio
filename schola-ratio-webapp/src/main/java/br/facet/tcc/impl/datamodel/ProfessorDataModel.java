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
package br.facet.tcc.impl.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;
import org.springframework.stereotype.Component;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoProfessorImpl;
import br.facet.tcc.pojo.Professor;

/**
 * @author TODO: Djulles IKEDA
 * 
 * @version 1.0.2
 * @since 23 SEP 2012
 */

@Component
public class ProfessorDataModel extends ListDataModel<Professor> implements
        SelectableDataModel<Professor>, Serializable {

    @Resource(name = "professorService")
    private GestaoProfessorImpl gestaoProfessorImpl;

    /**
* 
*/
    private static final long serialVersionUID = -5816551491570174057L;

    /**
     * @since 0.0.1
     */
    public ProfessorDataModel() {
    }

    /**
     * @param list
     * @since 0.0.1
     */
    public ProfessorDataModel(List<Professor> list) {
        super(list);
    }

    /**
     * @see org.primefaces.model.SelectableDataModel#getRowKey(java.lang.Object)
     * @since since optional
     */
    @Override
    public Object getRowKey(Professor professor) {
        Integer id = professor.getId();
        return id;
    }

    /**
     * @see org.primefaces.model.SelectableDataModel#getRowData(java.lang.String)
     * @since since optional
     */
    @Override
    public Professor getRowData(String rowKey) {
        Integer id = Integer.parseInt(rowKey);
        Professor professor = null;
        try {
            professor = this.gestaoProfessorImpl.consultarUsuario(
                    Professor.class, id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return professor;
    }

}
