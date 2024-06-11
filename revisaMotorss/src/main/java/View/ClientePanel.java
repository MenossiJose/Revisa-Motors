package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ClientePanel extends JPanel {
    private MainView mainView;
    private JTextField textFieldNomeVeiculo;
    private JTextField textFieldMarcaVeiculo;
    private JTextField textFieldAnoVeiculo;
    private JTextField textFieldPlacaVeiculo;
    private JTextField textFieldData;
    private JTextField textFieldHora;
    private JComboBox<String> comboBoxOficina;
    private JButton buttonAgendar;
    private JButton buttonConsultarHistorico;
    private JButton buttonLogout;

    public ClientePanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelNomeVeiculo = new JLabel("Nome Veículo:");
        labelNomeVeiculo.setBounds(10, 10, 100, 25);
        add(labelNomeVeiculo);

        textFieldNomeVeiculo = new JTextField();
        textFieldNomeVeiculo.setBounds(120, 10, 200, 25);
        add(textFieldNomeVeiculo);

        JLabel labelMarcaVeiculo = new JLabel("Marca Veículo:");
        labelMarcaVeiculo.setBounds(10, 50, 100, 25);
        add(labelMarcaVeiculo);

        textFieldMarcaVeiculo = new JTextField();
        textFieldMarcaVeiculo.setBounds(120, 50, 200, 25);
        add(textFieldMarcaVeiculo);

        JLabel labelAnoVeiculo = new JLabel("Ano Veículo:");
        labelAnoVeiculo.setBounds(10, 90, 100, 25);
        add(labelAnoVeiculo);

        textFieldAnoVeiculo = new JTextField();
        textFieldAnoVeiculo.setBounds(120, 90, 200, 25);
        add(textFieldAnoVeiculo);

        JLabel labelPlacaVeiculo = new JLabel("Placa Veículo:");
        labelPlacaVeiculo.setBounds(10, 130, 100, 25);
        add(labelPlacaVeiculo);

        textFieldPlacaVeiculo = new JTextField();
        textFieldPlacaVeiculo.setBounds(120, 130, 200, 25);
        add(textFieldPlacaVeiculo);

        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(10, 170, 100, 25);
        add(labelData);

        textFieldData = new JTextField();
        textFieldData.setBounds(120, 170, 200, 25);
        add(textFieldData);

        JLabel labelHora = new JLabel("Hora:");
        labelHora.setBounds(10, 210, 100, 25);
        add(labelHora);

        textFieldHora = new JTextField();
        textFieldHora.setBounds(120, 210, 200, 25);
        add(textFieldHora);

        JLabel labelOficina = new JLabel("Oficina:");
        labelOficina.setBounds(10, 250, 100, 25);
        add(labelOficina);

        comboBoxOficina = new JComboBox<>();
        comboBoxOficina.setBounds(120, 250, 200, 25);
        add(comboBoxOficina);

        buttonAgendar = new JButton("Agendar Revisão");
        buttonAgendar.setBounds(10, 290, 150, 25);
        add(buttonAgendar);

        buttonConsultarHistorico = new JButton("Consultar Histórico");
        buttonConsultarHistorico.setBounds(170, 290, 150, 25);
        add(buttonConsultarHistorico);

        buttonLogout = new JButton("Logout");
        buttonLogout.setBounds(10, 330, 150, 25);
        add(buttonLogout);

        buttonLogout.addActionListener(e -> mainView.showPanel("LoginPanel"));
    }

    public void addAgendarListener(ActionListener listener) {
        buttonAgendar.addActionListener(listener);
    }

    public void addConsultarHistoricoListener(ActionListener listener) {
        buttonConsultarHistorico.addActionListener(listener);
    }

    public String getNomeVeiculo() {
        return textFieldNomeVeiculo.getText();
    }

    public String getMarcaVeiculo() {
        return textFieldMarcaVeiculo.getText();
    }

    public String getAnoVeiculo() {
        return textFieldAnoVeiculo.getText();
    }

    public String getPlacaVeiculo() {
        return textFieldPlacaVeiculo.getText();
    }

    public String getData() {
        return textFieldData.getText();
    }

    public String getHora() {
        return textFieldHora.getText();
    }

    public String getOficinaSelecionada() {
        return (String) comboBoxOficina.getSelectedItem();
    }

    public void setOficinas(String[] oficinas) {
        comboBoxOficina.setModel(new DefaultComboBoxModel<>(oficinas));
    }
}