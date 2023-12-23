package guru.qa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimpleJUnitTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("### @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("### @AfterEach");
    }

    @Test
    void firstTest() {
        System.out.println("###         @Test firstTest");
        Assertions.assertTrue(2 * 2 == 4);
    }

    @Test
    void secondTest() {
        System.out.println("###         @Test secondTest");
        Assertions.assertTrue(2 + 2 == 4);
    }

}
