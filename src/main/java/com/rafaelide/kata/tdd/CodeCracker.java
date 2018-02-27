package com.rafaelide.kata.tdd;

import java.util.function.Function;

public class CodeCracker {

    private String[] alphabet = {" ", "", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] code = {"?", "", "!", ")", "\"", "(", "£", "*", "%", "&", ">", "<", "@", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o"};

    public String decode(String message) {
        return changeChars(message, this::decodeChar);
    }

    public String encode(String message) {
        return changeChars(message, this::encodeChar);
    }

    private String changeChars(String message, Function<String, String> f) {
        String str = "";
        for (String chr : message.split("")) {
            str += f.apply(chr);
        }
        return str;
    }

    private int findIndex(String key, String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(key))
                return i;
        }
        return -1;
    }

    private String decodeChar(String chr) {
        return alphabet[findIndex(chr, code)];
    }

    private String encodeChar(String chr) {
        return code[findIndex(chr, alphabet)];
    }
}
