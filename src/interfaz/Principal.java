package interfaz;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame{
	
	PanelDeJuego juego;
	
	PanelBarraDeHerramientas panel1;
	
	PanelImagen imagen;
	
	public Principal() {
		super("Damas");
		iniciar();
		alinear();
		setVisible(true);
		setResizable(false);
		//setSize(685,531);
		setSize(480,520);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void alinear() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("Informacion")));
		panel.add(imagen);
		
		setLayout(new BorderLayout());
		add(juego, BorderLayout.CENTER);
		add(panel1, BorderLayout.NORTH);
	//	add(panel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		new Principal();
	}
	
	public void Actualizar_botones() {
		juego.ResetearTablero();
		juego.dibujar_en_los_botones();
	}
	
	public void iniciar() {
		juego = new PanelDeJuego();
		panel1 = new PanelBarraDeHerramientas(this,juego);
		imagen = new PanelImagen();
	}
}
