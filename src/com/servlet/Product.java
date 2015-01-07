package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.DAOComment;
import com.Database.DAOProduct;
import com.Database.DAOUser;
import com.beans.Comment;
import com.beans.User;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		com.beans.Product p = DAOProduct.getProduct(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("product", p);

		this.getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId;
		String comment = request.getParameter("comment");
		HttpSession session = request.getSession();
		if (session.getAttribute("login") != null && DAOProduct.getProduct(productId = Integer.valueOf(request.getParameter("id"))) != null) {
			session.setAttribute("commentid", session.getAttribute("commentid") == null ? 0 : (int)session.getAttribute("commentid") + 1);
			User u = DAOUser.getUser((String)session.getAttribute("login"), (String)session.getAttribute("password"));
			//DAOComment.addComment(new Comment((int)session.getAttribute("commentid"), comment, u, productId));
		}
		response.sendRedirect("/JWeb/Product?id="+request.getParameter("id"));
	}

}
