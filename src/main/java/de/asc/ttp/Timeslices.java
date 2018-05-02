/**
 * 
 */
package de.asc.ttp;
import de.asc.db.Table;
/**
 * @author jonas
 *
 */
public class Timeslices extends Table {
	public int taskid;
	public int userid;
	public int startts;
	public int endts;
	public String comment = null;

public Timeslices() {
	tablename = "timeslices";
	init();
	}
}
