/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.repository;

import com.mycompany.lo54.entity.Course;
import com.mycompany.lo54.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Paul-Huang
 */
public class HibernateCourseDao {
    public List<Course> selectAllCourse(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> list = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course");
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
    
    public Course selectCourse(String code){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course course = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course where code = ?");
                course = (Course) session.get(Course.class, code);
                session.getTransaction().commit();
                return course;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
                return course;
		}
		finally {
	         session.close();
                }
    }
    public void addCourse(Course c) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(c);
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
    
    public void DeleteCourse(String code) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
                Course c = (Course) session.get(Course.class,code);
                session.delete(c);
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
