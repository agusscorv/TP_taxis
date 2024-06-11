package negocio;

import java.io.Serializable;

public  class VehiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int maxPasajeros;
	private String patente;
	private boolean ocupado; 
	
	
	public VehiculoDTO(){
      // TODO Auto-generated constructor stub
	}

  public String getPatente() {
  		return patente;
	}

	public void setPatente(String patente) {
  		this.patente = patente;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

  public void setMaxPasajeros(int maxPasajeros){
    this.maxPasajeros = maxPasajeros;
  }

  public int getMaxPasajeros(){
    return maxPasajeros;
  }

}

