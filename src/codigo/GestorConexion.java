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

    public DefaultTableModel devuelvePersonajeUsuario(String usuario) {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"nombre", "apellidos", "alineamiento", "religion",
            "genero", "ptsGolpe", "idiomas", "nivel", "edad", "altura", "peso", "cabello",
            "ojos", "fuerza", "destreza", "constitucion", "inteligencia", "sabidura", "carisma", "acrobacias", "artesania1", "artesania1Nombre",
            "artesania2", "artesania2Nombre", "artesania3", "artesania3Nombre", "averiguarIntenciones", "conocimientoDeConjuros",
            "curar", "diplomacia", "disfrazarse", "engannar", "escapismo", "interpretar1", "interpretar1Nombre",
            "interpretar2", "interpretar2Nombre", "intimidar", "inutilizarMecanismo", "juegoDeManos", "linguistica", "montar",
            "nadar", "percepcion", "profesion1", "profesion1Nombre", "profesion2", "profesion2Nombre", "saberArcano", "saberDungeons",
            "saberGeografia", "saberHistoria", "saberIngenieria", "saberLocal", "saberNaturaleza", "saberNobleza", "saberPlanos", "saberReligion",
            "sigilo", "supervivencia", "tasacion", "tratoConAnimales", "trepar", "usarObjetoMagico", "volar", "raza", "clase",}, 0);;
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from personaje where (codPersonaje in (select codPersonaje from usuariopersonaje where (id in (select id from usuario where nombre = '" + usuario + "'))));";

            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                //Agregar los datos en la tabla poco a poco
                resultado.addRow(new String[]{rs.getString("nombre"), rs.getString("apellidos"), rs.getString("alineamiento"), rs.getString("religion"), rs.getString("genero"),
                    rs.getString("ptsGolpe"), rs.getString("idiomas"), rs.getString("nivel"), rs.getString("edad"), rs.getString("altura"), rs.getString("peso"),
                    rs.getString("cabello"), rs.getString("ojos"), rs.getString("fuerza"), rs.getString("destreza"), rs.getString("constitucion"), rs.getString("inteligencia"),
                    rs.getString("sabiduria"), rs.getString("carisma"), rs.getString("acrobacias"), rs.getString("artesania1"), rs.getString("artesania1Nombre"),
                    rs.getString("artesania2"), rs.getString("artesania2Nombre"), rs.getString("artesania3"), rs.getString("artesania3Nombre"), rs.getString("averiguarIntenciones"),
                    rs.getString("conocimientoDeConjuros"), rs.getString("curar"), rs.getString("diplomacia"), rs.getString("disfrazarse"), rs.getString("engannar"), rs.getString("escapismo"),
                    rs.getString("interpretar1"), rs.getString("interpretar1Nombre"), rs.getString("interpretar2"), rs.getString("interpretar2Nombre"), rs.getString("intimidar"),
                    rs.getString("inutilizarMecanismo"), rs.getString("juegoDeManos"), rs.getString("linguistica"), rs.getString("montar"), rs.getString("nadar"), rs.getString("percepcion"),
                    rs.getString("profesion1"), rs.getString("profesion1Nombre"), rs.getString("profesion2"), rs.getString("profesion2Nombre"), rs.getString("saberArcano"),
                    rs.getString("saberDungeons"), rs.getString("saberGeografia"), rs.getString("saberHistoria"), rs.getString("saberIngenieria"), rs.getString("saberLocal"),
                    rs.getString("saberNaturaleza"), rs.getString("saberNobleza"), rs.getString("saberPlanos"), rs.getString("saberReligion"), rs.getString("sigilo"), rs.getString("supervivencia"),
                    rs.getString("tasacion"), rs.getString("tratoConAnimales"), rs.getString("trepar"), rs.getString("usarObjetoMagico"), rs.getString("volar"), rs.getString("raza"), rs.getString("clase")});

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
