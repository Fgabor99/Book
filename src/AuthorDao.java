import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Integer> {

        Author findByName(String name);

}
