public class Empleado {
    public double calcularSalario() {
        return 0;
    }
}

class EmpleadoFijo extends Empleado {
    double salario;

    public EmpleadoFijo(double salario) {
        this.salario = salario;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}

class EmpleadoPorHora extends Empleado {
    int horas;
    double pagoHora;

    public EmpleadoPorHora(int horas, double pagoHora) {
        this.horas = horas;
        this.pagoHora = pagoHora;
    }

    @Override
    public double calcularSalario() {
        return horas * pagoHora;
    }
}
