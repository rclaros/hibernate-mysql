/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.project.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     *
     * @return
     */
    public static SessionFactory getSessionFactory() {
        log.debug("Call getSessionFactory..");
        return sessionFactory;
    }

    /**
     *
     * @param session
     */
    public static synchronized void close(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
            log.debug("Close session hibernateUtil..");
        }
    }

    /**
     *
     * @param tx
     */
    public static void commit(Transaction tx) {
        if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
            tx.commit();
        }
    }

    /**
     *
     * @param tx
     */
    public static void rollback(Transaction tx) {
        if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) {
            tx.rollback();
        }
    }
}
