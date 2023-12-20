package com.other.files;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class SwingExample implements ActionListener
{
	 JFrame frame=new JFrame();
	 JButton button=new JButton("Click Me");
	    
	 SwingExample()
	 {
		 prepareGUI();
	 }
	public static void main(String[] args)
	{
		new SwingExample();
		/*JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);
        File currentDirectory = f.getCurrentDirectory();
        
        List<File> files = findDirectoriesWithSameName("CVS", currentDirectory);
    	
		for (File file : files)
		{
			deleteDir(file);
		}
		
		System.out.println("deletion done ...............");*/
		
	}
	
	private void prepareGUI()
	{
		JFileChooser f = new JFileChooser();
		 f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	        f.showSaveDialog(null);
	        
		frame.setTitle("Select Folder");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(200,200,400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        button.setBounds(130,200,100,40);
       // frame.add(button);
        frame.add(f);
        f.addActionListener(this);
       // button.addActionListener(this);
	}
	private static void jFrameGUI()
	{
		//jframe
		JFrame frame = new JFrame("Folder deletion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		//Adding panel
		JPanel panel = new JPanel();
        JLabel label = new JLabel("Select Folder");
        panel.add(label);
		//Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
        
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println(e.getActionCommand());
	}
}
