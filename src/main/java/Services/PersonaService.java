/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Infraestructura.DbManagement.contacto.Persona;
import Infraestructura.Models.PersonaModels;

/**
 *
 * @author Toby
 */
public class PersonaService {
    Persona personasDB;
    public PersonaService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new Persona(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarPersona(PersonaModels persona){
        if(validarDatos(persona)){
           return personasDB.registrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarPersona(PersonaModels persona){
        if(validarDatos(persona)){
            return personasDB.modificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public PersonaModels consultarPersonaPorId(int id){
        return  personasDB.consultarPersona(id);
    }
    
    public PersonaModels consultarPersonaPorDocumento(int documento){
        return  personasDB.consultarPersona(documento);
    }

    private boolean validarDatos(PersonaModels Persona) {
        try {
        if(Persona.Nombre.trim().isEmpty())
            throw new Exception("El nombre no debe estar vacío");
        else if (Persona.Nombre.trim().length() < 3) {
            throw new Exception("El nombre no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
    
}
