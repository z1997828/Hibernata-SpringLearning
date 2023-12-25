package ch06_sll.ex02.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch06_sll.ex02.model.CategoryH;
import ch06_sll.ex02.service.CategoryServiceH;
import ch06_sll.ex02.service.impl.CategoryServiceImplH;
 
@WebServlet("/ch06_sll/ex02/queryAllCategoriesH.do")
public class QueryAllCategoriesHibernateH extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryServiceH categoryService;
	
	public QueryAllCategoriesHibernateH() {
		this.categoryService = new CategoryServiceImplH();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoryH> categories = categoryService.findAll();
		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/ch06_sll/ex02/showCategoriesH.jsp");
		rd.forward(request, response);
		return;
	}

}
