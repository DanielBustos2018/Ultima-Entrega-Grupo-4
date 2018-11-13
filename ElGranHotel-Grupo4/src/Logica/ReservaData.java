////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                         EL GRAN HOTEL - GRUPO 4                            //
//                                                                            //
//   YAMILE BUNINO - FLORENCIA BORDAGORRY - BUSTOS DANIEL - BERTERO RODOLFO   //
//                                                                            //
//                           CLASE RESERVA DATA                               //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

package Logica;

import Datos.Huesped;
import Datos.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReservaData {
    String sql = "";
    private Connection con = null;
    private int id_reserva = 0;

    public ReservaData(Conexion conexion) {
        try {
            con = conexion.conectar();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la base de datos (Reserva Data) error: " + e);
        }
    }

    //El siguiente método me permite insertar una nueva reserva y retorna el ID asignado a la misma:
    public int insertar(Reserva nr) {
        sql = "INSERT INTO reserva (id_huesped, id_habitacion, fecha_entrada, fecha_salida, cantidad_personas, importe, estado) VALUES ( ? , ? , ? , ? , ? , ? , ? )";

        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nr.getId_huesped());
            ps.setInt(2, nr.getId_habitacion());
            ps.setDate(3, nr.getFecha_entrada());
            ps.setDate(4, nr.getFecha_salida());
            ps.setInt(5, nr.getCantidad_personas());
            ps.setDouble(6, nr.getImporte());
            ps.setInt(7, nr.getEstado());

            ps.executeUpdate();
            
            //A continuacion obtengo el ID asignado a la reserva
            ResultSet rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                id_reserva = rs.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return id_reserva;
    }
    
    
    //El siguiente método permite inservar el id de un huesped luego de que el mismo confirme la reserva:
    public void insertarIdHuesped(int id_r, int id_h) {
        sql = "UPDATE reserva SET id_huesped = ?, estado = ? WHERE id_reserva = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_h);
            ps.setInt(2, 1);
            ps.setInt(3, id_r);

            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //Este metodo verifica si la fecha de salida es anterior a la actual, si es asi, entonces la reserva a caducado y se le debe
    //cambiar e estado a 0(inactiva?
    public void verificarFechaSalida(){
        sql = "UPDATE reserva SET estado = 0 WHERE fecha_salida < NOW()";
        try {
            Statement ps = con.createStatement();
            ps.executeQuery(sql);
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        sql = "UPDATE reserva SET estado = 1 WHERE fecha_salida >= NOW()";
        try {
            Statement ps = con.createStatement();
            ps.executeQuery(sql);
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    //El siguiente método permite modificar los datos de una reserva:
    public void editarReserva(Reserva reserva) {
        sql = "UPDATE reserva SET id_huesped = ? , id_habitacion = ? , fecha_entrada = ? , fecha_salida = ? , cantidad_personas = ? , importe = ? , estado = ? WHERE id_reserva = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, reserva.getId_huesped());
            ps.setInt(2, reserva.getId_habitacion());
            ps.setDate(3, reserva.getFecha_entrada());
            ps.setDate(4, reserva.getFecha_salida());
            ps.setInt(5, reserva.getCantidad_personas());
            ps.setDouble(6, reserva.getImporte());
            ps.setInt(7, reserva.getEstado());

            ps.setInt(8, reserva.getId_reserva());
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //El siguiente método permite mostrar todas las reservas:
    public DefaultTableModel mostrartodas() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_Huesped", "Id_Habitacion" , "Fecha Entrada", "Fecha Salida", "Cantidad de Personas", "Importe", "Estado"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM reserva";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                //debo invertir la fecha para que en vez de mostrarse de la forma yyyy-mm-dd se muestre dd-mm-yyyy:
                String fechaen = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_entrada"));
                String fechasa = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_salida"));
                       
                registro[0] = rs.getString("id_reserva");
                registro[1] = rs.getString("id_huesped");
                registro[2] = rs.getString("id_habitacion");
                registro[3] = fechaen;
                registro[4] = fechasa;
                registro[5] = rs.getString("cantidad_personas");
                registro[6] = rs.getString("importe");
                if(Integer.parseInt(rs.getString("estado")) == 0){
                    registro[7] = "Finalizada";
                } else {
                    registro[7] = "Activa";
                }
          
                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } 
    }
    
    //El siguiente metodo me permite buscar Por Huesped todas las reservas que ha hecho un huesped:
    public DefaultTableModel buscarPorHuespedAdmin(int id_hpd) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_Huesped", "Id_Habitacion" , "Fecha Entrada", "Fecha Salida", "Cantidad de Personas", "Importe", "Estado"};
        String[] registro = new String[8];

        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT * FROM reserva WHERE id_huesped = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_hpd);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //debo invertir la fecha para que en vez de mostrarse de la forma yyyy-mm-dd se muestre dd-mm-yyyy:
                String fechaen = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_entrada"));
                String fechasa = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_salida"));
                       
                registro[0] = rs.getString("id_reserva");
                registro[1] = rs.getString("id_huesped");
                registro[2] = rs.getString("id_habitacion");
                registro[3] = fechaen;
                registro[4] = fechasa;
                registro[5] = rs.getString("cantidad_personas");
                registro[6] = rs.getString("importe");
                if(Integer.parseInt(rs.getString("estado")) == 0){
                    registro[7] = "Finalizada";
                } else {
                    registro[7] = "Activa";
                }

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } 
    }
    
    //El siguiente metodo me permite buscar Por Huesped todas las reservas que ha hecho un huesped:
    public DefaultTableModel buscarPorHuesped(int id_hpd) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_Huesped", "Num Habitación" , "Fecha Entrada", "Fecha Salida", "Cantidad de Personas", "Importe", "Estado"};
        String[] registro = new String[8];

        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT * FROM reserva WHERE id_huesped = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_hpd);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //debo invertir la fecha para que en vez de mostrarse de la forma yyyy-mm-dd se muestre dd-mm-yyyy:
                String fechaen = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_entrada"));
                String fechasa = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_salida"));
                       
                registro[0] = rs.getString("id_reserva");
                registro[1] = rs.getString("id_huesped");
                registro[2] = rs.getString("id_habitacion");
                registro[3] = fechaen;
                registro[4] = fechasa;
                registro[5] = rs.getString("cantidad_personas");
                registro[6] = rs.getString("importe");
                
                //A continuación si el estado es 0, entonces coloco la palabra Finalizada, si es 1 (reserva activa) entonces
                //coloco la palabra Activa:
                //System.out.println(rs.getString("estado"));
                if(Integer.parseInt(rs.getString("estado")) == 0){
                    registro[7] = "Finalizada";
                } else {
                    registro[7] = "Activa";
                }
                

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        } 
    }
    
    
    
    //El siguiente metodo me permite buscar Por habitación todas las reservas asociadas a una cierta habitacion:
    public DefaultTableModel buscarPorHabitacion(int id_habi) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_Huesped", "Id_Habitacion" , "Fecha Entrada", "Fecha Salida", "Cantidad de Personas", "Importe", "Estado"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        
        sql = "SELECT * FROM reserva WHERE id_habitacion = ?";    
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_habi);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //debo invertir la fecha para que en vez de mostrarse de la forma yyyy-mm-dd se muestre dd-mm-yyyy:
                String fechaen = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_entrada"));
                String fechasa = new SimpleDateFormat("dd-MM-yyyy").format(rs.getDate("fecha_salida"));
                       
                registro[0] = rs.getString("id_reserva");
                registro[1] = rs.getString("id_huesped");
                registro[2] = rs.getString("id_habitacion");
                registro[3] = fechaen;
                registro[4] = fechasa;
                registro[5] = rs.getString("cantidad_personas");
                registro[6] = rs.getString("importe");
                if(Integer.parseInt(rs.getString("estado")) == 0){
                    registro[7] = "Finalizada";
                } else {
                    registro[7] = "Activa";
                }

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }
    
    
    
    //El siguiente método permite buscar una reserva a partir de si ID:
    public Reserva buscarReserva(int id_res) {
        Reserva res = new Reserva(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM reserva WHERE id_reserva =" + id_res ;

        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                
                res.setId_huesped(rs.getInt("id_huesped"));
                res.setId_habitacion(rs.getInt("id_habitacion"));
                res.setFecha_entrada(rs.getDate("fecha_entrada"));
                res.setFecha_salida(rs.getDate("fecha_salida"));
                res.setCantidad_personas(rs.getInt("cantidad_personas"));
                res.setImporte(rs.getDouble("importe"));
                res.setEstado(rs.getInt("estado"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return res;
    }
    
    //El siguiente método permite eliminar una reserva:
    public void eliminarReserva(int id_res) {
        sql = "DELETE FROM reserva WHERE id_reserva = " + id_res;
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva Eliminada");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //El siguiente método permite modificar el estado de una reserva y ponerle fin:
    public void finreserva(int id_rs) {
        sql = "UPDATE reserva SET estado = 0 WHERE id_reserva = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_rs);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
