public class SerializableObject<T> {

	
	private transient int hiddenhInt = 42;
	private T value;
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
