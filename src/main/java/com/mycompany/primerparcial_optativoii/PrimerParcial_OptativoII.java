/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primerparcial_optativoii;

import Infraestructura.Models.CiudadModels;
import Infraestructura.Models.ClienteModels;
import Infraestructura.Models.CuentasModels;
import Infraestructura.Models.MovimientosModels;
import Infraestructura.Models.PersonaModels;
import Services.CiudadService;
import Services.ClienteService;
import Services.CuentasService;
import Services.MovimientosService;
import Services.PersonaService;
import java.util.Calendar;
import java.util.Date;


public class PrimerParcial_OptativoII {


     public static void main(String[] args) {

        Calendar calendario = Calendar.getInstance();
        calendario.set(2023, Calendar.SEPTEMBER, 21);



/*
        PersonaService personaService = new PersonaService ("postgres", "12344321", "localhost", "5432", "postgres");

        PersonaModels persona = new PersonaModels();
        persona.Nombre = "Juan";
        persona.Apellido = "Perez";


        personaService.registrarPersona(persona);

        personaService.consultarPersonaPorId(1);

        personaService.modificarPersona(persona);
        */


      
/*
       ClienteService clienteService =new ClienteService("postgres", "12344321", "localhost", "5432", "postgres");



        ClienteModels cliente = new ClienteModels();
        cliente.Id_Cliente=1;
        cliente.Id_Persona=1;
        cliente.Fecha_Ingreso=calendario.getTime();
        cliente.Estado="Activo";
        cliente.Calificacion="Exelente";

        clienteService.registrarCliente(cliente);

        clienteService.consultarClientePorId(1);

        clienteService.modificarCliente(cliente);

         */

        /*   Ciudad

        CiudadService ciudadService = new CiudadService("postgres", "12344321", "localhost", "5432", "postgres");

        CiudadModels ciudad = new CiudadModels();
        ciudad.Nombre_ciudad="Asuncion";
        ciudad.Id_ciudad=2;
        ciudad.Departamento="Central";


        CiudadService.registrarCiudad(ciudad);

        CiudadService.consultarCiudadPorId(2);

        CiudadService.modificarCiudad(ciudad);

        */

        /*    Cuentas

        CuentasService cuentaService =new CuentaService("postgres", "12344321", "localhost", "5432", "postgres");

        Cuentas_modelo cuentas =new Cuentas_modelo();
        cuentas.IdCuenta=1;
        cuentas.IdCliente=1;
        cuentas.NroCuenta="1233";
        cuentas.TipoCuenta="Ahorro";
        cuentas.CostoMantenimiento= Float.valueOf(950000);
        cuentas.FechaAlta=calendario.getTime();
        cuentas.Moneda="Guaranies";
        cuentas.Saldo=Float.valueOf(50000);
        cuentas.PromedioAcreditacion= "30";
        cuentas.NroContrato="123";
        cuentas.Estado="Activo";

        cuentaService.registrarCuenta(cuentas);

        cuentaService.consultarCuentaPorId(1);

        cuentaService.modificarCuenta(cuentas);

        */
        /*   Movimientos

        MovimientosService movimientoService =new MovimientosService("postgres", "12344321", "localhost", "5432", "postgres");

        MovimientosModels movimiento = new MovimientosModels();
        movimiento.Id_Movimiento=1;
        movimiento.Id_Cuenta=1;
        movimiento.Tipo_Movimiento="Extraccion";
        movimiento.Fecha_Movimiento=calendario.getTime();
        movimiento.Saldo_anterior=Float.valueOf(450000);
        movimiento.Saldo_actual=Float.valueOf(440000);
        movimiento.Monto_movimiento=Float.valueOf(10000);
        movimiento.Cuenta_Origen=Float.valueOf(123);
        movimiento.Cuenta_Destino=Float.valueOf(456);
        movimiento.Canal= Float.valueOf(1);

        MovimientoService.registrarMovimientos(movimiento);
        MovimientoService.modificarCuenta(movimiento);
        MovimientoService.consultarMovimientoPorId(1);

 */
     }




}
