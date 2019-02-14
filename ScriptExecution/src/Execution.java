import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class Execution {
	static Logger log = Logger.getLogger(Execution.class.getName());
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "SQL_QUERY,EXECUTION_START_TIME,EXECUTION_END_TIME,OUTPUT";
    public static String host=null;
    public static String hostUserName=null;
    public static String hostPassword=null;
    public static String sh_Filepath=null;
    public static String is_War_Replace="False";
    public static String is_Tomcat_Restart="False";
    public static String old_War_Path=null;
    private static final int port=22;
    public static boolean status=false;
    public static Execution ex=null;
    public static Session session=null;
    public static ChannelSftp sftpChannel=null;
    public static Properties properties=null;
    
	public static void main(String[] args) throws IOException {
		log.info("Deployment Tool Start..");
		String dbURL=null;
		String dbUSER=null;
		String dbPASSWORD=null;
		long queryCount=0;
		FileInputStream fileInput = null;
		File file = new File("Input.properties");
		fileInput = new FileInputStream(file);
		properties = new Properties();
		log.info("Input.properties is loading");
	    properties.load(fileInput);
	    log.info("Input.properties loaded succesfully");
		FileWriter fileWriter=null;
		String[] token=null;
		int i=0;
		String reportCSV = "REPORT-"+ new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss'.csv'").format(new Date());
		try{
			if(properties.getProperty("DBURL").isEmpty()||properties.getProperty("DBUSER").isEmpty()||properties.getProperty("DBPASSWORD").isEmpty())
			{
				log.debug("In Input.properties file mandatory fields are empty ==> "+"DBURL= "+properties.getProperty("DBURL")+";"+"DBUSER= "+properties.getProperty("DBUSER")+";"+"DBPASSWORD= "+properties.getProperty("DBPASSWORD")+"\n"+"Please fill the Input.properties properly!!");
			}
			else{
			dbURL=properties.getProperty("DBURL");
			dbUSER=properties.getProperty("DBUSER");
			dbPASSWORD=properties.getProperty("DBPASSWORD");
			host=properties.getProperty("HOST");
			hostUserName=properties.getProperty("HOST_USERNAME");
			hostPassword=properties.getProperty("HOST_PASSWORD");
			sh_Filepath=properties.getProperty("SH_FILEPATH");
			is_War_Replace=properties.getProperty("WAR_REPLACE");
			is_Tomcat_Restart=properties.getProperty("TOMCAT_RESTART");
			System.out.println("PROPERTIES: "+dbPASSWORD+";"+dbURL+";"+dbUSER);
			//fileWriter=new FileWriter(reportCSV);
			fileWriter=new FileWriter("D:\\My Workspace\\Python-Workspace\\"+reportCSV);
			fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
		Class.forName("org.postgresql.Driver");
		java.sql.Statement pstmt=null;
		log.info("Driver Loading Is Done Successfully");
		System.out.println("Driver Loading Is Done Successfully");
		log.info("Connecting To The DB : "+dbURL);
		Connection con=DriverManager.getConnection(dbURL,dbUSER,dbPASSWORD);
		log.info("DB connection done successfully");
		con.setAutoCommit(false);
		System.out.println("Connection Established");
		System.out.println("-----------------------------------------");
		pstmt=con.createStatement();
		ex=new Execution();
		System.out.println("ex.readFile(): "+ex.readFile());
		System.out.println("-----------------------------------------");
		ArrayList <String> al= new ArrayList <String>();
			StringBuilder currentSql= new StringBuilder();
			System.out.println("1"+currentSql);
			System.out.println("al:"+al);
			log.info("INPUT SCRIPT : "+al);
			token=(ex.readFile()).split(";");
			if (ex.readFile().isEmpty())
			{
				queryCount=0;
			}
			else
			{
				queryCount=token.length;
			}
			log.info("Total query count: "+queryCount);
			for(i=0;i<token.length;i++){
				System.out.println("SQL Query : "+token[i]);
				log.info("SQL Query : "+token[i]);
				currentSql.append((token[i]));
				System.out.println("al:"+al);
				if(token[i].contains("dist_systemconfiguration")){
					fileWriter.append(token[i]);
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(new SimpleDateFormat("HH-mm-ss").format(new Date()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(new SimpleDateFormat("HH-mm-ss").format(new Date()));
					fileWriter.append("Not executed because of dist_systemconfiguration script");
					//fileWriter.append(NEW_LINE_SEPARATOR);
					log.info("Not executed SQL because of dist_systemconfiguration script found");
					System.out.println("Not executed because of dist_systemconfiguration script");
				}
				else
				log.info("Executing Query : "+token[i]);
				fileWriter.append(token[i].replaceAll(",", " {COMMA} "));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));
				pstmt.execute(token[i]);
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append("EXECUTED");
				fileWriter.append(NEW_LINE_SEPARATOR);
				log.info("Succesfully Executed Query : "+token[i]);
			}
			System.out.println(al);
		con.commit();
		con.close();
		status=true;
		  }
		}
		
		catch(Exception e){
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(new SimpleDateFormat("HH:mm:ss").format(new Date()));
			log.debug("NOT EXECUTED SQL : "+token[i]);
			fileWriter.append(COMMA_DELIMITER);
			String exceptionText=e.toString();
			exceptionText=exceptionText.replace("\n"," ");
			System.out.println("EXCEPTIONTEXT : "+exceptionText);
			log.debug(e);
			fileWriter.append(exceptionText);
			fileWriter.append(NEW_LINE_SEPARATOR);
			e.printStackTrace();
		}
		finally{
			try{
				fileWriter.flush();
				fileWriter.close();
				System.out.println(host+hostPassword);
				ex.executeFile(sh_Filepath);
			}
			catch(Exception e){
				System.out.println("Error while flushing/closing fileWriter !!!");
		        e.printStackTrace();
		    	}
		}
	}
	String readFile() throws IOException {
	    //String filename="SCRIPT.sql";
		String filename="D:\\My Workspace\\Python-Workspace\\SCRIPT.sql";
		BufferedReader br = new BufferedReader(new FileReader(filename));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            line = br.readLine();
	        }
	        System.out.println("sb.length: "+sb.length());
	        System.out.println("sb.toString: "+sb.toString());
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	 public List<String> executeFile(String scriptFileName){
	     List<String> result = new ArrayList<String>();
	     System.out.println(status);
	     System.out.println(scriptFileName);
	     log.info("WAR_REPLACE= "+is_War_Replace);
	     log.info("TOMCAT_RESTART= "+is_Tomcat_Restart);
	     if (status==true && is_War_Replace.equalsIgnoreCase("true") && is_Tomcat_Restart.equalsIgnoreCase("false"))
	     {
	     try{
	    	 JSch jsch = new JSch();
	    	 System.out.println(hostUserName+hostPassword+host);
	         session = jsch.getSession(hostUserName, host, port);
	         log.info("Host= "+host +"\n"+"Host_UserName= "+hostUserName+"\n"+"Host_Password= "+hostPassword);
	         session.setConfig("StrictHostKeyChecking", "no");
	         session.setPassword(hostPassword);
	         session.connect();
	         log.info("Host Connected");
	         sftpChannel = (ChannelSftp) session.openChannel("sftp");
	         sftpChannel.connect();
	         log.info("Uploading atlantis.war in to the remote server...............");
	         sftpChannel.put("D:\\My Workspace\\Python-Workspace\\AtlantisWar\\atlantis.war", "/tmp/atlantis.war");
	         //sftpChannel.put("AtlantisWar\\atlantis.war", "/tmp/atlantis.war");
	         log.info("atlantis.war uploaded succesfully in to the remote server.");
	         if(properties.getProperty("OLD_WAR_PATH").isEmpty())
	         {
	        	 log.info("OLD_WAR_PATH=NULL\nUnable to download the old atlantis.war");
	         }
	         else
	         {	 old_War_Path=properties.getProperty("OLD_WAR_PATH");
	         	 log.info("Downloading old atlantis.war from remote server..............");
	        	 //sftpChannel.get(old_War_Path+"/webapps/atlantis.war", "OLD-WAR\\atlantis.war");
	        	 sftpChannel.get(old_War_Path+"/webapps/atlantis.war", "D:\\My Workspace\\Python-Workspace\\OLD-WAR\\atlantis.war");
	        	 log.info("Old atlantis.war download succesfully from remote server.");
	         }
	         ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
	         InputStream in = channelExec.getInputStream();
	         channelExec.setCommand(scriptFileName);
	         log.info("Executing SH File");
	         //channelExec.setCommand("/root/bin/deployment.sh");
	         channelExec.connect();
	         BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	         String line;
	         	while ((line = reader.readLine()) != null)
	         		{
	         			result.add(line);
	         		}
	         int exitStatus = channelExec.getExitStatus();
	         channelExec.disconnect();
	         session.disconnect();
	         	if(exitStatus < 0)
	         		{
	         			System.out.println("Done, but exit status not set!");
	         			log.info("War Replacement/Pojo Deletion/Log File backup completed successfully."+"\n"+"Deployment completed succesfully"+"\n"+"Tomcat is up now with the new WAR, but exit status not set!");
	         		}
	         	else if(exitStatus > 0)
	         		{
	         			System.out.println("Done, but with error!");
	         			log.info("War Replacement/Pojo Deletion/Log File backup completed successfully."+"\n"+"Deployment completed succesfully"+"\n"+"Tomcat is up now with the new WAR, but with error!");
	         		}
	         	else
	         		{
	         			System.out.println("Done!");
	         			log.info("War Replacement/Pojo Deletion/Log File backup completed successfully."+"\n"+"Deployment completed succesfully"+"\n"+"Tomcat is up now with the new WAR.");
	         		}
	         
	     	}
	     catch(Exception e)
	     	{
	         System.err.println("Error: " + e);
	         log.debug("Error: "+e+"\nUnable to replace atlantis.war!!");
	     	}
	     finally
	     	{
	    	 if(session!=null)
	    	 {
	    		 System.out.println(session);
	    		 session.disconnect();
	    		 session=null;
	    		 System.out.println(session);
	    	 }
	     	}
	     }
	     else if(status==true && is_War_Replace.equalsIgnoreCase("false") && is_Tomcat_Restart.equalsIgnoreCase("true"))
	     {
	    	 try{
		    	 JSch jsch = new JSch();
		    	 System.out.println(hostUserName+hostPassword+host);
		         session = jsch.getSession(hostUserName, host, port);
		         log.info("Host= "+host +"\n"+"Host_UserName= "+hostUserName+"\n"+"Host_Password= "+hostPassword);
		         session.setConfig("StrictHostKeyChecking", "no");
		         session.setPassword(hostPassword);
		         session.connect();
		         log.info("Host Connected");
		         ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
		         InputStream in = channelExec.getInputStream();
		         channelExec.setCommand(scriptFileName);
		         log.info("Executing SH File");
		         //channelExec.setCommand("/root/bin/deployment.sh");
		         channelExec.connect();
		         BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		         String line;
		         	while ((line = reader.readLine()) != null)
		         		{
		         			result.add(line);
		         		}
		         int exitStatus = channelExec.getExitStatus();
		         channelExec.disconnect();
		         session.disconnect();
		         	if(exitStatus < 0)
		         		{
		         			System.out.println("Done, but exit status not set!");
		         			log.info("Tomcat restart done succesfully"+"\n"+"Tomcat is up now, but exit status not set!");
		         		}
		         	else if(exitStatus > 0)
		         		{
		         			System.out.println("Done, but with error!");
		         			log.info("Tomcat restart done succesfully"+"\n"+"Tomcat is up now, but with error!");
		         		}
		         	else
		         		{
		         			System.out.println("Done!");
		         			log.info("Tomcat restart done succesfully"+"\n"+"Tomcat is up now.");
		         		}
		         
		     	}
		     catch(Exception e)
		     	{
		         System.err.println("Error: " + e);
		         log.debug("Error: "+e+"\nUnable to restart Tomcat!!");
		     	}
		     finally
		     	{
		    	 if(session!=null)
		    	 {
		    		 System.out.println(session);
		    		 session.disconnect();
		    		 session=null;
		    		 System.out.println(session);
		    	 }
		     	}
	    	 
	     }
	     else
	     {
	    	 if(status==true && is_War_Replace.equalsIgnoreCase("false") && is_Tomcat_Restart.equalsIgnoreCase("false"))
	    	 {
	    	 log.info("SQL Query deployed successfully.\nWAR not replaced & Tomcat not restarted, \"WAR_REPLACE=False & TOMCAT_RESTART=False\" ");
	    	 }
	    	 else if(status==true && is_War_Replace.equalsIgnoreCase("true") && is_Tomcat_Restart.equalsIgnoreCase("true"))
	    	 {
	    	 log.info("In Input.Properties File \"WAR_REPLACE=True & TOMCAT_RESTART=True\" both parameters are TRUE!! This is a wrong configuaration. Any one of it should be FALSE!!");
	    	 }
	    	 else
	    	 {
	    	 log.debug("Exception occures during SQL Script execution!!\n Please check the REPORT.CSV file for details!!");	 
	    	 }
	     }
	     return result;
	 }
	
}
