<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%@ page import="model.Model"%>
<%
	request.setCharacterEncoding("UTF-8");
	User user = (User) request.getAttribute("user");
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
			<h1>検索結果</h1>
			<form action="SearchServlet" name="form" method="POST">
				<input type="text" name="name" value=""> <input
					type="submit" value="検索" id="submit" onclick="return checkForm()">
			</form>
			<%
				if (user != null) {
			%>

			<h2><%=user.getName()%></h2>


			<div class="cp_list">
				<p id="koumoku">住所</p>
					<p><%=user.getAddr()%></p>
				<p id="koumoku">電話</p>
					<p><%=user.getTell()%></p>
				<p id="koumoku">年齢</p>
					<p><%=user.getAge()%></p>
			</div>
			<%
				} else {
			%>
			<p>該当なし</p>
			<%
				}
			%>
		</section>
		<hr>
	</div>

	<footer>
		<p>
			<a href="http://localhost:8080/kadai9/SearchServlet">前の画面</a>
		</p>
		<p>
			<a href="http://localhost:8080/kadai9/MenuServlet">最初に戻る</a>
		</p>
		<p>©Kanami Matsumura</p>
	</footer>
	<script type="text/javascript">
		function checkForm() {

			var flag = 0;

			// 設定開始（チェックする項目を設定してください）

			if (document.form.name.value.match(/[^a-zA-Z]+/)) {
				flag = 1;
			}

			// 設定終了

			if (flag) {
				return true; // 送信を実行
			} else {
				window.alert('半角英字は入力できません'); // 数字以外が入力された場合は警告ダイアログを表示
				return false; // 送信を中止
			}
		}
	</script>
</body>
</html>