package Controller;

import View.RegistroClientePanel;

import Model.Cliente;
import Model.Veiculo;

import Controller.LoginCTRL;

public class ClienteCTRL {
    
    private Cliente cliente;
    private LoginCTRL loginCTRL;
    
    public ClienteCTRL(){
        
    }
    
    public ClienteCTRL(LoginCTRL loginCTRL){
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
        cliente = loginCTRL.entrarNoSistemaCliente();
        System.out.println(cliente);
        
        
    }
    
   /*
    public void  registrarVeiculoCliente(Veiculo veiculo) {
        cliente.adicionarVeiculo(veiculo);
        System.out.println("Veículo adicionado ao cliente: " + cliente.getNome());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Placa: " + veiculo.getPlaca());
    }*/
    
   
}
