//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.recommendationService;

import java.util.List;
import java.util.stream.Collectors;
import org.airtribe.Patron.Patron;
import org.airtribe.book.Book;
import org.airtribe.book.Genre;
import org.airtribe.library.LibraryBranch;

public class GenreBasedRecommendation implements BookRecommendationStrategy {
    public GenreBasedRecommendation() {
    }

    public List<String> recommendBooks(Patron patron, LibraryBranch branch) {
        Genre preferredGenre = patron.getPreferredGenre();
        return (List)branch.getInventory().getAvailableBooks().stream().filter((book) -> {
            return book.getGenre() == preferredGenre;
        }).map(Book::getTitle).limit(5L).collect(Collectors.toList());
    }
}
