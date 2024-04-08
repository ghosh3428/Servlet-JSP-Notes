<%-- 
    Document   : showallemployee
    Created on : 20 Mar, 2024, 8:26:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
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

            select * from employee;
        </sql:query>

        <%@include file="nav.jsp" %>

        <c:if test="${not empty success}">
            <div class="container row mt-2">
                <div class="alert alert-success alert-dismissible  fs-3 offset-md-2 col-md-8" role="alert">
                    ${success}
                    <button type="button" class="btn-close text-end" data-bs-dismiss="alert"
                            aria-label="Close">

                    </button>
                </div>
            </div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="container row mt-2">
                <div class="alert alert-danger alert-dismissible  fs-3 offset-md-2 col-md-8" role="alert">
                    ${error}
                    <button type="button" class="btn-close text-end" data-bs-dismiss="alert"
                            aria-label="Close">
                    </button>
                </div>
            </div>
        </c:if>
        <div class="card mt-2">
            <div class="card-header bg-primary text-white">
                <h1 class="display-4  fw-bold text-center">Employee Salary Details</h1>
            </div>
            <div class="card-body">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th width="8%">
                                Employee ID
                            </th>
                            <th width="8%">
                                First Name
                            </th>
                            <th width="8%">
                                Last Name
                            </th >
                            <th width="8%">
                                Age
                            </th>
                            <th width="8%">
                                Phone Number
                            </th>
                            <th width="17%">
                                Designation
                            </th>
                            <th width="8%">
                                Year of Experience
                            </th>
                            <th width="8%">
                                Basic Salary
                            </th>
                            <th width="27%">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employeelist.rows}"  var="employee" >

                            <tr>
                                <td>
                                    ${employee.id}
                                </td>
                                <td>
                                    ${employee.firstName}
                                </td>
                                <td>
                                    ${employee.lastName}
                                </td>
                                <td>
                                    ${employee.age}
                                </td>
                                <td>
                                    ${employee.phone}
                                </td>
                                <td>
                                    ${employee.designation}
                                </td>
                                <td>
                                    ${employee.Experience}
                                </td>
                                <td>
                                    ${employee.salary}
                                </td>
                                <td>
                                    <a href="employeeUpdate.jsp?id=${employee.id}" class="btn btn-warning btn-sm">Update</a> | 
                                    <a href="deleteServlet?e_id=${employee.id}" class="btn btn-danger btn-sm">Delete</a> |
                                    <a href="salarydetails.jsp?id=${employee.id}" class="btn btn-success btn-sm">Salary</a>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </body>
</html>
