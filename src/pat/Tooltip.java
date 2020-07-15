/*
 * Author : Aditya Roy
 * Description : It will update tooptip with configuration message
 * Date : 20/03/2020
 */

package pat;

public class Tooltip {

	public static String getMessage()
	{
		return("<html>"
				+ "@Copyright - Aditya Roy<br><br>"
				+ "Configuration folder should have<br>"
				+ "  1) GenerateTestRunner.bat<br>"
				+ "  2) Protractor.config.js<br>"
				+ "  3) TestRunner.jar<br>"
				+ "  4) Script Output.log create here<br><br>"	
				+ "TestScript folder should have<br>"
				+ "  1) All Protractor JS Test Cases<br><br>"
				+ "TestData folder should have<br>"
				+ "  1) TestData.xls<br>"
				+ "<html>");
	}

}
