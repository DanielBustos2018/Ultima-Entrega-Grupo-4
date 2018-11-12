////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                         EL GRAN HOTEL - GRUPO 4                            //
//                                                                            //
//   YAMILE BUNINO - FLORENCIA BORDAGORRY - BUSTOS DANIEL - BERTERO RODOLFO   //
//                                                                            //
//                      CLASE TIPO DE HABITACION DATA                         //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

package Logica;

import Datos.TipoDeHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TipoDeHabitacionData {
    String sql = "";
    private Connection con = null;
    
    public TipoDeHabitacionData(Conexion conexion){
        try {
            con = conexion.conectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la base de datos (TipoDeHabitacion Data) error: " + e);
        }
    }
    
    
    //El siguiente método permitirá editar los valores de un tipo de habitacion:
    public void editar(String tipohab, int capacidad, int cant_cam, String tipocama, Double precionoche, int id_tipohab) {
        sql = "UPDATE tipos_de_habitacion SET tipo = ?, capacidad = ?, cantidad_camas = ?, tipo_cama = ?, precio_noche = ? WHERE id_tipoHabitacion = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tipohab);
            ps.setInt(2, capacidad);
            ps.setInt(3, cant_cam);
            ps.setString(4, tipocama);
            ps.setDouble(5, precionoche);

            ps.setInt(6, id_tipohab);           
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
    //El siguiente método permite buscar por id un tipo de habitacion:
    public TipoDeHabitacion buscarDatosTipoHabitacion(int id_tip) {
        TipoDeHabitacion tipohabi = new TipoDeHabitacion(); //Instancio un objeto tipo Tipo habitacion para almacenar los datos leidos
        sql = "SELECT * FROM tipos_de_habitacion WHERE id_tipoHabitacion =" + id_tip ;

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {               
                tipohabi.setId_tipoHabitacion(rs.getInt("id_tipoHabitacion"));
                tipohabi.setTipo(rs.getString("tipo"));
                tipohabi.setCapacidad(rs.getInt("capacidad"));
                tipohabi.setCantidad_camas(rs.getInt("cantidad_camas"));
                tipohabi.setTipo_cama(rs.getString("tipo_cama"));
                tipohabi.setPrecio_noche(rs.getDouble("precio_noche"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tipohabi;
    }
    
    
    //El siguiente método permite buscar retornar el listado de habitaciones disponibles a partir de su tipo, en una tabla (retorna una tabla):
    public DefaultTableModel buscardisponibles(int cantidad) {

        DefaultTableModel modelo;   
        String[] titulos = {"ID","Tipo","Capacidad","Cantidad de camas","Tipo de cama", "Precio x noche"};    //Defino los nombres de las columnas de la tabla
        String[] registro = new String[6];  //Defino rgistro que ira guardando las filas con 3 parametros
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM tipos_de_habitacion WHERE capacidad >= ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_tipoHabitacion");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("capacidad");
                registro[3] = rs.getString("cantidad_camas");
                registro[4] = rs.getString("tipo_cama");
                registro[5] = rs.getString("precio_noche");

                modelo.addRow(registro);
            }
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return modelo;
    }
    
    
    //El siguiente método permite mostrar todos los tipos de habitacion ordendor por el precio de menor a mayor:
    public DefaultTableModel mostrarPMenorMayor() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Tipo", "Capacidad" , "Cantidad de camas", "Tipo de cama", "Precio por noche"};
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT * FROM tipos_de_habitacion ORDER BY precio_noche ASC";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_tipoHabitacion");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("capacidad");
                registro[3] = rs.getString("cantidad_camas");
                registro[4] = rs.getString("tipo_cama");
                registro[5] = rs.getString("precio_noche");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        return modelo;
    }
    
    
    
    //El siguiente método permite mostrar todos los tipos de habitacion ordendor por el precio de mayor a menor:
    public DefaultTableModel mostrarPMayorMenor() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Tipo", "Capacidad" , "Cantidad de camas", "Tipo de cama", "Precio por noche"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM tipos_de_habitacion ORDER BY precio_noche DESC";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_tipoHabitacion");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("capacidad");
                registro[3] = rs.getString("cantidad_camas");
                registro[4] = rs.getString("tipo_cama");
                registro[5] = rs.getString("precio_noche");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return modelo;
    }
    
    
    //El siguiente método permite mostrar todos los tipos de habitacion ordendor por lacapacidad de menor a mayor:
    public DefaultTableModel mostrarCMenorMayor() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Tipo", "Capacidad" , "Cantidad de camas", "Tipo de cama", "Precio por noche"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM tipos_de_habitacion ORDER BY capacidad ASC";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_tipoHabitacion");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("capacidad");
                registro[3] = rs.getString("cantidad_camas");
                registro[4] = rs.getString("tipo_cama");
                registro[5] = rs.getString("precio_noche");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
         return modelo;
    }
    
    
    
    //El siguiente método permite mostrar todos los tipos de habitacion ordendor por la capacidad de mayor a menor:
    public DefaultTableModel mostrarCMayorMenor() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Tipo", "Capacidad" , "Cantidad de camas", "Tipo de cama", "Precio por noche"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);     
        sql = "SELECT * FROM tipos_de_habitacion ORDER BY capacidad DESC";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("id_tipoHabitacion");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("capacidad");
                registro[3] = rs.getString("cantidad_camas");
                registro[4] = rs.getString("tipo_cama");
                registro[5] = rs.getString("precio_noche");
                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return modelo;
    }
    
    
    
    
    //El siguiente método permite mostrar todos los tipos de habitacion:
    public DefaultTableModel mostrartodos() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Tipo", "Capacidad" , "Cantidad de camas", "Tipo de cama", "Precio por noche"};
        String[] registro = new String[6];
        modelo = new DefaultTableModel(null, titulos);      
        sql = "SELECT * FROM tipos_de_habitacion ORDER BY id_tipoHabitacion";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_tipoHabitacion");
                registro[1] = rs.getString("tipo");
                registro[2] = rs.getString("capacidad");
                registro[3] = rs.getString("cantidad_camas");
                registro[4] = rs.getString("tipo_cama");
                registro[5] = rs.getString("precio_noche");

                modelo.addRow(registro);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
        return modelo;
    }
    
    
    
    public double buscarPrecio(int id_tipo) {
        double costo = 0;
        sql = "SELECT precio_noche FROM tipos_de_habitacion WHERE id_tipoHabitacion = " + id_tipo;

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                costo = rs.getDouble("precio_noche");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return costo;
    }

    
    public List<TipoDeHabitacion> obtenerTipos(){
        List<TipoDeHabitacion> tipos = new ArrayList<TipoDeHabitacion>();
        sql = "SELECT * FROM tipos_de_habitacion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            TipoDeHabitacion cadatipo;
            while(rs.next()){
                cadatipo = new TipoDeHabitacion();
                
                cadatipo.setId_tipoHabitacion(rs.getInt("id_tipoHabitacion"));
                cadatipo.setTipo(rs.getString("tipo"));
                cadatipo.setCapacidad(rs.getInt("capacidad"));
                cadatipo.setCantidad_camas(rs.getInt("cantidad_camas"));
                cadatipo.setTipo_cama(rs.getString("tipo_cama"));
                cadatipo.setPrecio_noche(rs.getDouble("precio_noche"));

                tipos.add(cadatipo);
            }      
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tipos: " + ex.getMessage());
        }
        return tipos;
    }
    
    //El siguiente método permite insertar un nuevo tipo de habitacion:
    public void insertar(String tipo, int capacidad, int cant_cam, String tipocama, double precionoche) {
        sql = "INSERT INTO tipos_de_habitacion (tipo, capacidad, cantidad_camas, tipo_cama, precio_noche) VALUES ( ? , ? , ? , ? , ? )";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tipo);
            ps.setInt(2, capacidad);
            ps.setInt(3, cant_cam);
            ps.setString(4, tipocama);
            ps.setDouble(5, precionoche);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    
    //El siguiente método permite eliminar un tipo de habitacion dado por su ID:
    public void eliminar(int id_tipohab) {
        sql = "DELETE FROM tipos_de_habitacion WHERE id_tipoHabitacion = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_tipohab);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
}
