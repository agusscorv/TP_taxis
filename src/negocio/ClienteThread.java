package negocio;

import java.util.GregorianCalendar;

public class ClienteThread extends Thread{
	
	private RecursoCompartido recursoCompartido;
    private Cliente cliente;
    private Pedido pedido;
	
	public ClienteThread(RecursoCompartido recursoCompartido, Cliente cliente, Pedido pedido) {
		super();
		this.recursoCompartido = recursoCompartido;
		this.cliente = cliente;
		this.pedido = pedido;
	}



	public void run() {
		boolean condPedido=false;
		
		while (recursoCompartido.getEstado()) {
			try {
				condPedido = this.recursoCompartido.aceptarPedido(pedido);
				if (condPedido) {
					this.recursoCompartido.solicitarViaje(pedido);
					while (!this.recursoCompartido.getCondicionViaje(pedido).equals("iniciado"))
						wait();
					this.recursoCompartido.pagarViaje(pedido); 
				}
				else {
					this.recursoCompartido.rechazado(); //crear metodo en RC
				}
			}catch (InterruptedException e) {
	            e.printStackTrace();
	        }
				
        } 
    }
}



