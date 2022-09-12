package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSystems {

    private static final String regex = "^(.+)@(.+)$";

    public static boolean validateEmail(String email){
        boolean out = false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()){
            out = true;
        }
        return out;
    }
}
