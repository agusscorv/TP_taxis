package negocio;

public class SingletonEmpresa {

	private static Empresa instancia = null;
	
	private SingletonEmpresa() {
		//que iria aca adentro en este caso??
	}
		
	public static Empresa obtenerInstancia() {

        if (instancia == null) {
            instancia = new Empresa();
        }

        return instancia;
    }
}
