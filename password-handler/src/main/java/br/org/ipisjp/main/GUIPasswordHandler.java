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
package br.org.ipisjp.main;

import javax.swing.UIManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.org.ipisjp.view.MainWindow;

/**
 * <b><code>GUIPasswordHandler</code></b><br>
 * 
 * Is an user interface to generate Md5 hash, encode/decode a password using
 * Base64 method.
 * 
 * @author osnir
 * 
 * @version class_version
 * @since package_version
 */
public class GUIPasswordHandler {

    static {
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println(e);
            System.exit(0);
        }
    }

    /**
     * Initialize the user interface.<br>
     * 
     * No arguments is needed.
     * 
     * @param args
     *            not necessary
     * @since class_version
     */
    public static void main(String[] args) {

        // Load Spring context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "config/applicationContext.xml");

        // Get an instance of the main window
        MainWindow mainWindow = (MainWindow) applicationContext
                .getBean("mainWindow");

        mainWindow.init();
        mainWindow.toFront();
    }

}
