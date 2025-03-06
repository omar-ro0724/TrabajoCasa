package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<CuentaBancaria> listaCuentaBancaria = new ArrayList<>();


        listaCuentaBancaria.add(new CuentaBancaria("OMAR RODRIGUEZ", 20000.0, 1));
        listaCuentaBancaria.add(new CuentaBancaria("JUAN PEREZ", 34567.0, 2));
        listaCuentaBancaria.add(new CuentaBancaria("ANTONIO SILVA", 12038.0, 3));
        listaCuentaBancaria.add(new CuentaBancaria("ANGELA GUITERREZ", 27462.0, 4));
        listaCuentaBancaria.add(new CuentaBancaria("PAULA FONSECA", 219237.0, 5));

        while (true) {
            System.out.println("\n Menú ");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Mostrar información de la cuenta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = teclado.nextInt();
            if (opcion == 4) {
                System.out.println("Saliendo del programa.");
                break;
            }

            System.out.print("Ingrese el número de cuenta: ");
            int numeroCuenta = teclado.nextInt();
            CuentaBancaria cuenta = buscarCuentaPorNumero(listaCuentaBancaria, numeroCuenta);

            if (cuenta == null) {
                System.out.println("Cuenta no encontrada.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = teclado.nextDouble();
                    cuenta.depositar(montoDeposito);
                }
                case 2 -> {
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = teclado.nextDouble();
                    cuenta.retirar(montoRetiro);
                }
                case 3 -> System.out.println(cuenta);
                default -> System.out.println("Opción no válida.");
            }
        }
        teclado.close();
    }

    public static CuentaBancaria buscarCuentaPorNumero(List<CuentaBancaria> cuentas, int numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }
}
