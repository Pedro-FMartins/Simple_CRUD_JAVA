<%-- 
    Document   : resultadoconsultartodos
    Created on : 20/03/2024, 21:27:52
    Author     : alunos
--%>

<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href ="style.css">
        <title>JSP Page</title>
        <style>
            form {
                overflow-x: auto;
            }
        </style>
    </head>
    <body>
        
        <h1> Consultar Todos os clientes </h1>
        <br>
        
        <h2><%
            List<Cliente> list = (List<Cliente>) request.getAttribute("list");
            
            if (list.size() > 0){
        %><table class="tabela">
            <th>ID</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>CPF</th>
            <th>Empresa</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>ID Compra</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>DELETAR </th>
            <th>EDITAR</th>
            <tr><%
                    for (Cliente cli : list){
                        %><td><%out.println(cli.getId());%><%
                        %><td><%out.println(cli.getNome());%><%
                        %><td><%out.println(cli.getSobrenome());%><%
                        %><td><%out.println(cli.getCPF());%><%
                        %><td><%out.println(cli.getEmpresa());%><%
                        %><td><%out.println(cli.getTelefone());%><%
                        %><td><%out.println(cli.getEndereco());%><%
                        %><td><%out.println(cli.getId_compra());%><%
                        %><td><%out.println(cli.getDescricao());%><%
                        %><td><%out.println(cli.getValor());%>
                        <td><a href="http://localhost:8080/TrabalhoPedro_7Sem_M2/Controller_Cliente?btnoperacao=Deletar&txtid=<%out.println(cli.getId());%>"><img src="imagens/lixeira.png" width="70px" height="50px"><a/>  
                        <td><a href="http://localhost:8080/TrabalhoPedro_7Sem_M2/Controller_Cliente?btnoperacao=Alterar&txtid=<%out.println(cli.getId());%>"><img src="imagens/edit.png" width="70px" height="50px"><a/>           
                        </tr><%
                    }
                %></table><%
            } else {
                out.println("Consulta Sem retorno");
            }%>
        </h2>
        <br><br>
        
        <form name="f1" action="Controller_Cliente" method="post">
            <input <input type="submit" name ="btnoperacao" value="Voltar">
        </form>
    </body>
</html>
