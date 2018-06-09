package Capa.Conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection cnn = null;
    private Statement st;
    private CallableStatement cs;

    public Conexion() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdGamma", "root", "root");

            if (cnn != null) {
                System.out.println("Conexion  ok...");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR no Conecto :\n" + e.toString());
        }
    }

    public boolean ejecutar(String query) {
        try {
            st = cnn.createStatement();
            st.execute(query);
            return true;
        } catch (SQLException ex) {
            System.err.print("Error al ejecutar consulta" + ex);
            return false;
        }
    }

    public ResultSet consultar(String query) {
        ResultSet tabla = null;
        try {
            st = cnn.createStatement();
            tabla = st.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error al Consultar consulta" + e);
        }
        return tabla;
    }

    public void desconectar() {
        try {
            cnn.close();
            st.close();

        } catch (SQLException ex) {
            System.err.println("Error al cerrar conexión" + ex);
        }
    }

    public Connection conectar() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/bdGamma", "root", "");

            if (cnn != null) {
                System.out.println("Conexion  ok...");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR En Conectar :\n" + e.toString());
        }
        return cnn;
    }

}
