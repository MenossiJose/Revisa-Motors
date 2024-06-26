package Controller;

import View.RegistroClientePanel;
import View.Veiculopanel;
import View.ClientePanel;

import Model.Cliente;
import Model.Veiculo;

import Controller.LoginCTRL;
import Controller.VeiculoCTRL;

public class ClienteCTRL {
    private Cliente cliente;
    private LoginCTRL loginCTRL;

   
    //private VeiculoCTRL veiculoCTRL;
    
    //Construtor na MainView para fz registro
    public ClienteCTRL(){
        
    }
    
    //Construtor no LoginPanel para o login
    public ClienteCTRL(LoginCTRL loginCTRL) {
        this.loginCTRL = loginCTRL;
    }
  
    //Função apenas para criar e inserir o cliente no BD
    public void registrarCliente(Cliente cliente) {
        // Aqui você pode inserir o cliente no banco de dados
        // Para este exemplo, vamos apenas imprimir os dados do cliente
        System.out.println("Cliente registrado: " + cliente.getNome());
        System.out.println(cliente.getCpf());
        System.out.println(cliente.getEmail());
        System.out.println(cliente.getSenha());
    }


    //Função para pegar o Cliente do Login
    //Todo o resto de manipulação tem que usar o cliente do login
    public void puxarCliente(){
        //Agora da pra puxar o cliente la da MainView entao ta safe
        this.cliente = loginCTRL.entrarNoSistemaCliente();
        System.out.println(getCliente().getNome());

    }

    public Cliente getCliente() {
        return cliente;
    }
    
    

   
}
