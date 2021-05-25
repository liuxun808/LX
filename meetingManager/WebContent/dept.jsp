<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/common.css"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
</head>
<body>
 <div class="page-content">
                <div class="content-nav">
                    人员管理 > 部门管理
                </div>
                <font color="red">${msg}</font>
                <form action = "AddDeptServlet">
                    <fieldset>
                        <legend>添加部门</legend>
                        部门名称:
                        <input type="text" name="departmentname" maxlength="20"/>
                        <input type="submit" class="clickbutton" value="添加"/>
                    </fieldset>
                </form>
                <table class="listtable">
                    <caption>所有部门:</caption>
                    <tr class="listheader">
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="dept" items="${list}">
                    	<tr>
	                        <td>${dept.deptId}</td>
	                        <td>${dept.deptName}</td>
	                        <td>
	                            <a class="clickbutton" href="dept_update.jsp?id=${dept.deptId}&name=${dept.deptName}">编辑</a>
	                            <a class="clickbutton" href="DeleteDeptServlet?deptId=${dept.deptId}">删除</a>
	                        </td>
                    	</tr>
                    </c:forEach>
                </table>
            </div>
</body>
</html>