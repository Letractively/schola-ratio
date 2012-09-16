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

import java.util.HashMap;
import java.util.Map;

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

    public Map<String, br.facet.tcc.pojo.UserRoles> getUserRoles() {
        Map<String, br.facet.tcc.pojo.UserRoles> selectManyRoles = new HashMap<String, br.facet.tcc.pojo.UserRoles>();
        for (int i = 0; i < UserRoles.values().length; i++) {
            br.facet.tcc.pojo.UserRoles role;
            switch (UserRoles.values()[i]) {
            case ROLE_ACA:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setId(UserRoles.ROLE_ACA.getId());
                role.setUserRole(UserRoles.ROLE_ACA);
                selectManyRoles.put("Academico", role);
                break;
            case ROLE_ADM:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setId(UserRoles.ROLE_ADM.getId());
                role.setUserRole(UserRoles.ROLE_ADM);
                selectManyRoles.put("Administrativo", role);
                break;
            case ROLE_CFG:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setUserRole(UserRoles.ROLE_CFG);
                role.setId(UserRoles.ROLE_CFG.getId());
                selectManyRoles.put("Configurações", role);
                break;
            case ROLE_FIN:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setUserRole(UserRoles.ROLE_FIN);
                role.setId(UserRoles.ROLE_FIN.getId());
                selectManyRoles.put("Financeiro", role);
                break;
            case ROLE_USR:
                role = new br.facet.tcc.pojo.UserRoles();
                role.setUserRole(UserRoles.ROLE_USR);
                role.setId(UserRoles.ROLE_USR.getId());
                selectManyRoles.put("Usuario", role);
                break;

            default:
                break;
            }
        }

        return selectManyRoles;
    }
}
