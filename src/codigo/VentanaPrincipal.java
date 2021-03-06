package codigo;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel Y Marco
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    GestorConexion miConexion;
    private boolean usuarioConectado = false;
    InicioSesion inicioSesion;
    VentanaDetallesArmas ventanaDetallesArmas;
    NuevoPersonaje ventanaNuevoPersonaje;
    String miUsuario;

    //Tablas locales donde guardaremos los datos
    DefaultTableModel personajes;
    DefaultTableModel armas;
    DefaultTableModel armaduras;
    DefaultTableModel objetos;
    DefaultTableModel dotes;
    DefaultTableModel habilidadesDeClase;
    DefaultTableModel hechizos;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setResizable(false);
        inicioSesion = new InicioSesion();
        inicioSesion.setVentanaPrincipal(this);
        miConexion = new GestorConexion();
        ventanaDetallesArmas = new VentanaDetallesArmas();
        ventanaDetallesArmas.guardaVentanaPrincipal(this);
        ventanaNuevoPersonaje = new NuevoPersonaje();
        ventanaNuevoPersonaje.guardaConexion(miConexion, this);
        ventanaNuevoPersonaje.rellenaComboBox();
        reseteaInterfaz();
        bloquearInterfaz(false);

    }

    public void setSesion(Boolean estado, String usuario) {
        usuarioConectado = estado;
        bloquearInterfaz(estado);
        if (usuarioConectado) {
            descargaDatosPersonajes(usuario);
            miUsuario = usuario;
        }
    }

    //Pone los campos en blanco
    public void reseteaInterfaz() {
        //Ponemos en blanco todos los jComboBox
        jComboBoxArmaduras.removeAllItems();
        jComboBoxArmas.removeAllItems();
        jComboBoxDotes.removeAllItems();
        jComboBoxHabilidadesDeClase.removeAllItems();
        jComboBoxHechizos.removeAllItems();
        jComboBoxListaPersonajes.removeAllItems();
        jComboBoxObjetos.removeAllItems();

        limpiaInterfaz();
    }

    public void limpiaInterfaz() {
        //Ponemos en blanco todos los jLabels de habilidades que no sean Titulos
        jLabelAcrobacias.setText("");
        jLabelArtesania1.setText("");
        jLabelArtesania2.setText("");
        jLabelArtesania3.setText("");
        jLabelAveriguarIntenciones.setText("");
        jLabelConocimientoConjuros.setText("");
        jLabelCurar.setText("");
        jLabelDiplomacia.setText("");
        jLabelDisfrazarse.setText("");
        jLabelEngannar.setText("");
        jLabelEscapismo.setText("");
        jLabelInterpretar1.setText("");
        jLabelInterpretar2.setText("");
        jLabelIntimidar.setText("");
        jLabelInutilizarMecanismo.setText("");
        jLabelJuegoDeManos.setText("");
        jLabelLinguistica.setText("");
        jLabelMontar.setText("");
        jLabelPercepcion.setText("");
        jLabelProfesion1.setText("");
        jLabelProfesion2.setText("");
        jLabelSaberArcano.setText("");
        jLabelSaberDungeons.setText("");
        jLabelSaberGeografia.setText("");
        jLabelSaberHistoria.setText("");
        jLabelSaberIngenieria.setText("");
        jLabelSaberLocal.setText("");
        jLabelSaberLosPlanos.setText("");
        jLabelSaberNaturaleza.setText("");
        jLabelSaberNobleza.setText("");
        jLabelSaberReligion.setText("");
        jLabelSigilo.setText("");
        jLabelSupervivencia.setText("");
        jLabelTasacion.setText("");
        jLabelTratoConAnimales.setText("");
        jLabelTrepar.setText("");
        jLabelUsarObjetoMagico.setText("");
        jLabelVolar.setText("");
        jLabelNadar.setText("");

        //Ahora reestablecemos los titulos que se modifican
        jLabelTArtesania1.setText("Artesania");
        jLabelTArtesania2.setText("Artesania");
        jLabelTArtesania3.setText("Artesania");
        jLabelTInterpretar1.setText("Interpretar");
        jLabelTInterpretar2.setText("Interpretar");
        jLabelTProfesion1.setText("Profesion");
        jLabelTProfesion2.setText("Profesion");

        //Ahora reseteamos el resto de caracteristicas
        jLabelFuerza.setText("");
        jLabelDestreza.setText("");
        jLabelConstitucion.setText("");
        jLabelInteligencia.setText("");
        jLabelSabiduria.setText("");
        jLabelFuerza.setText("");
        jLabelCarisma.setText("");
        jLabelNombre.setText("");
        jLabelApellido.setText("");
        jLabelAlineamiento.setText("");
        jLabelRaza.setText("");
        jLabelClase.setText("");
        jLabelNivel.setText("");
        jLabelDios.setText("");
        jLabelSexo.setText("");
        jLabelAltura.setText("");
        jLabelEdad.setText("");
        jLabelPeso.setText("");
        jLabelOjos.setText("");
        jLabelCabello.setText("");
        jLabelPtsGolpe.setText("");
        jLabelVelocidad.setText("");
    }

    //Bloquea o desbloquea la interfaz
    public void bloquearInterfaz(boolean bloquea) {

        //Bloqueamos los jComboBox
        jComboBoxArmaduras.setEnabled(bloquea);
        jComboBoxArmas.setEnabled(bloquea);
        jComboBoxDotes.setEnabled(bloquea);
        jComboBoxHabilidadesDeClase.setEnabled(bloquea);
        jComboBoxHechizos.setEnabled(bloquea);
        jComboBoxListaPersonajes.setEnabled(bloquea);
        jComboBoxObjetos.setEnabled(bloquea);

        //Bloqueamos los botones
        jButtonAnnadirArma.setEnabled(bloquea);
        jButtonAnnadirArmadura.setEnabled(bloquea);
        jButtonAnnadirDote.setEnabled(bloquea);
        jButtonAnnadirHabilidadDeClase.setEnabled(bloquea);
        jButtonAnnadirHechizo.setEnabled(bloquea);
        jButtonAnnadirObjeto.setEnabled(bloquea);

        jButtonDetallesArmaduras.setEnabled(bloquea);
        jButtonDetallesArmas.setEnabled(bloquea);
        jButtonDetallesDotes.setEnabled(bloquea);
        jButtonDetallesHabilidadesDeClase.setEnabled(bloquea);
        jButtonDetallesHechizos.setEnabled(bloquea);
        jButtonDetallesObjetos.setEnabled(bloquea);

    }

    //Descarga los datos de los personajes y los guarda en local
    public void descargaDatosPersonajes(String usuario) {
        //Guardamos las tablas en local
        personajes = miConexion.devuelvePersonajeUsuario(usuario);

        insertaPersonajesEnComboBox();

        rellenaComboBox();

        actualizaPersonaje(jComboBoxListaPersonajes.getSelectedIndex());

    }

    public void actualizaPersonaje(int codigoPersonaje) {
        //Primero ponemos en blanco la interfaz guardando 
        limpiaInterfaz();

        //Ahora metemos los objetos del personaje seleccionado en los comboBox
        rellenaComboBox();

        //Ahora decimos a las ventanas auxiliares que hemos cambiado de personaje
        //y tienen que reconfigurar las tablas
        ventanaDetallesArmas.cambioDeTabla();

        //Guardamos los datos base del primer personaje
        jLabelNombre.setText(personajes.getValueAt(codigoPersonaje, 0).toString());
        jLabelApellido.setText(personajes.getValueAt(codigoPersonaje, 1).toString());
        jLabelAlineamiento.setText(personajes.getValueAt(codigoPersonaje, 2).toString());
        jLabelDios.setText(personajes.getValueAt(codigoPersonaje, 3).toString());
        jLabelSexo.setText(personajes.getValueAt(codigoPersonaje, 4).toString());
        jLabelPtsGolpe.setText(personajes.getValueAt(codigoPersonaje, 5).toString());
        jLabelNivel.setText(personajes.getValueAt(codigoPersonaje, 7).toString());
        jLabelEdad.setText(personajes.getValueAt(codigoPersonaje, 8).toString());
        jLabelAltura.setText(personajes.getValueAt(codigoPersonaje, 9).toString());
        jLabelPeso.setText(personajes.getValueAt(codigoPersonaje, 10).toString());
        jLabelCabello.setText(personajes.getValueAt(codigoPersonaje, 11).toString());
        jLabelOjos.setText(personajes.getValueAt(codigoPersonaje, 12).toString());
        jLabelFuerza.setText(personajes.getValueAt(codigoPersonaje, 13).toString());
        jLabelDestreza.setText(personajes.getValueAt(codigoPersonaje, 14).toString());
        jLabelConstitucion.setText(personajes.getValueAt(codigoPersonaje, 15).toString());
        jLabelInteligencia.setText(personajes.getValueAt(codigoPersonaje, 16).toString());
        jLabelSabiduria.setText(personajes.getValueAt(codigoPersonaje, 17).toString());
        jLabelCarisma.setText(personajes.getValueAt(codigoPersonaje, 18).toString());
        jLabelRaza.setText(personajes.getValueAt(codigoPersonaje, 65).toString());
        jLabelClase.setText(personajes.getValueAt(codigoPersonaje, 66).toString());

        //Guardamos ahora las habilidades del primer personaje
        jLabelAcrobacias.setText(personajes.getValueAt(codigoPersonaje, 19).toString());
        jLabelArtesania1.setText(personajes.getValueAt(codigoPersonaje, 20).toString());
        jLabelArtesania2.setText(personajes.getValueAt(codigoPersonaje, 22).toString());
        jLabelArtesania3.setText(personajes.getValueAt(codigoPersonaje, 24).toString());
        jLabelAveriguarIntenciones.setText(personajes.getValueAt(codigoPersonaje, 26).toString());
        jLabelConocimientoConjuros.setText(personajes.getValueAt(codigoPersonaje, 27).toString());
        jLabelCurar.setText(personajes.getValueAt(codigoPersonaje, 28).toString());
        jLabelDiplomacia.setText(personajes.getValueAt(codigoPersonaje, 29).toString());
        jLabelDisfrazarse.setText(personajes.getValueAt(codigoPersonaje, 30).toString());
        jLabelEngannar.setText(personajes.getValueAt(codigoPersonaje, 31).toString());
        jLabelEscapismo.setText(personajes.getValueAt(codigoPersonaje, 32).toString());
        jLabelInterpretar1.setText(personajes.getValueAt(codigoPersonaje, 33).toString());
        jLabelInterpretar2.setText(personajes.getValueAt(codigoPersonaje, 35).toString());
        jLabelIntimidar.setText(personajes.getValueAt(codigoPersonaje, 37).toString());
        jLabelInutilizarMecanismo.setText(personajes.getValueAt(codigoPersonaje, 38).toString());
        jLabelJuegoDeManos.setText(personajes.getValueAt(codigoPersonaje, 39).toString());
        jLabelLinguistica.setText(personajes.getValueAt(codigoPersonaje, 40).toString());
        jLabelMontar.setText(personajes.getValueAt(codigoPersonaje, 41).toString());
        jLabelNadar.setText(personajes.getValueAt(codigoPersonaje, 42).toString());
        jLabelPercepcion.setText(personajes.getValueAt(codigoPersonaje, 43).toString());
        jLabelProfesion1.setText(personajes.getValueAt(codigoPersonaje, 44).toString());
        jLabelProfesion2.setText(personajes.getValueAt(codigoPersonaje, 46).toString());
        jLabelSaberArcano.setText(personajes.getValueAt(codigoPersonaje, 48).toString());
        jLabelSaberDungeons.setText(personajes.getValueAt(codigoPersonaje, 49).toString());
        jLabelSaberGeografia.setText(personajes.getValueAt(codigoPersonaje, 50).toString());
        jLabelSaberHistoria.setText(personajes.getValueAt(codigoPersonaje, 51).toString());
        jLabelSaberIngenieria.setText(personajes.getValueAt(codigoPersonaje, 52).toString());
        jLabelSaberLocal.setText(personajes.getValueAt(codigoPersonaje, 53).toString());
        jLabelSaberNaturaleza.setText(personajes.getValueAt(codigoPersonaje, 54).toString());
        jLabelSaberNobleza.setText(personajes.getValueAt(codigoPersonaje, 55).toString());
        jLabelSaberLosPlanos.setText(personajes.getValueAt(codigoPersonaje, 56).toString());
        jLabelSaberReligion.setText(personajes.getValueAt(codigoPersonaje, 57).toString());
        jLabelSigilo.setText(personajes.getValueAt(codigoPersonaje, 58).toString());
        jLabelSupervivencia.setText(personajes.getValueAt(codigoPersonaje, 59).toString());
        jLabelTasacion.setText(personajes.getValueAt(codigoPersonaje, 60).toString());
        jLabelTratoConAnimales.setText(personajes.getValueAt(codigoPersonaje, 61).toString());
        jLabelTrepar.setText(personajes.getValueAt(codigoPersonaje, 62).toString());
        jLabelUsarObjetoMagico.setText(personajes.getValueAt(codigoPersonaje, 63).toString());
        jLabelVolar.setText(personajes.getValueAt(codigoPersonaje, 64).toString());

        //Ahora miramos si tiene habilidades con nombre propio y los cambiamos 
        if (!personajes.getValueAt(codigoPersonaje, 21).toString().equals("-")) {
            jLabelTArtesania1.setText(personajes.getValueAt(codigoPersonaje, 21).toString());
        }
        if (!personajes.getValueAt(codigoPersonaje, 23).toString().equals("-")) {
            jLabelTArtesania2.setText(personajes.getValueAt(codigoPersonaje, 23).toString());
        }
        if (!personajes.getValueAt(codigoPersonaje, 25).toString().equals("-")) {
            jLabelTArtesania3.setText(personajes.getValueAt(codigoPersonaje, 25).toString());
        }
        if (!personajes.getValueAt(codigoPersonaje, 34).toString().equals("-")) {
            jLabelTInterpretar1.setText(personajes.getValueAt(codigoPersonaje, 34).toString());
        }
        if (!personajes.getValueAt(codigoPersonaje, 36).toString().equals("-")) {
            jLabelTInterpretar2.setText(personajes.getValueAt(codigoPersonaje, 36).toString());
        }
        if (!personajes.getValueAt(codigoPersonaje, 45).toString().equals("-")) {
            jLabelTProfesion1.setText(personajes.getValueAt(codigoPersonaje, 45).toString());
        }
        if (!personajes.getValueAt(codigoPersonaje, 47).toString().equals("-")) {
            jLabelTProfesion2.setText(personajes.getValueAt(codigoPersonaje, 47).toString());
        }
    }

    public void rellenaComboBox() {
        insertaArmasEnComboBox();
        insertaArmadurasEnComboBox();
        insertaObjetosEnComboBox();
        insertaDotesEnComboBox();
        insertaHabilidadesDeClasesEnComboBox();
        insertaHechizosEnComboBox();
    }

    public void insertaPersonajesEnComboBox() {
        jComboBoxListaPersonajes.removeAllItems();

        for (int i = 0; i < personajes.getRowCount(); i++) {
            jComboBoxListaPersonajes.addItem(personajes.getValueAt(i, 0).toString());
        }

    }

    public void insertaArmasEnComboBox() {
        jComboBoxArmas.removeAllItems();
        String a = personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString();
        armas = miConexion.devuelveArmaPorPersonaje(a);
        System.out.println(a);
        for (int i = 0; i < armas.getRowCount(); i++) {
            jComboBoxArmas.addItem(armas.getValueAt(i, 1).toString());
        }
    }

    public void insertaArmadurasEnComboBox() {
        jComboBoxArmaduras.removeAllItems();
        String a = personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString();
        armaduras = miConexion.devuelveArmaduraPorPersonaje(a);
        System.out.println(a);
        for (int i = 0; i < armaduras.getRowCount(); i++) {
            jComboBoxArmaduras.addItem(armaduras.getValueAt(i, 1).toString());
        }
    }

    public void insertaObjetosEnComboBox() {
        jComboBoxObjetos.removeAllItems();
        String a = personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString();
        objetos = miConexion.devuelveObjetosPorPersonaje(a);
        System.out.println(a);
        for (int i = 0; i < objetos.getRowCount(); i++) {
            jComboBoxObjetos.addItem(objetos.getValueAt(i, 1).toString());
        }
    }

    public void insertaDotesEnComboBox() {
        jComboBoxDotes.removeAllItems();
        String a = personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString();
        dotes = miConexion.devuelveDotesPorPersonaje(a);
        System.out.println(a);

        for (int i = 0; i < dotes.getRowCount(); i++) {
            jComboBoxDotes.addItem(dotes.getValueAt(i, 1).toString());
        }
    }

    public void insertaHabilidadesDeClasesEnComboBox() {
        jComboBoxHabilidadesDeClase.removeAllItems();
        String a = personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString();
        habilidadesDeClase = miConexion.devuelveHabilidadesDeClasePorPersonaje(a);
        System.out.println(a);

        for (int i = 0; i < habilidadesDeClase.getRowCount(); i++) {
            jComboBoxHabilidadesDeClase.addItem(habilidadesDeClase.getValueAt(i, 1).toString());
        }
    }

    public void insertaHechizosEnComboBox() {
        jComboBoxHechizos.removeAllItems();
        String a = personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString();
        hechizos = miConexion.devuelveHechizosPorPersonaje(a);
        System.out.println(a);

        for (int i = 0; i < hechizos.getRowCount(); i++) {
            jComboBoxHechizos.addItem(hechizos.getValueAt(i, 1).toString());
        }
    }

    public DefaultTableModel devuelveTodasLasArmas() {
        return miConexion.devuelveTodasLasArmas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTFuerza = new javax.swing.JLabel();
        jLabelTFUE = new javax.swing.JLabel();
        jLabelTDestreza = new javax.swing.JLabel();
        jLabelTDES = new javax.swing.JLabel();
        jLabelTConstitucion = new javax.swing.JLabel();
        jLabelTCON = new javax.swing.JLabel();
        jLabelTInteligencia = new javax.swing.JLabel();
        jLabelTINT = new javax.swing.JLabel();
        jLabelTSabiduria = new javax.swing.JLabel();
        jLabelTSAB = new javax.swing.JLabel();
        jLabelTCarisma = new javax.swing.JLabel();
        jLabelTCAR = new javax.swing.JLabel();
        jLabelTSeleccionaPersonaje = new javax.swing.JLabel();
        jComboBoxListaPersonajes = new javax.swing.JComboBox<>();
        jLabelAlineamiento = new javax.swing.JLabel();
        jLabelTALineamiento = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelTNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelTApellido = new javax.swing.JLabel();
        jLabelRaza = new javax.swing.JLabel();
        jLabelTRaza = new javax.swing.JLabel();
        jLabelClase = new javax.swing.JLabel();
        jLabelTClase = new javax.swing.JLabel();
        jLabelDios = new javax.swing.JLabel();
        jLabelTDios = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelTSexo = new javax.swing.JLabel();
        jLabelFuerza = new javax.swing.JLabel();
        jLabelDestreza = new javax.swing.JLabel();
        jLabelConstitucion = new javax.swing.JLabel();
        jLabelInteligencia = new javax.swing.JLabel();
        jLabelSabiduria = new javax.swing.JLabel();
        jLabelCarisma = new javax.swing.JLabel();
        jLabelThabilidades = new javax.swing.JLabel();
        jLabelAcrobacias = new javax.swing.JLabel();
        jLabelTAcrobacias = new javax.swing.JLabel();
        jLabelArtesania1 = new javax.swing.JLabel();
        jLabelTArtesania1 = new javax.swing.JLabel();
        jLabelArtesania2 = new javax.swing.JLabel();
        jLabelTArtesania2 = new javax.swing.JLabel();
        jLabelArtesania3 = new javax.swing.JLabel();
        jLabelTArtesania3 = new javax.swing.JLabel();
        jLabelAveriguarIntenciones = new javax.swing.JLabel();
        jLabelTAveriguarIntenciones = new javax.swing.JLabel();
        jLabelConocimientoConjuros = new javax.swing.JLabel();
        jLabelTConocimientoConjuros = new javax.swing.JLabel();
        jLabelCurar = new javax.swing.JLabel();
        jLabelTCurar = new javax.swing.JLabel();
        jLabelDiplomacia = new javax.swing.JLabel();
        jLabelTDiplomacia = new javax.swing.JLabel();
        jLabelDisfrazarse = new javax.swing.JLabel();
        jLabelTDisfrazarse = new javax.swing.JLabel();
        jLabelEngannar = new javax.swing.JLabel();
        jLabelTEngannar = new javax.swing.JLabel();
        jLabelEscapismo = new javax.swing.JLabel();
        jLabelTEscapismo = new javax.swing.JLabel();
        jLabelInterpretar1 = new javax.swing.JLabel();
        jLabelTInterpretar1 = new javax.swing.JLabel();
        jLabelNivel = new javax.swing.JLabel();
        jLabelTNivel = new javax.swing.JLabel();
        jLabelOjos = new javax.swing.JLabel();
        jLabelTOjos = new javax.swing.JLabel();
        jLabelCabello = new javax.swing.JLabel();
        jLabelTCabello = new javax.swing.JLabel();
        jLabelPeso = new javax.swing.JLabel();
        jLabelTPeso = new javax.swing.JLabel();
        jLabelEdad = new javax.swing.JLabel();
        jLabelTEdad = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jLabelTAltura = new javax.swing.JLabel();
        jLabelVelocidad = new javax.swing.JLabel();
        jLabelTVelocidad = new javax.swing.JLabel();
        jLabelPtsGolpe = new javax.swing.JLabel();
        jLabelTPtsGolpe = new javax.swing.JLabel();
        jLabelInterpretar2 = new javax.swing.JLabel();
        jLabelTInterpretar2 = new javax.swing.JLabel();
        jLabelIntimidar = new javax.swing.JLabel();
        jLabelTIntimidar = new javax.swing.JLabel();
        jLabelInutilizarMecanismo = new javax.swing.JLabel();
        jLabelTInutilizarMecanismo = new javax.swing.JLabel();
        jLabelJuegoDeManos = new javax.swing.JLabel();
        jLabelTJuegosDeManos = new javax.swing.JLabel();
        jLabelLinguistica = new javax.swing.JLabel();
        jLabelTLinguistica = new javax.swing.JLabel();
        jLabelMontar = new javax.swing.JLabel();
        jLabelTMontar = new javax.swing.JLabel();
        jLabelPercepcion = new javax.swing.JLabel();
        jLabelTPercepcion = new javax.swing.JLabel();
        jLabelProfesion1 = new javax.swing.JLabel();
        jLabelTProfesion1 = new javax.swing.JLabel();
        jLabelProfesion2 = new javax.swing.JLabel();
        jLabelTProfesion2 = new javax.swing.JLabel();
        jLabelSaberArcano = new javax.swing.JLabel();
        jLabelTSaberArcano = new javax.swing.JLabel();
        jLabelSaberDungeons = new javax.swing.JLabel();
        jLabelTSaberDungeons = new javax.swing.JLabel();
        jLabelSaberGeografia = new javax.swing.JLabel();
        jLabelTSaberGeografia = new javax.swing.JLabel();
        jLabelSaberHistoria = new javax.swing.JLabel();
        jLabelTSaberHistoria = new javax.swing.JLabel();
        jLabelSaberIngenieria = new javax.swing.JLabel();
        jLabelTSaberIngenieria = new javax.swing.JLabel();
        jLabelSaberLocal = new javax.swing.JLabel();
        jLabelTSaberLocal = new javax.swing.JLabel();
        jLabelSaberLosPlanos = new javax.swing.JLabel();
        jLabelTSaberLosPlanos = new javax.swing.JLabel();
        jLabelSaberNaturaleza = new javax.swing.JLabel();
        jLabelTSaberNaturaleza = new javax.swing.JLabel();
        jLabelSaberNobleza = new javax.swing.JLabel();
        jLabelTSaberNobleza = new javax.swing.JLabel();
        jLabelSaberReligion = new javax.swing.JLabel();
        jLabelTSaberReligion = new javax.swing.JLabel();
        jLabelSigilo = new javax.swing.JLabel();
        jLabelTSigilo = new javax.swing.JLabel();
        jLabelSupervivencia = new javax.swing.JLabel();
        jLabelTSupervivencia = new javax.swing.JLabel();
        jLabelTasacion = new javax.swing.JLabel();
        jLabelTTasacion = new javax.swing.JLabel();
        jLabelTratoConAnimales = new javax.swing.JLabel();
        jLabelTTratoConAnimales = new javax.swing.JLabel();
        jLabelTrepar = new javax.swing.JLabel();
        jLabelTTrepar = new javax.swing.JLabel();
        jLabelUsarObjetoMagico = new javax.swing.JLabel();
        jLabelTUsarObjetoMagico = new javax.swing.JLabel();
        jLabelVolar = new javax.swing.JLabel();
        jLabelTVolar = new javax.swing.JLabel();
        jComboBoxArmas = new javax.swing.JComboBox<>();
        jLabelTArmaduras = new javax.swing.JLabel();
        jComboBoxArmaduras = new javax.swing.JComboBox<>();
        jLabelTObjetos = new javax.swing.JLabel();
        jComboBoxObjetos = new javax.swing.JComboBox<>();
        jLabelTDotes = new javax.swing.JLabel();
        jComboBoxDotes = new javax.swing.JComboBox<>();
        jLabelTHabilidadesDeClase = new javax.swing.JLabel();
        jComboBoxHabilidadesDeClase = new javax.swing.JComboBox<>();
        jComboBoxHechizos = new javax.swing.JComboBox<>();
        jButtonAnnadirObjeto = new javax.swing.JButton();
        jButtonAnnadirArmadura = new javax.swing.JButton();
        jButtonAnnadirDote = new javax.swing.JButton();
        jButtonAnnadirHechizo = new javax.swing.JButton();
        jButtonAnnadirHabilidadDeClase = new javax.swing.JButton();
        jButtonAnnadirArma = new javax.swing.JButton();
        jButtonDetallesArmaduras = new javax.swing.JButton();
        jButtonDetallesArmas = new javax.swing.JButton();
        jButtonDetallesHabilidadesDeClase = new javax.swing.JButton();
        jButtonDetallesHechizos = new javax.swing.JButton();
        jButtonDetallesObjetos = new javax.swing.JButton();
        jButtonDetallesDotes = new javax.swing.JButton();
        jLabelTHechizos = new javax.swing.JLabel();
        jLabelTArmas = new javax.swing.JLabel();
        jLabelNadar = new javax.swing.JLabel();
        jLabelTNadar = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuConexion = new javax.swing.JMenu();
        jMenuItemConectarBBDD = new javax.swing.JMenuItem();
        jMenuItemIniciarSesion = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        jMenuItemArmas = new javax.swing.JMenuItem();
        jMenuItemArmaduras = new javax.swing.JMenuItem();
        jMenuItemobjetos = new javax.swing.JMenuItem();
        jMenuItemDotes = new javax.swing.JMenuItem();
        jMenuItemHabilidadesDeClase = new javax.swing.JMenuItem();
        jMenuItemhechizos = new javax.swing.JMenuItem();
        jMenuAnnadirPJ = new javax.swing.JMenu();
        jMenuModificarPJ = new javax.swing.JMenu();
        jMenuModificarPJ1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTFuerza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTFuerza.setText("Fuerza");
        getContentPane().add(jLabelTFuerza, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabelTFUE.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTFUE.setText("FUE");
        getContentPane().add(jLabelTFUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabelTDestreza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDestreza.setText("Destreza");
        getContentPane().add(jLabelTDestreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabelTDES.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTDES.setText("DES");
        getContentPane().add(jLabelTDES, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabelTConstitucion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTConstitucion.setText("Constitucion");
        getContentPane().add(jLabelTConstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabelTCON.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTCON.setText("CON");
        getContentPane().add(jLabelTCON, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabelTInteligencia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInteligencia.setText("Inteligencia");
        getContentPane().add(jLabelTInteligencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabelTINT.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTINT.setText("INT");
        getContentPane().add(jLabelTINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jLabelTSabiduria.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSabiduria.setText("Sabiduria");
        getContentPane().add(jLabelTSabiduria, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabelTSAB.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTSAB.setText("SAB");
        getContentPane().add(jLabelTSAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabelTCarisma.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCarisma.setText("Carisma");
        getContentPane().add(jLabelTCarisma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        jLabelTCAR.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTCAR.setText("CAR");
        getContentPane().add(jLabelTCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jLabelTSeleccionaPersonaje.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSeleccionaPersonaje.setText("Seleccionar personaje");
        getContentPane().add(jLabelTSeleccionaPersonaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jComboBoxListaPersonajes.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxListaPersonajes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxListaPersonajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListaPersonajesActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxListaPersonajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 181, -1));

        jLabelAlineamiento.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelAlineamiento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAlineamiento.setText("Maligno Caotico");
        jLabelAlineamiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelAlineamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 150, 20));

        jLabelTALineamiento.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTALineamiento.setText("Alineamiento");
        getContentPane().add(jLabelTALineamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, -1, -1));

        jLabelNombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNombre.setText("Caladrel");
        jLabelNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 200, 20));

        jLabelTNombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNombre.setText("Nombre");
        getContentPane().add(jLabelTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        jLabelApellido.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelApellido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelApellido.setText("Faënor");
        jLabelApellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 180, 20));

        jLabelTApellido.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTApellido.setText("Apellido");
        getContentPane().add(jLabelTApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        jLabelRaza.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelRaza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRaza.setText("Elfo");
        jLabelRaza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 160, 20));

        jLabelTRaza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTRaza.setText("Raza");
        getContentPane().add(jLabelTRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        jLabelClase.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelClase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelClase.setText("Mago");
        jLabelClase.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 150, 20));

        jLabelTClase.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTClase.setText("Clase");
        getContentPane().add(jLabelTClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jLabelDios.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelDios.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDios.setText("Pastafari");
        jLabelDios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDios, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 150, 20));

        jLabelTDios.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDios.setText("Dios");
        getContentPane().add(jLabelTDios, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, -1));

        jLabelSexo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSexo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSexo.setText("Hombre");
        jLabelSexo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 80, 20));

        jLabelTSexo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSexo.setText("Sexo");
        getContentPane().add(jLabelTSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        jLabelFuerza.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelFuerza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFuerza.setText("99");
        jLabelFuerza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelFuerza, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 51, 40));

        jLabelDestreza.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelDestreza.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDestreza.setText("99");
        jLabelDestreza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDestreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 51, 40));

        jLabelConstitucion.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelConstitucion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConstitucion.setText("99");
        jLabelConstitucion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelConstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 51, 40));

        jLabelInteligencia.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelInteligencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInteligencia.setText("99");
        jLabelInteligencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelInteligencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 51, 40));

        jLabelSabiduria.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelSabiduria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSabiduria.setText("99");
        jLabelSabiduria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSabiduria, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 51, 40));

        jLabelCarisma.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelCarisma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarisma.setText("99");
        jLabelCarisma.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelCarisma, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 51, 40));

        jLabelThabilidades.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelThabilidades.setText("Hablidades");
        getContentPane().add(jLabelThabilidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        jLabelAcrobacias.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelAcrobacias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAcrobacias.setText("99");
        jLabelAcrobacias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelAcrobacias, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 26, 20));

        jLabelTAcrobacias.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAcrobacias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTAcrobacias.setText("Acrobacias");
        getContentPane().add(jLabelTAcrobacias, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jLabelArtesania1.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelArtesania1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelArtesania1.setText("99");
        jLabelArtesania1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelArtesania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 26, 20));

        jLabelTArtesania1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTArtesania1.setText("Artesania");
        getContentPane().add(jLabelTArtesania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        jLabelArtesania2.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelArtesania2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelArtesania2.setText("99");
        jLabelArtesania2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelArtesania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 26, 20));

        jLabelTArtesania2.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTArtesania2.setText("Artesania");
        getContentPane().add(jLabelTArtesania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jLabelArtesania3.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelArtesania3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelArtesania3.setText("99");
        jLabelArtesania3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelArtesania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 26, 20));

        jLabelTArtesania3.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTArtesania3.setText("Artesania");
        getContentPane().add(jLabelTArtesania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        jLabelAveriguarIntenciones.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelAveriguarIntenciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAveriguarIntenciones.setText("99");
        jLabelAveriguarIntenciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelAveriguarIntenciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 26, 20));

        jLabelTAveriguarIntenciones.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAveriguarIntenciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTAveriguarIntenciones.setText("Averiguar Intenciones");
        getContentPane().add(jLabelTAveriguarIntenciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabelConocimientoConjuros.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelConocimientoConjuros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelConocimientoConjuros.setText("99");
        jLabelConocimientoConjuros.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelConocimientoConjuros, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 26, 20));

        jLabelTConocimientoConjuros.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTConocimientoConjuros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTConocimientoConjuros.setText("Conocimiento de Conjuros");
        getContentPane().add(jLabelTConocimientoConjuros, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabelCurar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelCurar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCurar.setText("99");
        jLabelCurar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelCurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 26, 20));

        jLabelTCurar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCurar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTCurar.setText("Curar");
        getContentPane().add(jLabelTCurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, -1, -1));

        jLabelDiplomacia.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelDiplomacia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDiplomacia.setText("99");
        jLabelDiplomacia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDiplomacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 26, 20));

        jLabelTDiplomacia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDiplomacia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTDiplomacia.setText("Diplomacia");
        getContentPane().add(jLabelTDiplomacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, -1));

        jLabelDisfrazarse.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelDisfrazarse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDisfrazarse.setText("99");
        jLabelDisfrazarse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDisfrazarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 26, 20));

        jLabelTDisfrazarse.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDisfrazarse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTDisfrazarse.setText("Disfrazarse");
        getContentPane().add(jLabelTDisfrazarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        jLabelEngannar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelEngannar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEngannar.setText("99");
        jLabelEngannar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelEngannar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 26, 20));

        jLabelTEngannar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEngannar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTEngannar.setText("Engañar");
        getContentPane().add(jLabelTEngannar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, -1, -1));

        jLabelEscapismo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelEscapismo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEscapismo.setText("99");
        jLabelEscapismo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelEscapismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 26, 20));

        jLabelTEscapismo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEscapismo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTEscapismo.setText("Escapismo");
        getContentPane().add(jLabelTEscapismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

        jLabelInterpretar1.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelInterpretar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelInterpretar1.setText("99");
        jLabelInterpretar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelInterpretar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 26, 20));

        jLabelTInterpretar1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInterpretar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTInterpretar1.setText("Interpretar");
        getContentPane().add(jLabelTInterpretar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, -1, -1));

        jLabelNivel.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelNivel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNivel.setText("Nivel");
        jLabelNivel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 50, 20));

        jLabelTNivel.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNivel.setText("Nivel");
        getContentPane().add(jLabelTNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, -1, -1));

        jLabelOjos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelOjos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelOjos.setText("Ojos");
        jLabelOjos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelOjos, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 80, 20));

        jLabelTOjos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTOjos.setText("Ojos");
        getContentPane().add(jLabelTOjos, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, -1));

        jLabelCabello.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelCabello.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCabello.setText("Cabello");
        jLabelCabello.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelCabello, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 80, 20));

        jLabelTCabello.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCabello.setText("Cabello");
        getContentPane().add(jLabelTCabello, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, -1, -1));

        jLabelPeso.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelPeso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPeso.setText("Peso");
        jLabelPeso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 80, 20));

        jLabelTPeso.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTPeso.setText("Peso");
        getContentPane().add(jLabelTPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, -1, -1));

        jLabelEdad.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelEdad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEdad.setText("Edad");
        jLabelEdad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 80, 20));

        jLabelTEdad.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEdad.setText("Edad");
        getContentPane().add(jLabelTEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        jLabelAltura.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelAltura.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAltura.setText("Altura");
        jLabelAltura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 80, 20));

        jLabelTAltura.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAltura.setText("Altura");
        getContentPane().add(jLabelTAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        jLabelVelocidad.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelVelocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVelocidad.setText("99");
        jLabelVelocidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelVelocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, 63, 40));

        jLabelTVelocidad.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTVelocidad.setText("Velocidad");
        getContentPane().add(jLabelTVelocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, -1, -1));

        jLabelPtsGolpe.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelPtsGolpe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPtsGolpe.setText("99");
        jLabelPtsGolpe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelPtsGolpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 63, 40));

        jLabelTPtsGolpe.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTPtsGolpe.setText("Pts. Golpe");
        getContentPane().add(jLabelTPtsGolpe, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, -1, -1));

        jLabelInterpretar2.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelInterpretar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelInterpretar2.setText("99");
        jLabelInterpretar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelInterpretar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 26, 20));

        jLabelTInterpretar2.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInterpretar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTInterpretar2.setText("Interpretar");
        getContentPane().add(jLabelTInterpretar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, -1, -1));

        jLabelIntimidar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelIntimidar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelIntimidar.setText("99");
        jLabelIntimidar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelIntimidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 650, 26, 20));

        jLabelTIntimidar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTIntimidar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTIntimidar.setText("Intimidar");
        getContentPane().add(jLabelTIntimidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, -1, -1));

        jLabelInutilizarMecanismo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelInutilizarMecanismo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelInutilizarMecanismo.setText("99");
        jLabelInutilizarMecanismo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelInutilizarMecanismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 680, 26, 20));

        jLabelTInutilizarMecanismo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInutilizarMecanismo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTInutilizarMecanismo.setText("Inutilizar Mecanismo");
        getContentPane().add(jLabelTInutilizarMecanismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, -1, -1));

        jLabelJuegoDeManos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelJuegoDeManos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelJuegoDeManos.setText("99");
        jLabelJuegoDeManos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelJuegoDeManos, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 710, 26, 20));

        jLabelTJuegosDeManos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTJuegosDeManos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTJuegosDeManos.setText("Juego de Manos");
        getContentPane().add(jLabelTJuegosDeManos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, -1, -1));

        jLabelLinguistica.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelLinguistica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelLinguistica.setText("99");
        jLabelLinguistica.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelLinguistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 26, 20));

        jLabelTLinguistica.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTLinguistica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTLinguistica.setText("Lingüistica");
        getContentPane().add(jLabelTLinguistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 740, -1, -1));

        jLabelMontar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelMontar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelMontar.setText("99");
        jLabelMontar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelMontar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 770, 26, 20));

        jLabelTMontar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTMontar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTMontar.setText("Montar");
        getContentPane().add(jLabelTMontar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 770, -1, -1));

        jLabelPercepcion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelPercepcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPercepcion.setText("99");
        jLabelPercepcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelPercepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 26, 20));

        jLabelTPercepcion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTPercepcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTPercepcion.setText("Percepcion");
        getContentPane().add(jLabelTPercepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        jLabelProfesion1.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelProfesion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelProfesion1.setText("99");
        jLabelProfesion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelProfesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 26, 20));

        jLabelTProfesion1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTProfesion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTProfesion1.setText("Profesion");
        getContentPane().add(jLabelTProfesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, -1, -1));

        jLabelProfesion2.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelProfesion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelProfesion2.setText("99");
        jLabelProfesion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelProfesion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 26, 20));

        jLabelTProfesion2.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTProfesion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTProfesion2.setText("Profesion");
        getContentPane().add(jLabelTProfesion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        jLabelSaberArcano.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberArcano.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberArcano.setText("99");
        jLabelSaberArcano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberArcano, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 26, 20));

        jLabelTSaberArcano.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberArcano.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberArcano.setText("Saber (Arcano)");
        getContentPane().add(jLabelTSaberArcano, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        jLabelSaberDungeons.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberDungeons.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberDungeons.setText("99");
        jLabelSaberDungeons.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberDungeons, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 26, 20));

        jLabelTSaberDungeons.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberDungeons.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberDungeons.setText("Saber (Dugeons");
        getContentPane().add(jLabelTSaberDungeons, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        jLabelSaberGeografia.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberGeografia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberGeografia.setText("99");
        jLabelSaberGeografia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberGeografia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 26, 20));

        jLabelTSaberGeografia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberGeografia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberGeografia.setText("Saber (Geografia) ");
        getContentPane().add(jLabelTSaberGeografia, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        jLabelSaberHistoria.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberHistoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberHistoria.setText("99");
        jLabelSaberHistoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 26, 20));

        jLabelTSaberHistoria.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberHistoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberHistoria.setText("Saber (Historia)");
        getContentPane().add(jLabelTSaberHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        jLabelSaberIngenieria.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberIngenieria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberIngenieria.setText("99");
        jLabelSaberIngenieria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberIngenieria, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 26, 20));

        jLabelTSaberIngenieria.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberIngenieria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberIngenieria.setText("Saber (Ingenieria)");
        getContentPane().add(jLabelTSaberIngenieria, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        jLabelSaberLocal.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberLocal.setText("99");
        jLabelSaberLocal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 26, 20));

        jLabelTSaberLocal.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberLocal.setText("Saber (Local)");
        getContentPane().add(jLabelTSaberLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, -1, -1));

        jLabelSaberLosPlanos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberLosPlanos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberLosPlanos.setText("99");
        jLabelSaberLosPlanos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberLosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 26, 20));

        jLabelTSaberLosPlanos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberLosPlanos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberLosPlanos.setText("Saber (Los Planos)");
        getContentPane().add(jLabelTSaberLosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, -1, -1));

        jLabelSaberNaturaleza.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberNaturaleza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberNaturaleza.setText("99");
        jLabelSaberNaturaleza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberNaturaleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 26, 20));

        jLabelTSaberNaturaleza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberNaturaleza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberNaturaleza.setText("Saber (Naturaleza)");
        getContentPane().add(jLabelTSaberNaturaleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, -1, -1));

        jLabelSaberNobleza.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberNobleza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberNobleza.setText("99");
        jLabelSaberNobleza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberNobleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 26, 20));

        jLabelTSaberNobleza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberNobleza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberNobleza.setText("Saber (Nobleza)");
        getContentPane().add(jLabelTSaberNobleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, -1, -1));

        jLabelSaberReligion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSaberReligion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSaberReligion.setText("99");
        jLabelSaberReligion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSaberReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 590, 26, 20));

        jLabelTSaberReligion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberReligion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberReligion.setText("Saber (Religion)");
        getContentPane().add(jLabelTSaberReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, -1, -1));

        jLabelSigilo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSigilo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSigilo.setText("99");
        jLabelSigilo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSigilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 26, 20));

        jLabelTSigilo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSigilo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSigilo.setText("Sigilo");
        getContentPane().add(jLabelTSigilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 620, -1, -1));

        jLabelSupervivencia.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelSupervivencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelSupervivencia.setText("99");
        jLabelSupervivencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelSupervivencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 650, 26, 20));

        jLabelTSupervivencia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSupervivencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSupervivencia.setText("Supervivencia");
        getContentPane().add(jLabelTSupervivencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, -1));

        jLabelTasacion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelTasacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTasacion.setText("99");
        jLabelTasacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelTasacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 680, 26, 20));

        jLabelTTasacion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTasacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTTasacion.setText("Tasacion");
        getContentPane().add(jLabelTTasacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 680, -1, -1));

        jLabelTratoConAnimales.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelTratoConAnimales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTratoConAnimales.setText("99");
        jLabelTratoConAnimales.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelTratoConAnimales, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 710, 26, 20));

        jLabelTTratoConAnimales.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTratoConAnimales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTTratoConAnimales.setText("Trato con Animales");
        getContentPane().add(jLabelTTratoConAnimales, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 710, -1, -1));

        jLabelTrepar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelTrepar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTrepar.setText("99");
        jLabelTrepar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelTrepar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 740, 26, 20));

        jLabelTTrepar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTrepar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTTrepar.setText("Trepar");
        getContentPane().add(jLabelTTrepar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 740, -1, -1));

        jLabelUsarObjetoMagico.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelUsarObjetoMagico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsarObjetoMagico.setText("99");
        jLabelUsarObjetoMagico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelUsarObjetoMagico, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 770, 26, 20));

        jLabelTUsarObjetoMagico.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTUsarObjetoMagico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTUsarObjetoMagico.setText("Usar Objeto Magico");
        getContentPane().add(jLabelTUsarObjetoMagico, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 770, -1, -1));

        jLabelVolar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelVolar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVolar.setText("99");
        jLabelVolar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelVolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 800, 26, 20));

        jLabelTVolar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTVolar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTVolar.setText("Volar");
        getContentPane().add(jLabelTVolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 800, -1, -1));

        jComboBoxArmas.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxArmas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 420, -1));

        jLabelTArmaduras.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelTArmaduras.setText("Armaduras");
        getContentPane().add(jLabelTArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, -1, -1));

        jComboBoxArmaduras.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxArmaduras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 420, -1));

        jLabelTObjetos.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelTObjetos.setText("Objetos");
        getContentPane().add(jLabelTObjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, -1, -1));

        jComboBoxObjetos.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxObjetos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxObjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 420, -1));

        jLabelTDotes.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelTDotes.setText("Dotes");
        getContentPane().add(jLabelTDotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 530, -1, -1));

        jComboBoxDotes.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxDotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxDotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 420, -1));

        jLabelTHabilidadesDeClase.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelTHabilidadesDeClase.setText("Habilidades de Clase");
        getContentPane().add(jLabelTHabilidadesDeClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, -1, -1));

        jComboBoxHabilidadesDeClase.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxHabilidadesDeClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxHabilidadesDeClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 640, 420, -1));

        jComboBoxHechizos.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jComboBoxHechizos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxHechizos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 720, 420, -1));

        jButtonAnnadirObjeto.setBackground(new java.awt.Color(190, 31, 44));
        jButtonAnnadirObjeto.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonAnnadirObjeto.setText("+");
        getContentPane().add(jButtonAnnadirObjeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, -1, -1));

        jButtonAnnadirArmadura.setBackground(new java.awt.Color(190, 31, 44));
        jButtonAnnadirArmadura.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonAnnadirArmadura.setText("+");
        getContentPane().add(jButtonAnnadirArmadura, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, -1, -1));

        jButtonAnnadirDote.setBackground(new java.awt.Color(190, 31, 44));
        jButtonAnnadirDote.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonAnnadirDote.setText("+");
        getContentPane().add(jButtonAnnadirDote, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 580, -1, -1));

        jButtonAnnadirHechizo.setBackground(new java.awt.Color(190, 31, 44));
        jButtonAnnadirHechizo.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonAnnadirHechizo.setText("+");
        getContentPane().add(jButtonAnnadirHechizo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 750, -1, -1));

        jButtonAnnadirHabilidadDeClase.setBackground(new java.awt.Color(190, 31, 44));
        jButtonAnnadirHabilidadDeClase.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonAnnadirHabilidadDeClase.setText("+");
        getContentPane().add(jButtonAnnadirHabilidadDeClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, -1, -1));

        jButtonAnnadirArma.setBackground(new java.awt.Color(190, 31, 44));
        jButtonAnnadirArma.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonAnnadirArma.setText("+");
        jButtonAnnadirArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnadirArmaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAnnadirArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, -1, -1));

        jButtonDetallesArmaduras.setBackground(new java.awt.Color(190, 31, 44));
        jButtonDetallesArmaduras.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonDetallesArmaduras.setText("Detalles");
        getContentPane().add(jButtonDetallesArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, -1, -1));

        jButtonDetallesArmas.setBackground(new java.awt.Color(190, 31, 44));
        jButtonDetallesArmas.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonDetallesArmas.setText("Detalles");
        jButtonDetallesArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetallesArmasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDetallesArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, -1, -1));

        jButtonDetallesHabilidadesDeClase.setBackground(new java.awt.Color(190, 31, 44));
        jButtonDetallesHabilidadesDeClase.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonDetallesHabilidadesDeClase.setText("Detalles");
        getContentPane().add(jButtonDetallesHabilidadesDeClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, -1, -1));

        jButtonDetallesHechizos.setBackground(new java.awt.Color(190, 31, 44));
        jButtonDetallesHechizos.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonDetallesHechizos.setText("Detalles");
        getContentPane().add(jButtonDetallesHechizos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 750, -1, -1));

        jButtonDetallesObjetos.setBackground(new java.awt.Color(190, 31, 44));
        jButtonDetallesObjetos.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonDetallesObjetos.setText("Detalles");
        getContentPane().add(jButtonDetallesObjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, -1, -1));

        jButtonDetallesDotes.setBackground(new java.awt.Color(190, 31, 44));
        jButtonDetallesDotes.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jButtonDetallesDotes.setText("Detalles");
        getContentPane().add(jButtonDetallesDotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, -1, -1));

        jLabelTHechizos.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelTHechizos.setText("Hechizos");
        getContentPane().add(jLabelTHechizos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 700, -1, -1));

        jLabelTArmas.setFont(new java.awt.Font("Pokemon Classic", 1, 10)); // NOI18N
        jLabelTArmas.setText("Armas");
        getContentPane().add(jLabelTArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        jLabelNadar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelNadar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNadar.setText("99");
        jLabelNadar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelNadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 800, 26, 20));

        jLabelTNadar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNadar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTNadar.setText("Nadar");
        getContentPane().add(jLabelTNadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 800, -1, -1));

        jMenuBar.setBackground(new java.awt.Color(190, 31, 44));
        jMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuConexion.setBackground(new java.awt.Color(190, 31, 44));
        jMenuConexion.setText("Conexion");
        jMenuConexion.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N

        jMenuItemConectarBBDD.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemConectarBBDD.setText("Desconectar");
        jMenuItemConectarBBDD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemConectarBBDDMousePressed(evt);
            }
        });
        jMenuConexion.add(jMenuItemConectarBBDD);

        jMenuItemIniciarSesion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemIniciarSesion.setText("Iniciar Sesion");
        jMenuItemIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItemIniciarSesionMousePressed(evt);
            }
        });
        jMenuConexion.add(jMenuItemIniciarSesion);

        jMenuBar.add(jMenuConexion);

        jMenuConsultas.setBackground(new java.awt.Color(190, 31, 44));
        jMenuConsultas.setText("Consultar");
        jMenuConsultas.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jMenuConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuConsultasMousePressed(evt);
            }
        });
        jMenuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuConsultasActionPerformed(evt);
            }
        });

        jMenuItemArmas.setBackground(new java.awt.Color(190, 31, 44));
        jMenuItemArmas.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemArmas.setText("Armas");
        jMenuItemArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArmasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemArmas);

        jMenuItemArmaduras.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemArmaduras.setText("Armaduras");
        jMenuItemArmaduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemArmadurasActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemArmaduras);

        jMenuItemobjetos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemobjetos.setText("Objetos");
        jMenuConsultas.add(jMenuItemobjetos);

        jMenuItemDotes.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemDotes.setText("Dotes");
        jMenuConsultas.add(jMenuItemDotes);

        jMenuItemHabilidadesDeClase.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemHabilidadesDeClase.setText("Habilidades de Clase");
        jMenuConsultas.add(jMenuItemHabilidadesDeClase);

        jMenuItemhechizos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jMenuItemhechizos.setText("Hechizos");
        jMenuConsultas.add(jMenuItemhechizos);

        jMenuBar.add(jMenuConsultas);

        jMenuAnnadirPJ.setBackground(new java.awt.Color(190, 31, 44));
        jMenuAnnadirPJ.setText("Añadir Personaje");
        jMenuAnnadirPJ.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jMenuAnnadirPJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuAnnadirPJMousePressed(evt);
            }
        });
        jMenuBar.add(jMenuAnnadirPJ);

        jMenuModificarPJ.setBackground(new java.awt.Color(190, 31, 44));
        jMenuModificarPJ.setText("Modificar Personaje");
        jMenuModificarPJ.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jMenuModificarPJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuModificarPJMousePressed(evt);
            }
        });
        jMenuBar.add(jMenuModificarPJ);

        jMenuModificarPJ1.setBackground(new java.awt.Color(190, 31, 44));
        jMenuModificarPJ1.setText("Borrar Personaje");
        jMenuModificarPJ1.setFont(new java.awt.Font("Pokemon Classic", 0, 9)); // NOI18N
        jMenuModificarPJ1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuModificarPJ1MousePressed(evt);
            }
        });
        jMenuBar.add(jMenuModificarPJ1);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemIniciarSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemIniciarSesionMousePressed
        inicioSesion.setVisible(true);
    }//GEN-LAST:event_jMenuItemIniciarSesionMousePressed

    private void jMenuItemConectarBBDDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemConectarBBDDMousePressed
        switch (jMenuItemConectarBBDD.getText()) {
            case "Conectar":
                miConexion.abrir_Conexion();
                jMenuItemConectarBBDD.setText("Desconectar");
                System.out.println("Abrir");
                break;
            case "Desconectar":
                miConexion.cerrar_conexion();
                jMenuItemConectarBBDD.setText("Conectar");
                System.out.println("Cerrar");
                break;
        }

    }//GEN-LAST:event_jMenuItemConectarBBDDMousePressed

    private void jComboBoxListaPersonajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListaPersonajesActionPerformed
        try {
            actualizaPersonaje(jComboBoxListaPersonajes.getSelectedIndex());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jComboBoxListaPersonajesActionPerformed

    private void jButtonDetallesArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetallesArmasActionPerformed
        ventanaDetallesArmas.setVisible(true);
        ventanaDetallesArmas.estableceTabla(armas);
        ventanaDetallesArmas.abreVentanaAnnadir(false);
    }//GEN-LAST:event_jButtonDetallesArmasActionPerformed

    private void jMenuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuConsultasActionPerformed

    }//GEN-LAST:event_jMenuConsultasActionPerformed

    private void jMenuConsultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuConsultasMousePressed

    }//GEN-LAST:event_jMenuConsultasMousePressed

    private void jMenuItemArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArmasActionPerformed
        if (usuarioConectado) {
            ventanaDetallesArmas.setVisible(true);
            ventanaDetallesArmas.cambioDeTabla();
            ventanaDetallesArmas.estableceTabla(devuelveTodasLasArmas());
            ventanaDetallesArmas.abriendoVentanaTotal();
            ventanaDetallesArmas.abreVentanaAnnadir(false);
        }
    }//GEN-LAST:event_jMenuItemArmasActionPerformed

    private void jButtonAnnadirArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnadirArmaActionPerformed
        if (usuarioConectado) {
            ventanaDetallesArmas.setVisible(true);
            ventanaDetallesArmas.cambioDeTabla();
            ventanaDetallesArmas.estableceTabla(devuelveTodasLasArmas());
            ventanaDetallesArmas.abriendoVentanaTotal();
            ventanaDetallesArmas.abreVentanaAnnadir(true);
            ventanaDetallesArmas.guardaConexion(miConexion, personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString());
        }
    }//GEN-LAST:event_jButtonAnnadirArmaActionPerformed

    private void jMenuAnnadirPJMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAnnadirPJMousePressed
        if (usuarioConectado) {
            ventanaNuevoPersonaje.reseteaCampos();
            ventanaNuevoPersonaje.setVisible(true);
            ventanaNuevoPersonaje.abreModificacion(false, null, null, 0);

        }
    }//GEN-LAST:event_jMenuAnnadirPJMousePressed

    private void jMenuModificarPJMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuModificarPJMousePressed
        if (usuarioConectado) {
            ventanaNuevoPersonaje.setVisible(true);
            ventanaNuevoPersonaje.abreModificacion(true, personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString(), personajes, jComboBoxListaPersonajes.getSelectedIndex());
        }
    }//GEN-LAST:event_jMenuModificarPJMousePressed

    private void jMenuItemArmadurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemArmadurasActionPerformed

    }//GEN-LAST:event_jMenuItemArmadurasActionPerformed

    private void jMenuModificarPJ1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuModificarPJ1MousePressed
        if (usuarioConectado) {
            miConexion.borraPersonaje(personajes.getValueAt(jComboBoxListaPersonajes.getSelectedIndex(), 67).toString());
            descargaDatosPersonajes(miUsuario);
        }
    }//GEN-LAST:event_jMenuModificarPJ1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnadirArma;
    private javax.swing.JButton jButtonAnnadirArmadura;
    private javax.swing.JButton jButtonAnnadirDote;
    private javax.swing.JButton jButtonAnnadirHabilidadDeClase;
    private javax.swing.JButton jButtonAnnadirHechizo;
    private javax.swing.JButton jButtonAnnadirObjeto;
    private javax.swing.JButton jButtonDetallesArmaduras;
    private javax.swing.JButton jButtonDetallesArmas;
    private javax.swing.JButton jButtonDetallesDotes;
    private javax.swing.JButton jButtonDetallesHabilidadesDeClase;
    private javax.swing.JButton jButtonDetallesHechizos;
    private javax.swing.JButton jButtonDetallesObjetos;
    private javax.swing.JComboBox<String> jComboBoxArmaduras;
    private javax.swing.JComboBox<String> jComboBoxArmas;
    private javax.swing.JComboBox<String> jComboBoxDotes;
    private javax.swing.JComboBox<String> jComboBoxHabilidadesDeClase;
    private javax.swing.JComboBox<String> jComboBoxHechizos;
    public javax.swing.JComboBox<String> jComboBoxListaPersonajes;
    private javax.swing.JComboBox<String> jComboBoxObjetos;
    private javax.swing.JLabel jLabelAcrobacias;
    private javax.swing.JLabel jLabelAlineamiento;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelArtesania1;
    private javax.swing.JLabel jLabelArtesania2;
    private javax.swing.JLabel jLabelArtesania3;
    private javax.swing.JLabel jLabelAveriguarIntenciones;
    private javax.swing.JLabel jLabelCabello;
    private javax.swing.JLabel jLabelCarisma;
    private javax.swing.JLabel jLabelClase;
    private javax.swing.JLabel jLabelConocimientoConjuros;
    private javax.swing.JLabel jLabelConstitucion;
    private javax.swing.JLabel jLabelCurar;
    private javax.swing.JLabel jLabelDestreza;
    private javax.swing.JLabel jLabelDios;
    private javax.swing.JLabel jLabelDiplomacia;
    private javax.swing.JLabel jLabelDisfrazarse;
    private javax.swing.JLabel jLabelEdad;
    private javax.swing.JLabel jLabelEngannar;
    private javax.swing.JLabel jLabelEscapismo;
    private javax.swing.JLabel jLabelFuerza;
    private javax.swing.JLabel jLabelInteligencia;
    private javax.swing.JLabel jLabelInterpretar1;
    private javax.swing.JLabel jLabelInterpretar2;
    private javax.swing.JLabel jLabelIntimidar;
    private javax.swing.JLabel jLabelInutilizarMecanismo;
    private javax.swing.JLabel jLabelJuegoDeManos;
    private javax.swing.JLabel jLabelLinguistica;
    private javax.swing.JLabel jLabelMontar;
    private javax.swing.JLabel jLabelNadar;
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelOjos;
    private javax.swing.JLabel jLabelPercepcion;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelProfesion1;
    private javax.swing.JLabel jLabelProfesion2;
    private javax.swing.JLabel jLabelPtsGolpe;
    private javax.swing.JLabel jLabelRaza;
    private javax.swing.JLabel jLabelSaberArcano;
    private javax.swing.JLabel jLabelSaberDungeons;
    private javax.swing.JLabel jLabelSaberGeografia;
    private javax.swing.JLabel jLabelSaberHistoria;
    private javax.swing.JLabel jLabelSaberIngenieria;
    private javax.swing.JLabel jLabelSaberLocal;
    private javax.swing.JLabel jLabelSaberLosPlanos;
    private javax.swing.JLabel jLabelSaberNaturaleza;
    private javax.swing.JLabel jLabelSaberNobleza;
    private javax.swing.JLabel jLabelSaberReligion;
    private javax.swing.JLabel jLabelSabiduria;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelSigilo;
    private javax.swing.JLabel jLabelSupervivencia;
    private javax.swing.JLabel jLabelTALineamiento;
    private javax.swing.JLabel jLabelTAcrobacias;
    private javax.swing.JLabel jLabelTAltura;
    private javax.swing.JLabel jLabelTApellido;
    private javax.swing.JLabel jLabelTArmaduras;
    private javax.swing.JLabel jLabelTArmas;
    private javax.swing.JLabel jLabelTArtesania1;
    private javax.swing.JLabel jLabelTArtesania2;
    private javax.swing.JLabel jLabelTArtesania3;
    private javax.swing.JLabel jLabelTAveriguarIntenciones;
    private javax.swing.JLabel jLabelTCAR;
    private javax.swing.JLabel jLabelTCON;
    private javax.swing.JLabel jLabelTCabello;
    private javax.swing.JLabel jLabelTCarisma;
    private javax.swing.JLabel jLabelTClase;
    private javax.swing.JLabel jLabelTConocimientoConjuros;
    private javax.swing.JLabel jLabelTConstitucion;
    private javax.swing.JLabel jLabelTCurar;
    private javax.swing.JLabel jLabelTDES;
    private javax.swing.JLabel jLabelTDestreza;
    private javax.swing.JLabel jLabelTDios;
    private javax.swing.JLabel jLabelTDiplomacia;
    private javax.swing.JLabel jLabelTDisfrazarse;
    private javax.swing.JLabel jLabelTDotes;
    private javax.swing.JLabel jLabelTEdad;
    private javax.swing.JLabel jLabelTEngannar;
    private javax.swing.JLabel jLabelTEscapismo;
    private javax.swing.JLabel jLabelTFUE;
    private javax.swing.JLabel jLabelTFuerza;
    private javax.swing.JLabel jLabelTHabilidadesDeClase;
    private javax.swing.JLabel jLabelTHechizos;
    private javax.swing.JLabel jLabelTINT;
    private javax.swing.JLabel jLabelTInteligencia;
    private javax.swing.JLabel jLabelTInterpretar1;
    private javax.swing.JLabel jLabelTInterpretar2;
    private javax.swing.JLabel jLabelTIntimidar;
    private javax.swing.JLabel jLabelTInutilizarMecanismo;
    private javax.swing.JLabel jLabelTJuegosDeManos;
    private javax.swing.JLabel jLabelTLinguistica;
    private javax.swing.JLabel jLabelTMontar;
    private javax.swing.JLabel jLabelTNadar;
    private javax.swing.JLabel jLabelTNivel;
    private javax.swing.JLabel jLabelTNombre;
    private javax.swing.JLabel jLabelTObjetos;
    private javax.swing.JLabel jLabelTOjos;
    private javax.swing.JLabel jLabelTPercepcion;
    private javax.swing.JLabel jLabelTPeso;
    private javax.swing.JLabel jLabelTProfesion1;
    private javax.swing.JLabel jLabelTProfesion2;
    private javax.swing.JLabel jLabelTPtsGolpe;
    private javax.swing.JLabel jLabelTRaza;
    private javax.swing.JLabel jLabelTSAB;
    private javax.swing.JLabel jLabelTSaberArcano;
    private javax.swing.JLabel jLabelTSaberDungeons;
    private javax.swing.JLabel jLabelTSaberGeografia;
    private javax.swing.JLabel jLabelTSaberHistoria;
    private javax.swing.JLabel jLabelTSaberIngenieria;
    private javax.swing.JLabel jLabelTSaberLocal;
    private javax.swing.JLabel jLabelTSaberLosPlanos;
    private javax.swing.JLabel jLabelTSaberNaturaleza;
    private javax.swing.JLabel jLabelTSaberNobleza;
    private javax.swing.JLabel jLabelTSaberReligion;
    private javax.swing.JLabel jLabelTSabiduria;
    private javax.swing.JLabel jLabelTSeleccionaPersonaje;
    private javax.swing.JLabel jLabelTSexo;
    private javax.swing.JLabel jLabelTSigilo;
    private javax.swing.JLabel jLabelTSupervivencia;
    private javax.swing.JLabel jLabelTTasacion;
    private javax.swing.JLabel jLabelTTratoConAnimales;
    private javax.swing.JLabel jLabelTTrepar;
    private javax.swing.JLabel jLabelTUsarObjetoMagico;
    private javax.swing.JLabel jLabelTVelocidad;
    private javax.swing.JLabel jLabelTVolar;
    private javax.swing.JLabel jLabelTasacion;
    private javax.swing.JLabel jLabelThabilidades;
    private javax.swing.JLabel jLabelTratoConAnimales;
    private javax.swing.JLabel jLabelTrepar;
    private javax.swing.JLabel jLabelUsarObjetoMagico;
    private javax.swing.JLabel jLabelVelocidad;
    private javax.swing.JLabel jLabelVolar;
    private javax.swing.JMenu jMenuAnnadirPJ;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuConexion;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenuItem jMenuItemArmaduras;
    private javax.swing.JMenuItem jMenuItemArmas;
    private javax.swing.JMenuItem jMenuItemConectarBBDD;
    private javax.swing.JMenuItem jMenuItemDotes;
    private javax.swing.JMenuItem jMenuItemHabilidadesDeClase;
    private javax.swing.JMenuItem jMenuItemIniciarSesion;
    private javax.swing.JMenuItem jMenuItemhechizos;
    private javax.swing.JMenuItem jMenuItemobjetos;
    private javax.swing.JMenu jMenuModificarPJ;
    private javax.swing.JMenu jMenuModificarPJ1;
    // End of variables declaration//GEN-END:variables
}
