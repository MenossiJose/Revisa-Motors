package View;

import javax.swing.*;
import java.awt.event.ActionListener;

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
        labelNome.setBounds(10, 10, 100, 25);
        add(labelNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 10, 200, 25);
        add(textFieldNome);

        JLabel labelCPF = new JLabel("CPF:");
        labelCPF.setBounds(10, 50, 100, 25);
        add(labelCPF);

        textFieldCPF = new JTextField();
        textFieldCPF.setBounds(120, 50, 200, 25);
        add(textFieldCPF);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(10, 90, 100, 25);
        add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(120, 90, 200, 25);
        add(textFieldEmail);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(10, 130, 100, 25);
        add(labelSenha);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 130, 200, 25);
        add(passwordField);

        buttonRegistrar = new JButton("Registrar");
        buttonRegistrar.setBounds(10, 170, 150, 25);
        add(buttonRegistrar);

        buttonVoltar = new JButton("Voltar");
        buttonVoltar.setBounds(170, 170, 150, 25);
        add(buttonVoltar);

        buttonVoltar.addActionListener(e -> mainView.showPanel("LoginPanel"));
    }

    public void addRegistrarListener(ActionListener listener) {
        buttonRegistrar.addActionListener(listener);
    }

    public String getNome() {
        return textFieldNome.getText();
    }

    public String getCPF() {
        return textFieldCPF.getText();
    }

    public String getEmail() {
        return textFieldEmail.getText();
    }

    public String getSenha() {
        return new String(passwordField.getPassword());
    }
}

