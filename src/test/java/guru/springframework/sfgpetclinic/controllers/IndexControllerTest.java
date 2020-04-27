package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index(), "Wrong view returned");
    }

    @DisplayName("Test exception")
    @Test
    void oopsHandler() {
        assertTrue("notimplemented".equals(controller.oopsHandler()), () -> "This is some expensive" +
                "Message to build" +
                " for my test");
    }
}