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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author servi
 */
public class ReservaCliente extends javax.swing.JInternalFrame {

    private Conexion con;
    
    int diassalida = 0;
    int id_hab_elegida = 0;
    int nro_hab_elegida;
    int adultos;
    int niños;
    int total = 0;
    
    int id_reserva;
    
    private Date f_llegada;
    private Date f_salida;
    private double costototal;
    
    private int id = 0;
    private String tipo = null;
    private int capacidad = 0;
    private int cant_camas = 0;
    private String tipo_cama = null;
    private double precio_noche = 0;
    
    DefaultTableModel modelotipos;
    DefaultTableModel modelohabs;

    public ReservaCliente() {
        initComponents();
        btnsiguientehab.setEnabled(false); //Deshabilito el botón siguiente para elegir un tipo deseado
        
        //A continuación seteo los nombres de las columnas de ámbas tablas, pero en este caso, para el huesped, solo muestro
        //parametros importantes y quito ID, Estado, etc.:
        String[] titulos = {"ID", "Tipo", "Capacidad" , "Cantidad de camas", "Tipo de cama", "Precio por noche"};
        modelotipos = new DefaultTableModel(null, titulos);
        tablatiposhab.setModel(modelotipos);
        String[] tituloshab = {"ID", "Numero", "Piso", "Noches", "Costo toal"};
        modelohabs = new DefaultTableModel(null, tituloshab);
        tablahabs.setModel(modelohabs);
        
        //A continuacion deshabilito las columnas de la tabla habitaciones que no necesita ver el huesped:
        ocultarColumnasHab();
        
        //A continuacion deshabilito las columnas de la tabla tipos de habitacion que no necesita ver el huesped:
        ocultarColumnasTipos();
        
    }
    
    public void ocultarColumnasHab(){
        //Columna ID
        tablahabs.getColumnModel().getColumn(0).setMaxWidth(0);
        tablahabs.getColumnModel().getColumn(0).setMinWidth(0);
        tablahabs.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablahabs.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    public void ocultarColumnasTipos(){
        //Columna ID
        tablatiposhab.getColumnModel().getColumn(0).setMaxWidth(0);
        tablatiposhab.getColumnModel().getColumn(0).setMinWidth(0);
        tablatiposhab.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tablatiposhab.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    }
    
    
    public void registrarReserva(){
        Reserva r = new Reserva();
        
        java.util.Date utilStartDate = fechallegada.getDate();
        java.sql.Date f_llegada = new java.sql.Date(utilStartDate.getTime());
        java.util.Date utilEndDate = fechasalida.getDate();
        java.sql.Date f_salida = new java.sql.Date(utilEndDate.getTime());
        
        r.setId_habitacion(id_hab_elegida);
        r.setFecha_entrada(f_llegada);
        r.setFecha_salida(f_salida);
        r.setImporte(costototal);
        r.setCantidad_personas(total);
        r.setEstado(2);
        
        try {
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            ReservaData rd = new ReservaData(con);
            
            //En id_reserva, obtengo el ID asignado a esta reserva, esto me permitirá luego guardar el ID del huesped en
            //la misma reserva.
            id_reserva = rd.insertar(r);
            
        } catch (Exception e) {
            System.out.println("error en registrarReserva");
        }
    }
    

    public void mostrarTipos(int cantidad) {
        try {
            //labeltipos.setText("TIPOS DE HABITACIONES DISPONIBLES");
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            TipoDeHabitacionData thd = new TipoDeHabitacionData(con);

            DefaultTableModel modelo;
            modelo = thd.buscardisponibles(cantidad);

            //El siguiente if comprueba que la tabla modelo no este vacia. Ésta estará vacia si la cantidad
            //de personas ingresadas supera la capacidad de cualquier tipo de habitación.
            if (modelo.getRowCount() == 0) {
                tablatiposhab.setModel(modelotipos);
                tablahabs.setModel(modelohabs);
                JOptionPane.showMessageDialog(null, "La cantidad de personas supera la capacidad de cualquier habitacion. Por favor haga mas de una reserva");
            } else {
                tablatiposhab.setModel(modelo);
            }
            
            //A continuacion deshabilito las columnas de la tabla habitaciones que no necesita ver el huesped:
            ocultarColumnasHab();
        
            //A continuacion deshabilito las columnas de la tabla tipos de habitacion que no necesita ver el huesped:
            ocultarColumnasTipos();

        } catch (Exception e) {
            System.out.println("error mostrartipos.java");
        }
    }
    
   
    public void mostrarHabitaciones() {
        try {
            costototal = precio_noche * diassalida;
            labeltipos.setText("HABITACIONES DISPONIBLES");
            con = new Conexion("jdbc:mysql://localhost/elgranhotel", "root", "");
            HabitacionData thd = new HabitacionData(con);

            DefaultTableModel modelo;
            modelo = thd.buscardisponibles(id, diassalida,costototal);

            tablahabs.setModel(modelo);
            ocultarColumnasHab();

        } catch (Exception e) {
            System.out.println("error reservacliente.java");
        }
    }

    public void limpiar() {
        fechallegada.setCalendar(null);
        fechasalida.setCalendar(null);
        cboxadultos.setSelectedIndex(0);
        cboxniños.setSelectedIndex(0);
        
        tablatiposhab.setModel(modelotipos);
        tablahabs.setModel(modelohabs);
        
        //A continuacion deshabilito las columnas de la tabla habitaciones que no necesita ver el huesped:
        ocultarColumnasHab();  
        //A continuacion deshabilito las columnas de la tabla tipos de habitacion que no necesita ver el huesped:
        ocultarColumnasTipos();
    }

    public void comprobarFechaSalida(int año, int mes, int dia) {
        int fsalida[] = {1, 2, 2};
        //System.out.println("llego hasta aca tambien");

        if (fechasalida.getDate() != null) {   //Compruebo que se haya ingreado una fecha de llegada
            //En las siguientes 4 lineas obtengo la fecha de llegada en formato String:
            String dias = Integer.toString(fechasalida.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mess = Integer.toString(fechasalida.getCalendar().get(Calendar.MONTH) + 1);
            String years = Integer.toString(fechasalida.getCalendar().get(Calendar.YEAR));
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
                comprobarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha de salida mayor a la fecha de llegada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de salida");
        }
    }

    public void comprobarFechaLlegada() {
        int fllegada[] = {1, 2, 2};

        if (fechallegada.getDate() != null) {   //Compruebo que se haya ingreado una fecha de llegada
            //En las siguientes 4 lineas obtengo la fecha de llegada en formato String:
            String dial = Integer.toString(fechallegada.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mesl = Integer.toString(fechallegada.getCalendar().get(Calendar.MONTH) + 1);
            String yearl = Integer.toString(fechallegada.getCalendar().get(Calendar.YEAR));
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

            int dias = (int) ((fechaProxima.getTime() - f_llegada.getTime()) / 86400000);
            //System.out.println("Hay " + dias + " dias de diferencia");

            if (dias >= 0) { //Si a fecha de llegada coincide con la actual o es mayor, entonces el dato esta bien y paso a comprobar la fecha de salida
                comprobarFechaSalida(fllegada[2], fllegada[1], fllegada[0]);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese una fecha de llegada correcta");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de llegada");
        }
    }

    public void comprobarCampos() {
        if ((cboxadultos.getSelectedItem().toString()).equals("Seleccione")) {        //Compruebo si se ha indicado la cantidad de adultos

            JOptionPane.showMessageDialog(null, "Ingrese la cantidad de adultos");

        } else if ((cboxniños.getSelectedItem().toString()).equals("Seleccione")) {    //Compruebo si se ha indicado la cantidad de niños

            JOptionPane.showMessageDialog(null, "Ingrese la cantidad de niños, 0 para ninguno");

        } else {
            adultos = Integer.parseInt(cboxadultos.getSelectedItem().toString());   //OBTENGO LA CANTIDAD DE ADULTOS
            niños = Integer.parseInt(cboxniños.getSelectedItem().toString());       //OBTENGO LA CANTIDAD DE NIÑOS
            total = adultos + niños;    //SUMO LA CANTIDAD DE ADULTOS Y NIÑOS
            mostrarTipos(total);           
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
        cboxadultos = new javax.swing.JComboBox<>();
        cboxniños = new javax.swing.JComboBox<>();
        btnsiguiente = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        fechallegada = new com.toedter.calendar.JDateChooser();
        fechasalida = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablatiposhab = new javax.swing.JTable();
        labeltipos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablahabs = new javax.swing.JTable();
        btnsiguientehab = new javax.swing.JButton();
        labeltipos1 = new javax.swing.JLabel();
        labeltipos2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Reserva - Ingrese los datos"));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha de llegada:");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha de salida:");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad de adultos:");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cantidad de niños");

        cboxadultos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        cboxniños.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        btnsiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/001-flecha.png"))); // NOI18N
        btnsiguiente.setText("SIGUIENTE");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/003-escoba-de-limpieza-para-suelos.png"))); // NOI18N
        btnlimpiar.setText("LIMPIAR");
        btnlimpiar.setPreferredSize(new java.awt.Dimension(91, 25));
        btnlimpiar.setRolloverEnabled(false);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboxadultos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxniños, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(fechallegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(btnsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fechallegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboxadultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboxniños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsiguiente)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione el tipo de habitación deseado"));

        tablatiposhab.setModel(new javax.swing.table.DefaultTableModel(
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
        tablatiposhab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablatiposhabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablatiposhab);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labeltipos.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labeltipos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltipos.setText("HABITACIONES DISPONIBLES");

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione la habitacion deseada y luego haga click en siguiente"));

        tablahabs.setModel(new javax.swing.table.DefaultTableModel(
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
        tablahabs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablahabsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablahabs);

        btnsiguientehab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Archivos/confirmar.png"))); // NOI18N
        btnsiguientehab.setText("SIGUIENTE");
        btnsiguientehab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsiguientehabMouseClicked(evt);
            }
        });
        btnsiguientehab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguientehabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(661, Short.MAX_VALUE)
                .addComponent(btnsiguientehab, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(btnsiguientehab)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        labeltipos1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labeltipos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltipos1.setText("TIPOS DE HABITACIONES");

        labeltipos2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        labeltipos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labeltipos2.setText("DATOS NECESARIOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labeltipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeltipos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labeltipos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltipos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltipos2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labeltipos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed
        tablahabs.setModel(modelohabs);
        comprobarFechaLlegada();
    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void tablatiposhabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablatiposhabMouseClicked
        //Aquí leo los valores de la fila que el cliente seleccione:
        int seleccion = tablatiposhab.rowAtPoint(evt.getPoint());

        id = Integer.valueOf(String.valueOf(tablatiposhab.getValueAt(seleccion, 0)));
        tipo = String.valueOf(tablatiposhab.getValueAt(seleccion, 1));
        capacidad = Integer.valueOf(String.valueOf(tablatiposhab.getValueAt(seleccion, 2)));
        cant_camas = Integer.valueOf(String.valueOf(tablatiposhab.getValueAt(seleccion, 3)));
        tipo_cama = String.valueOf(tablatiposhab.getValueAt(seleccion, 4));
        precio_noche = Integer.valueOf(String.valueOf(tablatiposhab.getValueAt(seleccion, 5)));
        
        mostrarHabitaciones();
        //System.out.println(id + " " + tipo + " " + capacidad + " " + cant_camas + " " + precio_noche);
    }//GEN-LAST:event_tablatiposhabMouseClicked

    private void tablahabsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablahabsMouseClicked
        btnsiguientehab.setEnabled(true);  //Habilito el botón siguiente para elegir un tipo deseado
        
        //Aqui debo tomar el id de la habitacion seleccionada por el cliente y luego
        //pasar a la ventana de login/registro.
        int selec = tablahabs.rowAtPoint(evt.getPoint());
        id_hab_elegida = Integer.valueOf(String.valueOf(tablahabs.getValueAt(selec, 0)));
        nro_hab_elegida = Integer.valueOf(String.valueOf(tablahabs.getValueAt(selec, 1)));
    }//GEN-LAST:event_tablahabsMouseClicked

    private void btnsiguientehabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsiguientehabMouseClicked

    }//GEN-LAST:event_btnsiguientehabMouseClicked

    private void btnsiguientehabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguientehabActionPerformed
        //Lo que hare ahora es registrar esta reserva, y luego, en la ventana de confirmacion, si el cliente confirma
        //entonces la dejo, si el cliente la descarta, entonces la elimino, y si el cliente la quiere modificar, vuelvo a la 
        //ventana de ReservaCliente
               
        registrarReserva();
        
        //Aqui debo pasar a la ventana de login/registro.
        escritorio.removeAll();
        escritorio.repaint();
        IngresoLuegoDeReserva log = new IngresoLuegoDeReserva(id_reserva, adultos, niños, nro_hab_elegida, precio_noche);
        int x = (escritorio.getWidth() / 2) - log.getWidth() / 2;
        int y = (escritorio.getHeight() / 2) - log.getHeight() / 2;
        log.setLocation(x, y);
        escritorio.add(log);
        log.toFront();
        log.setVisible(true);
    }//GEN-LAST:event_btnsiguientehabActionPerformed

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
            java.util.logging.Logger.getLogger(ReservaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JButton btnsiguientehab;
    private javax.swing.JComboBox<String> cboxadultos;
    private javax.swing.JComboBox<String> cboxniños;
    private com.toedter.calendar.JDateChooser fechallegada;
    private com.toedter.calendar.JDateChooser fechasalida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labeltipos;
    private javax.swing.JLabel labeltipos1;
    private javax.swing.JLabel labeltipos2;
    private javax.swing.JTable tablahabs;
    private javax.swing.JTable tablatiposhab;
    // End of variables declaration//GEN-END:variables
}
