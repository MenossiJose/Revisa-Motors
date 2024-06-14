package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import Model.Cliente;

public class RegistroClientePanel extends JPanel {
    private Cliente cliente;
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
        String strNome = textFieldNome.getText();
        cliente.setNome(strNome);

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
    }

    public void addRegistrarListener(ActionListener listener) {
        buttonRegistrar.addActionListener(listener);
        //ClienteCTRL vai pegar os dados aqui e inserir no BD
    }
    
}

