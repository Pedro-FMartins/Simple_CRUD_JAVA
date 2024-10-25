/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller;

import dao.ClienteDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
/**
 *
 * @author Pedro
 */
public class CadastrarClienteAction implements ICommand{
    
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response){
        
        String nome = request.getParameter("txtnome");
        String sobrenome = request.getParameter("txtsobrenome");
        String CPF = request.getParameter("txtCPF");
        String empresa = request.getParameter("txtempresa");
        String telefone = request.getParameter("txttelefone");
        String endereco = request.getParameter("txtendereco");
        int id_compra = Integer.parseInt(request.getParameter("txtid_compra"));
        String descricao = request.getParameter("txtdescricao");
        Double valor = Double.valueOf(request.getParameter("txtvalor"));
        
        
        Cliente cli = Cliente.getBuilder()
                .comNome(nome)
                .comSobrenome(sobrenome)
                .comCPF(CPF)
                .comEmpresa(empresa)
                .comTelefone(telefone)
                .comEndereco(endereco)
                .comId_compra(id_compra)
                .comDescricao(descricao)
                .comValor(valor)
                .constroi();
        
        ClienteDAO clidao = new ClienteDAO();
                
        String message = "";

        try {
            clidao.cadastrar(cli);
            message = "CADASTRADO COM SUCESSO";
        } catch (ClassNotFoundException | SQLException ex) {
            message = "CADASTRO NÃO REALIZADO: " + ex.getMessage();
            System.out.println("Erro: " + ex.getMessage());
        }

        request.setAttribute("message", message);
        return "resultadocadastrar.jsp";
    }
}
