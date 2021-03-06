<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="styles/common.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
	<div class="page-content">
		<div class="content-nav">人员管理 > 部门管理</div>
		<form>
			<fieldset>
				<legend>添加部门</legend>
				部门名称: <input type="text" id="departmentname" maxlength="20" /> <input
					type="submit" class="clickbutton" value="添加" />
			</fieldset>
		</form>
		<table class="listtable">
			<caption>所有部门:</caption>
			<tr class="listheader">
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
			<tr>
				<td>1</td>
				<td>技术部</td>
				<td><a class="clickbutton" href="#">编辑</a> <a
					class="clickbutton" href="#">删除</a></td>
			</tr>
			<tr>
				<td>2</td>
				<td><input type="text" value="销售部" /></td>
				<td><a class="clickbutton" href="#">编辑</a> <a
					class="clickbutton" href="#">取消</a> <a class="clickbutton" href="#">删除</a>
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td>市场部</td>
				<td><a class="clickbutton" href="#">编辑</a> <a
					class="clickbutton" href="#">删除</a></td>
			</tr>
			<tr>
				<td>4</td>
				<td>行政部</td>
				<td><a class="clickbutton" href="#">编辑</a> <a
					class="clickbutton" href="#">删除</a></td>
			</tr>
		</table>
	</div>
</body>
</html>