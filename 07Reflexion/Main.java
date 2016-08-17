package reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws Exception {
		Class<Superheld> c1 = Superheld.class;
		System.out.println(c1);
		
		Class<?> c2 = new Superheld().getClass();
		System.out.println(c2);
		
			Class<?> c3 = Class.forName("reflection.Superheld");
			System.out.println(c3);
			for(Field f : c3.getFields()){
				System.out.println(f.toString());
			}
			for(Constructor<?> c : c3.getConstructors()){
				System.out.println(c.toString());
			}
			for(Method m : c3.getMethods()){
				System.out.println(m.toString());
			}
		Superheld held = null ;
			Constructor<Superheld> constructor = 
					c1.getConstructor(String.class, int.class, String.class);
					held = constructor.newInstance("Udo", 52, "4 Schachteln am Tag Rauchen");		// erstellt neue instanz des konstruktors
					System.out.println(held.getSuperkraft());
		
		
			Method method = c1.getMethod("setMaennlich");
			method.invoke(held);							// führt methode auf "held"  aus 
			System.out.println(held.getGeschlecht());
			method = c1.getMethod("setName", String.class);
			method.invoke(held, "Kurt");
			System.out.println(held.getName());
		
			for(Field f : c1.getDeclaredFields()){	// gets also private fields, methods , constructors
				System.out.println(f.toString());
			}
			for (Method m : c1.getDeclaredMethods()){
				System.out.println(m.toString());
			}
			for(Constructor c : c1.getDeclaredConstructors()){
				System.out.println(c.toString());
			}
			
			Constructor c = c1.getDeclaredConstructor(String.class);
			c.setAccessible(true);
			Superheld heldi = (Superheld) c.newInstance("Unglaublich beste superkraft evor");
			System.out.println(heldi.getSuperkraft());
			
			outToString(heldi,c1);
	}
	static void outToString( Object o, Class<?> classObj )
	 {
     System.out.println("=== Object ==="); 
	  Field[] fields = classObj.getDeclaredFields();
	  AccessibleObject.setAccessible( fields, true );

	  for ( Field f : fields ) {
	   try {
	    System.out.println( f.getName() + "=" + f.get(o) );
	   }
	   catch ( IllegalAccessException e ) { e.printStackTrace(); }
	  }
	  System.out.println("======"); 	
	}

}
