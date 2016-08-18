package compositePattern;
public class MainClass {

	public static void main(String[] args) {
		Graphic g1 = new Line();
		Graphic g2 = new Text();
		Graphic g3 = new Figure();
		Graphic g4 = new Line();
		Graphic g5 = new Text();
		Graphic g6 = new Figure();
		
		g3.add(g1);
		g3.add(g2);
		
		g6.add(g4);
		g6.add(g5);
		
		g3.add(g6);
		
		g1.draw();
		System.out.println("-------------");
		g2.draw();
		System.out.println("-------------");
		g3.draw();

		

	}

}
