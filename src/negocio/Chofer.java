package negocio;

/**
 * Clase abstracta : Chofer es aquel que rinde el servicio necesario para realizar un viaje con determinado trayecto.
 */
public abstract class Chofer
{
	private String dni;
	protected String nombre;
	private int puntaje=0;
	
	/**
	 * Constructor del chofer
	 * Pre: dni!=null, dni!="", nombre!=null, nombre!=""
	 * Post: Se crea un nuevo chofer con los atributos dados
	 * @param dni: documento identificatorio del chofer permanente
	 * @param nombre: nombre del chofer
	 */
	public Chofer(String dni, String nombre)
	{
		this.dni = dni;
		this.nombre = nombre;
	}
	

	public String getDni()
	{
		return dni;
	}
	

	public void setDni(String dni)
	{
		this.dni = dni;
	}
	

	public String getNombre()
	{
		return nombre;
	}
	

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	/** Suma el puntaje mensual del chofer
     * pre: puntuacion >= 0
     * post: modifica el puntaje del chofer
     * @param puntuacion brindada al chofer en base a los viajes realizados y su distancia
     */
	public void addPuntaje(int puntuacion) {
		this.puntaje += puntuacion;
	}


	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}


	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Obtiene el sueldo neto del chofer
	 * Post: Devuelve un double correspondiente al sueldo neto del chofer, dependiendo si es permanente, temporario o contratado
	 */
	public abstract double getSueldo();
}
