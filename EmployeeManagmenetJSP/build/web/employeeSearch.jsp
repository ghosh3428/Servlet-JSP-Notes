<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
    </head>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <body>
        <%@include file="nav.jsp" %>
        <div class="container">
            
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
            
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h1 class="display-4  fw-bold text-center">Employee Search</h1>
                </div>
                <div class="card-body">
                    <form method="post" action="searchEmployeeServlet">
                        <div class="form-group row">
                            <label for="e_id" class="col-md-4 fs-3 text-center">Employee ID</label>
                            <div class="col-md-8">
                                <input type="text" name="e_id" id="e_id" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group mt-3">
                            <div class="text-center">
                                <input type="submit" value="Search Employee" class="btn btn-lg btn-success"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
