package View;

import javax.swing.*;
import java.awt.event.ActionListener;

import Controller.LoginCTRL;
import Controller.ClienteCTRL;
import Controller.OficinaCTRL;
import Controller.VeiculoCTRL;

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
    
    private LoginCTRL controller;
    private OficinaCTRL ofController;
    private ClienteCTRL clController;
    

    public LoginPanel(MainView mainView) {
        controller = new LoginCTRL(this);
        ofController = new OficinaCTRL(controller);
        clController = new ClienteCTRL(controller);
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
        
        buttonLoginCliente.addActionListener(e -> buttonLoginClienteActionPerformed(e));
        buttonLoginOficina.addActionListener(e -> buttonLoginOficinaActionPerformed(e));

        buttonOficinaPanel.addActionListener(e -> mainView.showPanel("OficinaPanel"));
        buttonClientePanel.addActionListener(e -> mainView.showPanel("ClientePanel"));
        buttonRegistroCliente.addActionListener(e -> mainView.showPanel("RegistroClientePanel"));
        buttonRegistroOficina.addActionListener(e -> mainView.showPanel("RegistroOficinaPanel"));
    }
    
    private void buttonLoginClienteActionPerformed(java.awt.event.ActionEvent evt){
        if(this.controller.validaCliente()){
            this.controller.entrarNoSistemaCliente();
            clController.puxarCliente();
            this.mainView.showPanel("ClientePanel");
        }  
        else{
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
    }
    
    private void buttonLoginOficinaActionPerformed(java.awt.event.ActionEvent evt){
        if(this.controller.validaOficina()){
            this.controller.entrarNoSistemaOficina();
            ofController.puxarOficina();
            this.mainView.showPanel("OficinaPanel");
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro");
        }
    }
    
    
    //Informações Cliente
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
    
    public MainView getMainView(){
        return mainView;
    }
    
}


