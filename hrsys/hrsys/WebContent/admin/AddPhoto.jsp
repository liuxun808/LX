<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>增加员工照片</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
	</head>

	<body>
		<form action="AddPhotoServlet?employee_id=100" method="post" enctype="multipart/form-data"
			name="form1">
			<table width="500" border="0" align="center" cellpadding="5"
				cellspacing="1" bgcolor="#CCCCCC">
				<tr>
					<td align="center" bgcolor="#FF9900">
						请选择要上传的员工照片（*.jpg 或者*.gif）
					</td>
				</tr>
				<tr>
					<td align="center" bgcolor="#FFFFFF">
						<input type="file" name="photo_path" size="40">
						<input type="submit" name="Submit" value="添加员工图片" onClick="location.href='PhotoViewServlet'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>