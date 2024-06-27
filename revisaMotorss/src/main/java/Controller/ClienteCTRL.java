package Controller;

import View.RegistroClientePanel;
import View.Veiculopanel;
import View.ClientePanel;

import Model.Cliente;
import Model.Veiculo;

import Controller.LoginCTRL;
import Controller.VeiculoCTRL;
import DAO.ClienteDAO;
import DAO.ConexaoDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteCTRL {
    private Cliente cliente;
    private LoginCTRL loginCTRL;
    
     private ClienteDAO clienteDAO;
    
    Connection conn;

   
    public ClienteCTRL() {
        this.clienteDAO = new ClienteDAO(); // Inicialize clienteDAO no construtor padrão
    }

    public ClienteCTRL(LoginCTRL loginCTRL) {
        this.loginCTRL = loginCTRL;
        this.clienteDAO = new ClienteDAO(); // Inicialize clienteDAO no construtor que recebe LoginCTRL
    }
  
    public ResultSet autenticacaoCliente(Cliente objcliente){
        conn = new ConexaoDAO().conectaBD();
        
        try {
            String sql = "Select * from cliente where nome = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcliente.getNome());
            pstm.setString(2, objcliente.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Cliente: " + erro);
            return null;
        }
    }
    


    //Função para pegar o Cliente do Login
    //Todo o resto de manipulação tem que usar o cliente do login
    public void puxarCliente(){
        //Agora da pra puxar o cliente la da MainView entao ta safe
        this.cliente = loginCTRL.entrarNoSistemaCliente();
        System.out.println(getCliente().getNome());

    }

    public void registrarCliente(Cliente cliente) {
        String senhaHash = hashPassword(cliente.getSenha());
        cliente.setSenha(senhaHash);
        if (clienteDAO != null) {
            clienteDAO.registrarCliente(cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: clienteDAO não inicializado corretamente.");
        }
    }

    public Cliente buscarClientePorCPF(int cpf) {
        return clienteDAO.buscarClientePorCPF(cpf);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    

   
}
