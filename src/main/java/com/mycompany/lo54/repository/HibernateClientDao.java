/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.repository;

import com.mycompany.lo54.entity.Client;
import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.util.HibernateUtil;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Paul-Huang
 */
public class HibernateClientDao {
    public void addUser(Client c) {
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
    
    public Client selectUser(Integer cid) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
            Client c = null;
	    try {
	        session.beginTransaction();
	        c = (Client) session.get(Client.class,cid);
	        session.getTransaction().commit();
                return c;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
                return c;
		}
		finally {
	         session.close();
                }
    }
    
    public void deleteUser(Integer cid) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
                Client c = (Client) session.get(Client.class, cid);
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
    public void updateUser(Client c) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.update(c);
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
 
    //生成PDF用
    public List<Map> SelectClients() {
	    Session session = HibernateUtil.getSessionFactory().openSession();
            List<Map> list = null;
	    try {
	        session.beginTransaction();
                Query query = session.createQuery("select new map(cs.csid as id, cs.start_date as sdate, cs.end_date as edate,"
                        + "c.title as course, l.city as location, cl.lastname as lname, cl.firstname as fname"
                        + "from Course_Session cs, Course c, Location l, Client cl where cs.location.lid = l.lid "
                        + "and cs.course.code = c.code and cl.course_session_csid = cs.csid");
                list=query.list();
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


   
}
