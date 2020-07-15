/*
 * Author : Aditya Roy
 * Description : It will update the Protractor.config.js with the Script Name passing as a parameter
 * Date : 20/03/2020
 */

package pat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateConfigFile
{
	public static String filePath = "./Protractor.config.js";
	
	public static void updateSpecInConfigFile(String scriptName) throws IOException 
	{	
		  //place the Executable JAR in the same location of Protractor.config.js
	      //String filePath = "./Protractor.config.js/";
	      Scanner sc = new Scanner(new File(filePath));
	      StringBuffer buffer = new StringBuffer();
		      while (sc.hasNextLine()) 
		      {
		         buffer.append(sc.nextLine()+System.lineSeparator());
		      }
	      String fileContents = buffer.toString();
	      sc.close();
	      
	      //using regex-check to find the spec line and update with new testScript from drop down
	      String oldLine = "specs:\\[\\'\\.\\.\\/TestScript\\/.*";
	      String newLine = "specs:['../TestScript/"+scriptName+"'],";
	      
	      
	      //replace and update the file with new script configuration
	      fileContents = fileContents.replaceAll(oldLine, newLine);
	      FileWriter writer = new FileWriter(filePath);
	                 writer.append(fileContents);
	      			 writer.flush();
	      			 writer.close();
	      
	       //System.out.println("");
	       //System.out.println(fileContents);    
	   }
}