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
public class BuscarHabitacion extends javax.swing.JInternalFrame {

    private Conexion con;
    private int id_hab;
    //private int id_habi;

    public BuscarHabitacion() {
        initComponents();

        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificarhabitacion.setEnabled(false);
        btneliminarhabitacion.setEnabled(false);

        mostrarTodas();
    }

    public void mostrarTodas() {
        //Deshabilito el boton de ver todas:
        vertodas.setEnabled(false);
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData todas = new HabitacionData(con);

            DefaultTableModel modelo;
            modelo = todas.mostrartodas();

            tablahabitaciones.setModel(modelo);
        } catch (Exception e) {
            System.out.println("error en mostrarTodas");
        }
    }

    public void mostrarLibres() {
        //Habilito el boton de ver todas:
        vertodas.setEnabled(true);
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

    public void mostrarOcupadas() {
        //Habilito el boton de ver todas:
        vertodas.setEnabled(true);
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

    public void mostrarPorTipo(int id) {
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

    public void mostrarPorPiso(int id) {
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

    public void eliminarHabitacion() {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData elim = new HabitacionData(con);

            elim.eliminar(id_hab);

        } catch (Exception e) {
            System.out.println("error en eliminarHabitacion");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtvalorfiltro = new javax.swing.JTextField();
        buscarporhabitacion = new javax.swing.JButton();
        vertodas = new javax.swing.JButton();
        cboxfiltros = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Habitaciones"));

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

        btnnuevahabitacion.setText("NUEVA");
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FILTRAR");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Opciones de filtrado:");

        txtvalorfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalorfiltroKeyTyped(evt);
            }
        });

        buscarporhabitacion.setText("BUSCAR");
        buscarporhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarporhabitacionActionPerformed(evt);
            }
        });

        vertodas.setText("Ver Todas");
        vertodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vertodasActionPerformed(evt);
            }
        });

        cboxfiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ID Tipo Habitacion", "Libres", "Ocupadas", "Piso" }));
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnnuevahabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btnmodificarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(btneliminarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 259, Short.MAX_VALUE)
                        .addComponent(vertodas)
                        .addGap(273, 273, 273))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboxfiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtvalorfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarporhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(vertodas)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnnuevahabitacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnmodificarhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarporhabitacion)
                    .addComponent(cboxfiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalorfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HABITACIONES");

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
        id_hab = Integer.valueOf(String.valueOf(tablahabitaciones.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablahabitacionesMouseClicked

    private void btneliminarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarhabitacionActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar esta habitación?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //A continuacion elimino la habitacion seleccionada.
            eliminarHabitacion();
        }

        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificarhabitacion.setEnabled(false);
        btneliminarhabitacion.setEnabled(false);

        //Vuelvo a mostrar todas las reservas restantes
        mostrarTodas();
    }//GEN-LAST:event_btneliminarhabitacionActionPerformed

    private void btnmodificarhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarhabitacionActionPerformed
        //En la accion de click de la tabla ya tengo el ID de la habitacion seleccionada, entonces debo invocar al jFrame
        // llamado ModificarHabitacioon para que el administrador pueda modificar los datos
        escritorio.removeAll();
        escritorio.repaint();
        ModificarHabitacion mra = new ModificarHabitacion(id_hab);
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
        NuevaHabitacion mra = new NuevaHabitacion();
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnnuevahabitacionActionPerformed

    private void buscarporhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarporhabitacionActionPerformed
        //Aqui debo tomar el valor seleccionado del combo box para ver con que filtrare:
        if ((cboxfiltros.getSelectedItem().toString()).equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Elija una opcion de filtrado");
            txtvalorfiltro.setEnabled(true);
        } else if ((cboxfiltros.getSelectedItem().toString()).equals("ID Tipo Habitacion") && txtvalorfiltro.getText().length() != 0) {
            int id_seleccionado = Integer.parseInt(txtvalorfiltro.getText());
            mostrarPorTipo(id_seleccionado);
            //txtvalorfiltro.setEnabled(true);
        } else if ((cboxfiltros.getSelectedItem().toString()).equals("Libres")) {
            //txtvalorfiltro.setEnabled(false);
            mostrarLibres();
        } else if ((cboxfiltros.getSelectedItem().toString()).equals("Ocupadas")) {
            //txtvalorfiltro.setEnabled(false);
            mostrarOcupadas();
        } else if ((cboxfiltros.getSelectedItem().toString()).equals("Piso") && txtvalorfiltro.getText().length() != 0) {
            int id_seleccionado = Integer.parseInt(txtvalorfiltro.getText());
            mostrarPorPiso(id_seleccionado);

        } else { //Aqui busco por piso:
            //txtvalorfiltro.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor de búsqueda");
        }

        //habilito el boton ver todas:
        vertodas.setEnabled(true);
    }//GEN-LAST:event_buscarporhabitacionActionPerformed

    private void vertodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vertodasActionPerformed
        //Con este boton vuelvo a mostrar todas las reservas, sin filtros
        mostrarTodas();
    }//GEN-LAST:event_vertodasActionPerformed

    private void txtvalorfiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalorfiltroKeyTyped
        //Aqui valido que en el campo ID solo se ingresen numeros:
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Solo se permiten valores numéricos");
        }
    }//GEN-LAST:event_txtvalorfiltroKeyTyped

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
            java.util.logging.Logger.getLogger(BuscarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarHabitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarHabitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminarhabitacion;
    private javax.swing.JButton btnmodificarhabitacion;
    private javax.swing.JButton btnnuevahabitacion;
    private javax.swing.JButton buscarporhabitacion;
    private javax.swing.JComboBox<String> cboxfiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablahabitaciones;
    private javax.swing.JTextField txtvalorfiltro;
    private javax.swing.JButton vertodas;
    // End of variables declaration//GEN-END:variables
}
