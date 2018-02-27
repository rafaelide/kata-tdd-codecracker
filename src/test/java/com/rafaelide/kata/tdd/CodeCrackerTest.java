package com.rafaelide.kata.tdd;

import com.rafaelide.kata.tdd.CodeCracker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class CodeCrackerTest {

    private CodeCracker cracker = new CodeCracker();

    @Test
    public void testDecode() {
        assertDecode("clean code", "\"a£!c?\"d(£");
        assertDecode("tdd", "i((");
        assertDecode("rafael", "g!*!£a");
    }

    @Test
    public void testEncode() {
        assertEncode("", "");
        assertEncode("!", "a");
        assertEncode("\"", "c");
        assertEncode("<!k!", "java");
        assertEncode("\"a£!c?\"d(£", "clean code");
        assertEncode("i((", "tdd");
    }

    private void assertEncode(String expected, String message) {
        assertEquals(expected, cracker.encode(message));
    }

    private void assertDecode(String expected, String message) {
        assertEquals(expected, cracker.decode(message));
    }
}
