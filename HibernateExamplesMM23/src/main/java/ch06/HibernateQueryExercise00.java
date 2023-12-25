package ch06;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ch00.HibernateUtils;
import ch06.model.Employee;
import net.sf.ehcache.hibernate.HibernateUtil;

public class HibernateQueryExercise00 {

	public static void main(String[] args) {
		System.out.println("本程式為模板，無法執行");
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		String hql = "FROM Employee";
		Object obj = new Object();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();	
		
		   List<Employee> emps = session.createQuery(hql)
			    .setParameter("", obj)	
				.setParameter("", obj)
				.getResultList();
		   tx.commit();
		   System.out.println(emps);
		} catch(Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
	}

}
