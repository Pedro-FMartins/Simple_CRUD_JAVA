/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import br.com.commandfactory.controller.ICommand;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
public class ControleFacadeWeb {
    
    public void acionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String paramAction = request.getParameter("btnoperacao");
            String nomeDaClasse = "br.com.commandfactory.controller."+ paramAction +"ClienteAction";
            Class classeAction = Class.forName(nomeDaClasse);
            ICommand commandAction = (ICommand) classeAction.newInstance();
            String pageDispatcher = commandAction.executar(request, response);
            request.getRequestDispatcher("/" + pageDispatcher).forward(request, response);
        } catch(Exception ex){
            System.out.println("Erro: "+ex.getMessage());
            request.setAttribute("erro", ex.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}
