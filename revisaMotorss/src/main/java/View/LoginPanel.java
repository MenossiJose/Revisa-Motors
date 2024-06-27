package View;

import javax.swing.*;
import java.awt.event.ActionListener;

import Controller.LoginCTRL;
import Controller.ClienteCTRL;
import Controller.OficinaCTRL;
import Controller.VeiculoCTRL;
import Model.Cliente;
import Model.Oficina;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPanel extends JPanel {
    private MainView mainView;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;
    private JButton buttonLoginCliente;
    private JButton buttonLoginOficina;
    private JButton buttonRegistroCliente;
    private JButton buttonRegistroOficina;
    
    private LoginCTRL controller;
    private OficinaCTRL ofController;
    private ClienteCTRL clController;
    

    public LoginPanel(MainView mainView) {
        controller = new LoginCTRL(this);
        ofController = new OficinaCTRL(controller);
        clController = new ClienteCTRL();
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
        buttonLoginCliente.setBounds(68, 130, 150, 25);
        add(buttonLoginCliente);

        buttonLoginOficina = new JButton("Login Oficina");
        buttonLoginOficina.setBounds(222, 130, 150, 25);
        add(buttonLoginOficina);

        buttonRegistroCliente = new JButton("Registro Cliente");
        buttonRegistroCliente.setBounds(68, 170, 150, 25); 
        add(buttonRegistroCliente);

        buttonRegistroOficina = new JButton("Registro Oficina");
        buttonRegistroOficina.setBounds(222, 170, 150, 25); 
        add(buttonRegistroOficina);
        
        buttonLoginCliente.addActionListener(e -> {
            try {
                buttonLoginClienteActionPerformed(e);
            } catch (SQLException ex) {
                Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        buttonLoginOficina.addActionListener(e -> buttonLoginOficinaActionPerformed(e));

        buttonRegistroCliente.addActionListener(e -> mainView.showPanel("RegistroClientePanel"));
        buttonRegistroOficina.addActionListener(e -> mainView.showPanel("RegistroOficinaPanel"));
    }
    
    private void buttonLoginClienteActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        System.out.println("Botão de login do cliente clicado");  // Log para depuração
        try {
            String cliente = textFieldUsuario.getText();
            String senha = new String(passwordField.getPassword());
            Cliente objcliente = new Cliente();
            objcliente.setNome(cliente);
            objcliente.setSenha(senha);

            ClienteCTRL objclientectrl = new ClienteCTRL();
            ResultSet rsclientectrl = objclientectrl.autenticacaoCliente(objcliente);

            if (rsclientectrl != null && rsclientectrl.next()) {
                System.out.println("Login bem-sucedido");  // Log para depuração
                this.mainView.showPanel("ClientePanel");
            } else {
                System.out.println("Login falhou");  // Log para depuração
                JOptionPane.showMessageDialog(null, "Erro: Email ou senha incorretos.");
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar login: " + erro.getMessage());  // Log para depuração
            JOptionPane.showMessageDialog(null, "Erro ao realizar login: " + erro.getMessage());
        }
    }
    
    private void buttonLoginOficinaActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Botão de login da oficina clicado");  // Log para depuração
        try {
            String oficina = textFieldUsuario.getText();
            String senha = new String(passwordField.getPassword());
            Oficina objoficina = new Oficina();
            objoficina.setNome(oficina);
            objoficina.setSenha(senha);

            OficinaCTRL objoficinactrl = new OficinaCTRL();
            ResultSet rsoficinactrl = objoficinactrl.autenticacaoOficina(objoficina);

            if (rsoficinactrl != null && rsoficinactrl.next()) {
                System.out.println("Login bem-sucedido");  // Log para depuração
                this.mainView.showPanel("OficinaPanel");
            } else {
                System.out.println("Login falhou");  // Log para depuração
                JOptionPane.showMessageDialog(null, "Erro: Email ou senha incorretos.");
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao realizar login: " + erro.getMessage());  // Log para depuração
            JOptionPane.showMessageDialog(null, "Erro ao realizar login: " + erro.getMessage());
        }
    }
    
    public JTextField getTextFieldUsuario() {
        return textFieldUsuario;
    }

    public void setTextFieldUsuario(JTextField textFieldUsuario) {
        this.textFieldUsuario = textFieldUsuario;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }
    
    public MainView getMainView() {
        return mainView;
    }
}
