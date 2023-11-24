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
                    movimientos.getId_Movimiento() + "', '" +
                    movimientos.getIdCuenta() + "', '" +
                    movimientos.getFecha_movimiento() + "', '" +
                    movimientos.getTipo_movimiento() + "', '" +
                    movimientos.getSaldo_anterior() + "', '" +
                    movimientos.getSaldo_actual() + "', '" +
                    movimientos.getMonto_movimiento() + "', '" +
                    movimientos.getCuenta_origen() + "', '" +
                    movimientos.getCuenta_destino() + "', '" +
                    movimientos.getCanal() + "'))");
            conexion.conexionDB().close();
            return "Los movimientos " + movimientos.getId_Movimiento() + " fueron registrados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarMovimientos(MovimientosModels movimientos){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Movimientos SET " +
                    "Id_Movimiento' = '" + movimientos.getId_Movimiento() + "'," +
                    "Id_Cuentas' = '" + movimientos.getIdCuenta() + "'," +
                    "Fecha_movimiento' = '" + movimientos.getFecha_movimiento() + "'," +
                    "Tipo_movimiento = '" + movimientos.getTipo_movimiento() + "'," +
                    "Saldo_anterior = '" + movimientos.getSaldo_anterior() + "'," +
                    "Saldo_actual = '" + movimientos.getSaldo_actual() + "'," +
                    "Monto_movimiento = '" + movimientos.getMonto_movimiento() + "'," +
                    "Cuenta_origen = '" + movimientos.getCuenta_origen() + "'," +
                    "Cuenta_destino = '" + movimientos.getCuenta_destino() + "'," +
                    "Canal = '" + movimientos.getCanal() + "' Where movimientos.idMovimientos = " + movimientos.getId_Movimiento());
            conexion.conexionDB().close();
            return "Los datos de los movimientos " + movimientos.getId_Movimiento() + " fueron modificados correctamente!!!";
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
                movimientos.setId_Cuentas  (conexion.getResultadoQuery().getInt("id_cuenta"));
                movimientos.setId_Movimiento (conexion.getResultadoQuery().getInt("id_movimiento"));
                movimientos.setFecha_movimiento  (conexion.getResultadoQuery().getString("fecha_movimiento"));
                movimientos.setTipo_movimiento  (conexion.getResultadoQuery().getString("tipo_movimiento"));
                movimientos.setSaldo_anterior  (conexion.getResultadoQuery().getString("saldo_anterior"));
                movimientos.setSaldo_actual  (conexion.getResultadoQuery().getString("saldo_actual"));
                movimientos.setMonto_movimiento  (conexion.getResultadoQuery().getString("monto_movimiento"));
                movimientos.setCuenta_origen  (conexion.getResultadoQuery().getString("cuenta_origen"));
                movimientos.setCuenta_destino  (conexion.getResultadoQuery().getString("cuenta_destino"));
                movimientos.setCanal (conexion.getResultadoQuery().getString("canal"));
                

                return movimientos;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String eliminarmovimiento(int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("DELETE FROM movimientos" +
                    " Where id_movimiento = '" + id+ "'");
            conexion.conexionDB().close();
            return "Los datos de la persona fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}


}
