package ch05.ex02.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ch05.ex00.entity.Member;
import ch05.ex00.service.MemberService;

@WebServlet("/ch05/ex02/queryAllMembers.do")
public class QueryAllMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService memberService = (MemberService)context.getBean("memberServiceInMemory");
		Collection<Member> coll = memberService.findAll();
		request.setAttribute("AllMembers", coll);
		RequestDispatcher rd = request
				.getRequestDispatcher("/ch05/ex02/showAllMembers.jsp");
		rd.forward(request, response);
		return;
	}
}
