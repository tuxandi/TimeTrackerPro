/**
 * 
 */
package de.asc.ttp;
import de.asc.db.Table;
/**
 * @author jonas
 *
 */
public class Projects extends Table{
	public int projectid;
	public int mandantid;
	public int time;
	public String name = null;
	
	public Projects() {
		tablename = "projects";
		init();
	}

}
