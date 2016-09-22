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
		<table>
			<caption>用户列表</caption>
			<thead>
				<tr>
					<th>编号</th>
					<th>用户名</th>
					<th>地址</th>
					<th>性别</th>
					<th>年龄</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty users }">
					<c:forEach var="user" items="${users }" varStatus="status">
						<tr>
							<td>${status.index+1 }</td>
							<td>${user.userName }</td>
							<td>${user.address }</td>
							<td>${user.sex eq '0'?'女':'男' }</td>
							<td>${user.age }</td>
							<td>
								<a href="delete?id=${user.id }">删除</a>
								<a href="edit/${user.id }">修改</a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>