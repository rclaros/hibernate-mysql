/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.project.dao;

import com.ads.project.conexion.HibernateUtil;
import com.ads.project.model.Proyecto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProyectoDAO {

    public Proyecto add(Proyecto object) throws HibernateException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            tx = session.beginTransaction();
            session.save(object);
            HibernateUtil.commit(tx);
        } catch (HibernateException e) {
            HibernateUtil.rollback(tx);
            throw new HibernateException(e.getMessage(), e);
        } finally {
            HibernateUtil.close(session);
        }
        return object;
    }
}
