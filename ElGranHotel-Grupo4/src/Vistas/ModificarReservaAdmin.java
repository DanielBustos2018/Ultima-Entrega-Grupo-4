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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dani
 */
public class ModificarReservaAdmin extends javax.swing.JInternalFrame {

    int id_res;
    private Conexion con;
    Reserva res;

    private Date f_llegada;
    private Date f_salida;
    int diassalida = 0;
    private double costototal;
    private int id_hab;
    private double costonoche;

    public ModificarReservaAdmin() {
        initComponents();
    }

    public ModificarReservaAdmin(int id_rese) {
        initComponents();
        this.id_res = id_rese;
        mostrarDatosReserva();
    }

    public void mostrarDatosReserva() {
        //primero obtengo los datos y luego los muestro:
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            res = new Reserva();

            ReservaData rd = new ReservaData(con);
            res = rd.buscarReserva(id_res);

            lblid.setText("" + id_res);
            txtidhuesped.setText("" + res.getId_huesped());
            txtidhabitacion.setText("" + res.getId_habitacion());
            txtcantidadpersonas.setText("" + res.getCantidad_personas());
            txtfechaentrada.setDate(res.getFecha_entrada());
            txtfechasalida.setDate(res.getFecha_salida());
            txtimporte.setText("" + res.getImporte());
            txtestado.setText("" + res.getEstado());

            id_hab = res.getId_habitacion();

            //System.out.println("el id de la habitacion es: " + id_hab);

        } catch (Exception e) {
            System.out.println("error en mostrtarDatosReserva");
        }
    }

    public void calculoImporte() {
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData hdd = new HabitacionData(con);
            int id_tipo = hdd.buscarHabitacion(id_hab);

            //System.out.println("el id del tipo de habitacion es: " + id_tipo);

            TipoDeHabitacionData thd = new TipoDeHabitacionData(con);
            costonoche = thd.buscarPrecio(id_tipo);

            //System.out.println("el costo por noche es: " + costonoche);

            comprobarFechaLlegada();

            costototal = costonoche * diassalida;

            //System.out.println("Las ncohes son: " + diassalida);
            //System.out.println("el costo total es: " + costototal);

        } catch (Exception e) {
            System.out.println("error en calculoImporte");
        }
    }

    public void comprobarFechaSalida(int año, int mes, int dia) {
        int fsalida[] = {0, 0, 0};

        if (txtfechasalida.getDate() != null) {   //Compruebo que se haya ingreado una fecha de llegada
            //En las siguientes 4 lineas obtengo la fecha de llegada en formato String:
            String dias = Integer.toString(txtfechasalida.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mess = Integer.toString(txtfechasalida.getCalendar().get(Calendar.MONTH) + 1);
            String years = Integer.toString(txtfechasalida.getCalendar().get(Calendar.YEAR));
            //String fechas = (dias + "-" + mess + "-" + years);
            //System.out.println(fechal);

            //A continuacion convierto las fechas en enteros para luego compararlas entre ellas y con la fecha actual
            //con el finde comprobr que:
            //  *la fecha de llegada sea igual o mayor a la fecha actual
            //  *la fecha de salida sea mayor a la fecha de llegada           
            fsalida[0] = Integer.parseInt(dias);
            fsalida[1] = Integer.parseInt(mess);
            fsalida[2] = Integer.parseInt(years);

            //A continuacion Compruebo que la fecha de salida ingresada sea mayor a la fecha de llegada
            /*Calendar fecha = Calendar.getInstance();
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int año = fecha.get(Calendar.YEAR);*/
            f_salida = new Date(año, mes, dia);
            Date fechaProxima = new Date(fsalida[2], fsalida[1], fsalida[0]);

            diassalida = (int) ((fechaProxima.getTime() - f_salida.getTime()) / 86400000);
            //System.out.println("Hay " + diassalida + " dias de diferencia");

            if (diassalida > 0) { //Si a fecha de salida es mayor que a de llegada, entonces el dato esta bien y paso a comprobar la fecha de salida
                //comprobarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha de salida mayor a la fecha de llegada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de salida");
        }
    }

    public void comprobarFechaLlegada() {
        int fllegada[] = {1, 2, 2};

        if (txtfechaentrada.getDate() != null) {   //Compruebo que se haya ingreado una fecha de llegada
            //En las siguientes 4 lineas obtengo la fecha de llegada en formato String:
            String dial = Integer.toString(txtfechaentrada.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mesl = Integer.toString(txtfechaentrada.getCalendar().get(Calendar.MONTH) + 1);
            String yearl = Integer.toString(txtfechaentrada.getCalendar().get(Calendar.YEAR));
            //String fechal = (dial + "-" + mesl + "-" + yearl);
            //System.out.println(fechal);

            //A continuacion convierto las fechas en enteros para luego compararlas entre ellas y con la fecha actual
            //con el finde comprobr que:
            //  *la fecha de llegada sea igual o mayor a la fecha actual
            //  *la fecha de salida sea mayor a la fecha de llegada           
            fllegada[0] = Integer.parseInt(dial);
            fllegada[1] = Integer.parseInt(mesl);
            fllegada[2] = Integer.parseInt(yearl);

            //A continuacion Compruebo que la fecha de entrada ingresada sea igual o mayor a la actual
            Calendar fecha = Calendar.getInstance();
            int dia = fecha.get(Calendar.DAY_OF_MONTH);
            int mes = fecha.get(Calendar.MONTH) + 1;
            int año = fecha.get(Calendar.YEAR);
            f_llegada = new Date(año, mes, dia);
            Date fechaProxima = new Date(fllegada[2], fllegada[1], fllegada[0]);

            //int dias = (int) ((fechaProxima.getTime() - f_llegada.getTime()) / 86400000);
            //System.out.println("Hay " + dias + " dias de diferencia");
            //if (dias >= 0) { //Si a fecha de llegada coincide con la actual o es mayor, entonces el dato esta bien y paso a comprobar la fecha de salida
            comprobarFechaSalida(fllegada[2], fllegada[1], fllegada[0]);
            //} else {
            //    JOptionPane.showConfirmDialog(null, "Ingrese una fecha de llegada correcta");
            //}

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de llegada");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        txtidhuesped = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtfechasalida = new com.toedter.calendar.JDateChooser();
        txtfechaentrada = new com.toedter.calendar.JDateChooser();
        txtidhabitacion = new javax.swing.JLabel();
        txtcantidadpersonas = new javax.swing.JLabel();
        txtimporte = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificación de Reserva"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Id_reserva");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Id_huesped");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Id_habitación");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fecha de Entrada");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fecha de Salida");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cantidad de Personas");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Importe");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Estado");

        lblid.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(0, 0, 153));
        lblid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtidhuesped.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        txtidhuesped.setForeground(new java.awt.Color(0, 0, 255));
        txtidhuesped.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtestado.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jButton2.setText("VOLVER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtfechasalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtfechasalidaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtfechasalidaMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtfechasalidaMousePressed(evt);
            }
        });

        txtidhabitacion.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        txtidhabitacion.setForeground(new java.awt.Color(0, 0, 153));
        txtidhabitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtcantidadpersonas.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        txtcantidadpersonas.setForeground(new java.awt.Color(0, 0, 153));
        txtcantidadpersonas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtimporte.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        txtimporte.setForeground(new java.awt.Color(0, 0, 153));
        txtimporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtfechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtfechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtidhuesped))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtidhabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtcantidadpersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtidhuesped, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(lblid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtidhabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcantidadpersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MODIFICACIÓN DE RESERVA");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("En esta ventana solo se permite modificar Id_huesped, Fechas y Estado");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Si desea modificar otro parámetro deberá eliminar esta reserva y crear otra nueva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Vuelvo al listado de reservas, es decir, al frame BuscarReserva:
        escritorio.removeAll();
        escritorio.repaint();
        BuscarReserva form = new BuscarReserva();
        int x = (escritorio.getWidth() / 2) - form.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - form.getHeight() / 2;
        form.setLocation(x, y);
        escritorio.add(form);
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        //Guardo las modificaciones hechas a la reserva con ID = id_res:
        //creo una instancia Reserva para guardar los datos del frame:
        Reserva resmod;
        try {
            resmod = new Reserva();
            //a continuacion preparo las fechas en formato sql:
            java.util.Date utilStartDate = txtfechaentrada.getDate();
            java.sql.Date f_entrada = new java.sql.Date(utilStartDate.getTime());
            java.util.Date utilEndDate = txtfechasalida.getDate();
            java.sql.Date f_salida = new java.sql.Date(utilEndDate.getTime());

            resmod.setId_reserva(id_res);
            resmod.setId_huesped(Integer.parseInt(txtidhuesped.getText()));
            resmod.setId_habitacion(Integer.parseInt(txtidhabitacion.getText()));
            resmod.setFecha_entrada(f_entrada);
            resmod.setFecha_salida(f_salida);
            resmod.setCantidad_personas(Integer.parseInt(txtcantidadpersonas.getText()));

            //Para calcular el importe necesitamos saber el costo por noche y para ello debo buscarPorHuesped en la habitacion, su tipo
            //y luego buscarPorHuesped el precio de este tipo:
            calculoImporte();

            txtimporte.setText("" + costototal);
            resmod.setImporte(costototal);

            resmod.setEstado(Integer.parseInt(txtestado.getText()));

            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");

            ReservaData rd = new ReservaData(con);
            rd.editarReserva(resmod);

            JOptionPane.showMessageDialog(null, "Datos Guardados Exitosamente");

            //Luego de modificada la reserva, vuelvo al menu buscarPorHuesped reserva:
            escritorio.removeAll();
            escritorio.repaint();
            BuscarReserva br = new BuscarReserva();
            int x = (escritorio.getWidth() / 2) - br.getWidth() / 2;
            int y = (escritorio.getHeight() / 2) - br.getHeight() / 2;
            br.setLocation(x, y);
            escritorio.add(br);
            br.toFront();
            br.setVisible(true);

        } catch (Exception e) {
            System.out.println("error en boton guardar");
        }


    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtfechasalidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfechasalidaMouseClicked
        //

    }//GEN-LAST:event_txtfechasalidaMouseClicked

    private void txtfechasalidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfechasalidaMousePressed

    }//GEN-LAST:event_txtfechasalidaMousePressed

    private void txtfechasalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfechasalidaMouseEntered
        System.out.println("funciono");
    }//GEN-LAST:event_txtfechasalidaMouseEntered

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
            java.util.logging.Logger.getLogger(ModificarReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarReservaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarReservaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel txtcantidadpersonas;
    private javax.swing.JTextField txtestado;
    private com.toedter.calendar.JDateChooser txtfechaentrada;
    private com.toedter.calendar.JDateChooser txtfechasalida;
    private javax.swing.JLabel txtidhabitacion;
    private javax.swing.JTextField txtidhuesped;
    private javax.swing.JLabel txtimporte;
    // End of variables declaration//GEN-END:variables
}
