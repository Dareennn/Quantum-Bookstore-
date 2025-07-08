import java.util.*;

class BookTypes {
    public static final String PAPER = "paper";
    public static final String EBOOK = "ebook";
    public static final String SHOWCASE = "showcase";
}


abstract class book{
    String ISBN;
    String Title;
    int publishedYear;
    double price;
    int quantity;
    String bookType;


   abstract book addBook(){
   
    }
   abstract book removeBook(){
        
     }   
      int getQuantity() {
        return quantity;
    }

    void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    void reduceQuantity(int amount) {
        quantity -= amount;
    }
    String getISBN() {
         return ISBN; 
         }
    String getTitle() {
         return Title; 
         }
    int getPublishedYear() {
         return publishedYear; 
         }
    double getPrice() { 
        return price;
         }
    String getBookType() {
         return bookType; 
         }
}
public book(String ISBN,String Title,int publishedYear,double price,int quantity){
this.ISBN=ISBN;
this.Title=Title;
this.publishedYear=publishedYear;
this.price=price;
this.quantity=quantity;
this.bookType=bookType;
}

class Paperbook extends book{
@Override
    Book addBook() {
        System.out.println("Quantum book store: Adding paper book " + Title + " to inventory");
        return this;
    }

    @Override
    Book removeBook() {
        System.out.println("Quantum book store: Removing paper book " + Title + " from inventory");
        return this;
    }
}
public PaperBook(String ISBN, String Title, int publishedYear, double price, int quantity) {
        super(ISBN, Title, publishedYear, price, quantity, BookTypes.PAPER);
    }

class eBook extends book{
String fileType;
@Override
    Book addBook() {
        System.out.println("Quantum book store: Adding eBook " + Title + " to inventory");
        return this;
    }

    @Override
    Book removeBook() {
        System.out.println("Quantum book store: Removing eBook " + Title + " from inventory");
        return this;
    }

    String getFileType() { return fileType; }


}
 public EBook(String ISBN, String Title, int publishedYear, double price, String fileType) {
        super(ISBN, Title, publishedYear, price, 0, BookTypes.EBOOK);
        this.fileType = fileType;
    }

    class  demoBook extends book{
@Override
    Book addBook() {
        System.out.println("Quantum book store: Adding showcase book " + Title + " to inventory");
        return this;
    }

    @Override
    Book removeBook() {
        System.out.println("Quantum book store: Removing showcase book " + Title + " from inventory");
        return this;
    }
}
    public DemoBook(String ISBN, String Title, int publishedYear) {
        super(ISBN, Title, publishedYear, 0.0, 0, BookTypes.SHOWCASE);
    }

class cart extends book{
String emailAddress;

void addtoCart(book Book,int quantity){
        Map<book, quantity> items = new HashMap<>();

   if (book.getBookType().equals(BookTypes.SHOWCASE)) {
            throw new IllegalArgumentException("Showcase books cannot be purchased");
        }
        if (book.getBookType().equals(BookTypes.PAPER) && book.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock available for " + book.getTitle());
        }
        items.put(book, items.getOrDefault(book, 0) + quantity);
    }

}

}



class ShippingService{
 public static void shipBook(String isbn, String address) {
        System.out.println("Quantum book store: Shipping book with ISBN " + isbn + " to " + address);
    }
}

class ShippingService{
 public static void sendEbook(String isbn, String email) {
        System.out.println("Quantum book store: Sending eBook with ISBN " + isbn + " to " + email);
    }
}

class QuantumBookstore {


}

public class  QuantumBookstoreTest{
   
    
    public static void main(String[] args) {

}
}


