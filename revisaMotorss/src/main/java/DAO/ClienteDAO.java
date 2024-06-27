
package DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsuario(Cliente objcliente){
        conn = new ConexaoDAO().conectaBD();
        
        try {
            String sql = "Select * from usuario where nome = ? and senha = ?";
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
    
     public void registrarCliente(Cliente cliente) {
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;

        try {
            String sql = "INSERT INTO Cliente (nome, cpf, email, senha) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setInt(2, cliente.getCpf());
            pstm.setString(3, cliente.getEmail());
            pstm.setString(4, cliente.getSenha()); // A senha deve ser hashada antes de ser passada aqui

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente registrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar cliente: " + erro.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public Cliente buscarClientePorCPF(int cpf) {
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente cliente = null;

        try {
            String sql = "SELECT * FROM Cliente WHERE cpf = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cpf);

            rs = pstm.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha")); // As senhas devem ser comparadas usando hash
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + erro.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return cliente;
    }
}