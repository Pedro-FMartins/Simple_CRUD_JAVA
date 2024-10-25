/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notifier_decorator;

import java.sql.SQLException;

/**
 *
 * @author alunos
 */
public class SMSDecorator extends BaseNotifierDecorator{
    
    public SMSDecorator(INotifier wrapped){
        super(wrapped); 
    }
    
    @Override
    public void send(String msg){
        super.send(msg);
        try{
            String telefone = clidao.getPhone_Dec(getId_Dec());
            System.out.println("Sending "+ msg +" by SMS to " + telefone);
            
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}
