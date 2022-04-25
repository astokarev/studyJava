package lesson16;

import java.util.Arrays;

public class Perestanovki {
    static String sort(String input){
        char[] letters = input.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
    static boolean perestanovki(String first, String second){
        if (first.length() != second.length()) return false;
        return sort(first).equals(sort(second));
    }
}
