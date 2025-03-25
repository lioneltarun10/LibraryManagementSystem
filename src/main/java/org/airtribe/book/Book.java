//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.book;

import java.util.Date;

public abstract class Book {
    private String author;
    private String title;
    private String ISBN;
    private Genre genre;
    private Date publicationYear;

    Book(String author, String title, String ISBN, Genre genre, Date publicationYear) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public abstract String getFormat();

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }
}
