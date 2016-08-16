import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public enum Method {
		STATEMENT, PREPAREDSTATEMENT, CALLABLESTATMENT
	}

	public static void main(String[] args) {

		// Loading driver (can be skipped since java 1.5)
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(
				"jdbc:postgresql://java.is.uni-due.de:5432/PizzaDB/", "ws1011",
				"ftpw10")) {
			executeMyStatement(con, Method.CALLABLESTATMENT);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void executeMyStatement(Connection con, Method m) {
		switch (m) {

		case STATEMENT:

			try (Statement stmt = con.createStatement();
					ResultSet rs = stmt
							.executeQuery("SELECT * FROM \"Pizzaliste\" WHERE \"Big\" = 6.5")) {
				while (rs.next()) {
					System.out.println(rs.getString(2));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		case PREPAREDSTATEMENT:

			try (PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM \"Pizzaliste\" WHERE \"Big\" = ?")) {
				pstmt.setDouble(1, 6.50);
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						System.out.println(rs.getString(2));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		case CALLABLESTATMENT:

			try (CallableStatement cstmt = con
					.prepareCall("{ call getpizzawithbigprice(?) }")) {
				cstmt.setDouble(1, 6.50);
				try (ResultSet rs = cstmt.executeQuery()) {
					while (rs.next()) {
						System.out.println(rs.getString(2));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		}

	}
}
