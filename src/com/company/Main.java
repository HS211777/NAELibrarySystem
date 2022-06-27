package com.company;

public class Main {

    public static void main(String[] args) {
        LoginSystems.LoginMenu();
        if (LoginSystems.getCurrentAccount().isAdmin()){
            AdminUserSystems.AdminMenu();
        }
        else {
            AdminUserSystems.UserMenu();
        }
    }
}
