package customer.helperClass;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;




public class HibernateUtil {
    
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    
    public static SessionFactory createSessionFactory() {
        
        Configuration configuration = new Configuration();
        configuration.configure();
        
        registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(registry);
        return sessionFactory;
    }

    public static void closeHibernateUtil()
    {
        StandardServiceRegistryBuilder.destroy(registry);
    }

    
}
