import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Cuenta Bancaria");
            System.out.println("2. Polimorfismo con Empleados");
            System.out.println("3. Ocultamiento de Atributos");
            System.out.println("4. Arrays y Referencias");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    CuentaBancaria cuenta = new CuentaBancaria("001", 1000);
                    cuenta.depositar(200);
                    cuenta.retirar(100);
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;

                case 2:
                    Empleado e1 = new EmpleadoFijo(15000);
                    Empleado e2 = new EmpleadoPorHora(160, 100);

                    System.out.println("Empleado fijo: " + e1.calcularSalario());
                    System.out.println("Empleado por hora: " + e2.calcularSalario());
                    break;

                case 3:
                    A obj = new B();
                    System.out.println("Valor de x: " + obj.x);
                    break;
                    /*
                    El objeto creado es de tipo B, pero la referencia es de tipo A.
                    En Java, los atributos no son polimorficos
                    Por eso se accede al atributo x de la clase A y no al de la clase B en este caso.
                    */
                case 4:
                    int[] a1 = {1, 2, 3};
                    int[] a2 = a1;

                    a2[0] = 9;

                    for (int i : a1) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}


/* https://github.com/NashRojas/Ejercicios_Clase_P3.git */