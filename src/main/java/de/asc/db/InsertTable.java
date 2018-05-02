/**
 * 
 */
package de.asc.db;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author jonas
 *
 */
public class InsertTable extends Database {
	protected String tablename = null;
	private String insertSql = null;
	private String selectSql = null;
	private List<Field> fields = new ArrayList<Field>();
	
	public Integer id = null;
	public String name = null;
	
	
	
	public void init() {
		buildFieldList();
		buildSelectStatement();
		buildInsertStatement();
	}

	private void buildFieldList() {
		Field[] fieldlist = this.getClass().getFields();
		fields = Arrays.asList(fieldlist);
	}
	
	
	private void buildSelectStatement() {
		selectSql = "select ";
		for (int i = 0; i < fields.size(); i++) {
			if (i > 0)
				selectSql += ", ";
			selectSql += fields.get(i).getName();
		}
	selectSql += " from "+ tablename+" where id = "+id;
	}

	
	
	private void buildInsertStatement() {
		insertSql = "INSERT INTO "+ tablename +"(";
		for (int i = 0; i < fields.size(); i++) {
			if (i > 0)
				insertSql += ", ";
			insertSql += fields.get(i).getName()+"=";
			
			try { 
				if (fields.get(i).getType().getName().equals("java.lang.Integer"))
					insertSql +=fields.get(i).get(this);
				else
					insertSql += "'"+fields.get(i).get(this)+"'";
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				insertSql += "''";
				e.printStackTrace();
			}
		}
		insertSql += ") where id = "+id;
	}
	public void setSelect (String selectSql) {
		this.selectSql = selectSql;
	}
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String toString(){
		return selectSql+"\n"+insertSql;
	}
	
	
}

