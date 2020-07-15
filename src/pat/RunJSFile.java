/*
 * Author : Aditya Roy
 * Description : To run the Protractor.config.js file at Project> Configuration location via cmd
 * Date : 20/03/2020
 */

package pat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RunJSFile 
{
	
	public static void runProtractorScript()  throws IOException
	{
		String filePath = UpdateConfigFile.filePath;
        int index= filePath.lastIndexOf("/");
        String fileDirName = filePath.substring(0, index);

        //executing the 'protractor.config.js' via command prompt
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "pushd \""+fileDirName+"\" && protractor protractor.config.js");
	        		   builder.redirectErrorStream(true);
	    Process p = builder.start();
	    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    PrintWriter out = new PrintWriter(new FileWriter(new File(fileDirName+"/output.log")));
	    String line; 
	    while (true) 
	    {
		    
	        line = r.readLine();
	        if (line == null) { break; }
	        //storing the logs
	        out.println(line);
	    }   
	    out.close();
    }
}
