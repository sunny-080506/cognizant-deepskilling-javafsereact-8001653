import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class BookSearch {
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Java Basics", "Author A"),
            new Book(2, "Data Structures", "Author B"),
            new Book(3, "Algorithms", "Author C"),
            new Book(4, "Machine Learning", "Author D"),
            new Book(5, "Artificial Intelligence", "Author E")
        };

        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        String t1 = "Machine Learning";
        Book r1 = linearSearch(books, t1);
        System.out.println("Linear Search Result: " + (r1 != null ? r1 : "Not Found"));

        String t2 = "Algorithms";
        Book r2 = binarySearch(books, t2);
        System.out.println("Binary Search Result: " + (r2 != null ? r2 : "Not Found"));

        String t3 = "Python";
        Book r3 = binarySearch(books, t3);
        System.out.println("Binary Search Result: " + (r3 != null ? r3 : "Not Found"));
    }
}
