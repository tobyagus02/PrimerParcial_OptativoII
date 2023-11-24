/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.contacto;

import Infraestructura.Conections.Conexiones;
import Infraestructura.Models.CiudadModels;
import java.sql.SQLException;

/**
 *
 * @author Toby
 */
public class Ciudad {
    private Conexiones conexion;

    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }
    
    public String registrarCiudad(CiudadModels ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +"'id_ciudad'"+
                    "'Ciudad', " +
                    "'Departamento', " +
                    "'Postal_code,' )" +
                    "values('" +
                    ciudad.getId_ciudad()+ "','"+
                    ciudad.getNombre_ciudad()+ "','"+
                    ciudad.getDepartamento()  + "','" +
                    ciudad.getCodigopostal()  +"'))");
            conexion.conexionDB().close();
            return "La Ciudad " + ciudad.getNombre_ciudad() + " fue registrada exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String modificarCiudad(CiudadModels ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Ciudad SET " +
                    "id_ciudad' = '" + ciudad.getId_ciudad() + "'," +
                    "Ciudad' = '" + ciudad.getNombre_ciudad() + "'," +
                    "Departamento = '" + ciudad.getDepartamento() + "'," +
                    "Postal_code = '" + ciudad.getCodigopostal() + "'," );
                    conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.getId_ciudad() + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModels consultarCiudad(int id){
        CiudadModels Ciudad = new CiudadModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudad where idCiudad = " + id));
            if(conexion.getResultadoQuery().next()){
                Ciudad.setId_ciudad( conexion.getResultadoQuery().getInt("Id_ciudad"));
                Ciudad.setNombre_ciudad(conexion.getResultadoQuery().getString("ciudad"));
                Ciudad.setDepartamento( conexion.getResultadoQuery().getString("nombre"));
                Ciudad.setCodigopostal (conexion.getResultadoQuery().getString("apellido"));


                return Ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String eliminarciudad(int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("DELETE FROM ciudades" +
                    " Where id_ciudad = '" + id+ "'");
            conexion.conexionDB().close();
            return "Los datos del cliente fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}}

    
 

 
