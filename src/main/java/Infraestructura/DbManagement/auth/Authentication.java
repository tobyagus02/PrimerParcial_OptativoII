/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.auth;

import Infraestructura.Conections.Conexiones;
import Infraestructura.DbManagement.contacto.Persona;
import Infraestructura.Models.UsuarioModel;
import Presentations.Contactos.Personas;

import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Authentication {
    private  Conexiones conexion;
    private Persona persona;

    public Authentication(String userBD, String passDB, String hostDB, String portDB, String dataBase) {
        this.conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
        this.persona = new Persona(userBD, passDB, hostDB, portDB, dataBase);
    }
    public UsuarioModel Autenticar(String usuario){
        
        try {
            UsuarioModel usuariomodelo = new UsuarioModel();
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from usuarios  where usuario = '" + usuario +"'" ));
            if(conexion.getResultadoQuery().next()){
                usuariomodelo.setIDUsuario  (conexion.getResultadoQuery().getInt("IDUsuario"));
                usuariomodelo.setContraseña  (conexion.getResultadoQuery().getString("contraseña"));
                usuariomodelo.setPersonas (persona.consultarPersona(conexion.getResultadoQuery().getInt("idpersona")));
                usuariomodelo.setEstado (conexion.getResultadoQuery().getString("estado"));
                
                return usuariomodelo;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
        
    }
    
    public String registrarUsuario(UsuarioModel usuario){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO usuarios("+
                    
                    "idpersona, " +
                    "usuario, " +
                    "contrasena, " +
                    "estado)"  +
                    "values(" + usuario.getPersonas().getIdPersona() +",'" + usuario.getUsuario() + "',' " + usuario.getContraseña() + "','ACTIVO')");
            conexion.conexionDB().close();
            return "La persona " + usuario.getUsuario() + " fue registrada exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     public UsuarioModel editarCiudad(int id){
        UsuarioModel  usuario = new UsuarioModel();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudades where id_ciudad = " + id));
            if(conexion.getResultadoQuery().next()){
                usuario.setUsuario(conexion.getResultadoQuery().getString("usuario"));
                usuario.setContraseña(conexion.getResultadoQuery().getString("contrasena"));    
                usuario.setIDUsuario(conexion.getResultadoQuery().getInt("idusuario"));
                usuario.setEstado(conexion.getResultadoQuery().getString("estado"));
                
/*                ciudad.Codigopostal = conexion.getResultadoQuery().getInt("codigo_postal"); Definido como numeric
*/
                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
      public String modificarPersona(UsuarioModel ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudades "
                    + "SET " + 
                     " estado = '" + ciudad.getEstado()+ "'," +
                    " usuario = '" + ciudad.getUsuario()+ "'," +
                    "contrasena = '" + ciudad.getContraseña()+ "'" +
                    " Where ciudades.id_ciudad = " + ciudad.getID_Usuario());
            conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.getID_Usuario()+ " fue modificado exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
}
