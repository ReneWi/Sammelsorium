import java.io.Serializable;

public class SerializableObject<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T value;
	public SerializableObject(T value){
		this.value = value;
	}
	public T getVal(){
		return value;
	}
}
