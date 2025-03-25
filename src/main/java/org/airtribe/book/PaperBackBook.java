//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.book;

import java.util.Date;

public class PaperBackBook extends Book {
    public PaperBackBook(String author, String title, String ISBN, Genre genre, Date publicationYear) {
        super(author, title, ISBN, genre, publicationYear);
    }

    public String getFormat() {
        return "PAPERBACK";
    }
}
