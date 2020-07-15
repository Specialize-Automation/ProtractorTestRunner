/*
 * Author : Aditya Roy
 * Description : It will create the JSON file from EXCEL and place it to TestData folder
 * Date : 20/03/2020
 */

package pat;

import java.io.File;
import java.io.IOException;

public class GenerateData {

	public static void createKJSONData() throws IOException, InterruptedException 
	{

		String filePath = UpdateConfigFile.filePath;
        int index= filePath.lastIndexOf("/");
        String fileDirName = filePath.substring(0, index);
   
        //Executing the batch file through process Builder
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "Start", "GenerateTestData.bat");
        File dir = new File(fileDirName);
        pb.directory(dir);
        Process p = pb.start();
        		Thread.sleep(500);
        		p.destroy();
	}
}
