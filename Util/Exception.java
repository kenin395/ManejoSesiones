package Util;

public class Exception extends RuntimeException {

    /*
     * Implementamos un constructor donde recibe como parametro un mensaje
     * Luego llamamos a la clase constructor de la clase padre para que
     * lance la expeción
     */
    public Exception(String mensaje) {
        super(mensaje);
    }

    /*
     * Implementamos un constructor donde recibe dos parámetros como
     * el mensaje y la causa de la excepcion
     * Luego se invoca al constructor de la clase padre donde devuelve
     * la causa de forma técnica
     */
    public Exception(String mensaje, Throwable cause) {
        super(cause);
    }
}