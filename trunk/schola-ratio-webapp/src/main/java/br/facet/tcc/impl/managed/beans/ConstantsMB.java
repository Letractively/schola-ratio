/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of HSBC Holdings plc.
 */
package br.facet.tcc.impl.managed.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.facet.tcc.enums.Bimestre;
import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.UserRoles;

/**
 * <b>FIXME</b>: Each class and interface specification must include:
 * <OL>
 * <LI><b>Executive summary</b></LI>
 * <LI><b>State Information</b></LI>
 * <LI><b>OS/Hardware Dependencies</b></LI>
 * <LI><b>Allowed Implementation Variances</b></LI>
 * <LI><b>Security Constraints</b></LI>
 * <LI><b>Serialized Form</b></LI>
 * <LI><b>References to any External Specifications</b></LI>
 * </OL>
 * Refer to <a
 * href="http://java.sun.com/j2se/javadoc/writingapispecs/index.html#class"
 * >Class/Interface Specification</a> for more information
 * <p>
 * <b>Creation Time:</b> 04/09/2012 01:20:41
 * 
 * @author Osnir F CUNHA
 * @version 0.0.1
 * @since schola-ratio-webapp
 */

public abstract class ConstantsMB {

    /**
     * @return
     * 
     * @since schola-ratio-webapp 0.0.1
     */
    public Bimestre[] getBimestreList() {
        return Bimestre.values();
    }

    /**
     * @return
     * @since schola-ratio-webapp 0.0.1
     */
    public Estado[] getEstadoList() {
        return Estado.values();
    }

    public Sexo[] getSexoList() {
        return Sexo.values();
    }

    public List getUserRoles_() {
        List selectManyRoles = new ArrayList();
        for (int i = 0; i < UserRoles.values().length; i++) {
            br.facet.tcc.pojo.UserRoles role;
            switch (UserRoles.values()[i]) {
            case ROLE_ACA:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setId(UserRoles.ROLE_ACA.getId());
                role.setUserRole(UserRoles.ROLE_ACA);
                selectManyRoles.add(new SelectItem(role, "Academico"));
                break;
            case ROLE_ADM:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setId(UserRoles.ROLE_ADM.getId());
                role.setUserRole(UserRoles.ROLE_ADM);
                selectManyRoles.add(new SelectItem(role, "Administrativo"));
                break;
            case ROLE_CFG:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setUserRole(UserRoles.ROLE_CFG);
                role.setId(UserRoles.ROLE_CFG.getId());
                selectManyRoles.add(new SelectItem(role, "Configurações"));
                break;
            case ROLE_FIN:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setUserRole(UserRoles.ROLE_FIN);
                role.setId(UserRoles.ROLE_FIN.getId());
                selectManyRoles.add(new SelectItem(role, "Financeiro"));
                break;
            case ROLE_USR:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setUserRole(UserRoles.ROLE_USR);
                role.setId(UserRoles.ROLE_USR.getId());
                selectManyRoles.add(new SelectItem(role, "Usuario"));
                break;

            default:
                break;
            }
        }

        return selectManyRoles;
    }

    public List<br.facet.tcc.pojo.UserRoles> getUserRoles() {
        List<br.facet.tcc.pojo.UserRoles> roles = new ArrayList<br.facet.tcc.pojo.UserRoles>();
        for (UserRoles userRole : UserRoles.values()) {
            br.facet.tcc.pojo.UserRoles role = new br.facet.tcc.pojo.UserRoles();
            role.setId(userRole.getId());
            role.setUserRole(userRole);

            roles.add(role);
        }

        return roles;
    }
}
