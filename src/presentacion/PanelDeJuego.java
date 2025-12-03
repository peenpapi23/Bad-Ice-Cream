package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import dominio.Colision;
import dominio.Configuracion;
import dominio.Jugador;
import dominio.SuperObjeto;

public class PanelDeJuego extends JPanel implements Runnable{
	
	//Configuracion de Pantalla
	final int tamañoPixel = 16;
	final int escala = 3; 
	
	public final int originalTamañoPixel = tamañoPixel * escala; //Seria de 48 pixeles
	final int maximoColumna = 16;
	final int maximoFila = 12;
	
	public final int anchoPantalla = originalTamañoPixel * maximoColumna; //768 pixeles
	public final int largoPantalla = originalTamañoPixel * maximoFila; // 576 pixeles
	
	
	//Parametros Mundo
	public final int maximoMundoColumna = 18;
	public final int maximoMundoFila = 18; 
	public final int mundoAncho = originalTamañoPixel * maximoMundoColumna;
	public final int mundoLargo = maximoMundoFila * maximoMundoFila;
	
	private GestorSonido sonidoJuego = new GestorSonido();

	
	//FPS
	int FPS = 60;
	
	
	public Nivel1 nivel = new Nivel1(this);
	Teclado tecla = new Teclado();
	Thread hilos;
	public Colision colision = new Colision(this);
	
	
	public Jugador jugador = new Jugador(this, tecla);
	public SuperObjeto obj[] = new SuperObjeto[10];
	public Configuracion conf = new Configuracion(this);
	
	
	
	
	public PanelDeJuego() {
		this.setPreferredSize(new Dimension(anchoPantalla,largoPantalla));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(tecla);
		this.setFocusable(true);
		sonidoJuego.setArchivo(1); // Carga juego.wav
        sonidoJuego.play();
        sonidoJuego.loop();
	}
	
	public void setObjetos() {
		conf.conjuntoObjeto();
	}
	
	
	public void iniciarHilos() {
		hilos = new Thread(this);
		hilos.start();
	}

	@Override
	public void run() {
		
		double intervaloDeDibujo = 1000000000 / FPS;
		double delta = 0;
		long ultimaHora = System.nanoTime();
		long horaActual;
		
		while (hilos != null) {
			
			horaActual = System.nanoTime();
			delta += (horaActual - ultimaHora)/ intervaloDeDibujo;
			
			ultimaHora = horaActual;
			
			if(delta >= 1) {
				actualizar();
				repaint();
				delta--;
			}
		}
		
	}
	
	public void actualizar() {
		jugador.actualizar();
	}
	
	//Metodo que Sobreescribimos por Swing
	@Override 
	public void paintComponent(Graphics graficos) {
	    super.paintComponent(graficos);
	    
	    Graphics2D graficos2D = (Graphics2D) graficos;
	    //Nivel1
	    nivel.dibujo(graficos2D);
	    
	    //Objetos
	    for(int i = 0; i< obj.length;i++) {
	    	if (obj[i] != null) {
	    		obj[i].dibujo(graficos2D,this);
	    		
	    	}
	    }
	    
	    //Jugador
	    jugador.dibujo(graficos2D);

	    graficos2D.dispose();
	}

	
}
