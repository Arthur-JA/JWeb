package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.DAOProduct;
import com.beans.Comment;
import com.beans.Product;
import com.beans.User;

/**
 * Servlet implementation class Products
 */
@WebServlet("/Products")
public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User("JeanClaude", User.Role.USER, "aaaa@epitech.eu", "aaa");
		List<Comment> comments = new ArrayList<Comment>();
		for (int i = 0; i < 5; i++)
			comments.add(new Comment("C'est tres tres bien on se regale avec ca je ne saurais que le recommender.", u));
		List<Product>	products = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			Product p = new Product("Product" + i, i, "Its product" + i + ". Very good!");
			p.setComments(comments);
			products.add(p);
		}
		List<Product> plist = DAOProduct.getProductList();
		request.setAttribute("products", plist);
		this.getServletContext().getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
