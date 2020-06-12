<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.co.aforce.beans.MemberBean"%>
    <jsp:useBean id="memberBean" class="jp.co.aforce.beans.MemberBean" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
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
<p>会員情報変更画面</p>
<span class="label label-danger">${msg}</span>

<form action="display-servlet" method="POST">
<p><span class="c8">会員番号</span>
<input type="text" name="member_no" class="c4">
<input type="submit" value="表示"></p>
</form>

<%
   String name = memberBean.getName();
   int age = memberBean.getAge();
   int birth_year = memberBean.getBirth_year();
   int birth_month = memberBean.getBirth_month();
   int birth_day = memberBean.getBirth_day(); %>

<form action="edit-servlet" method="POST" name="form1" onSubmit="return check()">
<div><span>名前</span>
<input type="text" name="name"
<% if (name == null) {%>
       value=""
<%} else {%>
       value=
       "<%=name %>"
<%} %>class="c4"></div><br>
<div><span>年齢</span>
<input type="text" name="age"
<% if (age == 0) {%>
       value=""
<%} else {%>
       value=
       "<%=age %>"
<%} %>class="c4"></div><br>
<div><span>生年月日</span>
<select name="birth_year" class="c5">
<option value=""></option>
<% for (int i =1920; i <= 2020; i++) {
	%>
	<option value="<%=i%>"
	<%if (i == birth_year){%>
	selected
	<%}%>><%=i %></option>
<%} %>
</select>
<select name="birth_month" class="c5">
<option value=""></option>
<% for (int i =1; i<=12;i++) {
	%>
	<option value="<%=i%>"
	<%if (i == birth_month) { %>
	selected
	<%}%>><%=i %></option>
<%} %>
</select>
<select name="birth_day" class="c5">
<option value=""></option>
<% for (int i =1; i<=31;i++) {
	%>
	<option value="<%=i%>"
	<%if (i == birth_day) { %>
	selected
	<%} %>><%=i %></option>
<%} %>
</select></div><br>
<div class=c2>
<button type="button" onClick="location.href='http://localhost:8070/MemberInformation/views/menu.jsp';" class="c6">戻る</button>
<input type="hidden" name="member_no" value="<%=memberBean.getMember_no()%>">
<input type="submit" value="変更" class="c7"></form></div>
<% session.invalidate(); %>
</body>
</html>