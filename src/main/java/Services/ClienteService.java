/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Infraestructura.DbManagement.contacto.Cliente;
import Infraestructura.Models.ClienteModels;

/**
 *
 * @author Toby
 */
public class ClienteService {
    Cliente clienteDB;
    public ClienteService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        clienteDB = new Cliente(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){
        if(validarDatos(cliente)){
           return clienteDB.registrarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCliente(ClienteModels cliente){
        if(validarDatos(cliente)){
            return clienteDB.modificarCliente(cliente);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public ClienteModels consultarClientePorId(int id){
        return  clienteDB.consultarCliente(id);
    }

    private boolean validarDatos(ClienteModels cliente) {
        try {
        if(cliente.getCalificacion().trim().isEmpty())
            throw new Exception("La calificacion no debe estar vacía");
        else if (cliente.getCalificacion().trim().length() < 3) {
            throw new Exception("La calificacion no tiene la longitud necesaria");
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
        return true;
    }
}
