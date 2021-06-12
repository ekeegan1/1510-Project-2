/* Note from Dr. Hobbs' Demos:
 * 
 * Here is a rough UML diagram
 * 
 * 		Triangle2D
 * ------------------------
 * 	methods:
 * 		+Triangle2D () 
 * 		+Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3)
 * 		+Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3)
 * 		+getP1(), getP2(), getP3()
 * 		+setP1(MyPoint p1), setP2(MyPoint p2), setP3(MyPoint p3)
 * 		+getPerimeter()
 * 		+getArea()
 * 		+contains(double x, double y)
 * 		+contains(Triangle2D, t)
 * 		+overlaps(Triangle2D, t)
 */

import java.awt.geom.Line2D;

class Triangle2D extends GeometricObject
{
  private MyPoint p1, p2, p3; 

   	//There are 14 total methods in this class.
  
	//There are 3 constructor methods for Triangles
	public Triangle2D()
	{
		p1 = new MyPoint(0,0);
		p2 = new MyPoint(1,1);
		p3 = new MyPoint(2,5);
	}
	
	public Triangle2D(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		this.p1 = new MyPoint(x1,y1);
		this.p2 = new MyPoint(x2,y2);
		this.p3 = new MyPoint(x3,y3);
	}
	
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	
	//There is 1 getP1 method
	public MyPoint getP1()
	{
		return p1;
	}
	
	//There is 1 setP1 method
	public void setP1(MyPoint p1)
	{
		this.p1 = p1;
	}
	
	//There is 1 getP2 method
	public MyPoint getP2()
	{
		return p2;
	}
	
	//There is 1 setP2 method
	public void setP2(MyPoint p2)
	{
		this.p2 = p2;
	}
	
	//There is 1 getP3 method
	public MyPoint getP3()
	{
		return p3;
	}
	
	//There is 1 setP3 method
	public void setP3(MyPoint p3)
	{
		this.p3 = p3;
	}
	
	
	//There is 1 getPerimeter method
	public double getPerimeter()
	{
		return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
	}
	
	
	//There is 1 getArea method
	//this method is give in Dr. Hobbs' demos
	public double getArea()
	{
		double side1 = p1.distance(p2);
		double side2 = p1.distance(p3);
		double side3 = p2.distance(p3);
				
		double s = (side1 + side2 + side3)/2;							//This calculation is from problem
		return Math.sqrt(s*(s-side1) * (s - side2) * (s - side3));		//2.19
	}
	
	
	//There is 1 contains method for points. 
	//this method is given in Dr. Hobbs' demos
	public boolean contains(double x, double y)
	{		
		//firstly, this splits the triangle into 3 parts all connecting by the point
		//secondly, it computes the area of them individually
		double area1 = new Triangle2D(p1.getX(), p1.getY(), p2.getX(), p2.getY(), x, y).getArea();
		double area2 = new Triangle2D(p1.getX(), p1.getY(), p3.getX(), p3.getY(), x, y).getArea();
		double area3 = new Triangle2D(p2.getX(), p2.getY(), p3.getX(), p3.getY(), x, y).getArea();
		
		//finally, if all of their areas equal the area of the class' triangle, then the point is contained
		return (Math.abs(area1 + area2 + area3 - getArea()) < 0.0000001);
	}
	
	
	//There is 1 contains method for triangles.
	public boolean contains(Triangle2D t)
	{		
		//this checks to see if all of the points of Triangle t are contained in the class' triangle
		return contains(t.p1.getX(), t.p1.getY()) && 
			   contains(t.p2.getX(), t.p2.getY()) &&
			   contains(t.p3.getX(), t.p3.getY());		
	}
	
	
	//There is 1 method for overlaps.
	public boolean overlaps(Triangle2D t)
	{		
		//the following lines are inspired by Dr. Hobbs' demos
		//These lines correspond with the class' object
		Line2D side1 = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		Line2D side2 = new Line2D.Double(p1.getX(), p1.getY(), p3.getX(), p3.getY());
		Line2D side3 = new Line2D.Double(p2.getX(), p2.getY(), p3.getX(), p3.getY());
		
		//These lines correspond with the potentially overlapping triangle
		Line2D side4 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p2.getX(), t.p2.getY());
		Line2D side5 = new Line2D.Double(t.p1.getX(), t.p1.getY(), t.p3.getX(), t.p3.getY());
		Line2D side6 = new Line2D.Double(t.p2.getX(), t.p2.getY(), t.p3.getX(), t.p3.getY());
		
		//this checks to see if any of the lines on the class' triangle intersect with the lines of the triangle in question
		return contains(t) || t.contains(this) ||
			  (side1.intersectsLine(side4) || side1.intersectsLine(side5) || side1.intersectsLine(side6)) ||
			  (side2.intersectsLine(side4) || side2.intersectsLine(side5) || side2.intersectsLine(side6)) ||
			  (side3.intersectsLine(side4) || side3.intersectsLine(side5) || side3.intersectsLine(side6));
	}
   
}