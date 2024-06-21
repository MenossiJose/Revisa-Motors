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
    private JButton buttonOficinaPanel;
    private JButton buttonClientePanel;
    

    public LoginPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(30, 10, 100, 25);
        add(labelUsuario);

        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(120, 10, 200, 25);
        add(textFieldUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(30, 50, 100, 25);
        add(labelSenha);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 50, 200, 25);
        add(passwordField);

        buttonLoginCliente = new JButton("Login Cliente");
        buttonLoginCliente.setBounds(68, 90, 150, 25);
        add(buttonLoginCliente);

        buttonLoginOficina = new JButton("Login Oficina");
        buttonLoginOficina.setBounds(222, 90, 150, 25);
        add(buttonLoginOficina);

        buttonRegistroCliente = new JButton("Registro Cliente");
        buttonRegistroCliente.setBounds(68, 130, 150, 25);
        add(buttonRegistroCliente);

        buttonRegistroOficina = new JButton("Registro Oficina");
        buttonRegistroOficina.setBounds(222, 130, 150, 25);
        add(buttonRegistroOficina);
        
        buttonOficinaPanel = new JButton("Oficina Panel");
        buttonOficinaPanel.setBounds(222, 180, 150, 25);
        add(buttonOficinaPanel);
        
        buttonClientePanel = new JButton("Cliente Panel");
        buttonClientePanel.setBounds(68, 180, 150, 25);
        add(buttonClientePanel);
        

        buttonOficinaPanel.addActionListener(e -> mainView.showPanel("OficinaPanel"));
        buttonClientePanel.addActionListener(e -> mainView.showPanel("ClientePanel"));
        buttonRegistroCliente.addActionListener(e -> mainView.showPanel("RegistroClientePanel"));
        buttonRegistroOficina.addActionListener(e -> mainView.showPanel("RegistroOficinaPanel"));
    }

    
}
