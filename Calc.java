package com;

public class Calc {

    public static int run(String input) {

        String ex = input.replace(" ","");

        return cal(ex);
    }

    public static int cal(String ex){

        ex = ex.replace(" ", "");

        for (int i = ex.length() - 1; i >= 0; i--) {

            char c = ex.charAt(i);

            if (c == '+' || c == '-') {

                if (i == 0) continue;
                char prev = ex.charAt(i - 1);
                if (prev == '+' || prev == '-' || prev == '*' || prev == '/') continue;

                int left = cal(ex.substring(0, i));
                int right = cal(ex.substring(i + 1));
                return (c == '+') ? left + right : left - right;
            }
        }

        for (int i = ex.length() - 1; i >= 0; i--) {
            char c = ex.charAt(i);
            if (c == '*' || c == '/') {
                int left = cal(ex.substring(0, i));
                int right = cal(ex.substring(i + 1));
                return (c == '*') ? left * right : left / right;
            }
        }

        if (ex.startsWith("-")) return -cal(ex.substring(1));

        return Integer.parseInt(ex);
    }
}

