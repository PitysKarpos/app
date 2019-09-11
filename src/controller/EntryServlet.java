package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EntryServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		String view = "/Entry.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 呼び出し元Jspからデータ受け取り
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tell = request.getParameter("tell");
		String age = request.getParameter("age");

		// 呼び出し先Jspに渡すデータセット
		request.setAttribute("name", name);
		request.setAttribute("addr", addr);
		request.setAttribute("tell", tell);
		request.setAttribute("age", age);

		Pattern p = Pattern.compile("[０１２３４５６７８９]");
		Matcher m = p.matcher(tell);

		if (m.find()) {
			request.setAttribute("Error", "電話番号" + "[" + tell + "]" + "に全角数字が含まれています");
			String view = "/Entry_error.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(view);
			dispatch.forward(request, response);

		} else {
			//打ち込まれたデータをモデルクラスにポーイッ
			Model userModel = new Model();
			userModel.insertUser(name, addr, tell, age);

			String view = "/Entry_complete.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(view);
			dispatch.forward(request, response);
		}

	}

}
