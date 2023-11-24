/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.auth;

import Infraestructura.DbManagement.auth.Authentication;
import Infraestructura.Models.UsuarioModel;

/**
 *
 * @author Toby
 */
public class UsuarioService {
        
    private Authentication  usuariosDB;
    public UsuarioService(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        usuariosDB = new Authentication(userBD, passDB, hostDB, portDB, dataBase);
    }
    
    public UsuarioModel autenticar(String usuario){
        return usuariosDB.Autenticar(usuario);
    }

    public void registrarUsuario(UsuarioModel usuario){
        usuariosDB.registrarUsuario(usuario);
    }
    public void actualizarUsuario(UsuarioModel usuario){
        
        usuariosDB.modificarPersona(usuario);
    }
}
    

