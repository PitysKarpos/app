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
			<form action="EntryServlet" name="form" method="POST">
				<h1>人物登録</h1>
				<p>人物名を入力してください</p>
				<div>
					<label for="name">名前</label> <input type="text" name="name"
						value="">
				</div>
				<div>
					<label for="addr">住所</label> <input type="text" name="addr"
						value="">
				</div>
				<div>
					<label for="tell">電話</label> <input type="text" name="tell"
						value="">
				</div>
				<div>
					<label for="age">年齢</label> <input type="text" name="age" value="">
				</div>
				<input type="submit" value="登録" id="submit" onclick="return checkForm()">
			</form>
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