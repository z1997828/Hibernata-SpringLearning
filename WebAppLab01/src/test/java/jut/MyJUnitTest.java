package jut;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lab01.model.MemberBean;
import lab01.utils.HibernateUtils;

public class MyJUnitTest {
	SessionFactory factory;
	Session session;
	Transaction tx;
	@Before
	public void setUp() throws Exception {
		factory = HibernateUtils.getSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		tx.commit();
		session.close();
		factory.close();
	}

	@Test
	public void test() {
		MemberBean memberbean = new MemberBean("AA001", "HelloKitty", "0919-123456","null1235", Date.valueOf("1990-12-20"),  Timestamp.valueOf("1990-12-20 13:13:13"), 50.0);
		session.save(memberbean);
	}
	
	@Test
	public void test2() {
		MemberBean memberbean = new MemberBean("AA002", "pikachu", "0919-222456","abc1235", Date.valueOf("1990-11-20"),new Timestamp(System.currentTimeMillis()), 90.0);
		session.save(memberbean);
	}
}
