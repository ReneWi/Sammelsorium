package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.openjpa.persistence.OpenJPAPersistence;


public class Connector {
	private EntityManagerFactory fac;
	private EntityManager e;
	private EntityTransaction t;
 public Connector(){
	 //--------------load EntityManagerFactory with persistence.xml-------------
	 fac = Persistence.createEntityManagerFactory("openjpa",System.getProperties()); 
	 //--------------load EntityManagerFactory without persistence.xml----------
	 Map<String, String> map = new HashMap<String, String>();

		map.put("openjpa.ConnectionURL",
				"jdbc:postgresql://java.is.uni-due.de/ws1011");
		map.put("openjpa.ConnectionDriverName", "org.postgresql.Driver");
		map.put("openjpa.ConnectionUserName", "ws1011");
		map.put("openjpa.ConnectionPassword", "ftpw10");
		map.put("openjpa.RuntimeUnenhancedClasses", "supported");
		map.put("openjpa.jdbc.SynchronizeMappings", "false");
		map. put ("openjpa.MetaDataFactory" ,"jpa(Types="+ Product.class.getName()+")") ;
		
		List<Class<?>> types = new ArrayList<Class<?>>();
		types.add(Product.class);

		if (!types.isEmpty()) {
			StringBuffer buf = new StringBuffer();
			for (Class<?> c : types) {
				if (buf.length() > 0)
					buf.append(";");
				buf.append(c.getName());
			}
			
			map.put("openjpa.MetaDataFactory", "jpa(Types=" + buf.toString()
					+ ")");
		}
		fac = OpenJPAPersistence.getEntityManagerFactory(map);
		// ------------- create EntityManager-----------------------
		e = fac.createEntityManager();
		//----------------- create Transaction ----------------------
		t = e.getTransaction();
		// ----------------- insert---------------------------------
		t.begin();
		Product obj = new Product();
		obj.setId(100000000);
		obj.setName("dr strangelove");
		obj.setPrice(100.0);
		obj.setQuantity(1);
		if (obj.getId() != 0){
			if (e.find(obj.getClass(),obj.getId()) != null){
			e.merge(obj);
			}else{
				e.persist(obj);
			}
		}else{
			e.persist(obj);
		}
		t.commit();
		//---------------------- read Product --------------------
		t.begin();
		Product p = null;
		for(Object o: e.createQuery("SELECT p FROM Product p WHERE p.id =100000000").getResultList()){
			p = (Product) o;
		}
		t.commit();
		// --------------------- close ------------------------
		if (e != null){
			e.close();
		}
		if (fac != null){
			fac.close();
		}
		
		System.out.println("Name : " + p.getName() + " id : " + p.getId() + " Quantity: " + p.getQuantity() +" Price : " + p.getPrice());
	 
	 
 }
}
