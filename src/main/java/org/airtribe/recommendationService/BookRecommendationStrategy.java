//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.recommendationService;

import java.util.List;
import org.airtribe.Patron.Patron;
import org.airtribe.library.LibraryBranch;

public interface BookRecommendationStrategy {
    List<String> recommendBooks(Patron var1, LibraryBranch var2);
}
