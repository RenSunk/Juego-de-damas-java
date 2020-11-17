package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Hipervinculo extends JLabel implements MouseListener {

	private String url;
	
	public Hipervinculo(String Texto,String url) {
		this.url=url;
		setText("<html><a href=" + "" + ">"+Texto+"</a></html>");
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					desktop.browse(
							new URI(url));
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
