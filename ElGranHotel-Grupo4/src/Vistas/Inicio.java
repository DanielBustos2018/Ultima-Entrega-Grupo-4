/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Logica.ImagenFondo;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author servi
 */
public class Inicio extends javax.swing.JFrame {

    private int id_huesped;
    
    
    public Inicio() {
        initComponents();
       
        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(Inicio.MAXIMIZED_BOTH);

        menuhabitaciones.setEnabled(false);
        menutipos.setEnabled(false);
        menuhuespedes.setEnabled(false);
        menureservas.setEnabled(false);
        huespedmisreservas.setEnabled(false);
        huespedmisdatos.setEnabled(false);
        this.setTitle("Sistema de Administración de Gran Hotel Safari - Versión 1.0 - Grupo 4");
    }
    
    public Inicio(int valor) {
        initComponents();
        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(Inicio.MAXIMIZED_BOTH);
        menuhabitaciones.setEnabled(false);
        menutipos.setEnabled(false);
        menuhuespedes.setEnabled(false);
        menureservas.setEnabled(false);
        huespedmisreservas.setEnabled(false);
        huespedmisdatos.setEnabled(false);
        this.setTitle("Sistema de Administración de Gran Hotel Safari - Versión 1.0 - Grupo 4");
        
        //Ingreso a la parte de reserva:
        escritorio.removeAll();
        escritorio.repaint();
        ReservaCliente br = new ReservaCliente();
        int x = (1366 / 2) - br.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - br.getHeight() / 2;
        
        System.out.println(escritorio.getWidth() + " - " + escritorio.getHeight());
        
        if (br.isShowing()) {
            br.setLocation(x, 0);
        } else {
            escritorio.add(br);
            br.setLocation(x, 0);
            br.show();
        }
    }

    public Inicio(String admin, int id_huesped) {
        initComponents();
        this.id_huesped = id_huesped;
        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(Inicio.MAXIMIZED_BOTH);
        menuhabitaciones.setEnabled(true);
        menutipos.setEnabled(true);
        menuhuespedes.setEnabled(true);
        menureservas.setEnabled(true);
        ingresohuesped.setEnabled(false);
        reservahuesped.setEnabled(false);
        this.setTitle("Sistema de Administración de Gran Hotel Safari - Versión 1.0 - Grupo 4");
    }
    
    public Inicio(boolean admin, int id_huesped) {
        initComponents();
        this.id_huesped = id_huesped;
        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(Inicio.MAXIMIZED_BOTH);
        menuhabitaciones.setEnabled(false);
        menutipos.setEnabled(false);
        menuhuespedes.setEnabled(false);
        menureservas.setEnabled(false);
        huespedmisreservas.setEnabled(true);
        huespedmisdatos.setEnabled(true);
        ingresohuesped.setEnabled(false);
        this.setTitle("Sistema de Administración de Gran Hotel Safari - Versión 1.0 - Grupo 4");
    }

    public void centrar(JInternalFrame j) {
        int x = (escritorio.getWidth() / 2) - j.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - j.getHeight() / 2;
        
        System.out.println(x + " - " + y);
        
        if (j.isShowing()) {
            j.setLocation(x, y);
        } else {
            escritorio.add(j);
            j.setLocation(x, y);
            j.show();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        openMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        reservahuesped = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        ingresohuesped = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        huespedmisreservas = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        huespedmisdatos = new javax.swing.JMenuItem();
        menuhabitaciones = new javax.swing.JMenu();
        menubuscarhabitacion1 = new javax.swing.JMenuItem();
        menutipos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuhuespedes = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menureservas = new javax.swing.JMenu();
        menubuscarreserva = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        menuBar.setForeground(new java.awt.Color(255, 0, 0));
        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuBar.setPreferredSize(new java.awt.Dimension(1100, 38));

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/carpeta.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/eliminar.png"))); // NOI18N
        jMenuItem7.setText("Cerrar Sesion");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(140, 30));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem7);
        fileMenu.add(jSeparator4);

        openMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/001-flecha-de-volver-a-cargar.png"))); // NOI18N
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Salir");
        openMenuItem.setPreferredSize(new java.awt.Dimension(140, 30));
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/administrador-con-tuercas.png"))); // NOI18N
        helpMenu.setMnemonic('h');
        helpMenu.setText("Administrador");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/002-pagina-de-inicio.png"))); // NOI18N
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Ingreso");
        aboutMenuItem.setPreferredSize(new java.awt.Dimension(120, 30));
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/silueta-de-usuario.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Huesped");
        editMenu.setPreferredSize(new java.awt.Dimension(120, 32));
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });

        reservahuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/001-anadir-nuevo-documento.png"))); // NOI18N
        reservahuesped.setMnemonic('t');
        reservahuesped.setText("Nueva reserva");
        reservahuesped.setPreferredSize(new java.awt.Dimension(140, 30));
        reservahuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservahuespedActionPerformed(evt);
            }
        });
        editMenu.add(reservahuesped);
        editMenu.add(jSeparator1);

        ingresohuesped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/002-pagina-de-inicio.png"))); // NOI18N
        ingresohuesped.setMnemonic('c');
        ingresohuesped.setText("Ingreso/Registro");
        ingresohuesped.setPreferredSize(new java.awt.Dimension(140, 30));
        ingresohuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresohuespedActionPerformed(evt);
            }
        });
        editMenu.add(ingresohuesped);
        editMenu.add(jSeparator2);

        huespedmisreservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/002-pagina-de-documento-de-texto.png"))); // NOI18N
        huespedmisreservas.setText("Mis reservas");
        huespedmisreservas.setPreferredSize(new java.awt.Dimension(140, 30));
        huespedmisreservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huespedmisreservasActionPerformed(evt);
            }
        });
        editMenu.add(huespedmisreservas);
        editMenu.add(jSeparator3);

        huespedmisdatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/reanudar.png"))); // NOI18N
        huespedmisdatos.setText("Mis Datos");
        huespedmisdatos.setPreferredSize(new java.awt.Dimension(140, 30));
        huespedmisdatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huespedmisdatosActionPerformed(evt);
            }
        });
        editMenu.add(huespedmisdatos);

        menuBar.add(editMenu);

        menuhabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/001-clave.png"))); // NOI18N
        menuhabitaciones.setText("ABM Habitaciones");
        menuhabitaciones.setPreferredSize(new java.awt.Dimension(160, 32));

        menubuscarhabitacion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/003-lupa-de-busqueda.png"))); // NOI18N
        menubuscarhabitacion1.setText("Buscar Habitacion");
        menubuscarhabitacion1.setPreferredSize(new java.awt.Dimension(140, 30));
        menubuscarhabitacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubuscarhabitacion1ActionPerformed(evt);
            }
        });
        menuhabitaciones.add(menubuscarhabitacion1);

        menuBar.add(menuhabitaciones);

        menutipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/003-clasificacion.png"))); // NOI18N
        menutipos.setText("ABM Tipos de Habitacion");
        menutipos.setPreferredSize(new java.awt.Dimension(200, 32));

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/003-lupa-de-busqueda.png"))); // NOI18N
        jMenuItem2.setText("Buscar Tipo");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(140, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menutipos.add(jMenuItem2);

        menuBar.add(menutipos);

        menuhuespedes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/usuarios-multiples-en-silueta.png"))); // NOI18N
        menuhuespedes.setText("ABM Huespedes");
        menuhuespedes.setMaximumSize(new java.awt.Dimension(160, 32767));
        menuhuespedes.setPreferredSize(new java.awt.Dimension(140, 30));
        menuhuespedes.setRequestFocusEnabled(false);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/003-lupa-de-busqueda.png"))); // NOI18N
        jMenuItem3.setText("Buscar Huesped");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(140, 30));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuhuespedes.add(jMenuItem3);

        menuBar.add(menuhuespedes);

        menureservas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menureservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/002-reserva.png"))); // NOI18N
        menureservas.setText("ABM Reservas");
        menureservas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menureservas.setPreferredSize(new java.awt.Dimension(150, 36));
        menureservas.setRequestFocusEnabled(false);

        menubuscarreserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/003-lupa-de-busqueda.png"))); // NOI18N
        menubuscarreserva.setText("Buscar Reserva");
        menubuscarreserva.setPreferredSize(new java.awt.Dimension(140, 30));
        menubuscarreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubuscarreservaActionPerformed(evt);
            }
        });
        menureservas.add(menubuscarreserva);

        menuBar.add(menureservas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenuActionPerformed

    private void ingresohuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresohuespedActionPerformed
        this.dispose();
        LoginORegistroHuesped form = new LoginORegistroHuesped();
        form.setLocationRelativeTo(null);   //Con esta linea, centro el JFrame al medio de la pantalla
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_ingresohuespedActionPerformed

    private void reservahuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservahuespedActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        ReservaCliente br = new ReservaCliente();
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);
    }//GEN-LAST:event_reservahuespedActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed

        this.dispose();
        LoginAdministrador form = new LoginAdministrador();
        form.setLocationRelativeTo(null);   //Con esta linea, centro el JFrame al medio de la pantalla
        form.toFront();
        form.setVisible(true);

        /*escritorio.removeAll();
        escritorio.repaint();
        LoginAdministrador form =new LoginAdministrador();
        
        //escritorio.add(form);
        centrar(form);
        //form.toFront();
        //form.setVisible(true);*/
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void menubuscarreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubuscarreservaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BuscarReserva br = new BuscarReserva();
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);
    }//GEN-LAST:event_menubuscarreservaActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void huespedmisreservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huespedmisreservasActionPerformed
        //Aqui abro el internal frame que muestra las reservas del huesped:
        escritorio.removeAll();
        escritorio.repaint();
        MisReservas br = new MisReservas(id_huesped);
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);

    }//GEN-LAST:event_huespedmisreservasActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //Aqui cierro esta ventana y abro la de Inicio:

        this.dispose();
        Inicio in = new Inicio();
        in.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void menubuscarhabitacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubuscarhabitacion1ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BuscarHabitacion br = new BuscarHabitacion();
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);
    }//GEN-LAST:event_menubuscarhabitacion1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BuscarTiposDeHabitacion br = new BuscarTiposDeHabitacion();
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        BuscarHuespedes br = new BuscarHuespedes();
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void huespedmisdatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huespedmisdatosActionPerformed
        //Aqui abro el internal frame que muestra las reservas del huesped:
        escritorio.removeAll();
        escritorio.repaint();
        MisDatos br = new MisDatos(id_huesped);
        centrar(br);
        //escritorio.add(form);
        //form.toFront();
        //form.setVisible(true);

    }//GEN-LAST:event_huespedmisdatosActionPerformed

    private void habilitarAdmin() {

    }

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu editMenu;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem huespedmisdatos;
    private javax.swing.JMenuItem huespedmisreservas;
    private javax.swing.JMenuItem ingresohuesped;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menubuscarhabitacion1;
    private javax.swing.JMenuItem menubuscarreserva;
    private javax.swing.JMenu menuhabitaciones;
    private javax.swing.JMenu menuhuespedes;
    private javax.swing.JMenu menureservas;
    private javax.swing.JMenu menutipos;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem reservahuesped;
    // End of variables declaration//GEN-END:variables

}
