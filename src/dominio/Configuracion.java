package dominio;

import presentacion.PanelDeJuego;

public class Configuracion {
	PanelDeJuego panel;
	public Configuracion (PanelDeJuego panel) {
		this.panel = panel;
	}
	
	public void conjuntoObjeto() {
		panel.obj[0] = new OBJ_Banana();
		panel.obj[0].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[0].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[1] = new OBJ_Banana();
		panel.obj[1].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[1].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[2] = new OBJ_Banana();
		panel.obj[2].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[2].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[3] = new OBJ_Banana();
		panel.obj[3].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[3].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[4] = new OBJ_Banana();
		panel.obj[4].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[4].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[5] = new OBJ_Banana();
		panel.obj[5].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[5].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[6] = new OBJ_Banana();
		panel.obj[6].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[6].mundoY = 1 * panel.originalTamañoPixel; 
		
		panel.obj[0] = new OBJ_Banana();
		panel.obj[0].mundoX = 1 * panel.originalTamañoPixel;
		panel.obj[0].mundoY = 1 * panel.originalTamañoPixel; 
		
		
	}
}
