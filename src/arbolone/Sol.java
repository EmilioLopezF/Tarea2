
package arbolone;

import java.awt.*;

public class Sol {
    private final int x = 1000;
    private final int y = 100;
    private final int radio = 50;
    public static final Color amarillo = new Color(255,252,152);
    
    public void pintar(Graphics g){
        g.setColor(amarillo);
        g.fillOval(x, y, radio, radio);
    }
}
