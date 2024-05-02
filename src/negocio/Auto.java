package negocio;

public class Auto extends Vehiculo {

	public Auto(String patente) {
		super(patente,4);
	}

	
	public boolean checkMascota(Pedido pedido){
		return true;
	}
	
	public boolean checkBaul(Pedido pedido) {
		return true;
	}
	
	public int calculo(Pedido pedido){
		if (pedido.isBaul())
			return 40*pedido.getCantPasajeros();
		else
			return 30*pedido.getCantPasajeros();
	}
}
