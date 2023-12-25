//package ch06.ex01.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.hibernate.SessionFactory;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
////@WebFilter(urlPatterns={"/ch06/ex02/queryAllMembers.do"})
//@SuppressWarnings("unused")
//public class HibernateFilter implements Filter {
//    private SessionFactory factory = null;
//	private FilterConfig config = null;
//    
//    public HibernateFilter() {
//
//    }
//
//	public void destroy() {
//
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
////		Transaction tx = null;
////		try {
////			tx = factory.getCurrentSession().beginTransaction();
//			chain.doFilter(request, response);
////			tx.commit();
////		} catch(Exception ex){
////			ex.printStackTrace();
////			System.out.println(ex.getMessage());
////			if (tx!=null){
////				tx.rollback();
////			}
////		}		
//	}
//
//	public void init(FilterConfig fConfig) throws ServletException {
//		this.config = fConfig;
//		WebApplicationContext context = 
//				WebApplicationContextUtils.getWebApplicationContext(fConfig.getServletContext());
//		factory = (SessionFactory)context.getBean("sessionFactory", SessionFactory.class);
//	}
//}
