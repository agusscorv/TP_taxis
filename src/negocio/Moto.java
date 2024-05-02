package negocio;

public class Moto extends Vehiculo {
    
	//private boolean baul=false;
	//private boolean pf=false;
	
	public Moto(String patente) {
		super(patente,1);
	}
	
	public boolean checkMascota(Pedido pedido){
		if (pedido.isMascota()) // o pedido.isMascota == this.pf return true else return false
			return false;
		else
			return true;
	}
	
	abstract boolean checkBaul(Pedido pedido){
		if (pedido.isBaul())
			return false;
		else
			return true;
	}
	
	int calculo(Pedido pedido){
		return 1000;
	}

}
