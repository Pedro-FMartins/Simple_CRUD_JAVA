<%-- 
    Document   : resultadodeletar
    Created on : 15/03/2024, 21:23:23
    Author     : ptoledo
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
        
        <h1>Resultado Exclusão</h1>
        <form name="f1" action="Controller_Cliente" method="post">
        <h2>
        <% 
            String message = (String) request.getAttribute("message");
            out.println(message);
        %>
        </h2>
        <br>
        <br>
        
        
            <input type="submit" name ="btnoperacao" value="Voltar">
        </form>
    </body>
</html>
