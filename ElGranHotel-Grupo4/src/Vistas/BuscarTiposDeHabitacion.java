/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Reserva;
import Logica.Conexion;
import Logica.HabitacionData;
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
public class BuscarTiposDeHabitacion extends javax.swing.JInternalFrame {

    private Conexion con;
    private int id_tipohab;
    //private int id_habi;
    
    public BuscarTiposDeHabitacion() {
        initComponents();
        
        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificartipohabitacion.setEnabled(false);
        btneliminartipohabitacion.setEnabled(false);
                
        mostrarTodos();
    }

    
    public void mostrarTodos(){
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData todos = new TipoDeHabitacionData(con);

            DefaultTableModel modelo;
            modelo = todos.mostrartodos();


            tablatiposhabitacion.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en mostrarTodos");
        }
    }
    
    public void mostrarPrecioMenorMayor(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData mame = new TipoDeHabitacionData(con);

            DefaultTableModel modelo;
            modelo = mame.mostrarPMenorMayor();


            tablatiposhabitacion.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en precioMenorMayor");
        }
    }
    
    public void mostrarPrecioMayorMenor(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData mame = new TipoDeHabitacionData(con);

            DefaultTableModel modelo;
            modelo = mame.mostrarPMayorMenor();


            tablatiposhabitacion.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en precioMayorMenor");
        }
    }
    
    public void mostrarCapacidadMenorMayor(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData mame = new TipoDeHabitacionData(con);

            DefaultTableModel modelo;
            modelo = mame.mostrarCMenorMayor();


            tablatiposhabitacion.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en mostrarCapacidadMenorMayor");
        }
    }
    
    public void mostrarCapacidadMayorMenor(){

        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData mame = new TipoDeHabitacionData(con);

            DefaultTableModel modelo;
            modelo = mame.mostrarCMayorMenor();


            tablatiposhabitacion.setModel(modelo);           
        } catch (Exception e) {
            System.out.println("error en mostrarCapacidadMayorMenor");
        }
    }
    
    
    public void mostrarPorTipo(int id){
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData portipo = new HabitacionData(con);

            DefaultTableModel model;
            model = portipo.buscarPorTipo(id);
            
            tablatiposhabitacion.setModel(model);           
        } catch (Exception e) {
            System.out.println("error en mostrarPorTipo");
        }
    }
    
    
    public void eliminarTipoDeHabitacion(){
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData elim = new TipoDeHabitacionData(con);

            elim.eliminar(id_tipohab);

        } catch (Exception e) {
            System.out.println("error en eliminarTipoDeHabitacion");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatiposhabitacion = new javax.swing.JTable();
        btnnuevotipohabitacion = new javax.swing.JButton();
        btnmodificartipohabitacion = new javax.swing.JButton();
        btneliminartipohabitacion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buscarporhabitacion = new javax.swing.JButton();
        cboxfiltros = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Tipos de Habitacion"));

        tablatiposhabitacion.setModel(new javax.swing.table.DefaultTableModel(
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
        tablatiposhabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablatiposhabitacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablatiposhabitacion);

        btnnuevotipohabitacion.setText("NUEVO");
        btnnuevotipohabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevotipohabitacionActionPerformed(evt);
            }
        });

        btnmodificartipohabitacion.setText("MODIFICAR");
        btnmodificartipohabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificartipohabitacionActionPerformed(evt);
            }
        });

        btneliminartipohabitacion.setText("ELIMINAR");
        btneliminartipohabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminartipohabitacionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FILTRAR");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ordenar por:");

        buscarporhabitacion.setText("BUSCAR");
        buscarporhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarporhabitacionActionPerformed(evt);
            }
        });

        cboxfiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ID", "Precio menor - mayor", "Precio mayor - menor", "Capacidad menor - mayor", "Capacidad mayor - menor" }));
        cboxfiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboxfiltrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboxfiltrosMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboxfiltrosMousePressed(evt);
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
                        .addComponent(btnnuevotipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnmodificartipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btneliminartipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboxfiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarporhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevotipohabitacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminartipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnmodificartipohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarporhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboxfiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TIPOS DE HABITACIONES");

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

    private void tablatiposhabitacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablatiposhabitacionMouseClicked
        //Cuando el admin seleccione una fila, entonces habilito los botones modificar y eliminar
        btnmodificartipohabitacion.setEnabled(true);
        btneliminartipohabitacion.setEnabled(true);
        int selec = tablatiposhabitacion.rowAtPoint(evt.getPoint());
        id_tipohab = Integer.valueOf(String.valueOf(tablatiposhabitacion.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablatiposhabitacionMouseClicked

    private void btneliminartipohabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminartipohabitacionActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar esta huesped?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //A continuacion elimino el tipo dehabitacion seleccionada.
            eliminarTipoDeHabitacion();
        }
        
        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificartipohabitacion.setEnabled(false);
        btneliminartipohabitacion.setEnabled(false);

        //Vuelvo a mostrar todos las reservas restantes
        mostrarTodos();
    }//GEN-LAST:event_btneliminartipohabitacionActionPerformed

    private void btnmodificartipohabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificartipohabitacionActionPerformed
        //En la accion de click de la tabla ya tengo el ID de la habitacion seleccionada, entonces debo invocar al jFrame
        // llamado ModificarHabitacioon para que el administrador pueda modificar los datos
        escritorio.removeAll();
        escritorio.repaint();
        ModificarTipoDeHabitacion mra = new ModificarTipoDeHabitacion(id_tipohab);
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnmodificartipohabitacionActionPerformed

    private void btnnuevotipohabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevotipohabitacionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        NuevoTipoDeHabitacion mra = new NuevoTipoDeHabitacion();
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnnuevotipohabitacionActionPerformed

    private void buscarporhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarporhabitacionActionPerformed
        //Aqui debo tomar el valor seleccionado del combo box para ver con que filtrare:
        if ((cboxfiltros.getSelectedItem().toString()).equals("Seleccione")) { 
            JOptionPane.showMessageDialog(null, "Elija una opcion de filtrado");
        } 
        else if((cboxfiltros.getSelectedItem().toString()).equals("ID")){
            mostrarTodos();      
        } 
        else if((cboxfiltros.getSelectedItem().toString()).equals("Precio menor - mayor")){
            mostrarPrecioMenorMayor();      
        } 
        else if((cboxfiltros.getSelectedItem().toString()).equals("Precio mayor - menor")){
            mostrarPrecioMayorMenor();
        }
        else if((cboxfiltros.getSelectedItem().toString()).equals("Capacidad menor - mayor")){
            mostrarCapacidadMenorMayor();
        }
        else { //Aqui busco por piso:
            mostrarCapacidadMayorMenor();
        }

    }//GEN-LAST:event_buscarporhabitacionActionPerformed

    private void cboxfiltrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxfiltrosMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboxfiltrosMousePressed

    private void cboxfiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxfiltrosMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cboxfiltrosMouseEntered

    private void cboxfiltrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxfiltrosMouseClicked

    }//GEN-LAST:event_cboxfiltrosMouseClicked

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
            java.util.logging.Logger.getLogger(BuscarTiposDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarTiposDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarTiposDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarTiposDeHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarTiposDeHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminartipohabitacion;
    private javax.swing.JButton btnmodificartipohabitacion;
    private javax.swing.JButton btnnuevotipohabitacion;
    private javax.swing.JButton buscarporhabitacion;
    private javax.swing.JComboBox<String> cboxfiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablatiposhabitacion;
    // End of variables declaration//GEN-END:variables
}
