<%-- 
    Document   : employeesalarydetails
    Created on : 20 Mar, 2024, 8:06:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib 
    uri="http://java.sun.com/jsp/jstl/core"
    prefix="c"%>

<%@taglib 
    uri="http://java.sun.com/jsp/jstl/sql"
    prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource 
            driver="org.h2.Driver"
            password=""
            url="jdbc:h2:tcp://localhost/~/test"
            user="sa"
            var="con" />

        <sql:query 
            dataSource="${con}" 
            var="employeelist">

            select * from employee where id = ?;
            <sql:param value="${param.id}" />
        </sql:query>

        <c:forEach items="${employeelist.rows}"  var="employee" >

            <c:set var="basic" value="${employee.salary}" />
            <c:set var="hra" value="${basic * 35 / 100}" />
            <c:set var="da" value="${basic * 70 / 100}" />
            <c:set var="ta" value="${basic * 20 / 100}" />
            <c:set var="pf" value="${basic * 13 / 100}" />
            <c:set var="net" value="${basic + da + ta + hra - pf}" />
        </c:forEach>

        <%@include file="nav.jsp" %>

        <div class="container mt-2">
            <div class="card ">
                <div class="card-header bg-primary text-white">
                    <h1 class="display-4 fw-bold text-center">Employee Salary Details</h1>
                </div>
                <div class="card-body">
                    <table class="table table-dark">
                        <tbody>
                            <tr>
                                <th class="fs-3">
                                    Basic Salary
                                </th>
                                <td class="fs-3">
                                    &#x20B9; ${basic}
                                </td>
                            </tr>
                            <tr>
                                <th class="fs-3">
                                    HRA
                                </th>
                                <td class="fs-3">
                                    &#x20B9; ${hra}
                                </td>
                            </tr>
                            <tr>
                                <th class="fs-3">
                                    DA
                                </th>
                                <td class="fs-3">
                                    &#x20B9; ${da}
                                </td>
                            </tr>
                            <tr>
                                <th class="fs-3">
                                    TA
                                </th>
                                <td class="fs-3">
                                    &#x20B9; ${ta}
                                </td>
                            </tr>
                            <tr>
                                <th class="fs-3">
                                    PF
                                </th>
                                <td class="fs-3">
                                    &#x20B9; ${pf} 
                                </td>
                            </tr>
                            <tr>
                                <th class="fs-3">
                                    Net Salary
                                </th>
                                <td class="fs-3">
                                    &#x20B9; ${net}
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>

            </div>
        </div>

    </body>
</html>
