package negocio;

public class Moto extends Vehiculo {
    
	/**
	 * Constructor de la moto
	 * Pre: patente!=null,patente!=""
	 * Post: se crea un objeto de tipo moto con el atributo patente ingresado y una cantidad maxima de personas determinada 
	 * @param patente = patente que hace de identificador de vehiculo
	 */
	public Moto(String patente) {
		super(patente,1);
	}
	
	/**Verifica si se puede realizar el pedido analizando la condicion de mascota para el vehiculo moto 
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true o false si se cumple la condicion de mascota que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con el vehiculo moto
	 */
	public boolean checkMascota(Pedido pedido){
		if (pedido.isMascota()) 
			return false;
		else
			return true;
	}
	
	/**Verifica si se puede realizar el pedido analizando la condicion de baul para el vehiculo moto 
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve true o false si se cumple la condicion de baul que requiere el pedido
	 * @param pedido: pedido para realizar un viaje con el vehiculo moto
	 */
	public boolean checkBaul(Pedido pedido){
		if (pedido.isBaul())
			return false;
		else
			return true;
	}
	
	
	/** Calcula la prioridad del vehiculo moto para realizar un viaje determinado
	 * pre: debe existir un pedido para realizar un viaje
	 * post: devuelve un int que es la prioridad del vehiculo moto para realizar un viaje
	 * @param pedido: pedido para realizar un viaje con el vehiculo moto
	 */
	public int calculo(Pedido pedido){
		return 1000;
	}

}
