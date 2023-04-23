package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class Ventana extends JFrame{
	private Top10 top;
	private Tablero tablero;
	private PanelSeleccion selecciones;
	private PanelBarra barra;
	private PanelDatos datos;
	private PanelJuego juego;

	
	public Ventana() {
		
		setSize(new Dimension(1000,750));
		
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
			salvarTop10();
			}
		});
		
		barra = new PanelBarra(this);
		int tamanio = barra.getCantidad();
		selecciones = new PanelSeleccion(this);
		top = new Top10();
		tablero = new Tablero(tamanio);
		int dificultad = barra.getDificultad();
		tablero.desordenar(dificultad);
		boolean[][] matriz = tablero.darTablero();
		juego = new PanelJuego(matriz, this);
		datos = new PanelDatos(tablero);
		
		setLayout(new BorderLayout());
		add(selecciones);
		
		add(barra, BorderLayout.NORTH);
		add(datos, BorderLayout.SOUTH);
		add(juego, BorderLayout.WEST);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
				
	}
	
	public void salvarTop10() {
		
	}
	
	public boolean completo() {
		return tablero.tableroIluminado();
		
	}
	
	public void nuevoJuego(int cantidad) {
		remove(juego);
		int dificultad = barra.getDificultad();
		tablero.desordenar(dificultad);
		boolean[][] matriz = tablero.darTablero();
		PanelJuego newJuego = new PanelJuego(matriz, this);
		this.juego = newJuego;
		add(juego);
		
	}
	public void reiniciar() {
		tablero.reiniciar();
		boolean[][] matriz = tablero.darTablero();
		juego.setMatriz(matriz);
		add(juego);
	}
	
	public int getCantidad() {
		return barra.getCantidad();
	}
	
	public void juego(int fila, int columna) {
		
		tablero.jugar(fila, columna);
		boolean[][] matriz = tablero.darTablero();
		juego.setMatriz(matriz);
		add(juego);
	}
	
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
	}
	

}
