<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body class="c1">
メニュー画面<br>

<form action="registration.jsp" method="POST">
<p><input class="button" type="submit" value="会員情報新規登録"></p></form>
<form action="edit.jsp" method="POST">
<p><input class="button" type="submit" value="会員情報変更"></p></form>
<form action="delete.jsp" method="POST">
<p><input class="button" type="submit" value="会員情報削除"></p></form>
</body>
</html>