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
                    <h1 class="display-4 bg-primary text-white text-center"> Add Employee Form</h1>
                </div>
                <div class="card-body">
                    <form method="post" action="addEmployeeServlet">
                        <div class="form-group row">
                            <label for="e_fn" class="col-md-5 fs-3">First Name</label>
                            <div class="col-md-7">
                                <input type="text" name="e_fn" id="e_fn" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="e_ln" class="col-md-5 fs-3">Last Name</label>
                            <div class="col-md-7">
                                <input type="text" name="e_ln" id="e_ln" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="e_age" class="col-md-5 fs-3">Age</label>
                            <div class="col-md-7">
                                <input type="number" name="e_age" id="e_age" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="e_phone" class="col-md-5 fs-3">Phone</label>
                            <div class="col-md-7">
                                <input type="text" name="e_phone" id="e_phone" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="e_desig" class="col-md-5 fs-3">Designation</label>
                            <div class="col-md-7">
                                <input type="text" name="e_desig" id="e_desig" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="e_exp" class="col-md-5 fs-3">Years Of Experience</label>
                            <div class="col-md-7">
                                <input type="number" name="e_exp" id="e_exp" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="e_sal" class="col-md-5 fs-3 ">Basic Salary</label>
                            <div class="col-md-7">
                                <input type="text" name="e_sal" id="e_sal" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group mt-3">
                            <div class="text-center">
                                <input type="submit" value="Add Employee" class="btn btn-lg btn-success"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
