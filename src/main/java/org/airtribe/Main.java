package org.airtribe;

import org.airtribe.Patron.Patron;
import org.airtribe.TransferBookService.TransferService;
import org.airtribe.book.Book;
import org.airtribe.book.EBook;
import org.airtribe.book.Genre;
import org.airtribe.book.PaperBackBook;
import org.airtribe.library.Library;
import org.airtribe.library.LibraryBranch;
import org.airtribe.notification.EmailNotificationService;
import org.airtribe.notification.NotificationService;
import org.airtribe.notification.SMSNotificationService;
import org.airtribe.recommendationService.BorrowingHistoryRecommendation;
import org.airtribe.recommendationService.GenreBasedRecommendation;
import org.airtribe.recommendationService.RecommendationService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        NotificationService emailService =  new EmailNotificationService();
        NotificationService smsServicenew = new SMSNotificationService();
        Library library = new Library();
        LibraryBranch branch1 = new LibraryBranch("1", "Central Library");
        library.addBranch(branch1);
        Book book1 = new PaperBackBook("Robert C. Martin", "Clean Code", "123456789", Genre.COMEDY, new Date());
        Book book2 = new PaperBackBook("Joshua Bloch", "Effective Java", "987654321", Genre.THRILLER, new Date());
        Book book3 = new EBook("J.R.R. Tolkien", "The Hobbit", "543216789", Genre.HORROR, new Date(), "downloadlink1");
        Book book4 = new EBook("J.K. Rowling", "Harry Potter", "112233445", Genre.HORROR, new Date(), "downloadlink2");
        Book book5 = new PaperBackBook("Mark Weiss", "Data Structures", "998877665", Genre.FICTION, new Date());
        branch1.getInventory().addBook(book1, 2);
        branch1.getInventory().addBook(book2, 2);
        branch1.getInventory().addBook(book3, 1);
        branch1.getInventory().addBook(book4, 1);
        branch1.getInventory().addBook(book5, 3);
        Set<String> notificationPreferences = new HashSet();
        notificationPreferences.add("SMS");
        notificationPreferences.add("EMAIL");
        Patron patron1 = new Patron("Alice", "alice@example.com", "9888829212", notificationPreferences, Genre.COMEDY);
        Patron patron2 = new Patron("Bob", "bob@example.com", "921728222", notificationPreferences, Genre.THRILLER);
        library.addPatron(patron1);
        library.addPatron(patron2);
        branch1.getLendingService().borrowBook(book1, patron1);
        branch1.getLendingService().borrowBook(book2, patron2);
        branch1.getLendingService().borrowBook(book3, patron1);
        branch1.getLendingService().borrowBook(book3, patron2);
        branch1.getLendingService().returnBook(book3, patron1);
        LibraryBranch branch2 = new LibraryBranch("2", "Westside Library");
        library.addBranch(branch2);
        TransferService transferService = new TransferService();
        transferService.transferBook(branch1, branch2, book5, 2);
        RecommendationService recommendationService = new RecommendationService();
        branch1.getLendingService().borrowBook(book4, patron1);
        recommendationService.setStrategy(new BorrowingHistoryRecommendation());
        List<String> recommendations = recommendationService.getRecommendations(patron1, library);
        System.out.println("History-Based Recommendation: " + recommendations);
        recommendationService.setStrategy(new GenreBasedRecommendation());
        recommendations = recommendationService.getRecommendations(patron1, library);
        System.out.println("Genre-Based Recommendation: " + recommendations);
    }
}