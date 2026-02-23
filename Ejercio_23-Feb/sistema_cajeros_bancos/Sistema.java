package sistema_cajeros_bancos;

public class Sistema {
    
    public static void main(String[] args) {
        
        Boveda boveda = new Boveda();

        Cajero cajero1 = new Cajero("Cajero 1", boveda);
        Cajero cajero2 = new Cajero("Cajero 2", boveda);
        Cajero cajero3 = new Cajero("Cajero 3", boveda);
    
        MonitorSaldo monitor = new MonitorSaldo(boveda);
        monitor.setDaemon(true);

        monitor.start();
        cajero1.start();
        cajero2.start();
        cajero3.start();

        try {
            cajero1.join();
            cajero2.join();
            cajero3.join();
        } catch (Exception e) {
            e.printStackTrace();;
        }

        System.out.println("\n -- Resumen Final ---");
        System.out.println("Cajero 1 realizo: " + cajero1.getTransaccionesRealizadas());
        System.out.println("Cajero 2 realizo: " + cajero2.getTransaccionesRealizadas());
        System.out.println("Cajero 3 realizo: " + cajero3.getTransaccionesRealizadas());
        System.out.println("Saldo final en boveda: $" + boveda.getSaldo());
    }
}
