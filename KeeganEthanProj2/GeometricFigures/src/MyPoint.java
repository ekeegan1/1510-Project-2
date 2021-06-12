/* This code is provided to the student for the project.
 * Student should NOT alter this code.
 * Code courtesy of Daniel Liang Introduction to Object Oriented
 * Programming 12th Edition.
 * 
 */

/*********************DO NOT ALTER THE CODE IN THIS CLASS*********************/
public class MyPoint 
	{
	  private double x;
	  private double y;

	  public MyPoint() 
	  {
	  }

	  public MyPoint(double x, double y) 
	  {
	    this.x = x;
	    this.y = y;
	  }

	  public double distance(MyPoint secondPoint) 
	  {
	    return distance(this, secondPoint);
	  }

	  public double distance(MyPoint p1, MyPoint p2) 
	  {
	    return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
	        * (p1.y - p2.y));
	  }

//	  public double distance(MyPoint p1, MyPoint p2) 
	//  {
	  //  return p2.distance(p1);
	  //}

	  public double getX() 
	  {
	    return x;
	  }

	  public double getY() 
	  {
	    return y;
	  }
	}