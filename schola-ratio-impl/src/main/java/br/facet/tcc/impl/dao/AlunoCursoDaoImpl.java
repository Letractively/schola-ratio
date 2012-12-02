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

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
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
import br.facet.tcc.pojo.Curso;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Djulles IKEDA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@SuppressWarnings("serial")
@Repository("alunoCursoDao")
public class AlunoCursoDaoImpl extends DaoConfiguration<AlunoCurso> {

    private static final Logger LOG = Logger.getLogger(AlunoCursoDaoImpl.class);

    @Override
    public Integer salvar(AlunoCurso t) throws DaoException {
        String password = t.getAluno().getUserLogin().getPassword();
        t.getAluno()
                .getUserLogin()
                .setPassword(
                        password.length() == 40 ? password : DigestUtils
                                .shaHex(password));
        return super.salvar(t);
    }

    @Override
    public void atualizar(AlunoCurso t) throws DaoException {
        String password = t.getAluno().getUserLogin().getPassword();
        t.getAluno()
                .getUserLogin()
                .setPassword(
                        password.length() == 40 ? password : DigestUtils
                                .shaHex(password));
        super.atualizar(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AlunoCurso> pesquisar(AlunoCurso t) throws DaoException {
        Criteria criteria = this.getSession().createCriteria(AlunoCurso.class,
                "AC");

        Conjunction aluno = Restrictions.conjunction();
        Conjunction userLogin = Restrictions.conjunction();
        Conjunction curso = Restrictions.conjunction();
        if (t.getAluno() != null) {
            LOG.info("Adicionando Aluno à busca.");
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
                aluno.add(userLogin);
            }

            criteria.add(aluno);

        }
        if (t.getCurso() != null) {
            LOG.info("Adicionando Curso à busca.");
            curso.add(Subqueries.exists(DetachedCriteria.forClass(Curso.class)
                    .setProjection(Projections.id())));
            criteria.createAlias("AC.curso", "c");

            curso.add(Restrictions.eq("c.id", t.getCurso().getId()));
            curso.add(Restrictions.eqProperty("AC.curso.id", "c.id"));

            criteria.add(curso);
        }

        if (t.getSituacaoAlunoCurso() != null) {
            LOG.info("Adicionando Situação à busca.");
            criteria.add(Restrictions.eq("AC.situacaoAlunoCurso",
                    t.getSituacaoAlunoCurso()));
        }

        LOG.info("Criteria criada : " + criteria.toString());
        return criteria.list();
    }
}
