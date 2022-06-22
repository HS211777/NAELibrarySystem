package com.company;

import java.time.LocalDate;

public class ObjLendings {
    private int lendingID;
    private int ISBN;
    private String title;
    private String author;
    private String genre;
    private LocalDate datePublished;
    private LocalDate dateLent;
    private LocalDate returnDate;

    public ObjLendings(int lendingID, int ISBN, String title, String author, String genre, LocalDate datePublished, LocalDate dateLent, LocalDate returnDate) {
        this.lendingID = lendingID;
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.datePublished = datePublished;
        this.dateLent = dateLent;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return lendingID+" | "+ISBN+" | "+title+" | "+author+" | "+genre+" | "+datePublished+" | "+dateLent+" | "+returnDate;
    }

    public int getLendingID() {
        return lendingID;
    }

    public void setLendingID(int lendingID) {
        this.lendingID = lendingID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
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
