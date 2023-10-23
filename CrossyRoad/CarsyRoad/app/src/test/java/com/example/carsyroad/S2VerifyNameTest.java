package com.example.carsyroad;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

    public class S2VerifyNameTest {
    @Test
    //Checks null name entry
    public void verifyNullName() {
        String name = null;
        assertFalse(ConfigActivity.isValid(name));
    }

   @Test
    //Checks empty name entry
    public void verifyEmptyName() {
        String name = "";
        assertFalse(ConfigActivity.isValid(name));

    }

   @Test
    //Checks name entry that only consists of whitespace
    public void verifyWhiteSpaceName() {
        String name = "  ";
        assertFalse(ConfigActivity.isValid(name));
    }

    @Test
    //Checks valid name entry
    public void verifyValidStringName() {
        String name = "Vanshika";
        assertTrue(ConfigActivity.isValid(name));
    }
}
