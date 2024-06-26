package View;

import Model.Revisao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HistoricoPanel extends JPanel {
    private MainView mainView;
    private JTable tableHistorico;
    private JButton buttonVoltar;
    private DefaultTableModel tableModel;

    public HistoricoPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        // Configurar a tabela
        String[] columnNames = {"Data", "Hora", "Oficina", "Veículo", "Detalhes do Serviço"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableHistorico = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableHistorico);
        scrollPane.setBounds(10, 10, 460, 200);
        add(scrollPane);

        // Configurar o botão Voltar
        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(10, 220, 100, 25);
        add(buttonVoltar);

        buttonVoltar.addActionListener(e -> mainView.showPanel("ClientePanel"));
    }

    public void adicionarRevisao(Revisao revisao) {
        tableModel.addRow(new Object[]{
            revisao.getData(),
            revisao.getHoras(),
            revisao.getOficina(),
            revisao.getVeiculo(),
            revisao.getServico()
        });
    }
}
