/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.contacto;

import Infraestructura.Conections.Conexiones;
import Infraestructura.Models.CuentasModels;
import java.sql.SQLException;

/**
 *
 * @author Toby
 */
public class Cuentas {
    private final Conexiones conexion;

    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuentas(CuentasModels cuentas){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO Cuentas(" +
                    "'Id_Cuentas', " +
                    "'Id_Cliente', " +
                    "'Nro_cuenta', " +
                    "'Fecha_Alta', " +
                    "'Tipo_cuenta', " +
                    "'Estado', " +
                    "'Saldo'," +
                    "'Nro_contrato', " +
                    "'Costo', " +
                    "'Promedio_Acreditacion', " +
                    "'Moneda') " +
                    "values('" +
                    cuentas.getId_Cuentas() + "', '" +
                    cuentas.getId_Cliente() + "', '" +
                    cuentas.getNro_cuenta() + "', '" +
                    cuentas.getFechaAlta() + "', '" +
                    cuentas.getTipo_cuenta() + "', '" +
                    cuentas.getEstado() + "', '" +
                    cuentas.getSaldo() + "', '" +
                    cuentas.getNro_contrato() + "', '" +
                    cuentas.getCosto_Mantenimiento() + "', '" +
                    cuentas.getPromedio_Acreditacion() + "', '" +
                    cuentas.getMoneda() + "'))");
            conexion.conexionDB().close();
            return "La cuenta " + cuentas.getId_Cuentas() + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuentas(CuentasModels cuentas){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Cuentas SET " +
                    "Id_Cuentas' = '" + cuentas.getId_Cuentas() + "'," +
                    "Id_Cliente' = '" + cuentas.getId_Cliente() + "'," +
                    "Nro_cuenta' = '" + cuentas.getNro_cuenta() + "'," +
                    "Fecha_Alta = '" + cuentas.getFechaAlta() + "'," +
                    "Tipo_cuenta = '" + cuentas.getTipo_cuenta() + "'," +
                    "Estado = '" + cuentas.getEstado() + "'," +
                    "Saldo = '" + cuentas.getSaldo() + "'," +
                    "Nro_contrato = '" + cuentas.getNro_contrato() + "'," +
                    "Costo_Mantenimiento = '" + cuentas.getCosto_Mantenimiento() + "'," +
                    "Promedio_Acreditacion = '" + cuentas.getPromedio_Acreditacion() + "'," +
                    "Moneda = '" + cuentas.getMoneda() + "' Where cuentas.idCuentas = " + cuentas.getId_Cuentas());
            conexion.conexionDB().close();
            return "Los datos de la cuenta " + cuentas.getId_Cuentas() + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CuentasModels consultarCuentas(int id){
        CuentasModels cuentas = new CuentasModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cuenta where idCuentas = " + id));
            if(conexion.getResultadoQuery().next()){
                cuentas.setId_Cuentas  (conexion.getResultadoQuery().getInt("Id_Cuentas"));
                cuentas.setId_Cliente  (conexion.getResultadoQuery().getInt("Id_cliente"));
                cuentas.setNro_cuenta  (conexion.getResultadoQuery().getString("nro_cuenta"));
                cuentas.setFecha_Alta  (conexion.getResultadoQuery().getString("Fecha_Alta"));
                cuentas.setTipoCuenta  (conexion.getResultadoQuery().getString("tipo_cuenta"));
                cuentas.setEstado  (conexion.getResultadoQuery().getString("estado"));
                cuentas.setSaldo  (conexion.getResultadoQuery().getString("saldo"));
                cuentas.setNro_contrato  (conexion.getResultadoQuery().getString("nro_contrato"));
                cuentas.setCosto_Mantenimiento  (conexion.getResultadoQuery().getString("costo_mantenimiento"));
                cuentas.setPromedio_Acreditacion  (conexion.getResultadoQuery().getString("promedio_acreditacion"));
                cuentas.setMoneda (conexion.getResultadoQuery().getString("moneda"));


                return cuentas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public String eliminarcuentaporid(int id){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("DELETE FROM cuentas" +
                    " Where id_cuenta = '" + id+ "'");
            conexion.conexionDB().close();
            return "Los datos de la persona fueron eliminados correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }}

    
    }
