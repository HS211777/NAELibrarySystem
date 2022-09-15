package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class InputSystems { //this class contains methods for inputs utilising try catches to prevent errors
    public static int InputInt(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        int out = -1;
        boolean valid = false;
        while (!valid){
            try{
                out = input.nextInt();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error "+e);
                input.next();
            }
        }
        return out;
    }

    public static String InputString(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        String out = "";
        boolean valid = false;
        while (!valid){
            try{
                out = input.next();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error "+e);
                input.next();
            }
        }
        return out;
    }

    public static LocalDate InputDate(){
        boolean validyear = false;
        int year = -1;
        int minyear = LocalDate.now().getYear() - 99;
        while(!validyear){
            year = InputInt("Enter the year: ");
            if (year >= minyear){ // doesn't work
                validyear = true;
            }
        }
        boolean validmonth = false;
        int month = -1;
        while (!validmonth){
            month = InputInt("Enter the month (1-12):");
            if (month > 0 && month < 13){
                validmonth = true;
            }
        }
        boolean validday = false;
        int day = -1;
        while (!validday){
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                day = InputInt("Enter the day (1-31):");
                if (day > 0 && day < 32){
                    validday = true;
                }
            }
            else if (month == 2){
                day = InputInt("Enter the day (1-29):");
                if (day > 0 && day < 30){
                    validday = true;
                }
            }
            else{
                day = InputInt("Enter the day (1-30):");
                if (day > 0 && day < 31){
                    validday = true;
                }
            }
        }
        return LocalDate.of(year,month,day);
    }

    public static boolean InputBoolean(String prompt){
        boolean valid = false;
        boolean out = false;
        while (!valid){
            int setadmin = InputSystems.InputInt(prompt);
            if (setadmin == 1){
                out = true;
                valid = true;
            }
            else if (setadmin == 0){
                valid = true;
            }
            else {
                System.out.println("Please enter a valid option");
            }
        }
        return out;
    }
}
