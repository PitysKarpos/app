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
<meta name="viewport"
	content="width=device-width,initial-scale=1, viewport-fit=cover">
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


			<form action="UpdateServlet" name="form" method="POST">
				<h1>住所更新</h1>
				<p>人物名と住所を入力してください</p>
				<div>
					<label for="name">名前</label> <input type="text" name="name"
						value="">
				</div>
				<div>
					<label for="addr">住所</label> <input type="text" name="addr"
						value="">
				</div>
				<input type="submit" value="更新" id="submit" name="btn"
					onClick="return Check()">
			</form>
		</section>
		<hr class="border">
		<section class="page">
			<h2>人物名一覧</h2>
			<section class="aaa">
				<table border="1">
					<%
						if (users != null) {

							for (int i = 0; i < users.size(); i++) {
								User user = (User) users.get(i);
					%>

					<tr>
						<td width=150px><%=user.getName()%></td>

					</tr>

					<%
						}
						}
					%>
				</table>
			</section>
		</section>
		<hr>
	</div>
	<footer>
		<p>
			<a href="http://localhost:8080/kadai9/MenuServlet">最初に戻る</a>
		</p>
		<p>©Kanami Matsumura</p>
	</footer>
	<script type="text/javascript">
		function Check() {
			var checked = confirm("住所を更新してもいいですか？");
			if (checked == true) {
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>