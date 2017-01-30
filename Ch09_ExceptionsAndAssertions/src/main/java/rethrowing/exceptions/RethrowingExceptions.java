package rethrowing.exceptions;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;

public class RethrowingExceptions {

	public void parseData() throws SQLException, DateTimeParseException {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void multiCatch() throws SQLException, DateTimeParseException {
		try {
			parseData();
		} catch (SQLException | DateTimeParseException e) {
			System.err.println(e);
			throw e;
		}
	}

}
