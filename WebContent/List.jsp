<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="model.User"%>
<%
	request.setCharacterEncoding("UTF-8");
	List<User> users = (List<User>) request.getAttribute("userList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>研修課題</title>
<link rel="stylesheet" href="css/styles.css">
<meta name="viewport" content="width=device-width,initial-scale=1, viewport-fit=cover">
</head>
<body>
	<div class="cp_bgpattern02">
		<header>

			<div class="midashi">
				<h1>研修課題</h1>
				<p>人物照会</p>
			</div>

		</header>
		<section class="sent">
			<h1>人物一覧</h1>
		</section>
		<section class="page">
			<%
				if (users != null) {
			%>
			<table border="1" id="form_tbl">
				<tr class="midashi">
					<th>名前</th>
					<th>住所</th>
					<th>電話</th>
					<th>年齢</th>
				</tr>
				<%
					for (int i = 0; i < users.size(); i++) {
							User user = (User) users.get(i);
				%>
				<tr>
					<td><%=user.getName()%></td>
					<td><%=user.getAddr()%></td>
					<td><%=user.getTell()%></td>
					<td><%=user.getAge()%></td>
				</tr>

				<%
					}
					}
				%>
			</table>
		</section>
		<hr>
	</div>
	<footer>
		<p>
			<a href="http://localhost:8080/kadai9/MenuServlet">最初に戻る</a>
		</p>
		<p>©Kanami Matsumura</p>
	</footer>
</body>
</html>