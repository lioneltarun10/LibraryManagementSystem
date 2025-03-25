//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.Patron;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.airtribe.Observable.Observer;
import org.airtribe.book.Book;
import org.airtribe.book.Genre;
import org.airtribe.notification.NotificationFactory;
import org.airtribe.notification.NotificationService;

public class Patron implements Observer {
    private String name;
    private String email;
    private String phoneNumber;
    private List<Book> borrowedBooks;
    private Genre preferredGenre;
    private Set<String> notificationPreferences;

    public Patron(String name, String email, String phoneNumber, Set<String> notificationPreferences) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList();
        this.notificationPreferences = notificationPreferences;
    }

    public Patron(String name, String email, String phoneNumber, Set<String> notificationPreferences, Genre preferredGenre) {
        this(name, email, phoneNumber, notificationPreferences);
        this.preferredGenre = preferredGenre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public Genre getPreferredGenre() {
        return this.preferredGenre;
    }

    public void setPreferredGenre(Genre preferredGenre) {
        this.preferredGenre = preferredGenre;
    }

    public Set<String> getNotificationPreferences() {
        return this.notificationPreferences;
    }

    public void setNotificationPreferences(Set<String> notificationPreferences) {
        this.notificationPreferences = notificationPreferences;
    }

    public void updateObserver(String message) {
        Iterator var2 = this.notificationPreferences.iterator();

        while(var2.hasNext()) {
            String s = (String)var2.next();
            NotificationService notificationService = NotificationFactory.createNotification(s);
            notificationService.sendNotification(this, message);
        }

    }
}
