package View;

import Controller.RevisaoCTRL;
import Model.Revisao;
import javax.swing.*;
import java.awt.event.ActionListener;

public class RevisaoPanel extends JPanel {
    private MainView mainView;
    public JTextField textFieldData;
    public JTextField textFieldHora;
    public JTextField textFieldOficina;
    public JTextField textFieldModeloVeiculo;
    public JTextArea textAreaDetalhesServico;
    private JButton buttonSalvar;
    private JButton buttonCancelar;
    private JButton buttonVoltar;
    
    private RevisaoCTRL revisaoCTRL;

    public RevisaoPanel(MainView mainView) {
        revisaoCTRL = mainView.getRevisaoCTRL();
        this.mainView = mainView;
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

        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(120, 480, 100, 25);
        add(buttonVoltar);
        
        buttonVoltar.addActionListener(e -> mainView.showPanel("ClientePanel"));
        buttonSalvar.addActionListener(e -> buttonSalvarActionPerformed(e));
        
        
    }

    public void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
       this.revisaoCTRL.registrarRevisao();
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

    public MainView getMainView() {
        return mainView;
    }
}

