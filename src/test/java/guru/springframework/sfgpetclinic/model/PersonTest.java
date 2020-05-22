package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Buck", person.getLastName())
        );
    }

    @Test
    void groupedAssertionsWithMessages() {
        // given
        Person person = new Person(1L, "Joe", "Buck");

        // then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName(), "First name failed"),
                () -> assertEquals("Buck", person.getLastName(), "Last name failed")
        );
    }

}