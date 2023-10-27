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
                    cliente.Id_Cliente + "', '" +
                    cliente.Id_Persona + "', '" +
                    cliente.Fecha_Ingreso + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.Estado + "'))");
            conexion.conexionDB().close();
            return "El cliente " + cliente.Id_Cliente + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCliente(ClienteModels cliente){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Cliente SET " +
                    "id_Cliente' = '" + cliente.Id_Cliente + "'," +
                    "id_Ciudad' = '" + cliente.Id_Persona + "'," +
                    "Fecha_Ingreso' = '" + cliente.Fecha_Ingreso + "'," +
                    "Calificacion = '" + cliente.Calificacion + "'," +
                    "estado = '" + cliente.Estado + "' Where cliente.id_Cliente = " + cliente.Id_Cliente);
            conexion.conexionDB().close();
            return "Los datos del cliente " + cliente.Id_Cliente + " fueron modificados correctamente!!!";
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
                cliente.Id_Cliente = conexion.getResultadoQuery().getInt("id_cliente");
                cliente.Id_Persona = conexion.getResultadoQuery().getInt("id_persona");
                cliente.Fecha_Ingreso = conexion.getResultadoQuery().getString("Fecha_Ingreso");
                cliente.Calificacion = conexion.getResultadoQuery().getString("Calificacion");
                cliente.Estado = conexion.getResultadoQuery().getString("estado");


                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
