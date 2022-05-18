package com.company;

public class LoginSystems {
    public static void LoginMenu(){
        boolean valid = false;
        while (!valid){
            System.out.println("Login (1) or Sign up (0)?");
            int choice = InputSystems.InputInt();
            if (choice == 1){
                Login();
            }
            else if (choice == 0){
                Signup();
            }
            else{
                System.out.println("please enter a valid option");
            }
        }
    }

    private static void Login(){

    }

    private static void Signup(){

    }
}
