package negocio;

import java.util.ArrayList;

public class Simulacion {

	Empresa empresa = Empresa.obtenerInstancia();
	private RecursoCompartido recursoCompartido;
	private ClienteThread cliente1;
	private ClienteThread cliente2;
	private ClienteThread cliente3;
	ArrayList<Vehiculo> vehiculosCopia = empresa.copiarVehiculos();
	
	//crear que genere de forma aleatoria los parametros importantes de cada cliente
}
