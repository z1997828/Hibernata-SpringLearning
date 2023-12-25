package ch06_sll.ex02.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch06_sll.ex02.model.CategoryH;
import ch06_sll.ex02.service.CategoryServiceH;
import ch06_sll.ex02.service.impl.CategoryServiceImplH;

@WebServlet("/ch06_sll/ex02/queryCategoryById.do")
public class QueryCategoryH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryServiceH categoryService ;
	
	public QueryCategoryH() {
		this.categoryService = new CategoryServiceImplH();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("catId");
		int id = -1;
		try {
			id = Integer.parseInt(sid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		CategoryH category = categoryService.findById(id);
		request.setAttribute("category", category);
		RequestDispatcher rd= request.getRequestDispatcher("/ch06_sll/ex02/showProductsByCategoryH.jsp");
		rd.forward(request, response);
		return;
	}
}
