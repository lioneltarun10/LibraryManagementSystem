//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.airtribe.library;

import org.airtribe.bookManagement.Inventory;
import org.airtribe.bookManagement.LendingService;

public class LibraryBranch {
    private String branchId;
    private String branchName;
    private Inventory inventory;
    private LendingService lendingService;

    public LibraryBranch(String branchId, String branchName) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.inventory = new Inventory();
        this.lendingService = new LendingService(this.inventory);
    }

    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public LendingService getLendingService() {
        return this.lendingService;
    }

    public void setLendingService(LendingService lendingService) {
        this.lendingService = lendingService;
    }
}
