import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {

    private String nombreCliente;
    private Date fechaReserva;
    private int cantidadPersonas;

    public Reserva(String nombreCliente, String fechaTexto, int cantidadPersonas) {

        // validacion del nombre
        if (nombreCliente == null || nombreCliente.trim().isEmpty()) {
            throw new ReservaInvalidaException("Nombre del cliente invalido.");
        }
        this.nombreCliente = nombreCliente.trim();

        // para validar la cantidad
        if (cantidadPersonas <= 0) {
            throw new ReservaInvalidaException("La cantidad de personas debe ser mayor que cero.");
        }
        this.cantidadPersonas = cantidadPersonas;

        // Validar fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);
        try {
            this.fechaReserva = formato.parse(fechaTexto);
        } catch (Exception e) {
            throw new ReservaInvalidaException("Formato de fecha invalido. Use dd/MM/yyyy");
        }
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Cliente: " + nombreCliente +
            " | Fecha: " + formato.format(fechaReserva) +
            " | Personas: " + cantidadPersonas;
    }
}
