package com.fivedrawdesign.rocketlaunches;

import com.fivedrawdesign.rocketlaunches.utils.HelperUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * HelperUtils tests
 */
public class HelperUtilsTest {

    /**
     * Test the isValidLink method handles invalid and null values
     * @throws Exception
     */
    @Test
    public void isValidLink() throws Exception {

        String null_link = null;
        String valid_link = "http://www.google.com";
        String invalid_link = "";

        assertFalse(HelperUtils.isValidLink(null_link));

        assertFalse(HelperUtils.isValidLink(invalid_link));

        assertTrue(HelperUtils.isValidLink(valid_link));

    }

}