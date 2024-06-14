package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientePanel extends JPanel {
    private MainView mainView;
    private JTable tableVeiculos;
    private JButton buttonAgendarRevisao;
    private JButton buttonConsultarHistorico;
    private JButton buttonVoltar;

    public ClientePanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelVeiculos = new JLabel("Veículos:");
        labelVeiculos.setBounds(10, 100, 120, 25);
        add(labelVeiculos);

        tableVeiculos = new JTable();
        JScrollPane scrollPaneVeiculos = new JScrollPane(tableVeiculos);
        scrollPaneVeiculos.setBounds(10, 130, 760, 200);
        add(scrollPaneVeiculos);

        buttonAgendarRevisao = new JButton("Agendar Revisão");
        buttonAgendarRevisao.setBounds(10, 340, 150, 25);
        add(buttonAgendarRevisao);

        buttonConsultarHistorico = new JButton("Consultar Histórico");
        buttonConsultarHistorico.setBounds(170, 340, 150, 25);
        add(buttonConsultarHistorico);
        
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 430, 150, 25);
        add(buttonVoltar);

        buttonVoltar.addActionListener(e -> mainView.showPanel("LoginPanel"));
    }

    public void addAgendarRevisaoListener(ActionListener listener) {
        buttonAgendarRevisao.addActionListener(listener);
    }

    public void addConsultarHistoricoListener(ActionListener listener) {
        buttonConsultarHistorico.addActionListener(listener);
    }


}