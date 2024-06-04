package negocio;

import java.util.ArrayList;

public class ChoferThread extends Thread
{
	private RecursoCompartido recursoCompartido;
	private ArrayList<Viaje> viajes;
	private Chofer chofer;
	
	
	public ChoferThread(RecursoCompartido recursoCompartido, ArrayList<Viaje> viajes, Chofer chofer)
	{
		super();
		this.recursoCompartido = recursoCompartido;
		this.viajes = viajes;
	}
	
	public void run()
	{
		try
		{
			while (recursoCompartido.estaActivo()) {
			    recursoCompartido.asignarViajeAChofer(chofer);
        		recursoCompartido.iniciarViaje(pedido.getViaje());
        		//Pasa algo..
        		recursoCompartido.finalizarViaje(pedido.getViaje());
			}
		}
		catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
