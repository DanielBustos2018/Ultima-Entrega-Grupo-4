
package Datos;


public class Habitacion {
    private int id_habitacion;
    private int id_tipoHabitacion;
    private int numero;
    private int piso;
    private int estado = 1; //un 1 significa habitacion estado y un 0 ocupada

    public Habitacion(int id_habitacion, int id_tipoHabitacion, int numero, int piso) {
        this.id_habitacion = id_habitacion;
        this.id_tipoHabitacion = id_tipoHabitacion;
        this.numero = numero;
        this.piso = piso;
    }

    public Habitacion() {
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId_tipoHabitacion() {
        return id_tipoHabitacion;
    }

    public void setId_tipoHabitacion(int id_tipoHabitacion) {
        this.id_tipoHabitacion = id_tipoHabitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
