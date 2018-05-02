package de.asc.ttp;

import de.asc.db.Table;

public class User extends Table {
	public String firstname = null;
	public String lastname = null;
	
	public User() {
		tablename = "users";
		init();
	
	}
}
