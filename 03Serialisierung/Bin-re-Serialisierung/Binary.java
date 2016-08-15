import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Binary {
public static void main(String[] args) {
	String s = "Blablablabla";
	try(FileOutputStream f= new FileOutputStream("dateipfad.ser");
		ObjectOutputStream o = new ObjectOutputStream(f)){
		o.writeObject(s);
		o.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String blub = null;
	try(FileInputStream fi = new FileInputStream("dateipfad.ser");
		ObjectInputStream oi = new ObjectInputStream(fi)){
		blub = (String) oi.readObject();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(blub);
	
}
}
