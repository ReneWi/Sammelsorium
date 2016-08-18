package compositePattern;
import java.util.ArrayList;

public class Figure extends Graphic{

	private ArrayList<Graphic> children = new ArrayList<>();
	
	@Override
	public void draw() {
		for(int i = 0; i < children.size(); i++){
			getChild(i).draw();
		}
	}

	@Override
	public void add(Graphic g) {
		children.add(g);
	}

	@Override
	public Graphic getChild(int i) {
		return children.get(i);
	}

	
	
}
