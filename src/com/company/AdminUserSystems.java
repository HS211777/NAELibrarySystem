package com.company;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class AdminUserSystems {
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
                AmendBook();
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

            }
            else if (choice == 8){

            }
            else if (choice == 9){

            }
            else if (choice == 10){

            }
        }
    }

    public static void AmendBook(){
        System.out.println("   --Field--");
        System.out.println("1 - Title");
        System.out.println("2 - Author");
        System.out.println("3 - Genre");
        System.out.println("4 - Quantity");
        System.out.println("5 - DatePublished");
        System.out.println("6 - Back");
        int choice1 = InputSystems.InputInt("Enter option number: ");
        if (choice1 == 1){
            DatabaseSystems.AmendString("Books","Title",InputSystems.InputInt("Enter the ISBN:"),InputSystems.InputString("Enter the Amendment:"));
        }
        else if (choice1 == 2){
            DatabaseSystems.AmendString("Books","Author",InputSystems.InputInt("Enter the ISBN:"),InputSystems.InputString("Enter the Amendment:"));
        }
        else if (choice1 == 3){
            DatabaseSystems.AmendString("Books","Genre",InputSystems.InputInt("Enter the ISBN:"),InputSystems.InputString("Enter the Amendment:"));
        }
        else if (choice1 == 4){
            int isbn = InputSystems.InputInt("Enter ISBN:");
            int amendment = InputSystems.InputInt("Enter Amendment:");
            ObjBook myBook = DatabaseSystems.getBook(isbn);
            int difference = myBook.getQuantity() - myBook.getQuantityAvailable();
            int amendmentQA = amendment - difference;
            DatabaseSystems.AmendInt("Books","Quantity",isbn,amendment);
            DatabaseSystems.AmendInt("Books","QuantityAvailable",isbn,amendmentQA);

        }
        else if (choice1 == 5){
            int isbn = InputSystems.InputInt("Enter ISBN:");
            int year = InputSystems.InputInt("Enter the year: ");
            int month = InputSystems.InputInt("Enter the month (1-12):");
            int day = InputSystems.InputInt("Enter the day (1-31):");
            LocalDate amendment = LocalDate.parse(year+"-"+month+"-"+day);
            DatabaseSystems.AmendDate("Books","QuantityAvailable",isbn,amendment);
        }
        else{

        }
    }

    public static void AmendUser(){
        System.out.println("   --Field--");
        System.out.println("1 - Username");
        System.out.println("2 - Password");
        System.out.println("3 - First Name");
        System.out.println("4 - Last Name");
        System.out.println("5 - Date of Birth");
        System.out.println("6 - Email");
        System.out.println("7 - Admin *Admin only");

        int choice1 = InputSystems.InputInt("Enter option number: ");
    }
}
