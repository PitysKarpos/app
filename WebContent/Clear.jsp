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
			<form action="ClearServlet" name="form" method="POST">
				<h1>完全削除</h1>
				<p>完全に削除する人物名を入力してください</p>
				<input type="text" name="name" value=""> <input
					type="submit" value="削除" id="submit" onClick="return Check()">
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
		var checked = confirm("本当削除してもよろしいですか？\n二度とデータを復元できません");
		if (checked == true) {
			return true;
		} else {
			return false;
		}
	}
	</script>
</body>
</html>