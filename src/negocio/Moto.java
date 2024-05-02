package negocio;

public class Moto extends Vehiculo {
    
	
	public Moto(String patente) {
		super(patente,1);
	}
	
	public boolean checkMascota(Pedido pedido){
		if (pedido.isMascota()) 
			return false;
		else
			return true;
	}
	
	public boolean checkBaul(Pedido pedido){
		if (pedido.isBaul())
			return false;
		else
			return true;
	}
	
	public int calculo(Pedido pedido){
		return 1000;
	}

}
