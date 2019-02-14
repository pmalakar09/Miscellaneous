package com.onmobile.ps.util.bot;

import java.sql.SQLException;

import com.onmobile.ps.util.Utils;
import com.onmobile.ps.util.pojo.ScriptObj;

public class ScriptBot {
	public static void main(String[] args) throws SQLException
	  {
		System.out.println("Program  Start");
		ScriptObj obj = new ScriptObj();
	    try {
	      Utils.readInput(obj);
	      /*if (!Utils.validateInput(obj)) return;*/
	      Utils.createScript(obj);
	    } finally {
	      try {
	        obj.getConnection().close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    try
	    {
	      obj.getConnection().close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
}
