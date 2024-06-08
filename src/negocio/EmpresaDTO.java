	package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

					    
public class EmpresaDTO { 

	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Chofer> choferes;
	private ArrayList<Cliente> clientes;
	private ArrayList<IViaje> viajes;
	private VehiculoFactory fabrica=new VehiculoFactory();
	private ViajeFactory fabricaViajes=new ViajeFactory();
	public GregorianCalendar hoy = new GregorianCalendar();
	private static Empresa instancia = null;

public EmpresaDTO{
    super();
}
public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}
	public void setChoferes(ArrayList<Chofer> choferes) {
		this.choferes = choferes;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<IViaje> getViajes() {
		return viajes;
	}
	public void setViajes(ArrayList<IViaje> viajes) {
		this.viajes = viajes;
	}
	public VehiculoFactory getFabrica() {
		return fabrica;
	}
	public void setFabrica(VehiculoFactory fabrica) {
		this.fabrica = fabrica;
	}
	public ViajeFactory getFabricaViajes() {
		return fabricaViajes;
	}
	public void setFabricaViajes(ViajeFactory fabricaViajes) {
		this.fabricaViajes = fabricaViajes;
	}
	public static Empresa getInstancia() {
		return instancia;
	}
	public static void setInstancia(Empresa instancia) {
		EmpresaDTO.instancia = instancia;
	}
}
