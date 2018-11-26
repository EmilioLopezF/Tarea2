package arbolone;

import java.awt.*;
import java.util.ArrayList;


public class Rama {
    private final ArrayList arreglo;
    private final ArrayList ramas;
    private Sol sol;
    private final int n;    
    private float largo;
    private float ancho;
    private final int largomaximo;
    private final int anchomaximo;
    private int edad;
    private final float vel;
    private Polygon p;
    private int x;
    private int y;
    private final int gen;
    private final double delta;
    private int division;
    private boolean completa;
    private int i,j;
    public static final Color brownrama = new Color(102,51,0);
    
    public Rama(int t,int x,int y,int g,double alfa){
        arreglo = new ArrayList();
        ramas = new ArrayList();
        edad = 0;
        this.x = x;
        this.y = y;
        gen = g+1;
        delta = alfa;
        if(gen == 1) division = 2;
        if(gen == 2) division = 3;
        if(gen == 3) division = 4;
        if(gen == 4) division = 5;                              
        largomaximo = 980/(int)(Math.pow(4,(double)gen-1));
        anchomaximo = 70/(int)(Math.pow(3,(double)gen-1));
        largo = 0.0f;
        ancho = 0.0f;
        vel = 1.0f;
        completa=false;
        i = 0;
        j = 0;
        n = 8 -(2*(gen-1));
        
        for(int i=0 ; i<n; i=i+1){
            Rama aux;
            if(i%2 == 0){
                aux = new Rama(edad,0,0,gen,(double)delta-2.5/division);
            }
            else{
                aux = new Rama(edad,0,0,gen,(double)delta+2.5/division);
            }
            ramas.add(aux);
        }
    }
    
    public void paint (Graphics g){
        p=new Polygon();
        float rama1 = (float)x;
        float rama2 = (float)y;
        float rama3 = (float)(x+Math.cos(delta)*largo);
        float rama4 = (float)(y-Math.sin(delta)*largo);
        float rama5 = (float)(x+Math.cos(delta-1.5708)*(ancho-1));
        float rama6 = (float)(y-Math.sin(delta-1.5708)*(ancho-2));
        float rama7 = (float)(rama3+rama5-x);
        float rama8 = (float)(rama4+rama6-y);
        p.addPoint((int)rama1,(int)rama2);
        p.addPoint((int)rama3,(int)rama4);
        p.addPoint((int)rama7,(int)rama8);
        p.addPoint((int)rama5,(int)rama6);
        g.fillPolygon(p);
        if(largo>=(float)(largomaximo*(((2.0*(float)n-4.0))/(4.0*(float)n))) && (gen<=1)){
            float pos1 = (float)(x+((largo*((2.0*(float)n-4.0)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n-4.0)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(0-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)(pos1+ancho*Math.cos(delta)), (int)(pos2-ancho*Math.sin(delta)));
            aux.paint(g);
        }
        
        if(largo>=(float)(largomaximo*((2.0*(float)n-2.0)/(4.0*(float)n))) && (gen<=1)){
            float pos1 = (float)(x+((largo*((2.0*(float)n-2.0)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n-2.0)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(1-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)pos1, (int)pos2);
            aux.paint(g);
        }
        
        if(largo>=(float)(largomaximo*((2.0*(float)n)/(4.0*(float)n))) && (gen<=2)){
            float pos1 = (float)(x+((largo*((2.0*(float)n)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(2-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)(pos1+ancho*Math.cos(delta)), (int)(pos2-ancho*Math.sin(delta)));
            aux.paint(g);
        }
        
        if(largo>=(float)(largomaximo*((2.0*(float)n+2.0)/(4.0*(float)n))) && (gen<=2)){
            float pos1 = (float)(x+((largo*((2.0*(float)n+2.0)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n+2.0)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(3-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)pos1, (int)pos2);
            aux.paint(g);
        }
        
        if(largo>=(float)(largomaximo*((2.0*(float)n+4.0)/(4.0*(float)n))) && (gen<=2)){
            float pos1 = (float)(x+((largo*((2.0*(float)n+4.0)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n+4.0)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(4-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)(pos1+ancho*Math.cos(delta)), (int)(pos2-ancho*Math.sin(delta)));
            aux.paint(g);
        }
        
        if(largo>=(float)(largomaximo*((2.0*(float)n+6.0)/(4.0*(float)n))) && (gen<=2)){
            float pos1 = (float)(x+((largo*((2.0*(float)n+6.0)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n+6.0)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(5-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)pos1, (int)pos2);
            aux.paint(g);
        }
        
        if(largo>=(float)(largomaximo*((2.0*(float)n+8.0)/(4.0*(float)n))) && (gen<=3)){
            float pos1 = (float)(x+((largo*((2.0*(float)n+8.0)/(4.0*(float)n)))*Math.cos(delta)));
            float pos2 = (float)(y-((largo*((2.0*(float)n+8.0)/(4.0*(float)n)))*Math.sin(delta)));
            
            Rama aux = (Rama) ramas.get(6-2*(gen-1));
            g.setColor(brownrama);
            aux.crecer((int)(pos1+ancho*Math.cos(delta)), (int)(pos2-ancho*Math.sin(delta)));
            aux.paint(g);
        }
        
        if(completa==false && largo>=largomaximo && gen == 4){
            completa=true;
        }
        if(completa){
            sol = new Sol();
            sol.pintar(g);
            if(i<10 && edad>=100 && edad%100==0){   
                Hoja aux2; 
                aux2 = new Hoja((int)(x+((((i+1)*largo)/(100))*Math.cos(delta))),(int)(y-((((i+1)*largo)/(100))*Math.sin(delta))),delta);
                arreglo.add(aux2);
                i++;
            }
            edad++;
            for(int j=0;j<i;j=j+1){
                Hoja aux2=(Hoja)arreglo.get(j);
                if(j%2==0){
                    aux2.setXY((int)(x+(((((j+1)*largo)/(10))-5)*Math.cos(delta))+ancho*Math.cos(delta)+6),(int)(y-(((((j+1)*largo)/(10))+5)*Math.sin(delta))-ancho*Math.sin(delta)-6));
                }
                else{
                    aux2.setXY((int)(x+(((((j+1)*largo)/(10))-5)*Math.cos(delta))+Math.cos(delta)-6),(int)(y-(((((j+1)*largo)/(10))+5)*Math.sin(delta))-ancho*Math.sin(delta)+6));
                }
                aux2.crecer();
                aux2.paint(g);
            }
            
        }
    }
    
    public void crecer(int x,int y){
        if(largo<=largomaximo){
            largo+=vel;
            ancho+=vel/20;
        }
        this.x=x;
        this.y=y;
    }
    
}
