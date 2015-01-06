package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.DAOUser;
import com.Database.Database;
import com.beans.News;
import com.beans.User;
import com.beans.User.Role;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db = Database.getInstance();
		if (request.getParameter("state") != null && request.getParameter("state").equals("logout"))
			request.getSession().removeAttribute("login");
		User user = new User("Toto", User.Role.USER, "caca@epitech.eu", "testmdp");
		List<News> news = new ArrayList<News>();
		
		news.add(new News("Vive le JWeb", "C tro b1", user));
		news.add(new News("Vive le JWeb", "C tro b1", user));
		news.add(new News("Vive le JWeb", "C tro b1", user));
		
		request.setAttribute("news", news);
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		if (DAOUser.getUser(login, password) != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			session.setAttribute("password", password);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}
}
