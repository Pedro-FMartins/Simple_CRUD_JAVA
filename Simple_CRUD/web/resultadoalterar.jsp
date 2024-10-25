<%-- 
    Document   : resultadoalterar
    Created on : 6 de abr. de 2024, 15:50:29
    Author     : Pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href ="style.css">
    </head>
    <body>
        <h1>Resultado Alteração</h1>
        <form name="f1" action="Controller_Cliente" method="post">
        <h2>
        <% 
            String message = (String) request.getAttribute("message");
            out.println(message);
        %>
        </h2>
        <br><br>
        
        
            <input <input type="submit" name ="btnoperacao" value="Voltar">
        </form>
    </body>
</html>
