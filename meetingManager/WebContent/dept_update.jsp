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
		<div class="content-nav">部门修改</div>
		<font color="red">${msg}</font>
		<form action="UpdateDeptServlet" >
		<input name="deptId" value="${param.id}" type="hidden">
			<fieldset>
				<legend>部门信息</legend>
				<table class="formtable" style="width:50%">
					<tr>
						<td>部门id:</td>
						<td>${param.id}</td>
					</tr>
					<tr>
						<td>部门名字:</td>
						<td><input id="new" name="deptname" type="text" value="${param.name}"/></td>
					</tr>
					<tr>
						<td colspan="2" class="command"><input type="submit"
							value="修改" class="clickbutton" /> </td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

</body>
</html>