package negocio;

import java.util.ArrayList;

public class RecursoCompartido {
	private boolean estado;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Viaje> viajes;

	public RecursoCompartido(ArrayList<Vehiculo> vehiculos) {
		super();
		this.estado = true;
		this.vehiculos =  vehiculos;
		this.viajes = new ArrayList<Viaje>();
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public synchronized boolean aceptarPedido(Pedido pedido) {
        //evaluar las condiciones y ver si tenemos vehiculos con esas capacidades.
        return true; 
        //return falsa
    }
	
	public synchronized Viaje solicitarViaje(Pedido pedido) {
        //debe llamar a Empresa.solicitaViaje
        return viaje;
    }

	public synchronized void pagarViaje(Viaje viaje) {
        // Condicion pagado
    }
	
	public synchronized void finalizarViaje(Viaje viaje) {
        //lo hace el chofer
    }
	
	public synchronized void asignarVehiculoAViaje() {
		//asigna vehiculo
	}
	

}
