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
public class ConsultarPorIdClienteAction implements ICommand{
    
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("txtid"));

        Cliente cli = Cliente.getBuilder()
                .comId(id)
                .constroi();

        ClienteDAO clidao = new ClienteDAO();

        try {
            cli = clidao.consultarPorID(cli);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        request.setAttribute("cli", cli);
        return "resultadoconsultarporid.jsp";
    }
}
