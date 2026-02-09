import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Reserva> reservas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Registrar reserva");
            System.out.println("2. Mostrar reservas");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    try {
                        
                        System.out.print("Nombre del cliente: ");
                        String nombre = sc.nextLine();

                        if (nombre.trim().isEmpty()) {
                            throw new ReservaInvalidaException("Nombre del cliente invalido.");
                        }

                        
                        System.out.print("Fecha (dd/MM/yyyy): ");
                        String fecha = sc.nextLine();

                        if (fecha.trim().isEmpty()) {
                            throw new ReservaInvalidaException("La fecha no puede estar vacia.");
                        }

                        
                        System.out.print("Cantidad de personas: ");
                        String textoCantidad = sc.nextLine();
                        int cantidad;

                        try {
                            cantidad = Integer.parseInt(textoCantidad);
                        } catch (NumberFormatException e) {
                            throw new ReservaInvalidaException("La cantidad debe ser un numero entero.");
                        }

                        // Crea la reserva 
                        Reserva r = new Reserva(nombre, fecha, cantidad);
                        reservas.add(r);

                        System.out.println("Reserva registrada con exito.");

                    } catch (ReservaInvalidaException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (reservas.isEmpty()) {
                        System.out.println("No hay reservas registradas.");
                    } else {
                        for (Reserva r : reservas) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
