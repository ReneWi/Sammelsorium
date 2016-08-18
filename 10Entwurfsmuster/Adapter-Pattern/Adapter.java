package adapterPattern;

public class Adapter implements UsedToBe{

	private Adaptee adaptee;

	public Adapter() {
		this.adaptee = new Adaptee();
	}

	@Override
	public int getResult() {
		return adaptee.getResultOfAdapteeThisYear();
	}
	
	

}
