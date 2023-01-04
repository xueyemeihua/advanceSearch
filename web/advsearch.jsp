<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2023/1/3
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高级搜索</title>
</head>
<body>
<div align="center">
    <form action="/advanceSearch/advsearch" method="post">
        员工姓名:<input name="ename"><br>
        工资:<input name="salary"><br>
        <input type="submit" value="搜索">
    </form>
    <table border="1px" cellpadding="0px" cellspacing="0px">
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>岗位</th>
            <th>工资</th>
            <th>领导编号</th>
            <th>奖金</th>
            <th>入职时间</th>
            <th>部门编号</th>
        </tr>
        <c:forEach var="emp" items="${emps}">
            <tr>
                <td>${emp.empno}</td>
                <td>${emp.ename}</td>
                <td>${emp.job}</td>
                <td>${emp.salary}</td>
                <td>${emp.mgr}</td>
                <td>${emp.bonus}</td>
                <td>${emp.hiredate}</td>
                <td>${emp.deptno}</td>
            </tr>
        </c:forEach>
    </table>
    <p style="color: red">${sEmpsError}</p>
    <a href="advsearch.jsp">返回</a>
</div>
</body>
</html>
