/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Huesped;
import Datos.Reserva;
import Logica.Conexion;
import Logica.HabitacionData;
import Logica.HuespedData;
import Logica.ReservaData;
import static Vistas.Inicio.escritorio;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author servi
 */
public class ConfirmaReservaAdmin extends javax.swing.JInternalFrame {

    private int id_reserva;
    private int id_huesped;
    private Conexion con;
    private Huesped hues;
    private Reserva res;

    private int adultos;
    private int niños;
    private int numhab;
    private double precio_noche;

    public ConfirmaReservaAdmin(int id_reserva, int id_huesped, int adultos, int niños, int numhab, double precio_noche) {
        initComponents();
        this.id_reserva = id_reserva;
        this.id_huesped = id_huesped;
        this.adultos = adultos;
        this.niños = niños;
        this.numhab = numhab;
        this.precio_noche = precio_noche;

        //System.out.println(this.id_reserva + " - " + this.id_huesped);

        //Como tengo los datos de la reserva y el huesped, procedo a mostrar esta informacion mediante las siguientes funciones:
        obtenerHuesped();
        obtenerReserva();
        mostrarHuesped();
        mostrarReserva();

    }

    public ConfirmaReservaAdmin() {
        initComponents();
    }

    public void obtenerHuesped() {
        try {
            hues = new Huesped();
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HuespedData hd = new HuespedData(con);
            hues = hd.buscarHuesped(id_huesped);

            //System.out.println("El nombre del guacho es:" + hues.getNombre());
        } catch (Exception e) {
            System.out.println("error en obtenerHuesped");
        }
    }

    public void obtenerReserva() {
        try {
            res = new Reserva();
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData rd = new ReservaData(con);
            res = rd.buscarReserva(id_reserva);

        } catch (Exception e) {
            System.out.println("error en obtenerReservas");
        }
    }

    public void mostrarHuesped() {
        lbldatoshuesped.setText(hues.getApellido() + ", " + hues.getNombre() + ". - DNI: " + hues.getDni() + ". - ID: " + hues.getId_huesped());
    }

    public void mostrarReserva() {
        lblfechallegada.setText("" + res.getFecha_entrada());
        lblfechasalida.setText("" + res.getFecha_salida());
        lbladultos.setText("" + this.adultos);
        lblniños.setText("" + this.niños);
        int noches = (int) (res.getImporte() / precio_noche);
        lblnoches.setText("" + noches);
        lblprecionoche.setText("" + precio_noche);
        lblpreciototal.setText("" + res.getImporte());
        lblhabitacion.setText("" + numhab);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbldatoshuesped = new javax.swing.JLabel();
        lblfechallegada = new javax.swing.JLabel();
        lblfechasalida = new javax.swing.JLabel();
        lbladultos = new javax.swing.JLabel();
        lblniños = new javax.swing.JLabel();
        lblnoches = new javax.swing.JLabel();
        lblprecionoche = new javax.swing.JLabel();
        lblpreciototal = new javax.swing.JLabel();
        lblhabitacion = new javax.swing.JLabel();
        descartar = new javax.swing.JButton();
        btnconfirmar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Fecha de llegada:");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha de salida:");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Adultos:");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Niños:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cantidad de noches:");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio por noche:");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Precio total");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Habitación Nro:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/silueta-de-usuario.png"))); // NOI18N

        lblfechallegada.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblfechallegada.setForeground(new java.awt.Color(0, 102, 51));
        lblfechallegada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblfechasalida.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblfechasalida.setForeground(new java.awt.Color(0, 102, 51));
        lblfechasalida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbladultos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbladultos.setForeground(new java.awt.Color(0, 102, 51));
        lbladultos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblniños.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblniños.setForeground(new java.awt.Color(0, 102, 51));
        lblniños.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblnoches.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblnoches.setForeground(new java.awt.Color(0, 102, 51));
        lblnoches.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblprecionoche.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblprecionoche.setForeground(new java.awt.Color(0, 102, 51));
        lblprecionoche.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblpreciototal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblpreciototal.setForeground(new java.awt.Color(0, 102, 51));
        lblpreciototal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblhabitacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblhabitacion.setForeground(new java.awt.Color(0, 102, 51));
        lblhabitacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        descartar.setText("DESCARTAR RESERVA");
        descartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descartarActionPerformed(evt);
            }
        });

        btnconfirmar.setText("CONFIRMAR RESERVA");
        btnconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descartar)
                        .addGap(62, 266, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbladultos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(lblfechallegada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblfechasalida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblniños, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblpreciototal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblprecionoche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnoches, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblhabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnconfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldatoshuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbldatoshuesped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblfechallegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnoches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblprecionoche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbladultos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblpreciototal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblniños, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblhabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descartar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jLabel11.setBackground(new java.awt.Color(204, 255, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("CONFIRMACIÓN DE RESERVA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmarActionPerformed
        //Si el huesped confirma la reserva, procedo a registrar en la misma, el ID del huesped y cambio el estado a 1
        try {
            Reserva ress = new Reserva();
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData rds = new ReservaData(con);
            rds.insertarIdHuesped(this.id_reserva, this.id_huesped);

        } catch (Exception e) {
            System.out.println("error en botonconfirmar");
        }
        
        //Ademas, debo cambiar el estado de la habitacion a ocupada (1):
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData rds = new HabitacionData(con);
            rds.ocupar(res.getId_habitacion());

        } catch (Exception e) {
            System.out.println("error en botonconfirmar");
        }

        JOptionPane.showMessageDialog(null, "Reserva Resgitrada Exitosamente - ID = " + id_reserva);

        //Luego de insertado el huesped, vuelvo al menu buscarPorHuesped reserva:
        escritorio.removeAll();
        escritorio.repaint();
        BuscarReserva br = new BuscarReserva();
        int x = (escritorio.getWidth() / 2) - br.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - br.getHeight() / 2;
        br.setLocation(x, y);
        escritorio.add(br);
        br.toFront();
        br.setVisible(true);


    }//GEN-LAST:event_btnconfirmarActionPerformed

    private void descartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descartarActionPerformed
        //Aqui debo eliminar la reserva guardada temporalmente y luego volver a buscarPorHuesped reservas
        
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData rdse = new ReservaData(con);
            rdse.eliminarReserva(id_reserva);
        } catch (Exception e) {
            System.out.println("error en insertarNuevoTipoDeHabitacion");
        }

        escritorio.removeAll();
        escritorio.repaint();
        BuscarReserva br = new BuscarReserva();
        int x = (escritorio.getWidth() / 2) - br.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - br.getHeight() / 2;
        br.setLocation(x, y);
        escritorio.add(br);
        br.toFront();
        br.setVisible(true);
    }//GEN-LAST:event_descartarActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmaReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmaReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmaReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmaReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmaReservaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconfirmar;
    private javax.swing.JButton descartar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbladultos;
    private javax.swing.JLabel lbldatoshuesped;
    private javax.swing.JLabel lblfechallegada;
    private javax.swing.JLabel lblfechasalida;
    private javax.swing.JLabel lblhabitacion;
    private javax.swing.JLabel lblniños;
    private javax.swing.JLabel lblnoches;
    private javax.swing.JLabel lblprecionoche;
    private javax.swing.JLabel lblpreciototal;
    // End of variables declaration//GEN-END:variables
}
