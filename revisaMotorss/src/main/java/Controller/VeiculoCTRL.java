package Controller;
import Model.Veiculo;

public class VeiculoCTRL {
    
    public void registrarVeiculo(Veiculo veiculo) {
        // Aqui você pode inserir o cliente no banco de dados
        // Para este exemplo, vamos apenas imprimir os dados do cliente
        System.out.println("Veiculo registrado: " + veiculo.getMarca());
        System.out.println(veiculo.getModelo());
        System.out.println(veiculo.getAno());
        System.out.println(veiculo.getPlaca());
    }
}
