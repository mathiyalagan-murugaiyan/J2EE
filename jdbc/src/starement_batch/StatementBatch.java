package starement_batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class StatementBatch {

	public static void main(String[] args) throws SQLException {
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata?user=root&password=root");
		
		Statement st = con.createStatement();
		
		st.addBatch("delete from student where id=19");
		
		
		st.addBatch("update student set mobile=1234567891 where id = 15");
		
      	int[] arr = st.executeBatch();

	    Arrays.stream(arr)
		.forEach(System.out::println);
		
       con.close();
	}

}
