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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.xml.security.exceptions.Base64DecodingException;

import br.org.ipisjp.util.PasswordHandler;

/**
 * <b><code>MainWindow</code></b><br>
 * Defines the main window where the user can put a password, hash or encrypted
 * password to get the conversion.
 * 
 * @author osnir
 * 
 * @version class_version
 * @since package_version
 */
public class MainWindow extends JFrame implements ActionListener {

    private JLabel labelValue;

    private JTextField textValue;

    private JLabel labelResult;

    private JTextField textResult;

    private ActionButton buttonHash;

    private ActionButton buttonEncode;

    private ActionButton buttonDecode;

    private ActionButton buttonClear;

    private JPanel mainPanel;

    private JPanel buttonPanel;

    /**
     * Put all elements in the main window.
     * 
     * @since class_version
     */
    public void init() {

        this.mainPanel.add(this.labelValue);
        this.mainPanel.add(this.textValue);
        this.mainPanel.add(this.labelResult);
        this.mainPanel.add(this.textResult);

        this.buttonPanel.add(this.buttonHash);
        this.buttonPanel.add(this.buttonEncode);
        this.buttonPanel.add(this.buttonDecode);
        this.buttonPanel.add(this.buttonClear);

        this.mainPanel.add(this.buttonPanel);

        SpringUtilities.makeCompactGrid(mainPanel, 5, 1, 5, 5, 7, 10);

        this.add(mainPanel);

        ImageIcon icon = new ImageIcon(getClass()
                .getResource("/config/key.png"));
        this.setIconImage(icon.getImage());

        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }

    /**
     * Used to dependency injection purposes.
     * 
     * @since class_version
     */
    public void setDimension(Dimension d) {
        setSize(d);

    }

    /**
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     * @since since optional
     */
    public void actionPerformed(ActionEvent e) {
        // Define action to be performed when buttonHash is clicked.
        if (e.getSource() == this.buttonHash) {

            if (!validateValue()) {
                this.textResult.setText(PasswordHandler
                        .generateHash(this.textValue.getText()));
            } else {
                showError();
            }

        } else
        // Define action to be performed when buttonEncode is clicked.
        if (e.getSource() == this.buttonEncode) {

            if (!validateValue()) {
                this.textResult.setText(PasswordHandler.encode(this.textValue
                        .getText()));
            } else {
                showError();
            }

        } else
        // Define action to be performed when buttonDecode is clicked.
        if (e.getSource() == this.buttonDecode) {

            if (!validateValue()) {
                try {
                    this.textResult.setText(PasswordHandler
                            .decode(this.textValue.getText()));
                } catch (Base64DecodingException e1) {
                    showError(e1.getLocalizedMessage());
                }
            } else {
                showError();
            }

        } else
        // Define action to be performed when buttonClear is clicked.
        if (e.getSource() == this.buttonClear) {
            this.textResult.setText("");
            this.textValue.setText("");
        }
    }

    /**
     * Used to check if the value passed to be calculated is empty or not.
     * 
     * @return true if the value is empty or false if not.
     * @since class_version
     */
    private boolean validateValue() {
        return this.textValue.getText().trim().equals("");
    }

    /**
     * Popup an error message when value is empty
     * 
     * @since class_version
     */
    private void showError() {
        JOptionPane.showMessageDialog(this, "Value can not be empty!!!",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Popup an error message with a given text.
     * 
     * @param text
     *            text to be displayed on popup message
     * @since class_version
     */
    private void showError(String text) {
        JOptionPane.showMessageDialog(this, text, "Erro",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Sets the labelValue
     * 
     * @param labelValue
     *            the labelValue to set
     */
    public void setLabelValue(JLabel labelValue) {
        this.labelValue = labelValue;
    }

    /**
     * Sets the textValue
     * 
     * @param textValue
     *            the textValue to set
     */
    public void setTextValue(JTextField textValue) {
        this.textValue = textValue;
    }

    /**
     * Sets the labelResult
     * 
     * @param labelResult
     *            the labelResult to set
     */
    public void setLabelResult(JLabel labelResult) {
        this.labelResult = labelResult;
    }

    /**
     * Sets the textResult
     * 
     * @param textResult
     *            the textResult to set
     */
    public void setTextResult(JTextField textResult) {
        this.textResult = textResult;
    }

    /**
     * Sets the buttonHash
     * 
     * @param buttonHash
     *            the buttonHash to set
     */
    public void setButtonHash(ActionButton buttonHash) {
        this.buttonHash = buttonHash;
    }

    /**
     * Sets the buttonEncode
     * 
     * @param buttonEncode
     *            the buttonEncode to set
     */
    public void setButtonEncode(ActionButton buttonEncode) {
        this.buttonEncode = buttonEncode;
    }

    /**
     * Sets the buttonDecode
     * 
     * @param buttonDecode
     *            the buttonDecode to set
     */
    public void setButtonDecode(ActionButton buttonDecode) {
        this.buttonDecode = buttonDecode;
    }

    /**
     * Sets the buttonClear
     * 
     * @param buttonClear
     *            the buttonClear to set
     */
    public void setButtonClear(ActionButton buttonClear) {
        this.buttonClear = buttonClear;
    }

    /**
     * Sets the mainPanel
     * 
     * @param mainPanel
     *            the mainPanel to set
     */
    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    /**
     * Sets the buttonPanel
     * 
     * @param buttonPanel
     *            the buttonPanel to set
     */
    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }
}
