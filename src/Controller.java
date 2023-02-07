import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private Store store = new Store();

    public void addBook(Integer isbn, String title, LocalDate releaseDate, int edition, Integer authorId) {

        addBook(isbn, title, releaseDate, edition, getAuthorById(authorId));
    } // új könyv hozzádása
    public void addBook(Integer isbn, String title, LocalDate releaseDate, int edition, Author author) {

        Book book = new Book();

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setReleaseDate(releaseDate);
        book.setEdition(edition);
        book.setAuthor(author);

        Session session = HibernateContext.getSession();

        session.beginTransaction();
        session.persist(book);
        session.flush();
        session.getTransaction().commit();
    }
    public void modifyBook(int id, Integer isbn, String title, LocalDate releaseDate, int edition, Integer authorId) {

        Session session = HibernateContext.getSession();
        session.beginTransaction();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();

        session.createQuery("UPDATE Book p " +
                "SET p.isbn = :isbn ,p.author.id = :authorId,p.edition =:edition,p.releaseDate = :relaseDate, p.title = :title " +
                " WHERE p.id = :id")
                .setParameter("isbn",isbn)
                .setParameter("id" ,id)
                .setParameter("title",title)
                .setParameter("releaseDate",releaseDate)
                .setParameter("edition",edition)
                .setParameter("authorId",authorId).executeUpdate();

        em.close();
        session.flush();
        session.getTransaction().commit();
    }
    public List<Book> findBookByIsbn(int num) {

        Session session = HibernateContext.getSession();
        Transaction tx = session.beginTransaction();

        Query<Book> b = session.createQuery("select b " +
                        "from Book b " +
                        "where b.isbn = :n  ",
                Book.class).setParameter("n", num);
        List<Book> books = (List<Book>) b;

        session.getTransaction().commit();
        session.close();

        return books;
    }
    public List<Book> findBookByAuthor(String name) {

        Session session = HibernateContext.getSession();
        Transaction tx = session.beginTransaction();

        Query<Book> a = session.createQuery("select a " +
                        "from Book a " +
                        "where a.author.name = :name  ",
                Book.class).setParameter("n", name);
        List<Book> books = (List<Book>) a;

        session.clear();
        session.close();
        session.getTransaction().commit();

        return books;
    }// szerzőt keresds
    public List<Book> findBookByTitle(String name) {

        Session session = HibernateContext.getSession();
        Transaction tx = session.beginTransaction();

        Query<Book> a = session.createQuery("select a " +
                        "from Book a " +
                        "where a.title = :name  ",
                Book.class).setParameter("n", name);
        List<Book> books = (List<Book>) a;

        session.clear();
        session.close();
        session.getTransaction().commit();

        return books;
    }

    // piac kivezetes es kereses modositasa
    public void modifyAuthor(int id, String name, LocalDate birthDate, String gender) {

        Session session = HibernateContext.getSession();
        session.beginTransaction();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();

        session.createQuery("UPDATE Author p " +
                "SET p.id = :id ," +
                "p.name = :name ," +
                "p.birthDate =:birthDate," +
                "p.gender = :gender " +
                        " WHERE p.id = :id")
                .setParameter("id",id)
                .setParameter("name",name)
                .setParameter("birthDate",birthDate)
                .setParameter("gender",gender).executeUpdate();

        em.close();
        session.flush();
        session.getTransaction().commit();
    }
    public Author addAuthor(String name, LocalDate birthDate, String gender) {

        Author author = new Author();

        author.setName(name);
        author.setBirthDate(birthDate);
        author.setGender(gender);

        Session session = HibernateContext.getSession();

        session.beginTransaction();
        session.persist(author);
        session.flush();
        session.getTransaction().commit();

        return author;
    } // új szerző hozzáadása
    public void deleteAuthor(int id){
        Session session = HibernateContext.getSession();
        session.beginTransaction();

        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        Author author = (Author) em.createQuery("select a " +
                "from Author a " +
                "where a.id = :id").setParameter("id", id).getResultList().get(0);
        em.remove(author);

        session.flush();
        session.getTransaction().commit();
        em.close();
    }
    public Author getAuthorById(Integer id) {

        Author author;
        Session session = HibernateContext.getSession();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        author = (Author) em.createQuery("select a " +
                "from Author a " +
                "where a.id = :id").setParameter("id", id).getResultList().get(0);

        em.getTransaction().commit();
        em.close();
        session.flush();
        session.getTransaction().commit();

        return author;
    }
    public void addStore(String name,String address,String owner,Boolean contract){

        Store store = new Store();

        store.setName(name);
        store.setAddress(address);
        store.setOwner(owner);
        store.setContract(contract);

        Session session = HibernateContext.getSession();

        session.beginTransaction();
        session.persist(store);
        session.flush();
        session.getTransaction().commit();
    }

    public void modifyStore(int id,String name,String address,String owner,Boolean contract){

        Session session = HibernateContext.getSession();
        session.beginTransaction();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();

        session.createQuery("UPDATE Store s " +
                "SET s.id = :id ," +
                        "s.name = :name ," +
                        "s.address =:address," +
                        "s.owner = :owner ," +
                        "s.contract  = :contrct " +
                        " WHERE s.id = :id")

                .setParameter("id",id)
                .setParameter("name",name)
                .setParameter("address",address)
                .setParameter("contract",contract)
                .executeUpdate();

        em.close();
        session.flush();
        session.getTransaction().commit();
    }
    public void deleteAll() {
//        List<Author> authors = allAuthors();
        Session session = HibernateContext.getSession();
        session.beginTransaction();

        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Book ").executeUpdate();
        em.createQuery("delete from Author ").executeUpdate();

//        for (Author author : authors) {
//            em.remove(author);
//        };
        em.close();
        session.flush();
        session.getTransaction().commit();
    }
    public List<Author> allAuthors() {

        List<Author> authors = new ArrayList<>();
        Session session = HibernateContext.getSession();

        session.beginTransaction();

        Query query = session.createQuery("from Author");

        authors = query.list();

        session.flush();
        session.getTransaction().commit();

        return authors;
    }
    public List<Book> allBooks() {

        List<Book> books = new ArrayList<>();
        Session session = HibernateContext.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from Book");
        books = query.list();
        session.flush();
        session.getTransaction().commit();
        return books;
    }
}