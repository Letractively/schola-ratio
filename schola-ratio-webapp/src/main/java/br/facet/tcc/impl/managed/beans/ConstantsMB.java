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

import br.facet.tcc.enums.Bimestre;
import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.HorarioDeAulas;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.SituacaoAlunoCurso;
import br.facet.tcc.enums.Status;
import br.facet.tcc.enums.TipoTitulo;
import br.facet.tcc.enums.UserRoles;
import br.facet.tcc.pojo.HorarioDeAula;

/**
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

    public Status[] getStatusList() {
        return Status.values();
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

    public TipoTitulo[] getTitulos() {
        return TipoTitulo.values();
    }

    public List<HorarioDeAula> getHorariosDeAula() {
        List<HorarioDeAula> lista = new ArrayList<HorarioDeAula>();
        for (HorarioDeAulas horarioDeAula : HorarioDeAulas.values()) {
            HorarioDeAula horarioDeA = new HorarioDeAula(horarioDeAula);
            horarioDeA.setId(horarioDeAula.getId());
            horarioDeA.setHorarioDeAulas(horarioDeAula);

            lista.add(horarioDeA);
        }
        return lista;
    }

    public SituacaoAlunoCurso[] getSituacaoAlunoCurso() {
        return SituacaoAlunoCurso.values();
    }
}
