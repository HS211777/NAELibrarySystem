package com.company;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdminUserSystems { //this class contains mostly menus that link to other methods for both users and admins as well as merge sorting algorithms

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
                ArrayList<ObjLendings> lendings =  DatabaseSystems.DisplayLendings(LoginSystems.getCurrentAccount().getAccountID());
                printArrayList(lendings, "LendingID  |  ISBN  |  Title | Author | Genre | DatePublished |  DateLent  |  ReturnDate");
            }
            else if (choice == 3){
                ArrayList<ObjBook> books = sortBooks(DatabaseSystems.DisplayBooks(0));
                printArrayList(books, "ISBN  |  Title  |  Author  |  Genre  |  Quantity  |  QuantityAvailable  |  DatePublished");
            }
            else if (choice == 4){
                SearchBooks();
            }
            else if (choice == 5){
                DatabaseSystems.BorrowBook(LoginSystems.getCurrentAccount().getAccountID(),InputSystems.InputInt("Enter ISBN: "));
            }
            else if (choice == 6){
                DatabaseSystems.returnBook(InputSystems.InputInt("Enter ISBN: "),LoginSystems.getCurrentAccount().getAccountID());
            }
            else if (choice == 7){
                DatabaseSystems.returnAll(LoginSystems.getCurrentAccount().getAccountID());
            }
            else if (choice == 8){
                DatabaseSystems.DeleteAccount(LoginSystems.getCurrentAccount().getAccountID());
                valid = true;
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
            System.out.println("2 - Amend Account");
            System.out.println("3 - Delete Book");
            System.out.println("4 - Delete Account");
            System.out.println("5 - View Book List");
            System.out.println("6 - View Account List");
            System.out.println("7 - Search Books");
            System.out.println("8 - Search Accounts");
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
                DatabaseSystems.DeleteBook(InputSystems.InputInt("Enter ISBN: "));
            }
            else if (choice == 4){
                DatabaseSystems.DeleteAccount(InputSystems.InputInt("Enter AccountID: "));
            }
            else if (choice == 5){
                ArrayList<ObjBook> books = sortBooks(DatabaseSystems.DisplayBooks(0));
                printArrayList(books, "ISBN  |  Title  |  Author  |  Genre  |  Quantity  |  QuantityAvailable  |  DatePublished");
            }
            else if (choice == 6){
                ArrayList<ObjAccount> accounts = sortAccounts(DatabaseSystems.DisplayAccounts(0));
                printArrayList(accounts, "AccountID  |  UserName  |  Password  |  FirstName  |  LastName  |  Email  |  DateOfBirth  |  DateCreated  |  Admin");
            }
            else if (choice == 7){
                SearchBooks();
            }
            else if (choice == 8){
                SearchAccounts();
            }
            else if (choice == 9){
                DatabaseSystems.AddBook(); // AddBook() is not currently functional
            }
            else if (choice == 10){
                valid = true;
            }
        }
    }

    public static void printArrayList(ArrayList array, String heading){
        System.out.println(heading);
        for (int i = 0; i < array.size(); i++){
            System.out.println(array.get(i).toString());
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
                DatabaseSystems.AmendDate("Books","DatePublished",isbn,amendment);
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
                    DatabaseSystems.AmendBoolean("Accounts","Admin",ID,admin);
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

    public static void SearchBooks(){
        boolean valid = false;
        while (!valid){
            System.out.println("   --Field--");
            System.out.println("1 - Title");
            System.out.println("2 - Author");
            System.out.println("3 - Genre");
            System.out.println("4 - DatePublished");
            System.out.println("5 - Back");
            int choice = InputSystems.InputInt("Enter option number: ");
            if (choice < 1 || choice > 5){
                System.out.println("please enter a valid option");
            }
            else if (choice == 5){
                valid = true;
            }
            else{
                valid = true;
                ArrayList<ObjBook> books = sortBooks(DatabaseSystems.DisplayBooks(choice));
                books = sortBooks(books);
                printArrayList(books, "ISBN  |  Title  |  Author  |  Genre  |  Quantity  |  QuantityAvailable  |  DatePublished");
            }
        }
    }

    public static void SearchAccounts(){
        boolean valid = false;
        while (!valid){
            System.out.println("   --Field--");
            System.out.println("1 - Username");
            System.out.println("2 - First Name");
            System.out.println("3 - Last Name");
            System.out.println("4 - Email");
            System.out.println("5 - Date of Birth");
            System.out.println("6 - Date Created");
            System.out.println("7 - Admin ");
            System.out.println("8 - Back");

            int choice = InputSystems.InputInt("Enter option number: ");
            if (choice < 1 || choice > 8){
                System.out.println("please enter a valid option");
            }
            else if (choice == 8){
                valid = true;
            }
            else{
                valid = true;
                ArrayList<ObjAccount> accounts = sortAccounts(DatabaseSystems.DisplayAccounts(choice));
                accounts = sortAccounts(accounts);
                printArrayList(accounts, "AccountID  |  UserName  |  Password  |  FirstName  |  LastName  |  Email  |  DateOfBirth  |  DateCreated  |  Admin");
            }
        }


    }

    // the sorting algorithms below are modified versions of a sample I found on the internet
    public static ArrayList<ObjAccount> sortAccounts(ArrayList<ObjAccount> unsorted){
        if (unsorted.size() <= 1){
            return unsorted;
        }
        int mid = (int) Math.floor(unsorted.size()/2);
        ArrayList<ObjAccount> left = new ArrayList<>();
        for (int i = 0; i < mid; i++){
            left.add(unsorted.get(i));
        }
        ArrayList<ObjAccount> right = new ArrayList<>();
        for (int i = mid; i < unsorted.size(); i++){
            right.add(unsorted.get(i));
        }
        return mergeAccounts(sortAccounts(left),sortAccounts(right));
    }

    public static ArrayList<ObjAccount> mergeAccounts(ArrayList<ObjAccount> left, ArrayList<ObjAccount> right){
        ArrayList<ObjAccount> resultArray = new ArrayList<>();

        while(left.size() > 0 || right.size() > 0){
            if((left.size() != 0) && (left.get(0).getAccountID() < right.get(0).getAccountID())){
                resultArray.add(left.get(0));
                left.remove(0);
            }
            else{
                resultArray.add(right.get(0));
                right.remove(0);
            }
        }

        return resultArray;
    }

    public static ArrayList<ObjBook> sortBooks(ArrayList<ObjBook> unsorted){
        if (unsorted.size() <= 1){
            return unsorted;
        }
        int mid = (int) Math.floor(unsorted.size()/2);
        ArrayList<ObjBook> left = new ArrayList<>();
        for (int i = 0; i < mid; i++){
            left.add(unsorted.get(i));
        }
        ArrayList<ObjBook> right = new ArrayList<>();
        for (int i = mid; i < unsorted.size(); i++){
            right.add(unsorted.get(i));
        }
        return mergeBooks(sortBooks(left),sortBooks(right));
    }

    public static ArrayList<ObjBook> mergeBooks(ArrayList<ObjBook> left, ArrayList<ObjBook> right){
        ArrayList<ObjBook> resultArray = new ArrayList<>();


        while(left.size() > 0 || right.size() > 0){
            if( left.size() > 0 && left.get(0).getISBN() < right.get(0).getISBN()){
                resultArray.add(left.get(0));
                left.remove(0);
            }
            else{
                resultArray.add(right.get(0));
                right.remove(0);
            }
        }

        return resultArray;
    }

    public static ArrayList<ObjLendings> sortLendings(ArrayList<ObjLendings> unsorted){ //there is no search associated with lendings so i did not need to code this part
        if (unsorted.size() <= 1){
            return unsorted;
        }
        int mid = (int) Math.floor(unsorted.size()/2);
        ArrayList<ObjLendings> left = new ArrayList<>();
        for (int i = 0; i < mid; i++){
            left.add(unsorted.get(i));
        }
        ArrayList<ObjLendings> right = new ArrayList<>();
        for (int i = mid; i < unsorted.size(); i++){
            right.add(unsorted.get(i));
        }
        return mergeLendings(sortLendings(left),sortLendings(right));
    }

    public static ArrayList<ObjLendings> mergeLendings(ArrayList<ObjLendings> left, ArrayList<ObjLendings> right){
        ArrayList<ObjLendings> resultArray = new ArrayList<>();

        while(left.size() > 0 || right.size() > 0){
            if(left.size() > 0 && left.get(0).getLendingID() < right.get(0).getLendingID()){
                resultArray.add(left.get(0));
                left.remove(0);
            }
            else{
                resultArray.add(right.get(0));
                left.remove(0);
            }
        }

        return resultArray;
    }
}
