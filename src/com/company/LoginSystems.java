package com.company;

import java.time.LocalDate;

public class LoginSystems {
    public static void LoginMenu(){
        boolean valid = false;
        while (!valid){
            int choice = InputSystems.InputInt("Login (1) or Sign up (0)?");
            if (choice == 1){
                Login();
                valid = true;
            }
            else if (choice == 0){
                Signup();
                valid = true;
            }
            else{
                System.out.println("please enter a valid option");
            }
        }
    }

    private static void Login(){
        boolean valid = false;
        while (!valid){
            String username = InputSystems.InputString("Enter Username:");
            String password = InputSystems.InputString("Enter Password:");
            // check username and password
            valid = true;
        }
    }

    private static void Signup(){
        boolean valid = false;
        while (!valid) {
            String username = InputSystems.InputString("Enter Username:");
            String password = InputSystems.InputString("Enter Password:");
            String confPassword = InputSystems.InputString("Confirm Password");
            String firstName = InputSystems.InputString("Enter your First name");
            String lastName = InputSystems.InputString("Enter your Last name");
            String email = InputSystems.InputString("Enter your Email Address");
            LocalDate dateCreated = LocalDate.now();
            int year = InputSystems.InputInt("Enter the year of your birth");
            int month = InputSystems.InputInt("Enter the month (1-12) of your birth");
            int day = InputSystems.InputInt("Enter the day (1-31) of your birth");
            LocalDate dateOfBirth = LocalDate.of(year,month,day);
            if (password.equals(confPassword)){
                //check username
                //check date of birth
                //store data in database
            }
        }
    }
}
