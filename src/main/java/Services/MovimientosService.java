/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Infraestructura.DbManagement.contacto.Movimientos;
import Infraestructura.Models.MovimientosModels;

/**
 *
 * @author Toby
 */
public class MovimientosService {
    Movimientos movimientosDB;
    public MovimientosService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        movimientosDB = new Movimientos(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarMovimientos(MovimientosModels movimientos){
        if(validarDatos(movimientos)){
           return movimientosDB.registrarMovimientos(movimientos);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }
    public String eliminarpersonaporId(int id){
       
            return movimientosDB.eliminarmovimiento(id);
    }        

    public String modificarMovimientos(MovimientosModels movimientos){
        if(validarDatos(movimientos)){
            return movimientosDB.modificarMovimientos(movimientos);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public MovimientosModels consultarMovimientosPorId(int id){
        return  movimientosDB.consultarMovimientos(id);
    }
    private boolean validarDatos(MovimientosModels movimientos) {
        try {
        if(movimientos.getTipo_movimiento().trim().isEmpty())
            throw new Exception("El movimiento no debe estar vacío");
        else if (movimientos.getTipo_movimiento().trim().length() < 3) {
            throw new Exception("No cuenta con el tipo de movimiento necesario");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}

