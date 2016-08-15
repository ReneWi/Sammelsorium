import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
public class XStreamClass {
public static void main(String[] args) {
	SerializableObject<String> obj = new SerializableObject<String>("whatever ... its late...");
	System.out.println(obj.getNumber());
	XStream xstream = new XStream(new DomDriver());
	try(FileWriter fw = new  FileWriter("XDreamWorks.xml")){
		xstream.toXML(obj, fw);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SerializableObject<String> echo = null;
	try(FileReader fr = new FileReader("XDreamWorks.xml")){
		echo = (SerializableObject<String>)xstream.fromXML(fr);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(echo.getVal());
	System.out.println(echo.getNumber());
}
}
