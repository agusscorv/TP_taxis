package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

					    
public class Empresa { 

	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Chofer> choferes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Viaje> viajes;
	private VehiculoFactory fabrica=new VehiculoFactory();
	private ViajeFactory fabricaViajes=new ViajeFactory();
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

	/**
	 * Metodo que crea y agrega un chofer de Tipo contratado al array de la empresa
	 * 
	 * Pre: dni!=null,dni!="",nombre!=null,nombre!="", cantViajes >=0
	 * Post: Crea un nuevo chofer Contratado y lo agrega al Array de empresa
	 * 
	 * @param dni: documento identificatorio del chofer contratado
	 * @param nombre: nombre del chofer contratado
	 */
	public void agregarContratado(String dni, String nombre) {
		Chofer chofer = new Contratado(dni, nombre);
		choferes.add(chofer);
	}
	
	/**
	 * Metodo que crea y agrega un chofer de Tipo Temporario al array de la empresa
	 * 
	 * Pre: dni!=null, dni!="", nombre!=null, nombre!="", sueldo_basico > 0, cantViajes >=0
	 * Post: Crea un nuevo chofer Temporario y lo agrega al Array de empresa
	 * 
	 * @param dni = documento identificatorio del chofer temporario
	 * @param nombre = nombre del chofer temporario
	 * @param sueldo_basico = sueldo del chofer temporario
	 * @param cantViajes = cantidad de viajes que realizo el chofer temporario
	 */
	public void agregarTemporario(String dni, String nombre, double sueldo_basico, int cantViajes) {
		Chofer chofer = new Temporario(dni, nombre, sueldo_basico, cantViajes);
		choferes.add(chofer);
	}
	
	/**
	 * Metodo que crea y agrega un chofer de Tipo Permanente al array de la empresa
	 * 
	 * Pre: dni!=null, dni!="", nombre!=null, nombre!="", sueldo_basico > 0, cantHijos >= 0, fecha_ingreso valida en el GregorianCalendar
	 * Post: Crea un nuevo chofer Permanente y lo agrega al Array de empresa
	 * 
	 * @param dni: documento identificatorio del chofer permanente
	 * @param nombre: nombre del chofer permanente
	 * @param sueldo_basico: sueldo del chofer permanente
	 * @param cantHijos: cantidad de hijos del chofer permanente
	 * @param fecha_ingreso: fecha de ingreso a la empresa del chofer permanente
	 */
	public void agregarPermanente(String dni, String nombre, double sueldo_basico, int cantHijos, GregorianCalendar fecha_ingreso) {
		Chofer chofer = new Permanente(dni, nombre, sueldo_basico, cantHijos, fecha_ingreso);
		choferes.add(chofer);
	}
	
	public void agregarCliente(String user, String contrasena, String nombre)throws ClienteExistente {
		int x = 0;
		if (buscarElemento(this.clientes, user) != -1) {
			clientes.add(cliente);
		}
		else {
			throw new ClienteExistente();
		}	
	}
	
	public VehiculoFactory getFabrica() {
		return fabrica;
	}

	public void setFabrica(VehiculoFactory fabrica) {
		this.fabrica = fabrica;
	}

	

	

	public static int buscarElemento(ArrayList<Cliente> clientes, String userBuscado) {
		
        for (int i = 0; i < lista.size(); i++) {
            if (clientes.get(i).getUser().equals(userBuscado)) {
                return i;
            }
        }
        return -1;
    }
	
	public void agregarViaje(Viaje viaje) {
		viajes.add(viaje);
	}
	
	
	/**
	 * Procesa el viaje solicitado por un Cliente existente en la lista de clientes (o propaga la excepcion) 
	 * 
	 * Pre: fecha= GregorianCalendar valida; zona != null && !=""; cantPasjeros>0, cliente!=null
	 * Post: propaga una excepcion o solicita un viaje
	 *  
	 * @param fecha: fecha y hora del pedido
	 * @param zona: String con el nombre de la zona
	 * @param mascotas: Boolean que confirma si el cliente lleva mascota
	 * @param baul: Boolean que confirma si el cliente necesitara un baul
	 * @param cantPasajeros: cantidad de pasajeros que viajaran
	 * @param cliente: cliente que hizo el pedido
	 * 
	 */
	
	public void solicitaViaje(GregorianCalendar fecha, String zona, boolean mascotas, boolean baul, int cantPasajeros, Cliente cliente) 
			throws FaltaDeChoferException, FaltaDeVehiculoException, ZonaInexistenteException{
		Pedido pedido= new Pedido(fecha, zona, mascotas, baul, cantPasajeros, cliente);
		Viaje viaje= (Viaje) fabricaViajes.getViaje(pedido);
		viaje.Pagado();
	}
	
	public static void setCostoBaseViaje(float costoBase) {
		Viaje.setCostoBase(costoBase);
	}

	public Vehiculo seleccionaMejorVehiculo(Pedido pedido)throws FaltaDeVehiculoException{
		int mayor = -1;
		int k = 0;
		Vehiculo mejor = null;
		for (int i = 0; i < vehiculos.size(); i++) {
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
				texto = texto + "Viaje de " + viajesClonados.get(i).getCliente().getNombre() + " en el vehiculo de patente " + viajesClonados.get(i).getVehiculo().getPatente()+ "con un costo de: $" + viajesClonados.get(i).getCosto() + "\n";
			}
		}
		return texto;
	}
	
	public String muestraViajesCliente(Cliente cliente) {
		String texto="Viajes de " + cliente.getNombre() + ":\n";
		int bandera = 0;
			
		for(int i = 0; viajes.size() > i ; i++) {
			if( viajes.get(i).getCliente().getUser().equals(cliente.getUser())) {
				texto = texto + "Viaje en vehiculo de patente " + viajes.get(i).getVehiculo().getPatente() + "con un costo de: $" + viajes.get(i).getCosto() + "\n";
			}
		}
		if (bandera == 0)
			return "El cliente ingresado no tiene viajes";
		else
			return texto;
		
	}

	
	private ArrayList<Viaje> clonaYOrdenaViajes(ArrayList<Viaje> viajes2) throws CloneNotSupportedException { //REVISAR TRY Y CATCH
		ArrayList<Viaje> viajesClonados = new ArrayList<>();
		int i;
		int j;
		int indiceSacar = -1;
		Viaje viajeSacar = null;
		
		for ( i = 0; i < viajes2.size(); i++) {
			try {
				viajesClonados.add((Viaje) viajes2.get(i).clone());
			}
			catch (CloneNotSupportedException e){
				
			}
		}
		for (i = 1; i < viajesClonados.size()+1; i++) {
			viajeSacar = viajesClonados.get(0);
			indiceSacar = 0;
			for (j = viajesClonados.size()-i; j >= 0 ; j--) {
				if (viajeSacar.compareTo(viajesClonados.get(j)) == 1 ){
					viajeSacar = viajesClonados.get(j);
					indiceSacar = j;
				}
			}
			viajesClonados.remove(indiceSacar);
			viajesClonados.add(viajeSacar);
		}
		
		return viajesClonados;
	}
	

	//El chofer tiene que estar si o si en la lista, y el enviado como parametro es contratado
	public double CostoViajesMes(Contratado chofer){ //, int mes
		int j = viajes.size()-1;
		int mesAux = viajes.get(j).getFecha().get(2); //Fecha del ultimo viaje realizado, para guardar el ultimo mes
		double SumaCostosViajes = 0; 
		  
		  //Desde la ultima parte de la lista hasta que cambie el mes
		  while (j>=0 && ( mesAux == viajes.get(j).getFecha().get(2) ) )
		  {
			  if ( viajes.get(j).getChofer().getNombre().equals(chofer.getNombre()) )
			    SumaCostosViajes += viajes.get(j).getCosto();
		      j--;
		  }
	
		  return SumaCostosViajes;
	  }
	  
}
