package Controller;

import Model.Cliente;
import Model.Oficina;
import Model.Revisao;
import View.OficinaPanel;
import View.RevisaoPanel;

public class RevisaoCTRL {
    private RevisaoPanel view;
    private Cliente cliente;
    private Oficina oficina;
    
    public RevisaoCTRL(){
        
    }

    public void setController(RevisaoPanel view){
        this.view = view;
    }
    
    //Registrar a Revisao no BD na parte da oficina e manda o cliente junto para ela
    public void registrarRevisao(){
        Revisao revisao = new Revisao();
        this.cliente = view.getMainView().getCliente();
        this.oficina = view.getMainView().getOficina();
        
        String data = view.textFieldData.getText();
        String hora = view.textFieldHora.getText();
        String oficinaNome = view.textFieldOficina.getText();
        String modeloVeiculo = view.textFieldModeloVeiculo.getText();
        String detalhesServico = view.textAreaDetalhesServico.getText();
    
        if(oficina.getNome() != oficinaNome){
            System.out.println("Oficina Invalida");
        }
        revisao.setData(data);
        revisao.setHoras(hora);
        revisao.setOficina(oficina.getNome());
        revisao.setCliente(cliente.getNome());
        revisao.setVeiculo(modeloVeiculo);
        revisao.setServico(detalhesServico);
        
        System.out.println(revisao.getCliente());
        
        //Atualizar Tabela
        oficina.adicionarRevisao(revisao);
        OficinaPanel oficinaPanel = view.getMainView().getOficinaPanel();
        oficinaPanel.atualizarListaRevisoes(oficina.getRevisoes());
    }
    


    
}
