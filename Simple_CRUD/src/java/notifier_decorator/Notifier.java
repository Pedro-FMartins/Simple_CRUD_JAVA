/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notifier_decorator;
import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author alunos
 */
public class Notifier implements INotifier{
    
    private final int id;
    private final ClienteDAO clidao;
    
    public Notifier(int id){
        this.id = id;
        clidao = new ClienteDAO();
    }
    
    @Override
    public void send(String msg){
        try{
            String telefone = clidao.getPhone_Dec(id);
            System.out.println("Sending "+ msg +" by WhatsApp to " + telefone);
            
        }catch(SQLException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public int getId_Dec(){
        return id;
    }
}
