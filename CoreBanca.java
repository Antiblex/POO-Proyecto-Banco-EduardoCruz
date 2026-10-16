/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package corebanca;

/**
 *
 * @author antiblex
 */
public class CoreBanca {
    public static void main(String[] args) {

        
        System.out.println("===== 1. Encapsulamiento =====");
        CuentaBancaria miCuenta = new CuentaBancaria("001", "Ana López", 10000.0);
        //miCuenta.saldo = 50000;
        //Desde main solo se pueden acceder por metodos publicos y saldo es private en CuentaBancaria osea solo lo puedo modificar y leer en la misma clase

        System.out.println("\n===== 2. Atributos públicos =====");
        System.out.println("Titular: " + miCuenta.titular);
        System.out.println("Número de cuenta: " + miCuenta.numeroCuenta);

        System.out.println("\n===== 3. CuentaAhorros: 4 retiros consecutivos =====");
        CuentaAhorro ahorro = new CuentaAhorro("002", "Luis Pérez", 3000.0, 5.0);

        System.out.println("Saldo inicial: L. " + ahorro.getSaldo());
        for (int i = 1; i <= 4; i++) {
            System.out.println("\n--- Retiro " + i + " (L. 200) ---");
            ahorro.retirarConComision(200);
            System.out.println("Saldo actual: L. " + ahorro.getSaldo());
        }
        
        System.out.println("\n===== 4. Interés mensual =====");
        double saldoAntes = ahorro.getSaldo();
        System.out.println("Saldo antes del interés: L. " + saldoAntes);
        ahorro.aplicarInteresMensual();
        System.out.println("Saldo después del interés: L. " + ahorro.getSaldo());
        System.out.println("Interés ganado: L. " + (ahorro.getSaldo() - saldoAntes));

        System.out.println("\n===== 5. CuentaCorriente: retiro con sobregiro =====");
        CuentaCorriente corriente = new CuentaCorriente("003", "Empresa SA", 1000.0, "Empresa SA", 5000.0);

        System.out.println("Saldo inicial: L. " + corriente.getSaldo());
        corriente.retirarConSobregiro(3500);
        System.out.println("Saldo después del retiro: L. " + corriente.getSaldo());
        System.out.println("Sobregiro utilizado (con recargo): L. " + corriente.getSobregiroUtilizado());
        
        System.out.println("\n===== 6. Pago de sobregiro =====");
        corriente.pagarSobregiro(1000);
        System.out.println("Sobregiro pendiente: L. " + corriente.getSobregiroUtilizado());
        System.out.println("Saldo final: L. " + corriente.getSaldo());

        System.out.println();
        corriente.mostrarDatos();
    }
}
