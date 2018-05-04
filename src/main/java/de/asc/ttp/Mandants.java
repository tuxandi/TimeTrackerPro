
package de.asc.ttp;
import de.asc.db.InsertTable;
/**
 * @author jonas
 *
 */
public class Mandants extends InsertTable {
	
	public String name = null;
	public String address = null;
	public int zip;
	public String city = null;
	public String country = null;
	
	public Mandants() {
		tablename = "mandants";
		init();
	}

}
