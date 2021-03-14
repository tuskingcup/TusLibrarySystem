/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CLinicIT
 */
public class Book extends Item {

    private String ISBN;
    private String publisher;

    public Book(String ISBN, String publisher, String barcode, String title) {
        super(barcode, title);
        this.ISBN = ISBN;
        this.publisher = publisher;
    }

    public Book(String ISBN, String publisher, Item i) {
        super(i);
        this.ISBN = ISBN;
        this.publisher = publisher;
    }
    
    public Book(Book b) {
        this(b.ISBN, b.publisher, b);
    }

    
}
