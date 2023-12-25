package ch05.ex02.controller;

import java.io.IOException;

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

@WebServlet("/ch05/ex02/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		int iid = Integer.parseInt(id);
//		MemberService memberService = new MemberServiceImpl_Jdbc();  // JDBC
//		MemberService memberService = new MemberServiceImpl_Hibernate();  
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		MemberService memberService = (MemberService)context.getBean("memberServiceInMemory");
		Member member = memberService.findById(iid);
		System.out.println(member);
		request.setAttribute("member", member);
		RequestDispatcher rd = request.getRequestDispatcher("/ch05/ex02/updateMember.jsp");
		rd.forward(request, response);
		return;
	}
}