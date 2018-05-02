/**
 * 
 */
package de.asc.ttp;
import de.asc.db.Table;
/**
 * @author jonas
 *
 */
public class MandantUser extends Table{
	public int mandantid;
	public int userid;

	public MandantUser() {
		tablename = "mandantuser";
		init();
	}
}
