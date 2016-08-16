import java.beans.Transient;
import java.io.Serializable;


public class SerializableObject<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hiddenhInt;	
	private T value;
	
	public SerializableObject(){} // <---- Dont you ever forget this shit !
	
	public SerializableObject(T value){
		this.value = value;
		this.hiddenhInt = 42;	//<---- @Transient funktioniert wenn Attribut in Objekt implementiert wird, ansonsten sollte man es
					// 	static machen !
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
	
	@Transient
	public void setNumber(int number){
		this.hiddenhInt = number;
	} 
}
