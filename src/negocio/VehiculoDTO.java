package negocio;

public  class VehiculoDTO {
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
  
