/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class NuevoPersonaje extends javax.swing.JFrame {

    GestorConexion miConexion;
    VentanaPrincipal vP;

    /**
     * Creates new form NuevoPersonaje
     */
    public NuevoPersonaje() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        resetetaCampos();
    }

    public void guardaConexion(GestorConexion conexion) {
        miConexion = conexion;
    }

    public void rellenaComboBox() {
        jComboBoxRaza.removeAllItems();
        jComboBoxClase.removeAllItems();

        ArrayList<String> aux = new ArrayList<>(miConexion.nombreClase());

        for (int i = 0; i < aux.size(); i++) {
            jComboBoxClase.addItem(aux.get(i));
        }

        aux = new ArrayList<>(miConexion.nombreRaza());
        for (int i = 0; i < aux.size(); i++) {
            jComboBoxRaza.addItem(aux.get(i));
        }
    }

    public void resetetaCampos() {
        //Ponemos en blanco todos los jLabels de habilidades que no sean Titulos
        jTextFieldAcrobacias.setText("");
        jTextFieldArtesania1.setText("");
        jTextFieldArtesania2.setText("");
        jTextFieldArtesania3.setText("");
        jTextFieldAveriguarIntenciones.setText("");
        jTextFieldConocimientoDeConjuro.setText("");
        jTextFieldCurar.setText("");
        jTextFieldDiplomacia.setText("");
        jTextFieldDisfrarse.setText("");
        jTextFieldEngannar.setText("");
        jTextFieldEscapismo.setText("");
        jTextFieldInterpretar1.setText("");
        jTextFieldInterpretar2.setText("");
        jTextFieldIntimidar.setText("");
        jTextFieldInutilizarMecanismo.setText("");
        jTextFieldJuegoDeManos.setText("");
        jTextFieldLinguistica.setText("");
        jTextFieldMontar.setText("");
        jTextFieldPercepcion.setText("");
        jTextFieldProfesion1.setText("");
        jTextFieldProfesion2.setText("");
        jTextFieldSaberArcano.setText("");
        jTextFieldSaberDungeons.setText("");
        jTextFieldSaberGeografia.setText("");
        jTextFieldSaberHistoria.setText("");
        jTextFieldSaberIngenieria.setText("");
        jTextFieldSaberLocal.setText("");
        jTextFieldSaberLosPlanos.setText("");
        jTextFieldSaberNaturaleza.setText("");
        jTextFieldSaberNobleza.setText("");
        jTextFieldSaberReligion.setText("");
        jTextFieldSigilo.setText("");
        jTextFieldSupervivencia.setText("");
        jTextFieldTasacion.setText("");
        jTextFieldTratoConAnimales.setText("");
        jTextFieldTrepar.setText("");
        jTextFieldUsarObjetoMagico.setText("");
        jTextFieldVolar.setText("");
        jTextFieldNadar.setText("");

        //Ahora reseteamos el resto de caracteristicas
        jTextFieldFUE.setText("");
        jTextFieldDES.setText("");
        jTextFieldCON.setText("");
        jTextFieldINT.setText("");
        jTextFieldSAB.setText("");
        jTextFieldCAR.setText("");
        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldDios.setText("");
        jTextFieldDios.setText("");
        jTextFieldAltura.setText("");
        jTextFieldEdad.setText("");
        jTextFieldPeso.setText("");
        jTextFieldOjos.setText("");
        jTextFieldCabello.setText("");

    }

    public void annadePersonaje() {
        miConexion.insertaNuevoPersonaje(jTextFieldNombre.getText(), jTextFieldApellido.getText(), devuelveAlineamiento(),
                jTextFieldDios.getText(), jComboBoxGenero.getSelectedItem().toString(), "10", "comun", "0", jTextFieldEdad.getText(),
                jTextFieldAltura.getText(), jTextFieldPeso.getText(), jTextFieldCabello.getText(), jTextFieldOjos.getText(), jTextFieldFUE.getText(),
                jTextFieldDES.getText(), jTextFieldCON.getText(), jTextFieldINT.getText(), jTextFieldSAB.getText(), jTextFieldCAR.getText(), jTextFieldAcrobacias.getText(),
                jTextFieldArtesania1.getText(), jTextFieldArtesaniaq1Nombre.getText(), jTextFieldArtesania2.getText(), jTextFieldArtesania2Nombre.getText(), jTextFieldArtesania3.getText(),
                jTextFieldArtesania3Nombre.getText(), jTextFieldAveriguarIntenciones.getText(), jTextFieldConocimientoDeConjuro.getText(), jTextFieldCurar.getText(),
                jTextFieldDiplomacia.getText(), jTextFieldDisfrarse.getText(), jTextFieldEngannar.getText(), jTextFieldEscapismo.getText(), jTextFieldInterpretar1.getText(),
                jTextFieldInterpretar1Nombre.getText(), jTextFieldInterpretar2.getText(), jTextFieldInterpretar2Nombre.getText(), jTextFieldIntimidar.getText(),
                jTextFieldInutilizarMecanismo.getText(), jTextFieldJuegoDeManos.getText(), jTextFieldLinguistica.getText(), jTextFieldMontar.getText(), jTextFieldNadar.getText(),
                jTextFieldPercepcion.getText(), jTextFieldProfesion1.getText(), jTextFieldProfesion1Nombre.getText(), jTextFieldProfesion2.getText(), jTextFieldProfesion2Nombre.getText(),
                jTextFieldSaberArcano.getText(), jTextFieldSaberDungeons.getText(), jTextFieldSaberGeografia.getText(), jTextFieldSaberHistoria.getText(),
                jTextFieldSaberIngenieria.getText(), jTextFieldSaberLocal.getText(), jTextFieldSaberNaturaleza.getText(), jTextFieldSaberNobleza.getText(),
                jTextFieldSaberLosPlanos.getText(), jTextFieldSaberReligion.getText(), jTextFieldSigilo.getText(), jTextFieldSupervivencia.getText(), jTextFieldTasacion.getText(),
                jTextFieldTratoConAnimales.getText(), jTextFieldTrepar.getText(), jTextFieldUsarObjetoMagico.getText(), jTextFieldVolar.getText(),
                jComboBoxRaza.getSelectedItem().toString(), jComboBoxClase.getSelectedItem().toString(), vP.miUsuario);

    }

    public String devuelveAlineamiento() {
        String resultado = "";

        switch (jComboBoxAlineamiento1.getSelectedItem().toString()) {
            case "Legal":
                resultado += "L";
                break;
            case "Neutral":
                resultado += "N";
                break;
            case "Caotico":
                resultado += "C";
                break;
        }

        switch (jComboBoxAlineamiento2.getSelectedItem().toString()) {
            case "Bueno":
                resultado += "B";
                break;
            case "Neutral":
                resultado += "N";
                break;
            case "Maligno":
                resultado += "M";
                break;
        }
        return resultado;
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
        jLabelTClase = new javax.swing.JLabel();
        jLabelTDios = new javax.swing.JLabel();
        jLabelThabilidades = new javax.swing.JLabel();
        jLabelTAcrobacias = new javax.swing.JLabel();
        jLabelTArtesania1 = new javax.swing.JLabel();
        jLabelTArtesania2 = new javax.swing.JLabel();
        jLabelTArtesania3 = new javax.swing.JLabel();
        jLabelTAveriguarIntenciones = new javax.swing.JLabel();
        jLabelTConocimientoConjuros = new javax.swing.JLabel();
        jLabelTCurar = new javax.swing.JLabel();
        jLabelTDiplomacia = new javax.swing.JLabel();
        jLabelTDisfrazarse = new javax.swing.JLabel();
        jLabelTEngannar = new javax.swing.JLabel();
        jLabelTEscapismo = new javax.swing.JLabel();
        jLabelTInterpretar1 = new javax.swing.JLabel();
        jLabelTAltura = new javax.swing.JLabel();
        jLabelTInterpretar2 = new javax.swing.JLabel();
        jLabelTIntimidar = new javax.swing.JLabel();
        jLabelTInutilizarMecanismo = new javax.swing.JLabel();
        jLabelTJuegosDeManos = new javax.swing.JLabel();
        jLabelTLinguistica = new javax.swing.JLabel();
        jLabelTMontar = new javax.swing.JLabel();
        jLabelTPercepcion = new javax.swing.JLabel();
        jLabelTProfesion1 = new javax.swing.JLabel();
        jLabelTProfesion2 = new javax.swing.JLabel();
        jLabelTSaberArcano = new javax.swing.JLabel();
        jLabelTSaberDungeons = new javax.swing.JLabel();
        jLabelTSaberGeografia = new javax.swing.JLabel();
        jLabelTSaberHistoria = new javax.swing.JLabel();
        jLabelTSaberIngenieria = new javax.swing.JLabel();
        jLabelTSaberLocal = new javax.swing.JLabel();
        jLabelTSaberLosPlanos = new javax.swing.JLabel();
        jLabelTSaberNaturaleza = new javax.swing.JLabel();
        jLabelTSaberNobleza = new javax.swing.JLabel();
        jLabelTSaberReligion = new javax.swing.JLabel();
        jLabelTSigilo = new javax.swing.JLabel();
        jLabelTSupervivencia = new javax.swing.JLabel();
        jLabelTTasacion = new javax.swing.JLabel();
        jLabelTTratoConAnimales = new javax.swing.JLabel();
        jLabelTTrepar = new javax.swing.JLabel();
        jLabelTUsarObjetoMagico = new javax.swing.JLabel();
        jLabelTVolar = new javax.swing.JLabel();
        jLabelTNadar = new javax.swing.JLabel();
        jComboBoxClase = new javax.swing.JComboBox<>();
        jLabelTNombre = new javax.swing.JLabel();
        jLabelTRaza = new javax.swing.JLabel();
        jComboBoxRaza = new javax.swing.JComboBox<>();
        jLabelTAlineamiento = new javax.swing.JLabel();
        jComboBoxAlineamiento1 = new javax.swing.JComboBox<>();
        jComboBoxAlineamiento2 = new javax.swing.JComboBox<>();
        jLabelTApellido1 = new javax.swing.JLabel();
        jLabelTNombre4 = new javax.swing.JLabel();
        jComboBoxGenero = new javax.swing.JComboBox<>();
        jLabelTOjos = new javax.swing.JLabel();
        jLabelTCabello = new javax.swing.JLabel();
        jLabelTEdad = new javax.swing.JLabel();
        jLabelTPeso = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDios = new javax.swing.JTextField();
        jTextFieldAltura = new javax.swing.JTextField();
        jTextFieldEdad = new javax.swing.JTextField();
        jTextFieldPeso = new javax.swing.JTextField();
        jTextFieldOjos = new javax.swing.JTextField();
        jTextFieldCabello = new javax.swing.JTextField();
        jTextFieldFUE = new javax.swing.JTextField();
        jTextFieldDES = new javax.swing.JTextField();
        jTextFieldCON = new javax.swing.JTextField();
        jTextFieldINT = new javax.swing.JTextField();
        jTextFieldSAB = new javax.swing.JTextField();
        jTextFieldCAR = new javax.swing.JTextField();
        jTextFieldAcrobacias = new javax.swing.JTextField();
        jTextFieldVolar = new javax.swing.JTextField();
        jTextFieldArtesania1 = new javax.swing.JTextField();
        jTextFieldArtesania2 = new javax.swing.JTextField();
        jTextFieldArtesania3 = new javax.swing.JTextField();
        jTextFieldAveriguarIntenciones = new javax.swing.JTextField();
        jTextFieldConocimientoDeConjuro = new javax.swing.JTextField();
        jTextFieldCurar = new javax.swing.JTextField();
        jTextFieldDiplomacia = new javax.swing.JTextField();
        jTextFieldDisfrarse = new javax.swing.JTextField();
        jTextFieldEngannar = new javax.swing.JTextField();
        jTextFieldEscapismo = new javax.swing.JTextField();
        jTextFieldInterpretar1 = new javax.swing.JTextField();
        jTextFieldInterpretar2 = new javax.swing.JTextField();
        jTextFieldIntimidar = new javax.swing.JTextField();
        jTextFieldInutilizarMecanismo = new javax.swing.JTextField();
        jTextFieldJuegoDeManos = new javax.swing.JTextField();
        jTextFieldLinguistica = new javax.swing.JTextField();
        jTextFieldMontar = new javax.swing.JTextField();
        jTextFieldNadar = new javax.swing.JTextField();
        jTextFieldPercepcion = new javax.swing.JTextField();
        jTextFieldProfesion1 = new javax.swing.JTextField();
        jTextFieldProfesion2 = new javax.swing.JTextField();
        jTextFieldSaberArcano = new javax.swing.JTextField();
        jTextFieldSaberDungeons = new javax.swing.JTextField();
        jTextFieldSaberGeografia = new javax.swing.JTextField();
        jTextFieldSaberHistoria = new javax.swing.JTextField();
        jTextFieldSaberIngenieria = new javax.swing.JTextField();
        jTextFieldSaberLocal = new javax.swing.JTextField();
        jTextFieldSaberLosPlanos = new javax.swing.JTextField();
        jTextFieldSaberNaturaleza = new javax.swing.JTextField();
        jTextFieldSaberNobleza = new javax.swing.JTextField();
        jTextFieldSaberReligion = new javax.swing.JTextField();
        jTextFieldSigilo = new javax.swing.JTextField();
        jTextFieldSupervivencia = new javax.swing.JTextField();
        jTextFieldTasacion = new javax.swing.JTextField();
        jTextFieldTratoConAnimales = new javax.swing.JTextField();
        jTextFieldTrepar = new javax.swing.JTextField();
        jTextFieldUsarObjetoMagico = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jLabelTArtasania1Nombre = new javax.swing.JLabel();
        jTextFieldArtesaniaq1Nombre = new javax.swing.JTextField();
        jLabelTArtesania2Nombre = new javax.swing.JLabel();
        jTextFieldArtesania2Nombre = new javax.swing.JTextField();
        jLabelTArtesania3Nombre = new javax.swing.JLabel();
        jTextFieldArtesania3Nombre = new javax.swing.JTextField();
        jLabelTProfesion1Nombre = new javax.swing.JLabel();
        jTextFieldProfesion1Nombre = new javax.swing.JTextField();
        jTextFieldProfesion2Nombre = new javax.swing.JTextField();
        jLabelTInterpretar1Nombre = new javax.swing.JLabel();
        jTextFieldInterpretar1Nombre = new javax.swing.JTextField();
        jLabelTInterpretar2Nombre = new javax.swing.JLabel();
        jTextFieldInterpretar2Nombre = new javax.swing.JTextField();
        jLabelTProfesion2Nombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(950, 950));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTFuerza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTFuerza.setText("Fuerza");
        getContentPane().add(jLabelTFuerza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabelTFUE.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTFUE.setText("FUE");
        getContentPane().add(jLabelTFUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabelTDestreza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDestreza.setText("Destreza");
        getContentPane().add(jLabelTDestreza, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabelTDES.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTDES.setText("DES");
        getContentPane().add(jLabelTDES, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabelTConstitucion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTConstitucion.setText("Constitucion");
        getContentPane().add(jLabelTConstitucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, -1, -1));

        jLabelTCON.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTCON.setText("CON");
        getContentPane().add(jLabelTCON, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabelTInteligencia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInteligencia.setText("Inteligencia");
        getContentPane().add(jLabelTInteligencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabelTINT.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTINT.setText("INT");
        getContentPane().add(jLabelTINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabelTSabiduria.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSabiduria.setText("Sabiduria");
        getContentPane().add(jLabelTSabiduria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabelTSAB.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTSAB.setText("SAB");
        getContentPane().add(jLabelTSAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        jLabelTCarisma.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCarisma.setText("Carisma");
        getContentPane().add(jLabelTCarisma, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jLabelTCAR.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jLabelTCAR.setText("CAR");
        getContentPane().add(jLabelTCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabelTClase.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTClase.setText("Clase");
        getContentPane().add(jLabelTClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 60, 20));

        jLabelTDios.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTDios.setText("Dios");
        getContentPane().add(jLabelTDios, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 60, 20));

        jLabelThabilidades.setFont(new java.awt.Font("Pokemon Classic", 1, 24)); // NOI18N
        jLabelThabilidades.setText("Hablidades");
        getContentPane().add(jLabelThabilidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jLabelTAcrobacias.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAcrobacias.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTAcrobacias.setText("Acrobacias");
        getContentPane().add(jLabelTAcrobacias, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jLabelTArtesania1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTArtesania1.setText("Artesania");
        getContentPane().add(jLabelTArtesania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        jLabelTArtesania2.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTArtesania2.setText("Artesania");
        getContentPane().add(jLabelTArtesania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        jLabelTArtesania3.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTArtesania3.setText("Artesania");
        getContentPane().add(jLabelTArtesania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        jLabelTAveriguarIntenciones.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAveriguarIntenciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTAveriguarIntenciones.setText("Averiguar Intenciones");
        getContentPane().add(jLabelTAveriguarIntenciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jLabelTConocimientoConjuros.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTConocimientoConjuros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTConocimientoConjuros.setText("Conocimiento de Conjuros");
        getContentPane().add(jLabelTConocimientoConjuros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        jLabelTCurar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCurar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTCurar.setText("Curar");
        getContentPane().add(jLabelTCurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, -1, -1));

        jLabelTDiplomacia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDiplomacia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTDiplomacia.setText("Diplomacia");
        getContentPane().add(jLabelTDiplomacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, -1, -1));

        jLabelTDisfrazarse.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDisfrazarse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTDisfrazarse.setText("Disfrazarse");
        getContentPane().add(jLabelTDisfrazarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, -1, -1));

        jLabelTEngannar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEngannar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTEngannar.setText("Engañar");
        getContentPane().add(jLabelTEngannar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, -1, -1));

        jLabelTEscapismo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEscapismo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTEscapismo.setText("Escapismo");
        getContentPane().add(jLabelTEscapismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        jLabelTInterpretar1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInterpretar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTInterpretar1.setText("Interpretar");
        getContentPane().add(jLabelTInterpretar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jLabelTAltura.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAltura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTAltura.setText("Altura");
        getContentPane().add(jLabelTAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 60, 20));

        jLabelTInterpretar2.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInterpretar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTInterpretar2.setText("Interpretar");
        getContentPane().add(jLabelTInterpretar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, -1, -1));

        jLabelTIntimidar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTIntimidar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTIntimidar.setText("Intimidar");
        getContentPane().add(jLabelTIntimidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, -1, -1));

        jLabelTInutilizarMecanismo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInutilizarMecanismo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTInutilizarMecanismo.setText("Inutilizar Mecanismo");
        getContentPane().add(jLabelTInutilizarMecanismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        jLabelTJuegosDeManos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTJuegosDeManos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTJuegosDeManos.setText("Juego de Manos");
        getContentPane().add(jLabelTJuegosDeManos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, -1, -1));

        jLabelTLinguistica.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTLinguistica.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTLinguistica.setText("Lingüistica");
        getContentPane().add(jLabelTLinguistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, -1, -1));

        jLabelTMontar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTMontar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTMontar.setText("Montar");
        getContentPane().add(jLabelTMontar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, -1, -1));

        jLabelTPercepcion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTPercepcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTPercepcion.setText("Percepcion");
        getContentPane().add(jLabelTPercepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 620, -1, -1));

        jLabelTProfesion1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTProfesion1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTProfesion1.setText("Profesion");
        getContentPane().add(jLabelTProfesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, -1, -1));

        jLabelTProfesion2.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTProfesion2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTProfesion2.setText("Profesion");
        getContentPane().add(jLabelTProfesion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, -1, -1));

        jLabelTSaberArcano.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberArcano.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberArcano.setText("Saber (Arcano)");
        getContentPane().add(jLabelTSaberArcano, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, -1, -1));

        jLabelTSaberDungeons.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberDungeons.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberDungeons.setText("Saber (Dugeons");
        getContentPane().add(jLabelTSaberDungeons, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, -1, -1));

        jLabelTSaberGeografia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberGeografia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberGeografia.setText("Saber (Geografia) ");
        getContentPane().add(jLabelTSaberGeografia, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, -1, -1));

        jLabelTSaberHistoria.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberHistoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberHistoria.setText("Saber (Historia)");
        getContentPane().add(jLabelTSaberHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 500, -1, -1));

        jLabelTSaberIngenieria.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberIngenieria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberIngenieria.setText("Saber (Ingenieria)");
        getContentPane().add(jLabelTSaberIngenieria, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, -1, -1));

        jLabelTSaberLocal.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberLocal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberLocal.setText("Saber (Local)");
        getContentPane().add(jLabelTSaberLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, -1, -1));

        jLabelTSaberLosPlanos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberLosPlanos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberLosPlanos.setText("Saber (Los Planos)");
        getContentPane().add(jLabelTSaberLosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, -1, -1));

        jLabelTSaberNaturaleza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberNaturaleza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberNaturaleza.setText("Saber (Naturaleza)");
        getContentPane().add(jLabelTSaberNaturaleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, -1, -1));

        jLabelTSaberNobleza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberNobleza.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberNobleza.setText("Saber (Nobleza)");
        getContentPane().add(jLabelTSaberNobleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, -1));

        jLabelTSaberReligion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSaberReligion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSaberReligion.setText("Saber (Religion)");
        getContentPane().add(jLabelTSaberReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 380, -1, -1));

        jLabelTSigilo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSigilo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSigilo.setText("Sigilo");
        getContentPane().add(jLabelTSigilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, -1, -1));

        jLabelTSupervivencia.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTSupervivencia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTSupervivencia.setText("Supervivencia");
        getContentPane().add(jLabelTSupervivencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, -1, -1));

        jLabelTTasacion.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTasacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTTasacion.setText("Tasacion");
        getContentPane().add(jLabelTTasacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 470, -1, -1));

        jLabelTTratoConAnimales.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTratoConAnimales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTTratoConAnimales.setText("Trato con Animales");
        getContentPane().add(jLabelTTratoConAnimales, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, -1));

        jLabelTTrepar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTrepar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTTrepar.setText("Trepar");
        getContentPane().add(jLabelTTrepar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 530, -1, -1));

        jLabelTUsarObjetoMagico.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTUsarObjetoMagico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTUsarObjetoMagico.setText("Usar Objeto Magico");
        getContentPane().add(jLabelTUsarObjetoMagico, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, -1, -1));

        jLabelTVolar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTVolar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTVolar.setText("Volar");
        getContentPane().add(jLabelTVolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 590, -1, -1));

        jLabelTNadar.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNadar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTNadar.setText("Nadar");
        getContentPane().add(jLabelTNadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, -1, -1));

        jComboBoxClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mago", "Bardo", "Clerigo" }));
        getContentPane().add(jComboBoxClase, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 190, -1));

        jLabelTNombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTNombre.setText("Nombre");
        getContentPane().add(jLabelTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 60, 20));

        jLabelTRaza.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTRaza.setText("Raza");
        getContentPane().add(jLabelTRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 60, 20));

        jComboBoxRaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elfo", "Enano", "Gnomo" }));
        getContentPane().add(jComboBoxRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 190, -1));

        jLabelTAlineamiento.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTAlineamiento.setText("Alineamiento");
        getContentPane().add(jLabelTAlineamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 90, 20));

        jComboBoxAlineamiento1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Legal", "Neutral", "Caotico" }));
        getContentPane().add(jComboBoxAlineamiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 130, -1));

        jComboBoxAlineamiento2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bueno", "Neutral", "Maligno" }));
        getContentPane().add(jComboBoxAlineamiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 130, -1));

        jLabelTApellido1.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTApellido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTApellido1.setText("Apellido");
        getContentPane().add(jLabelTApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 60, 20));

        jLabelTNombre4.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNombre4.setText("Sexo");
        getContentPane().add(jLabelTNombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 60, 20));

        jComboBoxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Sin Genero", "Dinosaurio", "Helicoptero", "Desconocido" }));
        getContentPane().add(jComboBoxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 160, -1));

        jLabelTOjos.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTOjos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTOjos.setText("Ojos");
        getContentPane().add(jLabelTOjos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 60, 20));

        jLabelTCabello.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCabello.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTCabello.setText("Cabello");
        getContentPane().add(jLabelTCabello, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 60, 20));

        jLabelTEdad.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTEdad.setText("Edad");
        getContentPane().add(jLabelTEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 60, 20));

        jLabelTPeso.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTPeso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTPeso.setText("Peso");
        getContentPane().add(jLabelTPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 60, 20));

        jTextFieldNombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 29, 210, 20));

        jTextFieldApellido.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldApellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 210, 20));

        jTextFieldDios.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldDios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldDios, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 210, 20));

        jTextFieldAltura.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldAltura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 210, 20));

        jTextFieldEdad.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldEdad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 210, 20));

        jTextFieldPeso.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldPeso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 210, 20));

        jTextFieldOjos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldOjos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldOjos, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 210, 20));

        jTextFieldCabello.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldCabello.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldCabello, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 210, 20));

        jTextFieldFUE.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jTextFieldFUE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldFUE.setText("99");
        jTextFieldFUE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldFUE, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 50, 40));

        jTextFieldDES.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jTextFieldDES.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldDES.setText("99");
        jTextFieldDES.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldDES, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 50, 40));

        jTextFieldCON.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jTextFieldCON.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCON.setText("99");
        jTextFieldCON.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldCON, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 50, 40));

        jTextFieldINT.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jTextFieldINT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldINT.setText("99");
        jTextFieldINT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 50, 40));

        jTextFieldSAB.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jTextFieldSAB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSAB.setText("99");
        jTextFieldSAB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldSAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 50, 40));

        jTextFieldCAR.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jTextFieldCAR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldCAR.setText("99");
        jTextFieldCAR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 50, 40));

        jTextFieldAcrobacias.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldAcrobacias.setText("99");
        jTextFieldAcrobacias.setToolTipText("");
        jTextFieldAcrobacias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldAcrobacias.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldAcrobacias, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 20, 20));

        jTextFieldVolar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldVolar.setText("99");
        jTextFieldVolar.setToolTipText("");
        jTextFieldVolar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldVolar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldVolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 590, 20, 20));

        jTextFieldArtesania1.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldArtesania1.setText("99");
        jTextFieldArtesania1.setToolTipText("");
        jTextFieldArtesania1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldArtesania1.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldArtesania1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 20, 20));

        jTextFieldArtesania2.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldArtesania2.setText("99");
        jTextFieldArtesania2.setToolTipText("");
        jTextFieldArtesania2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldArtesania2.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldArtesania2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 20, 20));

        jTextFieldArtesania3.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldArtesania3.setText("99");
        jTextFieldArtesania3.setToolTipText("");
        jTextFieldArtesania3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldArtesania3.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldArtesania3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 20, 20));

        jTextFieldAveriguarIntenciones.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldAveriguarIntenciones.setText("99");
        jTextFieldAveriguarIntenciones.setToolTipText("");
        jTextFieldAveriguarIntenciones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldAveriguarIntenciones.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldAveriguarIntenciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 20, 20));

        jTextFieldConocimientoDeConjuro.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldConocimientoDeConjuro.setText("99");
        jTextFieldConocimientoDeConjuro.setToolTipText("");
        jTextFieldConocimientoDeConjuro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldConocimientoDeConjuro.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldConocimientoDeConjuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, 20, 20));

        jTextFieldCurar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldCurar.setText("99");
        jTextFieldCurar.setToolTipText("");
        jTextFieldCurar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldCurar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldCurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 20, 20));

        jTextFieldDiplomacia.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldDiplomacia.setText("99");
        jTextFieldDiplomacia.setToolTipText("");
        jTextFieldDiplomacia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldDiplomacia.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldDiplomacia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 20, 20));

        jTextFieldDisfrarse.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldDisfrarse.setText("99");
        jTextFieldDisfrarse.setToolTipText("");
        jTextFieldDisfrarse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldDisfrarse.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldDisfrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 20, 20));

        jTextFieldEngannar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldEngannar.setText("99");
        jTextFieldEngannar.setToolTipText("");
        jTextFieldEngannar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldEngannar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldEngannar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 620, 20, 20));

        jTextFieldEscapismo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldEscapismo.setText("99");
        jTextFieldEscapismo.setToolTipText("");
        jTextFieldEscapismo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldEscapismo.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldEscapismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 20, 20));

        jTextFieldInterpretar1.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldInterpretar1.setText("99");
        jTextFieldInterpretar1.setToolTipText("");
        jTextFieldInterpretar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldInterpretar1.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldInterpretar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 20, 20));

        jTextFieldInterpretar2.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldInterpretar2.setText("99");
        jTextFieldInterpretar2.setToolTipText("");
        jTextFieldInterpretar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldInterpretar2.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldInterpretar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 20, 20));

        jTextFieldIntimidar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldIntimidar.setText("99");
        jTextFieldIntimidar.setToolTipText("");
        jTextFieldIntimidar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldIntimidar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldIntimidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 20, 20));

        jTextFieldInutilizarMecanismo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldInutilizarMecanismo.setText("99");
        jTextFieldInutilizarMecanismo.setToolTipText("");
        jTextFieldInutilizarMecanismo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldInutilizarMecanismo.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldInutilizarMecanismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 20, 20));

        jTextFieldJuegoDeManos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldJuegoDeManos.setText("99");
        jTextFieldJuegoDeManos.setToolTipText("");
        jTextFieldJuegoDeManos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldJuegoDeManos.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldJuegoDeManos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 20, 20));

        jTextFieldLinguistica.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldLinguistica.setText("99");
        jTextFieldLinguistica.setToolTipText("");
        jTextFieldLinguistica.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldLinguistica.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldLinguistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, 20, 20));

        jTextFieldMontar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldMontar.setText("99");
        jTextFieldMontar.setToolTipText("");
        jTextFieldMontar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldMontar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldMontar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 20, 20));

        jTextFieldNadar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldNadar.setText("99");
        jTextFieldNadar.setToolTipText("");
        jTextFieldNadar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldNadar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldNadar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 20, 20));

        jTextFieldPercepcion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldPercepcion.setText("99");
        jTextFieldPercepcion.setToolTipText("");
        jTextFieldPercepcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldPercepcion.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldPercepcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, 20, 20));

        jTextFieldProfesion1.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldProfesion1.setText("99");
        jTextFieldProfesion1.setToolTipText("");
        jTextFieldProfesion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldProfesion1.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldProfesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 20, 20));

        jTextFieldProfesion2.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldProfesion2.setText("99");
        jTextFieldProfesion2.setToolTipText("");
        jTextFieldProfesion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldProfesion2.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldProfesion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 20, 20));

        jTextFieldSaberArcano.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberArcano.setText("99");
        jTextFieldSaberArcano.setToolTipText("");
        jTextFieldSaberArcano.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberArcano.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberArcano, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 20, 20));

        jTextFieldSaberDungeons.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberDungeons.setText("99");
        jTextFieldSaberDungeons.setToolTipText("");
        jTextFieldSaberDungeons.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberDungeons.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberDungeons, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 20, 20));

        jTextFieldSaberGeografia.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberGeografia.setText("99");
        jTextFieldSaberGeografia.setToolTipText("");
        jTextFieldSaberGeografia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberGeografia.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberGeografia, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, 20, 20));

        jTextFieldSaberHistoria.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberHistoria.setText("99");
        jTextFieldSaberHistoria.setToolTipText("");
        jTextFieldSaberHistoria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberHistoria.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 20, 20));

        jTextFieldSaberIngenieria.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberIngenieria.setText("99");
        jTextFieldSaberIngenieria.setToolTipText("");
        jTextFieldSaberIngenieria.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberIngenieria.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberIngenieria, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, 20, 20));

        jTextFieldSaberLocal.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberLocal.setText("99");
        jTextFieldSaberLocal.setToolTipText("");
        jTextFieldSaberLocal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberLocal.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 20, 20));

        jTextFieldSaberLosPlanos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberLosPlanos.setText("99");
        jTextFieldSaberLosPlanos.setToolTipText("");
        jTextFieldSaberLosPlanos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberLosPlanos.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberLosPlanos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, 20, 20));

        jTextFieldSaberNaturaleza.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberNaturaleza.setText("99");
        jTextFieldSaberNaturaleza.setToolTipText("");
        jTextFieldSaberNaturaleza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberNaturaleza.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberNaturaleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 620, 20, 20));

        jTextFieldSaberNobleza.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberNobleza.setText("99");
        jTextFieldSaberNobleza.setToolTipText("");
        jTextFieldSaberNobleza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberNobleza.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberNobleza, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, 20, 20));

        jTextFieldSaberReligion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSaberReligion.setText("99");
        jTextFieldSaberReligion.setToolTipText("");
        jTextFieldSaberReligion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSaberReligion.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSaberReligion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 20, 20));

        jTextFieldSigilo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSigilo.setText("99");
        jTextFieldSigilo.setToolTipText("");
        jTextFieldSigilo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSigilo.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSigilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 20, 20));

        jTextFieldSupervivencia.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldSupervivencia.setText("99");
        jTextFieldSupervivencia.setToolTipText("");
        jTextFieldSupervivencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldSupervivencia.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldSupervivencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 440, 20, 20));

        jTextFieldTasacion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldTasacion.setText("99");
        jTextFieldTasacion.setToolTipText("");
        jTextFieldTasacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldTasacion.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldTasacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 20, 20));

        jTextFieldTratoConAnimales.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldTratoConAnimales.setText("99");
        jTextFieldTratoConAnimales.setToolTipText("");
        jTextFieldTratoConAnimales.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldTratoConAnimales.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldTratoConAnimales, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 20, 20));

        jTextFieldTrepar.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldTrepar.setText("99");
        jTextFieldTrepar.setToolTipText("");
        jTextFieldTrepar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldTrepar.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldTrepar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 20, 20));

        jTextFieldUsarObjetoMagico.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldUsarObjetoMagico.setText("99");
        jTextFieldUsarObjetoMagico.setToolTipText("");
        jTextFieldUsarObjetoMagico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldUsarObjetoMagico.setMinimumSize(new java.awt.Dimension(20, 20));
        getContentPane().add(jTextFieldUsarObjetoMagico, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 20, 20));

        jButtonAceptar.setFont(new java.awt.Font("Pokemon Classic", 1, 12)); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 780, 140, -1));

        jLabelTArtasania1Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtasania1Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTArtasania1Nombre.setText("Artesania 1");
        getContentPane().add(jLabelTArtasania1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 80, 20));

        jTextFieldArtesaniaq1Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldArtesaniaq1Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldArtesaniaq1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 670, 210, 20));

        jLabelTArtesania2Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania2Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTArtesania2Nombre.setText("Artesania 2");
        getContentPane().add(jLabelTArtesania2Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 80, 20));

        jTextFieldArtesania2Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldArtesania2Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldArtesania2Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 700, 210, 20));

        jLabelTArtesania3Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTArtesania3Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTArtesania3Nombre.setText("Artesania 3");
        getContentPane().add(jLabelTArtesania3Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 670, 80, 20));

        jTextFieldArtesania3Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldArtesania3Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldArtesania3Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 670, 210, 20));

        jLabelTProfesion1Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTProfesion1Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTProfesion1Nombre.setText("Profesion 1");
        getContentPane().add(jLabelTProfesion1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, 80, 20));

        jTextFieldProfesion1Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldProfesion1Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldProfesion1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 730, 210, 20));

        jTextFieldProfesion2Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldProfesion2Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldProfesion2Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 760, 210, 20));

        jLabelTInterpretar1Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInterpretar1Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTInterpretar1Nombre.setText("Interpretar 1");
        getContentPane().add(jLabelTInterpretar1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 700, 100, 20));

        jTextFieldInterpretar1Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldInterpretar1Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldInterpretar1Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 700, 210, 20));

        jLabelTInterpretar2Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTInterpretar2Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTInterpretar2Nombre.setText("Interpretar 2");
        getContentPane().add(jLabelTInterpretar2Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 730, 100, 20));

        jTextFieldInterpretar2Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTextFieldInterpretar2Nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jTextFieldInterpretar2Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 730, 210, 20));

        jLabelTProfesion2Nombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTProfesion2Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTProfesion2Nombre.setText("Profesion 2");
        getContentPane().add(jLabelTProfesion2Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 760, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        annadePersonaje();

        vP.actualizaPersonaje(vP.jComboBoxListaPersonajes.getSelectedIndex());
    }//GEN-LAST:event_jButtonAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoPersonaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPersonaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox<String> jComboBoxAlineamiento1;
    private javax.swing.JComboBox<String> jComboBoxAlineamiento2;
    private javax.swing.JComboBox<String> jComboBoxClase;
    private javax.swing.JComboBox<String> jComboBoxGenero;
    private javax.swing.JComboBox<String> jComboBoxRaza;
    private javax.swing.JLabel jLabelTAcrobacias;
    private javax.swing.JLabel jLabelTAlineamiento;
    private javax.swing.JLabel jLabelTAltura;
    private javax.swing.JLabel jLabelTApellido1;
    private javax.swing.JLabel jLabelTArtasania1Nombre;
    private javax.swing.JLabel jLabelTArtesania1;
    private javax.swing.JLabel jLabelTArtesania2;
    private javax.swing.JLabel jLabelTArtesania2Nombre;
    private javax.swing.JLabel jLabelTArtesania3;
    private javax.swing.JLabel jLabelTArtesania3Nombre;
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
    private javax.swing.JLabel jLabelTEdad;
    private javax.swing.JLabel jLabelTEngannar;
    private javax.swing.JLabel jLabelTEscapismo;
    private javax.swing.JLabel jLabelTFUE;
    private javax.swing.JLabel jLabelTFuerza;
    private javax.swing.JLabel jLabelTINT;
    private javax.swing.JLabel jLabelTInteligencia;
    private javax.swing.JLabel jLabelTInterpretar1;
    private javax.swing.JLabel jLabelTInterpretar1Nombre;
    private javax.swing.JLabel jLabelTInterpretar2;
    private javax.swing.JLabel jLabelTInterpretar2Nombre;
    private javax.swing.JLabel jLabelTIntimidar;
    private javax.swing.JLabel jLabelTInutilizarMecanismo;
    private javax.swing.JLabel jLabelTJuegosDeManos;
    private javax.swing.JLabel jLabelTLinguistica;
    private javax.swing.JLabel jLabelTMontar;
    private javax.swing.JLabel jLabelTNadar;
    private javax.swing.JLabel jLabelTNombre;
    private javax.swing.JLabel jLabelTNombre4;
    private javax.swing.JLabel jLabelTOjos;
    private javax.swing.JLabel jLabelTPercepcion;
    private javax.swing.JLabel jLabelTPeso;
    private javax.swing.JLabel jLabelTProfesion1;
    private javax.swing.JLabel jLabelTProfesion1Nombre;
    private javax.swing.JLabel jLabelTProfesion2;
    private javax.swing.JLabel jLabelTProfesion2Nombre;
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
    private javax.swing.JLabel jLabelTSigilo;
    private javax.swing.JLabel jLabelTSupervivencia;
    private javax.swing.JLabel jLabelTTasacion;
    private javax.swing.JLabel jLabelTTratoConAnimales;
    private javax.swing.JLabel jLabelTTrepar;
    private javax.swing.JLabel jLabelTUsarObjetoMagico;
    private javax.swing.JLabel jLabelTVolar;
    private javax.swing.JLabel jLabelThabilidades;
    private javax.swing.JTextField jTextFieldAcrobacias;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldArtesania1;
    private javax.swing.JTextField jTextFieldArtesania2;
    private javax.swing.JTextField jTextFieldArtesania2Nombre;
    private javax.swing.JTextField jTextFieldArtesania3;
    private javax.swing.JTextField jTextFieldArtesania3Nombre;
    private javax.swing.JTextField jTextFieldArtesaniaq1Nombre;
    private javax.swing.JTextField jTextFieldAveriguarIntenciones;
    private javax.swing.JTextField jTextFieldCAR;
    private javax.swing.JTextField jTextFieldCON;
    private javax.swing.JTextField jTextFieldCabello;
    private javax.swing.JTextField jTextFieldConocimientoDeConjuro;
    private javax.swing.JTextField jTextFieldCurar;
    private javax.swing.JTextField jTextFieldDES;
    private javax.swing.JTextField jTextFieldDios;
    private javax.swing.JTextField jTextFieldDiplomacia;
    private javax.swing.JTextField jTextFieldDisfrarse;
    private javax.swing.JTextField jTextFieldEdad;
    private javax.swing.JTextField jTextFieldEngannar;
    private javax.swing.JTextField jTextFieldEscapismo;
    private javax.swing.JTextField jTextFieldFUE;
    private javax.swing.JTextField jTextFieldINT;
    private javax.swing.JTextField jTextFieldInterpretar1;
    private javax.swing.JTextField jTextFieldInterpretar1Nombre;
    private javax.swing.JTextField jTextFieldInterpretar2;
    private javax.swing.JTextField jTextFieldInterpretar2Nombre;
    private javax.swing.JTextField jTextFieldIntimidar;
    private javax.swing.JTextField jTextFieldInutilizarMecanismo;
    private javax.swing.JTextField jTextFieldJuegoDeManos;
    private javax.swing.JTextField jTextFieldLinguistica;
    private javax.swing.JTextField jTextFieldMontar;
    private javax.swing.JTextField jTextFieldNadar;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldOjos;
    private javax.swing.JTextField jTextFieldPercepcion;
    private javax.swing.JTextField jTextFieldPeso;
    private javax.swing.JTextField jTextFieldProfesion1;
    private javax.swing.JTextField jTextFieldProfesion1Nombre;
    private javax.swing.JTextField jTextFieldProfesion2;
    private javax.swing.JTextField jTextFieldProfesion2Nombre;
    private javax.swing.JTextField jTextFieldSAB;
    private javax.swing.JTextField jTextFieldSaberArcano;
    private javax.swing.JTextField jTextFieldSaberDungeons;
    private javax.swing.JTextField jTextFieldSaberGeografia;
    private javax.swing.JTextField jTextFieldSaberHistoria;
    private javax.swing.JTextField jTextFieldSaberIngenieria;
    private javax.swing.JTextField jTextFieldSaberLocal;
    private javax.swing.JTextField jTextFieldSaberLosPlanos;
    private javax.swing.JTextField jTextFieldSaberNaturaleza;
    private javax.swing.JTextField jTextFieldSaberNobleza;
    private javax.swing.JTextField jTextFieldSaberReligion;
    private javax.swing.JTextField jTextFieldSigilo;
    private javax.swing.JTextField jTextFieldSupervivencia;
    private javax.swing.JTextField jTextFieldTasacion;
    private javax.swing.JTextField jTextFieldTratoConAnimales;
    private javax.swing.JTextField jTextFieldTrepar;
    private javax.swing.JTextField jTextFieldUsarObjetoMagico;
    private javax.swing.JTextField jTextFieldVolar;
    // End of variables declaration//GEN-END:variables
}
