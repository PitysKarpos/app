<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="model.User"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = (String) request.getAttribute("name");
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
			<h1>人物登録</h1>
			<p>以下の人物の情報を削除しました</p>
			<p><%=name%></p>
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