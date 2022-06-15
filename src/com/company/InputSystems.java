package com.company;

import java.time.LocalDate;
import java.util.Scanner;

public class InputSystems {
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
        int year = InputInt("Enter the year: ");
        int month = InputInt("Enter the month (1-12):");
        int day = InputInt("Enter the day (1-31):");
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
