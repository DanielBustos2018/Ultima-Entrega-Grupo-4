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
public class NuevoTipoDeHabitacion extends javax.swing.JInternalFrame {

    private Conexion con;

    public NuevoTipoDeHabitacion() {
        initComponents();
        
        //Los tipos posibles ya estan cargador en el cboxtipo
        //La capacidad tambien esta cargada y va del 1 a 6 personas
        //La cantidad de camas va del 1 al 4
        //El tipo de cama hay 3 opciones
        //El precio por noche lo ingresa el admin manualmente
    }

    
    public void insertarNuevoTipoDeHabitacion(){
        //Primero tomo los valores del fomrulario:
        //el precio por noche
        double precionoche = Double.parseDouble(txtprecionoche.getText());
        //la capacidad
        int capacidad = Integer.parseInt(cboxcapacidad.getSelectedItem().toString());
        //La cantidad de camas:
        int cant_cam = Integer.parseInt(cboxcantidaddecamas.getSelectedItem().toString());
        
        //El tipo de cama:
        String tipohab;
        if (cboxtipo.getSelectedItem().toString().equals("Estándar Simple")){
            tipohab = "Estándar simple";
        }
        else if (cboxtipo.getSelectedItem().toString().equals("Doble")){
            tipohab = "Doble";
        }
        else if (cboxtipo.getSelectedItem().toString().equals("Triple")){
            tipohab = "Triple";
        }
        else {
            tipohab = "suite Lujo";
        }
        
        
        String tipocama;
        if (cboxtipocama.getSelectedItem().toString().equals("Simple")){
            tipocama = "Simple";
        }
        else if (cboxtipocama.getSelectedItem().toString().equals("Queen")){
            tipocama = "Queen";
        }
        else {
            tipocama = "King Size";
        }
 
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData nuevo = new TipoDeHabitacionData(con);
            nuevo.insertar(tipohab, capacidad, cant_cam, tipocama, precionoche);
            
        } catch (Exception e) {
            System.out.println("error en insertarNuevoTipoDeHabitacion");
        }
        
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboxtipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboxcapacidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboxcantidaddecamas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboxtipocama = new javax.swing.JComboBox<>();
        btncancelar_volver = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtprecionoche = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NUEVO TIPO DE HABITACION");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo de Habitación:");

        cboxtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Estándar Simple", "Doble", "Triple", "Suite Lujo" }));
        cboxtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxtipoActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Capacidad:");

        cboxcapacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6" }));
        cboxcapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxcapacidadActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad de camas:");

        cboxcantidaddecamas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4" }));
        cboxcantidaddecamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxcantidaddecamasActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de cama:");

        cboxtipocama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Simple", "Queen", "King Size" }));
        cboxtipocama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxtipocamaActionPerformed(evt);
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

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio por noche:");

        txtprecionoche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecionocheKeyTyped(evt);
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
                                .addComponent(cboxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxcapacidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxcantidaddecamas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxtipocama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtprecionoche)))
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
                    .addComponent(cboxtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxcantidaddecamas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxtipocama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecionoche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cboxtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxtipoActionPerformed

    private void cboxcapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxcapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxcapacidadActionPerformed

    private void cboxcantidaddecamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxcantidaddecamasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxcantidaddecamasActionPerformed

    private void cboxtipocamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxtipocamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxtipocamaActionPerformed

    private void btncancelar_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar_volverActionPerformed
        //Aqui debo volver a la ventana buscarhabitacion:
        escritorio.removeAll();
        escritorio.repaint();
        BuscarTiposDeHabitacion nhab = new BuscarTiposDeHabitacion();
        int x = (escritorio.getWidth() / 2) - nhab.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - nhab.getHeight() / 2;
        nhab.setLocation(x, y);
        escritorio.add(nhab);
        nhab.toFront();
        nhab.setVisible(true);
    }//GEN-LAST:event_btncancelar_volverActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //Aqui controlare que se ingresen todos los datos requeridos:
        if(cboxtipo.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione el tipo de habitación");
        }
        else if (cboxcapacidad.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione la capacidad que tendrá el nuevo tipo de habitación");
        }
        else if (cboxcantidaddecamas.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione la cantidad de camas que tendrá el nuevo tipo de habitación");
        }
        else if (cboxtipocama.getSelectedItem().toString().equals("Seleccione")){
            JOptionPane.showMessageDialog(null, "Por favor seleccione el tipo de cama que tendrá el nuevo tipo de habitación");
        }
        else if (txtprecionoche.getText().length()==0){
            JOptionPane.showMessageDialog(null, "Por favor ingrese el precio por noche que tendrá el nuevo tipo de habitación");
        }
        else {
            //Si los datos fueron ingresados correctamente, entonces almaceno la nuevo habitacion y vuelvo a la ventana Buscar Habitaciones:
            btncancelar_volver.setText("VOLVER");
            insertarNuevoTipoDeHabitacion();
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtprecionocheKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecionocheKeyTyped
        //Aqui valido que en el campo ID solo se ingresen numeros:
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se permiten valores numéricos");
        }
    }//GEN-LAST:event_txtprecionocheKeyTyped

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
            java.util.logging.Logger.getLogger(NuevoTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoTipoDeHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar_volver;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cboxcantidaddecamas;
    private javax.swing.JComboBox<String> cboxcapacidad;
    private javax.swing.JComboBox<String> cboxtipo;
    private javax.swing.JComboBox<String> cboxtipocama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtprecionoche;
    // End of variables declaration//GEN-END:variables
}
