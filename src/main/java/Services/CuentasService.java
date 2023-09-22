/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Infraestructura.DbManagement.contacto.Cuentas;
import Infraestructura.Models.CuentasModels;

/**
 *
 * @author Toby
 */
public class CuentasService {
    Cuentas cuentasDB;
    public CuentasService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentasDB = new Cuentas(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCuentas(CuentasModels cuentas){
        if(validarDatos(cuentas)){
           return cuentasDB.registrarCuentas(cuentas);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCuentas(CuentasModels cuentas){
        if(validarDatos(cuentas)){
            return cuentasDB.modificarCuentas(cuentas);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

/*
    public CuentasModels consultarCuentasPorId(int id){
        return cuentasDB.consultarId_Cuentas(id);
    }
*/
    public CuentasModels consultarCuentasPorId(int id){
        return  cuentasDB.consultarCuentas(id);
    }
    private boolean validarDatos(CuentasModels cuentas) {
        try {
        if(cuentas.Nro_cuenta.trim().isEmpty())
            throw new Exception("La cuenta no debe estar vacía");
        else if (cuentas.Fecha_Alta.trim().length() < 3) {
            throw new Exception("La cuenta no tiene la fecha necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
