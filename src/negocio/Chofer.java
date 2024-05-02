package negocio;

public abstract class Chofer
{
	private String dni;
	private String nombre;
	
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
	
	public abstract double getSueldo();
}
