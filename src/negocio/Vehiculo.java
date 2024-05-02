package negocio;

public abstract class Vehiculo {
	private int maxPasajeros;
	private String patente;
	
	public Vehiculo(String patente,int maxPasajeros){
		this.patente=patente;
		this.maxPasajeros=maxPasajeros;
	}

	public int getPrioridad(Pedido pedido) {
		boolean cond1 = this.checkCantPasajeros(pedido);
		boolean cond2 = checkMascota(pedido);
		boolean cond3 = checkBaul(pedido);
		
		if (cond1 && cond2 && cond3)
			return calculo(pedido);
		else
			return null;
	}
	
	boolean checkCantPasajeros(Pedido pedido) {
		if (pedido.pasajeros > this.maxPasajeros)
			return false;
		else
			return true;
	}
	
	abstract boolean checkMascota(Pedido pedido);
	
	abstract boolean checkBaul(Pedido pedido);
	
	abstract int calculo(Pedido pedido);
}
