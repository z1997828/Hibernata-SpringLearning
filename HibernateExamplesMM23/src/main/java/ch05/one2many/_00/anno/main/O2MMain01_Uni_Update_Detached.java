package ch05.one2many._00.anno.main;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch00.HibernateUtils;
import ch05.one2many._00.anno.model.Department;
import ch05.one2many._00.anno.model.Employee;
// 客服部修改一位員工資料: 黃華改為 黃華昌 
// 會計部刪除一位員工: 陳淑芳
// 工程部新增一位員工: 
// Employee emp1 = new Employee(null, "CUS004", "林婉欣(工程部)-Detached");
// 
public class O2MMain01_Uni_Update_Detached {
	                              
	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// 建立SessionFactory物件
			sessionFactory = HibernateUtils.getSessionFactory();
			// 取出Session物件
			session = sessionFactory.openSession();
			System.out.println("得到Session物件");
			// 開啟交易
			tx = session.beginTransaction();
			// 更新一方物件
			Department dept1 = session.get(Department.class, 1);
			Department dept2 = session.get(Department.class, 2);
			Department dept3 = session.get(Department.class, 3);
			Hibernate.initialize(dept1.getEmployees());
			Hibernate.initialize(dept2.getEmployees());
			Hibernate.initialize(dept3.getEmployees());
			tx.commit();
			session.close();
			System.out.println("三個Department物件已經成為Detached物件");
			// 客服部修改一位員工資料: 黃華改為 黃華昌 
			Set<Employee> employees1 = dept1.getEmployees();
			Iterator<Employee> it1 = employees1.iterator();
			while (it1.hasNext()) {
				Employee e = it1.next();
				if (e.getName().equals("黃華"))
					e.setName("黃華昌");
			}
			// 會計部刪除一位員工: 陳淑芳
			//			
			Set<Employee> employees2 = dept2.getEmployees();
			Iterator<Employee> it2 = employees2.iterator();
			while (it2.hasNext()) {
				Employee e = it2.next();
				if (e.getName().equals("陳淑芳"))
					it2.remove();
			}
			// 工程部新增一位員工: 
			Employee emp1 = new Employee(null, "CUS004", "林婉欣(工程部)-Detached");
			Set<Employee> employees3 = dept3.getEmployees();
			employees3.add(emp1);
			session = sessionFactory.openSession();
			System.out.println("得到Session物件");
			// 開啟交易
			tx = session.beginTransaction();
			session.update(dept1);
			session.update(dept2);
			session.update(dept3);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("發生例外: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("關閉SessionFactory");
				sessionFactory.close();
			}
		}
	}
}

