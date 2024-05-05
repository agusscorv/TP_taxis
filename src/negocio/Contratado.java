package negocio;

public class Contratado extends Chofer
{
	public static double ganancia_viaje = 15;
	Empresa empresa= Empresa.obtenerInstancia();
	//private int cant_viajes;

	/**
	 * Constructor del chofer contratado
	 * Pre: dni!=null,dni!="",nombre!=null,nombre!="", cantViajes >=0
	 * Post: Se crea un nuevo chofer contratado con los atributos dados
	 * @param dni: documento identificatorio del chofer contratado
	 * @param nombre: nombre del chofer contratado
	 * @param cant_viajes: Cantidad de viajes que realizo el chofer contratado
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
		return empresa.CostoViajesMes(this) * (ganancia_viaje / 100);
	}
}
