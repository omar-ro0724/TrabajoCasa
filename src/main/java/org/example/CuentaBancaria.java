package org.example;

public class CuentaBancaria {
    private String titular;
    private double saldo;
    private int numeroCuenta;

    public CuentaBancaria(String titular, double saldo, int numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria" +
                "Titular :" + titular  +
                ", Saldo=$" + String.format("%.2f", saldo) +
                ", Número de Cuenta=" + numeroCuenta ;
    }


    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("DEPÓSITO DE $" + String.format("%.2f", monto) +
                    " realizado en la cuenta de " + titular);
        } else {
            System.out.println("El monto a depositar debe ser mayor que cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("RETIRO DE $" + String.format("%.2f", monto) +
                    " realizado en la cuenta de " + titular);
            return true;
        } else {
            System.out.println("Fondos insuficientes o monto inválido para " + titular);
            return false;
        }
    }

}
