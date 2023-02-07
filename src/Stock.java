import jakarta.persistence.*;

import java.util.List;

public class Stock {
    //book -> OneToOne
    //store -> OneToOne
    //darabszam ->

    @OneToOne
    private List<Book> books;
    @ManyToOne
    private List<Store> store;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Store> getStore() {
        return store;
    }

    public void setStore(List<Store> store) {
        this.store = store;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    int piece;

    @Override
    public String toString() {
        return "Stock{" +
                "books=" + books +
                ", store=" + store +
                ", piece=" + piece +
                '}';
    }
}
