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
                    <h1 class="display-4 bg-primary text-white text-center">Employee Details</h1>
                </div>
                <div class="card-body">

                    <div class="row">
                        <div  class="col-md-6 fs-3">Employee ID</div>
                        <div  class="col-md-6 fs-3">${id}</div>
                    </div>
                    <div class="row">
                        <div  class="col-md-6 fs-3 ">First Name</div>
                        <div  class="col-md-6 fs-3">${f_n}</div>
                    </div>
                    <div class="row">
                        <div  class="col-md-6 fs-3">Last Name</div>
                        <div  class="col-md-6 fs-3">${l_n}</div>
                    </div>
                    <div class="row">
                        <div  class="col-md-6 fs-3">Age</div>
                        <div  class="col-md-6 fs-3">${age}</div>
                    </div>
                    <div class="row">
                        <div  class="col-md-6 fs-3">Phone Number</div>
                        <div  class="col-md-6 fs-3">${phone}</div>
                    </div>
                    <div class="row">
                        <div  class="col-md-6 fs-3">Designation</div>
                        <div  class="col-md-6 fs-3">${desig}</div>
                    </div>
                    <div class="row">
                        <div  class="col-md-6 fs-3">Years of Experience</div>
                        <div  class="col-md-6 fs-3">${exp}</div>
                    </div>

                    <div class="row">
                        <div  class="col-md-6 fs-3">Salary</div>
                        <div  class="col-md-6 fs-3">${sal}</div>
                    </div>
            </div>
        </div>
    </body>
</html>
