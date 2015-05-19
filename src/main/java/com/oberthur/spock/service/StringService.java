package com.oberthur.spock.service;

/**
 * @author mzielinski on 18.05.15.
 */
public class StringService {

    public String concat(String string1, String string2) {
        if (string1 == null || string2 == null) {
            throw new IllegalArgumentException("input parameter cannot be null");
        }
        return string1 + string2;
    }


}
