<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<script type="text/javascript">
<!--
function check() {
var flag = 0;
if (document.form1.name.value == "") {
	flag = 1;
}else if (document.form1.age.value == "") {
	flag = 1;
}else if (document.form1.birth_year.value == "") {
	flag = 1;
}else if (document.form1.birth_month.value == "") {
	flag = 1;
}else if (document.form1.birth_day.value == "") {
	flag = 1;
}
if (flag){
	window.alert ('入力されていない項目があります');
	return false;
}else {
	return true;
}
}
//-->
</script>
</head>
<body class="c1">
会員情報新規登録画面
<p></p>
<span class="label label-danger">${msg}</span>
<form action="registration-servlet" method="POST" name="form1" onSubmit="return check()">
<div><span class="c3">名前</span>
<input type="text" name="name" class="c4"></div><br>
<div><span class="c3">年齢</span>
<input type="text" name="age" class="c4"></div><br>
<div><span class="c3">生年月日</span>
<select name="birth_year" class="c5">
<option value=""></option>
<%
for (int i =1920; i <= 2020; i++) {
	%>
	<option value="<%=i %>"><%=i %></option>
<%} %>
</select>
<select name="birth_month" class="c5">
<option value=""></option>
<%
for (int i =1; i<=12;i++) {
	%>
	<option value="<%=i%>"><%=i %></option>
<%} %>
</select>
<select name="birth_day" class="c5">
<option value=""></option>
<%
for (int i =1; i<=31;i++) {
	%>
	<option value="<%=i%>"><%=i %></option>
<%} %>
</select></div><br>

<div class=c2>
<button type="button" onClick="location.href='http://localhost:8070/MemberInformation/views/menu.jsp';" class="c6">戻る</button>
<input type="submit" value="登録" class="c7"></form>
</div>
</body>
</html>