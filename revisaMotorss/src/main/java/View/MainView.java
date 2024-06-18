package View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel panelContainer;
    private CardLayout cardLayout;

    public MainView() {
        setTitle("Revisa Motors");
        setSize(440, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);

        // Adicionar painéis ao container
        panelContainer.add(new LoginPanel(this), "LoginPanel");
        panelContainer.add(new RegistroClientePanel(this), "RegistroClientePanel");
        panelContainer.add(new RegistroOficinaPanel(this), "RegistroOficinaPanel");
        panelContainer.add(new ClientePanel(this), "ClientePanel");
        panelContainer.add(new OficinaPanel(this), "OficinaPanel");
        panelContainer.add(new ClientePanel(this), "ClientePanel");
        panelContainer.add(new RevisaoPanel(this), "RevisaoPanel");
        panelContainer.add(new OficinaPanel(this), "OficinaPanel");
        panelContainer.add(new Veiculopanel(this), "VeiculoPanel");


        // Adicionar container ao JFrame
        add(panelContainer);

        // Exibir a tela inicial
        cardLayout.show(panelContainer, "LoginPanel");
    }

    public void showPanel(String panelName) {
        cardLayout.show(panelContainer, panelName);
    }
}
