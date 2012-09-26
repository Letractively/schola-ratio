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
package br.facet.tcc.impl.managed.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;
import org.springframework.stereotype.Component;

import br.facet.tcc.objects.MenuPermissionMap;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
@ManagedBean(name = "menuPermissionLoaderMB")
@SessionScoped
public class MenuPermissionLoaderMB {

    @Resource(name = "mainMenu")
    private List<MenuPermissionMap> mainMenu;

    private List<MenuPermissionMap> mainMenuPermited;

    private User user;

    /**
     * @return the user
     */
    public User getUser() {
        this.user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return user;
    }

    /**
     * @return the mainMenuPermited
     */
    public List<MenuPermissionMap> getMainMenuPermited() {
        this.mainMenuPermited = new ArrayList<MenuPermissionMap>();
        for (int i = 0; i < this.user.getAuthorities().length; i++) {
            for (MenuPermissionMap urlPermission : mainMenu) {

                if (urlPermission.getRole().name()
                        .equals(this.user.getAuthorities()[i].getAuthority())) {

                    this.mainMenuPermited.add(urlPermission);

                }

            }
        }
        return mainMenuPermited;
    }

}
