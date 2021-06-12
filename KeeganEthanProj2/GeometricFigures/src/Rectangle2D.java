public class Rectangle2D extends GeometricObject
{
	private double x, y;
	private double height, width;
	
	//There are 15 methods in this class.
	
	//There are 2 constructors.
	public Rectangle2D()
	{
		x = 0;
		y = 0;
		width = 1;
		height = 1;
	}
	
	public Rectangle2D(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	//There is 1 getX method
	public double getX()
	{
		return x;
	}
	
	//There is 1 setX method
	public void setX(double x)
	{
		this.x = x;
	}
	
	//There is 1 getY method
	public double getY()
	{
		return y;
	}
	
	//There is 1 setY method
	public void setY(double y)
	{
		this.y = y;
	}
	
	//There is 1 getWidth method
	public double getWidth()
	{
		return width;
	}
	
	//There is 1 setWidth method
	public void setWidth(double width)
	{
		this.width = width;
	}
	
	//There is 1 getHeight method
	public double getHeight()
	{
		return height;
	}
	
	//There is 1 setHeight method
	public void setHeight(double height)
	{
		this.height = height;
	}
	
	
	//There is 1 getPerimeter method
	public double getPerimeter()
	{
		return 2 * (height + width);
	}
	
	//There is 1 getArea method
	public double getArea()
	{
		return height * width;
	}
	
	
	//There is 1 contains method for points
	//this method not only finds if a point is in the the class' rectangle, but it also helps the next two methods find their results
	public boolean contains(double x, double y)
	{
		return Math.abs(this.x - x) <= (width / 2) &&	// if the change in x is less than half the width
			   Math.abs(this.y - y) <= (height / 2);	// and the change in y is less than half the height
	}													// then the point is contained in the rectangle
	
	
	//There is 1 contains method for rectangles (given)
	//if all of the corners in Rectangle r are in the class' rectangle, then it is contained
	public boolean contains(Rectangle2D r) 
	{    
	    return contains(r.x - r.width / 2, r.y + r.height / 2) &&	//this calls the contains(x,y) method in
	    	   contains(r.x - r.width / 2, r.y - r.height / 2) &&	//order to check the corners
	    	   contains(r.x + r.width / 2, r.y + r.height / 2) &&
	    	   contains(r.x + r.width / 2, r.y - r.height / 2);
	} 
	
	
	//There is 1 overlaps method.
	//this method is inspired from the previous given method
	//if any of the corners in Rectangle r are in the class' rectangle, then it overlaps
	public boolean overlaps(Rectangle2D r)
	{
		return contains(r) || r.contains(this) ||
			   contains(r.x - r.width / 2, r.y + r.height / 2) ||	//this calls the contains(x,y) method in
			   contains(r.x - r.width / 2, r.y - r.height / 2) ||	//order to check the corners
			   contains(r.x + r.width / 2, r.y + r.height / 2) ||
			   contains(r.x + r.width / 2, r.y - r.height / 2);
	}
	  	  
}