package compositePattern;
public class Text extends Graphic {

	@Override
	public void draw() {
		System.out.println("Ich bin ein Text!");

	}

	@Override
	public void add(Graphic g) {

	}

	@Override
	public Graphic getChild(int i) {
		return null;
	}

}
