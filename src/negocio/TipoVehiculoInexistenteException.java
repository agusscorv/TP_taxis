package negocio;

public class TipoVehiculoInexistenteException extends Exception {
    public TipoVehiculoInexistenteException(){
    	super("El tipo de vehiculo ingresado es incorrecto");
    };
}
