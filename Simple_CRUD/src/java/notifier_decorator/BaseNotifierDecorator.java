/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notifier_decorator;
import dao.ClienteDAO;

/**
 *
 * @author alunos
 */
public abstract class BaseNotifierDecorator implements INotifier{
    
    private final INotifier wrapped;
    protected final ClienteDAO clidao;
    
    BaseNotifierDecorator(INotifier wrapped){
        this.wrapped = wrapped;
        clidao = new ClienteDAO();
    }
    
    @Override
    public void send(String msg){
        wrapped.send(msg);
    }
    
    @Override
    public int getId_Dec(){
        return wrapped.getId_Dec();
    }
}
