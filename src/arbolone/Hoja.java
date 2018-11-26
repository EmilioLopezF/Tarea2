package arbolone;

import java.awt.*;


public class Hoja {
    private int posX;
    private int posY;
    private int ancho;
    private int largo;
    private final int anchoMax;
    private final int largoMax;
    private float aux1;
    private float aux2;
    public static final Color verdehoja = new Color(0,102,0);

    
    public Hoja(int x,int y,double grados){
        posX=x;
        posY=y;
        ancho=0;
        largo=0;
        largoMax=17;
        anchoMax=13;
    }
    
    public void paint(Graphics g){
        g.setColor(verdehoja);
        g.fillOval(posX, posY, ancho, largo);
    }
    
    public void setXY(int x, int y){
        posX=x;
        posY=y;
    }
    
    public void crecer(){
        if(ancho <= anchoMax){
            aux1 = aux1+0.9f;
            ancho = (int)aux1;
        }
        if(largo <= largoMax){
            aux2 = aux2+0.7f;
            largo = (int)aux2;
        }
    }
}
