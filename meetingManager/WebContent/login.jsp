<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html" ;charset="gb2312">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />

</head>
<body>

	<div class="page-content">
		<div class="content-nav">登录</div>
		<font color="red">${msg}</font>
		<form action="LoginServlet" method="post">
			<fieldset>
				<legend>登录信息</legend>
				<table class="formtable" style="width:50%">
					<tr>
						<td>账号名:</td>
						<td><input id="accountname" name="username" type="text" /></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input id="new" name="password" type="password" /></td>
					</tr>
					<tr>
						<td></td>
						<td><select id="timelength" name="timelength">
								<option value="0" selected>每次都需要登录</option>
								<option value="10">10天内</option>
								<option value="30">30天内</option>
						</select></td>
					</tr>
					<tr>
						<td colspan="2" class="command"><input type="submit"
							value="登录" class="clickbutton" /> 
							<input type="button" value="注册" class="clickbutton"
							onclick="window.location.href='ForwardRegisterServlet';" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

</body>
</html>