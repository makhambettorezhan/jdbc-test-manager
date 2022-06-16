package kz.jusan.testdb;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
@SpringBootApplication
public class TestdbApplication {

	public static void main(String[] args) throws SQLException {
		Driver driver = new org.postgresql.Driver();
		DriverManager.registerDriver(driver);
		try (var connection = DriverManager.getConnection("jdbc:postgresql://batyr.db.elephantsql.com/wwanpexp", "wwanpexp", "lW9ahJNBZ0mGQUI9VtWCi2R44KWNvjUc")) {
			var sql = "select * from student";
			try (var statement = connection.createStatement()) {
				var findId = 5;
				ResultSet resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					int age = resultSet.getInt("age");
					String major = resultSet.getString("major");

					System.out.println(id + " " + name + " " + age + " " + major);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
