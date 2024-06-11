package negocio;

import java.util.ArrayList;

import negocio.Chofer;
import negocio.Viaje;
import negocio.Pedido;
import negocio.Vehiculo;
import negocio.Cliente;

public class ConvertirDTO{
    public static ChoferDTO choferToChoferDTO(Chofer chofer)
    {
     	ChoferDTO respuesta = new ChoferDTO();
	    respuesta.setDni(chofer.getDni());
	    respuesta.setNombre(chofer.getNombre());
	    respuesta.setPuntaje(chofer.getPuntaje());
	    return respuesta;   
    }
    public static Chofer choferDTOtoChofer(ChoferDTO choferDTO)
    {
        Chofer respuesta = new Chofer(choferDTO.getDni(), choferDTO.getNombre());
        respuesta.setPuntaje(choferDTO.getPuntaje());
        return respuesta;
    }
    public static ViajeDTO viajeToViajeDTO(Viaje viaje)
    {
        ViajeDTO respuesta = new ViajeDTO();
        respuesta.setEstado(viaje.getEstado());
        respuesta.setCosto(viaje.getCosto());
        respuesta.setChofer(ConvertirDTO.choferToChoferDTO(viaje.getChofer()));
        respuesta.setPedidoDTO(ConvertirDTO.pedidoToPedidoDTO(viaje.getPedido()));
        respuesta.setVehiculoDTO(ConvertirDTO.vehiculoToVehiculoDTO(viaje.getVehiculo()));
        return respuesta;

    }
    public static Viaje viajeDTOToViaje(ViajeDTO viajeDTO)
    {
        Viaje respuesta = new Viaje(ConvertirDTO.pedidoDTOToPedido(viajeDTO.getPedido()));
        respuesta.setChofer(ConvertirDTO.choferDTOtoChofer(viajeDTO.getChofer()));
        respuesta.setVehiculo(ConvertirDTO.vehiculoDTOToVehiculo(viajeDTO.getVehiculo()));
        return respuesta;
        
    }
    public static PedidoDTO pedidoToPedidoDTO(Pedido pedido){
        PedidoDTO respuesta= new PedidoDTO();
        respuesta.setZona(pedido.getZona());
        respuesta.setBaul(pedido.isBaul());
        respuesta.setMascota(pedido.isMascota());
        respuesta.setPasajeros(pedido.getCantPasajeros());
        respuesta.setDistancia(pedido.getDistancia());
	    respuesta.setFecha(pedido.getFecha());
        respuesta.setCliente(ConvertirDTO.clienteToClienteDTO(pedido.getCliente()));
        return respuesta;
    }
    public static Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO){
        Pedido respuesta = new Pedido(pedidoDTO.getDistancia(),pedidoDTO.getFecha(),pedidoDTO.getZona(),pedidoDTO.isMascota(),PedidoDTO.isBaul,pedidoDTO.getCantPasajeros(),ConvertirDTO.clienteDTOToCliente(pedidoDTO.getCliente()));
        return respuesta;
    }
    public static VehiculoDTO vehiculoToVehiculoDTO(Vehiculo vehiculo){
        VehiculoDTO respuesta = new VehiculoDTO();
        respuesta.setMaxPasajeros(vehiculo.getMaxPasajeros());
        respuesta.setPatente(vehiculo.getPatente());
        return respuesta;
    }
    public static Vehiculo vehiculoDTOToVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo respuesta = new Vehiculo(vehiculoDTO.getPatente(),vehiculoDTO.getMaxPasajeros());
        return respuesta;
    }
    public static ClienteDTO clienteToClienteDTO(Cliente cliente){
        ClienteDTO respuesta = new ClienteDTO();
        respuesta.setNombre(cliente.getNombre());
        respuesta.setUser(cliente.getUser());
        respuesta.setContrasena(cliente.getContrasena());
        return respuesta;
    }
    public static Cliente clienteDTOToCliente(ClienteDTO clienteDTO){
        Cliente respuesta = new Cliente(clienteDTO.getUser(),clienteDTO.getContrasena(),clienteDTO.getNombre());
        return respuesta;
    }
   public static EmpresaDTO empresaToEmpresaDTO(Empresa empresa){
	   EmpresaDTO respuesta = new EmpresaDTO();
	   ArrayList<VehiculoDTO> vehiculosDTO = new ArrayList<VehiculoDTO>();
	   ArrayList<ChoferDTO> choferesDTO = new ArrayList<ChoferDTO>();
	   ArrayList<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
	   ArrayList<ViajeDTO> viajesDTO = new ArrayList<ViajeDTO>();
	   for (int i = 0; i < empresa.getVehiculos().size(); i++)
		    vehiculosDTO.add(ConvertirDTO.vehiculoToVehiculoDTO(empresa.getVehiculos().get(i)));
	   for (int i = 0; i < empresa.getChoferes().size(); i++)
		    choferesDTO.add(ConvertirDTO.choferToChoferDTO(empresa.getChoferes().get(i)));
		for (int i = 0; i < empresa.getClientes().size(); i++)
		    clientesDTO.add(ConvertirDTO.clienteToClienteDTO(empresa.getClientes().get(i)));
		for (int i = 0; i < empresa.getViajes().size(); i++)
		    viajesDTO.add(ConvertirDTO.viajeToViajeDTO(empresa.getViajes().get(i)));
		respuesta.setChoferes(choferesDTO);
		respuesta.setClientes(clientesDTO);
		respuesta.setVehiculos(vehiculosDTO);
		respuesta.setViajes(viajesDTO);
		return respuesta;
   }
   
   public static Empresa empresaDTOToEmpresa(EmpresaDTO empresa){
	   Empresa respuesta = Empresa.obtenerInstancia();
		for (int i = 0; i < empresa.getClientes().size(); i++)
		{
		    respuesta.agregaCliente(ConvertirDTO.clienteDTOToCliente(empresa.getClientes().get(i)));
		    System.out.println(ConvertirDTO.clienteDTOToCliente(empresa.getClientes().get(i)));
		}
		for (int i = 0; i < empresa.getChoferes().size(); i++) {

			respuesta.agregaChofer(ConvertirDTO.choferDTOtoChofer(empresa.getChoferes().get(i)));
		}
		for (int i = 0; i < empresa.getVehiculos().size(); i++) {
		    respuesta.agregaVehiculo(ConvertirDTO.vehiculoDTOToVehiculo(empresa.getVehiculos().get(i)));
		}

		for (int i = 0; i < empresa.getViajes().size(); i++)
		    respuesta.agregaViaje(ConvertirDTO.viajeDTOToViaje(empresa.getViajes().get(i)));

		return respuesta;
	   
   }
 
}
