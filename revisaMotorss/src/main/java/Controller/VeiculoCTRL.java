package Controller;

import View.Veiculopanel;
import View.ClientePanel;

import Model.Cliente;
import Model.Veiculo;


public class VeiculoCTRL {
    private Veiculopanel view;
    private Veiculo veiculo;
    private Cliente cliente;
    
    public VeiculoCTRL(){
        
    }
    
    public VeiculoCTRL(Veiculopanel view){
        this.view = view;
    }
    

    public void registrarVeiculoCliente(Veiculo veiculo) {
        this.veiculo = veiculo;
        this.cliente = view.getMainView().getCliente();
        colocarVeiculoNaTabela(veiculo);
    }
    
    public void colocarVeiculoNaTabela(Veiculo veiculo){
        if (veiculo == null) {
            System.out.println("Erro: Cliente não inicializado.");
            return;
        }else{
        cliente.adicionarVeiculo(veiculo);
        System.out.println(cliente.getVeiculos());
        System.out.println(cliente.getNome());}
        ClientePanel clientePanel = view.getMainView().getClientePanel();
        clientePanel.atualizarListaVeiculos(cliente.getVeiculos());
        
    }
   
    
}
