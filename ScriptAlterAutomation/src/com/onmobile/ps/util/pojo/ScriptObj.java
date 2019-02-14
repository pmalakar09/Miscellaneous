package com.onmobile.ps.util.pojo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ScriptObj {
   	  private String dbDriver;
	  private String userName;
	  private String passWord;
	  private String dbURL;
	  private Connection connection;
	  private String tables;
	  private String views;
	  //private String column_type;
	  //private String jobname;
	  private String columns;
	  //private String tableScript;
	  //private String columnScript;
	  //private String labelName;
	  //private String extraColumnInsertCPP;
	  //private String extraColumnUpdateCPP;
	  //private String rssId;
	  //private String rssUpdateQuery;
	  //private String contentRightUpdateQuery;
	  
	  public String getViews() {
		    return this.views;
		  }

		  public void setViews(String views) {
		    this.views = views;
		  }
	  
	  public void setColumns(String columns) {
		    this.columns = columns;
		  }
	  
	  public String getColumns() {
		    return this.columns;
		  }
	  public String getTables() {
		    return this.tables;
		  }

		  public void setTables(String tables) {
		    this.tables = tables;
		  }


	    public void setdbdriver(String dbDriver)
	  {
	    this.dbDriver = dbDriver;
	  }

	  public String getdbdriver() {
	    return this.dbDriver;
	  }
	  public void setUserName(String userName) {
	    this.userName = userName;
	  }
	  public void setPassWord(String passWord) {
	    this.passWord = passWord;
	  }
	  public String getDbURL() {
		    return this.dbURL;
		  }

		  public void setDbURL(String dbURL) {
		    this.dbURL = dbURL;
		  }

	  public Connection getConnection() {
	    if (this.connection == null) {
	      try
	      {
	    	  Class.forName("org.postgresql.Driver");
	        this.connection = DriverManager.getConnection(this.dbURL, this.userName, this.passWord);
	      } catch (Exception e) {
	        e.printStackTrace();
	      }

	    }

	    return this.connection;
	  }

	  public String toString()
	  {
		  return "ScriptObj [dbDriver=" + this.dbDriver + ", userName=" + this.userName + 
			      ", dbURL=" + this.dbURL + ", connection=" + this.connection + 
			      ", tables=" + this.tables + ", views=" + this.views + ", columns=" + this.columns + "]";
	  }

}
