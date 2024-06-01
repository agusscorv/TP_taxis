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
        try {
     
        	while (recursoCompartido.estaActivo()) {
        		recursoCompartido.nuevoPedido(); //si no lo acepta, lanzara una excepcion //debe ejecutar el SolicitaViaje de Empresa
        		recursoCompartido.pagarViaje(pedido.getViaje());
       		}


       		
       
        //hacer un toString para las ventanas para cada excepcionlanzada y qie diga pedido rechazado
            

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



