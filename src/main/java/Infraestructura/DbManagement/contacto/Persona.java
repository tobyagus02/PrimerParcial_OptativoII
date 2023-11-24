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
                    persona.getIdPersona()+ "', '" +
                    persona.getId_Ciudad() + "', '" +
                    persona.getNombre() + "', '" +
                    persona.getApellido() + "', '" +
                    persona.getTipoDocumento() + "', '" +
                    persona.getNroDocumento() + "', '" +
                    persona.getDireccion() + "', '" +
                    persona.getCelular() + "', '" +
                    persona.getEmail() + "', '" +
                    persona.getEstado() + "'))");
            conexion.conexionDB().close();
            return "La persona " + persona.getNombre() + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Persona SET " +
                    "id_Persona' = '" + persona.getIdPersona() + "'," +
                    "id_Ciudad' = '" + persona.getId_Ciudad() + "'," +
                    "nombre' = '" + persona.getNombre() + "'," +
                    "apellido = '" + persona.getApellido() + "'," +
                    "tipodocumento = '" + persona.getTipoDocumento() + "'," +
                    "nrodocumento = '" + persona.getNroDocumento() + "'," +
                    "direccion = '" + persona.getDireccion() + "'," +
                    "celular = '" + persona.getCelular() + "'," +
                    "email = '" + persona.getEmail() + "'," +
                    "estado = '" + persona.getEstado() + "' Where personas.idPersona = " + persona.Id_Persona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.getNombre() + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModels consultarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from Persona where idPersona = " + id));
            if(conexion.getResultadoQuery().next()){
                persona.setId_Ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
                persona.setNombre (conexion.getResultadoQuery().getString("nombre"));
                persona.setApellido (conexion.getResultadoQuery().getString("apellido"));
                persona.setTipoDocumento( conexion.getResultadoQuery().getString("tipo_documento"));
                persona.setNroDocumento (conexion.getResultadoQuery().getString("nro_documento"));
                persona.setDireccion (conexion.getResultadoQuery().getString("direccion"));
                persona.setCelular (conexion.getResultadoQuery().getString("celular"));
                persona.setEmail (conexion.getResultadoQuery().getString("email"));
                persona.setEstado (conexion.getResultadoQuery().getString("estado"));
                                


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public PersonaModels consultarPersonaPorDocumento(int documento){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where nro_documento = " + documento));
            if(conexion.getResultadoQuery().next()){
                persona.setId_Ciudad(conexion.getResultadoQuery().getInt("id_ciudad"));
                persona.setNombre(conexion.getResultadoQuery().getString("nombre"));
                persona.setApellido(conexion.getResultadoQuery().getString("apellido"));
                persona.setTipoDocumento(conexion.getResultadoQuery().getString("tipo_documento"));
                persona.setNroDocumento(conexion.getResultadoQuery().getString("nro_documento"));
                persona.setDireccion(conexion.getResultadoQuery().getString("direccion"));
                persona.setCelular(conexion.getResultadoQuery().getString("celular"));
                persona.setEmail(conexion.getResultadoQuery().getString("email"));
                persona.setEstado(conexion.getResultadoQuery().getString("estado"));
                


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
     public String eliminarpersona(int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("DELETE FROM personas" +
                    " Where id_personas = '" + id+ "'");
            conexion.conexionDB().close();
            return "Los datos de la persona fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}}
    

