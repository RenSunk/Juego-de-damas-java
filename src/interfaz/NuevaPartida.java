package interfaz;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.Damas;

public class NuevaPartida extends JFrame implements ActionListener{

	private Label rojas,negras,vs;
	
	private JButton boton1,boton2;
	
	private JComboBox<Object> combo1,combo2;
	
	private Principal principal;
	
	private PanelDeJuego panelDeJuego;
	
	public void iniciar() {
		
		boton1= new JButton("Comenzar Partida");
		boton1.setBounds(50,70,140,30);
		boton1.addActionListener(this);
		
		boton2= new JButton("Salir");
		boton2.setBounds(220,70,100,30);
		boton2.addActionListener(this);
		
		rojas = new Label("rojas");
		rojas.setBounds(120,10,30,20);
		negras = new Label("negras");
		negras.setBounds(230,10,35,20);
		vs = new Label("VS");
		vs.setBounds(185, 35, 30, 20);
		
		combo1 = new JComboBox<>();
		combo1.addItem("");
		combo1.addItem("Automatico");
		combo1.addItem("Manual");
		combo2 = new JComboBox<>();
		combo2.addItem("");
		combo2.addItem("Automatico");
		combo2.addItem("Manual");
		
		combo1.setBounds(100,35,70,20);
		combo2.setBounds(220,35,70,20);
	}
	
	public NuevaPartida(Principal Pprincipal,PanelDeJuego juego) {
		iniciar();
		principal = Pprincipal;
		panelDeJuego = juego;
		setLayout(null);
		getContentPane().add(rojas);
		getContentPane().add(negras);
		getContentPane().add(combo1);
		getContentPane().add(combo2);
		getContentPane().add(vs);
		getContentPane().add(boton1);
		getContentPane().add(boton2);
		setResizable(false);
		setSize(400,150);
		setLocationRelativeTo(principal);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public NuevaPartida() {
		
	}
	
	public void abrir() {
		
	}
	
	@SuppressWarnings("null")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			if(combo1.getSelectedIndex() == 0 || combo2.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(principal,"Los Campos No Pueden Estar Vacios");
			}else {
				principal.Actualizar_botones();
				panelDeJuego.cambiar(combo1.getSelectedIndex(), combo2.getSelectedIndex());
				dispose();
			}
		}else {
			dispose();
		}
		
	}
}
