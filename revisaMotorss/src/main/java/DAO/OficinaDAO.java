package DAO;

import Model.Oficina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OficinaDAO {
    private Connection conn;

    public void registrarOficina(Oficina oficina) {
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;

        try {
            String sql = "INSERT INTO Oficina (nome, cnpj, endereco, senha) VALUES (?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, oficina.getNome());
            pstm.setInt(2, oficina.getCnpj());
            pstm.setString(3, oficina.getEndereco());
            pstm.setString(4, oficina.getSenha()); // A senha deve ser hashada antes de ser passada aqui

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Oficina registrada com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar Oficina: " + erro.getMessage());
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }


    public Oficina buscarOficinaPorCnpj(int cnpj) {
        Connection conn = new ConexaoDAO().conectaBD();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Oficina oficina = null;

        try {
            String sql = "SELECT * FROM Oficina WHERE cnpj = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, cnpj);

            rs = pstm.executeQuery();

            if (rs.next()) {
                oficina = new Oficina();
                oficina.setNome(rs.getString("nome"));
                oficina.setCnpj(rs.getInt("cnpj"));
                oficina.setEndereco(rs.getString("endereco"));
                oficina.setSenha(rs.getString("senha")); // As senhas devem ser comparadas usando hash
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Oficina: " + erro.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }

        return oficina;
    }
}
