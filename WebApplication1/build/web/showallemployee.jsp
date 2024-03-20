<%-- 
    Document   : showallemployee
    Created on : 20 Mar, 2024, 8:26:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="nav.jsp" %>



        <div class="card">
            <div class="card-header">
                <h1 class="display-4 bg-primary text-white text-center">Employee Salary Details</h1>
            </div>
            <div class="card-body">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th>
                                Employee ID
                            </th>
                            <th>
                                First Name
                            </th>
                            <th>
                                Last Name
                            </th>
                            <th>
                                Age
                            </th>
                            <th>
                                Phone Number
                            </th>
                            <th>
                                Designation
                            </th>
                            <th>
                                Year of Experience
                            </th>
                            <th>
                                Basic Salary
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employeelist}"  var="employee" >

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
                                    ${employee.phoneNumber}
                                </td>
                                <td>
                                    ${employee.designation}
                                </td>
                                <td>
                                    ${employee.yearOfExperience}
                                </td>
                                <td>
                                    ${employee.basic}
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>



    </body>
</html>
