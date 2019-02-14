package onmobile.atlantis.ps.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.oro.text.regex.MalformedPatternException;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import expect4j.Closure;
import expect4j.Expect4j;
import expect4j.ExpectState;
import expect4j.matches.Match;
import expect4j.matches.RegExpMatch;


public class Controller extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	    private static final int COMMAND_EXECUTION_SUCCESS_OPCODE = -2;
	    private static String ENTER_CHARACTER = "\r";
	    private static final int SSH_PORT = 22;
	    private List<String> lstCmds = new ArrayList<String>();
	    private static String[] linuxPromptRegEx = new String[]{"\\>","#", "~#"};
	 
	    private Expect4j expect = null;
	    private ChannelShell channel=null;
	    private StringBuilder buffer = new StringBuilder();
	    private String userName;
	    private String password;
	    private String host;
	    private Controller c=null;

    public void init()
     {
    	 try
	    	 {
	    	 JSch jsch = new JSch();
	         Session session = jsch.getSession(userName, host, SSH_PORT);
	         if (password != null) {
	             session.setPassword(password);
	         }
	         Hashtable<String,String> config = new Hashtable<String,String>();
	         config.put("StrictHostKeyChecking", "no");
	         session.setConfig(config);
	         session.connect(60000);
	         channel = (ChannelShell) session.openChannel("shell");
	    	 }
    	 catch(Exception e)
	    	 {
	    		 
	    	 }
     }
     public void service(HttpServletRequest req,HttpServletResponse res)
     {
        host=req.getParameter("HOST");
 	    password=req.getParameter("PASSWORD");
 		System.out.println(host);
 		System.out.println(password);
 		c.main(null);
 		/*List<String> cmdsToExecute = new ArrayList<String>();
        cmdsToExecute.add("pwd");
       // cmdsToExecute.add("ps aux |grep tomcat |grep -v grep |cut -d\"=\" -f7 |cut -d\" \" -f1");
        cmdsToExecute.add("ps -ef | grep -i tomcat");
       // String outputLog = ssh.execute(cmdsToExecute);
       // System.out.println(outputLog);*/
     }
     private Expect4j SSH() throws Exception 
     {
    	 Expect4j expect = new Expect4j(channel.getInputStream(), channel.getOutputStream());
         channel.connect();
         return expect;
     }
     public String execute(List<String> cmdsToExecute) 
     {
    	 this.lstCmds = cmdsToExecute;
    	 Closure closure = new Closure() 
    	 {
    		 public void run(ExpectState expectState) throws Exception {
                 buffer.append(expectState.getBuffer());
             }
         };
         List<Match> lstPattern =  new ArrayList<Match>();
         for (String regexElement : linuxPromptRegEx) {
             try {
                 Match mat = new RegExpMatch(regexElement, closure);
                 lstPattern.add(mat);
             } catch (MalformedPatternException e) {
                 e.printStackTrace();
             } catch(Exception e) {
                 e.printStackTrace();
             }
         }
  
         try {
             expect = SSH();
             boolean isSuccess = true;
             for(String strCmd : lstCmds) {
                 isSuccess = isSuccess(lstPattern,strCmd);
                 if (!isSuccess) {
                     isSuccess = isSuccess(lstPattern,strCmd);
                 }
             }
  
             checkResult(expect.expect(lstPattern));
         } catch (Exception ex) {
             ex.printStackTrace();
         } finally {
             closeConnection();
         }
        return buffer.toString();
     }
     private boolean isSuccess(List<Match> objPattern,String strCommandPattern) {
         try {
             boolean isFailed = checkResult(expect.expect(objPattern));
  
             if (!isFailed) {
                 expect.send(strCommandPattern);
                 expect.send(ENTER_CHARACTER);
                 return true;
             }
             return false;
         } catch (MalformedPatternException ex) {
             ex.printStackTrace();
             return false;
         } catch (Exception ex) {
             ex.printStackTrace();
             return false;
         }
     }
     private boolean checkResult(int intRetVal) {
         if (intRetVal == COMMAND_EXECUTION_SUCCESS_OPCODE) {
             return true;
         }
         return false;
     }
     private void closeConnection() {
         if (expect!=null) {
             expect.close();
         }
     }
    public void main(String args[])
    {    c=new Controller();
    	 List<String> cmdsToExecute = new ArrayList<String>();
         cmdsToExecute.add("pwd");
        // cmdsToExecute.add("ps aux |grep tomcat |grep -v grep |cut -d\"=\" -f7 |cut -d\" \" -f1");
         cmdsToExecute.add("ps -ef | grep -i tomcat");
         String outputLog = c.execute(cmdsToExecute);
         System.out.println(outputLog);
    }
}
