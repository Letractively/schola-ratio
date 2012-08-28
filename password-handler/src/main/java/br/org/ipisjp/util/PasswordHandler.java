/*
 * Trabalho de Conclusão de Curso - FACET
 * 
 * IKEDA, Djulles CUNHA, Osnir F
 * 
 * 
 * Copyright (c) 2011 All rights reserved.
 * 
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written
 * 
 * Infringement of copyright is a serious civil and criminal offence, which can
 * result in heavy fines and payment of substantial damages.
 * 
 * (Code Template Version: 1.1)
 */
package br.org.ipisjp.util;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.BCodec;

/**
 * @author osnir
 * 
 * @version class_version
 * @since package_version
 */
public class PasswordHandler {

    private static BCodec codec = new BCodec();

    /**
     * @param password
     * @return
     * @since class_version
     */
    public static String generateHash(String password) {

        String passKey = DigestUtils.shaHex(password);

        return passKey;
    }

    /**
     * @param password
     * @return
     * @throws EncoderException
     * @since class_version
     */
    public static String encode(String password) throws Exception {

        String passKey = null;

        passKey = codec.encode(password);

        return passKey;
    }

    /**
     * @param value
     * @return
     * @throws DecoderException
     * @throws Base64DecodingException
     * @since class_version
     */
    public static String decode(String value) throws Exception {
        String decoded = codec.decode(value);
        return decoded;
    }

}
