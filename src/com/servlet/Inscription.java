package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.DAOUser;
import com.beans.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", session.getAttribute("userid") == null ? 0 : (int)session.getAttribute("userid") + 1);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		session.setAttribute("email", email);
		User user = new User((int)session.getAttribute("userid"), login, User.Role.USER, email, password);
		DAOUser.addUser(user);
		
		response.sendRedirect("/JWeb/Inscription/");
	}

}
