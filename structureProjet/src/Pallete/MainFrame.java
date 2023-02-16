package Pallete;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame  extends JFrame{
	private Dimension screensize =Toolkit.getDefaultToolkit().getScreenSize();
	private Container mainContainer;
	private JPanel menuPanel ;
	
	
	private void initPanels() {
		
		menuPanel = new  sideMenuPanel (Color.white, bgColor, Buttonsfont , buttonsnames);
	}
	
	
	
	public void initcontainer() {
		mainContainer = getContentPane();
		mainContainer.setBackground(bgColor);
		mainContainer.setLayout(new  );
		
	}
	
	
	public MainFrame(String title) {
		 public void setTitle(title);
		 setsize(screensize.width,screensize.height);
	
	}

}
