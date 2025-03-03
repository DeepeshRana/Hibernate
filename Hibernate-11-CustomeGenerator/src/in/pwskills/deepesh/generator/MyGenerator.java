package in.pwskills.deepesh.generator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MyGenerator implements IdentifierGenerator {

	@Override
	public String generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		// Generate our own primary key value like u001, u002, u0003...

		String id = "";

		try {

			int i = 0;

			Connection connection = arg0.connection();
			Statement statement;
			statement = connection.createStatement();
			ResultSet executeQuery = statement.executeQuery("select id from temp_table");

			if (executeQuery.next()) {

				if (i <= 9) {
					id = "u00" + i;
				} else if (i > 9 && i <= 99) {
					id = "u00" + i;
				} else {
					id = "u0" + i;
				}
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;

	}

}
