/**
 * 
 */
package de.asc.db;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author andi
 *
 */
public class Table  extends Database{
	protected String tablename = null;
	private String insertSql = null;
	private String selectSql = null;
	private String updateSql = null;
	private List<Field> fields = new ArrayList<Field>();
	
	
	//public Integer id = null;
	//public String name = null;
	
	
	
	
	/**
	 * 
	 */
	public void init() {
		buildFieldList();
		buildSelectStatement();
		buildUpdateStatement();
		//buildInsertStatement();
	}
	
	/**
	 * 
	 */
	private void buildFieldList() {
		Field[] fieldlist = this.getClass().getFields();
		fields = Arrays.asList(fieldlist);
	}
	
	/**
	 * 
	 * @return
	 */
	private void buildSelectStatement() {
		selectSql = "select ";
		for (int i = 0; i < fields.size(); i++) {
			if (i > 0)
				selectSql += ", ";
			selectSql += fields.get(i).getName();
		}
		selectSql += " from "+tablename+" where id = 123";	
		
	}

	
	

	/**
	 * 
	 */
	private void buildUpdateStatement() {
		updateSql = "update "+tablename+ " set (";
		for (int i = 0; i < fields.size(); i++) {
			if (i > 0)
				updateSql += ", ";
			updateSql += fields.get(i).getName()+"=";
			
			try {
				if (fields.get(i).getType().getName().equals("java.lang.Integer"))
					updateSql +=fields.get(i).get(this);
				else
					updateSql +="'"+fields.get(i).get(this)+"'";
					
			} catch (IllegalArgumentException | IllegalAccessException e) {
				updateSql += "''";
				e.printStackTrace();
			}
						
		}
		updateSql += ") where id = 123";	
	}

	
		
	/*
 	/**
	 * 
	 * @param tablename
	 */
	public void setSelect(String selectSql) {
		this.selectSql = selectSql;
	}
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return selectSql+"\n"+updateSql;
	}
}
