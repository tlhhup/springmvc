<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<div align="center">
		<form action="../save" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${user.id }">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userName" value="${user.userName }"/></td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input type="text" name="address" value="${user.address }"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td>
						<select name="sex">
							<option value="0" ${user.sex eq '0'?'selected':'' }>女</option>
							<option value="1" ${user.sex eq '1'?'selected':'' }>男</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" value="${user.age }"/></td>
				</tr>
				<tr>
					<td>头像：</td>
					<td><input type="file" name="headPic" value="${user.photo }"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<img alt="" height="100px" width="100px" src="${pageContext.request.contextPath }/resources/upload/${user.photo}">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="修改">&nbsp;&nbsp;
						<input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>