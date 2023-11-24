/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.Models;

/**
 *
 * @author Toby
 */
public class UsuarioModel {
    private int Id_Usuario;
    private PersonaModels persona;
    private String Usuario;
    private String Contraseña;
    private String Estado;
    
    public int getID_Usuario() {
        return Id_Usuario;
    }

    /**
     * @param Id_Usuario the IDUsuario to set
     */
    public void setIDUsuario(int Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the Personas
     */
    public PersonaModels getPersonas() {
        return persona;
    }

    /**
     * @param Personas the Personas to set
     */
    public void setPersonas(PersonaModels Personas) {
        this.persona = Personas;
    }

    /**
     * @return the Usuario
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     * @return the Contraseña
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * @param Contraseña the Contraseña to set
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
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
    
    
    /** Utilizado como guia
    public UsuarioModel(int IdUsuario, PersonaModels persona, String Usuario, String Contraseña, String estado) {
        this.Id_Usuario = IdUsuario;
        this.persona = persona;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.estado = estado;
    }

    public UsuarioModel() {
        
    }

    public int getIdUsuario() {
        return Id_Usuario;
    }

    public PersonaModels getPersona() {
        return persona;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public void setPersona(PersonaModels persona) {
        this.persona = persona;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
*/
