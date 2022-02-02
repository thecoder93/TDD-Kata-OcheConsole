package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import src.OcheConsole;

public class TestOcheConsole {
    
    @Test
    public void test_should_return_reverseString() {
        assertEquals("aloh", OcheConsole.palindromeString("hola"));
    }

    @Test
    public void test_should_return_greeting() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
        LocalDateTime now = LocalDateTime.now(); 

        if(Integer.parseInt(dtf.format(now)) > 06 && Integer.parseInt(dtf.format(now)) < 12) 
            assertEquals("¡Buenos días Pedro", OcheConsole.greeting("oche Pedro"));
        if(Integer.parseInt(dtf.format(now)) > 12 && Integer.parseInt(dtf.format(now)) < 20) 
            assertEquals("¡Buenos tardes Pedro", OcheConsole.greeting("oche Pedro"));
        if(Integer.parseInt(dtf.format(now)) > 20 && Integer.parseInt(dtf.format(now)) < 06) 
            assertEquals("¡Buenos noches Pedro", OcheConsole.greeting("oche Pedro"));
    }
    
    @Test
    public void test_should_Palindrome_word() {
        assertEquals(true, OcheConsole.isPalindrome("oto"));
    }

    @Test
    public void test_should_return_reverseString_Palindrome() {
        assertEquals("oto\n ¡Bonita palabra!", OcheConsole.palindromeString("oto"));
    }


    @Test
    public void test_should_close_Oche_console() {
        assertEquals("Adios Pedro", OcheConsole.stopConsole("Stop!"));
    }
}


