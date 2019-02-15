/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.sql.*;
import java.util.ArrayList;
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
            "sigilo", "supervivencia", "tasacion", "tratoConAnimales", "trepar", "usarObjetoMagico", "volar", "raza", "clase", "codPersonaje"}, 0);
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
                    rs.getString("tasacion"), rs.getString("tratoConAnimales"), rs.getString("trepar"), rs.getString("usarObjetoMagico"), rs.getString("volar"), rs.getString("raza"), rs.getString("clase"), rs.getString("codPersonaje")});

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

    public DefaultTableModel devuelveArmaPorPersonaje(String codPersonaje) {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "peso", "magico", "dannoP", "dannoM", "critico", "rango", "tipo", "especial", "descripcion"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from armas , (select * from personajeArmas where codPersonaje = " + codPersonaje + ") c where c.codArma = armas.codArma;";
            System.out.println("select * from armas , (select * from personajeArmas where codPersonaje = " + codPersonaje + ") c where c.codArma = armas.codArma;");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codArma"), rs.getString("nombre"), rs.getString("peso"), rs.getString("magico"), rs.getString("dannoP"), rs.getString("dannoM"),
                    rs.getString("critico"), rs.getString("rango"), rs.getString("tipo"), rs.getString("especial"), rs.getString("descripcion")});
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public DefaultTableModel devuelveTodasLasArmas() {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "peso", "magico", "dannoP", "dannoM", "critico", "rango", "tipo", "especial", "descripcion"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from armas";
            System.out.println("select * from armas");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codArma"), rs.getString("nombre"), rs.getString("peso"), rs.getString("magico"), rs.getString("dannoP"), rs.getString("dannoM"),
                    rs.getString("critico"), rs.getString("rango"), rs.getString("tipo"), rs.getString("especial"), rs.getString("descripcion")});
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public ArrayList<String> nombreClase() {
        ArrayList<String> a = new ArrayList<String>();
        try {
            Statement sta = conn1.createStatement();
            String query = "select nombre from clases";
            System.out.println("select nombre from clases");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                a.add(rs.getString("nombre"));
            }
            return a;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return a;
        }
    }

    public ArrayList<String> nombreRaza() {
        ArrayList<String> b = new ArrayList<String>();
        try {
            Statement sta = conn1.createStatement();
            String query = "select nombre from raza";
            System.out.println("select nombre from raza");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                b.add(rs.getString("nombre"));
            }
            return b;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return b;
        }
    }

    public void annadirArmaPersonaje(String codPersonaje, String codArma) {
        try {
            Statement sta = conn1.createStatement();
            String query = "select cantidad from personajeArmas as pa where pa.codPersonaje = " + codPersonaje + " and pa.codArma = " + codArma + ";";
            System.out.println("select cantidad from personajeArmas as pa where pa.codPersonaje = " + codPersonaje + " and pa.codArma = " + codArma + ";");
            ResultSet rs = sta.executeQuery(query);
            int size = 0;
            if (rs != null) //VIVA STACKOVERFLOW
            {
                rs.last();    // moves cursor to the last row
                size = rs.getRow(); // get row id 
            }
            if (size == 0) {
                query = "INSERT INTO personajeArmas (`codPersonaje`,`codArma`,`cantidad`) " + "VALUES" + " (" + codPersonaje + ", " + codArma + ", 1);";
                sta.executeUpdate(query);
            } else {
                String cantidad = rs.getString("cantidad");
                int cant = Integer.valueOf(cantidad) + 1;
                System.out.println("Cantidad " + cantidad);
                String query2 = "UPDATE personajeArmas SET cantidad = " + cant + " WHERE codPersonaje = " + codPersonaje + " AND codArma = " + codArma + ";";
                System.out.println(query2);
                sta.executeUpdate(query2);
            }

        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
        }
    }
    
    public void insertaNuevoPersonaje(String nombre, String apellidos, String alineamiento, String religion, String genero, String ptsGolpe, String idiomas, String nivel,
            String edad, String altura, String peso, String cabello, String ojos, String fuerza, String destreza, String constitucion, String inteligencia, String sabiduria,
            String carisma, String acrobacias, String artesania1, String artesania1Nombre, String artesania2, String artesania2Nombre, String artesania3, String artesania3Nombre,
            String averiguarIntenciones, String conocimientoDeConjuros, String curar, String diplomacia, String disfrazarse, String engannar, String escapismo, String interpretar1,
            String interpretar1Nombre, String interpretar2, String interpretar2Nombre, String intimidar, String inutilizarMecanismo, String juegoDeManos, String linguistica, String montar,
            String nadar, String percepcion, String profesion1, String profesion1Nombre, String profesion2, String profesion2Nombre, String saberArcano, String saberDungeons, 
            String saberGeografia, String saberHistoria, String saberIngenieria, String saberLocal, String saberNaturaleza, String saberNobleza, String saberPlanos, String saberReligion, 
            String sigilo, String supervivencia, String tasacion, String tratoConAnimales, String trepar, String usarObjetoMagico, String volar, String raza, String clase) 
    {
        try 
        {
            Statement sta = conn1.createStatement();
            String query = "INSERT INTO `personaje` (`nombre`,`apellidos`,`alineamiento`,`religion`,`genero`,`ptsGolpe`,`idiomas`,"
                    + "`nivel`, `edad`, `altura`, `peso`, `cabello`, `ojos`, `fuerza`, `destreza`, `constitucion`, `inteligencia`, `sabiduria`, `carisma`,\n"
                    + "`acrobacias`,`artesania1`,`artesania1Nombre`,`artesania2`,`artesania2Nombre`,  \n"
                    + "`artesania3`,`artesania3Nombre`,`averiguarIntenciones`,`conocimientoDeConjuros`,`curar`,`diplomacia`,`disfrazarse`,`engannar`,`escapismo`,\n"
                    + "`interpretar1`,`interpretar1Nombre`,`interpretar2`,`interpretar2Nombre`,`intimidar`,`inutilizarMecanismo`,`juegoDeManos`,`linguistica`,\n"
                    + "`montar`,`nadar`,`percepcion`,`profesion1`,`profesion1Nombre`,`profesion2`,`profesion2Nombre`,`saberArcano`,`saberDungeons`,`saberGeografia`,\n"
                    + "`saberHistoria`,`saberIngenieria`,`saberLocal`,`saberNaturaleza`,`saberNobleza`,`saberPlanos`,`saberReligion`,`sigilo`,`supervivencia`,`tasacion`,\n"
                    + "`tratoConAnimales`,`trepar`,`usarObjetoMagico`,`volar`,\n"
                    + "`raza`, `clase`) \n"
                    + "VALUES \n"
                    + "('" + nombre + "', '" + apellidos + "', '" + alineamiento + "', '" + religion + "', '" + genero + "', " + ptsGolpe + ", '" + idiomas + "',\n"
                    + "" + nivel + ", " + edad + ", " + altura + ", " + peso + ", '" + cabello + "', '" + ojos + "', " + fuerza + ", " + destreza + ", " + constitucion + ", " + inteligencia + ", " + sabiduria + ", " + carisma + ",\n"
                    + "" + acrobacias + ", " + artesania1 + ", '" + artesania1Nombre + "', " + artesania2 + ", '" + artesania2Nombre + "',\n"
                    + "" + artesania3 + ", '" + artesania3Nombre + "', " + averiguarIntenciones + ", " + conocimientoDeConjuros + ", " + curar + ", " + diplomacia + ", " + disfrazarse + ", " + engannar + ", " + escapismo + ", \n"
                    + "" + interpretar1 + ", '" + interpretar1Nombre + "', " + interpretar2 + ", '" + interpretar2Nombre + "', " + intimidar + ", " + inutilizarMecanismo + ", " + juegoDeManos + ", " + linguistica + ",\n"
                    + "" + montar + ", " + nadar + ", " + percepcion + ", " + profesion1 + ", '" + profesion1Nombre + "', " + profesion2 + ", '" + profesion2Nombre + "', " + saberArcano + ", " + saberDungeons + ", " + saberGeografia + ", \n"
                    + "" + saberHistoria + ", " + saberIngenieria + ", " + saberLocal + ", " + saberNaturaleza + ", " + saberNobleza + ", " + saberPlanos + ", " + saberReligion + ", " + sigilo + ", " + supervivencia + ", " + tasacion + ", \n"
                    + "" + tratoConAnimales + ", " + trepar + ", " + usarObjetoMagico + ", " + volar + ", \n"
                    + "'" + raza + "', '" + clase + "');";
            sta.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
        }
    }
    
    public void modificarPersonaje(String nombre, String apellidos, String alineamiento, String religion, String genero, String ptsGolpe, String idiomas, String nivel,
            String edad, String altura, String peso, String cabello, String ojos, String fuerza, String destreza, String constitucion, String inteligencia, String sabiduria,
            String carisma, String acrobacias, String artesania1, String artesania1Nombre, String artesania2, String artesania2Nombre, String artesania3, String artesania3Nombre,
            String averiguarIntenciones, String conocimientoDeConjuros, String curar, String diplomacia, String disfrazarse, String engannar, String escapismo, String interpretar1,
            String interpretar1Nombre, String interpretar2, String interpretar2Nombre, String intimidar, String inutilizarMecanismo, String juegoDeManos, String linguistica, String montar,
            String nadar, String percepcion, String profesion1, String profesion1Nombre, String profesion2, String profesion2Nombre, String saberArcano, String saberDungeons, 
            String saberGeografia, String saberHistoria, String saberIngenieria, String saberLocal, String saberNaturaleza, String saberNobleza, String saberPlanos, String saberReligion, 
            String sigilo, String supervivencia, String tasacion, String tratoConAnimales, String trepar, String usarObjetoMagico, String volar, String raza, String clase, String codPersonaje) 
    {
        try 
        {
            Statement sta = conn1.createStatement();
            String query = "UPDATE personaje SET nombre = '" + nombre + "', apellidos = '" + apellidos + "', alineamiento = '" + alineamiento + "',"
                    + "religion = '" + religion + "', genero = '" + genero + "', ptsGolpe = " + ptsGolpe + ", idiomas = '" + idiomas + "', nivel = " + nivel + ","
                    + "edad = " + edad + ", altura = " + altura + ", peso = " + peso + ", cabello = '" + cabello + "', ojos = '" + ojos + "',"
                    + "fuerza = " + fuerza + ", destreza = " + destreza + ", constitucion = " + constitucion + ", inteligencia = " + inteligencia + ", sabiduria = " + sabiduria + ","
                    + "carisma = " + carisma + ", acrobacias = " + acrobacias + ", artesania1 = " + artesania1 + ", artesania1Nombre = '" + artesania1Nombre + "',"
                    + "artesania2 = " + artesania2 + ", artesania2Nombre = '" + artesania2Nombre + "', artesania3 = " + artesania3 + ", artesania3Nombre = '" + artesania3Nombre + "',"
                    + "averiguarIntenciones = " + averiguarIntenciones + ", conocimientoDeConjuros = " + conocimientoDeConjuros + ", curar = " + curar + ", diplomacia = " + diplomacia + ","
                    + "disfrazarse = " + disfrazarse + ", engannar = " + engannar + ", escapismo = " + escapismo + ", interpretar1 = " + interpretar1 + ", "
                    + "interpretar1Nombre = '" + interpretar1Nombre + "', interpretar2 = " + interpretar2 + ", interpretar2Nombre = '" + interpretar2Nombre + "',"
                    + "intimidar = " + intimidar + ", inutilizarMecanismo = " + inutilizarMecanismo + ", juegoDeManos = " + juegoDeManos + ", linguistica = " + linguistica + ","
                    + "montar = " + montar + ", nadar = " + nadar + ", percepcion = " + percepcion + ", profesion1 = " + profesion1 + ", profesion1Nombre = '" + profesion1Nombre + "',"
                    + "profesion2 = " + profesion2 + ", profesion2Nombre = '" + profesion2Nombre + "', saberArcano = " + saberArcano + ", saberDungeons = " + saberDungeons + ","
                    + "saberGeografia = " + saberGeografia + ", saberHistoria = " + saberHistoria + ", saberIngenieria = " + saberIngenieria + ", saberLocal = " + saberLocal + ","
                    + "saberNaturaleza = " + saberNaturaleza + ", saberNobleza = " + saberNobleza + ", saberPlanos = " + saberPlanos +", saberReligion = " + saberReligion + ","
                    + "sigilo = " + sigilo + ", supervivencia = " + supervivencia + ", tasacion = " + tasacion + ", tratoConAnimales = " + tratoConAnimales + ", trepar = " + trepar + ","
                    + "usarObjetoMagico = " + usarObjetoMagico + ", volar = " + volar + ", raza = '" + raza + "', clase = '" + clase + "' WHERE codPersonaje = " + codPersonaje + ";";
            sta.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("ERROR: No hay tostadora en la bañera");
            ex.printStackTrace();
        }
    }

    public DefaultTableModel devuelveArmaduraPorPersonaje(String codPersonaje) {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "bonificador", "peso", "magico", "descripcion", "velocidad", "dexBonus", "penalizacion", "falloHechizo", "cantidad"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from armaduras , (select * from personajeArmaduras where codPersonaje = " + codPersonaje + ") c where c.codArmadura = armaduras.codArmadura;";
            System.out.println("select * from armaduras , (select * from personajeArmaduras where codPersonaje = " + codPersonaje + ") c where c.codArmadura = armaduras.codArmadura;");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codArmadura"), rs.getString("nombre"), rs.getString("bonificador"), rs.getString("peso"), rs.getString("magico"), rs.getString("descripcion"), rs.getString("velocidad"),
                    rs.getString("dexBonus"), rs.getString("penalizacion"), rs.getString("falloHechizo"), rs.getString("cantidad")});
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public DefaultTableModel devuelveObjetosPorPersonaje(String codPersonaje) {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "peso", "magico", "descripcion", "cantidad"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from objetos , (select * from personajeObjetos where codPersonaje = " + codPersonaje + ") c where c.codObjeto = objetos.codObjeto;";
            System.out.println("select * from objetos , (select * from personajeObjetos where codPersonaje = " + codPersonaje + ") c where c.codObjeto = objetos.codObjeto;");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codObjeto"), rs.getString("nombre"), rs.getString("peso"), rs.getString("magico"), rs.getString("descripcion"), rs.getString("cantidad")});
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public DefaultTableModel devuelveDotesPorPersonaje(String codPersonaje) {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "beneficio", "normal", "especial", "descripcion", "preRequisitos"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from dotes , (select * from personajeDotes where codPersonaje = " + codPersonaje + ") c where c.codDote = dotes.codDote;";
            System.out.println("select * from dotes , (select * from personajeDotes where codPersonaje = " + codPersonaje + ") c where c.codDote = dotes.codDote;");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codDote"), rs.getString("nombre"), rs.getString("beneficio"), rs.getString("normal"),
                    rs.getString("especial"), rs.getString("descripcion"), rs.getString("preRequisitos")});
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public DefaultTableModel devuelveHabilidadesDeClasePorPersonaje(String codPersonaje) //FALTA POR TERMINAR.
    {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "ex", "descripcion", "objeto", "nombreClase"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from habilidadesDeClases , (select * from clasesHabilidadesDeClases where codClase = " + codPersonaje + ") c where c.codHabilidadDeClase = habilidadesDeClases.codHabilidadDeClase;";
            System.out.println("select * from habilidadesDeClases , (select * from clasesHabilidadesDeClases where codClase = " + codPersonaje + ") c where c.codHabilidadDeClase = habilidadesDeClases.codHabilidadDeClase;");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codHabilidadDeClase"), rs.getString("nombre"), rs.getString("ex"), rs.getString("descripcion"),
                    rs.getString("objeto"), rs.getString("nombreClase")});
            }
            return resultado;
        } catch (SQLException ex) {
            System.out.println("ERROR:al consultar");
            ex.printStackTrace();
            return resultado;
        }
    }

    public DefaultTableModel devuelveHechizosPorPersonaje(String codPersonaje) //FALTA POR TERMINAR.
    {
        DefaultTableModel resultado = new DefaultTableModel(new String[]{"id", "nombre", "escuela", "tiempoCasteo", "componentes", "descripcion",
            "rango", "objetivo", "efecto", "duracion", "tiradaSalvacion", "resistenciaHechizo", "barbaro", "bardo", "clerigo", "druida", "explorador",
            "guerrero", "monje", "paladin", "picaro", "hechicero", "mago"}, 0);
        try {
            Statement sta = conn1.createStatement();
            String query = "select * from hechizos , (select * from personajeHechizos where codPersonaje = " + codPersonaje + ") c where c.codHechizo = hechizos.codHechizo;";
            System.out.println("select * from hechizos , (select * from personajeHechizos where codPersonaje = " + codPersonaje + ") c where c.codHechizo = hechizos.codHechizo;");
            ResultSet rs = sta.executeQuery(query);
            while (rs.next()) {
                resultado.addRow(new String[]{rs.getString("codHechizo"), rs.getString("nombre"), rs.getString("escuela"), rs.getString("tiempoCasteo"),
                    rs.getString("componentes"), rs.getString("descripcion"), rs.getString("rango"), rs.getString("objetivo"), rs.getString("efecto"),
                    rs.getString("duracion"), rs.getString("tiradaSalvacion"), rs.getString("resistenciaHechizo")});
            }
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
