<%@page import="hrsys.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>

	<body>
		<!-- 页面头部 -->
	<%@include file="Top.jsp" %>
		<!-- 页面内容 -->
		<table border="0" width="950" height="350" bgcolor="#ffffff" align="center">
			<tr>
				<td align="center">
					您已经登陆到XXX人力资源管理系统，请使用
				</td>
			</tr>
		</table>

		<!-- 页面底部 -->
		
<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
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