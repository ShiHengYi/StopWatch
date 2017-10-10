	import java.awt.*;
	import java.util.*;
	import javax.swing.*;
	
	/**
	An icon that contains a moveable shape.
	copied from book code
	*/
	public class ShapeIcon implements Icon
	{
		/**
		 * constructor of the class
		 * @param shape initialize variable 
		 * @param width initialize variable 
		 * @param height initialize variable 
		 */
		public ShapeIcon(MoveableShape shape,
			int width, int height)
		{
		this.shape = shape;
		this.width = width;
		this.height = height;
		}
	/**
	 * method to get width
	 * @return the width
	 */
	public int getIconWidth()
	{
		return width;
	}
	
	/**
	 * method to get height
	 * @return the height
	 */
	public int getIconHeight()
	{
		return height;
	}
	
	/**
	 * method to paint Icon
	 * @param c component of the icon
	 * @param g  2d graphic
	 * @param x  x position to put icon
	 * @param y y position to put icon
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}
	private int width;
	private int height;
	private MoveableShape shape;
}