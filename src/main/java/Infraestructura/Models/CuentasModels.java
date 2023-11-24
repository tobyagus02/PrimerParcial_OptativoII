/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.Models;

/**
 *
 * @author Toby
 */
public class CuentasModels {
    public int Id_Cuentas;
    public int Id_Cliente;
    public String Nro_cuenta;
    public String Fecha_Alta;
    public String Tipo_cuenta;
    public String Estado;
    public String Saldo;
    public String Nro_contrato;
    public String Costo_Mantenimiento;
    public String Promedio_Acreditacion;
    public String Moneda;
    
    /**
     * @return the IdCuenta
     */
    public int getId_Cuentas() {
        return Id_Cuentas;
    }

    /**
     * @param Id_Cuentas the IdCuenta to set
     */
    public void setId_Cuentas(int Id_Cuentas) {
        this.Id_Cuentas = Id_Cuentas;
    }

    /**
     * @return the IdCliente
     */
    public int getId_Cliente() {
        return Id_Cliente;
    }

    /**
     * @param IdCliente the IdCliente to set
     */
    public void setId_Cliente(int IdCliente) {
        this.Id_Cliente = IdCliente;
    }

    /**
     * @return the NroCuenta
     */
    public String getNro_cuenta() {
        return Nro_cuenta;
    }

    /**
     * @param NroCuenta the NroCuenta to set
     */
    public void setNro_cuenta(String NroCuenta) {
        this.Nro_cuenta = NroCuenta;
    }

    /**
     * @return the TipoCuenta
     */
    public String getTipo_cuenta() {
        return Tipo_cuenta;
    }

    /**
     * @param TipoCuenta the TipoCuenta to set
     */
    public void setTipoCuenta(String TipoCuenta) {
        this.Tipo_cuenta = TipoCuenta;
    }

    /**
     * @return the FechaAlta
     */
    public String getFechaAlta() {
        return Fecha_Alta;
    }

    /**
     * @param FechaAlta the FechaAlta to set
     */
    public void setFecha_Alta(String FechaAlta) {
        this.Fecha_Alta = FechaAlta;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    /**
     * @return the Saldo
     */
    public String getSaldo() {
        return Saldo;
    }

    /**
     * @param Saldo the Saldo to set
     */
    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }

    /**
     * @return the NroContrato
     */
    public String getNro_contrato() {
        return Nro_contrato;
    }

    /**
     * @param NroContrato the NroContrato to set
     */
    public void setNro_contrato(String NroContrato) {
        this.Nro_contrato = NroContrato;
    }

    /**
     * @return the CostoMantenimiento
     */
    public String getCosto_Mantenimiento() {
        return Costo_Mantenimiento;
    }

    /**
     * @param CostoMantenimiento the CostoMantenimiento to set
     */
    public void setCosto_Mantenimiento(String CostoMantenimiento) {
        this.Costo_Mantenimiento = CostoMantenimiento;
    }

    /**
     * @return the PromedioAcreditacion
     */
    public String getPromedio_Acreditacion() {
        return Promedio_Acreditacion;
    }

    /**
     * @param PromedioAcreditacion the PromedioAcreditacion to set
     */
    public void setPromedio_Acreditacion(String PromedioAcreditacion) {
        this.Promedio_Acreditacion = PromedioAcreditacion;
    }

    /**
     * @return the Moneda
     */
    public String getMoneda() {
        return Moneda;
    }

    /**
     * @param Moneda the Moneda to set
     */
    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }
    
}

