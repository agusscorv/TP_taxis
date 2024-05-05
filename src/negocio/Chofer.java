package negocio;

public abstract class Chofer
{
	private String dni;
	protected String nombre;
	
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
	
	/**
	 * Obtiene el dni del chofer 
	 * Post: Devuelve el dni del chofer 
	 */
	public String getDni()
	{
		return dni;
	}
	
	/**
	 * Asigna el dni al chofer 
	 * Post: Establece el dni del chofer 
	 */
	public void setDni(String dni)
	{
		this.dni = dni;
	}
	
	/**
	 * Obtiene el nombre del chofer 
	 * Post: Devuelve el nombre del chofer
	 */
	public String getNombre()
	{
		return nombre;
	}
	
	/**
	 * Asigna el nombre del chofer
	 * Post: Establece el nombre del chofer
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene el sueldo neto del chofer
	 * Post: Devuelve un double correspondiente al sueldo neto del chofer, dependiendo si es permanente, temporario o contratado
	 */
	public abstract double getSueldo();
}
