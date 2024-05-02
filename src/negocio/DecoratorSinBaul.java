package negocio;

public class DecoratorSinBaul extends DecoratorBaul {

	public DecoratorSinBaul(IViaje aEncapsular) {
		super(aEncapsular);
	}
	
	@Override
	public double getIncPasajeros() {
		return 0;
	}
	@Override
	public double getIncKilometros() {
		return 0;
	}
	
	

}
