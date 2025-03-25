# Library Management System

## Overview
This is a **Library Management System** designed with **SOLID principles** and key **design patterns** to ensure scalability, flexibility, and maintainability. It allows patrons to **borrow, return, reserve, transfer, and search for books** while implementing a **notification system** and a **recommendation system** based on borrowing history and preferences.

## Features

### 1. **Library & Branch Management**
- A `Library` manages multiple `LibraryBranch` instances and aggregated of list of patrons.
- Patrons are managed centrally by one library , they can have access to any branch of that library.
- Patrons can **borrow and return books** from any branch.

### 2. **Book Inventory Management**
- Each branch maintains an `Inventory` of books and a lending Service.
- Supports **Physical Books & EBooks** using **inheritance** (`Book` -> `PhysicalBook`, `EBook`).

### 3. **Lending Service**
- **Patrons can borrow books** if available.
- **Reservations:** If a book is unavailable, patrons are added to a waitlist.
- **Return books:** Notifies all the patrons in queue using the **Observer Pattern**.

### 4. **Notification System (Observer Pattern)**
- Uses `NotificationService` as an **interface**, allowing multiple implementations (Email, SMS) to dynamically inject into NotificationService reference type using Factory Pattern based on patron's notification preferences.
- When a book becomes available, the all patrons in the reservation queue is notified automatically.

### 5. **Book Transfer System**
- `TransferService` allows books to be moved **between different branches**.

### 6. **Search Functionality**
- Patrons can search books by **Title, Author, or ISBN**.

### 7. **Book Recommendation System (Strategy Pattern)**
- Recommends books based on:
  1. **Borrowing History** (Past borrowed books)
  2. **Genre-Based Preference** (Preferred genre of patron)

## Class Relationships & Design Patterns

### **Class Relationships:**

1. `Library` **composed** of multiple `LibraryBranch` instances and aggregated of multiple patrons.
2. `LibraryBranch` **composes** an `Inventory`, `LendingService`.
3. `Book` is an **abstract class** with `EBook` and `PhysicalBook` as **subclasses**.
4. `Patron` has an **association** with `NotificationService`.
5.  Inventory is aggregated of books and gives behaviours searching of books by title,author,etc.
5. `LendingService` **manages** borrowing, returning, and reservations.
6. `TransferService` handles **moving books** between branches.
7. `RecommendationService` uses **Strategy Pattern** to provide different recommendation algorithms.
8. `NotificationService` implements **Observer Pattern** for real-time notifications.

### **Design Patterns Used:**

- **Observer Pattern:** Used in `NotificationService` for book availability notifications.
- **Strategy Pattern:** Used in `RecommendationService` for dynamic book recommendations during runtime.
- **Factory Pattern:** Allows flexible instantiation of different notification types (SMS, Email).
- **Dependency Injection:** `NotificationService` and `RecommendationService` are injected at runtime.


