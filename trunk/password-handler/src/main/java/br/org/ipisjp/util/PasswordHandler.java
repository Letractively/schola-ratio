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
package br.org.ipisjp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;

/**
 * @author osnir
 * 
 * @version class_version
 * @since package_version
 */
public class PasswordHandler {

    /**
     * @param password
     * @return
     * @since class_version
     */
    public static String generateHash(String password) {

        String passKey = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            BigInteger hash = new BigInteger(1, digest.digest(password
                    .getBytes()));

            passKey = hash.toString(32);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return passKey;
    }

    /**
     * @param password
     * @return
     * @since class_version
     */
    public static String encode(String password) {

        String passKey = null;

        passKey = Base64.encode(password.getBytes());

        return passKey;
    }

    /**
     * @param value
     * @return
     * @throws Base64DecodingException
     * @since class_version
     */
    public static String decode(String value) throws Base64DecodingException {
        byte[] decoded = Base64.decode(value);
        return new String(decoded);
    }

}
