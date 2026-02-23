package sistema_cajeros_bancos;

import java.util.Random;

public class Cajero extends Thread {
    
    private Boveda boveda;
    private int transaccionesRealizadas = 0;
    private Random random = new Random();

    public Cajero(String nombre, Boveda boveda){
        super(nombre);
        this.boveda = boveda;
    }

    public void run() {
        int cantidadClientes = random.nextInt(3) + 3;

        for (int i = 0; i < cantidadClientes; i++) {
            try {
                int tiempo = random.nextInt(3) + 1;
                Thread.sleep(tiempo * 1000);

                double monto = random.nextInt(1501) + 500;

                boolean exito = boveda.retirar(monto, getName());

                if(exito) {
                    transaccionesRealizadas++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " Finalizo.");
    }

    public int getTransaccionesRealizadas() {
        return transaccionesRealizadas;
    }
}

