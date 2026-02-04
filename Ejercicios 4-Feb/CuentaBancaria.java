public class CuentaBancaria {
    private double saldo;
    private String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }
}
