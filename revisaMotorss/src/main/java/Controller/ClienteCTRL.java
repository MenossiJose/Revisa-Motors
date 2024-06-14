package Controller;
import View.RegistroClientePanel;
import Model.Cliente;

public class ClienteCTRL {
    
    public void registrarCliente(Cliente cliente) {
        // Aqui você pode inserir o cliente no banco de dados
        // Para este exemplo, vamos apenas imprimir os dados do cliente
        System.out.println("Cliente registrado: " + cliente.getNome());
        System.out.println(cliente.getCpf());
        System.out.println(cliente.getEmail());
        System.out.println(cliente.getSenha());

    }
    
}
