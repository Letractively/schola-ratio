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

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import br.facet.tcc.dao.InstituicaoDao;
import br.facet.tcc.pojo.Instituicao;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1 FIXME : implementacao antiga, não esta funcionando. Comparar
 *        com {@link EnderecoDaoImpl}
 * 
 */
@Transactional(readOnly = true)
public class InstituicaoDaoImpl implements InstituicaoDao {

    private SessionFactory sessionFactory;

    /**
     * @see br.facet.tcc.dao.InstituicaoDao#salvar(br.facet.tcc.pojo.Instituicao)
     * @since since optional
     */
    @Override
    @Transactional(readOnly = false)
    public void salvar(Instituicao instituicao) {

        this.sessionFactory.getCurrentSession().save(instituicao);
    }

    /**
     * @see br.facet.tcc.dao.InstituicaoDao#atualizar(br.facet.tcc.pojo.Instituicao)
     * @since since optional
     */
    @Override
    @Transactional(readOnly = false)
    public void atualizar(Instituicao instituicao) {
        this.sessionFactory.getCurrentSession().update(instituicao);
    }

    /**
     * @see br.facet.tcc.dao.InstituicaoDao#excluir(br.facet.tcc.pojo.Instituicao)
     * @since since optional
     */
    @Override
    @Transactional(readOnly = false)
    public void excluir(Instituicao instituicao) {
        this.sessionFactory.getCurrentSession().delete(instituicao);
    }

    /**
     * @see br.facet.tcc.dao.InstituicaoDao#listar()
     * @since since optional
     */
    @Override
    public List<Instituicao> listar() {
        List<Instituicao> instituicoes = this.sessionFactory
            .getCurrentSession().createQuery("from Instituicao").list();
        return instituicoes;
    }

    /**
     * @return
     * @see br.facet.tcc.dao.InstituicaoDao#pesquisar(br.facet.tcc.pojo.Instituicao)
     * @since since optional
     */
    @Override
    public List<Instituicao> pesquisar(Instituicao instituicao) {
        List<Instituicao> instituicoes = this.sessionFactory
            .getCurrentSession().createQuery("from Instituicao").list();
        return instituicoes;
    }

    /**
     * @param sessionFactory
     *            the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
