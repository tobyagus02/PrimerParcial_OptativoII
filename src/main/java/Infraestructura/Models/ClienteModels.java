/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.Models;

/**
 *
 * @author Toby
 */
public class ClienteModels {
    public int Id_Cliente;
    public int Id_Persona;
    public String Fecha_Ingreso;
    public String Calificacion;
    public String Estado;
    
    public int getId_Cliente() {
        return Id_Cliente;
    }

    /**
     * @param IdCliente the IdCliente to set
     */
    public void setId_Cliente(int IdCliente) {
        this.Id_Cliente = IdCliente;
    }

    /**
     * @return the IdPersona
     */
    public int getId_Persona() {
        return Id_Persona;
    }

    /**
     * @param IdPersona the IdPersona to set
     */
    public void setId_Persona(int IdPersona) {
        this.Id_Persona = IdPersona;
    }

    /**
     * @return the FechaIngreso
     */
    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    /**
     * @param FechaIngreso the FechaIngreso to set
     */
    public void setFechaIngreso(String FechaIngreso) {
        this.Fecha_Ingreso = FechaIngreso;
    }

    /**
     * @return the Calificacion
     */
    public String getCalificacion() {
        return Calificacion;
    }

    /**
     * @param Calificacion the Calificacion to set
     */
    public void setCalificacion(String Calificacion) {
        this.Calificacion = Calificacion;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
}
