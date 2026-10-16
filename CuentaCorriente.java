/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corebanca;

/**
 *
 * @author antiblex
 */
public class CuentaCorriente extends CuentaBancaria{
    
    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado;
    
    CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro){
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    double getLimiteSobregiro(){
        return limiteSobregiro;
    }

    double getSobregiroUtilizado(){
        return sobregiroUtilizado;
    }

    boolean retirarConSobregiro(double monto){
        
        if (monto <= 0){
            System.out.println("El monto a retirar debe ser mayor que 0.");
            return false;
        }

        if (getSaldo() >= monto){
            return retirar(monto);
        }

        double cupoDisponible = limiteSobregiro - sobregiroUtilizado;
        if (monto <= getSaldo() + cupoDisponible){
            double saldoDisponible = getSaldo();
            double diferencia = monto - saldoDisponible;
            double recargo = diferencia * 0.03;

            if (saldoDisponible > 0){
                retirar(saldoDisponible);
            }

            sobregiroUtilizado += diferencia + recargo;

            System.out.println("Retiro con sobregiro exitoso.");
            System.out.println("Sobregiro utilizado: " + diferencia);
            System.out.println("Recargo por servicio (3%): " + recargo);
            return true;
        }

        System.out.println("El monto excede el saldo más el cupo de sobregiro disponible.");
        return false;
    }

    public void pagarSobregiro(double monto){
        if (monto <= 0){
            System.out.println("El monto a pagar debe ser mayor que 0.");
            return;
        }

        double abono = Math.min(monto, sobregiroUtilizado);
        sobregiroUtilizado -= abono;
        double sobrante = monto - abono;

        if (abono > 0){
            System.out.println("Abono al sobregiro: " + abono);
        }
        if (sobrante > 0){
            depositar(sobrante);
        }
    }
}
