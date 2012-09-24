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
package br.org.ipisjp.pastelada.test;

import junit.framework.TestCase;
import br.org.ipisjp.util.PasswordHandler;

/**
 * <b><code>PasswordHandlerTest</code></b><br>
 * 
 * Used for test {@link PasswordHandler}
 * 
 * @author osnir
 * 
 * @version class_version
 * @since package_version
 */
public class PasswordHandlerTest extends TestCase {

    /**
     * @see junit.framework.TestCase#setUp()
     * @since since optional
     */
    @Override
    protected void setUp() throws Exception {

        super.setUp();
    }

    /**
     * Used for test generateHash method using a valid String
     * 
     * @since class_version
     */
    public void testGenerateHash() {
        String password = "test";
        String expected = PasswordHandler.generateHash(password);
        assertNotNull("Hash is null.", expected);
        assertEquals("Hashes didn't match.", expected,
                PasswordHandler.generateHash(password));
    }

    /**
     * Used for test generateHash method using a null String
     * 
     * @since class_version
     */
    public void testGenerateHashWithNullPassword() {
        String expected = null;
        try {
            expected = PasswordHandler.generateHash(null);
            fail("Didn't throw expected exception.");
        } catch (NullPointerException e) {
            assertNull("Object isn't null.", expected);
        }
    }
}
