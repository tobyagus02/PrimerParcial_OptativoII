/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Infraestructura.DbManagement.contacto.Ciudad;
import Infraestructura.Models.CiudadModels;

/**
 *
 * @author Toby
 */
public class CiudadService {
        Ciudad ciudadDB;
    public CiudadService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new Ciudad(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
           return ciudadDB.registrarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
            return ciudadDB.modificarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }
    public String eliminarciudad(int id){
       
            return ciudadDB.eliminarciudad(id);
    }

    public CiudadModels consultarCiudadPorId(int id){
        return  ciudadDB.consultarCiudad(id);
    }

    private boolean validarDatos(CiudadModels ciudad) {
        try {
        if(ciudad.getNombre_ciudad().trim().isEmpty())
            throw new Exception("El nombre de la ciudad no debe estar vacío");
        else if (ciudad.getNombre_ciudad().trim().length() < 3) {
            throw new Exception("El nombre de la ciudad no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
