package com.onmobile.ps.util;

import com.onmobile.ps.util.pojo.ScriptObj;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class Utils {
	
	static final Logger logger = Logger.getLogger(Utils.class);

	  public static boolean validateInput(ScriptObj obj){
		  if (obj.getColumns().split(",").length == '0') {
			      logger.error("EMPTY/NULL input COLUMNS");
			      return false;
	  }
		  return true;

	  }
	  
	  public static void readInput(ScriptObj obj) {
		    FileInputStream fileInput = null;
		    try
		    {
		      logger.info("reading input");
		      File file = new File("Input.properties");
		      System.out.println(file);
		      fileInput = new FileInputStream(file);
		      Properties properties = new Properties();
		      properties.load(fileInput);

		      obj.setdbdriver(getValue(properties, "DBDRIVER"));
		      obj.setDbURL(getValue(properties, "DBURL"));
		      obj.setUserName(getValue(properties, "DBAUSER"));
		      obj.setPassWord(getValue(properties, "DBAPASSWORD"));
		      //obj.setTables(getValue(properties, "TABLES"));
		      obj.setViews(getValue(properties, "VIEWS"));
		      //obj.setColumn_type(getValue(properties, "COLUMN_TYPE"));
		      obj.setColumns(getValue(properties, "COLUMNS"));
		      /*obj.setJobname(getValue(properties, "JOBNAME"));
		      obj.setLabelName(getValue(properties, "COLUMN_DISPLAYNAME"));
		      obj.setRssId(getValue(properties, "RSSID"));

		      fileInput = new FileInputStream(new File("template.properties"));
		      properties.load(fileInput);
		      obj.setTableScript(getValue(properties, "TABLESCRIPT"));
		      obj.setColumnScript(getValue(properties, "COLUMNSCRIPT"));
		      obj.setExtraColumnInsertCPP(getValue(properties, 
		        "CONTENT_PUBLISH_JOB_EXTRACOLUMNS_INSERT"));
		      obj.setExtraColumnUpdateCPP(getValue(properties, 
		        "CONTENT_PUBLISH_JOB_EXTRACOLUMNS_UPDATE"));
		      obj.setContentRightUpdateQuery(getValue(properties, 
		        "CONTENT_PUBLISH_JOB_CONTENTRIGHTS_COLUMN_UPDATE"));
		      obj.setRssUpdateQuery(getValue(properties, "UPDATE_RSS"));*/
		    }
		    catch (FileNotFoundException e)
		    {
		      e.printStackTrace();
		      logger.error("", e);
		      try
		      {
		        fileInput.close();
		      } catch (IOException IOE1) {
		        e.printStackTrace();
		        logger.error("", e);
		      }
		    }
		    catch (IOException e)
		    {
		      e.printStackTrace();
		      logger.error("", e);
		      try
		      {
		        fileInput.close();
		      } catch (IOException IOE) {
		        e.printStackTrace();
		        logger.error("", e);
		      }
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      logger.error("", e);
		      try
		      {
		        fileInput.close();
		      } catch (IOException IOE2) {
		        e.printStackTrace();
		        logger.error("", e);
		      }
		    }
		    finally
		    {
		      try
		      {
		        fileInput.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		        logger.error("", e);
		      }
		    }
		  }
	  
	  public static String getValue(Properties pro, String key) throws Exception
	  {
	    try {
	      logger.debug("Loading key " + key);

	      return pro.getProperty(key);
	    }
	    catch (Exception e) {
	      logger.error("", e);
	      e.printStackTrace();
	      if (key.equalsIgnoreCase("COLUMN_DISPLAYNAME"))
	        return null; 
	    }
	    throw new  Exception();
	  }
	  static String getViewScript(Connection con, String viewName)
	  {
	    Statement stmt = null;
	    ResultSet rs = null;
	    String viewDef = null;
	    try
	    {
	      stmt = con.createStatement();
	      rs = stmt.executeQuery("select pg_get_viewdef('" + viewName + "')");
	      while (rs.next()) {
	        String createViewTemplate = "create or replace view " + 
	          viewName + " as \n";
	        String selectQuery = rs.getString(1).toLowerCase();
	        if (!selectQuery.startsWith("create or replace view "))
	          viewDef = createViewTemplate + selectQuery;
	        else
	          viewDef = selectQuery;
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      try
	      {
	        rs.close();
	        stmt.close();
	      } catch (SQLException SQL) {
	        logger.error("", e);
	      }
	    }
	    finally
	    {
	      try
	      {
	        rs.close();
	        stmt.close();
	      } catch (SQLException e) {
	        logger.error("", e);
	      }
	    }
	    logger.info("view definition is :: " + viewDef);
	    return viewDef;
	  }
	  
	  
	  
	  public static void createScript(ScriptObj obj) throws SQLException
	  {
	    
	    //ResultSet resultSet = null;
	    String[] viewsArray = obj.getViews().split(",");
	    int i = 0;
	    String[] columnName = obj.getColumns().split(",");
	   
	    Connection connection = null;
	    StringBuilder builder = new StringBuilder();
	    //String[] columnlabel;
	    //String[] columnlabel;
	    
	  //  String temp1 = getViewScript(obj.getConnection(), viewsArray[i]);
	    
	    if ((obj.getColumns() == null) || (obj.getColumns().isEmpty()))
	    {
	      logger.debug("COLUMN NAME is not provided");
	     // columnlabel = columnName;
	    }
	    else {
	      //columnlabel = obj.getLabelName().split(",");
	    }try {
	    	connection = obj.getConnection();
	    	System.out.println("Before Connection");
	    	System.out.println("connection " + connection);
	    	for (String table : obj.getTables().split(",")){
	    	logger.info("creating script for " + table);
	    	builder.setLength(0);
	    	for (int j = 0; j < columnName.length; j++) { logger.info("column is " + columnName[j]);
	    	}
	     String temp1 = getViewScript(obj.getConnection(), viewsArray[i]);

	        if (!"Not a view".equalsIgnoreCase(temp1))
	        {
	          builder.append(createViewDefinition(temp1, table, 
	            columnName) + ";\n");
	        }
	        writeToFile(builder.toString(), table);
	        i++;
	      }
	    }
	    
	    catch (Exception e)
	    {
	      e.printStackTrace();
	     
	    }
	  }



	  
	  
	  
	  static String createViewDefinition(String def, String operator, String[] columnnames)
	  {
	    String viewDef = def;

	    String operatorAlias = null;

	    String fromtoaliasmatch = null;
	    Pattern pattern = Pattern.compile("from.*" + operator + "\\s*.*?([\\s,]|$)");
	    Matcher match = pattern.matcher(viewDef);
	    while (match.find()) {
	      fromtoaliasmatch = match.group();
	      System.out.println(fromtoaliasmatch);
	      operatorAlias = fromtoaliasmatch.split(operator)[1].trim().split(",")[0];
	    }
	    logger.debug("alias name for operator table is:" + operatorAlias);

	    StringBuilder newColumnsScript = new StringBuilder();
	    for (int columnCount = 0; columnCount < columnnames.length; columnCount++) {
	      newColumnsScript.append(",");
	      newColumnsScript.append("\n\t");
	      newColumnsScript.append(operatorAlias + "." + columnnames[columnCount]);
	    }
	    newColumnsScript.append("\n\t");
	    logger.debug("new columns script:" + newColumnsScript);

	    Pattern replacePattern = Pattern.compile("[\\s\\t\\n]*from.*" + operator + "\\s*.*?([\\s,]|$)");
	    Matcher replaceMatch = replacePattern.matcher(viewDef);
	    while (replaceMatch.find()) {
	      String replaceString = replaceMatch.group();

	      viewDef = viewDef.replace(replaceString, newColumnsScript + fromtoaliasmatch);
	    }
	    System.out.println(viewDef);
	    logger.debug("new view definition is :: " + viewDef);
	    return viewDef;
	  }

	  static void writeToFile(String content, String fileName)
	  {
	    String viewFileAbsolutePath = fileName + ".sql";
	    logger.info("creating view file" + viewFileAbsolutePath);
	    FileWriter fw = null;
	    try {
	      fw = new FileWriter(viewFileAbsolutePath, true);
	      fw.write(content);
	    } catch (IOException e) {
	      logger.error("", e);
	      try
	      {
	        fw.close();
	      } catch (IOException IOE3) {
	        logger.error("", e);
	      }
	    }
	    finally
	    {
	      try
	      {
	        fw.close();
	      } catch (IOException e) {
	        logger.error("", e);
	      }
	    }
	    logger.info("created view file" + viewFileAbsolutePath);
	  }

	  public static void main(String[] ar)
	  {
		System.out.println("In Util");
	    createViewDefinition("select one_tab.tfspainrbtclipid clipid,one_tab.whsongname songname,one_tab.previewfilename,one_tab.clipfilename,(casewhen (one_tab.aliaspromocode is not null and one_tab.aliaspromocode::text <> '''') then one_tab.aliaspromocodewhen coalesce(one_tab.aliaspromocode::text, '''') = '''' then one_tab.promocodeend) promocode,(casewhen holderstartdate < to_date(''01.01.1990'',''dd.mm.yyyy'') then ''01.01.1990''when holderstartdate >= to_date(''01.01.1990'',''dd.mm.yyyy'') then to_char(holderstartdate, ''dd.mm.yyyy'')end) startdate,(casewhen holderenddate > to_date(''31.12.2037'',''dd.mm.yyyy'') then ''31.12.2037''when holderenddate <= to_date(''31.12.2037'',''dd.mm.yyyy'') then to_char(holderenddate, ''dd.mm.yyyy'')end) enddate,one_tab.chargeclass,one_tab.whmoviename moviename,one_tab.languagename  as language,smsalias,one_tab.singer,''y'' addtoaccesstable,'''' clipdemofilename,(casewhen (artwork_1 is not null and artwork_1::text <> '''') then''cp=''||contentprovidername||''|isrc=''||isrc||''|upc=''||upc||''|author=''||author||''|image=''||tfspainrbtclipid||''.''||artworkfileextension_1||''|cpc:''||cpc||''|cc:''||ccwhen coalesce(artwork_1::text, '''') = '''' then''cp=''||contentprovidername||''|isrc=''||isrc||''|upc=''||upc||''|author=''||author||''|cpc:''||cpc||''|cc:''||ccend) clipinfo,''normal'' cliptype from tfspainrbtdetails one_tab", "tfspainrbtdetails", new String[] { "dummy" });
	    System.out.println("In Util Last");
	  }
}
