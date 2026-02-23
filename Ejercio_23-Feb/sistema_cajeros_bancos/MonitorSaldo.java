package sistema_cajeros_bancos;

public class MonitorSaldo extends Thread {
    private Boveda boveda;

    public MonitorSaldo(Boveda boveda) {
        this.boveda = boveda;
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println("\n MONITOR >> Saldo Actual: $" + boveda.getSaldo());
            } catch (InterruptedException e) {
            break;
            }
        }
    }
}