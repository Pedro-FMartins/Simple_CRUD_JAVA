/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.commandfactory.controller;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.Calendar;
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
public class EfetivarAlteracaoClienteAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("txtid"));
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
                .comId(id)
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
            
            INotifier in = new TelegramDecorator(new SMSDecorator(new Notifier(cli.getId())));
            in.send("Dados do cliente alterados em: " + Calendar.getInstance().getTime());
            
            clidao.alterar(cli);
            /*
            String[] checks = request.getParameterValues("check");
            for (String ch : checks) {
                if (ch.equals("WhatsApp")){
                    
                }
                
                System.out.println("Tipo Notificação: " + ch);
            }
            */
            
            
            message = "ALTERADO COM SUCESSO";
        } catch (ClassNotFoundException | SQLException ex) {
            message = "ALTERAÇÃO NÃO REALIZADA: " + ex.getMessage();
            System.out.println("Erro: " + ex.getMessage());
        }
        request.setAttribute("message", message);
        return "resultadoalterar.jsp";
    }
}
