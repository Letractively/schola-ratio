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
import br.facet.tcc.pojo.Professor;
import br.facet.tcc.pojo.Turma;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository("turmaDao")
public class TurmaDaoImpl extends DaoConfiguration<Turma> {

    @Override
    public void atualizar(Turma t) throws DaoException {
        super.atualizar(t);
    }

    @Override
    public Integer salvar(Turma t) throws DaoException {
        return super.salvar(t);
    }

    @Override
    public void excluir(Turma t) throws DaoException {
        super.excluir(t);
    }

    @Override
    public List<Turma> listar(Class clazz) throws DaoException {
        return super.listar(clazz);
    }

    @Override
    public List<Turma> pesquisar(Turma t) throws DaoException {
        Criteria criteria = this.getSession().createCriteria(Turma.class, "T");

        Conjunction discipl = Restrictions.conjunction();
        Conjunction profes = Restrictions.conjunction();
        if (t.getDisciplina() != null) {
            discipl.add(Subqueries.exists(DetachedCriteria.forClass(
                    Disciplina.class).setProjection(Projections.id())));
            criteria.createAlias("T.disciplina", "d");

            if (t.getDisciplina().getCurso() != null) {
                Conjunction curso = Restrictions.conjunction();
                curso.add(Subqueries.exists(DetachedCriteria.forClass(
                        Curso.class).setProjection(Projections.id())));
                criteria.createAlias("d.curso", "c");
                curso.add(Restrictions.eq("c.id", t.getDisciplina().getCurso()
                        .getId()));
                curso.add(Restrictions.eqProperty("d.curso.id", "c.id"));

                discipl.add(curso);
            }

            if (t.getDisciplina().getId() != null
                    && t.getDisciplina().getId() != 0) {
                discipl.add(Restrictions.eq("d.id", t.getDisciplina().getId()));
            }

            if (t.getDisciplina().getNome() != null
                    && !"".equals(t.getDisciplina().getNome())) {
                discipl.add(Restrictions.ilike("d.nome", t.getDisciplina()
                        .getNome()));
            }

            discipl.add(Restrictions.eqProperty("T.disciplina.id", "d.id"));
            criteria.add(discipl);

        }
        if (t.getProfessor() != null) {
            profes.add(Subqueries.exists(DetachedCriteria.forClass(
                    Professor.class).setProjection(Projections.id())));
            criteria.createAlias("T.professor", "p");

            if (t.getProfessor().getId() != null
                    && t.getProfessor().getId() != 0) {
                profes.add(Restrictions.eq("p.id", t.getProfessor().getId()));
            }

            if (t.getProfessor().getNome() != null
                    && !"".equals(t.getProfessor().getId())) {
                profes.add(Restrictions.ilike("p.nome", "%"
                        + t.getProfessor().getNome() + "%"));
            }

            profes.add(Restrictions.eqProperty("T.professor.id", "p.id"));

            criteria.add(profes);
        }
        if (!"".equals(t.getAno()) && t.getAno() != null) {
            criteria.add(Restrictions.eq("T.ano", t.getAno()));
        }

        return criteria.list();

    }
}
