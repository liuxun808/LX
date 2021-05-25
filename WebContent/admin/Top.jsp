<%@page import="hrsys.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<body>
		<!-- 页面头部 -->
		


<table width="950" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td height="80" bgcolor="#FFFFFF">
			<img src="${pageContext.request.contextPath }/img/bannal.jpg" width="950"
				height="80">
		</td>
	</tr>
	<tr>
		<td height="24" align="right" bgcolor="#FFFFFF">
			<a href="${pageContext.request.contextPath }/admin/Main.jsp">首页</a>
			<a href="${pageContext.request.contextPath }/DeptViewServlet">部门查询</a>
			<a href="${pageContext.request.contextPath }/JobsViewServlet">职务查询</a>
			<a href="${pageContext.request.contextPath }/EmpViewServlet">员工查询</a>			
			<a href="${pageContext.request.contextPath }/admin/logout.jsp">退出登陆</a>		</td>
	</tr>
	<tr>
		<td height="24" align="right" bgcolor="#0099CC">
				当前用户：${admin.adminName } 身份：${admin.adminLevel==1?'管理员':'操作员' }
		</td>
	</tr>
</table>

</body>
</html>