import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Binary {
public static void main(String[] args) {
	String s = "blablablabla";
	SerializableObject<String> object = new SerializableObject<String>(s);
	System.out.println(object.getNumber());
	try(FileOutputStream f= new FileOutputStream("dateipfad.ser");
		ObjectOutputStream o = new ObjectOutputStream(f)){
		o.writeObject(object);
		o.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	SerializableObject<String>blub = null;
	try(FileInputStream fi = new FileInputStream("dateipfad.ser");
		ObjectInputStream oi = new ObjectInputStream(fi)){
		blub = (SerializableObject<String>) oi.readObject();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(blub.getVal());
	System.out.println(blub.getNumber());
	/*Output :
	*42
	*blablablabla
	*0
	*/
}
}
