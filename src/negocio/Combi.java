package negocio;

public class Combi extends Vehiculo {

	/**
	 * Constructor de la combi
	 * Pre: patente!=null,patente!=""
	 * Post: se crea un objeto de tipo combi con el atributo patente ingresado y una cantidad maxima de personas determinada 
	 * @param patente = patente que hace de identificador de vehiculo
	 */
	public Combi(String patente) {
		super(patente,10);
	}
	
	/**Verifica si se puede realizar el pedido analizando la condicion de mascota para el vehiculo combi
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true o false si se cumple la condicion de mascota que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con el vehiculo combi
	 */
	public boolean checkMascota(Pedido pedido){
		if (pedido.isMascota())
			return false;
		else
			return true;
	}
	
	/**Verifica si se puede realizar el pedido analizando la condicion de mascota para el vehiculo combi
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true o false si se cumple la condicion de baul que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con el vehiculo combi
	 */
	public boolean checkBaul(Pedido pedido){
		return true;
	}

	/** Calcula la prioridad del vehiculo combi para realizar un viaje determinado
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve un int que es la prioridad del vehiculo combi para realizar un viaje
	 * @param pedido: pedido para realizar un viaje con el vehiculo combi
	 */
	public int calculo(Pedido pedido){
		if (pedido.isBaul())
			return 100+10*pedido.getCantPasajeros();
		else
			return 10*pedido.getCantPasajeros();
	}
}
