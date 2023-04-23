package Vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class PanelDatos extends JPanel{
	
	private Tablero tablero;
	private JLabel lbJugadas;
	private JLabel jugadas;
	
	
	
	
	public PanelDatos(Tablero tabla) {
		
		tablero = tabla;
		
		lbJugadas = new JLabel("Jugadas:   ");
		jugadas = new JLabel(Integer. toString(tablero.darJugadas()));
		add(lbJugadas);
		add(jugadas);
		
	}
	
	
}
