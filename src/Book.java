import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @ManyToOne
    private Author author;

//    @ManyToMany
//    private List<Store> store;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    LocalDate releaseDate;
    int edition;
    String title;
    int isbn;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

//    public List<Store> getStore() {
//        return store;
//    }

//    public void setStore(List<Store> store) {
//        this.store = store;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
//                ", store=" + store +
                ", id=" + id +
                ", releaseDate=" + releaseDate +
                ", edition=" + edition +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
