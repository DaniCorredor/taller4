package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements MouseListener{
	
	private boolean[][] matriz;
	private int lonRectangulo;
	private Ventana ventana;
	
	public PanelJuego(boolean[][] matriz, Ventana ventana) {
		this.ventana = ventana;
		setPreferredSize(new Dimension(650,650));	
		this.matriz = matriz;
	}
	
	
	public void paint(Graphics g) {
		
		
		int maximo = matriz.length;
		lonRectangulo = (int) 650/maximo;
		
		super.paint(g); 
		Graphics2D g2d = (Graphics2D) g; 
		
		for (int i = 0; i < maximo; i++) {		
			for (int j = 0; j < maximo; j++){	
				
				if ( matriz[i][j] == false) {
					RoundRectangle2D.Double roundRectangulo = new RoundRectangle2D.Double(j*lonRectangulo,i*lonRectangulo,lonRectangulo,lonRectangulo,10,10);
					g2d.setColor(Color.YELLOW);
					g2d.fill(roundRectangulo);
					g2d.setColor(Color.BLACK);
					g2d.draw(roundRectangulo);
					
				}
				else if (matriz[i][j] == true) {
					RoundRectangle2D.Double roundRectangulo = new RoundRectangle2D.Double(j*lonRectangulo,i*lonRectangulo,lonRectangulo,lonRectangulo,10,10);
					g2d.setColor(Color.WHITE);
					g2d.fill(roundRectangulo);
					g2d.setColor(Color.BLACK);
					g2d.draw(roundRectangulo);
				}
			}
				
		}
	}
	
	
	
	
	
	public void setMatriz(boolean[][] newMatriz) {
		matriz = newMatriz;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e)
	{
	int click_x = e.getX();
	int click_y = e.getY();
	int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
	ventana.juego(casilla[0], casilla[1]);
	if (ventana.completo()) {
	
	}

	}

	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = matriz.length;
	int altoPanelTablero = 650;
	int anchoPanelTablero = 650;
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
