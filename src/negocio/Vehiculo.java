package negocio;

public abstract class Vehiculo {
	int maxPasajeros;
	String patente;
	
	public Vehiculo() {
		
	}

	abstract Integer getPrioridad(Pedido pedido) {
		boolean cond1 = this.checkCantPasajeros(pedido);
		boolean cond2 = this.checkMascota(pedido);
		boolean cond3 = this.checkBaul(pedido);
		
		if (cond1 && cond2 && cond3) {
			//realiza el calculo
		}
	}
	
	boolean checkCantPasajeros(Pedido pedido) {
		if (pedido.pasajeros > this.maxPasajeros)
			return false;
		else
			return true;
	}
	
	abstract boolean checkMascota(Pedido pedido);
	
	abstract boolean checkBaul(Pedido pedido);
}
