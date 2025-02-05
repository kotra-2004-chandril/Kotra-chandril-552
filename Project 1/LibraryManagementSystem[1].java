import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Sorry, this book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println(" Book returned successfully!");
        } else {
            System.out.println(" This book was not issued.");
        }
    }

    @Override
    public String toString() {
        return " Title: " + title + ",  Author: " + author + ",  Issued: " + (isIssued ? "Yes" : "No");
    }
}

// Library class
class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println(" Book '" + title + "' added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println(" No books available in the library.");
            return;
        }
        System.out.println("\n Books Available in the Library:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("Total Books: " + books.size());
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        try (Scanner scanner = new Scanner(System.in)) { // Try-with-resources for safe scanner closure
            while (true) {
                System.out.println("\n Library Management System");
                System.out.println(" Add Book");
                System.out.println(" Display Books");
                System.out.println(" Issue Book");
                System.out.println(" Return Book");
                System.out.println(" Exit");
                System.out.print(" Choose an option: ");
                
                int choice;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } else {
                    System.out.println(" Invalid input! Please enter a number.");
                    scanner.next(); // Consume invalid input
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print(" Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print(" Enter book author: ");
                        String author = scanner.nextLine();
                        library.addBook(title, author);
                        break;
                    case 2:
                        library.displayBooks();
                        break;
                    case 3:
                        System.out.print(" Enter book title to issue: ");
                        String issueTitle = scanner.nextLine();
                        Book issueBook = library.findBook(issueTitle);
                        if (issueBook != null) {
                            issueBook.issueBook();
                        } else {
                            System.out.println(" Book not found!");
                        }
                        break;
                    case 4:
                        System.out.print(" Enter book title to return: ");
                        String returnTitle = scanner.nextLine();
                        Book returnBook = library.findBook(returnTitle);
                        if (returnBook != null) {
                            returnBook.returnBook();
                        } else {
                            System.out.println(" Book not found!");
                        }
                        break;
                    case 5:
                        System.out.println(" Exiting... Thank you for using the Library Management System!");
                        return;
                    default:
                        System.out.println(" Invalid option! Please try again.");
                }
            }
        } // Scanner closes automatically
    }
}
