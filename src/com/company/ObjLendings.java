package com.company;

import java.time.LocalDate;

public class ObjLendings {
    private int lendingID;
    private int accountID;
    private int ISBN;
    private LocalDate dateLent;
    private LocalDate returnDate;

    public ObjLendings(int lendingId, int accountID, int ISBN, LocalDate dateLent, LocalDate returnDate) {
        this.lendingID = lendingId;
        this.accountID = accountID;
        this.ISBN = ISBN;
        this.dateLent = dateLent;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return lendingID+"  |  "+accountID+"  |  "+ISBN+"  |  "+dateLent+"  |  "+returnDate;
    }

    public int getLendingID() {
        return lendingID;
    }

    public void setLendingID(int lendingID) {
        this.lendingID = lendingID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDateLent() {
        return dateLent;
    }

    public void setDateLent(LocalDate dateLent) {
        this.dateLent = dateLent;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
