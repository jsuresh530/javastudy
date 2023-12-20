package com.other.files;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestingJavaCode extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 425618448024069585L;
	JLabel txtUser = new JLabel("Path: ");
	
	JPanel jPanel;
	JLabel userNameLabel, message;
	JTextField userName_txt;
	JButton submit;
	
    public TestingJavaCode() {	
    	//userlabel
    	userNameLabel =new JLabel("Enter Path");
    	userName_txt = new JTextField();
        
    	//submit
    	submit =new JButton("SUBMIT");
    	submit.setPreferredSize(new Dimension(40, 40));
    	
    	//panel code
    	jPanel =new JPanel(new GridLayout(2, 1));
    	
    	jPanel.add(userNameLabel);
    	jPanel.add(userName_txt);
        message = new JLabel();
        jPanel.add(message);
        jPanel.add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(jPanel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(300, 100);
        setVisible(true);
    }
    
    public static boolean deleteDir(File dir) {
	      if (dir.isDirectory()) {
	         String[] children = dir.list();
	         for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir (new File(dir, children[i]));
	            
	            if (!success) {
	               return false;
	            }
	         }
	      }
	      return dir.delete();
	   }
    
	//List all the files with folder....
	public static List<File> findDirectoriesWithSameName(String name, File root) {
		  List<File> result = new ArrayList<File>();

		  for (File file : root.listFiles()) {
		    if (file.isDirectory()) {
		      if (file.getName().equals(name)) {
		        result.add(file);
		      }
		      result.addAll(findDirectoriesWithSameName(name, file));
		    }
		  }

		  return result;
		}

    public static void main(String[] args) {
        new TestingJavaCode();
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getActionCommand());
		
		 /*JFileChooser fileChooser = new JFileChooser();
         int returnValue = fileChooser.showOpenDialog(null);
         if (returnValue == JFileChooser.APPROVE_OPTION) {
             File selectedFile = fileChooser.getSelectedFile();

            String keep = selectedFile.getAbsolutePath();
            
            System.out.println(keep);
         }*/
		String path = userName_txt.getText();
		
		List<File> files = findDirectoriesWithSameName("CVS", new File(path));
		
		for (File file : files)
		{
			deleteDir(file);
		}
		
		message.setText("<html> <font color='red'>CVS Dossiers enlevé.. </font></html>");
		
	}

}