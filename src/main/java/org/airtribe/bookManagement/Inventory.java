//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.bookManagement;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.airtribe.book.Book;

public class Inventory {
    private Map<Book, Integer> books = new HashMap();

    public Inventory() {
    }

    public void addBook(Book book, int quantity) {
        this.books.put(book, (Integer)this.books.getOrDefault(book, 0) + quantity);
    }

    public boolean hasBook(Book book) {
        return (Integer)this.books.getOrDefault(book, 0) > 0;
    }

    public int getBookQuantity(Book book) {
        return (Integer)this.books.getOrDefault(book, 0);
    }

    public Map<Book, Integer> getBooks() {
        return this.books;
    }

    public void setBooks(Map<Book, Integer> books) {
        this.books = books;
    }

    public List<Book> getAvailableBooks() {
        return (List)this.books.entrySet().stream().filter((entry) -> {
            return (Integer)entry.getValue() > 0;
        }).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<Book> getUnAvailableBooks() {
        return (List)this.books.entrySet().stream().filter((entry) -> {
            return (Integer)entry.getValue() <= 0;
        }).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public void searchByTitle(String title) {
        Stream var10000 = this.books.keySet().stream().filter((b) -> {
            return b.getTitle().equalsIgnoreCase(title);
        });
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    public void searchByAuthor(String author) {
        Stream var10000 = this.books.keySet().stream().filter((b) -> {
            return b.getAuthor().equalsIgnoreCase(author);
        });
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }

    public void searchByISBN(String ISBN) {
        Stream var10000 = this.books.keySet().stream().filter((b) -> {
            return b.getISBN().equals(ISBN);
        });
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
    }
}
