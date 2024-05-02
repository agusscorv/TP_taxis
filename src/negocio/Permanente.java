package negocio;

public class Permanente extends Empleado
{
	private int cantHijos;
	private int fecha_ingreso;
	public static double plus_x_antiguedad=2;
	public static double plus_x_hijos=2;

	public Permanente(String dni, String nombre, double sueldo_basico, int cantHijos, int fecha_ingreso)
	{
		super(dni, nombre, sueldo_basico);
		this.cantHijos = cantHijos;
		this.fecha_ingreso = fecha_ingreso;
	}
	
	@Override
	public double getBruto(double sueldo_basico)
	{
		return sueldo_basico + (sueldo_basico / 100) * (plus_x_antiguedad + plus_x_hijos * this.cantHijos);	//Necesito saber la fecha actual no?
	}
	
	@Override
	public double getSueldo()
	{
		double sueldoBruto = getBruto(sueldo_basico);
		return sueldoBruto - (super.aportes / 100) * sueldoBruto;
	}
}
