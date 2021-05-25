<%@page import="hrsys.vo.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="hrsys.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<title>职务数据</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	//****************-删除确认***************
	function del(job_id) {
		//弹出确认框
		var flag = window.confirm("你确定要删除" + job_id + "号职务吗?");

		//如果单击确定，则执行DelJobsServlet，并且传入职务编号
		if (flag) {
			alert("删除成功");
			location.href = "${pageContext.request.contextPath }/DelJobsServlet?job_id="+job_id;
		}
	}
</script>
</head>

<body>
	<!-- 页面头部 -->
	<%@include file="Top.jsp" %>
	<!-- 页面内容 -->
	<table border="0" width="950" height="350" bgcolor="#ffffff"
		align="center">
		<tr>
			<td align="center" valign="top">
				<table width="90%" border="0" cellpadding="5" cellspacing="1"
					bgcolor="#CCCCCC">
					<tr>
						<th width="16%" height="24" align="center" bgcolor="#FFCC00">
							职务编号</th>
						<th width="21%" height="24" align="center" bgcolor="#FFCC00">
							职务名称</th>
						<th width="23%" height="24" align="center" bgcolor="#FFCC00">
							最低工资</th>
						<th width="24%" height="24" align="center" bgcolor="#FFCC00">
							最高工资</th>
						<th width="16%" height="24" align="center" bgcolor="#FFCC00">
							操作</th>
					</tr>

					<!-- 显示职务数据 -->

					<%
					if(request.getAttribute("jobs")!=null){
						List<Jobs> jobs = (List<Jobs>)request.getAttribute("jobs");
						for(Jobs job : jobs){
							%>
							<tr>
								<td height="24" bgcolor="#FFFFFF"><%=job.getJobno() %></td>
								<td height="24" bgcolor="#FFFFFF"><%=job.getJname() %></td>
								<td height="24" bgcolor="#FFFFFF"><%=job.getMinSal() %></td>
								<td height="24" bgcolor="#FFFFFF"><%=job.getMaxSal() %></td>
								<td height="24" bgcolor="#FFFFFF"><a
									href="${pageContext.request.contextPath }/SelectByJobno?job_id=<%=job.getJobno() %>">修改</a> 
									<a href= "#" onclick="del(<%=job.getJobno() %>)">删除</a>
								</td>
							</tr>
							<%
						}
					}
					%>
				</table>
				<p>
					<a href="${pageContext.request.contextPath }/admin/AddJobs.jsp">增加新职务种类</a>
				</p>
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