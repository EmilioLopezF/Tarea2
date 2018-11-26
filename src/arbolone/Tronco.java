package arbolone;

import java.awt.Graphics;

public class Tronco {
    private final int edad;
    private Rama tronco;
    private final int x;
    private final int y;
    private boolean solo;
    
    public Tronco(int x,int y){
        edad = 0;
        this.x = x;
        this.y = y;
        solo = true;
    }   
    
    public void naceRama(Graphics g){
        if(edad>=0){
            if(solo){
                tronco = new Rama(edad-100 , x, y, 0, 1.56);
                solo = false;
            }
            else{
                tronco.crecer(x,y);
            }
            tronco.paint(g);
        }
    }
}
