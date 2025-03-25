//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.recommendationService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.airtribe.Patron.Patron;
import org.airtribe.book.Book;
import org.airtribe.book.Genre;
import org.airtribe.library.LibraryBranch;

public class BorrowingHistoryRecommendation implements BookRecommendationStrategy {
    public BorrowingHistoryRecommendation() {
    }

    public List<String> recommendBooks(Patron patron, LibraryBranch branch) {
        Set<Genre> borrowedGenres = (Set)patron.getBorrowedBooks().stream().map(Book::getGenre).collect(Collectors.toSet());
        return (List)branch.getInventory().getAvailableBooks().stream().filter((book) -> {
            return borrowedGenres.contains(book.getGenre());
        }).map(Book::getTitle).limit(5L).collect(Collectors.toList());
    }
}
