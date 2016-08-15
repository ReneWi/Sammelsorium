import java.beans.Transient;
import java.io.Serializable;


public class SerializableObject<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient int hiddenhInt = 42;
	private T value;
	
	public SerializableObject(){}
	
	public SerializableObject(T value){
		this.value = value;
	}
	public T getVal(){
		return value;
	}
	public void setVal(T value){
		this.value = value;
	}
	
	public int getNumber(){
		return hiddenhInt;
	}
	
	public void setNumber(int number){
		this.hiddenhInt = number;
	}
}
