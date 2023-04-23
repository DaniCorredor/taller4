package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class PanelBarra extends JPanel implements ActionListener{
	private final static String FACIL = "FACIL";
	private final static String MEDIO = "MEDIO";
	private final static String DIFICIL= "DIFICIL";
	private JComboBox<String> box;
	private JLabel tamanio;
	private JLabel dificultad;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private JLabel labFacil;
	private JLabel labMedio;
	private JLabel labDificil;
	private int cantidad;
	private Ventana ventana;
	private int canDificultad;

	
	
	public PanelBarra(Ventana ventana) {
		this.ventana = ventana;
		box = new JComboBox<String>();
		canDificultad = 1;
		
		tamanio = new JLabel("Tamaño:  ");
		
		String tam3 = "3X3";
		box.addItem(tam3);
		String tam4 = "4X4";
		box.addItem(tam4);
		String tam5 = "5X5";
		box.addItem(tam5);
		String tam6 = "6X6"; 
		box.addItem(tam6);
		cantidad = 3;
		box.addActionListener(this);;
		box.setActionCommand("seleccion");
		dificultad = new JLabel("Dificultad:      ");
		
		labFacil = new JLabel("              Facil:");
		labMedio = new JLabel("              Medio:");
		labDificil = new JLabel("               Dificil:");
		
		facil = new JRadioButton();
		facil.addActionListener(this);
		facil.setActionCommand(FACIL);	
		facil.setForeground(Color.WHITE);
		
		medio = new JRadioButton();
		medio.addActionListener(this);
		medio.setActionCommand(MEDIO);	
		medio.setForeground(Color.WHITE);
		
		dificil = new JRadioButton();
		dificil.addActionListener(this);
		dificil.setActionCommand(DIFICIL);	
		dificil.setForeground(Color.WHITE);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(facil);
		grupo.add(medio);
		grupo.add(dificil);
			
		add(tamanio);
		add(box);
		add(dificultad);
		add(labFacil);
		add(facil);
		add(labMedio);
		add(medio);
		add(labDificil);
		add(dificil);
		
		
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String eleccion = e.getActionCommand();
		
		if (eleccion.equals("seleccion")) {
			String seleccion = (String)box.getSelectedItem();
			
			if ("4X4".equals(seleccion)){
				   cantidad = 4;
			   }
			if ("5X5".equals(seleccion)){
				   cantidad = 5;
			   }
			if ("6X6".equals(seleccion)){
				   cantidad = 6;
			   }
			if ("7X7".equals(seleccion)){
				   cantidad = 7;
			   }
			ventana.nuevoJuego(cantidad);
			
		}
		
		if (eleccion.equals(FACIL)) {
			canDificultad = 1;
		}
		else if (eleccion.equals(MEDIO)) {
			canDificultad = 2;
		}
		else if (eleccion.equals(DIFICIL)) {
			canDificultad = 3;
		}
	}
	
	public int getDificultad() {
		return canDificultad;
	}
}
