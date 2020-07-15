/*
 * Author : Aditya Roy
 * Description : It will open the log for user read
 * Date : 20/03/2020
 */
package pat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckLog {

	protected static JFrame jf = new JFrame();
	public static void viewLog() throws IOException 
	{
		String filePath = UpdateConfigFile.filePath;
        int index= filePath.lastIndexOf("/");
        String fileDirName = filePath.substring(0, index);
		
        FileInputStream fstream = new FileInputStream(fileDirName+"/output.log");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			   
		String line = br.readLine(); 
		StringBuilder sb = new StringBuilder(); 
		while(line != null)
		   { 
			   sb.append(line).append("\n"); 
			   line = br.readLine(); 
		   } 
		String fileAsString = sb.toString(); 
		JOptionPane.showMessageDialog(jf,fileAsString,"Script Log | Saved at Configuration/Output.log",JOptionPane.INFORMATION_MESSAGE);
		br.close();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.dispose();
	}

}
