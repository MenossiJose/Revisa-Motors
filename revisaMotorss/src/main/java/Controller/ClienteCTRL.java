package Controller;
import View.RegistroClientePanel;
import Model.Cliente;
import Model.Veiculo;

public class ClienteCTRL {
    
     private Cliente cliente;
    
    public void registrarCliente(Cliente cliente) {
        // Aqui você pode inserir o cliente no banco de dados
        // Para este exemplo, vamos apenas imprimir os dados do cliente
        System.out.println("Cliente registrado: " + cliente.getNome());
        System.out.println(cliente.getCpf());
        System.out.println(cliente.getEmail());
        System.out.println(cliente.getSenha());
        this.cliente = cliente;

    }
    
    public void  registrarVeiculoCliente(Veiculo veiculo) {
        cliente.adicionarVeiculo(veiculo);
        System.out.println("Veículo adicionado ao cliente: " + cliente.getNome());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Placa: " + veiculo.getPlaca());
    }
    
    // Getter para o cliente
    public Cliente getCliente() {
        return cliente;
    }

    // Setter para o cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
