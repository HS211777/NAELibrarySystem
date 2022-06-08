package com.company;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseSystems {

    public static void AmendBook(String field,int isbn){
        try{
            Class.forName(""); //enter database
        }
        catch (Exception e){
            System.out.println("Class not found "+e);
        }
        try{
            Connection con = getConnection();
            String amendment;
            String sql = "UPDATE Books SET "+field+" = "+amendment+" WHERE ISBN = "+isbn;
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
            }
            //finish
        }
        catch(Exception e){

        }
    }

    //public static void AmendAccount(String field,int accountID){
        //try{
            //Class.forName(""); //enter database
        //}
        //catch (Exception e){
            //System.out.println("Class not found "+e);
       // }
        //try{
           // Connection con = DriverManager.getConnection(""); // enter database
           // Statement stmt = con.createStatement("SELECT "+field+" FROM Accounts WHERE ");
            //finish
       // }
       // catch(Exception e){

       // }
   // }

    public static void DisplayAccounts(){ // 0 = no search, 1 = AccountID, 2 = Username, 3 = FirstName, 4 = LastName, 5 = Email, 6 = DateOfBirth, 7  = DateCreated, 8 = Admin
        try{
            Class.forName(""); //enter database
        }
        catch (Exception e){
            System.out.println("Class not found "+e);
        }
        try{
            Connection con = DriverManager.getConnection(""); // enter database
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Accounts");
            //add search

            System.out.println("AccountID  |  UserName  |  Password  |  FirstName  |  LastName  |  Email  |  DateOfBirth  |  DateCreated  |  Admin");

            while (rs.next()){
                ObjAccount myAccount = new ObjAccount(rs.getString("Username"), rs.getInt("Password"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getDate("DateOfBirth#").toLocalDate(),rs.getDate("DateCreated").toLocalDate(),rs.getBoolean("Admin"),rs.getInt("AccountID"));

                System.out.println(myAccount.toString());
            }

        }
        catch(Exception e){

        }
    }

    public static void DisplayBooks(){ //0 = no search, 1 = ISBN, 2 = Title, 3 = Author, 4 = Genre, 5 = DatePublished
        try{
            Class.forName(""); //enter database
        }
        catch (Exception e){
            System.out.println("Class not found "+e);
        }
        try{
            Connection con = DriverManager.getConnection(""); // enter database
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Books");
            //add search

            System.out.println("ISBN  |  Title  |  Author  |  Genre  |  Quantity  |  QuantityAvailable  |  DatePublished");

            while (rs.next()){
                ObjBook myBook = new ObjBook(rs.getInt("ISBN"),rs.getString("Title"),rs.getString("Author"),rs.getString("Genre"),rs.getInt("Quantity"),rs.getInt("QuantityAvailable"),rs.getDate("DatePublished").toLocalDate());

                System.out.println(myBook.toString());
            }
        }
        catch(Exception e){

        }
    }

    public static void DisplayLendings(){ // 0 = no search, 1 = LendingID, 2 = AccountID, 3 = ISBN, 4 = DateLent, 5 = ReturnDate
        try{
            Class.forName(""); //enter database
        }
        catch (Exception e){
            System.out.println("Class not found "+e);
        }
        try{
            Connection con = DriverManager.getConnection(""); // enter database
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Lendings");
            //add search

            System.out.println("LendingID  |  AccountID  |  ISBN  |  DateLent  |  ReturnDate");

            while (rs.next()){
                int LenginID = rs.getInt("LenginID");
                int AccountID = rs.getInt("AccountID");
                int ISBN = rs.getInt("ISBN");
                Date DateLent = rs.getDate("DateLent");
                Date ReturnDate = rs.getDate("ReturnDate");

                System.out.println(LenginID+"  |  "+AccountID+"  |  "+ISBN+"  |  "+DateLent+"  |  "+ReturnDate);
            }
        }
        catch(Exception e){

        }
    }

    // Julie's code bellow

    //returns a connection to the database
    public static Connection getConnection() {
        try {
            //String DatabaseLocation = System.getProperty("user.dir") + "\\Computer Science NEA.accdb";
            String DatabaseLocation = "X:\\My Documents" + "\\Computer Science NEA.accdb";
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return null;
    }
    //Executes a query to return a result, use for select queries
    public static ResultSet executeQuery(Connection con, String query) {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error in the ExecuteSQL class:" + e);
            return null;
        }
    }
    //Used to edit/delete data in database
    public static void executeUpdateQuery(Connection con, String query) {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Error in the ExecuteSQL class:" + e);
        }
    }
    //An example of an SQL  SELECT query
    public static ObjAccount getCurrentUsersAccount() {
        ObjAccount account = null;
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM Accounts";
            ResultSet rs = executeQuery(con, sql);
            if (rs.next()) {
                //System.out.println(rs.getDate("DateOfBirth"));

                account = new ObjAccount(rs.getString("Username"), rs.getInt("Password"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), rs.getDate("DateOfBirth").toLocalDate(), rs.getDate("DateCreated").toLocalDate(), rs.getBoolean("Admin"), rs.getInt("AccountID"));
            }

            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return account;
    }
}