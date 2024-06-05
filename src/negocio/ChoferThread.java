package negocio;

import java.util.ArrayList;

public class ChoferThread extends Thread
{
	private RecursoCompartido recursoCompartido;
	private ArrayList<IViaje> viajes; //<=creo que no hace falta, podriamos hacer que RC informe a todos 
	private Chofer chofer;			  //cunado un chofer toma un vehiculo y la vista se encarga de
									  //mostrarlo o no dependiendo si es o no el chofer
	
	
	
	public ChoferThread(RecursoCompartido recursoCompartido, ArrayList<IViaje> viajes, Chofer chofer)
	{
		super();
		this.recursoCompartido = recursoCompartido;
		this.viajes = viajes;
	}
	
	public void run(){	
			while (recursoCompartido.getEstado()) {
				try {
			    	recursoCompartido.asignarViajeAChofer(chofer);
			    	
			    		//no puede pasar pedido, debe pasar el viaje
			    		recursoCompartido.finalizarViaje(pedido.getViaje());
				}
				catch (InterruptedException e) {
		            e.printStackTrace();
		        }
			}
	}
}
