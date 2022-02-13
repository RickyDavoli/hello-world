package com.rickydavoli;

import static java.lang.Character.isUpperCase;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class User {

    private final String firstname;
    private final String surname;

    public User(String firstname, String surname) {
        this.firstname = firstLetterNotCapital(notBlank(firstname).trim());
        this.surname = firstLetterNotCapital(notBlank(surname).trim());
    }

    public String getFirstName(){
        return firstname;
    }
    public String getLastName(){
        return surname;

    }
    static private String notBlank(String arg) {
        if (isBlank(arg)) {
            throw new IllegalArgumentException("Argument: " + arg  + " cannot be blank");
        }
        return arg;
    }

    static private String firstLetterNotCapital(String arg) {
        if (!isUpperCase(arg.charAt(0))) {
            throw new IllegalArgumentException("First letter in: " + arg  + " must be capitalized");
        }
        return arg;
    }
}
