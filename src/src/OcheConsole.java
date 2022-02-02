package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
https://kata-log.rocks/ohce-kata

ohce is a console application that echoes the reverse of what you input through the console.

Even though it seems a silly application, ohce knows a thing or two.

1. When you start oche, it greets you differently depending on the current time, but only in Spanish:
    Between 20 and 6 hours, ohce will greet you saying: ¡Buenas noches < your name >!
    Between 6 and 12 hours, ohce will greet you saying: ¡Buenos días < your name >!
    Between 12 and 20 hours, ohce will greet you saying: ¡Buenas tardes < your name >!
2. When you introduce a palindrome, ohce likes it and after reverse-echoing it, it adds ¡Bonita palabra!
3. ohce knows when to stop, you just have to write Stop! and it'll answer Adios < your name > and end.


$ ohce Pedro
> ¡Buenos días Pedro!
$ hola
> aloh
$ oto
> oto
> ¡Bonita palabra!
$ stop
> pots
$ Stop!
> Adios Pedro
*/


public class OcheConsole {

    private static String userName;

    public static String greeting(String input){
        if(input.startsWith("oche")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");  
            LocalDateTime now = LocalDateTime.now(); 

            userName = input.split("\\s+")[1];
            
            if(Integer.parseInt(dtf.format(now)) > 06 && Integer.parseInt(dtf.format(now)) < 12) 
                return "¡Buenos días " + userName;
            if(Integer.parseInt(dtf.format(now)) > 12 && Integer.parseInt(dtf.format(now)) < 20) 
                return "¡Buenos tardes " + userName;
            if(Integer.parseInt(dtf.format(now)) > 20 && Integer.parseInt(dtf.format(now)) <= 06) 
                return "¡Buenos noches " + userName;
        }
        return reverseString(input);
    }

    public static String stopConsole(String input){
        if(input.equals("Stop!")) {
            return "Adios " + userName;
        }

        return reverseString(input);
    }

    public static String palindromeString(String input){
        StringBuilder sb = new StringBuilder(input);

        if(isPalindrome(input)) {
            return sb.reverse().toString() + "\n ¡Bonita palabra!" ;
        }
        return reverseString(input);
}

    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static String reverseString(String input){
        StringBuilder sb = new StringBuilder(input);

        sb.reverse();
        return sb.toString();

    }
}
