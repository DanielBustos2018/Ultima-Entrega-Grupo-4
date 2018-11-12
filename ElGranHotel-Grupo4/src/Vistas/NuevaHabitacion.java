/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.TipoDeHabitacion;
import Logica.Conexion;
import Logica.HabitacionData;
import Logica.TipoDeHabitacionData;
import static Vistas.Inicio.escritorio;
//import java.awt.List;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dani
 */
public class NuevaHabitacion extends javax.swing.JInternalFrame {

    private Conexion con;

    public NuevaHabitacion() {
        initComponents();
        //Primero busco los tipos de habitacion existentes y los muestro en el combo box cboxtipos:
        mostrarTipos();
        mostrarNumeros();

    }

    public void mostrarTipos() {     
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData portipo = new TipoDeHabitacionData(con);
            
            ArrayList<TipoDeHabitacion> lista = (ArrayList) portipo.obtenerTipos();
            for (TipoDeHabitacion a : lista) {
                //JOptionPane.showMessageDialog(null, a.getId_tipoHabitacion());
                cboxtipos.addItem(""+a.getId_tipoHabitacion());
            }

        } catch (Exception e) {
            System.out.println("error en mostrarTipos");
        }
    }
    
    public void mostrarNumeros(){
        for (int i = 1 ; i <= 300 ; i ++){
            cboxnumero.addItem(""+i);
        }
    }
    
    
    
    public void insertarNuevaHabitacion(){
        //Primero tomo los valores del fomrulario:
        int id_tipohab = Integer.parseInt(cboxtipos.getSelectedItem().toString());
        int numero = Integer.parseInt(cboxnumero.getSelectedItem().toString());
        int piso;
        int estado;
        
        if (cboxpiso.getSelectedItem().toString().equals("Planta Baja")){
            piso = 0;
        }
        else if (cboxpiso.getSelectedItem().toString().equals("Primer piso")){
            piso = 1;
        }
        else if (cboxpiso.getSelectedItem().toString().equals("Segundo piso")){
            piso = 2;
        }
        else if (cboxpiso.getSelectedItem().toString().equals("Tercer piso")){
            piso = 3;
        }
        else if (cboxpiso.getSelectedItem().toString().equals("Cuarto piso")){
            piso = 4;
        }
        else {
            piso = 5;
        }
        
        if (cboxestado.getSelectedItem().toString().equals("Ocupada")){
            estado = 1;
        }
        else {
            estado = 0;
        }
        
        
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData nueva = new HabitacionData(con);
            nueva.insertar(id_tipohab, numero, piso, estado);
            
        } catch (Exception e) {
            System.out.println("error en insertarNuevaHabitacion");
        }
        
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboxtipos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboxnumero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboxpiso = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboxestado = new javax.swing.JComboBox<>();
        btncancelar_volver = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVA HABITACION");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo de Habitación:");

        cboxtipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el ID" }));
        cboxtipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxtiposActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Numero de habitacion:");

        cboxnumero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cboxnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxnumeroActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Piso:");

        cboxpiso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Planta baja", "Primer piso", "Segundo piso", "Tercer piso", "Cuarto piso", "Quinto piso" }));
        cboxpiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxpisoActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado:");

        cboxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Ocupada", "Libre" }));
        cboxestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxestadoActionPerformed(evt);
            }
        });

        btncancelar_volver.setText("CANCELAR");
        btncancelar_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar_volverActionPerformed(evt);
            }
        });

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxtipos, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxnumero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxpiso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btncancelar_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxtipos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxpiso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxestado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboxtiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxtiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxtiposActionPerformed

    private void cboxnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxnumeroActionPerformed

    private void cboxpisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxpisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxpisoActionPerformed

    private void cboxestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxestadoActionPerformed

    private void btncancelar_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar_volverActionPerformed
        //Aqui debo volver a la ventana buscarhabitacion:
        escritorio.removeAll();
        escritorio.repaint();
        BuscarHabitacion nhab = new BuscarHabitacion();
        int x = (escritorio.getWidth() / 2) - nhab.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - nhab.getHeight() / 2;
        nhab.setLocation(x, y);
        escritorio.add(nhab);
        nhab.toFront();
        nhab.setVisible(true);
    }//GEN-LAST:event_btncancelar_volverActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //Aqui controlare que se ingresen todos los datos requeridos:
        if(cboxtipos.getSelectedItem().toString().equals("Seleccione el ID")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione el tipo de habitación");
        }
        else if (cboxnumero.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione el numero que tendrá la nueva habitación");
        }
        else if (cboxpiso.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione el piso donde se encuentra la nueva habitación");
        }
        else if (cboxestado.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione el estado de la nueva habitación");
        }
        else {
            //Si los datos fueron ingresados correctamente, entonces almaceno la nueva habitacion y vuelvo a la ventana Buscar Habitaciones:
            btncancelar_volver.setText("VOLVER");
            JOptionPane.showMessageDialog(null, "Habitacion resgistrada exitosamente");
            insertarNuevaHabitacion();
            
        }
    }//GEN-LAST:event_btnguardarActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar_volver;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cboxestado;
    private javax.swing.JComboBox<String> cboxnumero;
    private javax.swing.JComboBox<String> cboxpiso;
    private javax.swing.JComboBox<String> cboxtipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
