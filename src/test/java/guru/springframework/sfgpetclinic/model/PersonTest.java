package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

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