package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Connector{
	private Connection con;
	public Connector(){
		
		//-----------Initiate Driver-----------------------
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//------------Get Connection-----------------------
		try {
			this.con = DriverManager.getConnection("jdbc:postgresql://java.is.uni-due.de/ws1011", "ws1011",
					"ftpw10");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//------------print out url and username ----------
		try {
			System.out.println("URL: " + con.getMetaData().getURL()
					+"Username: " + con.getMetaData().getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-------------get Table names --------------------		
		try {
			ResultSet rs = con.getMetaData().getTables(null,null,null,new String[] {"TABLES"});
			while(rs.next()){
				System.out.println(rs.getString("TABLE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//------------insert into table -------------------
		long id = -1;
		try {
			PreparedStatement ps = con.prepareStatement(  // <--- PreparedStatement damit Nutzer nicht sicherheitslücken ausnutzen kann
									// ist außerdem schneller 
					"INSERT INTO products(name, price, quantity) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);// id wird von datenbank erzeugt
			ps.setString(1, "Karl");
			ps.setDouble(2,2.5);
			ps.setInt(3, 1);
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				id = rs.getLong("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//----------- get from table----------------------
		try {
			PreparedStatement ps = con.prepareStatement("SELECT *"
					+ "FROM products WHERE id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String name = rs.getString("name");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				 id = rs.getLong("id");
				 System.out.println("Name : "+ name + " Quantity: "+ quantity +
						 " Price : " +price +" id : " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
