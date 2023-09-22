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
    private Conexiones conexion;

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
                    cuentas.Id_Cuentas + "', '" +
                    cuentas.Id_Cliente + "', '" +
                    cuentas.Nro_cuenta + "', '" +
                    cuentas.Fecha_Alta + "', '" +
                    cuentas.Tipo_cuenta + "', '" +
                    cuentas.Estado + "', '" +
                    cuentas.Saldo + "', '" +
                    cuentas.Nro_contrato + "', '" +
                    cuentas.Costo_Mantenimiento + "', '" +
                    cuentas.Promedio_Acreditacion + "', '" +
                    cuentas.Moneda + "'))");
            conexion.conexionDB().close();
            return "La cuenta " + cuentas.Id_Cuentas + " fue registrada correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCuentas(CuentasModels cuentas){

        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE Cuentas SET " +
                    "Id_Cuentas' = '" + cuentas.Id_Cuentas + "'," +
                    "Id_Cliente' = '" + cuentas.Id_Cliente + "'," +
                    "Nro_cuenta' = '" + cuentas.Nro_cuenta + "'," +
                    "Fecha_Alta = '" + cuentas.Fecha_Alta + "'," +
                    "Tipo_cuenta = '" + cuentas.Tipo_cuenta + "'," +
                    "Estado = '" + cuentas.Estado + "'," +
                    "Saldo = '" + cuentas.Saldo + "'," +
                    "Nro_contrato = '" + cuentas.Nro_contrato + "'," +
                    "Costo_Mantenimiento = '" + cuentas.Costo_Mantenimiento + "'," +
                    "Promedio_Acreditacion = '" + cuentas.Promedio_Acreditacion + "'," +
                    "Moneda = '" + cuentas.Moneda + "' Where cuentas.idCuentas = " + cuentas.Id_Cuentas);
            conexion.conexionDB().close();
            return "Los datos de la cuenta " + cuentas.Id_Cuentas + " fue modificado correctamente!!!";
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
                cuentas.Nro_cuenta = conexion.getResultadoQuery().getString("Nro_cuenta");
                cuentas.Fecha_Alta = conexion.getResultadoQuery().getString("Fecha_Alta");


                return cuentas;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    
    }
