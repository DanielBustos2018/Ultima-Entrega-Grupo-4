////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                         EL GRAN HOTEL - GRUPO 4                            //
//                                                                            //
//   YAMILE BUNINO - FLORENCIA BORDAGORRY - BUSTOS DANIEL - BERTERO RODOLFO   //
//                                                                            //
//                          CLASE HABITACION DATA                             //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////


package Logica;

import Datos.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HabitacionData {
    String sql = "";                    //Variable en la que almacenaré la consulta SQL
    private Connection con = null;

    public HabitacionData(Conexion conexion) {
        try {
            con = conexion.conectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la base de datos (Habitacion Data) error: " + e);
        }
    }
    
    //El siguiente método permite mostrar todas las habitaciones. Las mismas se cargan en un Objeto tipo Tabla:
    public DefaultTableModel mostrartodas() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_tipoHabitacion", "Numero" , "Piso", "Estado"};
        String[] registro = new String[5];

        modelo = new DefaultTableModel(null, titulos);      
        sql = "SELECT * FROM habitacion"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("id_tipoHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("piso");
                registro[4] = rs.getString("estado");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;
    }
    
    
    //El siguiente metodo busca todas las habitaciones disponibles (metodo sobrecargado):
    public DefaultTableModel buscardisponibles() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_tipoHabitacion", "Numero" , "Piso", "Estado"};
        String[] registro = new String[5];  //Defino rgistro que ira guardando las filas con 3 parametros

        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM habitacion WHERE estado = 0 ORDER BY id_habitacion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("id_tipoHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("piso");
                registro[4] = rs.getString("estado");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo;
    }
    
    //El siguiente método permite buscar el listado de habitaciones disponibles a partir de su tipo, en una tabla (retorna una tabla).
    //Observemos que recibe 3 parametros: el id del tipo de habitacion, la cantidad de noches y el precio total. Estos ultimos dos son para
    //rellenar la tabla modelo y retornarle ya lista para mostrar:
    public DefaultTableModel buscardisponibles(int id_tipo, int cant_noches, double precio_total) {
        DefaultTableModel modelo;

        String[] titulos = {"ID","Numero", "Piso", "Noches", "Costo toal"};    //Defino los nombres de las columnas de la tabla
        String[] registro = new String[5];  //Defino rgistro que ira guardando las filas con 3 parametros

        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM habitacion WHERE id_tipoHabitacion = ? AND estado = 0 ORDER BY id_habitacion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_tipo);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("numero");
                registro[2] = rs.getString("piso");
                registro[3] = String.valueOf(cant_noches);
                registro[4] = String.valueOf(precio_total);

                modelo.addRow(registro);
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo;
    }
    
    //El siguiente metodo busca todas las habitaciones ocupadas:
    public DefaultTableModel buscarOcupadas() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_tipoHabitacion", "Numero" , "Piso", "Estado"};
        String[] registro = new String[5];  //Defino rgistro que ira guardando las filas con 5 parametros
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM habitacion WHERE estado = 1 ORDER BY id_habitacion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);         
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("id_tipoHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("piso");
                registro[4] = rs.getString("estado");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo;
    }

    //El siguiente metodo busca todas las habitaciones de un tipo especifico:
    public DefaultTableModel buscarPorTipo(int id_tip) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_tipoHabitacion", "Numero" , "Piso", "Estado"};
        String[] registro = new String[5];  //Defino rgistro que ira guardando las filas con 3 parametros
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM habitacion WHERE id_tipoHabitacion = ? ORDER BY id_habitacion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_tip);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("id_tipoHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("piso");
                registro[4] = rs.getString("estado");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo;
    }
     
    //El siguiente metodo busca las habitaciones por piso:
    public DefaultTableModel buscarPorPiso(int id_pis) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Id_tipoHabitacion", "Numero" , "Piso", "Estado"};
        String[] registro = new String[5];  //Defino rgistro que ira guardando las filas con 3 parametros
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM habitacion WHERE piso = ? ORDER BY id_habitacion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_pis);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("id_habitacion");
                registro[1] = rs.getString("id_tipoHabitacion");
                registro[2] = rs.getString("numero");
                registro[3] = rs.getString("piso");
                registro[4] = rs.getString("estado");

                modelo.addRow(registro);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return modelo;
    }
    
    //El siguiente método permitirá insertar una nueva habitacion:
    public void insertar(int id_tipo, int num, int piso, int estado) {
        sql = "INSERT INTO habitacion (id_tipoHabitacion, numero, piso, estado) VALUES ( ? , ? , ? , ? )";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_tipo);
            ps.setInt(2, num);
            ps.setInt(3, piso);
            ps.setInt(4, estado);

            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    //El siguiente método permitirá editar los atributos de una habitacion:
    public void editar(int id_tipo, int num, int piso, int estado, int id) {
        sql = "UPDATE habitacion SET id_tipoHabitacion = ?, numero = ?, piso = ?, estado = ? WHERE id_habitacion = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_tipo);
            ps.setInt(2, num);
            ps.setInt(3, piso);
            ps.setInt(4, estado);
            ps.setInt(5, id);

            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    //El siguiente método permite buscar por id una habitacion:
    public Habitacion buscarDatosHabitacion(int id_hab) {
        Habitacion habi = new Habitacion(); //Instancio un objeto tipo Huesped para almacenar los datos leidos
        sql = "SELECT * FROM habitacion WHERE id_habitacion =" + id_hab ;
        try {

            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql);
            
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                habi.setId_habitacion(rs.getInt("id_habitacion"));
                habi.setId_tipoHabitacion(rs.getInt("id_tipoHabitacion"));
                habi.setNumero(rs.getInt("numero"));
                habi.setPiso(rs.getInt("piso"));
                habi.setEstado(rs.getInt("estado"));

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return habi;
    }
    
    //El siguiente método permite obtener el ID del tipo de habitacion de una habitación especifica:
    public int buscarHabitacion(int id_hab) {
        int id_tipo = 0;
        sql = "SELECT id_tipoHabitacion FROM habitacion WHERE id_habitacion =" + id_hab;

        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(sql); 
            //Si existe este huesped, entonces se ingresara al siguiente WHILE:
            while (rs.next()) {
                id_tipo = rs.getInt("id_tipoHabitacion");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        return id_tipo;
    }

    //El siguiente método permitirá cambiar el estado de una habitacion a Ocupada (estado = 1):
    public void ocupar(int id_hab) {
        sql = "UPDATE habitacion SET estado = 1 WHERE id_habitacion = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_hab);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    //El siguiente método permitirá cambiar el estado de una habitacion a Desocupada (estado = 0):
    public void desocupar(int id_hab) {
        sql = "UPDATE habitacion SET estado = 0 WHERE id_habitacion = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_hab);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    //El siguiente método permitirá eliminar una habitacion:
    public void eliminar(int id_hab) {
        sql = "DELETE FROM habitacion WHERE id_habitacion = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_hab);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

}
