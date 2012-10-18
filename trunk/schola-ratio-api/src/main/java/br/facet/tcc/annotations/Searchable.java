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
package br.facet.tcc.annotations;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Usada para definir se um atributo de uma classe é 'Searchable' (procuravel).<br>
 * Deve ser adicionada ao metodo get do atributo que se deseja procurar.
 * 
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Target({ METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Searchable {

    /**
     * Se for uma classe definida
     * 
     * @since 0.0.1
     */
    boolean innerSearch() default false;

    /**
     * Se for uma Coleção
     * 
     * @since 0.0.1
     */
    boolean collectionSearch() default false;
}
