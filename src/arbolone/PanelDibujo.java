package arbolone;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class PanelDibujo extends JPanel implements ActionListener{
    private final Tronco tronco;
    private final Timer t;
    private Image offImage;
    private Graphics offGraphics;
    private Dimension offDimension;
    private Boolean pausa;
    public static final Color browntronco = new Color(51,0,0);
    public static final Color cielo = new Color(51,153,255);

    
    public PanelDibujo(){
        tronco = new Tronco(420,700);
        this.setBackground(cielo);
        t = new Timer(49,null);
        t.addActionListener(this);
        t.start();
        pausa=false;
    }
    
    @Override
    public void paint (Graphics g){
        update(g);
    }
    
    @Override
    public void update(Graphics g){
        Dimension d=getSize();
        if(offGraphics == null || d.width != offDimension.width || d.height != offDimension.height){
            offDimension=d;
            offImage=createImage(d.width,d.height);
            offGraphics=offImage.getGraphics();
        }
        
        offGraphics.setColor(getBackground());
        offGraphics.fillRect(0, 0, d.width , d.height);
        offGraphics.setColor(browntronco);
        
        tronco.naceRama(offGraphics);
        
        g.drawImage(offImage,0,0,this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ea){
        super.repaint();
    }
    public void pausar(){
        if(pausa){
            pausa=false;
            t.start();
        }
        else{
            pausa=true;
            t.stop();
        }
    }
    
    public void cambiarDelay(int i){    
        int a = t.getDelay();
        if(i<0) a = a/2;
        if(i>0) a = a*2;
        if(a<=5) a = 13;
        if(a>=100) a = 130;
        t.setDelay(a);
    }
    
}
