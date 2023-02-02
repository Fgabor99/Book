import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Store")
public class Store {
    @ManyToMany
    @JoinColumn
    private List<Book> book;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String address;
    String owner; // tulajdonos
    String name;

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddrass() {
        return address;
    }

    public void setAddrass(String addrass) {
        this.address = addrass;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "book=" + book +
                ", id=" + id +
                ", addrass='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
