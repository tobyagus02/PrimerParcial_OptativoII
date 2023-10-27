/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.contacto;

import Infraestructura.Conections.Conexiones;
import Infraestructura.Models.MovimientosModels;
import java.sql.SQLException;

/**
 *
 * @author Toby
 */
public class Movimientos {
    private final Conexiones conexion;

    public Movimientos(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimientos(MovimientosModels movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO Movimientos(" +
                    "'Id_Movimiento', " +
                    "'Id_Cuentas', " +
                    "'Fecha_movimiento', " +
                    "'Tipo_movimiento', " +
                    "'Saldo_anterior', " +
                    "'Saldo_actual', " +
                    "'Monto_movimiento'," +
                    "'Cuenta_origen', " +
                    "'Cuenta_destino', " +
                    "'Canal') " +
                    "values('" +
                    movimientos.Id_Movimiento + "', '" +
                    movimientos.Id_Cuentas + "', '" +
                    movimientos.Fecha_movimiento + "', '" +
                    movimientos.Tipo_movimiento + "', '" +
                    movimientos.Saldo_anterior + "', '" +
                    movimientos.Saldo_actual + "', '" +
                    movimientos.Monto_movimiento + "', '" +
                    movimientos.Cuenta_origen + "', '" +
                    movimientos.Cuenta_destino + "', '" +
                    movimientos.Canal + "'))");
            conexion.conexionDB().close();
            return "Los movimientos " + movimientos.Id_Movimiento + " fueron registrados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimientos(MovimientosModels movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Movimientos SET " +
                    "Id_Movimiento' = '" + movimientos.Id_Movimiento + "'," +
                    "Id_Cuentas' = '" + movimientos.Id_Cuentas + "'," +
                    "Fecha_movimiento' = '" + movimientos.Fecha_movimiento + "'," +
                    "Tipo_movimiento = '" + movimientos.Tipo_movimiento + "'," +
                    "Saldo_anterior = '" + movimientos.Saldo_anterior + "'," +
                    "Saldo_actual = '" + movimientos.Saldo_actual + "'," +
                    "Monto_movimiento = '" + movimientos.Monto_movimiento + "'," +
                    "Cuenta_origen = '" + movimientos.Cuenta_origen + "'," +
                    "Cuenta_destino = '" + movimientos.Cuenta_destino + "'," +
                    "Canal = '" + movimientos.Canal + "' Where movimientos.idMovimientos = " + movimientos.Id_Movimiento);
            conexion.conexionDB().close();
            return "Los datos de los movimientos " + movimientos.Id_Movimiento + " fueron modificados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientosModels consultarMovimientos(int id){
        MovimientosModels movimientos = new MovimientosModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where idPersona = " + id));
            if(conexion.getResultadoQuery().next()){
                movimientos.Id_Cuentas = conexion.getResultadoQuery().getInt("id_cuenta");
                movimientos.Fecha_movimiento = conexion.getResultadoQuery().getString("fecha_movimiento");
                movimientos.Tipo_movimiento = conexion.getResultadoQuery().getString("tipo_movimiento");
                movimientos.Saldo_anterior = conexion.getResultadoQuery().getString("saldo_anterior");
                movimientos.Saldo_actual = conexion.getResultadoQuery().getString("saldo_actual");
                movimientos.Monto_movimiento = conexion.getResultadoQuery().getString("monto_movimiento");
                movimientos.Cuenta_origen = conexion.getResultadoQuery().getString("cuenta_origen");
                movimientos.Cuenta_destino = conexion.getResultadoQuery().getString("cuenta_destino");
                movimientos.Canal= conexion.getResultadoQuery().getString("canal");
                

                return movimientos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
