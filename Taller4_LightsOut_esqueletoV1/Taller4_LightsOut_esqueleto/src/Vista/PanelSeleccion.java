	package Vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSeleccion extends JPanel implements ActionListener{
	
	private static final String NUEVO = "NUEVO";
	private static final String REINICIAR = "REINICIAR";
	private static final String TOP10 = "TOP-10";
	private static final String CAMBIARJUGADOR = "CAMBIAR JUGADOR";

	
	private JButton botNuevo;
	private JButton botReiniciar;
	private JButton botTop;
	private JButton botCamJugador;
	private Ventana ventana;

	
	public PanelSeleccion(Ventana ventana) {
		
		this.ventana = ventana;
		
		setPreferredSize(new Dimension(300,600));	
		
		botNuevo = new JButton("NUEVO");
		botNuevo.setBounds(750, 200, 200, 50);
		botNuevo.addActionListener(this);
		botNuevo.setActionCommand(NUEVO);
		
		botReiniciar = new JButton("REINICIAR");
		botReiniciar.setBounds(750, 300, 200, 50);
		botReiniciar.addActionListener(this);
		botReiniciar.setActionCommand(REINICIAR);
		
		botTop = new JButton("TOP-10");
		botTop.setBounds(750, 400, 200, 50);
		botTop.addActionListener(this);
		botTop.setActionCommand(TOP10);
		
		botCamJugador = new JButton("CAMBIAR JUGADOR");
		botCamJugador.setBounds(750, 500, 200, 50);
		botCamJugador.addActionListener(this);
		botCamJugador.setActionCommand(CAMBIARJUGADOR);
		
		
		add(botNuevo);
		add(botReiniciar);
		add(botTop);
		add(botCamJugador);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String eleccion = e.getActionCommand();
		
		if (eleccion.equals(NUEVO)) {
			int cantidad = ventana.getCantidad();
			ventana.nuevoJuego(cantidad);
		}
		else if (eleccion.equals(REINICIAR)) {
			ventana.reiniciar();
		}
		else if (eleccion.equals(TOP10)) {
			
			
		}
		else if (eleccion.equals(CAMBIARJUGADOR)) {
			
		}
		
	}

}
