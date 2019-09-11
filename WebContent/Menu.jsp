<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

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
			<form action="MenuServlet" method="GET">
				<h1>項目</h1>
				<p class="Search">
					<a href="http://localhost:8080/kadai9/SearchServlet">検索</a>
				</p>
				<p class="List">
					<a href="http://localhost:8080/kadai9/ListServlet">一覧</a>
				</p>
				<p class="Entry">
					<a href="http://localhost:8080/kadai9/EntryServlet">登録</a>
				</p>
				<p class="Update">
					<a href="http://localhost:8080/kadai9/UpdateServlet">更新</a>
				</p>
				<p class="Delete">
					<a href="http://localhost:8080/kadai9/DeleteServlet">削除</a>
				</p>
				<p class="Clear">
					<a href="http://localhost:8080/kadai9/ClearServlet">消去</a>
				</p>
			</form>
		</section>
		<hr>
	</div>
	<footer>
		<p>©Kanami Matsumura</p>
	</footer>
</body>
</html>