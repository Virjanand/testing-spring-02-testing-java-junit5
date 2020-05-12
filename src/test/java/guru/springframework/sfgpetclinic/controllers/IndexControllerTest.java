package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controllers")
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

        assertThat(controller.index()).isEqualTo("index");
    }

    @DisplayName("Test exception")
    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeoutPreemtively() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I won't get here");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnOS() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeOnJava8() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testMeOnJava11() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "env:USERNAME", matches = "Seren")
    void testMeIfUserSeren() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    @EnabledIfEnvironmentVariable(named = "env:USERNAME", matches = "notExisting")
    void testMeIfUserFreja() {

    }
}