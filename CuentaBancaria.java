  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corebanca;

/**
 *
 * @author antiblex
 */
public class CuentaBancaria {
    
    public String numeroCuenta;
    public String titular;
    private double saldo;
    private int totalTransacciones;
    
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        
        if(saldoInicial < 0){
            this.saldo = 0.0;
        }
        else{
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    int getTotalTransacciones(){
        return this.totalTransacciones;
    }
    public void depositar(double monto){
        
        if(monto > 0){
            this.saldo += monto;
            this.totalTransacciones++;
            
            System.out.println("Deposito exitoso");
        }
        else
            System.out.println("Cantidad invalida");
    }
    public boolean retirar(double monto){
        
        if(monto > 0 && saldo >= monto){
            this.saldo -= monto;
            this.totalTransacciones++;
            return true;
        }
        else{
            System.out.println("Monto invalido o Saldo insuficiente");
            return false;
        }
    }
    public void mostrarDatos(){
        
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: " + saldo);
        System.out.println("Total de transacciones: " + totalTransacciones);
    }
}
