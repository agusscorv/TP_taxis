package negocio;

public interface IViaje {
	
	public int getCantPasajeros(Pedido pedido);
	
	public int getKilometros(Pedido pedido);
	
	public int getIncPorPasajero(Pedido pedido);
	
	public int getIncPorKilometros(Pedido pedido);
	
	public int getCosto(Pedido pedido);
}
