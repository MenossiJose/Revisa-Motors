package View;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;

public class OficinaPanel extends JPanel {
    private MainView mainView;
    private JTable tableAgendamentos;
    private JTextArea textAreaDetalhesServico;
    private JButton buttonRegistrarServico;
    private JButton buttonEmitirOrdemServico;
    private JButton buttonLogout;

    public OficinaPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelAgendamentos = new JLabel("Agendamentos:");
        labelAgendamentos.setBounds(10, 10, 100, 25);
        add(labelAgendamentos);

        tableAgendamentos = new JTable(); // Deverá ser configurada para exibir agendamentos
        JScrollPane scrollPane = new JScrollPane(tableAgendamentos);
        scrollPane.setBounds(10, 40, 760, 200);
        add(scrollPane);

        JLabel labelDetalhesServico = new JLabel("Detalhes do Serviço:");
        labelDetalhesServico.setBounds(10, 250, 150, 25);
        add(labelDetalhesServico);

        textAreaDetalhesServico = new JTextArea();
        textAreaDetalhesServico.setBounds(10, 280, 760, 100);
        add(textAreaDetalhesServico);

        buttonRegistrarServico = new JButton("Registrar Serviço");
        buttonRegistrarServico.setBounds(10, 390, 150, 25);
        add(buttonRegistrarServico);

        buttonEmitirOrdemServico = new JButton("Emitir Ordem de Serviço");
        buttonEmitirOrdemServico.setBounds(170, 390, 200, 25);
        add(buttonEmitirOrdemServico);

        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(10, 430, 150, 25);
        add(buttonLogout);

        buttonLogout.addActionListener(e -> mainView.showPanel("LoginPanel"));
    }

    public void addRegistrarServicoListener(ActionListener listener) {
        buttonRegistrarServico.addActionListener(listener);
    }

    public void addEmitirOrdemServicoListener(ActionListener listener) {
        buttonEmitirOrdemServico.addActionListener(listener);
    }

    public String getDetalhesServico() {
        return textAreaDetalhesServico.getText();
    }

    public void setAgendamentos(Object[][] dados, String[] colunas) {
        tableAgendamentos.setModel(new DefaultTableModel(dados, colunas));
    }
}