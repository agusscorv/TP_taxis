package negocio;

/**
 * Clase concreta : Contratado es un tipo de chofer que se encarga de realizar los viajes con comportamientos determinados
 * Su sueldo se basa en un porcentaje de la ganancia obtenida en sus viajes en un mes.
 */

public class Contratado extends Chofer
{
	public static double ganancia_viaje = 15;
	private Empresa empresa = Empresa.obtenerInstancia();

	/**
	 * Constructor del chofer contratado
	 * Pre: dni!=null,dni!="",nombre!=null,nombre!="", cantViajes >=0
	 * Post: Se crea un nuevo chofer contratado con los atributos dados
	 * @param dni: documento identificatorio del chofer contratado
	 * @param nombre: nombre del chofer contratado
	 */
	public Contratado(String dni, String nombre)
	{
		super(dni, nombre);
	}
	
	/**
	 * Obtiene el sueldo neto del chofer contratado
	 * Post: Devuelve un double correspondiente al sueldo neto del chofer contratado
	 */
	@Override
	public double getSueldo()
	{
		return empresa.costoViajesMes(this) * (ganancia_viaje / 100);
	}
}
