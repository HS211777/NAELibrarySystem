package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSystems {

    //this code is a modified version of code I found on the internet
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
