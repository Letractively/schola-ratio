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

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import br.facet.tcc.enums.Bimestre;
import br.facet.tcc.enums.Estado;

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
@ManagedBean(name = "constantsMB")
@Component
public class ConstantsMB {

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
}
