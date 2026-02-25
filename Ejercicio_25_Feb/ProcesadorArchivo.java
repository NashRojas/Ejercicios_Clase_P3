package Ejercicio_25_Feb;

import java.io.*;

public class ProcesadorArchivo implements Runnable {

    private String nombreArchivo;
    private int posicion;
    private Contador contador;

    public ProcesadorArchivo(String nombreArchivo, int posicion, Contador contador) {
        this.nombreArchivo = nombreArchivo;
        this.posicion = posicion;
        this.contador = contador;
    }

    @Override
    public void run() {

        int contadorPalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.trim().split("\\s+");
                contadorPalabras += palabras.length;
            }

            contador.agregarResultado(posicion, contadorPalabras);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
