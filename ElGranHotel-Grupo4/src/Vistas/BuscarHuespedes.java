/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Reserva;
import Logica.Conexion;
import Logica.HabitacionData;
import Logica.HuespedData;
import Logica.ReservaData;
import Logica.TipoDeHabitacionData;
import static Vistas.Inicio.escritorio;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dani
 */
public class BuscarHuespedes extends javax.swing.JInternalFrame {

    private Conexion con;
    private int id_hues;
    //private int id_habi;
    
    public BuscarHuespedes() {
        initComponents();
        
        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificarhabitacion.setEnabled(false);
        btneliminarhabitacion.setEnabled(false);
                
        mostrarTodos();
    }

    
    public void mostrarTodos(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HuespedData todas = new HuespedData(con);

            DefaultTableModel modelo;
            modelo = todas.mostrartodos();


            tablahabitaciones.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en mostrarTodos");
        }
    }
    
    public void mostrarLibres(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData dispo = new HabitacionData(con);

            DefaultTableModel modelo;
            modelo = dispo.buscardisponibles();


            tablahabitaciones.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en mostrarLibres");
        }
    }
    
    public void mostrarOcupadas(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData dispo = new HabitacionData(con);

            DefaultTableModel modelo;
            modelo = dispo.buscarOcupadas();


            tablahabitaciones.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en mostrarOcupadas");
        }
    }
    
    public void mostrarPorTipo(int id){
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData portipo = new HabitacionData(con);

            DefaultTableModel model;
            model = portipo.buscarPorTipo(id);
            
            tablahabitaciones.setModel(model);           
        } catch (Exception e) {
            System.out.println("error en mostrarPorTipo");
        }
    }
    
    
    public void mostrarPorPiso(int id){
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData portipo = new HabitacionData(con);

            DefaultTableModel model;
            model = portipo.buscarPorPiso(id);
            
            tablahabitaciones.setModel(model);           
        } catch (Exception e) {
            System.out.println("error en mostrarPorPiso");
        }
    }
    
    
    public void eliminarHuesped(){
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HuespedData elim = new HuespedData(con);

            elim.eliminarHuesped(id_hues);

        } catch (Exception e) {
            System.out.println("error en eliminarHuesped");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablahabitaciones = new javax.swing.JTable();
        btnnuevahabitacion = new javax.swing.JButton();
        btnmodificarhabitacion = new javax.swing.JButton();
        btneliminarhabitacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Huespedes"));

        tablahabitaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tablahabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablahabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablahabitaciones);

        btnnuevahabitacion.setText("NUEVO");
        btnnuevahabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevahabitacionActionPerformed(evt);
            }
        });

        btnmodificarhabitacion.setText("MODIFICAR");
        btnmodificarhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarhabitacionActionPerformed(evt);
            }
        });

        btneliminarhabitacion.setText("ELIMINAR");
        btneliminarhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarhabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnnuevahabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnmodificarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btneliminarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevahabitacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnmodificarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HUESPEDES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablahabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablahabitacionesMouseClicked
        //Cuando el admin seleccione una fila, entonces habilito los botones modificar y eliminar
        btnmodificarhabitacion.setEnabled(true);
        btneliminarhabitacion.setEnabled(true);
        int selec = tablahabitaciones.rowAtPoint(evt.getPoint());
        id_hues = Integer.valueOf(String.valueOf(tablahabitaciones.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablahabitacionesMouseClicked

    private void btneliminarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarhabitacionActionPerformed
        
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar esta huesped?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //A continuacion elimino la habitacion seleccionada.
            eliminarHuesped();
        }

        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificarhabitacion.setEnabled(false);
        btneliminarhabitacion.setEnabled(false);

        //Vuelvo a mostrar todas las reservas restantes
        mostrarTodos();
    }//GEN-LAST:event_btneliminarhabitacionActionPerformed

    private void btnmodificarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarhabitacionActionPerformed
        //En la accion de click de la tabla ya tengo el ID de la habitacion seleccionada, entonces debo invocar al jFrame
        // llamado ModificarHabitacioon para que el administrador pueda modificar los datos
        escritorio.removeAll();
        escritorio.repaint();
        ModificarHuesped mra = new ModificarHuesped(id_hues);
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnmodificarhabitacionActionPerformed

    private void btnnuevahabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevahabitacionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        NuevoHuesped mra = new NuevoHuesped();
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnnuevahabitacionActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarHuespedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarHuespedes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminarhabitacion;
    private javax.swing.JButton btnmodificarhabitacion;
    private javax.swing.JButton btnnuevahabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablahabitaciones;
    // End of variables declaration//GEN-END:variables
}
