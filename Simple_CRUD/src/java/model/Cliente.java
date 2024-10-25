/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pedro
 */
public class Cliente {
    private int id;
    private String nome;
    private String sobrenome;
    private String CPF;
    private String empresa;
    private String telefone;
    private String endereco;
    private int id_compra;
    private String descricao;
    private double valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public static ClienteBuilder getBuilder(){
        return new ClienteBuilder();
    }
    
    public static class ClienteBuilder{
        
        private Cliente cli = new Cliente();
        
        public ClienteBuilder comId(int id){
            cli.id = id;
            return this;
        }
        
        public ClienteBuilder comNome(String nome){
            cli.nome = nome;
            return this;
        }
        
        public ClienteBuilder comSobrenome(String sobrenome){
            cli.sobrenome = sobrenome;
            return this;
        }
        
        public ClienteBuilder comCPF(String CPF){
            cli.CPF = CPF;
            return this;
        }
        
        public ClienteBuilder comEmpresa(String empresa){
            cli.empresa = empresa;
            return this;
        }
        
        public ClienteBuilder comTelefone(String telefone){
            cli.telefone = telefone;
            return this;
        }
        
        public ClienteBuilder comEndereco(String endereco){
            cli.endereco = endereco;
            return this;
        }
        
        public ClienteBuilder comId_compra(int id_compra){
            cli.id_compra = id_compra;
            return this;
        }
        
        public ClienteBuilder comDescricao(String descricao){
            cli.descricao = descricao;
            return this;
        }
        
        public ClienteBuilder comValor(double valor){
            cli.valor = valor;
            return this;
        }
        
        public Cliente constroi(){
            return cli;
        }
    }
}
