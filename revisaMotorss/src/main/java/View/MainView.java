package View;

import javax.swing.*;
import java.awt.*;
import Controller.ClienteCTRL;
import Controller.LoginCTRL;
import Controller.OficinaCTRL;
import Controller.VeiculoCTRL;
import Model.Cliente;
import Model.Oficina;
import Model.Veiculo;

public class MainView extends JFrame {
    private JPanel panelContainer;
    private CardLayout cardLayout;

    private LoginPanel loginPanel;
    private RegistroClientePanel registroClientePanel;
    private RegistroOficinaPanel registroOficinaPanel;
    private OficinaPanel oficinaPanel;
    private ClientePanel clientePanel;
    private Veiculopanel veiculoPanel;
    private RevisaoPanel revisaoPanel;
    
    
    private ClienteCTRL clienteCTRL;
    private OficinaCTRL oficinaCTRL;
    private LoginCTRL loginCTRL;
    private VeiculoCTRL veiculoCTRL;

    private Cliente cliente;
    private Veiculo veiculo;
    private Oficina oficina;

    public MainView() {
        setTitle("Revisa Motors");
        setSize(440, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
        
        /*
        // Inicializar modelos
        oficina = new Oficina();
        cliente = new Cliente();
        veiculo = new Veiculo();

        // Inicializar painéis
        loginPanel = new LoginPanel(this);
        
        // Inicializar controladores
        loginCTRL = new LoginCTRL(loginPanel);
        loginPanel.setController(loginCTRL);
        clienteCTRL = new ClienteCTRL();
        oficinaCTRL = new OficinaCTRL();
        veiculoCTRL = new VeiculoCTRL();
*/
        cliente = new Cliente();
        veiculo = new Veiculo();
        
        //veiculoCTRL = new VeiculoCTRL();
        clienteCTRL = new ClienteCTRL();

        // Inicializar painéis restantes
        loginPanel = new LoginPanel(this);
        registroClientePanel = new RegistroClientePanel(this);
        registroOficinaPanel = new RegistroOficinaPanel(this);
        oficinaPanel = new OficinaPanel(this);
        clientePanel = new ClientePanel(this);
        veiculoPanel = new Veiculopanel(this);
        revisaoPanel = new RevisaoPanel(this);

        // Adicionar painéis ao container
        panelContainer.add(loginPanel, "LoginPanel");
        panelContainer.add(registroClientePanel, "RegistroClientePanel");
        panelContainer.add(registroOficinaPanel, "RegistroOficinaPanel");
        panelContainer.add(oficinaPanel, "OficinaPanel");
        panelContainer.add(clientePanel, "ClientePanel");
        panelContainer.add(veiculoPanel, "VeiculoPanel");
        panelContainer.add(revisaoPanel, "RevisaoPanel");

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

    public VeiculoCTRL getVeiculoCTRL() {
        return veiculoCTRL;
    }
    
    public ClientePanel getClientePanel(){
        return clientePanel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LoginCTRL getLoginCTRL() {
        return loginCTRL;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            mainView.setVisible(true);
        });
    }
}

