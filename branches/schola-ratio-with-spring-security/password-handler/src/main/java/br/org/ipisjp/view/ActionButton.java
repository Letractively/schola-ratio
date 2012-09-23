/*
 * Trabalho de Conclusão de Curso - FACET
 *
 * IKEDA, Djulles
 * CUNHA, Osnir F
 *
 *
 * Copyright (c) 2011
 * All rights reserved.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written

 * Infringement of copyright is a serious civil and criminal offence, which can
 * result in heavy fines and payment of substantial damages.
 * 
 * (Code Template Version: 1.1)
 */
package br.org.ipisjp.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * <b><code>ActionButton</code></b><br>
 * Is a sub class of {@link JButton}. <br>
 * 
 * Used for purpose of dependency injection.
 * 
 * @author osnir
 * 
 * @version class_version
 * @since package_version
 */
public class ActionButton extends JButton {

    /**
     * Creates a button with text.
     * 
     * @param text
     *            the text of the button
     * @since class_version
     */
    public ActionButton(String text) {
        super(text);
    }

    /**
     * Used for inject an {@link ActionListener}.
     * 
     * @param component
     *            the ActionListener to be added
     * @since class_version
     */
    public void setActionListener(ActionListener component) {
        this.addActionListener(component);
    }

}
