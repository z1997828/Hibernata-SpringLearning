package ch06_sll.ex01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch06_sll.ex01.model.Category;
import ch06_sll.ex01.service.CategoryService;

@WebServlet("/ch06_sll/ex01/queryAllCategoriesS.do")
public class QueryAllCategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	CategoryService categoryService;
	
	public QueryAllCategoriesServlet() {
//		this.categoryService = new CategoryServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext webApplicationContext = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		CategoryService categoryService = webApplicationContext.getBean(CategoryService.class);
		List<Category> categories = categoryService.findAll();
		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/ch06_sll/ex01/showCategoriesS.jsp");
		rd.forward(request, response);
		return;
	}

}
