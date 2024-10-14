import java.util.Scanner;

class Book {
    private String name, author;
    private double price;
    private int numPages;

    
    public Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }


    
    public String toString() {
         return "Name: " + name + "\n" +
            "Author: " + author + "\n" +
            "Price: Rs" + price + "\n" +
            "Number of Pages: " + numPages + "\n";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            System.out.print("Number of Pages: ");
            int numPages = scanner.nextInt();
            scanner.nextLine(); 

            books[i] = new Book(name, author, price, numPages);
        }


        System.out.println("\nBook Details:");
        for (Book book : books) {
            System.out.println(book);
        }

        scanner.close();
    }
}
