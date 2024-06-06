package negocio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener{
  private InterfazVista vista;
  private Empresa modelo;
  
  public Controlador(InterfazVista vista, Empresa modelo) {
	super();
	this.vista = vista;
	this.modelo = modelo;
  }
  
  public void ActionPerformed(ActionEvent evento){
  }
  
  public void NotificaNuevoCliente(String user, String contrasena, String nombre){
	  try {
	    modelo.agregarCliente(user, contrasena, nombre);
	  }
	  catch (ClienteExistenteException e) {
		  JCONTROLPANE(MENSAJE)
	  }
  }
  
  public void NotificaSolicitarViaje(Pedido pedido){
     try {
    	 modelo.solicitaViaje(pedido);
     }
     catch(FaltaDeChoferException e) {
    	 
     }
     catch(FaltaDeVehiculoException e) {
    	 
     }
     
     catch(ZonaInexistenteException e){
     }
  
  }
  
  public void NotificaPagarViaje(Pedido pedido) { //no tiene excepciones?
	  modelo.pagarViaje(pedido);
  }
  
	
}
