//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.recommendationService;

import java.util.List;
import java.util.stream.Collectors;
import org.airtribe.Patron.Patron;
import org.airtribe.library.Library;

public class RecommendationService {
    private BookRecommendationStrategy strategy;

    public RecommendationService() {
    }

    public void setStrategy(BookRecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> getRecommendations(Patron patron, Library library) {
        if (this.strategy == null) {
            throw new IllegalStateException("Recommendation strategy not set.");
        } else {
            return (List)library.getLibraryBranches().stream().flatMap((branch) -> {
                return this.strategy.recommendBooks(patron, branch).stream().map((bookTitle) -> {
                    return bookTitle + " (Available at: " + branch.getBranchName() + ")";
                });
            }).distinct().limit(5L).collect(Collectors.toList());
        }
    }
}
