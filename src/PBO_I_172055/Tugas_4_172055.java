package PBO_I_172055;

import java.applet.Applet;
import java.awt.*;

public class Tugas_4_172055 extends Applet 
{
    public void paint(Graphics x) 
    {  
       //kepala 
       x.setColor(Color.black);
       x.fillOval(10,10,150,150);
       x.setColor(Color.yellow);
       x.fillOval(15,15,140,140); 
       
       //alis
       x.setColor(Color.black);
       x.fillOval(35,50,30,20);
       x.setColor(Color.yellow);
       x.fillOval(35,55,30,20);
       
       x.setColor(Color.black);
       x.fillOval(105,50,30,20);
       x.setColor(Color.yellow);
       x.fillOval(105,55,30,20);
       
       //mata
       x.setColor(Color.black);
       x.fillOval(40,60,20,20);
       x.setColor(Color.black);
       x.fillOval(110,60,20,20);
       
       //mulut
       x.setColor(Color.black);
       x.fillArc(35, 40, 100, 100, 180, 180);
       x.setColor(Color.yellow);
       x.fillArc(32, 40, 106, 90, 180, 180);
    }
    public void start()
    {
        repaint();
    }
}
