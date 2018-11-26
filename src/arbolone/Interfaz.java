package arbolone;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Interfaz extends JFrame{
    private final PanelDibujo panel;
    
    public Interfaz(){
        this.setLayout(new BorderLayout());
        panel = new PanelDibujo();
        this.add(panel,BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel ctrls = new JPanel();
        this.add(ctrls,BorderLayout.SOUTH);
        ctrls.setLayout(new GridLayout(1,3));
        BotonRapidez masrapido = new BotonRapidez(-13,"MAS RAPIDO");
        BotonRapidez maslento = new BotonRapidez(13,"MAS LENTO");
        Pausa pausar = new Pausa("PAUSAR / REANUDAR");
        ctrls.add(masrapido);
        ctrls.add(pausar);
        ctrls.add(maslento);
        this.setSize(1370,735);
        this.setVisible(true);
    }
    
    private class Pausa extends JButton implements ActionListener{
        public Pausa(String n){
            super(n);
            this.addActionListener(this);
        }
        
        public void actionPerformed(ActionEvent e){
           panel.pausar();
       }
    }
    
    private class BotonRapidez extends JButton implements ActionListener{
       private int vel;
       public BotonRapidez(int i,String n){
           super(n);
           vel = i;
           this.addActionListener(this);
       }
       
       public void actionPerformed(ActionEvent e){
           panel.cambiarDelay(vel);
       }
    }
}
