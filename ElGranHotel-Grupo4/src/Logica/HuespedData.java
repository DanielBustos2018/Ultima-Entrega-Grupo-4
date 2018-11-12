////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                         EL GRAN HOTEL - GRUPO 4                            //
//                                                                            //
//   YAMILE BUNINO - FLORENCIA BORDAGORRY - BUSTOS DANIEL - BERTERO RODOLFO   //
//                                                                            //
//                           CLASE HUESPED DATA                               //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////


package Logica;

import Datos.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HuespedData {
    private int id_huesped;

    String sql = "";
    private Connection con = null;

    public HuespedData(Conexion conexion) {
        try {
            con = conexion.conectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la base de datos (Huesped Data) error: " + e);
        }
    }
    
    //El siguiente método permite mostrar todos los huespedes:
    public DefaultTableModel mostrartodos() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "Nombre", "Apellido" , "Dni", "Domicilio", "Correo", "Teléfono"};
        String[] registro = new String[7];
        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT * FROM huesped";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_huesped");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("dni");
                registro[4] = rs.getString("domicilio");
                registro[5] = rs.getString("correo");
                registro[6] = rs.getString("telefono");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } 
    }

    //El siguiente método permite registar un huesped:
    public int registrarHuesped(Huesped huesped) {    
        sql = "INSERT INTO huesped (nombre, apellido, dni, domicilio, correo, telefono) VALUES ( ? , ? , ? , ? , ? , ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, huesped.getNombre());
            ps.setString(2, huesped.getApellido());
            ps.setString(3, huesped.getDni());
            ps.setString(4, huesped.getDomicilio());
            ps.setString(5, huesped.getCorreo());
            ps.setString(6, huesped.getTelefono());

            ps.executeUpdate();
            
            //A continuacion obtengo el ID asignado al huesped:
            ResultSet rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                id_huesped = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(null, "Registro Exitoso!!");

        } catch (Exception e) {
            System.out.println(e);
            return id_huesped;
        }
        return id_huesped;
    }
    
    //El siguiente método permite editar los datos de un huesped:
    public void editarHuesped(String nombre, String apellido, String dni, String domicilio, String correo, String telefono, int id_huesp) {
        sql = "UPDATE huesped SET nombre = ? , apellido = ? , dni = ? , domicilio = ? , correo = ? , telefono = ? WHERE id_huesped = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.setString(4, domicilio);
            ps.setString(5, correo);
            ps.setString(6, telefono);
            ps.setInt(7, id_huesp);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //El siguiente método permite eliminar un huesped:
    public void eliminarHuesped(int id_h) {
        sql = "DELETE FROM huesped WHERE id_huesped = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_h);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //El siguiente método permite buscar un huesped por apellido y dni:
    public Huesped buscarHuesped(String loginapellido, String logindni) {
        Huesped hues = new Huesped(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM huesped WHERE apellido = '" + loginapellido + "' AND dni = '" + logindni + "' ";

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_huesped(rs.getInt("id_huesped"));
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setDni(rs.getString("dni"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setCorreo(rs.getString("correo"));
                hues.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return hues;
    }
    
    //El siguiente es un método sobrecargado de buscarHuesped, el cual permite verificar si existe un administrador:
    public Huesped buscarHuesped(String loginapellido, String logindni, int loginid) {
        Huesped hues = new Huesped(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM huesped WHERE  id_huesped = '" + loginid + "'  AND apellido = '" + loginapellido + "' AND dni = '" + logindni + "'";

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_huesped(rs.getInt("id_huesped"));
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setDni(rs.getString("dni"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setCorreo(rs.getString("correo"));
                hues.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return hues;
    }
    
    //El siguiente método sobrecargado permite buscar un huesped por ID:
    public Huesped buscarHuesped(int id_huesped) {
        Huesped hues = new Huesped(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM huesped WHERE id_huesped =" + id_huesped;

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_huesped(rs.getInt("id_huesped"));
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setDni(rs.getString("dni"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setCorreo(rs.getString("correo"));
                hues.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return hues;
    }
    
   
    public Huesped buscarHuesped(String dni_huesped) {
        Huesped hues = new Huesped(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM huesped WHERE dni = ? ";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni_huesped);
            
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                hues.setId_huesped(rs.getInt("id_huesped"));
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setDni(rs.getString("dni"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setCorreo(rs.getString("correo"));
                hues.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
        }
        return hues;
    }
    
    
}
