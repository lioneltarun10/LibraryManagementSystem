//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.library;

import java.util.ArrayList;
import java.util.List;
import org.airtribe.Patron.Patron;

public class Library {
    private List<Patron> patrons = new ArrayList();
    private List<LibraryBranch> libraryBranches = new ArrayList();

    public Library() {
    }

    public List<Patron> getPatrons() {
        return this.patrons;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public List<LibraryBranch> getLibraryBranches() {
        return this.libraryBranches;
    }

    public void setLibraryBranches(List<LibraryBranch> libraryBranches) {
        this.libraryBranches = libraryBranches;
    }

    public void addBranch(LibraryBranch libraryBranch) {
        this.libraryBranches.add(libraryBranch);
    }

    public String removeBranch(LibraryBranch libraryBranch) {
        return this.libraryBranches.remove(libraryBranch) ? "Successfully removed Branch" : "Unsuccessful in removing branch";
    }

    public void addPatron(Patron p) {
        this.patrons.add(p);
    }

    public void removePatron(Patron p) {
        this.patrons.remove(p);
    }
}
