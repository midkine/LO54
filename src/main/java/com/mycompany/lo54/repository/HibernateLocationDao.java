/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.repository;

import com.mycompany.lo54.entity.Location;
import com.mycompany.lo54.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Paul-Huang
 */
public class HibernateLocationDao {
    public List<Location> selectAllLocation(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Location> list = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Location");
                list = query.list();
                session.getTransaction().commit();
                return list;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
                return list;
		}
		finally {
	         session.close();
                }
    }
    
    public Location selectCourse(Integer lid){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Location location = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Location where lid = ?");
                location = (Location) session.get(Location.class, lid);
                session.getTransaction().commit();
                return location;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
                return location;
		}
		finally {
	         session.close();
                }
    }
    public void addLocation(Location l) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(l);
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	         session.close();
                }
    }
    
    public void DeleteLocation(Integer lid) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
                Location l = (Location) session.get(Location.class,lid);
                session.delete(l);
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	         session.close();
                }
    }
}
