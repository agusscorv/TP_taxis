package negocio;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class PersistenciaXML implements IPersistencia{
	    private FileOutputStream fout;
	    private FileInputStream fin;		
	    private XMLEncoder encoder;
	    private XMLDecoder decoder;
		@Override
		public void abrirInput(String nombre) throws IOException {
	        fin = new FileInputStream(nombre);
	        decoder = new XMLDecoder(fin);
			
		}
		@Override
		public void abrirOutput(String nombre) throws IOException {
			   fout = new FileOutputStream(nombre);
		       encoder = new XMLEncoder(fout);
			
		}
		@Override
		public void cerrarOutput() throws IOException {
			this.encoder.close();
			
		}
		@Override
		public void cerrarInput() throws IOException {
			this.decoder.close();
			
		}
		@Override
		public void escribir(Object objeto) throws IOException {
			encoder.writeObject(objeto);
			
		}
		@Override
		public Object leer() throws IOException, ClassNotFoundException {
			Object objeto = null;
			if (decoder != null)
				objeto = (Serializable) decoder.readObject();
			return objeto;
		}
	    
	    
	    
	    
	    
	    
	    
}
