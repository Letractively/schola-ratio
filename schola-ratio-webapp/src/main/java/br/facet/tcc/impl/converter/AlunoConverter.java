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

import org.apache.log4j.Logger;

import br.facet.tcc.exception.ServiceException;
import br.facet.tcc.impl.service.GestaoAlunoCursoImpl;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;

/**
 * @author Osnir F CUNHA
 * 
 */
@ManagedBean(name = "alunoConverter")
@RequestScoped
@FacesConverter("alunoConverter")
public class AlunoConverter implements Converter {

    private static final Logger log = Logger.getLogger(AlunoConverter.class);

    @ManagedProperty("#{alunoCursoService}")
    private GestaoAlunoCursoImpl alunoService;

    /**
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.String)
     * @since since optional
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        AlunoCurso alunoCurso = new AlunoCurso();
        Aluno aluno = new Aluno();
        aluno.setNome(value);

        alunoCurso.setAluno(aluno);

        try {
            log.debug("buscando " + value + " em AlunoConverter");
            List<AlunoCurso> alunos = this.alunoService
                    .consultarUsuario(alunoCurso);
            alunoCurso = alunos.get(0);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        log.debug("Retornando " + aluno + " em getAsObject");
        return alunoCurso;
    }

    /**
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext,
     *      javax.faces.component.UIComponent, java.lang.Object)
     * @since since optional
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {
        AlunoCurso aluno = (AlunoCurso) value;
        log.debug("Retornando" + value + " em getAsString");
        return aluno.getAluno().getNome();
    }

    public void setAlunoService(GestaoAlunoCursoImpl alunoService) {
        this.alunoService = alunoService;
    }
}
