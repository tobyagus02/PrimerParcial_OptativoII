/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.contacto;

import Infraestructura.Conections.Conexiones;
import Infraestructura.Models.ClienteModels;
import java.sql.SQLException;

/**
 *
 * @author Toby
 */
public class Cliente {
        private final Conexiones conexion;

    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO Cliente(" +
                    "'Id_Cliente', " +
                    "'Id_Persona', " +
                    "'Fecha_Ingreso', " +
                    "'Calificacion', " +
                    "'Estado') " +
                    "values('" +
                    cliente.getId_Cliente() + "', '" +
                    cliente.getId_Persona() + "', '" +
                    cliente.getFecha_Ingreso() + "', '" +
                    cliente.getCalificacion() + "', '" +
                    cliente.getEstado() + "'))");
            conexion.conexionDB().close();
            return "El cliente " + cliente.getId_Cliente() + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClienteModels cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Cliente SET " +
                    "id_Cliente' = '" + cliente.getId_Cliente() + "'," +
                    "id_Ciudad' = '" + cliente.getId_Persona() + "'," +
                    "Fecha_Ingreso' = '" + cliente.getFecha_Ingreso() + "'," +
                    "Calificacion = '" + cliente.getCalificacion() + "'," +
                    "estado = '" + cliente.getEstado() + "' Where cliente.id_Cliente = " + cliente.getId_Cliente());
            conexion.conexionDB().close();
            return "Los datos del cliente " + cliente.getId_Cliente() + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteModels consultarCliente(int id){
        ClienteModels cliente = new ClienteModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from Cliente where id = " + id));
            if(conexion.getResultadoQuery().next()){
                cliente.setId_Cliente  (conexion.getResultadoQuery().getInt("id_cliente"));
                cliente.setId_Persona  (conexion.getResultadoQuery().getInt("id_persona"));
                cliente.setFechaIngreso  (conexion.getResultadoQuery().getString("Fecha_Ingreso"));
                cliente.setCalificacion  (conexion.getResultadoQuery().getString("Calificacion"));
                cliente.setEstado  (conexion.getResultadoQuery().getString("estado"));


                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String eliminarcliente(int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("DELETE FROM cliente" +
                    " Where id_cliente = '" + id+ "'");
            conexion.conexionDB().close();
            return "Los datos del cliente fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}
}
