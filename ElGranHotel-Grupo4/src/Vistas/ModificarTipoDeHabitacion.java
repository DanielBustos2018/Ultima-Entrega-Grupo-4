/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Habitacion;
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
public class ModificarTipoDeHabitacion extends javax.swing.JInternalFrame {

    private Conexion con;
    TipoDeHabitacion tdh;
    private int id_tipohab;

    public ModificarTipoDeHabitacion() {
    }

    public ModificarTipoDeHabitacion(int id_tipohabi) {
        initComponents();
        this.id_tipohab = id_tipohabi;
        mostrarDatosHabitacion();
    }

    public void mostrarDatosHabitacion() {
        //primero obtengo los datos y luego los muestro:
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            tdh = new TipoDeHabitacion();

            TipoDeHabitacionData rd = new TipoDeHabitacionData(con);
            tdh = rd.buscarDatosTipoHabitacion(id_tipohab);
            
            lblid.setText("" + id_tipohab);

            //A coontinuacion muestro como Item principal en el cboxtipo el tipo de habitacion, luego cargo los demas tipos:
            cboxtipos.removeAllItems();
            cboxtipos.addItem(tdh.getTipo());
            //Aqui llamo a la funcion que me agrega los demas tipos:
            if(tdh.getTipo().equals("Estándar Simple")){
                cboxtipos.addItem("Doble");
                cboxtipos.addItem("Triple");
                cboxtipos.addItem("Suite Lujo");
            } else if(tdh.getTipo().equals("Doble")){
                cboxtipos.addItem("Estándar Simple");
                cboxtipos.addItem("Triple");
                cboxtipos.addItem("Suite Lujo");
            } else if(tdh.getTipo().equals("Triple")){
                cboxtipos.addItem("Estándar Simple");
                cboxtipos.addItem("Doble");
                cboxtipos.addItem("Suite Lujo");
            } else {
                cboxtipos.addItem("Estándar Simple");
                cboxtipos.addItem("Doble");
                cboxtipos.addItem("Triple");
            }
            


            //Luego muestro la capacidad elegida y demas opciones de capacidad:
            cboxcapacidad.removeAllItems();
            cboxcapacidad.addItem("" + tdh.getCapacidad());
            for (int i = 1; i <= 6; i++) {
                if (i != tdh.getCapacidad()) {
                    cboxcapacidad.addItem("" + i);
                }
            }
            
            
            //Luego muestro la cantidad de camas elegida y demas opciones:
            cboxcantidadcamas.removeAllItems();
            cboxcantidadcamas.addItem("" + tdh.getCantidad_camas());
            for (int i = 1; i <= 6; i++) {
                if (i != tdh.getCantidad_camas()) {
                    cboxcantidadcamas.addItem("" + i);
                }
            }
            
            
            //A coontinuacion muestro como Item principal en el cboxtipocama el tipo de cama, luego cargo los demas tipos:
            cboxtipocama.removeAllItems();
            cboxtipocama.addItem(tdh.getTipo_cama());
            //Aqui llamo a la funcion que me agrega los demas tipos:
            if(tdh.getTipo_cama().equals("Simple")){
                cboxtipocama.addItem("Queen");
                cboxtipocama.addItem("King Size");
            } else if(tdh.getTipo_cama().equals("Queen")){
                cboxtipocama.addItem("Simple");
                cboxtipocama.addItem("King Size");
            } else {
                cboxtipocama.addItem("Simple");
                cboxtipocama.addItem("Queen");
            }
            
            
            //Por ultimo, muestro el precio:
            txtprecionoche.setText(""+tdh.getPrecio_noche());

            //System.out.println("el id de la habitacion es: " + id_tipohab);
        } catch (Exception e) {
            System.out.println("error en mostrarDatosHabitacion");
        }
    }


    public void guardarDatos(){
        //Primero tomo los valores del fomrulario:
        //el precio por noche
        double precionoche = Double.parseDouble(txtprecionoche.getText());
        //la capacidad
        int capacidad = Integer.parseInt(cboxcapacidad.getSelectedItem().toString());
        //La cantidad de camas:
        int cant_cam = Integer.parseInt(cboxcantidadcamas.getSelectedItem().toString());
        
        //El tipo de cama:
        String tipohab;
        if (cboxtipos.getSelectedItem().toString().equals("Estándar Simple")){
            tipohab = "Estándar simple";
        }
        else if (cboxtipos.getSelectedItem().toString().equals("Doble")){
            tipohab = "Doble";
        }
        else if (cboxtipos.getSelectedItem().toString().equals("Triple")){
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
            nuevo.editar(tipohab, capacidad, cant_cam, tipocama, precionoche, id_tipohab);
            
        } catch (Exception e) {
            System.out.println("error en guardarDatos");
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
        cboxcapacidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboxcantidadcamas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboxtipocama = new javax.swing.JComboBox<>();
        btncancelar_volver = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtprecionoche = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICAR TIPO DE HABITACION");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tipo de Habitación:");

        cboxtipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cboxtipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxtiposActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Capacidad:");

        cboxcapacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cboxcapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxcapacidadActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad de camas:");

        cboxcantidadcamas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Planta baja", "Primer piso", "Segundo piso", "Tercer piso", "Cuarto piso", "Quinto piso" }));
        cboxcantidadcamas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxcantidadcamasActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de cama:");

        cboxtipocama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Ocupada", "Libre" }));
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
        jLabel6.setText("ID Asignado:");

        lblid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Precio por noche:");

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
                                .addComponent(cboxcapacidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxcantidadcamas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxtipocama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxtipos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxcapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxcantidadcamas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxtipocama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(txtprecionoche))
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

    private void cboxtiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxtiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxtiposActionPerformed

    private void cboxcapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxcapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxcapacidadActionPerformed

    private void cboxcantidadcamasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxcantidadcamasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxcantidadcamasActionPerformed

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

        //Si los datos fueron ingresados correctamente, entonces almaceno la nueva habitacion y vuelvo a la ventana Buscar Habitaciones:
        btncancelar_volver.setText("VOLVER");
        guardarDatos();
        JOptionPane.showMessageDialog(null, "Datos guardados exitosamente");

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
            java.util.logging.Logger.getLogger(ModificarTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarTipoDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarTipoDeHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar_volver;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cboxcantidadcamas;
    private javax.swing.JComboBox<String> cboxcapacidad;
    private javax.swing.JComboBox<String> cboxtipocama;
    private javax.swing.JComboBox<String> cboxtipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtprecionoche;
    // End of variables declaration//GEN-END:variables
}
