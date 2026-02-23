package sistema_cajeros_bancos;

public class Boveda {
    private double saldo = 50000;

    public synchronized boolean retirar(double monto, String nombreCajero) {
        if ( saldo >= monto) {
            saldo -= monto;
            System.out.println(nombreCajero + " retiro $" + monto + " | Saldo restante: $" + saldo);
            return true;
        } else {
            System.out.println(nombreCajero + " intento retirar $" + monto + " pero no hay saldo suficiente.");
            return false;
        }
    }
    public double getSaldo(){
        return saldo;
    }
}
