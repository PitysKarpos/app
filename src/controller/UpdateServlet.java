package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Model userModel = new Model();
		userModel.userData();
		List<User> userList = userModel.getUsers();

		request.setAttribute("userList", userList);

		String view = "/Update.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(view);

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 打ち込まれた名前と住所を変数に代入
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");

		// 呼び出し先Jspに渡すデータセット
		request.setAttribute("name", name);
		request.setAttribute("addr", addr);

		Model userModel = new Model();
		userModel.userData();
		List<User> userList = userModel.getUsers();

		//打ち込まれた名前がlistの中になかったらエラー画面へ
		List<String> list = new ArrayList<>();
		for (User users : userList) {
			String userName = users.getName();
			list.add(userName);
		}
		if (list.contains(name)) {

			String view = "/Update_complete.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(view);
			dispatch.forward(request, response);
		} else {
			//打ち込まれたデータをモデルクラスにポーイッ
			Model upDate = new Model();
			upDate.updateSql(name, addr);

			request.setAttribute("Error", "「" + name + "」という人は登録されていません");
			String view = "/Update_error.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(view);
			dispatch.forward(request, response);
		}

	}
}
