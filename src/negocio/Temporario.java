package negocio;

public class Temporario extends Empleado
{
	private int cantViajes;
	public static double plus_x_cantidad_viajes = 10;

	public Temporario(String dni, String nombre, double sueldo_basico, int cantViajes)
	{
		super(dni, nombre, sueldo_basico);
		this.cantViajes = cantViajes;
		
	}
	
	@Override
	public double getBruto(double sueldo_basico)
	{
		if (this.cantViajes > 40)
			return sueldo_basico + (sueldo_basico) * (plus_x_cantidad_viajes / 100);
		else
			return sueldo_basico;
	}
	
	@Override
	public double getSueldo()
	{
		double sueldoBruto = getBruto(super.sueldo_basico);
		return sueldoBruto - (aportes / 100) * sueldoBruto;
	}
}
