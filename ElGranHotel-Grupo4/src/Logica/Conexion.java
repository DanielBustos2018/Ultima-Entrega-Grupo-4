////////////////////////////////////////////////////////////////////////////////
//                                                                            //
//                         EL GRAN HOTEL - GRUPO 4                            //
//                                                                            //
//   YAMILE BUNINO - FLORENCIA BORDAGORRY - BUSTOS DANIEL - BERTERO RODOLFO   //
//                                                                            //
//                             CLASE CONEXION                                 //
//                                                                            //
////////////////////////////////////////////////////////////////////////////////

package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static Connection con;                                  //Atributo que almacenará la conexion
    private static final String driver = "org.mariadb.jdbc.Driver"; //Driver que permite la conexion entre java y mariadb
    private String url;                                             //Url donde se encuentra la base de datos (en este caso siempres sera en localhost, pero para hacerlo generico lo dejaremos asi).
    private String usuario;                                         //Nombre de usuario para acceso a base de datos
    private String contraseña;                                      //Contraseña de usuario para acceso a base de datos
    
    //A continuacion declaro el constructor con los parametros necesarios:
    public Conexion(String url, String usuario, String contraseña) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.contraseña = contraseña;
        Class.forName(driver);
    }
    
    //A continuacion creo el metodo que me permitira establecer la coneccion con la base de datos:
    public Connection conectar() throws SQLException{
        con = null;
        if(con == null) { //Verifico que no exista otra conexion
            con = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + contraseña);
        }       
        return con;
    }
}
