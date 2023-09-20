/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.DbManagement.contacto;

import Infraestructura.Conections.Conexiones;
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
            boolean execute = conexion.getQuerySQL().execute("UPDATE Persona SET " +
                    "id_Persona' = '" + cuentas.Id_Persona + "'," +
                    "id_Ciudad' = '" + cuentas.Id_Ciudad + "'," +
                    "nombre' = '" + cuentas.Nombre + "'," +
                    "apellido = '" + cuentas.Apellido + "'," +
                    "tipodocumento = '" + cuentas.TipoDocumento + "'," +
                    "nrodocumento = '" + persona.NroDocumento + "'," +
                    "direccion = '" + persona.Direccion + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "email = '" + persona.Email + "'," +
                    "estado = '" + persona.Estado + "' Where personas.idPersona = " + persona.Id_Persona);
            conexion.conexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModels consultarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.conexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where idPersona = " + id));
            if(conexion.getResultadoQuery().next()){
                persona.Nombre = conexion.getResultadoQuery().getString("nombre");
                persona.Apellido = conexion.getResultadoQuery().getString("apellido");


                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
