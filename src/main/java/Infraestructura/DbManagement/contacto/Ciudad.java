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
                    ciudad.Id_ciudad+ "','"+
                    ciudad.Ciudad + "','"+
                    ciudad.Departamento  + "','" +
                    ciudad.Postal_code  +"'))");
            conexion.conexionDB().close();
            return "La Ciudad " + ciudad.Ciudad + " fue registrada exitosamente";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String modificarCiudad(CiudadModels ciudad){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Ciudad SET " +
                    "id_ciudad' = '" + ciudad.Id_ciudad + "'," +
                    "Ciudad' = '" + ciudad.Ciudad + "'," +
                    "Departamento = '" + ciudad.Departamento + "'," +
                    "Postal_code = '" + ciudad.Postal_code + "'," );
                    conexion.conexionDB().close();
            return "Los datos de la ciudad " + ciudad.Ciudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModels consultarPersona(int id){
        CiudadModels Ciudad = new CiudadModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudad where idCiudad = " + id));
            if(conexion.getResultadoQuery().next()){
                Ciudad.Departamento = conexion.getResultadoQuery().getString("nombre");
                Ciudad.Postal_code = conexion.getResultadoQuery().getString("apellido");


                return Ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public CiudadModels consultarCiudad(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
