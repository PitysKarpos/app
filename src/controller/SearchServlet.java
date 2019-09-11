package controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.Model;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Model userModel = new Model();
		userModel.userData();
		List<User> userList = userModel.getUsers();

		request.setAttribute("userList", userList);

		String view = "/Search.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		Pattern p = Pattern.compile("[０１２３４５６７８９]");
		Matcher m = p.matcher(name);

		if(m.find()) {
			request.setAttribute("Error", name + "は全角数字が含まれています");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);

		} else {

			Model userModel = new Model();
			userModel.searchData();
			User user = userModel.searchUser(name);

			request.setAttribute("user", user);

			getServletConfig().getServletContext()
					.getRequestDispatcher("/Request.jsp")
					.forward(request, response);
		}

	}
}
