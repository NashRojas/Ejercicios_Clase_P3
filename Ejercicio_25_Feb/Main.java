package Ejercicio_25_Feb;
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Date inicio = new Date();

        Contador contador = new Contador();

        Thread h1 = new Thread(new ProcesadorArchivo("texto1.txt", 0, contador));
        Thread h2 = new Thread(new ProcesadorArchivo("texto2.txt", 1, contador));
        Thread h3= new Thread(new ProcesadorArchivo("texto3.txt", 2, contador));
    
        h1.start();
        h2.start();
        h3.start();
    
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    

        Date fin = new Date();
        long tiempo = fin.getTime() - inicio.getTime();

        generarReporte(contador, tiempo);
    }

    public static void generarReporte(Contador contador, long tiempo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("estadisticas.txt"))){
            pw.println("========================================");
            pw.println("REPORTE DE PROCESAMIENTO DE ARCHIVOS");
            pw.println("========================================\n");

            pw.println("Archivo: texto1.txt");
            pw.println("Palabras encontradas: " + contador.getResultados()[0] + "\n");

            pw.println("Archivo: texto2.txt");
            pw.println("Palabras encontradas: " + contador.getResultados()[1] + "\n");

            pw.println("Archivo: texto3.txt");
            pw.println("Palabras encontradas: " + contador.getResultados()[2] + "\n");

            pw.println("----------------------------------------");
            pw.println("Total de palabras procesadas: " + contador.getTotal());
            pw.println("Tiempo de procesamiento: " + tiempo + " ms");
            pw.println("========================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
