package Controller;

import DAO.ConexaoDAO;
import View.LoginPanel;

import Model.Cliente;
import Model.Oficina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginCTRL {
    
    private Cliente cliente;
    private Oficina oficina;
    private LoginPanel view;
    
    Connection conn;
       
    public LoginCTRL(LoginPanel view){
        this.view = view;
        
        
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

    public Cliente entrarNoSistemaCliente(){
        return cliente;

    }
    
    public boolean validaOficina(){
         //Procurar no bd um usuário que tenha o mesmo usuário e senha e atribuir
        oficina = getView().getMainView().getOficina();
        oficina.setNome("Oficina");
        oficina.setCnpj(1234);
        oficina.setEndereco("R.SWE");
        oficina.setSenha("1234");
        //Testando os dados na memoria depois troca pro bd
        String usuario = getView().getTextFieldUsuario().getText();
        char[] passwordChars = getView().getPasswordField().getPassword();
        String password = new String(passwordChars);
        System.out.println(usuario);
        System.out.println(password);
        //Acho que esse teste é valido
        if(oficina.getNome() != null){
            return true;
        }
        else{
            return false;
        }
    }
        
    
    public Oficina entrarNoSistemaOficina(){
        return oficina;
    }

    public LoginPanel getView() {
        return view;
    }
    
}
