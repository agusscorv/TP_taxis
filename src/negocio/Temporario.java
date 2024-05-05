package negocio;

/**
 * Clase concreta : Temporario es un tipo de chofer que es empleado que se encarga de realizar los viajes con comportamientos determinados.
 * Su sueldo se basa en la cantidad de viajes que realiza por mes.
 */
public class Temporario extends Empleado
{
	public static double plus_x_cantidad_viajes = 10;
	private Empresa empresa= Empresa.obtenerInstancia();

	/**
	 * Constructor del chofer temporario
	 * Pre: dni!=null, dni!="", nombre!=null, nombre!="", sueldo_basico > 0, cantViajes >=0
	 * Post: Se ha creado un chofer temporario nuevo con los atributos dados.
	 * @param dni = documento identificatorio del chofer temporario
	 * @param nombre = nombre del chofer temporario
	 * @param sueldo_basico = sueldo del chofer temporario
	 */
	public Temporario(String dni, String nombre, double sueldo_basico)
	{
		super(dni, nombre, sueldo_basico);
	}
	/**Obtiene el sueldo bruto del chofer temporario.
	 * Pre: sueldo_basico > 0
	 * Post: devuelve un double correspondiente al sueldo bruto del chofer temporario
	 */
	@Override
	public double getBruto(double sueldo_basico)
	{
		if (empresa.CantViajesMes(this) > 40)
			return sueldo_basico + (sueldo_basico) * (plus_x_cantidad_viajes / 100);
		else
			return sueldo_basico;
	}
	/**Obtiene el sueldo neto del chofer temporario.
	 * Post: devuelve un double correspondiente al sueldo neto del chofer temporario
	 */
	@Override
	public double getSueldo()
	{
		double sueldoBruto = getBruto(super.sueldo_basico);
		return sueldoBruto - (aportes / 100) * sueldoBruto;
	}
}
