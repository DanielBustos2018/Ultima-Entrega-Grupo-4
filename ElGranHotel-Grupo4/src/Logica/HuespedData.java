/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public Integer totalregistros;

    public HuespedData(Conexion conexion) {
        try {
            con = conexion.conectar();
        } catch (SQLException e) {
        }
    }
    
    
    //El siguiente método permite mostrar todos los huespedes:
    public DefaultTableModel mostrartodos() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "Apellido" , "Dni", "Domicilio", "Correo", "Teléfono"};

        String[] registro = new String[7];

        totalregistros = 0;
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

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } 
    }

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
        }
    }

    public void eliminarHuesped(int id_h) {
        sql = "DELETE FROM huesped WHERE id_huesped = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_h);

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

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

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) {
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

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) {
        }
        return hues;
    }
    
    
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

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) {
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

                //System.out.println(hues.getId_huesped() + hues.getApellido() + hues.getNombre() + hues.getDni());
            }
        } catch (Exception e) {
        }
        return hues;
    }
    
    
}
