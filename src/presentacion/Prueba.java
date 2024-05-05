package presentacion;

import java.util.GregorianCalendar;

import negocio.Auto;
import negocio.Cliente;
import negocio.Contratado;
import negocio.Chofer;
import negocio.Empresa;
import negocio.Vehiculo;
import negocio.Viaje;
import negocio.ViajeFactory;
import negocio.FaltaDeChoferException;
import negocio.FaltaDeVehiculoException;
import negocio.IViaje;
import negocio.Moto;
import negocio.Pedido;
import negocio.Permanente;
import negocio.Temporario;
import negocio.ZonaInexistenteException;

public class Prueba {
	//private Empresa empresa = Empresa.getInstance(); //pq va a ser singleton
	
	public static void main(String[] args) {
		//Vehiculo motito= new Moto("MOT123");
		//Vehiculo autito= new Auto("AUT321");
		Empresa empresa = new Empresa();
		Cliente cliente = new Cliente(null, null, null);
		ViajeFactory fabricaViajes=new ViajeFactory();
		
		Pedido pedido = new Pedido(new GregorianCalendar(2024,4,3),"Zona Peligrosa" ,true ,false , 2, cliente);
		Pedido pedido2 = new Pedido(new GregorianCalendar(2024,4,2),"Zona Estandar" ,true ,true , 3, cliente);
		Pedido pedido3 = new Pedido(new GregorianCalendar(2024,3,21),"Calle Tierra" ,false ,false , 1, cliente);
		Pedido pedido4 = new Pedido(new GregorianCalendar(2024,2,21),"Zona Peligrosa" ,true ,false , 4, cliente);
		Chofer chofer1= new Contratado("123123123", "PEPE Lapa");
		
		try {
			IViaje viaje= fabricaViajes.getViaje(pedido, chofer1);
			IViaje viaje2= fabricaViajes.getViaje(pedido2, chofer1);
			IViaje viaje3= fabricaViajes.getViaje(pedido3, chofer1);
			IViaje viaje4= fabricaViajes.getViaje(pedido4, chofer1);
		} catch (FaltaDeChoferException | FaltaDeVehiculoException | ZonaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println(motito.getPrioridad(pedido));
		//System.out.println(autito.getPrioridad(pedido));
		
		empresa.agregarVehiculo("Moto", "MOT123");
		empresa.agregarVehiculo("Auto", "AUT321");
		
		
		empresa.agregarChofer(chofer1);
		
		try {
			//empresa.solicitaViaje(new GregorianCalendar(2024,4,3),"Zona Peligrosa" ,true ,false , 2, cliente);
			//empresa.solicitaViaje(new GregorianCalendar(2024,4,2),"Zona Estandar" ,true ,true , 3, cliente);
			//empresa.solicitaViaje(new GregorianCalendar(2024,3,21),"Calle Tierra" ,false ,false , 1, cliente);
			//empresa.solicitaViaje(new GregorianCalendar(2024,2,21),"Zona Peligrosa" ,true ,false , 4, cliente);
			
			Vehiculo vehiculo = empresa.seleccionaMejorVehiculo(pedido);
			System.out.println(chofer1.getSueldo());
			//System.out.println(vehiculo.getPatente());
		}
		//catch (FaltaDeChoferException ex){
		//	System.out.println("No hay choferes disponibles.");
		//}
		catch (FaltaDeVehiculoException ex){
			System.out.println("No hay vehiculos disponibles.");
		}
		//catch (ZonaInexistenteException ex){
		//	System.out.println("Zona incorrecta ingresada.");
		//}
		 
		
		

	}

}
