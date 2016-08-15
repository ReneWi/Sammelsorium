import java.beans.Transient;
import java.io.Serializable;


public class SerializableObject<T> {

	
	private transient int hiddenhInt = 42;
	private T value;
	
	public SerializableObject(){}
	
	public SerializableObject(T value){
		this.value = value;
	}
	public T getVal(){
		return value;
	}
	
	
	public int getNumber(){
		return hiddenhInt;
	}
	
	
}
