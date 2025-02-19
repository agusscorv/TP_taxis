package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

					    
public class Empresa { 

	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Chofer> choferes;
	private ArrayList<Cliente> clientes;
	private ArrayList<IViaje> viajes;
	private VehiculoFactory fabrica=new VehiculoFactory();
	private ViajeFactory fabricaViajes=new ViajeFactory();
	public GregorianCalendar hoy = new GregorianCalendar();
	private static Empresa instancia = null;
	IPersistencia persistencia = new PersistenciaXML();
	
	public Empresa() {
		this.vehiculos = new ArrayList<>();
		this.choferes = new ArrayList<>();
		this.clientes = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}
	 public void lecturaArchivo() throws IOException, ClassNotFoundException{
	        persistencia.abrirInput("info.xml");
        	EmpresaDTO empresa = (EmpresaDTO) persistencia.leer();
        	ConvertirDTO.empresaDTOToEmpresa(empresa);
        	persistencia.cerrarInput();
    
	}
	public void escrituraArchivo(){
    		try {
      		  persistencia.abrirOutput("info.xml");
      		  EmpresaDTO empresa = ConvertirDTO.empresaToEmpresaDTO(Empresa.obtenerInstancia());
      		  persistencia.escribir(empresa);
       		   persistencia.cerrarOutput();
    		} catch (IOException e) {        
       			 e.printStackTrace();
  		  }
	
	
	//NUEVO
	public ArrayList<Vehiculo> copiarVehiculos() {
        ArrayList<Vehiculo> vehiculosCopia = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++) {
            vehiculosCopia.add(vehiculos.get(i));
        }
        return vehiculosCopia;
    }
	
	/**
	 * Ingresa el vehiculo al sistema y luego lo agrega al ArrayList.
	 * pre: tipo!= null and tipo!="", patente!= null and  patente!=""
	 * @param tipo: tipo de vehiculo a ser creado
	 * @param patente: del vehiculo a ser creado
	 * 
	 * post: catchea una excepcion o crea el vehiculo
	 */
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
	public Contratado agregarContratado(String dni, String nombre) {
		Contratado chofer = new Contratado(dni, nombre);
		choferes.add(chofer);
		return chofer;
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
	 */
	public Temporario agregarTemporario(String dni, String nombre, double sueldo_basico) {
		Temporario chofer = new Temporario(dni, nombre, sueldo_basico);
		choferes.add(chofer);
		return chofer;
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
	 * 
	 */
	public Permanente agregarPermanente(String dni, String nombre, double sueldo_basico, int cantHijos, GregorianCalendar fecha_ingreso) {
		Permanente chofer = new Permanente(dni, nombre, sueldo_basico, cantHijos, fecha_ingreso);
		choferes.add(chofer);
		return chofer;
	}
	
	/**
	 * Agrega el cliente siempre que el mismo no exista, puede lanzar Excepcion
	 * pre: user!= null and  user!="", contrasena!= null and  contrasena!="", nombre!= null and  nombre!=""
	 * 
	 * @param user: username del cliente
	 * @param contrasena: contrasena del usuario
	 * @param nombre: nombre del cliente
	 * 
	 * post:agrega el cliente o lanza una excepcion
	 * 
	 * @throws ClienteExistenteException en el caso que el usuarioya se encuentre en el ArrayList
	 */
	public Cliente agregarCliente(String user, String contrasena, String nombre) throws ClienteExistenteException {
		if (buscarElemento(this.clientes, user) == -1) {
			Cliente cliente = new Cliente(user, contrasena, nombre);
			clientes.add(cliente);
			return cliente;   //HACE FALTA QUE RETORNE CLIENTE?, HABRIA QUE HACERLO VOID
		}
		else {
			throw new ClienteExistenteException(); //NOTIFICAR A LA VISTA QUE YA EXISTE EL CLIENTE, NUEVO BOTON
		}	
	}
	
	public VehiculoFactory getFabrica() {
		return fabrica;
	}

	public void setFabrica(VehiculoFactory fabrica) {
		this.fabrica = fabrica;
	}

	/**
	 * Metodo para buscar un cliente en el ArrayList a través del usuario
	 * pre: clientes!= null, userBuscado!= null and  userBuscado!=""
	 * 
	 * @param clientes: lista en la cual se va a buscar a un determinado usuario
	 * @param userBuscado: user a ser buscado en la lista
	 * 
	 * post:
	 * @return devuelve la posicion en el arraylist o -1 si no lo encontro
	 */
	public static int buscarElemento(ArrayList<Cliente> clientes, String userBuscado) {
		
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUser().equals(userBuscado)) {
                return i;
            }
        }
        return -1;
    }
	
	/**
	 * Procesa el viaje solicitado por un Cliente existente en la lista de clientes (o propaga la excepcion)
	 *  
	 * Pre: fecha= GregorianCalendar valida; zona != null and !=""; cantPasjeros>0, cliente!=null
	 * Post: propaga una excepcion o solicita un viaje y lo agrega a la lista de viajes
	 *  
	 * @param fecha: fecha y hora del pedido
	 * @param zona: String con el nombre de la zona
	 * @param mascotas: Boolean que confirma si el cliente lleva mascota
	 * @param baul: Boolean que confirma si el cliente necesitara un baul
	 * @param cantPasajeros: cantidad de pasajeros que viajaran
	 * @param cliente: cliente que hizo el pedido
	 */
	
	//modificado para la segunda parte
	
	public IViaje solicitaViaje(Pedido pedido) throws FaltaDeChoferException, FaltaDeVehiculoException, ZonaInexistenteException{
		IViaje viaje= (IViaje) fabricaViajes.getViaje(pedido);
		viajes.add(viaje);
		return viaje;
	}
	
	public void pagarViaje(Pedido pedido) {
		int indiceDelViaje=0;
		for (int i = 0; i < viajes.size(); i++) {
			if (viajes.get(i).getCliente().equals(pedido.getUserCliente()) && viajes.get(i).getEstado().equals("iniciado")) {
				indiceDelViaje=i;
			}
		}
		viajes.get(indiceDelViaje).setCondicion("pagado"); //actualiza arraylist del RC
		this.setCondicion(indiceDelViaje,"pagado");//actualiza arraylist de Empresa
	}
	
	public static void setCostoBaseViaje(float costoBase) {
		Viaje.setCostoBase(costoBase);
	}

	/**
	 * Elige el vehiculo adecuado para el Pedido reciente, ademas pone el vehiculo al final del Arraylist. Puede lanzar Excepcion
	 * pre: pedido!=null
	 * 
	 * @param pedido para el cual se va a buscar el mejor vehiculo
	 * 
	 * post:
	 * @return el mejor auto para el pedido
	 * @throws FaltaDeVehiculoException en el caso que no haya vehiculos disponibles
	 */
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
			vehiculos.get(k).setOcupado(true); //nueva linea
			vehiculos.add(mejor);
		}
		else
			throw new FaltaDeVehiculoException();
		return mejor;
	}
	
	/**
	 * Toma el primer chofer disponible y lo vuelve a poner al fondo de la lista
	 * pre: pedido!= null
	 * 
	 * @param pedido: pedido para el cual se seleccionara su chofer
	 * 
	 * post:
	 * @return el mejor chofer
	 */

	public Chofer seleccionaChofer(Pedido pedido) {
		Chofer chofer = choferes.get(0);
		choferes.remove(0);
		choferes.add(chofer);
		return chofer;
	}
	
	/**
	 * Concatena en un String el listado de clientes
	 * @return el string en cuestion
	 */

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
	
	/**
	 * Concatena en un String el listado de choferes
	 * @return devuelve el string
	 */
	
	public String muestraChoferes() {
		String texto="";
		
		if(choferes.size() == 0) {
			texto = "No hay choferes";
		}
		else {
			for(int i = 0; choferes.size()>i ; i++) {
				texto = texto + choferes.get(i).getNombre() +", Tiene un sueldo de: $"+ choferes.get(i).getSueldo() + ", Puntaje del mes solicitado: "+ choferes.get(i).getPuntaje() + "\n";
			}
		}
		return texto;
	}
	
	/**
	 * Concatena en un String el listado de vehiculos 
	 * @return el string texto
	 */
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
	
	/**
	 * Verifica que viajes no sea nulo, clona el arraylist y lo recorre formando un String para posteriormente mostrar por pantalla, previamente llama a orto metodo
	 * @return un string
	 * @throws CloneNotSupportedException si no se pudo clonar
	 */
	
	public String muestraViajes() throws CloneNotSupportedException{  //Consultar que les parece esa informacion de viaje
		String texto="";
		
		if(viajes.size() == 0) {
			texto = "No hay viajes";
		}
		else {
			ArrayList<IViaje> viajesClonados = new ArrayList<>(); 
			viajesClonados = this.clonaYOrdenaViajes(viajes);
			for(int i = 0; viajesClonados.size()>i ; i++) {
				texto = texto + "Viaje de " + viajesClonados.get(i).getCliente().getNombre() + " en el vehiculo de patente " + viajesClonados.get(i).getVehiculo().getPatente()+ "con un costo de: $" + viajesClonados.get(i).getCosto() + "\n";
			}
		}
		return texto;
	}
	
	/**
	 * Devuelve un string con los viajes de un cliente en particular
	 * @param cliente distinto de null;
	 * @return string 
	 */
	
	public String muestraViajesCliente(Cliente cliente) {
		String texto="Viajes de " + cliente.getNombre() + ":\n";
		int bandera = 0;
			
		for(int i = 0; viajes.size() > i ; i++) {
			if( viajes.get(i).getCliente().getUser().equals(cliente.getUser())) {
				texto = texto + "Viaje en vehiculo de patente " + viajes.get(i).getVehiculo().getPatente() + "con un costo de: $" + viajes.get(i).getCosto() + "\n";
				bandera=1;
			}
		}
		if (bandera == 0)
			return "El cliente ingresado no tiene viajes";
		else
			return texto;
		
	}
	
	/**
	 * clona el arraylist de viajes y los ordena segun el costo de cada uno
	 * 
	 * Pre: viajes2!=null
	 * @param viajes2 lista de los clientes a ser clonados y ordenados
	 * 
	 * Post:
	 * @return un arraylist de viajes ordenados
	 * @throws CloneNotSupportedException si no se pudo clonar
	 */
	
	private ArrayList<IViaje> clonaYOrdenaViajes(ArrayList<IViaje> viajes2) throws CloneNotSupportedException {
		ArrayList<IViaje> viajesClonados = new ArrayList<>();
		int i;
		int j;
		int indiceSacar = -1;
		IViaje viajeSacar = null;
		
		for ( i = 0; i < viajes2.size(); i++) {
			try {
				viajesClonados.add((IViaje) viajes2.get(i).clone());
			}
			catch (CloneNotSupportedException e){
				
			}
		}
		for (i = 1; i < viajesClonados.size()+1; i++) {
			viajeSacar = viajesClonados.get(0);
			indiceSacar = 0;
			for (j = viajesClonados.size()-i; j >= 0 ; j--) {
				if ( viajeSacar.getCosto() < viajesClonados.get(j).getCosto() ){
					viajeSacar = viajesClonados.get(j);
					indiceSacar = j;
				}
			}
			viajesClonados.remove(indiceSacar);
			viajesClonados.add(viajeSacar);
		}
		
		return viajesClonados;
	}

	/**
	 * Calcula el costo total de salarios de la empresa
	 * @return costo de los servicios
	 */
	public double costosTotalesSalarios() {
		double acum = 0;
		if(choferes.size() != 0) {
			for(int i = 0; choferes.size()>i ; i++) {
				System.out.println( choferes.get(i).getNombre()+ "   $" + choferes.get(i).getSueldo());
				acum += choferes.get(i).getSueldo();
			}
		}
		return acum;
	}
	

	/**
	 * Este metodo se usa para calcular cuanto generaron los viajes que realizo un chofer en el mes actual
	 * 
	 * Pre: chofer!= null, chofer Contratado contenido en el Array
	 * Post: devuelve la cantidad de dinero generados por los viajes que realizo el chofer Contratado que se recibe por parametro, en el mes actual
	 * 
	 * @param chofer: chofer al cual se le va a calcular la cantidad de viajes en el mes actual
	 */
	public double costoViajesMes(Contratado chofer){ //, int mes
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
	
	/**
	 * Este metodo se usa para calcular cuantos viajes realizo un chofer en el mes actual
	 * 
	 * Pre: chofer!= null, chofer Temporario contenido en el Array
	 * Post: devuelve la cantidad de viajes que realizo el chofer Temporario que se recibe por parametro, en el mes actual
	 * 
	 * @param chofer: chofer al cual se le va a calcular la cantidad de viajes en el mes actual
	 */
	public int CantViajesMes(Temporario chofer){ //, int mes
		int j = viajes.size()-1;
		int mesAux = viajes.get(j).getFecha().get(2); //Fecha del ultimo viaje realizado, para guardar el mes actual
		int CantViajesMes = 0; 
		  
		  //Desde la ultima parte de la lista hasta que cambie el mes
		  while (j>=0 && ( mesAux == viajes.get(j).getFecha().get(2) ) )
		  {
			  if ( viajes.get(j).getChofer().getNombre().equals(chofer.getNombre()) )
			     CantViajesMes++;
		      j--;
		  }
	
		  return CantViajesMes;
	  }
	
	/** Calcula el puntaje de cada chofer para un mes especifico dado en base a los viajes realizados por los choferes y su distancia recorrida
	 * pre: mes mayor o igual 1, mes menor o igual 12
	 * post: actualiza el puntaje del mes especifico dado de cada chofer
	 * @param mes donde se calcula el puntaje
	 */
	public String puntajeChoferes(int mes)
	{
		int i,j;
		Chofer choferMax=null;
		double distanciaMax=0;
		for (i = 0; i < choferes.size();i++){
			j=0;
			choferes.get(i).setPuntaje(0);
		    while (j<viajes.size()   &&   mes >= viajes.get(j).getFecha().get(2)) {
			   if ( ( mes == viajes.get(j).getFecha().get(2) )) { //Si el mes es el buscado
				   if ( viajes.get(j).getChofer() == choferes.get(i) ){ //El chofer tuvo un viaje en ese mes
				      choferes.get(i).addPuntaje(5);
			          if (viajes.get(j).getDistancia() > distanciaMax){
				        distanciaMax=viajes.get(j).getDistancia();
				        choferMax = viajes.get(j).getChofer();
			          }
			       }

		      }
			   j++;
		    }
		}
		if (choferMax!=null) {
			choferMax.addPuntaje(15);
			return muestraChoferes();
		}else
			return "No hay choferes que hayan hecho entregas ese mes";
	}
	
	/**
	 * Arma el listado de viajes de un chofer en un determinado periodo de tiempo
	 * 
	 * pre: chofer!=null and chofer pertenece al arraylist (siempre cumple), fechaInicio!=null, fechaFinal!= null, fechaFinal mayor a fechaInicio
	 * @param chofer: chofer para el cual evaluar sus viajes
	 * @param fechaInicio: fecha inicial para la cual buscar si un chofer hizo un viaje 
	 * @param fechaFinal: fecha final para la cual buscar si un chofer hizo un viaje
	 *
	 * post:
	 * @return un String con el listado para poder imprimir por pantalla
	 */
	public String viajesChoferPeriodo(Chofer chofer, GregorianCalendar fechaInicio, GregorianCalendar fechaFinal) {
		String texto = "Viajes de " + chofer.getNombre() + ", desde: " + fechaInicio.getTime() + ", hasta: " + fechaFinal.getTime() + "\n";
		
		for (int i = 0; i < viajes.size(); i++) {
            if (viajes.get(i).getFecha().compareTo(fechaInicio) >= 0 && viajes.get(i).getFecha().compareTo(fechaFinal) <= 0 &&
                    viajes.get(i).getChofer().getDni().equals(chofer.getDni())) {
                texto += "Llevó a " + viajes.get(i).getCliente().getNombre() + " durante " + viajes.get(i).getDistancia() + " km\n";
            }
        }
		return texto;
	}
	
	/**
	 * Arma el listado de viajes de un cliente en un determinado periodo de tiempo
	 * 
	 * Pre: cliente!=null and cliente pertenece al arraylist (siempre cumple), fechaInicio!=null, fechaFinal!= null, fechaFinal mayor a fechaInicio
	 * 
	 * @param cliente: cliente para el cual se evaluan sus viajes
	 * @param fechaInicio: fecha inicial para la cual buscar si un chofer hizo un viaje 
	 * @param fechaFinal: fecha final para la cual buscar si un chofer hizo un viaje
	 * 
	 * post:
	 * @return un String con el listado para poder imprimir por pantalla
	 */
	public String viajesClientePeriodo(Cliente cliente, GregorianCalendar fechaInicio, GregorianCalendar fechaFinal) {
		String texto = "Viajes de " + cliente.getUser() + ", desde: " + fechaInicio.getTime() + ", hasta: " + fechaFinal.getTime() + "\n";

		for (int i = 0; i < viajes.size(); i++) {

            if (viajes.get(i).getFecha().compareTo(fechaInicio) >= 0 && viajes.get(i).getFecha().compareTo(fechaFinal) <= 0 &&
                    viajes.get(i).getCliente().getUser().equals(cliente.getUser())) {
                texto += "Viajó durante " + viajes.get(i).getDistancia() + " km\n";
            }
        }
		return texto;
	}
	
	
	
	
	/**
	 * Devuelve el listado de choferes junto al salario de cada uno
	 * @return texto
	 */
	
	public String salariosCadaChofer() {
		String texto = "Sueldos de cada chofer:\n";
		
		for(int i = 0; i < choferes.size(); i++) {
			texto = choferes.get(i).nombre + " gana: $" + choferes.get(i).getSueldo();
		}
		
		return texto;
	}
	
	/**
	 * Permite el cambio del nombre de chofer
	 * 
	 * Pre: documento!= null and documento!="", nombreNuevo!= null and nombreNuevo!=""
	 * 
	 * @param documento: dni del chofer a cambiar el nombre
	 * @param nombreNuevo: nuevo nombre del chofer
	 * 
	 * Post: El nombre del chofer cambia
	 */
	
	public void cambioNombreChofer(String documento,String nombreNuevo) {
		for(int i = 0; choferes.size()>i ; i++) {
			if(choferes.get(i).getDni().equals(documento)) {
				choferes.get(i).setNombre(nombreNuevo);
			}
		}
	}
	
	/**
	 * Cambia documento de chofer
	 * 
	 * Pre: documento!= null and documento!="", docNuevo!= null and docNuevo!=""
	 * 
	 * @param documento: documento actual del chofer
	 * @param docNuevo: nuevo documento del chofer
	 * post: cambio de dni
	 */
	
	public void cambioDocumentoChofer(String documento,String docNuevo) {
		for(int i = 0; choferes.size()>i ; i++) {
			if(choferes.get(i).getDni().equals(documento)) {
				choferes.get(i).setNombre(docNuevo);
			}
		}
	}
	
	/**
	 * Cambia contrasena de un usuario
	 * pre: user distinto de "" y null, contraNueva distitno de "" y null
	 * 
	 * @param user: username a cambiarle su contrasena
	 * @param contraNueva: nueva contrasena
	 * 
	 * post: cambio de contrasena
	 */
	public void cambioContrasena(String user, String contraNueva) {
		for(int i = 0; clientes.size()>i ; i++) {
			if(clientes.get(i).getUser().equals(user)) {
				clientes.get(i).setContrasena(contraNueva);
			}
		}
	}
	
	/**
	 * Cambia nombre de un usuario
	 * pre: user distinto de "" y null, nombreNuevo distitno de "" y null
	 * @param user: usuario a cambiarle el nombre
	 * @param nombreNuevo: nombre nuevo del usuario en cuestion
	 * post: cambia el nombre
	 */
	public void cambioNombre(String user, String nombreNuevo) {
		for(int i = 0; clientes.size()>i ; i++) {
			if(clientes.get(i).getUser().equals(user)) {
				clientes.get(i).setNombre(nombreNuevo);
			}
		}
	}
	/**
	 * Cambia el nombre de usuario de un cliente
	 * pre: user distinto de "" y null, userNuevo distitno de "" y null
	 * 
	 * @param user: user a ser cambiado
	 * @param userNuevo: nuevo user
	 * 
	 * post cambia el usuario
	 */
	public void cambioUser(String user, String userNuevo) {
		for(int i = 0; clientes.size()>i ; i++) {
			if(clientes.get(i).getUser().equals(user)) {
				clientes.get(i).setNombre(userNuevo);
			}
		}
	}
	
	public static Empresa obtenerInstancia() {

        if (instancia == null) {
            instancia = new Empresa();
        }

        return instancia;
    }


	//NUEVO
	public void setCondicion(int indiceDelViaje, String condicion) {
		viajes.get(indiceDelViaje).setCondicion(condicion);
	}
	
}
