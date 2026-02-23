package Sistema_Registro_Estudiantes;
import java.io.*;
import java.util.*;

public class Sistema {
    
    static final String ARCHIVO = "estudiantes.dat";
    static ArrayList<Estudiante> lista = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        cargarArchivo();

        int opcion;

        do {
            System.out.println("\n ---Menu ---");
            System.out.println(" 1) Agregar Estudiante");
            System.out.println(" 2) Buscar Estudiante");
            System.out.println(" 3) Listar Estudiantes");
            System.out.println(" 4) Salir ");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarEstudiante(sc);
                    break;
                case 2:
                    buscarEstudiante(sc);
                    break;

                case 3:
                    listarEstudiantes();
                    break;

                case 4:
                    guardarArchivo();
                    System.out.println("Datos guardados. Saliendo....");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                }
        } while(opcion != 4);
        sc.close();
    }

    public static void cargarArchivo() {

        File file = new File(ARCHIVO);

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Archivo creado.");
            } catch (IOException e) {
                System.out.println("Error al crear archivo: " + e.getMessage());
            }
            return;
        }

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(file))) {

            lista = (ArrayList<Estudiante>) ois.readObject();
            System.out.println("Datos cargados correctamente.");

        } catch (EOFException e) {
            System.out.println("Archivo vacio.");
        } catch (Exception e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
        }
    }


    public static void guardarArchivo() {
        try (ObjectOutputStream oss = 
            new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {

            oss.writeObject(lista);
        } catch(Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }


    public static void agregarEstudiante(Scanner sc) {

        try {
            System.out.println("--------------------Agregar Estudiante--------------------");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Matricula: ");
            String matricula = sc.nextLine();

            System.out.print("Promedio: ");
            double promedio = sc.nextDouble();
            sc.nextLine();

            Estudiante e = new Estudiante(nombre, matricula, promedio);
            lista.add(e);

            System.out.println("Estudiante agregado.");

        } catch (Exception ex) {
            System.out.println("Error al agregar estudiante.");
            sc.nextLine();
        }
    }


    public static void listarEstudiantes() {

        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        for (Estudiante e : lista) {
            System.out.println(e);
        }
    }

    public static void buscarEstudiante(Scanner sc) {
        System.out.println("");
        System.out.print("Ingrese matricula a buscar: ");
        String mat = sc.nextLine();

        try (RandomAccessFile raf =
                    new RandomAccessFile(ARCHIVO, "r")) {

            if (raf.length() == 0) {
                System.out.println("Archivo vacio.");
                return;
            }

            // Leemos todo el objeto serializado
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(ARCHIVO));

            ArrayList<Estudiante> temp =
                    (ArrayList<Estudiante>) ois.readObject();

            boolean encontrado = false;

            for (Estudiante e : temp) {
                if (e.getMatricula().equals(mat)) {
                    System.out.println("Encontrado:");
                    System.out.println(e);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontro el estudiante.");
            }

            ois.close();

        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
    }


}
