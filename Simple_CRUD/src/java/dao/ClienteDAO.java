/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import notifier_decorator.INotifier;
import notifier_decorator.Notifier;
import util.FabricaConexao;

/**
 *
 * @author Pedro
 */

public class ClienteDAO {
    
    public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {

        //1
        Connection conexao = FabricaConexao.getConexao();
        //2
        String sql = "INSERT INTO cliente (nome, sobrenome, CPF, empresa, telefone, endereco, id_compra, descricao, valor) VALUES (?,?,?,?,?,?,?,?,?);";
        //3
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getSobrenome());
        pstmt.setString(3, cliente.getCPF());
        pstmt.setString(4, cliente.getEmpresa());
        pstmt.setString(5, cliente.getTelefone());
        pstmt.setString(6, cliente.getEndereco());
        pstmt.setInt(7, cliente.getId_compra());
        pstmt.setString(8, cliente.getDescricao());
        pstmt.setDouble(9, cliente.getValor());
        pstmt.execute();
        //4
        conexao.close();
}
    
    public void excluir(Cliente cliente) throws ClassNotFoundException, SQLException {

        //1
        Connection conexao = FabricaConexao.getConexao();
        //2
        String sql = "DELETE FROM cliente where id = ?";
        //3
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, cliente.getId());
        pstmt.execute();
        //4
        conexao.close(); 
    }
    
    public void alterar(Cliente cliente) throws ClassNotFoundException, SQLException {
         
        Connection conexao = FabricaConexao.getConexao();
        String sql = "UPDATE cliente set nome = ?, sobrenome = ?, CPF = ?, empresa = ?, telefone = ?, endereco = ?, id_compra = ?, descricao = ?, valor = ? where id = ?;";
         
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        
        pstmt.setString(1, cliente.getNome());
        pstmt.setString(2, cliente.getSobrenome());
        pstmt.setString(3, cliente.getCPF());
        pstmt.setString(4, cliente.getEmpresa());
        pstmt.setString(5, cliente.getTelefone());
        pstmt.setString(6, cliente.getEndereco());
        pstmt.setInt(7, cliente.getId_compra());
        pstmt.setString(8, cliente.getDescricao());
        pstmt.setDouble(9, cliente.getValor());
        pstmt.setInt(10, cliente.getId());
        
        pstmt.execute();
        
        conexao.close();
    }
    
    public List<Cliente> consultadorTodos() throws ClassNotFoundException, SQLException {
        Connection conexao = FabricaConexao.getConexao();
        
        List<Cliente> lista_cli = new ArrayList<>(); 
        String sql = "select * from cliente";
        
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        ResultSet resultado = pstmt.executeQuery();
        while(resultado.next()){
            Cliente cli = new Cliente();
            cli.setId(resultado.getInt("id"));
            cli.setNome(resultado.getString("nome"));
            cli.setSobrenome(resultado.getString("sobrenome"));
            cli.setCPF(resultado.getString("CPF"));
            cli.setEmpresa(resultado.getString("empresa"));
            cli.setTelefone(resultado.getString("telefone"));
            cli.setEndereco(resultado.getString("endereco"));
            cli.setId_compra(resultado.getInt("id_compra"));
            cli.setDescricao(resultado.getString("descricao"));
            cli.setValor(resultado.getDouble("valor"));
            
            lista_cli.add(cli);
        }
        
        return lista_cli;
    }
    
    public Cliente consultarPorID(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection conexao = FabricaConexao.getConexao();
        
        String sql = "SELECT * from cliente where id = ?";
        
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, cliente.getId());
        
        ResultSet resultado = pstmt.executeQuery();
        
        Cliente cli = new Cliente();
        
        if(resultado.next()){
            cli.setId(resultado.getInt("id"));
            cli.setNome(resultado.getString("nome"));
            cli.setSobrenome(resultado.getString("sobrenome"));
            cli.setCPF(resultado.getString("CPF"));
            cli.setEmpresa(resultado.getString("empresa"));
            cli.setTelefone(resultado.getString("telefone"));
            cli.setEndereco(resultado.getString("endereco"));
            cli.setId_compra(resultado.getInt("id_compra"));
            cli.setDescricao(resultado.getString("descricao"));
            cli.setValor(resultado.getDouble("valor"));
        }
        
        return cli;
    }
    
    public String getPhone_Dec(int id) throws ClassNotFoundException, SQLException{
        Connection conexao = FabricaConexao.getConexao();
        
        String sql = "SELECT telefone from cliente where id = ?";
        
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        Cliente cli = new Cliente();
        ResultSet resultado = pstmt.executeQuery();
        
        if (resultado.next()){
            cli.setTelefone(resultado.getString("telefone"));
        }
        String telefone = cli.getTelefone();
        return telefone;
    }
}
