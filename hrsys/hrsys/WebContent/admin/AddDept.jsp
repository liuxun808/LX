<%@page import="hrsys.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>增加新部门</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<!-- 页面头部 -->
<%@include file="Top.jsp" %>
	<!-- 页面内容 -->
	<table border="0" width="950" height="350" bgcolor="#ffffff"
		align="center">
		<tr>
			<td align="center" valign="top">

	<h2>${msg }</h2>
			<form name="form1" method="post" action="${pageContext.request.contextPath }/AddDeptServlet">
					<table width="500" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
								请填写新部门信息</td>
						</tr>
						<tr>
							<td width="120" height="24" bgcolor="#FFFFFF">部门编号</td>
							<td width="357" height="24" bgcolor="#FFFFFF"><input
								name="department_id" type="text" id="department_id"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">部门名称</td>
							<td height="24" bgcolor="#FFFFFF"><input
								name="department_name" type="text" id="department_name">
								*</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">部门地址</td>
							<td height="24" bgcolor="#FFFFFF"><input
								name="location_name" type="text" id="location_name"> *</td>
						</tr>
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
								<input type="submit" name="Submit" value="提交" > 
								<input type="button" name="Submit2" value="取消" onclick="history.back();">
							</td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
	</table>

	<!-- 页面底部 -->

	<table width="950" border="0" align="center" cellpadding="0"
		cellspacing="0" bgcolor="#FFFFFF">
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td align="center">©版权所有</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>