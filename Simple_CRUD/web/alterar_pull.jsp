<%-- 
    Document   : resultadoalterar
    Created on : 20/03/2024, 20:14:52
    Author     : alunos
--%>

<%@page import="model.Cliente"%>
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

        <%
            Cliente cli = (Cliente) request.getAttribute("cli");
        %>
        
        <form name="f1" action="Controller_Cliente" method="post">
            <h2>
                ID: <input type="text" name ="txtid" value="<%out.print(cli.getId());%>" readonly>
                Nome: <input type="text" name ="txtnome" value="<%out.print(cli.getNome());%>">
                Sobrenome: <input type="text" name ="txtsobrenome" value="<%out.print(cli.getSobrenome());%>">
                CPF: <input type="text" name ="txtCPF" value="<%out.print(cli.getCPF());%>">
                Empresa: <input type="text" name="txtempresa" value="<%out.print(cli.getEmpresa());%>">
                Telefone: <input type="text" name ="txttelefone" value="<%out.print(cli.getTelefone());%>">
                Endereço: <input type="text" name ="txtendereco" value="<%out.print(cli.getEndereco());%>">
                Id Compra: <input type="text" name="txtid_compra" value="<%out.print(cli.getId_compra());%>">
                Descricao: <input type="text" name="txtdescricao" value="<%out.print(cli.getDescricao());%>">
                Valor: <input type="text" name="txtvalor" value="<%out.print(cli.getValor());%>">
            </h2>
        <br>
        <!--  Funcionalidade futura: Implementar escolha de notificação.
        <div class="checkbox-container">
            <input type="checkbox" name="check" value="sms">
            <label for="sms">SMS</label>
            <input type="checkbox" name="check" value="telegram">
            <label for="telegram">Telegram</label>
            <input type="checkbox" name="check" value="whatsapp">
            <label for="whatsapp">Whatsapp</label>
            <input type="submit" name ="btnoperacao" value="EfetivarAlteracao">
            <input type="submit" name ="btnoperacao" value="Voltar">
        </div>
        -->
        </form>
    </body>
</html>



