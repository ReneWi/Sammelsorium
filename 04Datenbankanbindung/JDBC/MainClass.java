import java.sql.*;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class MainClass {

	public static void main(String[] args) {

		RowSetFactory rowSetFactory;
		try {
			rowSetFactory = RowSetProvider.newFactory();
			try (CachedRowSet rs = (CachedRowSet) rowSetFactory
					.createCachedRowSet()) {

				rs.setUrl("jdbc:postgresql://java.is.uni-due.de:5432/lieferanten/");
				rs.setUsername("ws1011");
				rs.setPassword("ftpw10");
				rs.setCommand("select * from lieferanten");
				rs.execute();

				while (rs.next()) {
					int idVal = rs.getInt("id");
					String nameVal = rs.getString("name");
					String wohnortVal = rs.getString("wohnort");
					System.out.println("id = " + idVal + ", name = " + nameVal
							+ ", wohnort = " + wohnortVal);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
