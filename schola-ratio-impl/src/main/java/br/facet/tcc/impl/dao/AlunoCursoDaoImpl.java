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
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository("alunoCursoDao")
public class AlunoCursoDaoImpl extends DaoConfiguration<AlunoCurso> {

    @Override
    public List<AlunoCurso> pesquisar(AlunoCurso t) throws DaoException {
        Criteria criteria = this.getSession().createCriteria(AlunoCurso.class,
                "AC");

        Conjunction aluno = Restrictions.conjunction();
        Conjunction userLogin = Restrictions.conjunction();
        if (t.getAluno() != null) {
            aluno.add(Subqueries.exists(DetachedCriteria.forClass(Aluno.class)
                    .setProjection(Projections.id())));
            criteria.createAlias("AC.aluno", "a");
            // Nome
            if (!"".equals(t.getAluno().getNome())
                    && t.getAluno().getNome() != null) {
                aluno.add(Restrictions.ilike("a.nome", "%"
                        + t.getAluno().getNome() + "%"));
            }
            // CPF
            if (t.getAluno().getCpf() != null) {
                aluno.add(Restrictions.eq("a.cpf", t.getAluno().getCpf()));
            }
            aluno.add(Restrictions.eq("a.status", t.getAluno().getStatus()));

            aluno.add(Restrictions.eqProperty("AC.aluno.id", "a.id"));

            if (t.getAluno().getUserLogin() != null
                    && t.getAluno().getUserLogin().getUsername() != null) {
                userLogin.add(Subqueries.exists(DetachedCriteria.forClass(
                        UserLogin.class).setProjection(Projections.id())));
                criteria.createAlias("a.userLogin", "ul");
                userLogin.add(Restrictions.ilike("ul.username", "%"
                        + t.getAluno().getUserLogin().getUsername() + "%"));
                userLogin.add(Restrictions
                        .eqProperty("a.userLogin.id", "ul.id"));
            }

            criteria.add(aluno.add(userLogin));
        }

        return criteria.list();
    }
}
