package com.rickydavoli;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

public class UserTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("should not allow to construct users with first name being blank")
    void doNotAllowUsersToHaveFirstnameBlank() {
        boolean thrown = false;
        try {
            new User("   ", "Davoli");
            fail("Should not get here");
        } catch (IllegalArgumentException ile) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("should not allow to construct users with surname being blank")
    void doNotAllowUsersToHaveSurnameBlank() {
        boolean thrown = false;
        try {
            new User(" Ricardo ", "     ");
            fail("Should not get here");
        } catch (IllegalArgumentException ile) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("should enforce first names and surnames to start with a capital letter")
    void firstNamesAndSurnamesStartWithACapital() {
        boolean thrown = false;
        try {
            new User("ricardo", "davoli");
            fail("Should not get here");
        } catch (IllegalArgumentException ile) {
            thrown = true;
        }
        assertThat(thrown, is(true));

    }

    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("should enforce first names to start with a capital letter")
    void firstNamesStartWithACapital() {
        boolean thrown = false;
        try {
            new User("ricardoo", "Davoli");
            fail("Should not get here");
        } catch (IllegalArgumentException ile) {
            thrown = true;
        }
        assertThat(thrown, is(true));

    }

    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("should enforce surnames to start with a capital letter")
    void surnamesStartWithACapital() {
        boolean thrown = false;
        try {
            new User("Ricardo", "davoli");
            fail("Should not get here");
        } catch (IllegalArgumentException ile) {
            thrown = true;
        }
        assertThat(thrown, is(true));

    }
    @SuppressWarnings("ConstantConditions")
    @Test
    @DisplayName("should create users where both first name and surname starts with capitals")
    void canCreateUserWhereBothFirstNameAndLastNameStartsWithCapitals() {
        var user = new User(" Ricardo ", " Davoli  \t");
        assertThat(user.getFirstname(), is("Ricardo"));
        assertThat(user.getSurname(), is("Davoli"));
    }

}
