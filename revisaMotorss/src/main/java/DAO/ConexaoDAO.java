
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public Connection conectaBD() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/oficinadb"; // Ajuste a URL conforme necessário
            String usuario = "root";
            String senha = "root";
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO: " + erro.getMessage());
        }
        return conn;
    }
}
