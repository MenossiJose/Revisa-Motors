package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RevisaoPanel extends JPanel {
    private JTextField textFieldData;
    private JTextField textFieldHora;
    private JTextField textFieldOficina;
    private JTextField textFieldModeloVeiculo;
    private JTextArea textAreaDetalhesServico;
    private JButton buttonSalvar;
    private JButton buttonCancelar;

    public RevisaoPanel() {
        setLayout(null);

        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(10, 10, 100, 25);
        add(labelData);

        textFieldData = new JTextField();
        textFieldData.setBounds(120, 10, 200, 25);
        add(textFieldData);

        JLabel labelHora = new JLabel("Hora:");
        labelHora.setBounds(10, 50, 100, 25);
        add(labelHora);

        textFieldHora = new JTextField();
        textFieldHora.setBounds(120, 50, 200, 25);
        add(textFieldHora);
        
        //Precisa mudar para objeto
        JLabel labelOficina = new JLabel("Oficina:");
        labelOficina.setBounds(10, 90, 100, 25);
        add(labelOficina);

        textFieldOficina = new JTextField();
        textFieldOficina.setBounds(120, 90, 200, 25);
        add(textFieldOficina);
        
        //Precisa mudar para objeto
        JLabel labelModeloVeiculo = new JLabel("Veículo:");
        labelModeloVeiculo.setBounds(10, 130, 100, 25);
        add(labelModeloVeiculo);

        textFieldModeloVeiculo = new JTextField();
        textFieldModeloVeiculo.setBounds(120, 130, 200, 25);
        add(textFieldModeloVeiculo);

        JLabel labelDetalhesServico = new JLabel("Detalhes do Serviço:");
        labelDetalhesServico.setBounds(10, 290, 150, 25);
        add(labelDetalhesServico);

        textAreaDetalhesServico = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaDetalhesServico);
        scrollPane.setBounds(10, 320, 760, 150);
        add(scrollPane);

        buttonSalvar = new JButton("Salvar");
        buttonSalvar.setBounds(10, 480, 100, 25);
        add(buttonSalvar);

        buttonCancelar = new JButton("Cancelar");
        buttonCancelar.setBounds(120, 480, 100, 25);
        add(buttonCancelar);
    }

    public void addSalvarListener(ActionListener listener) {
        buttonSalvar.addActionListener(listener);
    }

    public void addCancelarListener(ActionListener listener) {
        buttonCancelar.addActionListener(listener);
    }

    public void setDetalhesRevisao(String data, String hora, String oficina,
                                   String modeloVeiculo,
                                   String detalhesServico) {
        textFieldData.setText(data);
        textFieldHora.setText(hora);
        textFieldOficina.setText(oficina);
        textFieldModeloVeiculo.setText(modeloVeiculo);
        textAreaDetalhesServico.setText(detalhesServico);
    }

    public String getDetalhesServico() {
        return textAreaDetalhesServico.getText();
    }
}
