package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.ClienteCTRL;
import Controller.VeiculoCTRL;

import Model.Cliente;
import Model.Veiculo;

public class Veiculopanel extends JPanel {
    private MainView mainView;
    private JTextField textFieldMarca;
    private JTextField textFieldModelo;
    private JTextField textFieldAno;
    private JTextField textFieldPlaca;
    private JButton buttonRegistrar;
    private JButton buttonVoltar;
    
    private Veiculo veiculo;
    private VeiculoCTRL veiculoCTRL;
    
    public Veiculopanel(MainView mainView) {
        veiculoCTRL = new VeiculoCTRL(this);
        this.mainView = mainView;
        setLayout(null);

        JLabel labelMarca = new JLabel("Marca:");
        labelMarca.setBounds(30, 10, 100, 25);
        add(labelMarca);

        textFieldMarca = new JTextField();
        textFieldMarca.setBounds(150, 10, 200, 25);
        add(textFieldMarca);

        JLabel labelModelo = new JLabel("Modelo:");
        labelModelo.setBounds(30, 50, 100, 25);
        add(labelModelo);

        textFieldModelo = new JTextField();
        textFieldModelo.setBounds(150, 50, 200, 25);
        add(textFieldModelo);

        JLabel labelAno = new JLabel("Ano:");
        labelAno.setBounds(30, 90, 100, 25);
        add(labelAno);

        textFieldAno = new JTextField();
        textFieldAno.setBounds(150, 90, 200, 25);
        add(textFieldAno);

        JLabel labelPlaca = new JLabel("Placa:");
        labelPlaca.setBounds(30, 130, 100, 25);
        add(labelPlaca);

        textFieldPlaca = new JTextField();
        textFieldPlaca.setBounds(150, 130, 200, 25);
        add(textFieldPlaca);

        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(150, 170, 100, 25);
        add(buttonRegistrar);

        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(260, 170, 100, 25);
        add(buttonVoltar);
        
        buttonVoltar.addActionListener(e -> mainView.showPanel("ClientePanel")); 
        buttonRegistrar.addActionListener(e -> buttonRegistrarActionPerformed(e));

        
    }
    
     private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt){
        Veiculo veiculo = new Veiculo();
        String marca = getTextFieldMarca().getText();
        String modelo = getTextFieldModelo().getText();
        int ano = Integer.parseInt(getTextFieldAno().getText());
        String placa = getTextFieldPlaca().getText();
        veiculo.setModelo(modelo);
        veiculo.setAno(ano);
        veiculo.setMarca(marca);
        veiculo.setPlaca(placa);
        this.veiculoCTRL.registrarVeiculoCliente(veiculo);
        limparCampos();
    }
     
     public void limparCampos(){
        textFieldMarca.setText("");
        textFieldModelo.setText("");
        textFieldAno.setText("");
        textFieldPlaca.setText("");
    }

    public JTextField getTextFieldMarca() {
        return textFieldMarca;
    }

    public void setTextFieldMarca(JTextField textFieldMarca) {
        this.textFieldMarca = textFieldMarca;
    }

    public JTextField getTextFieldModelo() {
        return textFieldModelo;
    }

    public void setTextFieldModelo(JTextField textFieldModelo) {
        this.textFieldModelo = textFieldModelo;
    }

    public JTextField getTextFieldAno() {
        return textFieldAno;
    }

    public void setTextFieldAno(JTextField textFieldAno) {
        this.textFieldAno = textFieldAno;
    }

    public JTextField getTextFieldPlaca() {
        return textFieldPlaca;
    }

    public void setTextFieldPlaca(JTextField textFieldPlaca) {
        this.textFieldPlaca = textFieldPlaca;
    }

    public MainView getMainView() {
        return mainView;
    }
    
    
    
}
