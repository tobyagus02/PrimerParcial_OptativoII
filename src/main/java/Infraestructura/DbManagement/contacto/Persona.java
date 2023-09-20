/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.contacto;

import Infraestructura.Conections.Conexiones;
import Infraestructura.Models.PersonaModels;
import java.sql.SQLException;

/**
 *
 * @author Toby
 */
public class Persona {
    private Conexiones conexion;

    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO Persona(" +
                    "'Id_Persona', " +
                    "'Id_Ciudad', " +
                    "'Nombre', " +
                    "'Apellido', " +
                    "'Tipodocumento', " +
                    "'Nrodocumento', " +
                    "'Direccion'," +
                    "'Celular', " +
                    "'Email', " +
                    "'Estado') " +
                    "values('" +
                    persona.Id_Persona + "', '" +
                    persona.Id_Ciudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Celular + "', '" +
                    persona.Email + "', '" +
                    persona.Estado + "'))");
            conexion.conexionDB().close();
            return "La persona " + persona.Nombre + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Persona SET " +
                    "id_Persona' = '" + persona.Id_Persona + "'," +
                    "id_Ciudad' = '" + persona.Id_Ciudad + "'," +
                    "nombre' = '" + persona.Nombre + "'," +
                    "apellido = '" + persona.Apellido + "'," +
                    "tipodocumento = '" + persona.TipoDocumento + "'," +
                    "nrodocumento = '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "email = '" + persona.Email + "'," +
                    "estado = '" + persona.Estado + "' Where personas.idPersona = " + persona.Id_Persona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModels consultarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where idPersona = " + id));
            if(conexion.getResultadoQuery().next()){
                persona.Nombre = conexion.getResultadoQuery().getString("nombre");
                persona.Apellido = conexion.getResultadoQuery().getString("apellido");


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
