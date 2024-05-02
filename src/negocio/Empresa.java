package negocio;

import java.util.ArrayList;
					    
public class Empresa { 

	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Chofer> choferes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Viaje> viajes;
	private VehiculoFactory fabrica=new VehiculoFactory();
	
	public Empresa() {
		this.vehiculos = new ArrayList<>();
		this.choferes = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}

	public void agregarVehiculo(String tipo, String patente) {
		Vehiculo vehiculo = fabrica.getVehiculo(tipo, patente);
		vehiculos.add(vehiculo);
	}

	
	
	public VehiculoFactory getFabrica() {
		return fabrica;
	}

	public void setFabrica(VehiculoFactory fabrica) {
		this.fabrica = fabrica;
	}

	public void agregarChofer(Chofer chofer) {
		choferes.add(chofer);
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void agregarViaje(Viaje viaje) {
		viajes.add(viaje);
	}
	
	public void solicitaViaje(long fecha, int hora, String zona, boolean mascotas, boolean baul, int cantPasajeros, Cliente cliente) {
		Pedido pedido= new Pedido(fecha, hora, zona, mascotas, baul, cantPasajeros, cliente);
		
		try {
			//Viaje viaje= ViajeFactory.getViaje();
		}
		catch (FaltaDeChoferException ex){
			System.out.println("No hay choferes disponibles.");
		}
		catch (FaltaDeVehiculoException ex){
			System.out.println("No hay vehiculos disponibles.");
		}
		catch (ZonaInexistenteException ex){
			System.out.println("Zona incorrecta ingresada.");
		}
	}
	
	public static void setCostoBaseViaje(float costoBase) {
		Viaje.setCostoBase(costoBase);
	}

	public Vehiculo seleccionaMejorVehiculo(Pedido pedido)throws FaltaDeVehiculoException{
		int mayor = -1;
		int k = 0;
		Vehiculo mejor = null;
		for (int i = 1; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPrioridad(pedido) > mayor) {
                mayor = vehiculos.get(i).getPrioridad(pedido);
                mejor = vehiculos.get(i);
                k=i;
            }
        }
		if(mejor != null) {
			vehiculos.remove(k);
			vehiculos.add(mejor);
		}
		else
			throw new FaltaDeVehiculoException();
		return mejor;
	}

	public Chofer seleccionaChofer(Pedido pedido) {
		Chofer chofer = choferes.get(0);
		choferes.remove(0);
		choferes.add(chofer);
		return chofer;
	}

	public String muestraClientes() {
		String texto="";
		
		if(clientes.size() == 0) {
			texto = "No hay clientes";
		}
		else {
			for(int i = 0; clientes.size()>i ; i++) {
				texto = texto + clientes.get(i).getNombre() + "\n";
			}
		}
		return texto;
	}
	
	public String muestraChoferes() {
		String texto="";
		
		if(choferes.size() == 0) {
			texto = "No hay choferes";
		}
		else {
			for(int i = 0; choferes.size()>i ; i++) {
				texto = texto + choferes.get(i).getNombre() + "\n";
			}
		}
		return texto;
	}
	
	public String muestraVehiculos() {
		String texto="";
		
		if(vehiculos.size() == 0) {
			texto = "No hay vehiculos";
		}
		else {
			for(int i = 0; vehiculos.size()>i ; i++) {
				texto = texto + vehiculos.get(i).getPatente()+ "\n";
			}
		}
		return texto;
	}
	
	public String muestraViajes() {  //Consultar que les parece esa informacion de viaje
		String texto="";
		
		if(viajes.size() == 0) {
			texto = "No hay viajes";
		}
		else {
			for(int i = 0; clientes.size()>i ; i++) {
				texto = texto + "Viaje de " + viajes.get(i).getCliente().getNombre() + " en el vehiculo de patente " + viajes.get(i).getVehiculo().getPatente() + "\n";
			}
		}
		return texto;
	}
	
	public String muestraViajesClondados(){
		String texto="";
		
		ArrayList<Viaje> clonados = new ArrayList<>();
		
		try {
			clonados= clonaYOrdenaViajes(viajes);
		}
		
		
	}

	private ArrayList<Viaje> clonaYOrdenaViajes(ArrayList<Viaje> viajes2) throws noClono { //REVISAR TRY Y CATCH
		ArrayList<Viaje> viajesClonados = new ArrayList<>();
		for (int i = 0; i < viajes2.size(); i++) {
			try {
				viajesClonados.add((Viaje) viajes2.get(i).clone());
			}
			catch (CloneNotSupportedException e){
				throw new noClono();
			}
		}
		
		
		// Primero clona elemento a elemento y despues con un compare to y dos whiles los va ordenando 
		return viajesClonados;
	}

}
