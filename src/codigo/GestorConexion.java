/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class GestorConexion {

    Connection conn1 = null;
    Statement sta = null;

    //Boolean que nos dira si la base de datos esta conectada o no
    boolean estado = false;

    public GestorConexion() {
        abrir_Conexion();
        if (conn1 != null) {
            System.out.println("Conectado a la base de datos");
            estado = true;
        }
    }

    public void abrir_Conexion() {
        try {
            String url1 = "jdbc:mysql://localhost:3306/pathmanager?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";

            conn1 = (Connection) DriverManager.getConnection(url1, user, password);
        } catch (SQLException ex) {
            System.out.println("ERROR: direccion o usuario/clave no valida");
            ex.printStackTrace();
        }
    }

    public void cerrar_conexion() {
        try {
            conn1.close();
            System.out.println("Conexion Cerrada");
            estado = false;
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion");
            ex.printStackTrace();
        }
    }

    /**
     * Funcion que nos dice si la base de datos esta conectada o no
     *
     * @return True si esta conecatada, false en caso contrario
     */
    public boolean getEstado() {
        return estado;
    }

    public boolean iniciaSesion(String usuario, String pass) {
        boolean existe = false;
        try {
            Statement sta = conn1.createStatement();
            String query = "SELECT * FROM usuario WHERE nombre like '" + usuario + "' AND pass like '" + pass + "';";
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                existe = true;
            }
            rs.close();
            sta.close();
            return existe;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return existe;
        }
    }

    //Configurar todas las tablas bien
    public DefaultTableModel dameTabla() {
        DefaultTableModel tabla;

        tabla = new DefaultTableModel(new String[]{"Nombre", "Nivel"}, 0);

        return tabla;
    }

    public DefaultTableModel consulta_Statement(String consulta) {
        DefaultTableModel resultado = null;
        try {
            Statement sta = conn1.createStatement();
            String query = "SELECT * FROM album WHERE titulo like '%" + consulta + "%'";
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                //Agregar los datos en la tabla poco a poco
//                resultado = resultado + "\n" + "ID - " + rs.getInt("id") + ", Título " + rs.getString("titulo")
//                        + ", Autor " + rs.getString("autor");
            }
            rs.close();
            sta.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public String consulta_preparedStatement(String consulta) {
        String resultado = "";
        try {
            String query = "SELECT * FROM cancion WHERE titulo like ?";
            PreparedStatement pst = conn1.prepareStatement(query);
            pst.setString(1, "%" + consulta + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                resultado = resultado + ("Titulo - " + rs.getString("titulo") + ", Duracion " + rs.getString("duracion")
                        + ", Letras " + rs.getString("letras"));
            }
            rs.close();
            pst.close();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public void insertaAlbumes(String titulo1, String autor1, String anno1,
            String titulo2, String autor2, String anno2) {
        try {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            sta.executeUpdate("INSERT INTO album (titulo, autor, anno) " + "VALUES ('" + titulo1 + "', '" + autor1 + "', '" + anno1 + "')");
            sta.executeUpdate("INSERT INTO album (titulo, autor, anno) " + "VALUES ('" + titulo2 + "', '" + autor2 + "', '" + anno2 + "')");
            conn1.commit();
            conn1.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("ERROR:al hacer un Insert");
            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            ex.printStackTrace();
        }
    }
}
