

<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    
    <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="nav.jsp" %>
        <p style="color:white ; background-color:green">
            <% 
                int x = 10;
                int y = 20;
                out.print(x+y);
            %>
            <br/>
            <%=new Date() %>
            
        </p>
        <h2>
            ${10+20}
        </h2>
        <h1>Hello World!</h1>
    </body>
</html>
