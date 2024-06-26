package Model;

import java.util.ArrayList;
import java.util.List;

public class Oficina {
    private String nome;
    private int cnpj;
    private String endereco;
    private String senha;
    private List<Revisao> revisoes;
    
    public Oficina (String nome, int cnpj, String endereco, String senha){
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.senha = senha;
        this.revisoes = new ArrayList<>();
    }
    
    public Oficina(String nome, int cnpj, String endereco, String senha, Revisao revisao){
        this(nome, cnpj, endereco, senha);
        this.revisoes.add(revisao);
    }
    
    public Oficina(){
        this.revisoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    public void adicionarRevisao(Revisao revisao) {
        this.revisoes.add(revisao);
    }
}
