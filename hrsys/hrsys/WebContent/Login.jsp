<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<h2>${msg }</h2>
	
	<form name="form1" method="post"
		action="LoginServlet">
		<table width="300" border="0" align="center" cellpadding="4"
			cellspacing="1" bgcolor="#FF9900">
			<tr>
				<td height="24" colspan="2" align="center" bgcolor="#FFCC66">
					管理员登陆</td>
			</tr>
			<tr>
				<td width="77" height="24" align="center" bgcolor="#FFFFFF">
					管理账号</td>
				<td width="204" height="24" bgcolor="#FFFFFF"><input
					name="adminName" type="text" id="adminname" class="input1" value="${param.adminName }">
				</td>
			</tr>
			<tr>
				<td height="24" align="center" bgcolor="#FFFFFF">管理密码</td>
				<td height="24" bgcolor="#FFFFFF"><input name="adminPwd"
					type="password" id="adminpwd" class="input1" ></td>
			</tr>
			<tr>
				<td height="24" align="center" bgcolor="#FFFFFF">管理级别</td>
				<td height="24" bgcolor="#FFFFFF"><input name="adminlevel"
					type="radio" value="1" checked> 管理员 <input
					name="adminlevel" type="radio" value="2"> 操作员</td>
			</tr>
			<tr>
				<td height="24" colspan="2" align="center" bgcolor="#FFFFFF"><input
					type="submit" name="Submit" value="进入系统"> &nbsp;&nbsp; <input
					type="hidden" name="targetURL" value=""></td>
			</tr>
		</table>
	</form>
</body>
</html>