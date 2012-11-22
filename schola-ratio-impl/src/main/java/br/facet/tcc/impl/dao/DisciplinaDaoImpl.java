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
package br.facet.tcc.impl.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import br.facet.tcc.exception.DaoException;
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.Disciplina;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository("disciplinaDao")
public class DisciplinaDaoImpl extends DaoConfiguration<Disciplina> {

    @Override
    public Integer salvar(Disciplina t) throws DaoException {
        return super.salvar(t);
    }

    @Override
    public void excluir(Disciplina t) throws DaoException {
        super.excluir(t);
    }

    @Override
    public void atualizar(Disciplina t) throws DaoException {
        super.atualizar(t);
    }

    @Override
    public List<Disciplina> pesquisar(Disciplina t) throws DaoException {
        Criteria criteria = this.getSession().createCriteria(Disciplina.class,
                "D");

        Conjunction curso = Restrictions.conjunction();
        if (t.getCurso() != null) {
            curso.add(Subqueries.exists(DetachedCriteria.forClass(Curso.class)
                    .setProjection(Projections.id())));
            criteria.createAlias("D.curso", "c");

            if (t.getCurso().getNome() != null
                    && !"".equals(t.getCurso().getNome())) {
                curso.add(Restrictions.ilike("c.nome", "%"
                        + t.getCurso().getNome() + "%"));
            }
            if (t.getCurso().getId() != null) {
                curso.add(Restrictions.eq("c.id", t.getCurso().getId()));
            }

            curso.add(Restrictions.eqProperty("D.curso.id", "c.id"));
            criteria.add(curso);

        }
        if (!"".equals(t.getNome()) && t.getNome() != null) {
            criteria.add(Restrictions.ilike("D.nome", "%" + t.getNome() + "%"));
        }
        if (!"".equals(t.getPeriodo()) && t.getPeriodo() != null) {
            criteria.add(Restrictions.eq("D.periodo", t.getPeriodo()));
        }
        if (!"".equals(t.getCargaHoraria()) && t.getCargaHoraria() != null) {
            criteria.add(Restrictions.eq("D.cargaHoraria", t.getCargaHoraria()));
        }

        criteria.add(Restrictions.eq("D.status", t.getStatus()));

        return criteria.list();
    }

    @Override
    public List<Disciplina> listar(Class clazz) throws DaoException {
        return super.listar(clazz);
    }

}
