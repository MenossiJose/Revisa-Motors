package View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private MainView mainView;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JButton buttonLoginCliente;
    private JButton buttonLoginOficina;
    private JButton buttonRegistroCliente;
    private JButton buttonRegistroOficina;

    public LoginPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(10, 10, 100, 25);
        add(labelUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(120, 10, 200, 25);
        add(textFieldUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(10, 50, 100, 25);
        add(labelSenha);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 50, 200, 25);
        add(passwordField);

        buttonLoginCliente = new JButton("Login Cliente");
        buttonLoginCliente.setBounds(10, 90, 150, 25);
        add(buttonLoginCliente);

        buttonLoginOficina = new JButton("Login Oficina");
        buttonLoginOficina.setBounds(170, 90, 150, 25);
        add(buttonLoginOficina);

        buttonRegistroCliente = new JButton("Registro Cliente");
        buttonRegistroCliente.setBounds(10, 130, 150, 25);
        add(buttonRegistroCliente);

        buttonRegistroOficina = new JButton("Registro Oficina");
        buttonRegistroOficina.setBounds(170, 130, 150, 25);
        add(buttonRegistroOficina);

        buttonRegistroCliente.addActionListener(e -> mainView.showPanel("RegistroClientePanel"));
        buttonRegistroOficina.addActionListener(e -> mainView.showPanel("RegistroOficinaPanel"));
    }

    public void addLoginClienteListener(ActionListener listener) {
        buttonLoginCliente.addActionListener(listener);
    }

    public void addLoginOficinaListener(ActionListener listener) {
        buttonLoginOficina.addActionListener(listener);
    }

    public String getUsuario() {
        return textFieldUsuario.getText();
    }

    public String getSenha() {
        return new String(passwordField.getPassword());
    }
}
