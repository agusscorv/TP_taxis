package negocio;

public class SingletonEmpresa {

	private static Empresa instancia = null;
	
	private SingletonEmpresa() {
		//que
	}
		
	public static Empresa obtenerInstancia() {

        if (instancia == null) {
            instancia = new Empresa();
        }

        return instancia;
    }
}
