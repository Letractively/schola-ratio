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
package br.facet.tcc.pojo;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;

import br.facet.tcc.annotations.Searchable;
import br.facet.tcc.enums.TipoTitulo;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_professor")
@SequenceGenerator(sequenceName = "seq_professor", name = "seq_professor", allocationSize = 1)
public class Professor extends Pessoa implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1973568054583894362L;

    private Integer id;

    private TipoTitulo titulo;

    private String descricaoTitulo;

    private Set<Disciplina> disciplinasQueLeciona;

    private Set<HorarioDeAula> horarioDisponivel;

    public Professor() {
        this.horarioDisponivel = new LinkedHashSet<HorarioDeAula>();
    }

    /**
     * @see br.facet.tcc.pojo.Pessoa#getId()
     * @since since optional
     */
    @Id
    @Column(name = "professor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_professor")
    @Searchable
    public Integer getId() {
        return this.id;
    }

    /**
     * @return the titulo
     */
    @Enumerated(EnumType.STRING)
    @Column
    @Searchable
    public TipoTitulo getTitulo() {
        return titulo;
    }

    /**
     * @return the descricaoTitulo
     */
    @Column
    public String getDescricaoTitulo() {
        return descricaoTitulo;
    }

    /**
     * @return the horarioDisponivel
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @IndexColumn(name = "idx_col")
    @Fetch(FetchMode.SUBSELECT)
    @Searchable(collectionSearch = true)
    public Set<HorarioDeAula> getHorarioDisponivel() {
        return horarioDisponivel;
    }

    /**
     * @return the disciplinasQueLeciona
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @IndexColumn(name = "idx_col")
    @Fetch(FetchMode.SUBSELECT)
    @Searchable(collectionSearch = true)
    public Set<Disciplina> getDisciplinasQueLeciona() {
        return disciplinasQueLeciona;
    }

    /**
     * @param titulo
     *            the titulo to set
     */
    public void setTitulo(TipoTitulo titulo) {
        this.titulo = titulo;
    }

    /**
     * @param descricaoTitulo
     *            the descricaoTitulo to set
     */
    public void setDescricaoTitulo(String descricaoTitulo) {
        this.descricaoTitulo = descricaoTitulo;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param horarioDisponivel
     *            the horarioDisponivel to set
     */
    public void setHorarioDisponivel(Set<HorarioDeAula> horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    /**
     * @param disciplinasQueLeciona
     *            the disciplinasQueLeciona to set
     */
    public void setDisciplinasQueLeciona(Set<Disciplina> disciplinasQueLeciona) {
        this.disciplinasQueLeciona = disciplinasQueLeciona;
    }
}
