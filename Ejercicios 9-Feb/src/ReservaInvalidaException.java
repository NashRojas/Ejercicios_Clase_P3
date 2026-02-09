public class ReservaInvalidaException extends RuntimeException { // use el RuntimeException para no tener que usar throw de forma obligatoria
             // de esta forma no tengo que declararla y el programa no se caera capturando desde main
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
