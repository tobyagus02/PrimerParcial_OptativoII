/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.Models;

/**
 *
 * @author Toby
 */
public class CiudadModels {
    
    public int getId_ciudad() {
        return Id_ciudad;
    }

    /**
     * @param Idciudad the Idciudad to set
     */
    public void setId_ciudad(int Idciudad) {
        this.Id_ciudad = Id_ciudad;
    }

    /**
     * @return the Nombre_ciudad
     */
    public String getNombre_ciudad() {
        return Ciudad;
    }

    /**
     * @param Nombre_ciudad the Nombre_ciudad to set
     */
    public void setNombre_ciudad(String Nombre_ciudad) {
        this.Ciudad = Ciudad;
    }

    /**
     * @return the Departamento
     */
    public String getDepartamento() {
        return Departamento;
    }

    /**
     * @param Departamento the Departamento to set
     */
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    /**
     * @return the Codigopostal
     */
    public String getCodigopostal() {
        return Postal_code;
    }

    /**
     * @param Codigopostal the Codigopostal to set
     */
    public void setCodigopostal(String Codigopostal) {
        this.Postal_code = Codigopostal;
    }

    public int Id_ciudad;
    public String Ciudad;
    public String Departamento;
    public String Postal_code;
    
}
