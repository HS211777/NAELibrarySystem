package com.company;

import java.time.LocalDate;

public class ObjBook {
    private int ISBN;
    private String title;
    private String author;
    private String genre;
    private int quantity;
    private int quantityAvailable;
    private LocalDate datePublished;

    public ObjBook(int ISBN, String title, String author, String genre, int quantity, int quantityAvailable, LocalDate datePublished) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.quantityAvailable = quantityAvailable;
        this.datePublished = datePublished;
    }

    @Override
    public String toString() {
        return "ObjBook{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", quantity=" + quantity +
                ", quantityAvailable=" + quantityAvailable +
                ", datePublished=" + datePublished +
                '}';
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }
}

