package negocio;

public class ChoferDTO {
	private String dni;
	protected String nombre;
	private int puntaje;
	
	public ChoferDTO() {
		super();
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
  public void addPuntaje(int puntuacion) {
		this.puntaje += puntuacion;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
}
