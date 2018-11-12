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
import java.text.DateFormat;
//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dani
 */
public class BuscarReserva extends javax.swing.JInternalFrame {

    private Conexion con;
    private int id_res;
    private int id_habi;

    public BuscarReserva() {
        initComponents();

        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificarreserva.setEnabled(false);
        btneliminarreserva.setEnabled(false);
        verificarFechasReservas();
        mostrarTodas();
    }

    //El siguiente metodo invoca al metodo verificarFechaSalida de la clase ReservaData en el cual se verifica
    //que si la fecha de salida es menor a la actual, entonces la reserva pasa de estado 1 a 0, es decir de activa a inactiva.
    public void verificarFechasReservas() {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData thd = new ReservaData(con);
            thd.verificarFechaSalida();

        } catch (Exception e) {
            System.out.println("error reservacliente.java");
        }
    }

    public void mostrarTodas() {
        //Deshabilito el boton de ver todas:
        vertodas.setEnabled(false);
        Date fecha_salida;
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData todas = new ReservaData(con);

            DefaultTableModel modelo;
            modelo = todas.mostrartodas();

            tablareservas.setModel(modelo);
        } catch (Exception e) {
            System.out.println("error en mostrarTodas");
        }
    }

    public void mostrarPorHab(int id) {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData porhab = new ReservaData(con);

            DefaultTableModel model;
            model = porhab.buscarPorHabitacion(id);

            tablareservas.setModel(model);
        } catch (Exception e) {
            System.out.println("error en mostrarPorHab");
        }
    }

    public void mostrarPorHues(int id) {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData porhues = new ReservaData(con);

            DefaultTableModel model;
            model = porhues.buscarPorHuespedAdmin(id);

            tablareservas.setModel(model);
        } catch (Exception e) {
            System.out.println("error en mostrarPorHues");
        }
    }

    public void obtenerIdHab() {
        Reserva re = new Reserva();
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData rese = new ReservaData(con);
            re = rese.buscarReserva(id_res);

            id_habi = re.getId_habitacion();
        } catch (Exception e) {
            System.out.println("error en obtenerIdHab");
        }
    }

    public void habilitarHab() {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData habi = new HabitacionData(con);
            habi.desocupar(id_habi);

        } catch (Exception e) {
            System.out.println("error en habilitarHab");
        }
    }

    public void eliminarReserva() {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData elim = new ReservaData(con);

            elim.eliminarReserva(id_res);

        } catch (Exception e) {
            System.out.println("error en eliminarReserva");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablareservas = new javax.swing.JTable();
        btnnuevareserva = new javax.swing.JButton();
        btnmodificarreserva = new javax.swing.JButton();
        btneliminarreserva = new javax.swing.JButton();
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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Reservas"));

        tablareservas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablareservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablareservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablareservas);

        btnnuevareserva.setText("NUEVA");
        btnnuevareserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevareservaActionPerformed(evt);
            }
        });

        btnmodificarreserva.setText("MODIFICAR");
        btnmodificarreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarreservaActionPerformed(evt);
            }
        });

        btneliminarreserva.setText("ELIMINAR");
        btneliminarreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarreservaActionPerformed(evt);
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

        cboxfiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "ID Habitacion", "ID huesped" }));

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
                                .addComponent(btnnuevareserva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btnmodificarreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(btneliminarreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(btnnuevareserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminarreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnmodificarreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        jLabel1.setText("RESERVAS");

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

    private void tablareservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablareservasMouseClicked
        //Cuando el admin seleccione una fila, entonces habilito los botones modificar y eliminar
        btnmodificarreserva.setEnabled(true);
        btneliminarreserva.setEnabled(true);
        int selec = tablareservas.rowAtPoint(evt.getPoint());
        id_res = Integer.valueOf(String.valueOf(tablareservas.getValueAt(selec, 0)));
    }//GEN-LAST:event_tablareservasMouseClicked

    private void btneliminarreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarreservaActionPerformed
        //Al eliminar la reserva, debo volver a habilitar la habitacion que estaba asiganda a esa reserva, entonces
        //primero obtengo el id de la habitacion relacionada a esa reserva:

        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente eliminar esta reserva?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            obtenerIdHab();
            habilitarHab();

            //A continuacion elimino la reserva seleccionada.
            eliminarReserva();
        }

        //A continuacion desabilito los botones de modificar y eliminar hasta que el admin haga click en una reserva:
        btnmodificarreserva.setEnabled(false);
        btneliminarreserva.setEnabled(false);

        //Vuelvo a mostrar todas las reservas restantes
        mostrarTodas();
    }//GEN-LAST:event_btneliminarreservaActionPerformed

    private void btnmodificarreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarreservaActionPerformed
        //En la accion de click de la tabla ya tengo el ID de la reserva seleccionada, entonces debo invocar al jFrame
        // llamado ModificarReservaAdmin para que el administrador pueda modificar los datos
        escritorio.removeAll();
        escritorio.repaint();
        ModificarReservaAdmin mra = new ModificarReservaAdmin(id_res);
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnmodificarreservaActionPerformed

    private void btnnuevareservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevareservaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ReservaAdministrador mra = new ReservaAdministrador();
        int x = (escritorio.getWidth() / 2) - mra.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - mra.getHeight() / 2;
        mra.setLocation(x, y);
        escritorio.add(mra);
        mra.toFront();
        mra.setVisible(true);
    }//GEN-LAST:event_btnnuevareservaActionPerformed

    private void buscarporhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarporhabitacionActionPerformed
        //Aqui debo tomar el valor seleccionado del combo box para ver con que filtrare:
        if ((cboxfiltros.getSelectedItem().toString()).equals("Seleccione")) {        //Compruebo si se ha indicado la cantidad de adultos

            JOptionPane.showMessageDialog(null, "Elija una opcion de filtrado");

        } else if (txtvalorfiltro.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor de búsqueda");

        } else if ((cboxfiltros.getSelectedItem().toString()).equals("ID Habitacion")) {    //Compruebo si se ha indicado la cantidad de niños
            int id_seleccionado = Integer.parseInt(txtvalorfiltro.getText());
            mostrarPorHab(id_seleccionado);

        } else {
            int id_seleccionado = Integer.parseInt(txtvalorfiltro.getText());
            mostrarPorHues(id_seleccionado);
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

            JOptionPane.showMessageDialog(null, "El ID debe ser un número");
        }
    }//GEN-LAST:event_txtvalorfiltroKeyTyped

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
            java.util.logging.Logger.getLogger(BuscarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarReserva().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminarreserva;
    private javax.swing.JButton btnmodificarreserva;
    private javax.swing.JButton btnnuevareserva;
    private javax.swing.JButton buscarporhabitacion;
    private javax.swing.JComboBox<String> cboxfiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablareservas;
    private javax.swing.JTextField txtvalorfiltro;
    private javax.swing.JButton vertodas;
    // End of variables declaration//GEN-END:variables
}
