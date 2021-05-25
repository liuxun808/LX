<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>增加员工</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/inc/Calendar1.inc"></script>

		<script type="text/javascript">
			//显示对应职务的最低和最高工资
			function showSal() {
				//获得职务表单元素对象
				var job_id = document.form1.job_id;
				//显示最低工资和最高工资
				if (job_id.value != "") {
					document.form1.min_salary.value = eval("document.form1.min"+job_id.value+".value");
					document.form1.max_salary.value = eval("document.form1.max"+job_id.value+".value");
				} else {
					document.form1.min_salary.value = "";
					document.form1.max_salary.value = "";
				}
			}
		</script>
		<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$.ajax({
					type:"get",
					url:$('#url').val()+"/SelectJobDeptAjaxServlet",
					dataType:'json',
					success:function(data){
						$('select[name=job_id]').empty();
						var optionNode = '<option value="">请选择职务</option>';
						$('select[name=job_id]').append(optionNode)
						$.each(data.jobs,function(i,job){
							optionNode = '<option value="'+job.jobno+'">'+job.jname+'</option>';
							$('select[name=job_id]').append(optionNode);
						});
						
						$('select[name=department_id]').empty();
						var optionNode1 = '<option value="">请选择部门</option>';
						$('select[name=department_id]').append(optionNode1);
						$.each(data.depts, function(i,dept) {
							 optionNode1 = '<option value="'+dept.deptno+'">'+dept.dname+'</option>';
							$('select[name=department_id]').append(optionNode1);
						});
					},
					error:function(XMLHttpRequest){
						alert(XMLHttpRequest.status)
					},
					async:true 
				});
			});
		</script>
		<script>
			$(function(){
				$('select[name=job_id]').change(function(){
					$.ajax({
						type:"get",
						url:$('#url').val()+"/SelectByJobAjaxServlet",
						data:{job_id:$('#job_id').val()},
						dataType:'json',
						success:function(data){
							
							$('#min_salary').empty();
							$('#min_salary').val()=data.minSal;
							$('#max_salary').empty();
							$('#max_salary').val()=data.maxSal;
						},
						error:function(XMLHttpRequest){
						alert(XMLHttpRequest.status)
					},
					
						async:true
					});
					
				})
			})
			
		</script>
	</head>

	<body>
		<!-- 页面头部 -->
	<%@include file="Top.jsp" %>
		<!-- 页面内容 -->
		<input type="hidden" id="url" value="${pageContext.request.contextPath  }">
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<form name="form1" method="post" action="${pageContext.request.contextPath }/AddEmpServlet">
						<table width="500" border="0" cellpadding="5" cellspacing="1"
							bgcolor="#CCCCCC">
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFCC00">
									请填写以下员工信息
								</td>
							</tr>
							<tr>
								<td width="120" height="24" bgcolor="#FFFFFF">
									员工姓名
								</td>
								<td width="357" height="24" bgcolor="#FFFFFF">
									<input name="empname" type="text" id="empname">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									邮箱地址
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="email" type="text" id="email">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									电话号码
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="phone_number" type="text" id="phone_number">
									例如123.456.789
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									入职日期
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="hire_date" type="text" id="hire_date"  onfocus="calendar()">
									yyyy-mm-dd
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									职务
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<select name="job_id" id="job_id" onchange="showSal()">
										<%-- <option value="">
											请选择职务
										</option>

										<!-- 循环输出所有的职务option -->
										<c:forEach items="${jobs }" var="job">
											<option value="${job.jobno }">${job.jname }</option>
											
										</c:forEach> --%>
							
									</select>

									<!-- 隐藏表单元素：存储每种职务的最低和最高工资 -->
									<%-- <c:forEach items="${jobs }" var="job">
										
											
										</c:forEach> --%>
									
										
									<input type="hidden" name="min${job.jobno }" value="${job.minSal }"/>
									<input type="hidden" name="max${job.jobno }" value="${job.maxSal }"/>		
									工资范围
									<input name="min_salary" type="text" id="min_salary" size="10"
										readonly>
									~
									<input name="max_salary" type="text" id="max_salary" size="10"
										readonly>
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									工资
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<input name="salary" type="text" id="salary">
									*
								</td>
							</tr>
							<tr>
								<td height="24" bgcolor="#FFFFFF">
									部门
								</td>
								<td height="24" bgcolor="#FFFFFF">
									<select name="department_id" id="department_id">
										<%-- <option value="">
											请选择部门
										</option>

										<!-- 循环输出所有的部门的option -->
										<c:forEach items="${depts }" var="dept">
											<option value="${dept.deptno }" >${dept.dname }</option>
										</c:forEach> --%>
										
									</select>
								</td>
							</tr>
							<tr>
								<td height="24" colspan="2" align="center" bgcolor="#FFFFFF">
									<input type="submit" name="Submit" value="提交" >
									<input type="button" name="Submit2" value="取消"
										onclick="history.back()">
								</td>
							</tr>
						</table>
					</form>
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