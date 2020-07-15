/*
 * Author : Aditya Roy
 * Description : It will launch the application for Protractor Test Execution
 * Date : 20/03/2020
 */

package pat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


@SuppressWarnings("serial")
public class LaunchApplication extends JFrame implements ItemListener, ActionListener
{
	 protected static JLabel lblSelectCase;
	 protected static JLabel lblSelectMsg;
	 protected static JLabel lblHeader;
	 protected static JLabel lblTC_PathMsg;
	 protected static JLabel lblTC_UploadPathMsg;
	 protected static JLabel lblSelectedCase;
	 protected static JLabel lblborder1;
	 protected static JLabel lblMovingText;
	 protected static JComboBox<?> selectCaseddl;
	 protected static JFrame frameProtractor;
	 protected static JTextField inputPath; 
	 protected static JButton btnSetTC_Dir; 
	 protected static JButton btnUploadDir; 
	 protected static JButton btnRun;
	 protected static JButton btnGenerateData;
	 protected static JButton btnLogs;
	 protected static JButton btnCheckLog;
	 protected static JButton btnTooltip;
	 protected static JFileChooser chooser;

	//Launch the application.
	public static void main(String[] args) 
	{
		try 
		{
			
			LaunchApplication.initialize();
			
		} 
		catch (Exception e) {e.printStackTrace();}
	}

	//Initialize the contents of the frame.
	private static void initialize() throws IOException 
	{	
		URL tooltipIcon = LaunchApplication.class.getResource("/resources/tooltip.png");
		URL runIcon = LaunchApplication.class.getResource("/resources/run.png");
		URL checkLogIcon = LaunchApplication.class.getResource("/resources/checkLog.png");
		URL updateDataIcon = LaunchApplication.class.getResource("/resources/updateData.png");
		URL uplaodPathIcon = LaunchApplication.class.getResource("/resources/uploadPath.png");		
		URL updatePathIcon = LaunchApplication.class.getResource("/resources/updatePath.png");
		
		frameProtractor = new JFrame();
		frameProtractor.setType(Type.POPUP);
		frameProtractor.setResizable(false);
		frameProtractor.getContentPane().setBackground(Color.BLACK);
		frameProtractor.setTitle("ProtractorJS Test Automation Execution Tool");
		frameProtractor.setAlwaysOnTop(false);
		frameProtractor.setBounds(500,200,550,400);
		frameProtractor.getContentPane().setLayout(null);
		frameProtractor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//show message which path input by user
		lblTC_PathMsg = new JLabel(""); 
		lblTC_PathMsg.setBounds(191, 145, 285 ,24);
		lblTC_PathMsg.setFont(new Font("Cambria", Font.BOLD, 13));
		frameProtractor.getContentPane().add(lblTC_PathMsg);
		
		//show message which path selected from browser window popup
		lblTC_UploadPathMsg = new JLabel(""); 
		lblTC_UploadPathMsg.setBounds(191, 185, 285 ,24);
		lblTC_UploadPathMsg.setFont(new Font("Cambria", Font.BOLD, 13));
		frameProtractor.getContentPane().add(lblTC_UploadPathMsg);
		
		
		//Select TestScript location
		lblSelectCase = new JLabel("Enter Test Path");
		lblSelectCase.setBounds(62, 105 , 119 , 29);
		lblSelectCase.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSelectCase.setForeground(Color.WHITE);
		frameProtractor.getContentPane().add(lblSelectCase);
		
		
		//user give input where scripts are located
		inputPath = new JTextField("Please set your Test Script path", 16); 
		inputPath.setBounds(191, 105, 285, 24);
		inputPath.setFont(new Font("Cambria", Font.BOLD, 12));
		inputPath.setForeground(Color.BLACK);
		frameProtractor.getContentPane().add(inputPath);
		

	 	//create a set script directory button, click on it it will update the directory
		btnSetTC_Dir = new JButton(new ImageIcon(updatePathIcon));
		btnSetTC_Dir.setBounds(62, 140, 108, 30);
		btnSetTC_Dir.setForeground(Color.BLACK);
		//btnSetTC_Dir.setBackground(Color.WHITE);
		btnSetTC_Dir.addActionListener(new LaunchApplication()); 
		frameProtractor.getContentPane().add(btnSetTC_Dir);
		
	 	//click on it, it will open windows browse
		btnUploadDir = new JButton(new ImageIcon(uplaodPathIcon));
		btnUploadDir.setBounds(62, 185, 108, 30);
		btnUploadDir.setForeground(Color.BLACK);
		//btnUploadDir.setBackground(Color.WHITE);
		btnUploadDir.addActionListener(new LaunchApplication()); 
		frameProtractor.getContentPane().add(btnUploadDir);
		
	 	//click on it, it will Execute the Test
		btnRun = new JButton(new ImageIcon(runIcon));
		btnRun.setActionCommand("Run Script");
		btnRun.setBounds(233, 295, 110, 40);
		btnRun.setForeground(Color.BLACK);
		btnRun.addActionListener(new LaunchApplication()); 
		frameProtractor.getContentPane().add(btnRun);

	 	//click on it, it will generate the test data
		btnGenerateData = new JButton(new ImageIcon(updateDataIcon));
		btnGenerateData.setActionCommand("Generate Data");
		btnGenerateData.setBounds(62, 295, 110, 40);
		btnGenerateData.setForeground(Color.BLACK);
		btnGenerateData.addActionListener(new LaunchApplication()); 
		frameProtractor.getContentPane().add(btnGenerateData);		
		
		//tooltip button, show additional configuration information
		btnTooltip = new JButton(new ImageIcon(tooltipIcon));
		btnTooltip.setBounds(5,337,28,28);
		btnTooltip.setBorderPainted(false);
		btnTooltip.setForeground(Color.BLACK);
		btnTooltip.setToolTipText(Tooltip.getMessage());
		frameProtractor.getContentPane().add(btnTooltip);	
		
	 	//click on it, it will show you the logs
		btnCheckLog = new JButton(new ImageIcon(checkLogIcon));
		btnCheckLog.setActionCommand("Check Log");
		btnCheckLog.setBounds(400, 295, 110, 40);
		btnCheckLog.setForeground(Color.BLACK);
		btnCheckLog.addActionListener(new LaunchApplication()); 
		frameProtractor.getContentPane().add(btnCheckLog);
		
		
		//Title Header
		lblHeader = new JLabel("RBS  ProtractorJS  Test  Execution  Tool");
		lblHeader.setBounds(95,27,360,29);
		lblHeader.setFont(new Font("Cambria", Font.BOLD, 20));
		lblHeader.setForeground(Color.WHITE);
		frameProtractor.getContentPane().add(lblHeader);
		
		//add Moving Text
		lblMovingText = new JLabel("Welcome to Script Runner ! Set the Test Directory & Click 'Update path' or Direct Click on 'Upload Path'."
								   + "                                                                         ");
		lblMovingText.setBounds(50,60,450,29);
		lblMovingText.setFont(new Font("Cambria",Font.PLAIN,12));
		lblMovingText.setForeground(Color.GREEN);
		frameProtractor.getContentPane().add(lblMovingText,BorderLayout.NORTH);
		Timer t = new Timer(120, new LaunchApplication()); // set a timer
	    t.start();
		
		//header- border
		lblborder1 = new JLabel("________________________________________________________________");
		lblborder1.setBounds(50,67,450,29);
		lblborder1.setFont(new Font("Cambria",Font.PLAIN,20));
		lblborder1.setForeground(Color.YELLOW);
		frameProtractor.getContentPane().add(lblborder1);
		
		
		//Select Case from drop-down
		lblSelectCase = new JLabel("Select Test Case");
		lblSelectCase.setBounds(62, 222 , 119 , 29);
		lblSelectCase.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSelectCase.setForeground(Color.WHITE);
		frameProtractor.getContentPane().add(lblSelectCase);
		
		//Select Case from drop-down
		lblSelectedCase = new JLabel("Script to Execute");
		lblSelectedCase.setBounds(62, 250 , 119 , 29);
		lblSelectedCase.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSelectedCase.setForeground(Color.WHITE);
		frameProtractor.getContentPane().add(lblSelectedCase);
		
		
		//Select TestCase DropDown
		selectCaseddl = new JComboBox<String>(getFileContents(inputPath));
		selectCaseddl.setBackground(SystemColor.WHITE);
		selectCaseddl.setMaximumRowCount(30);
		selectCaseddl.setBounds(191, 222, 285, 24);
		selectCaseddl.addItemListener(new LaunchApplication());
		frameProtractor.getContentPane().add(selectCaseddl);
		frameProtractor.setForeground(Color.BLACK);
		frameProtractor.setBackground(Color.YELLOW);
		
		
		//post select DropDown message
		lblSelectMsg = new JLabel("");
		lblSelectMsg.setBounds(191, 250, 285 ,29);
		lblSelectMsg.setFont(new Font("Cambria", Font.BOLD, 13));
		frameProtractor.getContentPane().add(lblSelectMsg);
		
		frameProtractor.setVisible(true);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent selectDropdown) 
	  { 
	      // if the state of drop-down changed 
	      if (selectDropdown.getSource() == selectCaseddl) 
	      { 
	    	  if(selectCaseddl.getSelectedItem().toString().length()<1)
	    	  {
	    		  lblSelectMsg.setForeground(Color.RED);
	    		  lblSelectMsg.setText("Please Select Test Case From Dropdown");  
	    		  
	    	  }
	    	  else
	    	  {
	    		  lblSelectMsg.setForeground(Color.GREEN);
	    		  lblSelectMsg.setText((String) selectCaseddl.getSelectedItem()); 
	    		  try {UpdateConfigFile.updateSpecInConfigFile(selectCaseddl.getSelectedItem().toString().trim());}
	    		  catch (IOException e) {e.printStackTrace();}
	    	  }
	      } 
	 }

	//action performed for updating the path in text field and also the moving banner when no action performed
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void actionPerformed(ActionEvent e) 
	{ 
		if(e.getActionCommand() == null)
		{
		      String oldText = lblMovingText.getText();
		      String newText= oldText.substring(1)+ oldText.substring(0,1);
		      lblMovingText.setText(newText);
		}
		else 
		if (e.getActionCommand().equals("Update Path")) 
		{  
			try 
			{
				if(inputPath.getText().equals("") || inputPath.getText().equals(" ") ||inputPath.getText().equalsIgnoreCase("Please set your Test Script path"))
				{
					lblTC_PathMsg.setForeground(Color.RED);
					lblTC_PathMsg.setText("Please try again with valid Test Case location");
					lblTC_UploadPathMsg.setText("");
					//disposeFrame(frameProtractor);
				}
				else
				{
					selectCaseddl.setModel(new DefaultComboBoxModel(getFileContents(inputPath)));
					lblTC_PathMsg.setForeground(Color.GREEN);
					lblTC_PathMsg.setText("Path updated : "+inputPath.getText());
					lblTC_UploadPathMsg.setText("");
				}
			} 
			catch (IOException e1) {e1.printStackTrace();}
			inputPath.setText(" "); 
		}
		else
		if (e.getActionCommand().equals("Upload Path")) 
		{  
			try {	
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				    chooser = new JFileChooser();
				    chooser.updateUI();
				    chooser.setCurrentDirectory(new java.io.File("."));
				    chooser.setDialogTitle("Select your Protractor test script location");
				    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				    chooser.setAcceptAllFileFilterUsed(false);
				    UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
				    refreshUI(chooser, false);
				    	
				    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
				    {
				    	JOptionPane.showMessageDialog(chooser,"Selected Test Location - "+chooser.getSelectedFile(),"Success",JOptionPane.INFORMATION_MESSAGE);
				    	lblTC_UploadPathMsg.setForeground(Color.GREEN);
				    	lblTC_UploadPathMsg.setText("Selected Path : "+chooser.getSelectedFile().toString().trim());
				    	lblTC_PathMsg.setText("");
					    
				    	//updating the dropdown with file name under directory
					    selectCaseddl.setModel(new DefaultComboBoxModel(getFileContents(chooser)));
				    } 
				    else
				    {
				    	JOptionPane.showMessageDialog(chooser,"No Directory Selected","Please Select Path",JOptionPane.WARNING_MESSAGE);
				    	lblTC_UploadPathMsg.setForeground(Color.RED);
				    	lblTC_UploadPathMsg.setText("No Directory Selected");
				    	lblTC_PathMsg.setText("");
				    }
				    
			} 
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException | IOException e1) 
			{
				e1.printStackTrace();
			}

		}
		else 
		if (e.getActionCommand().equals("Run Script"))
			{
				try {
						RunJSFile.runProtractorScript();
					}
				catch (IOException e1) {e1.printStackTrace();}
			}
		else
		if (e.getActionCommand().equals("Check Log"))
		{
			try {
					CheckLog.viewLog();
				}
			catch (IOException e1) {e1.printStackTrace();}
		}
		else
		if (e.getActionCommand().equals("Generate Data"))
		{
			try {
					GenerateData.createKJSONData();
				}
			catch (IOException | InterruptedException e1) {e1.printStackTrace();}
		}
	} 

	//get the path from inputPath field and store into an array
	public static Vector<String> getFileContents(JFileChooser c) throws IOException 
	{
		Path path = Paths.get(chooser.getSelectedFile().toString().trim());
		Vector<String> filesPaths = new Vector<>();
		if(Files.isDirectory(path)) 
		{
			filesPaths.add("");
			Files.list(path)
				 .filter(Files::isRegularFile)
				 .map(file->file.getFileName().toString())
				 .forEach(filesPaths::add);
		}
		return filesPaths;
	}
	
	//get the path from browse folder screen and store the files into an array
	public static Vector<String> getFileContents(JTextField t) throws IOException 
	{
		Path path = Paths.get(inputPath.getText().toString().trim());
		Vector<String> filesPaths = new Vector<>();
		if(Files.isDirectory(path)) 
		{
			filesPaths.add("");
			Files.list(path)
				 .filter(Files::isRegularFile)
				 .map(file->file.getFileName().toString())
				 .forEach(filesPaths::add);
		}
		return filesPaths;
	}
	
	//dispose the frame or closing it
	public void disposeFrame(JFrame frame)
	{
		frame.setVisible(false);
		frame.dispose();
	}

	//Refresh UI for UPload Path window dialog
	private static void refreshUI(JComponent c, boolean includeParent)
	  {
	      if (includeParent)
	          c.updateUI();

	      for (int i = 0; i < c.getComponentCount(); i++)
	      {
	          Component child = c.getComponent(i);
	          if (child instanceof JComponent)
	          {
	              refreshUI((JComponent)child, true);
	          }
	      }
	  }
}
