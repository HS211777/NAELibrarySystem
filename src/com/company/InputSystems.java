package com.company;

import java.util.Scanner;

public class InputSystems {
    public static int InputInt(){
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

    public static String InputString(){
        Scanner input = new Scanner(System.in);

    }
}
