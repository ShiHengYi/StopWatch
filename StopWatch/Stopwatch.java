import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.time.Duration;
import java.time.Instant;
/**
 * class of Stop Watch
 * @author henryi
 *
 */
public class Stopwatch implements MoveableShape{
   private Dial big;
   private Dial small ;
   private int radius ;		
   private double bex ;
   private double bey ;
   private double sex ;
   private double sey ;	
   private double sec ;
   private double minute ;
   Instant now ;
   private boolean fz;
   private boolean rn;
   double tempx ;
   double tempy ;
   double x ;
   double y ;
	
   /**
	 * constructor of the class
	 * @param radius initialize instance variable
	 */
   public Stopwatch(int radius)
   {
      this.radius = radius;	
      big = new Dial(radius,true,Color.BLACK);
      small = new Dial(2*radius/5,false,Color.BLACK);		
      now = Instant.now();		
      sex = radius + 0.85*2.0*radius/5*Math.sin(minute*Math.PI/30);		
      sey = radius - 0.85*3.0*radius/5*Math.cos(minute*Math.PI/30);		
      bex = radius + 0.85*Math.sin(sec*Math.PI/30)*radius;		
      bey = radius - 0.85*Math.cos(sec*Math.PI/30)*radius;		
      sec = 0.0;
      minute = 0.0;		
      fz = false;
      rn = false;		
      tempx=radius + 0.80*Math.sin(sec*Math.PI/30)*radius;	
      tempy=radius - 0.80*Math.cos(sec*Math.PI/30)*radius;
      x = radius + 0.80*2.0*radius/5*Math.sin(minute*Math.PI/30);
      y = radius - 0.80*3.0*radius/5*Math.cos(minute*Math.PI/30);
   }
	
	/**
	 * method to draw the watch
	 */
   public void draw(Graphics2D g2)
   {
      big.paintIcon(null,g2,0,0);
      small.paintIcon(null,g2,3*radius/5,2*radius/5);
      Line2D.Double big = new Line2D.Double(radius , radius, bex, bey);
      Line2D.Double small = new Line2D.Double(radius ,4*radius/5, sex, sey);
      g2.setColor(Color.RED);
      g2.draw(big);
      ArrowHead arrow = new ArrowHead();
      arrow.draw(g2, new Point2D.Double(tempx,tempy), new Point2D.Double(bex,bey));
      g2.setColor(Color.MAGENTA);
      ArrowHead arrow1 = new ArrowHead();
      arrow1.draw(g2,new Point2D.Double(x,y), new Point2D.Double(sex,sey));
      g2.draw(small);	
   }
	/**
	 * method to reset status
	 */
   public void reset() 
   {
      big = new Dial(radius,true,Color.BLACK);
      small = new Dial(2*radius/5,false,Color.BLACK);
      now = Instant.now();
      sex = radius + 0.85*2.0*radius/5*Math.sin(minute*Math.PI/30);
      sey = radius - 0.85*3.0*radius/5*Math.cos(minute*Math.PI/30);
      bex = radius + 0.85*Math.sin(sec*Math.PI/30)*radius;
      bey = radius - 0.85*Math.cos(sec*Math.PI/30)*radius;
      sec = 0.0;
      minute = 0.0;
      
      fz = false;
      rn = false;
      
      tempx=radius + 0.80*Math.sin(sec*Math.PI/30)*radius;
      tempy=radius - 0.80*Math.cos(sec*Math.PI/30)*radius;
      x = radius + 0.80*2.0*radius/5*Math.sin(minute*Math.PI/30);
      y = radius - 0.80*3.0*radius/5*Math.cos(minute*Math.PI/30);
   }

   /**
    * method to make second button function normally
    */
   public void secondButtonPressed() 
   {
      if(!rn)
      {
         reset();
         reset();
         return;
      }
      else if(rn && !fz)
      {
         fz = true;		
      }
      else
      {
         fz = false;
      }		
   }
   /**
    * method to make button function
    */
	public void topButtonPressed() 
	{
		if(rn)
		{
			rn = false;
		}
		else
		{
			rn = true;
		}
	}

	/**
	 * method to make tick move normally
	 */
	public void move() 
	{
		if (rn && fz)
		{
			sec += 0.1;
			minute += 0.1/60;
		}
         else if(rn)
         {
            sec += 0.1;
		    bex = radius + 0.85*Math.sin(sec*Math.PI/30)*radius;
		    bey = radius - 0.85*Math.cos(sec*Math.PI/30)*radius;		
		    minute += 0.1/60;
		    sex = radius + 0.85*2.0*radius/5*Math.sin(minute*Math.PI/30);
		    sey = radius - 0.85*3.0*radius/5*Math.cos(minute*Math.PI/30);
		    x = radius + 0.80*2.0*radius/5*Math.sin(minute*Math.PI/30);
		    y = radius - 0.80*3.0*radius/5*Math.cos(minute*Math.PI/30);
		    tempx=radius + 0.80*Math.sin(sec*Math.PI/30)*radius;
		    tempy=radius - 0.80*Math.cos(sec*Math.PI/30)*radius;
         }
	}
}
