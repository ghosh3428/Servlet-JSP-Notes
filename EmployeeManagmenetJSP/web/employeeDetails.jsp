<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>

        <div class="container mt-2">
 
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h1 class="display-4 fw-bold text-center">Employee Details</h1>
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
