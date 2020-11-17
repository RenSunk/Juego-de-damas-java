package interfaz;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AcercaDe extends JFrame {

	private Principal principal;
	
	private JLabel label1,label2,label3;
	
	private JTextArea area;
	
	private JScrollPane panel;
	
	private Hipervinculo label4,label5;
	
	public AcercaDe(Principal Pprincipal) {
		principal = Pprincipal;
		iniciar();
		alinear();
		setSize(500,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(principal);
	}
	
	public void alinear() {
		setLayout(null);
		label1.setBounds(160,0,500,50);
		getContentPane().add(label1);
		label2.setBounds(0,250,500,50);
		getContentPane().add(label2);
		label3.setBounds(150,250,500,50);
		getContentPane().add(label3);
		label4.setBounds(220,265,500,20);
		getContentPane().add(label4);
		label5.setBounds(220,285,500,20);
		getContentPane().add(label5);
		panel.setBounds(0,50,485,200);
		getContentPane().add(panel);
	}
	
	public void iniciar() {
		label1 = new JLabel("Juego De Damas");
		label1.setFont(new Font("1942 report", Font.CENTER_BASELINE, 18));
		label2 = new JLabel("Version 2.2");
		label2.setFont(new Font("1942 report", Font.CENTER_BASELINE, 13));
		label3 = new JLabel("Fuentes:");
		label2.setFont(new Font("1942 report", Font.CENTER_BASELINE, 13));
		label4 = new Hipervinculo("Canal De Youtube Del Creador", "https://www.youtube.com/channel/UCNpwCkuVJjeDF-kID0-zCLQ?view_as=subscriber");
		label5 = new Hipervinculo("Pagina De La Universidad Santiago De Cali", "http://usc.edu.co/");
		area = new JTextArea();
		area.setEditable(false);
		area.setText("Proyecto Personal, Recreando el popular juego de damas en el entorno de desarrollo java, \nHecho por: Kevin Rodrigo Guerrero Posso \nEstudiante De: "
				+ "Ingeniería En Sistemas Cursando cuarto Semestre en la Universidad Santiago De Cali\nEl Programa aun está en fase beta ya que aun no tiene implementadas \n"
				+ "algunas reglas básicas del juego de damas original, los movimientos de las damas se hacen en diagonal,\n"
				+ "si vas a eliminar a una ficha enemiga simplemente le pasas por encima\n"
				+ "Imágenes Pertenecientes a: Freddy González\n"
				+ "modos de juegos: Pc vs Pc, Manual vs Pc y Manual vs Manual\n\n"
				+ "Proyecto hecho de estudiante para estudiantes\n"
				+ "publicado el 27 de Noviembre de 2018");
		panel = new JScrollPane(area);
	}
	
}
