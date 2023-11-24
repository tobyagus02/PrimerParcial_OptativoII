/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Infraestructura.Models;

/**
 *
 * @author Toby
 */
public class MovimientosModels {
    public int Id_Movimiento;
    public int Id_Cuentas;
    public String Fecha_movimiento;
    public String Tipo_movimiento;
    public String Saldo_anterior;
    public String Saldo_actual;
    public String Monto_movimiento;
    public String Cuenta_origen;
    public String Cuenta_destino;
    public String Canal;
    
    public int getIdCuenta() {
        return Id_Cuentas;
    }

    /**
     * @param IdCuenta the IdCuenta to set
     */
    public void setId_Cuentas(int IdCuenta) {
        this.Id_Cuentas = IdCuenta;
    }

    /**
     * @return the IdMovimiento
     */
    public int getId_Movimiento() {
        return Id_Movimiento;
    }

    /**
     * @param IdMovimiento the IdMovimiento to set
     */
    public void setId_Movimiento(int IdMovimiento) {
        this.Id_Movimiento = IdMovimiento;
    }

    /**
     * @return the FechaMovimiento
     */
    public String getFecha_movimiento() {
        return Fecha_movimiento;
    }

    /**
     * @param FechaMovimiento the FechaMovimiento to set
     */
    public void setFecha_movimiento(String FechaMovimiento) {
        this.Fecha_movimiento = FechaMovimiento;
    }

    /**
     * @return the TipoMovimiento
     */
    public String getTipo_movimiento() {
        return Tipo_movimiento;
    }

    /**
     * @param TipoMovimiento the TipoMovimiento to set
     */
    public void setTipo_movimiento(String TipoMovimiento) {
        this.Tipo_movimiento = TipoMovimiento;
    }

    /**
     * @return the Saldoanterior
     */
    public String getSaldo_anterior() {
        return Saldo_anterior;
    }

    /**
     * @param Saldoanterior the Saldoanterior to set
     */
    public void setSaldo_anterior(String Saldoanterior) {
        this.Saldo_anterior = Saldoanterior;
    }

    /**
     * @return the Saldoactual
     */
    public String getSaldo_actual() {
        return Saldo_actual;
    }

    /**
     * @param Saldoactual the Saldoactual to set
     */
    public void setSaldo_actual(String Saldoactual) {
        this.Saldo_actual = Saldoactual;
    }

    /**
     * @return the Montomovimiento
     */
    public String getMonto_movimiento() {
        return Monto_movimiento;
    }

    /**
     * @param Montomovimiento the Montomovimiento to set
     */
    public void setMonto_movimiento(String Montomovimiento) {
        this.Monto_movimiento = Montomovimiento;
    }

    /**
     * @return the CuentaOrigen
     */
    public String getCuenta_origen() {
        return Cuenta_origen;
    }

    /**
     * @param CuentaOrigen the CuentaOrigen to set
     */
    public void setCuenta_origen(String CuentaOrigen) {
        this.Cuenta_origen = CuentaOrigen;
    }

    /**
     * @return the CuentaDestino
     */
    public String getCuenta_destino() {
        return Cuenta_destino;
    }

    /**
     * @param CuentaDestino the CuentaDestino to set
     */
    public void setCuenta_destino(String CuentaDestino) {
        this.Cuenta_destino = CuentaDestino;
    }

    /**
     * @return the Canal
     */
    public String getCanal() {
        return Canal;
    }

    /**
     * @param Canal the Canal to set
     */
    public void setCanal(String Canal) {
        this.Canal = Canal;
    }
      
    
    
    
}

