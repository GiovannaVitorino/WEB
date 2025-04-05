package br.edu.ifspcjo.ads.web2.exercicio2.controller;

import java.io.IOException;
import br.edu.ifspcjo.ads.web2.exercicio2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
 public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		User user = new User();
		
		user.setLogin(login);
		user.setPassword(password);
		
		if(user.getLogin().equals("giovanna.vitorino@gmail.com") && user.getPassword().equals("123456")) {
			
			resp.sendRedirect("login.jsp");
	}
		else {
			resp.sendRedirect("erro.jsp");
		}
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}