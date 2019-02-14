/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Daniel
 */
public class VentanaDetallesArmas extends javax.swing.JFrame {

    DefaultTableModel tabla;

    boolean adaptada = false;
    boolean abiertaVentanaTodas = false;

    /**
     * Creates new form ventanaDetallesObjetos
     */
    public VentanaDetallesArmas() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        jButtonAnnadir.setVisible(false);
    }

    public void estableceTabla(DefaultTableModel _tabla) {
        tabla = _tabla;
        jTableObjetos.setModel(tabla);

        if (!adaptada || abiertaVentanaTodas) {
            jTableObjetos.removeColumn(jTableObjetos.getColumnModel().getColumn(jTableObjetos.getColumnCount() - 1));
            jTableObjetos.removeColumn(jTableObjetos.getColumnModel().getColumn(jTableObjetos.getColumnCount() - 1));
            jTableObjetos.removeColumn(jTableObjetos.getColumnModel().getColumn(0));

            TableColumnModel columnModel = jTableObjetos.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(250);
            adaptada = true;
            abiertaVentanaTodas = false;
            jTableObjetos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                    cambiaSeleccion();
                }
            });
        }

    }

    public void cambioDeTabla() {
        adaptada = false;
    }

    public void abriendoVentanaTotal() {
        abiertaVentanaTodas = true;
    }

    public void cambiaSeleccion() {
        jLabelNombre.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 1).toString());
        jLabelPeso.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 2).toString());
        jLabelDannoP.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 4).toString());
        jLabelDannoM.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 5).toString());
        jLabelCritico.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 6).toString());
        jLabelRango.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 7).toString());
        jLabelTipo.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 8).toString());
        jLabelEspecial.setText(tabla.getValueAt(jTableObjetos.getSelectedRow(), 9).toString());
        jLabelDescripcion.setText("<html><p align='center' margin-top=2em;>" + tabla.getValueAt(jTableObjetos.getSelectedRow(), 10).toString() + "</p></html>");
        //Hay que poner el Magico
    }

    public void abreVentanaAnnadir() {
        jButtonAnnadir.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableObjetos = new javax.swing.JTable();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelTNombre = new javax.swing.JLabel();
        jLabelPeso = new javax.swing.JLabel();
        jLabelTPeso = new javax.swing.JLabel();
        jLabelDannoP = new javax.swing.JLabel();
        jLabelTDannoP = new javax.swing.JLabel();
        jLabelDannoM = new javax.swing.JLabel();
        jLabelTDannoM = new javax.swing.JLabel();
        jLabelCritico = new javax.swing.JLabel();
        jLabelTCritico = new javax.swing.JLabel();
        jLabelRango = new javax.swing.JLabel();
        jLabelTRango = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelTTipo = new javax.swing.JLabel();
        jLabelEspecial = new javax.swing.JLabel();
        jLabelTEspecial = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jButtonAnnadir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(190, 31, 44));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableObjetos.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jTableObjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableObjetos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 659, 130));

        jLabelDescripcion.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelDescripcion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 320, 190));

        jLabelTNombre.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTNombre.setText("Nombre");
        getContentPane().add(jLabelTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 320, -1));

        jLabelPeso.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelPeso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPeso.setText("Caladrel");
        jLabelPeso.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 80, 20));

        jLabelTPeso.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTPeso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTPeso.setText("Peso");
        getContentPane().add(jLabelTPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 80, -1));

        jLabelDannoP.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelDannoP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDannoP.setText("Caladrel");
        jLabelDannoP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDannoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 80, 20));

        jLabelTDannoP.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDannoP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTDannoP.setText("Daño P");
        getContentPane().add(jLabelTDannoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 80, -1));

        jLabelDannoM.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelDannoM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelDannoM.setText("Caladrel");
        jLabelDannoM.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelDannoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 80, 20));

        jLabelTDannoM.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTDannoM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTDannoM.setText("Daño M");
        getContentPane().add(jLabelTDannoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 80, -1));

        jLabelCritico.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelCritico.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCritico.setText("Caladrel");
        jLabelCritico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelCritico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 120, 20));

        jLabelTCritico.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTCritico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTCritico.setText("Critico");
        getContentPane().add(jLabelTCritico, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 80, -1));

        jLabelRango.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelRango.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRango.setText("Caladrel");
        jLabelRango.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 110, 20));

        jLabelTRango.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTRango.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTRango.setText("Rango");
        getContentPane().add(jLabelTRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 80, -1));

        jLabelTipo.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTipo.setText("Caladrel");
        jLabelTipo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, -1));

        jLabelTTipo.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTTipo.setText("Tipo");
        getContentPane().add(jLabelTTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 80, 10));

        jLabelEspecial.setFont(new java.awt.Font("Pokemon Classic", 0, 10)); // NOI18N
        jLabelEspecial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelEspecial.setText("Caladrel");
        jLabelEspecial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelEspecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 100, 20));

        jLabelTEspecial.setFont(new java.awt.Font("Pokemon Classic", 0, 8)); // NOI18N
        jLabelTEspecial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTEspecial.setText("Especial");
        getContentPane().add(jLabelTEspecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 80, -1));

        jLabelNombre.setFont(new java.awt.Font("Pokemon Classic", 0, 12)); // NOI18N
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("Caladrel");
        jLabelNombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 320, 30));

        jButtonAnnadir.setText("Añadir");
        getContentPane().add(jButtonAnnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaDetallesArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDetallesArmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaDetallesArmas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnadir;
    private javax.swing.JLabel jLabelCritico;
    private javax.swing.JLabel jLabelDannoM;
    private javax.swing.JLabel jLabelDannoP;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelEspecial;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelRango;
    private javax.swing.JLabel jLabelTCritico;
    private javax.swing.JLabel jLabelTDannoM;
    private javax.swing.JLabel jLabelTDannoP;
    private javax.swing.JLabel jLabelTEspecial;
    private javax.swing.JLabel jLabelTNombre;
    private javax.swing.JLabel jLabelTPeso;
    private javax.swing.JLabel jLabelTRango;
    private javax.swing.JLabel jLabelTTipo;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableObjetos;
    // End of variables declaration//GEN-END:variables
}
