import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.Icon;

/**
 * class of Dail
 * @author hengyishi
 *
 */
public class Dial implements Icon
{

   private int rad;
   private boolean rd;
   private Color me;
   /**
    * constructor of the class
    * @param i initialize rad
    * @param b initialize rd
    * @param color initialize color
    */
   public Dial(int i, boolean b, Color color) 
   {
      rad = i;
      rd = b;
      me = color;
   }

   /**
    * method to paint Icon
    * @param c component
    * @param g praphics
    * @param x the width
    * @param y the hight
    */
   public void paintIcon(Component c, Graphics g, int x, int y) 
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(me);
      if(rd)
      {
         for(int i = 0; i < 300; i++)
         {
            if(i % 5 != 0)
            {
               Line2D.Double line = new Line2D.Double(x+rad + 0.95*rad*Math.sin(i*Math.PI/150),y+rad - 0.95*rad*Math.cos(i*Math.PI/150),x+rad+rad*Math.sin(i*Math.PI/150),y+ rad - rad*Math.cos(i*Math.PI/150));
               g2.draw(line);
				}
			}
      }
      for(int i = 0; i < 60; i++)
      {
         if(i % 25!= 0)
         {
            Line2D.Double line = new Line2D.Double(x+rad + 0.9*rad*Math.sin(i*Math.PI/30),y+rad - 0.9*rad*Math.cos(i*Math.PI/30),x+rad+rad*Math.sin(i*Math.PI/30), y+rad - rad*Math.cos(i*Math.PI/30));
            g2.draw(line);
         }
      }
      for(int i = 0; i < 12; i++)
      {
         Line2D.Double line = new Line2D.Double(x+rad + 0.85*rad*Math.sin(i*Math.PI/6),y+rad - 0.85*rad*Math.cos(i*Math.PI/6),x+rad+rad*Math.sin(i*Math.PI/6),y+ rad - rad*Math.cos(i*Math.PI/6));
         g2.draw(line);
		}
      drawStr(g2,x,y);
   }
	
   /**
    * helper method for paint icon
    * @param g2 graphic variable
    */
   private void drawStr(Graphics2D g2,int x, int y)
   {
      for(int i = 0; i < 12; i++)
      {
         String text = 5*i + "";
         Font font = new Font("Serif",Font.BOLD,rad/8);
         FontRenderContext context = g2.getFontRenderContext();
         Rectangle2D bounds = font.getStringBounds(text, context);
		
         double ascent = -bounds.getY();
         double descent = bounds.getHeight() - ascent;
         double extent = bounds.getWidth();
         g2.setFont(font);
         int a = (int) (x+rad + 0.8*(rad)*Math.sin(i*Math.PI/6)-extent/2);
         int b = (int) (y+rad - 0.8*(rad)*Math.cos(i*Math.PI/6)+extent/3);
         g2.drawString(text,a ,b);
      }
   }

   /**
    * method to get width
    * @return the width
    */
   public int getIconWidth() 
   {
      return 2*rad;
   }

   /**
    * method to get height
    * @return the hight
    */
   public int getIconHeight()
   {
      return 2*rad;
   }

}
