package com.company;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class AdminUserSystems {

    public static void UserMenu(){
        boolean valid = false;
        while (!valid){
            System.out.println("    --Menu--");
            System.out.println("1 - Edit Account");
            System.out.println("2 - Display Books Borrowed");
            System.out.println("3 - View Book list");
            System.out.println("4 - Search Books");
            System.out.println("5 - Borrow Book");
            System.out.println("6 - Return Book");
            System.out.println("7 - Return All Books");
            System.out.println("8 - Delete Account");
            System.out.println("9 - Exit");
            int choice = InputSystems.InputInt("Enter option number: ");
            if (choice == 1){
                AmendUser();
            }
            else if (choice == 2){

            }
            else if (choice == 3){

            }
            else if (choice == 4){

            }
            else if (choice == 5){

            }
            else if (choice == 6){

            }
            else if (choice == 7){

            }
            else if (choice == 8){

            }
            else if (choice == 9){
                valid = true;
            }
            else{
                System.out.println("Please choose a valid option");
            }
        }
    }

    public static void AdminMenu(){
        boolean valid = false;
        while(!valid){
            System.out.println("    --Menu--");
            System.out.println("1 - Amend Book");
            System.out.println("2 - Amend User");
            System.out.println("3 - Delete Book");
            System.out.println("4 - Delete User");
            System.out.println("5 - View Book List");
            System.out.println("6 - View User List");
            System.out.println("7 - Search Books");
            System.out.println("8 - Search Users");
            System.out.println("9 - Add Book");
            System.out.println("10 - Exit");
            System.out.println();
            int choice = InputSystems.InputInt("Enter option number: ");
            if (choice == 1){
                AmendBook(InputSystems.InputInt("Enter the ISBN:"));
            }
            else if (choice == 2){
                AmendUser();
            }
            else if (choice == 3){
                //DeleteBook();
            }
            else if (choice == 4){
                //DeleteUser();
            }
            else if (choice == 5){
                //ViewBookList();
            }
            else if (choice == 6){
                //ViewUserList();
            }
            else if (choice == 7){
                //SearchBooks();
            }
            else if (choice == 8){
                //SearchUsers();
            }
            else if (choice == 9){
                DatabaseSystems.AddBook(); // AddBook() is not currently functional
            }
            else if (choice == 10){
                valid = true;
            }
        }
    }

    public static void AmendBook(int isbn){
        boolean valid = false;
        while (!valid){
            System.out.println("   --Field--");
            System.out.println("1 - Title");
            System.out.println("2 - Author");
            System.out.println("3 - Genre");
            System.out.println("4 - Quantity");
            System.out.println("5 - DatePublished");
            System.out.println("6 - Back");
            int choice1 = InputSystems.InputInt("Enter option number: ");
            if (choice1 == 1){
                valid = true;
                DatabaseSystems.AmendString("Books","Title",isbn,InputSystems.InputString("Enter the Amendment:"));
            }
            else if (choice1 == 2){
                valid = true;
                DatabaseSystems.AmendString("Books","Author",isbn,InputSystems.InputString("Enter the Amendment:"));
            }
            else if (choice1 == 3){
                valid = true;
                DatabaseSystems.AmendString("Books","Genre",isbn,InputSystems.InputString("Enter the Amendment:"));
            }
            else if (choice1 == 4){
                valid = true;
                int amendment = InputSystems.InputInt("Enter Amendment:");
                ObjBook myBook = DatabaseSystems.getBook(isbn);
                int difference = myBook.getQuantity() - myBook.getQuantityAvailable();
                int amendmentQA = amendment - difference;
                DatabaseSystems.AmendInt("Books","Quantity",isbn,amendment);
                DatabaseSystems.AmendInt("Books","QuantityAvailable",isbn,amendmentQA);

            }
            else if (choice1 == 5){
                valid = true;
                LocalDate amendment = InputSystems.InputDate();
                DatabaseSystems.AmendDate("Books","QuantityAvailable",isbn,amendment);
            }
            else if (choice1 == 6){
                valid = true;
            }
            else{
                System.out.println("please enter a valid option");
            }
        }
    }

    public static void AmendUser(){
        ObjAccount currentAccount = LoginSystems.getCurrentAccount();
        ObjAccount myAccount = null;

        if (currentAccount.isAdmin()){
            int accountid = InputSystems.InputInt("Enter the Account ID:");
            myAccount = DatabaseSystems.getUser(accountid);
        }
        else {
            myAccount = currentAccount;
        }
        int ID = myAccount.getAccountID();
        boolean valid = false;

        while (!valid){
            System.out.println("   --Field--");
            System.out.println("1 - Username");
            System.out.println("2 - Password");
            System.out.println("3 - First Name");
            System.out.println("4 - Last Name");
            System.out.println("5 - Date of Birth");
            System.out.println("6 - Email");
            System.out.println("7 - Admin *Admin only*");
            System.out.println("8 - Back");

            int choice1 = InputSystems.InputInt("Enter option number: ");
            if (choice1 == 1){
                valid = true;
                String username = InputSystems.InputString("Enter the Amendment: ");
                if (DatabaseSystems.CheckUsernameAvailable(username)){
                    DatabaseSystems.AmendString("Accounts","Username",ID,username);
                }
                else{
                    System.out.println("That username is not available");
                }
            }
            else if (choice1 == 2){
                valid = true;
                String checkpassword = InputSystems.InputString("Enter current Password: ");
                int checkpassword1 = checkpassword.hashCode();
                if (checkpassword1 == myAccount.getPassword()){
                    String password = InputSystems.InputString("Enter new Password: ");
                    String confpassword = InputSystems.InputString("Confirm Password: ");
                    if (password.equals(confpassword)){
                        int newpassword = password.hashCode();
                        DatabaseSystems.AmendInt("Accounts","Password",ID,newpassword);
                    }
                }
            }
            else if (choice1 == 3){
                valid = true;
                DatabaseSystems.AmendString("Accounts","FirstName",ID,InputSystems.InputString("Enter the Amendment: "));
            }
            else if (choice1 == 4){
                valid = true;
                DatabaseSystems.AmendString("Accounts","LastName",ID,InputSystems.InputString("Enter the Amendment: "));
            }
            else if (choice1 == 5){
                valid = true;
                LocalDate amendment = InputSystems.InputDate();
                DatabaseSystems.AmendDate("Accounts","DateOfBirth",ID,amendment);
            }
            else if (choice1 == 6){
                valid = true;
                DatabaseSystems.AmendString("Accounts","Email",ID,InputSystems.InputString("Enter the Amendment: "));
            }
            else if (choice1 == 7){
                valid = true;
                if (currentAccount.isAdmin()){
                    boolean admin = InputSystems.InputBoolean("Enter Amendment (1 = admin, 0 = user): ");
                    DatabaseSystems.AmendBoolean("Accounts","Email",ID,admin);
                }
            }
            else if (choice1 == 8){
                valid = true;
            }
            else{
                System.out.println("please enter a valid option");
            }
        }
    }
}
