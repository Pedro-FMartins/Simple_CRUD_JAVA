/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import notifier_decorator.INotifier;
import notifier_decorator.Notifier;
import notifier_decorator.SMSDecorator;
import notifier_decorator.TelegramDecorator;

/**
 *
 * @author Pedro
 */
public class DeletarClienteAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtid"));

        Cliente cli = Cliente.getBuilder()
                .comId(id)
                .constroi();

        ClienteDAO clidao = new ClienteDAO();
        String message = "";

        try {
            INotifier in = new SMSDecorator(new TelegramDecorator(new Notifier(cli.getId())));
            in.send("Dados do cliente excluídos em: " + Calendar.getInstance().getTime());          
            
            
            clidao.excluir(cli);
            message = "EXCLUÍDO COM SUCESSO";
        } catch (ClassNotFoundException | SQLException ex) {
            message = "EXCLUSÃO NÃO REALIZADO: " + ex.getMessage();
            System.out.println("Erro: " + ex.getMessage());
        }

        request.setAttribute("message", message);
        return "resultadodeletar.jsp";
    }
}
