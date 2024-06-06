package negocio;

import java.util.ArrayList;
import java.util.Observable;

public class RecursoCompartido extends Observable{
	private boolean estado;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<IViaje> viajes;
	private Empresa empresa;

	public RecursoCompartido(ArrayList<Vehiculo> vehiculos, Empresa empresa) {
		super();
		this.estado = true;
		this.vehiculos = vehiculos;
		this.viajes = new ArrayList<IViaje>();
		this.empresa = empresa;
	}

	//NUEVO
	public String getCondicionViaje(Pedido pedido) {
		String condicion="";
		for (int i = 0; i < viajes.size(); i++) {
			if (viajes.get(i).getCliente().equals(pedido.getUserCliente()) && !(viajes.get(i).getEstado().equals("finalizado"))) {
				condicion = viajes.get(i).getEstado();
			}
		}
		return condicion;
	}
	
	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	//NUEVO
	public synchronized boolean aceptarPedido(Pedido pedido) {
		boolean aceptado=false;
		//pedido.isMascota()
		//pedido.isBaul()
		if (pedido.getCantPasajeros()>10 || (pedido.getCantPasajeros()> 4 && pedido.isMascota())) {
			aceptado= false;
		}
		else {
			for (int i = 0; i < vehiculos.size(); i++) {
				if (vehiculos.get(i).checkCantPasajeros(pedido)) {
					aceptado = true;
		        }
		    }
		}
		return aceptado;
	}
	
	//NUEVO   deberia sacar los throw del metodo empresa, no?
	public synchronized void solicitarViaje(Pedido pedido) throws FaltaDeChoferException, FaltaDeVehiculoException, ZonaInexistenteException {
		IViaje viaje= this.empresa.solicitaViaje(pedido);
		this.viajes.add(viaje);
	}

	public synchronized void asignarVehiculoAViaje(Vehiculo vehiculo) {
		
	}
		

	public synchronized void asignarViajeAChofer(Chofer chofer) {
		int i=-1;
		int j=-1;
		boolean encontrado=false;
		boolean encontradoVehiculo=false;
		
		while (i < viajes.size() && !encontrado) {
			i++;
            if (viajes.get(i).getEstado().equalsIgnoreCase("con vehiculo")) {
            	viajes.get(i).setChofer(chofer);
            	viajes.get(i).setCondicion("iniciado");
            	while (j < vehiculos.size() && !encontradoVehiculo) { //marca vehiculo como ocupado
            		j++;
            		if (vehiculos.get(j).getPatente().equalsIgnoreCase(viajes.get(i).getVehiculo().getPatente())) {
            			vehiculos.get(j).setOcupado(true);
            		}
            			
            	}
                encontrado = true;
            }   
		}
		
	}

	public synchronized void pagarViaje(Pedido pedido) {
		this.empresa.pagarViaje(pedido);
	}

	public void finalizarViaje(Chofer chofer) {
		boolean encontrado=false;
		int i=-1;
		int j=-1;
		boolean encontradoVehiculo=false;
		
		while (i < viajes.size() && !encontrado) {
			i++;
			 if ( viajes.get(i).getChofer().getDni().equals(chofer.getDni()) && viajes.get(i).getEstado().equalsIgnoreCase("pagado")) {
				 encontrado=true;
				 viajes.get(i).setCondicion("finalizado");
				 while (j < vehiculos.size() && !encontradoVehiculo) { //marca vehiculo como desocupado
	            		j++;
	            		if (vehiculos.get(j).getPatente().equalsIgnoreCase(viajes.get(i).getVehiculo().getPatente())) {
	            			vehiculos.get(j).setOcupado(false);
	            		}		
	            }
			 }
		}
	}

	public void rechazado() {
		// armar string para la ventan de pedido rechazado

	}

}
