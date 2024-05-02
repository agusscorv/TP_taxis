package negocio;

public class Combi extends Vehiculo {

	
	public Combi(String patente) {
		super(patente,10);
	}
	
	public boolean checkMascota(Pedido pedido){
		if (pedido.isMascota())
			return false;
		else
			return true;
	}
	
	public boolean checkBaul(Pedido pedido){
		return true;
	}

	public int calculo(Pedido pedido){
		if (pedido.isBaul())
			return 100+10*pedido.getCantPasajeros();
		else
			return 10*pedido.getCantPasajeros();
	}
}
