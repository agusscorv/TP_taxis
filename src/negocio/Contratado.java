package negocio;

public class Contratado extends Chofer
{
	public static double ganancia_viaje = 15;
	private int cant_viajes;

	public Contratado(String dni, String nombre, int cant_viajes)
	{
		super(dni, nombre);
		this.cant_viajes = cant_viajes;
	}
	
	@Override
	public double getSueldo()
	{
		return this.cant_viajes * (ganancia_viaje / 100);
	}
}
