package interfaz;

import java.awt.BorderLayout;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class PanelBarraDeHerramientas extends JPanel implements ActionListener{

	private JMenu menu;
	
	private JMenu menu1;
	
	private JMenuBar barra;
	
	private JMenuItem nuevapartida,salir,acerca,cambiar_modo;
	
	private Principal principal;
	
	private PanelDeJuego panelDeJuego;
	
	private void iniciar() {
		nuevapartida = new JMenuItem("Nueva partida");
		cambiar_modo = new JMenuItem("Cambiar Modo");
		salir = new JMenuItem("Salir");
		acerca = new JMenuItem("Acerca de...");
		menu = new JMenu("Archivo");
		menu1 = new JMenu("Ayuda");
		menu.add(nuevapartida);
		menu1.add(acerca);
		menu.add(cambiar_modo);
		menu.add(salir);
		cambiar_modo.addActionListener(this);
		nuevapartida.addActionListener(this);
		salir.addActionListener(this);
		acerca.addActionListener(this);
		barra = new JMenuBar();
		barra.add(menu);
		barra.add(menu1);
	}
	
	private void alinear() {
		setLayout(new BorderLayout());
		add(barra,BorderLayout.CENTER);
	}
	
	public PanelBarraDeHerramientas(Principal Pprincipal,PanelDeJuego juego) {
		iniciar();
		alinear();
		panelDeJuego = juego;
		principal = Pprincipal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nuevapartida) {
			new NuevaPartida(principal,panelDeJuego).abrir();
		}
		if(e.getSource() == salir) {
			principal.dispose();
		}
		if(e.getSource() == acerca) {
			new AcercaDe(principal);
		}
		if(e.getSource() == cambiar_modo) {
			new Seleccion_de_modo(principal,panelDeJuego).abrir();;
		}
	}
}
