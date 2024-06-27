package Controller;

import Model.Oficina;

import Controller.LoginCTRL;
import DAO.ConexaoDAO;
import DAO.OficinaDAO;
import Model.Revisao;
import com.mysql.cj.xdevapi.Result;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class OficinaCTRL {

    private Oficina oficina;
    private LoginCTRL loginCTRL;
    private RevisaoCTRL revisaoCTRL;
    
    private OficinaDAO oficinaDAO;
    
    Connection conn;
    
    public OficinaCTRL() {
        this.oficinaDAO = new OficinaDAO(); // Inicialize clienteDAO no construtor padrão
    }

    public OficinaCTRL(LoginCTRL loginCTRL) {
        this.loginCTRL = loginCTRL;
        this.oficinaDAO = new OficinaDAO(); // Inicialize clienteDAO no construtor que recebe LoginCTRL
    }
    
    public ResultSet autenticacaoOficina(Oficina objoficina){
        conn = new ConexaoDAO().conectaBD();
        
        try {
            String sql = "Select * from oficina where nome = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objoficina.getNome());
            pstm.setString(2, objoficina.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Oficina: " + erro);
            return null;
        }
    }
    
    public void registrarOficina(Oficina oficina) {
        String senhaHash = hashPassword(oficina.getSenha());
        oficina.setSenha(senhaHash);
        if (oficinaDAO != null) {
            oficinaDAO.registrarOficina(oficina);
        } else {
            JOptionPane.showMessageDialog(null, "Erro: oficinaDAO não inicializado corretamente.");
        }
    }
        
    public void puxarOficina(){
        oficina = loginCTRL.entrarNoSistemaOficina();
        System.out.println(oficina);
        
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
    
    
        
}
