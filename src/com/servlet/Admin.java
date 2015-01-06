package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.DAONew;
import com.Database.DAOUser;
import com.beans.News;
import com.beans.User;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/lol")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (title.length() > 0 && content.length() > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("newsid", session.getAttribute("newsid") == null ? 0 : (int)session.getAttribute("newsid") + 1);
			User user = DAOUser.getUser((String)session.getAttribute("login"), (String)session.getAttribute("password"));
			DAONew.addNews(new News((int)session.getAttribute("newsid"), title, content, user));
			response.sendRedirect("/JWeb/Admin/");
		}
	}

}
