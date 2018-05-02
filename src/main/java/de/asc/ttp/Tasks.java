/**
 * 
 */
package de.asc.ttp;
import de.asc.db.Table;
/**
 * @author jonas
 *
 */
public class Tasks extends Table{
	public int taskid;
	public String name = null;
	public String pph = null;
	
	public Tasks() {
		tablename = "tasks";
		init();
	}
}
