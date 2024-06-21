package View;

import javax.swing.*;
import java.awt.*;

import Controller.ClienteCTRL;
import Controller.OficinaCTRL;

import Model.Cliente;

public class MainView extends JFrame {
    private JPanel panelContainer;
    private CardLayout cardLayout;
    
    private ClienteCTRL clienteCTRL;
    private OficinaCTRL oficinaCTRL;


    public MainView() {
        setTitle("Revisa Motors");
        setSize(440, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clienteCTRL = new ClienteCTRL(); // Inicialização do campo da classe
        oficinaCTRL = new OficinaCTRL(); // Inicialização do campo da classe

        
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);

        // Adicionar painéis ao container
        panelContainer.add(new LoginPanel(this), "LoginPanel");
        panelContainer.add(new RegistroClientePanel(this), "RegistroClientePanel");
        panelContainer.add(new RegistroOficinaPanel(this), "RegistroOficinaPanel");
        panelContainer.add(new OficinaPanel(this), "OficinaPanel");
        panelContainer.add(new ClientePanel(this), "ClientePanel");
        panelContainer.add(new RevisaoPanel(this), "RevisaoPanel");
        panelContainer.add(new Veiculopanel(this), "VeiculoPanel");


        // Adicionar container ao JFrame
        add(panelContainer);

        // Exibir a tela inicial
        cardLayout.show(panelContainer, "LoginPanel");
    }

    public void showPanel(String panelName) {
        cardLayout.show(panelContainer, panelName);
    }

    
    public ClienteCTRL getClienteCTRL() {
        return clienteCTRL;
    }
    
     public OficinaCTRL getOficinaCTRL() {
        return oficinaCTRL;
    }
     
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setVisible(true);
        });
    }
    
}
