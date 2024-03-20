<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <link href="bootstrap.css" rel="stylesheet" />

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
                    <h1 class="display-4 bg-primary text-white text-center">Employee Search</h1>
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
