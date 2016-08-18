package compositePattern;
public class Line extends Graphic{

	@Override
	public void draw() {
		System.out.println("Ich bin eine Linie");
	}

	@Override
	public void add(Graphic g) {
	}

	@Override
	public Graphic getChild(int i) {
		return null;
	}

}
