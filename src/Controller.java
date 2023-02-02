import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@org.springframework.stereotype.Controller
public class Controller {
    private Store store = new Store();

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
    public void addBook(Integer isbn, String title, LocalDate releaseDate, int edition, Integer authorId) {

       addBook(isbn, title, releaseDate, edition, getAuthorById(authorId) );
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

    public Author getAuthorById(Integer id){
        Author author;
        Session session = HibernateContext.getSession();
        session.beginTransaction();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        author = (Author) em.createQuery("select a from Author a where a.id = :id").setParameter("id", id).getResultList().get(0);
        em.getTransaction().commit();
        em.close();
        session.flush();
        session.getTransaction().commit();
        return author;
    }

    public void bookModifaction() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("melyik könyvet szeretnéd módosítani ? ");
        System.out.println("írd be az ID-t");
        int num=scanner.nextInt();

    }
    /*         System.out.println("írd be a könyv címét vagy a szerzőt vagy az ISBN-t"); */
    public void bookSearch() {
    }
    public void deleteAll(){
        List<Author> authors = allAuthors();
        Session session = HibernateContext.getSession();
        session.beginTransaction();
        EntityManager em = session.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        for (Author author: authors) {
            em.remove(author);
        };
        em.getTransaction().commit();
        em.close();
        session.flush();
        session.getTransaction().commit();
    }
    public List<Author> allAuthors(){

       List<Author> authors = new ArrayList<>();
        Session session = HibernateContext.getSession();
        session.beginTransaction();
        Query query=session.createQuery("from Author");//here persistent class name is Emp
        authors = query.list();
        session.flush();
        session.getTransaction().commit();
        return authors;
    }

    public List<Book> allBooks(){

        List<Book> books = new ArrayList<>();
        Session session = HibernateContext.getSession();
        session.beginTransaction();
        Query query=session.createQuery("from Book");//here persistent class name is Emp
        books = query.list();
        session.flush();
        session.getTransaction().commit();
        return books;
    }
}