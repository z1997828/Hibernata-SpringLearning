package ch06_sll.ex02.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ch06_sll.ex00.HibernateUtils;

@WebFilter(urlPatterns = { "/ch06_sll/ex02/queryCategoryById.do" })
                            
public class HibernateFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig fConfig;
	private SessionFactory factory;

	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		factory = HibernateUtils.getSessionFactory();
	}

	public void destroy() {
		factory.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Transaction tx = null;
		try {
			Session session = factory.getCurrentSession();
			tx = session.beginTransaction();
			// 下一敘述會啟動控制器(Servlet), DAO, 視圖(JSP)，這些程式執行時Session都保持在開啟狀態
			chain.doFilter(request, response);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}
}
