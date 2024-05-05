package negocio;

public abstract class Vehiculo {
	private int maxPasajeros;
	private String patente;
	
	/**
	 * Constructor del vehiculo
	 * Pre: patente!=null,patente!="", maxpasajeros>0
	 * Post: se crea un objeto de tipo Vehiculo con el atributo patente ingresado y una cantidad maxima de personas determinada 
	 * @param patente = patente que hace de identificador de vehiculo
	 * @param maxPasajeros = cantidad maxima de pasajeros que soporta el vehiculo
	 */
	public Vehiculo(String patente,int maxPasajeros){
		this.patente=patente;
		this.maxPasajeros=maxPasajeros;
	}

	/** determina el valor de la prioridad de un vehiculo determinado, siguiendo una serie de pasos, contemplando las condiciones del tipo de pedido
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve un int que es la prioridad del tipo de vehiculo para realizar un viaje
	 * @param pedido: pedido para realizar un viaje con un vehiculo
	 */
	public int getPrioridad(Pedido pedido) {
		boolean cond1 = this.checkCantPasajeros(pedido);
		boolean cond2 = checkMascota(pedido);
		boolean cond3 = checkBaul(pedido);
		
		if (cond1 && cond2 && cond3)
			return calculo(pedido);
		else
			return -1;
	}
	
	/**
	 * Compara la cantidad de pasajeros solicitada en el pedido con la cantidad maxima que soporta el tipo de vehiculo
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true si la cantidad de pasajeros solicitada en el pedido es soportado por el tipo del vehiculo, si no, devuelve false
	 * @param pedido: pedido para realizar un viaje con un vehiculo
	 */
	boolean checkCantPasajeros(Pedido pedido) {
		if (pedido.getCantPasajeros() > this.maxPasajeros)
			return false;
		else
			return true;
	}
	
	/**Verifica si se puede realizar el pedido analizando la condicion de mascota para el vehiculo
	 * post: devuelve true o false si se cumple la condicion de mascota que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con un vehiculo
	 */
	abstract boolean checkMascota(Pedido pedido);
	
	/**Verifica si se puede realizar el pedido analizando la condicion de baul para el vehiculo
	 * post: devuelve true o false si se cumple la condicion de baul que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con un vehiculo
	 */
	abstract boolean checkBaul(Pedido pedido);
	
	/** Calcula la prioridad de un vehiculo para realizar un viaje determinado
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve un int que es la prioridad de un vehiculo para realizar un viaje
	 * @param pedido: pedido para realizar un viaje con un vehiculo
	 */
	abstract int calculo(Pedido pedido);

	/** Obtiene la patente de dicho vehiculo
	 * post: devuelve un string que es la patente que identifica a dicho vehiculo
	 */
	public String getPatente() {
		return patente;
	}
}
