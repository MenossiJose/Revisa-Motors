package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;

import Model.Cliente;
import Model.Veiculo;

public class ClientePanel extends JPanel {
    private MainView mainView;
    private JList<String> listVeiculos;
    private DefaultListModel<String> listModelVeiculos;
    private JButton buttonAdicionarVeiculo;
    private JButton buttonAgendarRevisao;
    private JButton buttonConsultarHistorico;
    private JButton buttonVoltar;

    public ClientePanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);
        
        buttonAdicionarVeiculo = new JButton("Adicionar Veículo");
        buttonAdicionarVeiculo.setBounds(10, 40, 150, 25);
        add(buttonAdicionarVeiculo);

        JLabel labelVeiculos = new JLabel("Veículos:");
        labelVeiculos.setBounds(10, 100, 120, 25);
        add(labelVeiculos);

        
        //JLIST
        listModelVeiculos = new DefaultListModel<>();
        listVeiculos = new JList<>(listModelVeiculos);
        JScrollPane scrollPane = new JScrollPane(listVeiculos);
        scrollPane.setBounds(10, 130, 300, 200);
        add(scrollPane);
    

        buttonAgendarRevisao = new JButton("Agendar Revisão");
        buttonAgendarRevisao.setBounds(10, 340, 150, 25);
        add(buttonAgendarRevisao);

        buttonConsultarHistorico = new JButton("Consultar Histórico");
        buttonConsultarHistorico.setBounds(170, 340, 150, 25);
        add(buttonConsultarHistorico);
        
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 380, 150, 25);
        add(buttonVoltar);

        buttonVoltar.addActionListener(e -> mainView.showPanel("LoginPanel"));
        buttonAdicionarVeiculo.addActionListener(e -> mainView.showPanel("VeiculoPanel"));
        buttonAgendarRevisao.addActionListener(e -> mainView.showPanel("RevisaoPanel"));
        buttonConsultarHistorico.addActionListener(e -> mainView.showPanel("HistoricoPanel"));
    }
    public void atualizarListaVeiculos(List<Veiculo> veiculos) {
        listModelVeiculos.clear();
        for (Veiculo veiculo : veiculos) {
            listModelVeiculos.addElement(veiculo.getMarca() + " " + veiculo.getModelo() + " " +veiculo.getPlaca());
        }
    } 
    
    
    
    


}