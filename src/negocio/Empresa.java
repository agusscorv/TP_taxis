package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

					  
public class Empresa { 

	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Chofer> choferes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Viaje> viajes;
	private VehiculoFactory fabrica=new VehiculoFactory();
	public static GregorianCalendar hoy = new GregorianCalendar();
	
	public Empresa() {
		this.vehiculos = new ArrayList<>();
		this.choferes = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}

	
	public void agregarVehiculo(String tipo, String patente) {
		
		try{
		Vehiculo vehiculo = fabrica.getVehiculo(tipo, patente);
		vehiculos.add(vehiculo);
		}
		catch (TipoVehiculoInexistenteException ex){
			System.out.println("El tipo de vehiculo no fue encontrado");
		}
	}

	
	
	public VehiculoFactory getFabrica() {
		return fabrica;
	}

	public void setFabrica(VehiculoFactory fabrica) {
		this.fabrica = fabrica;
	}

	public void agregarChofer(Chofer chofer) {
		choferes.add(chofer);
	}

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void agregarViaje(Viaje viaje) {
		viajes.add(viaje);
	}
	
	public void solicitaViaje(long fecha, int hora, String zona, boolean mascotas, boolean baul, int cantPasajeros, Cliente cliente) {
		Pedido pedido= new Pedido(fecha, hora, zona, mascotas, baul, cantPasajeros, cliente);
		
		try {
			//Viaje viaje= ViajeFactory.getViaje();
		}
		catch (FaltaDeChoferException ex){
			System.out.println("No hay choferes disponibles.");
		}
		catch (FaltaDeVehiculoException ex){
			System.out.println("No hay vehiculos disponibles.");
		}
		catch (ZonaInexistenteException ex){
			System.out.println("Zona incorrecta ingresada.");
		}
	}
	
	public static void setCostoBaseViaje(float costoBase) {
		Viaje.setCostoBase(costoBase);
	}

	public Vehiculo seleccionaMejorVehiculo(Pedido pedido)throws FaltaDeVehiculoException{
		int mayor = -1;
		int k = 0;
		Vehiculo mejor = null;
		for (int i = 1; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPrioridad(pedido) > mayor) {
                mayor = vehiculos.get(i).getPrioridad(pedido);
                mejor = vehiculos.get(i);
                k=i;
            }
        }
		if(mejor != null) {
			vehiculos.remove(k);	//pone el "mejor" al final 
			vehiculos.add(mejor);
		}
		else
			throw new FaltaDeVehiculoException();
		return mejor;
	}

	public Chofer seleccionaChofer(Pedido pedido) {
		Chofer chofer = choferes.get(0);
		choferes.remove(0);
		choferes.add(chofer);
		return chofer;
	}

	public String muestraClientes() {
		String texto="";
		
		if(clientes.size() == 0) {
			texto = "No hay clientes";
		}
		else {
			for(int i = 0; i < clientes.size() ; i++) {
				texto = texto + clientes.get(i).getNombre() + "\n";
			}
		}
		return texto;
	}
	
	public String muestraChoferes() {
		String texto="";
		
		if(choferes.size() == 0) {
			texto = "No hay choferes";
		}
		else {
			for(int i = 0; choferes.size()>i ; i++) {
				texto = texto + choferes.get(i).getNombre() + "\n";
			}
		}
		return texto;
	}
	
	public String muestraVehiculos() {
		String texto="";
		
		if(vehiculos.size() == 0) {
			texto = "No hay vehiculos";
		}
		else {
			for(int i = 0; vehiculos.size()>i ; i++) {
				texto = texto + vehiculos.get(i).getPatente()+ "\n";
			}
		}
		return texto;
	}
	
	public String muestraViajes() throws noClono{  //Consultar que les parece esa informacion de viaje
		String texto="";
		
		if(viajes.size() == 0) {
			texto = "No hay viajes";
		}
		else {
			ArrayList<Viaje> viajesClonados = new ArrayList<>(); 
			viajesClonados = this.clonaYOrdenaViajes(viajes);
			for(int i = 0; viajesClonados.size()>i ; i++) {
				texto = texto + "Viaje de " + viajesClonados.get(i).getCliente().getNombre() + " en el vehiculo de patente " + viajesClonados.get(i).getVehiculo().getPatente() + "\n";
			}
		}
		return texto;
	}
	
	
	
	private ArrayList<Viaje> clonaYOrdenaViajes(ArrayList<Viaje> viajes2) throws noClono { //REVISAR TRY Y CATCH
		ArrayList<Viaje> viajesClonados = new ArrayList<>();
		int i;
		int j;
		int indiceSacar = -1;
		Viaje viajeAgregar = null;
		
		for ( i = 0; i < viajes2.size(); i++) {
			try {
				viajesClonados.add((Viaje) viajes2.get(i).clone());
			}
			catch (CloneNotSupportedException e){
				throw new noClono();
			}
		}
		for (i = 0; i < viajes2.size(); i++) {
			viajeAgregar = viajes2.get(i);
			indiceSacar = i;
			for (j = i; j < viajes2.size(); j++) {
				if (viajes2.get(i).compareTo(viajes2.get(j)) == 0){
					viajeAgregar = viajes2.get(j);
					indiceSacar = j;
				}
			}
			viajes2.remove(indiceSacar);
			viajes2.add(viajeAgregar);
		}
		
		// Primero clona elemento a elemento y despues con un compare to y dos for los va ordenando 
		
		return viajesClonados;
	}


	
	public double CostoViajesMes(String NombreChofer){ //, int mes
	  int i = 0;
	  while ( ( i < choferes.size() ) && ( choferes.get(i).getNombre().compareTo(NombreChofer) ) )
         i++;
	  if (i == choferes.size())
		  //Lanzo excepcion no existe chofer //O no hace falta por que getsueldo ya es parte de un chofer, en ese caso nos ahorramos el primer while
	  else
	  {
		  int j =  0;
		  double SumaCostosViajes = 0; 
		  
		  //Falta desarrollar la operacion con el mes indicado, el mes seria parametro enviado desde el main?
		  while ( ( j < viajes.size() ) &&  UnNumeroDeMes == viajes.get(i).getFecha() ) 
			  SumaCostosViajes += viajes.get(i).getCosto();
		  
		  return SumaCostosViajes;
	  }
	  
	}
}
