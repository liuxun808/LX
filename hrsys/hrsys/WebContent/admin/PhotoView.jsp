<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
	<head>
		<title>员工图片</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>

	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center">
					<a href="${pageContext.request.contextPath }/AddImageServlet">添加100号员工照片</a>
					<a href="javascript:window.close()">关闭窗口</a>				</td>
			</tr>
		</table>

		
			<img src="${pageContext.request.contextPath }/upload/1267115960093727.jpg" />
			<br />
			<p>
				<a
					href="#">删除此图片</a>			</p>
		
			<img src="${pageContext.request.contextPath }/upload/126711587887562.jpg" />
			<br />
			<p>
				<a
					href="#">删除此图片</a>			</p>
		

	</body>
</html>