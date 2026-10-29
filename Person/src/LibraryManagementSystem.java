
class Book {
    String title;
    String author;
    String isbn;
    boolean available;

    // Constructor
    Book(String bookTitle, String bookAuthor, String bookIsbn) {
        title = bookTitle;
        author = bookAuthor;
        isbn = bookIsbn;
        available = true;
    }

    // Borrows the book if it is available
    boolean borrowBook() {
        if (available) {
            available = false;
            return true;
        } else {
            System.out.println(title + " is already borrowed.");
            return false;
        }
    }

    // Returns the book if it is currently borrowed
    boolean returnBook() {
        if (!available) {
            available = true;
            return true;
        } else {
            System.out.println(title + " is already available.");
            return false;
        }
    }

    // Displays book details
    void displayBookInfo() {
        System.out.println("Book: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);

        if (available) {
            System.out.println("Status: Available");
        } else {
            System.out.println("Status: Borrowed");
        }
    }
}

class LibraryMember {
    String name;
    String memberId;
    Book[] booksBorrowed;
    int borrowedCount;

    // Constructor
    LibraryMember(String memberName, String id) {
        name = memberName;
        memberId = id;
        booksBorrowed = new Book[3];
        borrowedCount = 0;
    }

    // Borrows a book
    void borrowBook(Book book) {
        if (borrowedCount >= 3) {
            System.out.println(name + " cannot borrow more than 3 books.");
            return;
        }

        if (book.borrowBook()) {
            booksBorrowed[borrowedCount] = book;
            borrowedCount++;

            System.out.println(name + " borrowed: " + book.title);
        }
    }

    // Returns a book borrowed by this member
    void returnBook(Book book) {
        int position = -1;

        for (int i = 0; i < borrowedCount; i++) {
            if (booksBorrowed[i] == book) {
                position = i;
                break;
            }
        }

        if (position == -1) {
            System.out.println(name + " did not borrow " + book.title);
            return;
        }

        if (book.returnBook()) {
            // Shift the remaining books to fill the empty position
            for (int i = position; i < borrowedCount - 1; i++) {
                booksBorrowed[i] = booksBorrowed[i + 1];
            }

            borrowedCount--;
            booksBorrowed[borrowedCount] = null;

            System.out.println(name + " returned: " + book.title);
        }
    }

    // Displays member details
    void displayMemberInfo() {
        System.out.println("Member: " + name);
        System.out.println("ID: " + memberId);
        System.out.println("Books Borrowed: " + borrowedCount);
    }

    // Challenge: displays all books borrowed by this member
    void displayBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");

        if (borrowedCount == 0) {
            System.out.println("No books borrowed.");
        } else {
            for (int i = 0; i < borrowedCount; i++) {
                System.out.println(
                    (i + 1) + ". " + booksBorrowed[i].title
                );
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create four books
        Book book1 = new Book(
            "Java Programming", "Hirwa JL", "ISBN001"
        );

        Book book2 = new Book(
            "Object-Oriented Programming", "Chris Brown", "ISBN002"
        );

        Book book3 = new Book(
            "Introduction to Java", "Musinga Neil", "ISBN003"
        );

        Book book4 = new Book(
            "Advanced Java", "Mahoro Peter", "ISBN004"
        );

        // Create two library members
        LibraryMember member1 = new LibraryMember("Alice", "M001");
        LibraryMember member2 = new LibraryMember("David", "M002");

        System.out.println("===== BORROWING BOOKS =====");

        member1.borrowBook(book1);
        member1.borrowBook(book2);
        member2.borrowBook(book2); // Already borrowed
        member2.borrowBook(book3);

        System.out.println("\n===== RETURNING BOOKS =====");

        member1.returnBook(book1);

        System.out.println("\n===== LIBRARY =====");

        book1.displayBookInfo();
        System.out.println();

        book2.displayBookInfo();
        System.out.println();

        book3.displayBookInfo();
        System.out.println();

        book4.displayBookInfo();

        System.out.println("\n===== MEMBERS =====");

        member1.displayMemberInfo();
        member2.displayMemberInfo();

        System.out.println("\n===== BORROWED BOOKS =====");

        member1.displayBorrowedBooks();
        member2.displayBorrowedBooks();
    }
}
