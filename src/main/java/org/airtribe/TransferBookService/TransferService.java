//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.TransferBookService;

import org.airtribe.book.Book;
import org.airtribe.library.LibraryBranch;

public class TransferService {
    public TransferService() {
    }

    public void transferBook(LibraryBranch fromBranch, LibraryBranch toBranch, Book book, int quantity) {
        if (fromBranch.getInventory().hasBook(book) && fromBranch.getInventory().getBookQuantity(book) >= quantity) {
            fromBranch.getInventory().addBook(book, -quantity);
            toBranch.getInventory().addBook(book, quantity);
        } else {
            System.out.println("Insufficient Quantity of books in branch " + fromBranch.getBranchName());
        }

    }
}
