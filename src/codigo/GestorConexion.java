/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.*;

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
        try {
            String url1 = "jdbc:mysql://localhost:3306/pathmanager?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";

            conn1 = (Connection) DriverManager.getConnection(url1, user, password);

            if (conn1 != null) {
                System.out.println("Conectado a la base de datos");
                estado = true;
            }
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

    public String consulta_Statement(String consulta) {
        String resultado = "";
        try {
            Statement sta = conn1.createStatement();
            String query = "SELECT * FROM album WHERE titulo like '%" + consulta + "%'";
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado = resultado + "\n" + "ID - " + rs.getInt("id") + ", Título " + rs.getString("titulo")
                        + ", Autor " + rs.getString("autor");
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

    public void insertaCanciones(String titulo1, String duracion1, String letra1,
            String titulo2, String duracion2, String letra2) {
        try {
            conn1.setAutoCommit(false);
            Statement sta = conn1.createStatement();
            sta.executeUpdate("INSERT INTO cancion (titulo, duracion, letras) " + "VALUES ('" + titulo1 + "', '" + duracion1 + "', '" + letra1 + "')");
            sta.executeUpdate("INSERT INTO cancion (titulo, duracion, letras) " + "VALUES ('" + titulo2 + "', '" + duracion2 + "', '" + letra2 + "')");
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

    public void insertaColumnaImagenes() {
        try {
            // Crea un statement
            Statement sta = conn1.createStatement();
            // Ejecuta la inserción
            sta.executeUpdate("ALTER TABLE album ADD caratula VARCHAR(100) DEFAULT NULL;");
            // Cierra el statement
            sta.close();
        } catch (SQLException ex) {
            System.out.println("ERROR: al modificar la table");
            ex.printStackTrace();
        }

    }
}
