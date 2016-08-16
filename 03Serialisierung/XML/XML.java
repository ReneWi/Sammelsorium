import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XML {
public static void main(String[] args) {
	SerializableObject<String> obj = new SerializableObject<String>("Unkreativ");
	obj.setNumber(14);
	System.out.println(obj.getNumber());
 	try(FileOutputStream fo  = new 	FileOutputStream("dat_Ei.xml");
			XMLEncoder encoder = new XMLEncoder(fo)){
 			encoder.writeObject(obj);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	
 	SerializableObject<String> echo = null;
 	try(FileInputStream fi = new FileInputStream("dat_Ei.xml");
 			XMLDecoder decoder = new XMLDecoder(fi)){
 		echo = (SerializableObject<String>) decoder.readObject();
 	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 	System.out.println(echo.getVal());
 	System.out.println(echo.getNumber());
 	/* Output: 
 	*42
 	*Unkreativ
 	*0                    
 	*/
}
}
