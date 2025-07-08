import java.util.*;

class BookTypes {
     String PAPER = "paper";
     String EBOOK = "ebook";
     String SHOWCASE = "showcase";
}


abstract class Book {
     String ISBN;
     String title;
     int publishedYear;
     double price;
     int quantity;
     String bookType;

    public Book(String ISBN, String title, int publishedYear, double price, int quantity, String bookType) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price;
        this.quantity = quantity;
        this.bookType = bookType;
    }

    public abstract void addBook();
    public abstract void removeBook();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reduceQuantity(int amount) {
        quantity -= amount;
    }

    public String getISBN() { return ISBN; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublishedYear() { return publishedYear; }
    public double getPrice() { return price; }
    public String getBookType() { return bookType; }

   
}

class PaperBook extends Book {
    public PaperBook(String ISBN, String title, int publishedYear, double price, int quantity) {
        super(ISBN, title, publishedYear, price, quantity, BookTypes.PAPER);
    }

    @Override
    public void addBook() {
        System.out.println("Quantum book store: Adding paper book " + title + " to inventory");
    }

    @Override
    public void removeBook() {
        System.out.println("Quantum book store: Removing paper book " + title + " from inventory");
    }
}

// EBook Class
class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, int publishedYear, double price, String fileType) {
        super(ISBN, title, publishedYear, price, BookTypes.EBOOK);
        this.fileType = fileType;
    }

    @Override
    public void addBook() {
        System.out.println("Quantum book store: Adding eBook " + title + " to inventory");
    }

    @Override
    public void removeBook() {
        System.out.println("Quantum book store: Removing eBook " + title + " from inventory");
    }

    public String getFileType() { 
        return fileType;
         }
}


class DemoBook extends Book {
    public DemoBook(String ISBN, String title, int publishedYear) {
        super(ISBN, title, publishedYear, BookTypes.SHOWCASE);
    }

    @Override
    public void addBook() {
        System.out.println("Quantum book store: Adding showcase book " + title + " to inventory");
    }

    @Override
    public void removeBook() {
        System.out.println("Quantum book store: Removing showcase book " + title + " from inventory");
    }
}


class ShippingService {
    public void shipBook(String isbn, String address) {
        System.out.println("Quantum book store: Shipping book with ISBN " + isbn + " to " + address);
    }
}


class MailService {
    public void sendEbook(String isbn, String email) {
        System.out.println("Quantum book store: Sending eBook with ISBN " + isbn + " to " + email);
    }
}

class QuantumBookstore {
    private Map<String, Book> inventory = new HashMap<>();
    private ShippingService shippingService = new ShippingService();
    private MailService mailService = new MailService();

    public void addBook(Book book) {
        book.addBook();
        inventory.put(book.getISBN(), book);
    }

    public List<Book> removeOutdatedBooks(int years) {
        int currentYear = java.time.Year.now().getValue();
        List<Book> removedBooks = new ArrayList<>();
        List<String> toRemove = new ArrayList<>();

        for (Book book : inventory.values()) {
            if (currentYear - book.getPublishedYear() > years) {
                toRemove.add(book.getISBN());
                removedBooks.add(book);
            }
        }

        for (String isbn : toRemove) {
            inventory.get(isbn).removeBook();
            inventory.remove(isbn);
        }

        System.out.println("Quantum book store: Removed " + removedBooks.size() + " outdated books");
        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new Exception("Quantum book store: Book with ISBN " + isbn + " not found");
        }

        if (book.getBookType().equals(BookTypes.SHOWCASE)) {
            throw new Exception("Quantum book store: Cannot purchase showcase/demo book");
        }

        if (book.getBookType().equals(BookTypes.PAPER)) {
            PaperBook paperBook = (PaperBook) book;
            if (paperBook.getQuantity() < quantity) {
                throw new Exception("Quantum book store: Not enough stock for book " + isbn);
            }
            paperBook.reduceQuantity(quantity);
            shippingService.shipBook(isbn, address);
        } else if (book.getBookType().equals(BookTypes.EBOOK)) {
            mailService.sendEbook(isbn, email);
        }

        double total = book.getPrice() * quantity;
        System.out.println("Quantum book store: Purchased " + quantity + " of " + book.getTitle() + " for $" + total);
        return total;
    }

  

public class QuantumBookstoreTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        store.addBook(new PaperBook("888", "Janeare", "maria ", 2020, 120, 3));
        store.addBook(new EBook("111", "macbeth", "John Smith", 2022, 60, "PDF"));
        store.addBook(new DemoBook("222", "tressureIsland", "Alan walker", 2021));
        store.addBook(new PaperBook("999", "atomicHabits", "mia are", 2010, 80, 5));


        List<Book> removed = store.removeOutdatedBooks(10);
        System.out.println("Removed books:");
        for (Book book : removed) {
            System.out.println("  " + book);
        }

        try {
            double total = store.buyBook("888", 2, "", "6 october");
            System.out.println("Total paid: $" + total);
            
            store.buyBook("222", 1, "dareenhady@gmail.com", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
    }
}
