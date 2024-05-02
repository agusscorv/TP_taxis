package negocio;

public class Auto extends Vehiculo {

	
	//private boolean baul=true;
	//private boolean pf=true;
	
	public Auto(String patente) {
		super(patente,4);
	}

	
	abstract boolean checkMascota(Pedido pedido){
		return true;
	}
	
	abstract boolean checkBaul(Pedido pedido) {
		return true;
	}
	
	int calculo(Pedido pedido){
		if (pedido.isBaul())
			return 40*pedido.getCantPasajeros();
		else
			return 30*pedido.getCantPasajeros();
	}
}
