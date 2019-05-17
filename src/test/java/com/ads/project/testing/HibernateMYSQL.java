/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ads.project.testing;

import com.ads.project.conexion.HibernateUtil;
import com.ads.project.dao.PermisoDAO;
import com.ads.project.dao.ProyectoDAO;
import com.ads.project.dao.UsuarioDAO;
import com.ads.project.model.Permiso;
import com.ads.project.model.Proyecto;
import com.ads.project.model.Usuario;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rclaros
 */
public class HibernateMYSQL {

    public HibernateMYSQL() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void inserta_Datos() {
        /**
         * saving permiso
         */
        Permiso permiso = new Permiso();
        permiso.setName("Administrador");
        permiso.setAcl(12);
        permiso.setModified(new Date());
        permiso.setCreatedby("admin");
        new PermisoDAO().add(permiso);
        /**
         * saving usuario
         */
        Usuario usuario = new Usuario();
        usuario.setName("Jhone Doe");
        usuario.setEmail("jhondoe@gmail.com");
        usuario.setCreated(new Date());
        usuario.setCreatedby("Jhon Doe");
        usuario.setPermiso(permiso);
        new UsuarioDAO().add(usuario);
        /**
         * saving proyecto
         */
        Proyecto proyecto1 = new Proyecto();
        proyecto1.setTitle("project 1");
        proyecto1.setDatestart(new Date());
        proyecto1.setDateend(new Date());
        proyecto1.setUsuario(usuario);

        Proyecto proyecto2 = new Proyecto();
        proyecto2.setTitle("project 2");
        proyecto2.setDatestart(new Date());
        proyecto2.setDateend(new Date());
        proyecto2.setUsuario(usuario);

        /**
         * listar usuario con permiso y usuarios
         */
        new ProyectoDAO().add(proyecto1);
        new ProyectoDAO().add(proyecto2);
    }

    @Test
    public void lista_usuarios() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            List<Usuario> usuarios = criteria.list();
            if (!usuarios.isEmpty()) {
                for (Usuario usuario : usuarios) {
                    System.out.println("Id: " + usuario.getId());
                    System.out.println("Name : " + usuario.getName());
                    System.out.println("Proyectos : " + usuario.getProyectos().size());
                    System.out.println("Permiso : " + usuario.getPermiso().getAcl());
                }
            }
        } catch (HibernateException e) {
            throw new HibernateException(e.getMessage(), e);
        } finally {
            HibernateUtil.close(session);
        }
    }
}
