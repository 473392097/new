package com.lanou.uilts;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by lanouhn on 17/8/8.
 */
public class Utils {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static Session openSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }


    public static Session getSession() {
        return ourSessionFactory.getCurrentSession();
    }


}
