package hibernate;

import models.DynamicData;
import models.entity.MainData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryMaker
{
    private static SessionFactory sessionFactory;

    private static void configureFactory()
    {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(MainData.class)
                    .addAnnotatedClass(DynamicData.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static org.hibernate.SessionFactory getFactory() {
        if (sessionFactory == null) {
            configureFactory();
        }

        return sessionFactory;
    }
}
