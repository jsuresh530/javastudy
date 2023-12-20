package com.testing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration (DisplayNameGenerator.ReplaceUnderscores.class)
public class DemoUtilsTest {
    DemoUtils demoUtils;
    @BeforeEach
    void setUpBeforeEach(){
        demoUtils = new DemoUtils ();
        System.out.println ("@Beforeeach excutes before the test of each method");
    }

    @Test
    //@DisplayName ("Equals and Not equals ")
    void Test_EqualsAnd_NotEquals(){
        DemoUtils demoUtils = new DemoUtils ();
        assertEquals(6, demoUtils.add (3,3), "The sum must be 6 ");
    }

    @DisplayName ("TrueorFalse")
    @Order (1)
    @Test
    void testTrueOrFalse(){
        int gradeOne = 10;
        int gradeTwo = 5;
        assertTrue (demoUtils.isGreater (gradeOne,gradeTwo), " which one is greater");
    }

    @DisplayName ("Throws and Doesnot throws")
    @Test

    void testThrowsandDoesnotThrows(){
        assertThrows (Exception.class, () -> {demoUtils.throwException (-1);}, "Should throw exception");
        assertDoesNotThrow (() -> {demoUtils.throwException (5);}, "Should not throw exception");
    }
}
