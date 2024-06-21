package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Controller.ClienteCTRL;

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
    
    public Veiculopanel(MainView mainView) {
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
        
         buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instancia Veiculo Ctrl
                ClienteCTRL clienteCTRL = mainView.getClienteCTRL();
                // Define atributos
                String marca = textFieldMarca.getText();
                String modelo = textFieldModelo.getText();
                int ano = Integer.parseInt(textFieldAno.getText());
                String placa = textFieldPlaca.getText();
                // Instancia Veiculo com construtor
                Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
                // Envia para Controller
                clienteCTRL.registrarVeiculoCliente(veiculo);

            }
        });
    }
    
}
