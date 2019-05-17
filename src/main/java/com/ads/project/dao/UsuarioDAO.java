/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.project.dao;

import com.ads.project.conexion.HibernateUtil;
import com.ads.project.model.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioDAO {

    public Usuario add(Usuario object) throws HibernateException {
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

    public List<Usuario> getList() throws HibernateException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage(), e);
        } finally {
            HibernateUtil.close(session);
        }
    }
}
