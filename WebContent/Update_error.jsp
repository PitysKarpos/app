<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%
	// Servletのデータ受け取り
	request.setCharacterEncoding("UTF8");
	String strServlet = (String) request.getAttribute("Error");
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
			<h1>！エラー！</h1>
			<p><%=strServlet%></p>
			<p>
				<a href="http://localhost:8080/kadai9/UpdateServlet">更新に戻る</a>
			</p>
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