//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.bookManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.airtribe.Observable.Observable;
import org.airtribe.Observable.Observer;
import org.airtribe.Patron.Patron;
import org.airtribe.book.Book;

public class LendingService implements Observable {
    private Inventory inventory;
    private Map<Book, Set<Patron>> borrowedBooks = new HashMap();
    private Map<Book, List<Observer>> reservations = new HashMap();

    public LendingService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void borrowBook(Book book, Patron patron) {
        if (this.inventory.hasBook(book)) {
            ((Set)this.borrowedBooks.computeIfAbsent(book, (k) -> {
                return new HashSet();
            })).add(patron);
            this.inventory.getBooks().put(book, (Integer)this.inventory.getBooks().get(book) - 1);
            patron.getBorrowedBooks().add(book);
        } else {
            this.addObserver(patron, book);
        }

    }

    public void returnBook(Book book, Patron patron) {
        ((Set)this.borrowedBooks.get(book)).remove(patron);
        if (((Set)this.borrowedBooks.get(book)).isEmpty()) {
            this.borrowedBooks.remove(book);
        }

        this.inventory.getBooks().put(book, (Integer)this.inventory.getBooks().get(book) + 1);
        this.notifyObservers(book);
    }

    public void reserveBook(Book book, Patron patron) {
        ((List)this.reservations.computeIfAbsent(book, (k) -> {
            return new LinkedList();
        })).add(patron);
    }

    public void addObserver(Observer observer, Book book) {
        ((List)this.reservations.computeIfAbsent(book, (k) -> {
            return new ArrayList();
        })).add(observer);
    }

    public void removeObserver(Observer observer, Book book) {
        List<Observer> observers = (List)this.reservations.get(book);
        if (observers != null) {
            observers.remove(observer);
        }

    }

    public void notifyObservers(Book book) {
        List<Observer> observerList = (List)this.reservations.get(book);
        if (observerList != null && !observerList.isEmpty()) {
            Iterator var3 = observerList.iterator();

            while(var3.hasNext()) {
                Observer observer = (Observer)var3.next();
                if (observer != null) {
                    observer.updateObserver("The book '" + book.getTitle() + "' is now available!");
                }
            }

            observerList.clear();
        }

    }
}
