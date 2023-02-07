import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;
public class HibernateContext implements AutoCloseable {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            Properties props = new Properties();

            props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            props.put("hibernate.connection.url", System.getenv("pdb_url"));
            props.put("hibernate.connection.username", System.getenv("pdb_user"));
            props.put("hibernate.connection.password", System.getenv("pdb_pw"));
            props.put("provider", "org.hibernate.jpa.HibernatePersistenceProvider");
            props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            props.put(Environment.SHOW_SQL, "false");
            props.put(Environment.PERSISTENCE_UNIT_NAME, "book");
            props.put(Environment.HBM2DDL_AUTO, "create-drop");

            configuration.setProperties(props);

            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Store.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void close() throws Exception {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}