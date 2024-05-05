package negocio;

/**
 * Clase abstracta : Empleado es un tipo de chofer que tiene un vinculo contractual con la empresa con comportamientos determinados.
 */
public abstract class Empleado extends Chofer
{

	protected double sueldo_basico;
	public static double aportes = 25; 
	
	/**Constructor del chofer empleado.
	 * pre: Pre: dni!=null,dni!="",nombre!=null,nombre!="",sueldo_basico > 0
	 * post: Se ha creado un chofer empleado nuevo con los atributos dados.
	 * @param dni = documento identificador del chofer empleado
	 * @param nombre = nombre del chofer empleado
	 * @param sueldo_basico = sueldo del chofer empleado
	 */
	public Empleado(String dni, String nombre, double sueldo_basico)
	{
		super(dni, nombre);
		this.sueldo_basico = sueldo_basico;
	}
	
	/** Devuelve el sueldo bruto del chofer empleado
	 * pre: sueldo_basico > 0
	 * post: devuelve un double correspondiente al sueldo basico del chofer empleado, dependiendo si es temporario o permanente
	 * @param sueldo_basico = sueldo del chofer empleado
	 */
	public abstract double getBruto(double sueldo_basico);
}
