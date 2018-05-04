package de.asc.ttp;


import java.sql.SQLException;


import de.asc.db.Table;

public class User extends Table {


	public int id;
	public int mandantid;
	public String name = null;
	public String firstname = null;
	public String email = null;
	public User() throws SQLException {
		tablename = "users";
		init();
	}
		
	

	

	
		
 
}
