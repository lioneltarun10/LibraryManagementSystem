//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.book;

import java.util.Date;

public class EBook extends Book {
    String downloadLink;

    public EBook(String author, String title, String ISBN, Genre genre, Date publicationYear, String downloadLink) {
        super(author, title, ISBN, genre, publicationYear);
        this.downloadLink = downloadLink;
    }

    public String getFormat() {
        return "PDF";
    }

    public String getDownloadLink() {
        return this.downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
