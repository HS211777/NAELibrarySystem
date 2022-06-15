package com.company;

import java.sql.*;
import java.time.LocalDate;

public class DatabaseSystems {

    public static void AmendInt(String table, String field, int ID, int amendment){
        try{
            Connection con = getConnection();
            String sql = "";
            if (table.equalsIgnoreCase("Books")){
                sql = "UPDATE Books SET "+field+" = "+amendment+" WHERE ISBN = "+ID;
            }
            else if (table.equalsIgnoreCase("Accounts")){
                sql = "UPDATE Accounts SET "+field+" = "+amendment+" WHERE AccountID = "+ID;
            }
            else{

            }
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
            }
            //finish
        }
        catch(Exception e){

        }
    }

    public static void AmendString(String table, String field,int ID, String amendment){
        try{
            Connection con = getConnection();
            String sql = "";
            if (table.equalsIgnoreCase("Books")){
                sql = "UPDATE Books SET "+field+" = "+amendment+" WHERE ISBN = "+ID;
            }
            else if (table.equalsIgnoreCase("Accounts")){
                sql = "UPDATE Accounts SET "+field+" = "+amendment+" WHERE AccountID = "+ID;
            }
            else{

            }
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
            }
            //finish
        }
        catch(Exception e){

        }
    }

    public static void AmendBoolean(String table, String field,int ID, boolean amendment){
        try{
            Connection con = getConnection();
            String sql = "";
            if (table.equalsIgnoreCase("Books")){
                sql = "UPDATE Books SET "+field+" = "+amendment+" WHERE ISBN = "+ID;
            }
            else if (table.equalsIgnoreCase("Accounts")){
                sql = "UPDATE Accounts SET "+field+" = "+amendment+" WHERE AccountID = "+ID;
            }
            else{

            }
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
            }
            //finish
        }
        catch(Exception e){

        }
    }

    public static void AmendDate(String table, String field,int ID, LocalDate amendment){
        try{
            Connection con = getConnection();
            String sql = "";
            if (table.equalsIgnoreCase("Books")){
                sql = "UPDATE Books SET "+field+" = "+amendment+" WHERE ISBN = "+ID;
            }
            else if (table.equalsIgnoreCase("Accounts")){
                sql = "UPDATE Accounts SET "+field+" = "+amendment+" WHERE AccountID = "+ID;
            }
            else{

            }
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
            }
            //finish
        }
        catch(Exception e){

        }
    }

    public static void DisplayAccounts(int searchby){ // 0 = no search, 1 = Username, 2 = FirstName, 3 = LastName, 4 = Email, 5 = DateOfBirth, 6  = DateCreated, 7 = Admin
        try{
            Connection con = getConnection();
            String sqladd = "";
            if (searchby == 1){
                String search = InputSystems.InputString("Search: ");
                sqladd = " WHERE Username LIKE '"+search+"'";
            }
            else if (searchby == 2){
                String search = InputSystems.InputString("Search: ");
                sqladd = " WHERE FirstName LIKE '"+search+"'";
            }
            else if (searchby == 3){
                String search = InputSystems.InputString("Search: ");
                sqladd = " WHERE LastName LIKE '"+search+"'";
            }
            else if (searchby == 4){
                String search = InputSystems.InputString("Search: ");
                sqladd = " WHERE Email LIKE '"+search+"'";
            }
            else if (searchby == 5){
                LocalDate search1 = InputSystems.InputDate();
                Date search = Date.valueOf(search1);
                sqladd = " WHERE DateOfBirth = "+search;
            }
            else if (searchby == 6){
                LocalDate search1 = InputSystems.InputDate();
                Date search = Date.valueOf(search1);
                sqladd = " WHERE DateCreated = "+search;
            }
            else if (searchby == 7){
                sqladd = " WHERE Admin LIKE "+search;
            }

            String sql = "SELECT * FROM Accounts";
            ResultSet rs = executeQuery(con,sql);
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

    public static ObjBook getBook(int isbn){
        ObjBook myBook = null;
        try{
            Connection con = getConnection();

            String sql = "SELECT * FROM Books WHERE ISBN = "+isbn;
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
                myBook = new ObjBook(rs.getInt("ISBN"),rs.getString("Title"),rs.getString("Author"),rs.getString("Genre"),rs.getInt("Quantity"), rs.getInt("QuantityAvailable"), rs.getDate("DatePublished").toLocalDate());
            }
            rs.close();
            con.close();
        }
        catch (Exception e){

        }
        return myBook;
    }

    public static ObjAccount getUser(int accountid){
        ObjAccount myAccount = null;
        try{
            Connection con = getConnection();

            String sql = "SELECT * FROM Accounts WHERE AccountID = "+accountid;
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
                myAccount = new ObjAccount(rs.getString("Username"), rs.getInt("Password"), rs.getString("FirstName"),rs.getString("LastName"),rs.getString("Email"), rs.getDate("DateOfBirth").toLocalDate(),rs.getDate("DateCreated").toLocalDate(),rs.getBoolean("Admin"), rs.getInt("AccountID"));
            }
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
        return myAccount;
    }

    public static boolean CheckUsernameAvailable(String username){
        boolean valid = true;
        try{
            Connection con = getConnection();
            String sql = "SELECT Username FROM Accounts";
            ResultSet rs = executeQuery(con,sql);
            while (rs.next()){
                String check = rs.getString("Username");
                if (check.equals(username)){
                    valid = false;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
        return valid;
    }

    public static void AddUser(String username, int password, String firstname, String lastname, LocalDate DoB, String email, LocalDate datecreated, boolean admin){
        try{
            Connection con = getConnection();
            String sql = "SELECT Accounts.* FROM Accounts";
            ResultSet rs = executeQuery(con,sql);
            if (rs.next()){
                rs.moveToInsertRow();
                rs.updateString("Username",username);
                rs.updateInt("Password",password);
                rs.updateString("FirstName",firstname);
                rs.updateString("LastName",lastname);
                rs.updateDate("DateOfBirth",Date.valueOf(DoB));
                rs.updateString("Email",email);
                rs.updateDate("DateCreated",Date.valueOf(datecreated));
                rs.updateBoolean("Admin",admin);
                rs.insertRow();
            }
            con.close();
            System.out.println("sign up successful");
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
    }

    public static void AddBook(){

    }

    public static int checkLogin(String username, int password){
        int out = -1;
        try{
            Connection con = getConnection();
            String sql = "SELECT Username, Password, AccountID FROM Accounts;";
            ResultSet rs = executeQuery(con, sql);

            while(rs.next()){
                if (username.equals(rs.getString("Username")) || password == rs.getInt("Password")){
                    out = rs.getInt("AccountID");
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Error "+e);
        }
        return out;
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