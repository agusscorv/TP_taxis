package negocio;

public class Combi extends Vehiculo {

	
	//private boolean baul=true;
	//private boolean pf=false;
	
	public Combi(String patente) {
		super(patente,10);
	}
	
	abstract boolean checkMascota(Pedido pedido){
		if (pedido.isMascota())
			return false;
		else
			return true;
	}
	
	abstract boolean checkBaul(Pedido pedido){
		return true;
	}

	int calculo(Pedido pedido){
		if (pedido.isBaul())
			return 100+10*pedido.getCantPasajeros();
		else
			return 10*pedido.getCantPasajeros();
	}
}
