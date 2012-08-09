
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
package br.facet.tcc.enums;


 /**
 * @author Osnir F CUNHA
 *
 * @version 0.0.1
 * @since 0.0.1 
 */
public enum Estado {  
    AC("Acre"),  
    AL("Alagoas"),  
    AP("Amapá"),  
    AM("Amazonas"),  
    BA("Bahia"),  
    CE("Ceará"),  
    DF("Distrito Federal"),  
    GO("Goiás"),  
    ES("Espírito Santo"),  
    MA("Maranhão"),  
    MT("Mato Grosso"),  
    MS("Mato Grosso do Sul"),  
    MG("Minas Gerais"),  
    PA("Pará"),  
    PB("Paraiba"),  
    PR("Paraná"),  
    PE("Pernambuco"),  
    PI("Piauí"),  
    RJ("Rio de Janeiro"),  
    RN("Rio Grande do Norte"),  
    RS("Rio Grande do Sul"),  
    RO("Rondônia"),  
    RR("Rorâima"),  
    SP("São Paulo"),  
    SC("Santa Catarina"),  
    SE("Sergipe"),  
    TO("Tocantins");  
      
    private String estado;  
  
    private Estado(String estado){  
        this.estado = estado;  
    }  
      
    public String getEstado() {  
        return estado;  
    }  
  
      
    @Override  
    public String toString(){  
        return this.getEstado();  
    }
}