//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.Observable;

import org.airtribe.book.Book;

public interface Observable {
    void addObserver(Observer var1, Book var2);

    void removeObserver(Observer var1, Book var2);

    void notifyObservers(Book var1);
}
