package compositePattern;
public abstract class Graphic {

	public abstract void draw();
	public abstract void add(Graphic g);
	public abstract Graphic getChild(int i);
	
}
