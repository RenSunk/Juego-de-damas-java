package mundo;

/* Kevin Rodrigo Guerrero Posso
 * esta madre fue un parcial
 */
import javax.swing.JOptionPane;

public class Damas {

	private int tabla[][];
	private final int rojas = 1, negras = 2, reinaR = 3, reinaN = 4, relleno = 5;
	private char color = 'N';
	
	public char getColor() {
		return color;
	}
	public int getRelleno() {
		return relleno;
	}
	public int getRojas() {
		return rojas;
	}
	public int getNegras() {
		return negras;
	}
	public int getReinaR() {
		return reinaR;
	}
	public int getReinaN() {
		return reinaN;
	}
	
	public void CambioDeTurno() {
		if(color == 'R') {
			color = 'N';
		}else {
			color = 'R';
		}
	}
	
	public Damas() {
		tabla = new int[8][8];
	}

	public int verdamas(int i,int j) {
		posibilidad_reina();
		return tabla[i][j];
	}
	
	public void poner_fichas() {	
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (j % 2 == 0) {
					tabla[1][j] = rojas;
					tabla[7][j] = negras;
					tabla[5][j] = relleno;
					tabla[3][j] = relleno;
				} else {
					tabla[0][j] = rojas;
					tabla[6][j] = negras;
					tabla[2][j] = relleno;
					tabla[4][j] = relleno;
				}
			}
		}
	}

	
	public boolean verificar_exitencia_de_ficha(char color, int x,int y) {
		if(color == 'N') {
			if(tabla[x][y] == negras || tabla[x][y] == reinaN) {
				return true;
			}
		}else if(color == 'R'){
			if(tabla[x][y] == rojas || tabla[x][y] == reinaR) {
				return true;
			}
		}
		return false;
	}
	
	
	public void imprimir(int contadorN, int contadorR, char color) {
//		System.out.println();
//		for (int i = 0; i < tabla.length; i++) {
//			System.out.println("----------------------------------------");
//			for (int j = 0; j < tabla[0].length; j++) {
//				if (tabla[i][j] == rojas) {
//					System.out.print(" R  |");
//				} else if (tabla[i][j] == negras) {
//					System.out.print(" N  |");
//				} else if (tabla[i][j] == reinaR) {
//					System.out.print(" RR |");
//				} else if (tabla[i][j] == reinaN) {
//					System.out.print(" RN |");
//				} else if (tabla[i][j] == 5) {
//					System.out.print("----|");
//				} else if (i == 4 && j == 7) {
//					System.out.print("    | Negras:");
//				} else if (i == 5 && j == 7) {
//					System.out.print("    | Rojas:");
//				} else if (i == 3 && j == 7 && color == 'R') {
//					System.out.print("    | Rojas");
//				} else if (i == 3 && j == 7 && color == 'N') {
//					System.out.print("    | Negras");
//				} else {
//					System.out.print("    |");
//				}
//				if (i == 2 && j == 7) {
//					System.out.print(" Turno De:");
//				}
//			}
//
//			System.out.println();
//		}
	}

	public void buscar_ficha(int i,int j) {
		if(tabla[i][j] == getNegras()) {
			System.out.println("negra");
		}else if(tabla[i][j] == getRojas()){
			System.out.println("roja");
		}
	}
	
	public void mostrartabla() {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				System.out.print(tabla[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * @param color
	 */
	public boolean jugar(char color, int x, int y, int x1, int y1) {
		boolean pasa = false;
		int variable, reina, enemigo, Renemiga;
		if (color == 'R') {
			enemigo = negras;
			Renemiga = reinaN;
			variable = rojas;
			reina = reinaR;
		} else {
			Renemiga = reinaN;
			enemigo = rojas;
			variable = negras;
			reina = reinaN;
		}
		while (pasa == false) {
			
			if (tabla[x][y] == variable) {
				if (y1 > -1 && x1 > -1 && y1 < 8 && x1 < 8) {
					if (tabla[x1][y1] == 5) {
						if (variable == negras) {
							
							if (x1 == x - 1) {
								
								if (y1 == y - 1 || y1 == y + 1) {
									tabla[x][y] = 5;
									tabla[x1][y1] = negras;
									pasa = true;
								}
							}
							if (x1 == x - 2) {
								if (y1 == y + 2) {
									if (tabla[x - 1][y + 1] == enemigo || tabla[x - 1][y + 1] == Renemiga) {
										tabla[x - 1][y + 1] = 5;
										tabla[x][y] = 5;
										tabla[x1][y1] = negras;
										pasa = true;
									}
								} else if (y1 == y - 2) {
									if (tabla[x - 1][y - 1] == enemigo || tabla[x - 1][y - 1] == Renemiga) {
										tabla[x - 1][y - 1] = 5;
										tabla[x][y] = 5;
										tabla[x1][y1] = negras;
										pasa = true;
									}

								}
							}
							
						} else if (variable == rojas) {
							if (x1 == x + 1) {
								if (y1 == y - 1 || y1 == y + 1) {
									tabla[x][y] = 5;
									tabla[x1][y1] = rojas;
									pasa = true;
								}
							}
							if (x1 == x + 2) {
								if (y1 == y + 2) {
									if (tabla[x + 1][y + 1] == enemigo || tabla[x + 1][y + 1] == Renemiga) {
										tabla[x + 1][y + 1] = 5;
										tabla[x][y] = 5;
										tabla[x1][y1] = rojas;
										pasa = true;
									}
								} else if (y1 == y - 2) {
									if (tabla[x + 1][y - 1] == enemigo || tabla[x + 1][y - 1] == Renemiga) {
										tabla[x + 1][y - 1] = 5;
										tabla[x][y] = 5;
										tabla[x1][y1] = rojas;
										pasa = true;
									}

								}
							}
						}
					}

				} else {
					 //JOptionPane.showMessageDialog(null, "coordenadas no validas");
				}
			} 
			
			
			else if (tabla[x][y] == reina) {
				// movimiento reina
				int menorx = 0, menory = 0;

				if (x == x1 || y == y1) {
					 //JOptionPane.showMessageDialog(null, "movimiento invalido por movimiento en vertical/horizontal");
				} else if (tabla[x1][y1] == variable) {
					 //JOptionPane.showMessageDialog(null, "movimiento invalido por chocar con una ficha aliada");
				} else if (tabla[x1][y1] == 5) {
					for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabla[0].length; i++, j++) {
						if (i == x1 && j == y1) {

							if (x > x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 >= x1; j2--, i2--) {
									if (tabla[j2][i2] == variable || tabla[j2][i2] == reina) {

									} else {
										tabla[j2][i2] = 5;
										pasa = true;
									}

								}
							} else if (x < x1 && y < y1) {

								for (int j2 = x, i2 = y; i2 < y1 || j2 < x1; j2++, i2++) {
									tabla[j2][i2] = 5;
									pasa = true;
								}
							}

							tabla[x][y] = 5;
							tabla[x1][y1] = reina;
							pasa = true;
						}
					}
					for (int i = x, j = y; i >= 0; i--, j++) {
						menory = i;
						menorx = j;
					}
					for (int i = menory, j = menorx; i < tabla[0].length; i++, j--) {
						if (i == x1 && j == y1) {
							if (x < x1 && y > y1) {

								for (int j2 = x, i2 = y; i2 >= y1 || j2 < x1; j2++, i2--) {
									if (tabla[j2][i2] == variable || tabla[j2][i2] == reina) {

									} else {
										tabla[j2][i2] = 5;
										pasa = true;
									}
								}
							} else if (x > x1 && y < y1) {
								for (int j2 = x, i2 = y; i2 < y1 || j2 >= x1; j2--, i2++) {
									if (tabla[j2][i2] == variable || tabla[j2][i2] == reina) {

									} else {
										tabla[j2][i2] = 5;
										pasa = true;
									}
								}
							}
							tabla[x][y] = 5;
							tabla[x1][y1] = reina;
							pasa = true;
						}
					}
					if (pasa == false) {
						 //JOptionPane.showMessageDialog(null, "movimiento invalido");
					} else {
						//JOptionPane.showMessageDialog(null, "movimiento hecho");
					}
				} else {
					 //JOptionPane.showMessageDialog(null, "tienes que pasar por encima de la ficha");
				}
			} else {
				 //JOptionPane.showMessageDialog(null, "ficha inesistente");
				pasa = false;
			}
			if(pasa == false) {
				break;
			}
		}
		return pasa;
	}

	public boolean verificar(char color) {
		int contadorN = 0, contadorR = 0;
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[0].length; j++) {
				if (tabla[i][j] == rojas || tabla[i][j] == reinaR) {
					contadorR++;
				} else if (tabla[i][j] == negras || tabla[i][j] == reinaN) {
					contadorN++;
				}
			}
		}
		imprimir(contadorN, contadorR, color);
		if (contadorN == 0 && contadorR > 0) {
			JOptionPane.showMessageDialog(null, "ganan las rojas");
			return true;
		} else if (contadorR == 0 && contadorN > 0) {
			JOptionPane.showMessageDialog(null, "ganan las negras");
			return true;
		}
		return false;
	}

	public void posibilidad_reina() {
		for (int j = 0; j < tabla[0].length; j++) {
			if (tabla[0][j] == negras) {
				tabla[0][j] = reinaN;
			} else if (tabla[7][j] == rojas) {
				tabla[7][j] = reinaR;
			}
		}
	}
}
