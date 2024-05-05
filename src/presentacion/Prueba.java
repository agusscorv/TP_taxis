package presentacion;

import java.util.GregorianCalendar;

import negocio.Auto;
import negocio.Cliente;
import negocio.ClienteExistenteException;
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
		
		try {
			
			Empresa empresa = Empresa.obtenerInstancia();
			Cliente cliente1= empresa.agregarCliente("mangat","123123","marcos lascar");
			Cliente cliente2= empresa.agregarCliente("pedro","8783444","mangus mangas");
			Cliente cliente3= empresa.agregarCliente("valen","1612362","loco tony");
			empresa.agregarContratado("123123123", "PEPE Lapa");
			empresa.agregarTemporario("623734783", "Rokcet ccocacola", 220000.2);
			empresa.agregarPermanente("123523747", "marito baracus", 200000.5, 2, new GregorianCalendar(2004,2,13));
			empresa.agregarVehiculo("Moto", "MOT1");
			empresa.agregarVehiculo("Moto", "MOT2");
			empresa.agregarVehiculo("Auto", "AUT1");
			empresa.agregarVehiculo("Auto", "AUT2");
			empresa.agregarVehiculo("Combi", "COMB1");
			empresa.solicitaViaje(5.5, new GregorianCalendar(2024,4,3),"Zona Peligrosa" ,true ,false , 2, cliente1); //zona peligrosa, c/pet, s/baul, 2personas
			empresa.solicitaViaje(7.5, new GregorianCalendar(2024,4,2),"Zona Estandar" ,true ,true , 2, cliente2);//estandar ,c/pet,c/baul,2ppl,7.5 km
			empresa.solicitaViaje(2.5, new GregorianCalendar(2024,3,21),"Calle Tierra" ,false ,false , 1, cliente3);
			empresa.solicitaViaje(3.5, new GregorianCalendar(2024,2,21),"Zona Peligrosa" ,true ,false , 4, cliente1); //zona peligrosa, c/pet, s/baul, 4personas
			
			//System.out.println(empresa.muestraViajesCliente(cliente1));
			//System.out.println(empresa.muestraViajesCliente(cliente2));
			System.out.println(empresa.muestraViajes());
			//System.out.println(empresa.muestraChoferes());
			//System.out.println(empresa.muestraClientes());
			//System.out.println(empresa.muestraVehiculos());
			//System.out.println(empresa.costosTotalesSalarios());
			//System.out.println(empresa.costosTotalesSalarios());
			
		} catch (FaltaDeChoferException | FaltaDeVehiculoException | ZonaInexistenteException e) {
			e.printStackTrace();
			
		} catch (ClienteExistenteException e) {
			e.printStackTrace();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	

	}

}
