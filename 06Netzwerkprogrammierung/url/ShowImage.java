package url;

import java.awt.*;

import javax.swing.JPanel;


public class ShowImage extends JPanel{
	Image im;
	
	public ShowImage(Image im){
		this.im = im;
	}
	
	protected void paintComponent( Graphics g ){
		super.paintComponent( g );

	    g.drawImage(im, 0, 0, this);
	}

	
}
