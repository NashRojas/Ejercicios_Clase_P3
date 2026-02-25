package Ejercicio_25_Feb;

public class Contador {

    private int[] resultados = new int[3];
    private int total = 0;

    public synchronized void agregarResultado(int posicion, int cantidad) {
        resultados[posicion] = cantidad;
        total += cantidad;
    }

    public int[] getResultados() {
        return resultados;
    }

    public int getTotal() {
        return total;
    }
}
