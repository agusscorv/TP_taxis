package negocio;

import java.util.GregorianCalendar;

/**
 * Clase concreta : Permanente es un tipo de chofer que es empleado que se encarga de realizar los viajes con comportamientos determinados.
 * Su sueldo se basa en su antiguedad y su cantidad de hijos.
 */
public class Permanente extends Empleado
{
	private int cantHijos;
	private GregorianCalendar fecha_ingreso;
	public static double plus_x_antiguedad = 2;
	public static double plus_x_hijos = 2;

	/**
	 * Constructor del chofer permanente
	 * Pre: dni!=null, dni!="", nombre!=null, nombre!="", sueldo_basico > 0, cantHijos >= 0, fecha_ingreso valida en el GregorianCalendar
	 * Post: Se crea un nuevo chofer permanente con los atributos dados
	 * @param dni: documento identificatorio del chofer permanente
	 * @param nombre: nombre del chofer permanente
	 * @param sueldo_basico: sueldo del chofer permanente
	 * @param cantHijos: cantidad de hijos del chofer permanente
	 * @param fecha_ingreso: fecha de ingreso a la empresa del chofer permanente
	 */
	public Permanente(String dni, String nombre, double sueldo_basico, int cantHijos, GregorianCalendar fecha_ingreso)
	{
		super(dni, nombre, sueldo_basico);
		this.cantHijos = cantHijos;
		this.fecha_ingreso = fecha_ingreso;
	}
	
	/**
	 * Obtiene el sueldo bruto del chofer permanente
	 * Pre: sueldo_basico > 0
	 * Post: devuelve un double correspondiente al sueldo bruto del chofer permanente
	 */
	@Override
	public double getBruto(double sueldo_basico)
	{
		return sueldo_basico + (sueldo_basico / 100) * (plus_x_antiguedad * GetAntiguedad() + plus_x_hijos * this.cantHijos);	//Necesito saber la fecha actual no?
	}
	
	/**
	 * Obtiene el sueldo neto del chofer permanente
	 * Post: Devuelve un double correspondiente al sueldo neto del chofer permanente
	 */
	@Override
	public double getSueldo()
	{
		double sueldoBruto = getBruto(sueldo_basico);
		return sueldoBruto - (Empleado.aportes / 100) * sueldoBruto;
	}
	
	/**
	 * Obtiene la fecha de ingreso del chofer permanente
	 * Post: Devuelve un GregorianCalendar correspondiente a la fecha de ingreso del chofer permanente
	 */
	public GregorianCalendar getFecha_ingreso() {
		return fecha_ingreso;
	}
	
	/**
	 * Obtiene la antiguedad de un chofer permanente
	 * Post: Devuelve un entero correspondiente a la cantidad de anios de antiguedad del chofer permanente
	 */
	public int GetAntiguedad(){ //Devuelve los anios de antiguedad del chofer
		long difAnios = Empresa.hoy.get(1) - this.fecha_ingreso.get(1);
		return (int) (difAnios); //Redondea bien?
	}
}
