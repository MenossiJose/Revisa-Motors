package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import Model.Cliente;
import Controller.ClienteCTRL;
import java.awt.event.ActionEvent;

public class RegistroClientePanel extends JPanel {
    private MainView mainView;
    private JTextField textFieldNome;
    private JTextField textFieldCPF;
    private JTextField textFieldEmail;
    private JPasswordField passwordField;
    private JButton buttonRegistrar;
    private JButton buttonVoltar;

    public RegistroClientePanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);
        
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(30, 10, 100, 25);
        add(labelNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 10, 200, 25);
        add(textFieldNome);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(30, 50, 100, 25);
        add(labelCPF);

        textFieldCPF = new JTextField();
        textFieldCPF.setBounds(120, 50, 200, 25);
        add(textFieldCPF);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 90, 100, 25);
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(120, 90, 200, 25);
        add(textFieldEmail);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(30, 130, 100, 25);
        add(labelSenha);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 130, 200, 25);
        add(passwordField);

        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(68, 170, 150, 25);
        add(buttonRegistrar);

        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(222, 170, 150, 25);
        add(buttonVoltar);

        buttonVoltar.addActionListener(e -> mainView.showPanel("LoginPanel"));
        
         buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Instancia Cliente Ctrl
                ClienteCTRL clienteCTRL = new ClienteCTRL();
                //Define atributos
                String nome = textFieldNome.getText();
                int cpf = Integer.parseInt(textFieldCPF.getText());
                String email = textFieldEmail.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                //Instancia Cliente com construtor
                Cliente cliente = new Cliente(nome, cpf, email, password);
                //Envia para Controller
                clienteCTRL.registrarCliente(cliente);
            }
        });
    }
    
}

