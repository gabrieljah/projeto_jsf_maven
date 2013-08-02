package br.com.projeto.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author gabriel
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";

    static {
        try {

            System.out.println("Tentando iniciar uma Session Factory");

            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();

            sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder);

            System.out.println("Session Factory iniciada com sucesso!");

        } catch (Exception ex) {

            System.out.println("Ocorreu um erro ao iniciar a Session Factory" + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
