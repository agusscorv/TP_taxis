package negocio;

import java.util.GregorianCalendar;

public class Permanente extends Empleado
{
	private int cantHijos;
	private GregorianCalendar fecha_ingreso;
	public static double plus_x_antiguedad = 2;
	public static double plus_x_hijos = 2;

	public Permanente(String dni, String nombre, double sueldo_basico, int cantHijos, GregorianCalendar fecha_ingreso)
	{
		super(dni, nombre, sueldo_basico);
		this.cantHijos = cantHijos;
		this.fecha_ingreso = fecha_ingreso;
	}
	
	@Override
	public double getBruto(double sueldo_basico)
	{
		return sueldo_basico + (sueldo_basico / 100) * (plus_x_antiguedad * GetAntiguedad() + plus_x_hijos * this.cantHijos);	//Necesito saber la fecha actual no?
	}
	
	@Override
	public double getSueldo()
	{
		double sueldoBruto = getBruto(sueldo_basico);
		return sueldoBruto - (Empleado.aportes / 100) * sueldoBruto;
	}

	public GregorianCalendar getFecha_ingreso() {
		return fecha_ingreso;
	}
	
	public int GetAntiguedad(){ //Devuelve los anios de antiguedad del chofer
		long DifMilesimos = Empresa.hoy.getTime().getTime() - this.fecha_ingreso.getTime().getTime();
		long MilesimosEnAnio = 1000*3600*24*365;
		return (int) (DifMilesimos/MilesimosEnAnio); //Redondea bien?
	}
}
