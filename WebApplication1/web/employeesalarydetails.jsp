<%-- 
    Document   : employeesalarydetails
    Created on : 20 Mar, 2024, 8:06:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="nav.jsp" %>

        <div class="container">
            <h1 class="bg-success text-white text-center">
                ${success}
            </h1>
            <h1 class="bg-danger text-white text-center">
                ${error} 
            </h1>
            <div class="card">
                <div class="card-header">
                    <h1 class="display-4 bg-primary text-white text-center">Employee Salary Details</h1>
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
