<%@page import="hrsys.vo.Admin"%>
<%@page import="hrsys.vo.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
	<head>
		<title>员工数据</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript">
			//****************-删除确认***************
			function del(employee_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + employee_id + "号员工吗?");
				//如果单击确定，则执行DelEmpServlet，并且传入员工编号
				if (flag) {
					alert("删除成功");
					location.href = "DelEmpServlet?employee_id="+employee_id;
				}
			}
		</script>
		<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript">
			$(fu)
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
					<table width="98%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<%
						if(request.getAttribute("emps")!=null){
							List<Emp> emps = (List<Emp>)request.getAttribute("emps");
							for(Emp emp : emps){
								%>
								<tr>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getEmpno() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getEname() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getEmail() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getPhone() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getHire() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getJobs().getJname()%>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getSal()%>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<%=emp.getDept().getDname() %>
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<a href="SelectByEmpno?empno=<%=emp.getEmpno() %>">修改</a>
									<a href="#" onclick="del(<%=emp.getEmpno() %>)">删除</a>
									<a href="../SelectByEmpno" target="_blank">照片</a>								</td>
							</tr>
							
						
						<%
							}
						}
						%>	
						
					</table>

					<!-- 分页显示用界面 -->
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="24" align="center">
								共3条数据，每页显示9条，
								共1页，当前是第1页
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								<a href="?pagenum=1">首页</a>
								<a href="?pagenum=0">上页</a>
								<a href="?pagenum=2">下页</a>
								<a href="?pagenum=1">末页</a>
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								
									
									
										<font color="red"><b>1</b>
										</font>
									
								
							</td>
						</tr>
					</table>
						
					<p>
						<a href="${pageContext.request.contextPath }/admin/AddEmp.jsp">增加新员工</a>					</p>
				</td>
			</tr>
		</table>

		<!-- 页面底部 -->
		<input type="hidden" id="url" value="${pageContext.request.contextPath }">
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