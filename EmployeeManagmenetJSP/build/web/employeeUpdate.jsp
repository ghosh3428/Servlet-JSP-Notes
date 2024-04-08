<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <sql:setDataSource
            driver="org.h2.Driver"
            password=""
            url="jdbc:h2:tcp://localhost/~/test"
            user="sa"
            var="con" />

        <sql:query dataSource="${con}" var="resultset">
            select * from employee where id = ? ;
            <sql:param value="${param.id}" />
        </sql:query>


        <%@include file="nav.jsp" %>

        <c:forEach items="${resultset.rows}" var="employee" >
            <div class="container mt-2">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h1 class="display-4 text-center fw-bold"> Add Employee Form</h1>
                    </div>
                    <div class="card-body">
                        <form method="post" action="updateServlet">
                            <div class="form-group row">
                                <label for="e_fn" class="col-md-5 fs-3">First Name</label>
                                <div class="col-md-7">
                                    <input type="text" name="e_fn" id="e_fn" class="form-control" value="${employee.firstname}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="e_ln" class="col-md-5 fs-3">Last Name</label>
                                <div class="col-md-7">
                                    <input type="text" name="e_ln" id="e_ln" class="form-control" value="${employee.lastname}"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="e_age" class="col-md-5 fs-3">Age</label>
                                <div class="col-md-7">
                                    <input type="number" name="e_age" id="e_age" class="form-control" value="${employee.age}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="e_phone" class="col-md-5 fs-3">Phone</label>
                                <div class="col-md-7">
                                    <input type="text" name="e_phone" id="e_phone" class="form-control" value="${employee.phone}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="e_desig" class="col-md-5 fs-3">Designation</label>
                                <div class="col-md-7">
                                    <input type="text" name="e_desig" id="e_desig" class="form-control" value="${employee.designation}"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="e_exp" class="col-md-5 fs-3">Years Of Experience</label>
                                <div class="col-md-7">
                                    <input type="number" name="e_exp" id="e_exp" class="form-control" value="${employee.experience}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="e_sal" class="col-md-5 fs-3 ">Basic Salary</label>
                                <div class="col-md-7">
                                    <input type="text" name="e_sal" id="e_sal" class="form-control" value="${employee.salary}" />
                                </div>
                            </div>
                            <div class="form-group mt-3">
                                <div class="text-center">
                                    <input type="hidden" name="e_id"  value="${employee.id}" />
                                    <input type="submit" value="Update Employee" class="btn btn-lg btn-success"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
