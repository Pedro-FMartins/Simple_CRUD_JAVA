/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Pedro
 */
public class ConsultarTodosClienteAction implements ICommand{
    
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response){
        ClienteDAO clidao = new ClienteDAO();
        List<Cliente> list = new ArrayList<Cliente>();

        try {
            list = clidao.consultadorTodos();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        request.setAttribute("list", list);
        return "resultadoconsultartodos.jsp";
    }
}
