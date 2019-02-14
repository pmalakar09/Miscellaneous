package onmobile.atlantis.ps.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import org.apache.oro.text.regex.MalformedPatternException;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import expect4j.Closure;
import expect4j.Expect4j;
import expect4j.ExpectState;
import expect4j.matches.Match;
import expect4j.matches.RegExpMatch;

public class Model {
 
    private static final int COMMAND_EXECUTION_SUCCESS_OPCODE = -2;
    private static String ENTER_CHARACTER = "\r";
    private static final int SSH_PORT = 22;
    private List<String> lstCmds = new ArrayList<String>();
    private static String[] linuxPromptRegEx = new String[]{"\\>","#", "~#"};
 
    private Expect4j expect = null;
    private StringBuilder buffer = new StringBuilder();
    private String userName;
    private String password;
    private String host;
 
    /**
     *
     * @prasenjit host
     * @prasenjit userName
     * @prasenjit password
     */
    public Model(String host, String userName, String password) {
        this.host = host;
        this.userName = userName;
        this.password = password;
    }
    /**
     *
     * @prasenjit cmdsToExecute
     */
    public String execute(List<String> cmdsToExecute) {
        this.lstCmds = cmdsToExecute;
 
        Closure closure = new Closure() {
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
    /**
     *
     * @prasenjit objPattern
     * @prasenjit strCommandPattern
     * @return
     */
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
    /**
     *
     * @prasenjit hostname
     * @prasenjit username
     * @prasenjit password
     * @prasenjit port
     * @return
     * @throws Exception
     */
    private Expect4j SSH() throws Exception {
        JSch jsch = new JSch();
        Session session = jsch.getSession(userName, host, SSH_PORT);
        if (password != null) {
            session.setPassword(password);
        }
        Hashtable<String,String> config = new Hashtable<String,String>();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect(60000);
        ChannelShell channel = (ChannelShell) session.openChannel("shell");
        Expect4j expect = new Expect4j(channel.getInputStream(), channel.getOutputStream());
        channel.connect();
        return expect;
    }
    /**
     *
     * @prasenjit intRetVal
     * @return
     */
    private boolean checkResult(int intRetVal) {
        if (intRetVal == COMMAND_EXECUTION_SUCCESS_OPCODE) {
            return true;
        }
        return false;
    }
    /**
     *
     */
    private void closeConnection() {
        if (expect!=null) {
            expect.close();
        }
    }
    /**
     *
     * @prasenjit args
     */
    public static void main(String[] args) {
        Model ssh = new Model ("10.155.10.95", "root", "password");
        List<String> cmdsToExecute = new ArrayList<String>();
        cmdsToExecute.add("pwd");
       // cmdsToExecute.add("ps aux |grep tomcat |grep -v grep |cut -d\"=\" -f7 |cut -d\" \" -f1");
        cmdsToExecute.add("ps -ef | grep -i tomcat");
        String outputLog = ssh.execute(cmdsToExecute);
        System.out.println(outputLog);
        
        GetPid objpid = new GetPid();
        StringBuffer sb = new StringBuffer("kill -9 ");
        sb.append(objpid.setPid());
        String killfull=sb.toString();
        List<String> cmdToKill = new ArrayList<String>();
        cmdToKill.add(killfull);
        System.out.println(cmdToKill);
        ssh.execute(cmdToKill);
        System.out.println("Tomcat Killed");
        
    }
}
class GetPid
{
	  int setPid()
	    {
	    	int pid=0;
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("Please Enter The Tomcat PID To Kill The Process: ");
	    	pid=sc.nextInt();
	    	sc.close();
			return pid;
	    	
	    }
}