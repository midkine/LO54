/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lo54.repository;

import com.mycompany.lo54.entity.Course_Session;
import com.mycompany.lo54.util.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Paul-Huang
 */
public class HibernateCourse_SessionDao {
    public List<Course_Session> selectAllSession(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course_Session> list = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course_Session");
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
    
    public Course_Session selectCourseById(Integer csid){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Course_Session course_session = null;
	    try {
	        session.beginTransaction();
                course_session = (Course_Session) session.get(Course_Session.class, csid);
                session.getTransaction().commit();
                return course_session;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
                return course_session;
		}
		finally {
	         session.close();
                }
    }
    
    public List<Course_Session> selectCourseByDate(String s) throws ParseException{
        Session session = HibernateUtil.getSessionFactory().openSession();
        Date date = null;
        List<Course_Session> list = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("from Course_Session where start_date = ?");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
                date=sdf.parse(s);  
                query.setDate(0, date);
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
    
  
    public List<Map> selectCourseByLocation(String location){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Map> list = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("select new map(cs.csid as id, cs.start_date as sdate, cs.end_date as edate,"
                        + " c.title as course, l.city as location)"
                        + "from Course_Session cs, Course c, Location l where cs.location.lid = l.lid "
                        + "and cs.course.code = c.code and l.city = ?");
                query.setString(0, location);
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
    
   public List<Map> selectCourseByTitle(String title){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Map> list = null;
	    try {
	        session.beginTransaction();
	        Query query = session.createQuery("select new map(cs.csid as id,cs.start_date as sdate,cs.end_date as edate,"
                        + "cs.course as course,cs.location as location)"
                        + " from Course_Session cs, Course c"
                        + " where c.code= cs.course.code and c.title = ?");
                query.setString(0, title);
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
    
    public void addCourse_Session(Course_Session cs) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.save(cs);
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
    
    public void updateCourse_Session(Course_Session cs) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        session.update(cs);
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
    
    public void DeleteCourse_Session(Integer csid) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
                Course_Session l = (Course_Session) session.get(Course_Session.class,csid);
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
