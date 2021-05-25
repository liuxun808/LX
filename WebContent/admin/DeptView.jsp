<%@page import="hrsys.vo.Dept"%>
<%@page import="java.util.List"%>
<%@page import="hrsys.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<title>部门数据</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	//****************-删除确认***************
	function del(department_id) {
		//弹出确认框
		var flag = window.confirm("你确定要删除" + department_id + "号部门吗?");

		//如果单击确定，则执行DelDeptServlet，并且传入部门编号
		if (flag) {
			alert("删除成功");
			location.href = "DelectDeptServlet?department_id="+ department_id;
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
						<th width="17%" bgcolor="#FFCC00">部门编号</th>
						<th width="25%" bgcolor="#FFCC00">部门名称</th>
						<th width="37%" bgcolor="#FFCC00">部门地址</th>
						<th width="21%" bgcolor="#FFCC00">操作</th>
					</tr>

					<!-- 循环输出部门记录 -->


					<%
						if (request.getAttribute("depts") != null) {
							List<Dept> depts = (List<Dept>) request.getAttribute("depts");
							for (Dept dept : depts) {
					%>
					<tr>
						<td bgcolor="#FFFFFF"><%=dept.getDeptno()%></td>
						<td bgcolor="#FFFFFF"><%=dept.getDname()%></td>
						<td bgcolor="#FFFFFF"><%=dept.getLoc()%></td>
						<td bgcolor="#FFFFFF">
						<a href="SelectByDeptnoServlet?department_id=<%=dept.getDeptno()%>" >修改</a>
							<a href="#" onclick="del(<%=dept.getDeptno()%>)">删除</a></td>
					</tr>
					<%
						}
						}
					%>

				</table>
				<p>
					<a href="${pageContext.request.contextPath }/admin/AddDept.jsp">增加新部门</a>
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