<%@page import="hrsys.vo.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="hrsys.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>修改职务</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<!-- 页面头部 -->
<%@include file="Top.jsp" %>
	<!-- 页面内容 -->
	<%
	if(request.getAttribute("jobs")!=null){
		Jobs jobs = (Jobs)request.getAttribute("jobs");
		%>
	<table border="0" width="950" height="350" bgcolor="#ffffff"
		align="center">
		<tr>
			<td align="center" valign="top">
				<form method="post" action="${pageContext.request.contextPath }/UpdateJobsServlet">
					<table width="500" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
								请修改职务类型信息</td>
						</tr>
						<tr>
							<td width="130" height="24" bgcolor="#FFFFFF">职务编号</td>
							<td width="347" height="24" bgcolor="#FFFFFF"><input
								name="job_id" type="text" id="job_id" readonly="readonly"
								value="<%=jobs.getJobno() %>"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">职务名称</td>
							<td height="24" bgcolor="#FFFFFF"><input name="job_title"
								type="text" id="job_title" value="<%=jobs.getJname() %>"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">最低工资</td>
							<td height="24" bgcolor="#FFFFFF"><input name="min_salary"
								type="text" id="min_salary" value="<%=jobs.getMinSal()%>"> *</td>
						</tr>
						<tr>
							<td height="24" bgcolor="#FFFFFF">最高工资</td>
							<td height="24" bgcolor="#FFFFFF"><input name="max_salary"
								type="text" id="max_salary" value="<%=jobs.getMaxSal()%>"> *</td>
						</tr>
						<tr>
							<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
								<input type="submit" name="Submit" value="更新"
								onClick="alert('修改职务成功')">
								<input type="button" name="Submit2" value="取消"
								onclick="history.back()">
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<%
	}
	%>
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