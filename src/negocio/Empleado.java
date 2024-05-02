package negocio;

public abstract class Empleado extends Chofer
{

	protected double sueldo_basico;
	public static double aportes = 25; 
	
	public Empleado(String dni, String nombre, double sueldo_basico)
	{
		super(dni, nombre);
		this.sueldo_basico = sueldo_basico;
	}
	
	public abstract double getBruto(double sueldo_basico);
}
