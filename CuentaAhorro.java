/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corebanca;

/**
 *
 * @author antiblex
 */
public class CuentaAhorro extends CuentaBancaria{
    
    public double tasaInteresAnual;
    private int retirosRealizadosMes;
    private final double comisionPorExceso = 20.0;
    
    CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual){
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
    }
    
    boolean retirarConComision(double monto){
        
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor que 0.");
            return false;
        }

        boolean cobraComision = retirosRealizadosMes >= 3;
        double montoTotal = cobraComision ? monto + comisionPorExceso : monto;

        if (retirar(montoTotal)) {
            retirosRealizadosMes++;
            if (cobraComision) {
                System.out.println("Se cobró una comision por exceso de retiros: " + comisionPorExceso);
            }
            return true;
        }
        return false;
    }
    
    void aplicarInteresMensual(){
        double interes = (getSaldo() * (tasaInteresAnual / 100)) / 12;
        depositar(interes);
    }
}
