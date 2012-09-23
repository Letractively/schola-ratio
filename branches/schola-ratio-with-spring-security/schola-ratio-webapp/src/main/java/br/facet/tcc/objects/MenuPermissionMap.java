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
package br.facet.tcc.objects;

import java.util.List;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import br.facet.tcc.enums.UserRoles;

/**
 * @author Osnir F CUNHA
 * 
 * @version 0.0.1
 * @since 0.0.1
 */
public class MenuPermissionMap {

    /**
     * Nome do Menu
     */
    private String menuName;

    /**
     * Lista de Menu Items
     */
    private List<MenuItem> urlsMenuMap;

    /**
     * Permissão Referente a este menu
     */
    private UserRoles role;

    /**
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @return the urlsMenuMap
     */
    public List<MenuItem> getUrlsMenuMap() {
        return urlsMenuMap;
    }

    /**
     * @return the role
     */
    public UserRoles getRole() {
        return role;
    }

    public MenuModel getMenuModel() {
        MenuModel menuModel = new DefaultMenuModel();

        for (MenuItem menuItem : this.urlsMenuMap) {
            menuModel.addMenuItem(menuItem);
        }
        return menuModel;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(UserRoles role) {
        this.role = role;
    }

    /**
     * @param urlsMenuMap
     *            the urlsMenuMap to set
     */
    public void setUrlsMenuMap(List<MenuItem> urlsMenuMap) {
        this.urlsMenuMap = urlsMenuMap;
    }

    /**
     * @param menuName
     *            the menuName to set
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

}
