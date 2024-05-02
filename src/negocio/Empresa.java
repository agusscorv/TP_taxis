package negocio;

import java.util.ArrayList;

public class Empresa { // FALTA HACER EN PRUEBA EL MOSTRAR CLIENTES, CHOFERES, VEHICULOS, VIAJES

	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Chofer> choferes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Viaje> viajes;
	
	public Empresa() {
		this.vehiculos = new ArrayList<>();
		this.choferes = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}

	public void agregarVehiculo(String tipo, String patente) {
		VehiculoFactory.getVehiculo(tipo, patente);
		vehiculos.add(vehiculo);
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

	public Vehiculo seleccionaMejorVehiculo(Pedido pedido) {
		int mayor = -1;
		int k;
		Vehiculo mejor;
		for (int i = 1; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPrioridad() > mayor) {
                mayor = vehiculos.get(i).getPrioridad();
                mejor = vehiculos.get(i);
                k=i;
            }
        }
		vehiculos.remove(k);	//pone el "mejor" al final 
		vehiculos.add(mejor);
		return mejor;
	}

	public Chofer seleccionaChofer(Pedido pedido) {
		
		return null;
	}

}
