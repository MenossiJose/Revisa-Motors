package View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Model.Oficina;
import Controller.OficinaCTRL;

public class RegistroOficinaPanel extends JPanel {
    private MainView mainView;
    private JTextField textFieldNome;
    private JTextField textFieldCNPJ;
    private JTextField textFieldEndereco;
    private JPasswordField passwordField;
    private JButton buttonRegistrar;
    private JButton buttonVoltar;

    public RegistroOficinaPanel(MainView mainView) {
        this.mainView = mainView;
        setLayout(null);

        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(30, 10, 100, 25);
        add(labelNome);

        textFieldNome = new JTextField();
        textFieldNome.setBounds(120, 10, 200, 25);
        add(textFieldNome);

        JLabel labelCNPJ = new JLabel("CNPJ:");
        labelCNPJ.setBounds(30, 50, 100, 25);
        add(labelCNPJ);

        textFieldCNPJ = new JTextField();
        textFieldCNPJ.setBounds(120, 50, 200, 25);
        add(textFieldCNPJ);

        JLabel labelEndereco = new JLabel("Endereço:");
        labelEndereco.setBounds(30, 90, 100, 25);
        add(labelEndereco);

        textFieldEndereco = new JTextField();
        textFieldEndereco.setBounds(120, 90, 200, 25);
        add(textFieldEndereco);

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
                //Instancia Oficina Ctrl
                OficinaCTRL oficinaCTRL = new OficinaCTRL();
                //Define atributos
                String nome = textFieldNome.getText();
                int cnpj = Integer.parseInt(textFieldCNPJ.getText());
                String endereco = textFieldEndereco.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);
                //Instancia Oficina com construtor
                Oficina oficina = new Oficina(nome, cnpj, endereco, password);
                //Envia para Controller
                oficinaCTRL.registrarOficina(oficina);
            }
        });
    }
}
