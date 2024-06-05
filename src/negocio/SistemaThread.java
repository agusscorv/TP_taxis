package negocio;

public class SistemaThread extends Thread{

	private RecursoCompartido recursoCompartido;

    public SistemaThread(RecursoCompartido recursoCompartido) {
        this.recursoCompartido = recursoCompartido;
    }

    @Override
    public void run() {
        while (recursoCompartido.getEstado()) {
            try {
               
                
            } catch (InterruptedException e) {    
            }
        }
    }
	
}
