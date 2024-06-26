package Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private int cpf;
    private String email;
    private String senha;
    private Revisao revisoes;
    private List<Veiculo> veiculos;
    
    public Cliente (String nome, int cpf, String email, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.veiculos = new ArrayList<>();
    }
    
     public Cliente(String nome, int cpf, String email, String senha, Veiculo veiculo) {
        this(nome, cpf, email, senha);
        this.veiculos.add(veiculo);
    }
    
   /* public Cliente (String nome, int cpf, String email, String senha, Veiculo veiculos, Revisao revisoes){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.veiculos = veiculos;
        this.revisoes = revisoes;
    }*/
    
    public Cliente(){
        this.veiculos = new ArrayList<>(); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Revisao getRevisoes() {
        return revisoes;
    }

    public void setRevisoes(Revisao revisoes) {
        this.revisoes = revisoes;
    }
    
   
    
}
