package negocio;

/**
 * Clase concreta : Auto es un tipo de vehiculo que puede utilizar un chofer determinado para realizar un viaje.
 */
public class Auto extends Vehiculo {

	/**
	 * Constructor del auto
	 * Pre: patente!=null,patente!=""
	 * Post: se crea un objeto de tipo auto con el atributo patente ingresado y una cantidad maxima de personas determinada 
	 * @param patente = patente que hace de identificador de vehiculo
	 */
	public Auto(String patente) {
		super(patente,4);
	}

	
	/**Verifica si se puede realizar el pedido analizando la condicion de mascota para el vehiculo auto
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true o false si se cumple la condicion de mascota que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con el vehiculo auto
	 */
	public boolean checkMascota(Pedido pedido){
		return true;
	}
	
	/**Verifica si se puede realizar el pedido analizando la condicion de mascota para el vehiculo auto
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true o false si se cumple la condicion de baul que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con el vehiculo auto
	 */
	public boolean checkBaul(Pedido pedido) {
		return true;
	}
	
	/** Calcula la prioridad del vehiculo auto para realizar un viaje determinado
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve un int que es la prioridad del vehiculo auto para realizar un viaje
	 * @param pedido: pedido para realizar un viaje con el vehiculo auto
	 */
	public int calculo(Pedido pedido){
		if (pedido.isBaul())
			return 40*pedido.getCantPasajeros();
		else
			return 30*pedido.getCantPasajeros();
	}
}
